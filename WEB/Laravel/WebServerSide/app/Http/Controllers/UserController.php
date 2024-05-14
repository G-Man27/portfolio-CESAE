<?php

namespace App\Http\Controllers;

use App\Models\Task;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Storage;

class UserController extends Controller
{
    public function allUsers() {

        $allUsers= $this->getUsers();
        // $allUsersInfo= $this->getUsersInfo();

        /*//sem ternário
        $search=null;
        if (request()->query('search')) {
            $search=request()->query('search');
        }else{
            $search=null;
        } */

        //com ternário
        $search=request()->query('search')?request()->query('search'):null;

        if ($search) {
            $allUsers=User::where('name', 'LIKE', "%{$search}%")->get();
        } else {
            $allUsers=User::get();
        }


    return view('users.all_users',compact('allUsers'/*,'allUsersInfo'*/,));
    }

    public function viewUser_name(?string $name = null) {
        if ($name==null){
            $users=null;
            return view('users.user_view',compact('users'));
        }else{
            $users=User::where('name','like',"%{$name}%")->get();
            $use=null;
            return view('users.user_view',compact('users','use'));
        }
    }

    public function viewUser($id){
        $users=User::where('id',$id)->get();
        $use=true;
        return view('users.user_view',compact('users','use'));
    }

    public function deleteUser($id){
        Task::where('user_id',$id)->update(['user_id'=>null]);
        User::where('id',$id)->delete();
        return redirect()->back();
    }



    /*     protected function getUsers(){
        $users=[
            [1,'Ana','912226847'],
            [2,'Luís','915156414'],
            [3,'Miguel','915551782'],
            [4,'Jessica','351+ 956915397'],
        ];

        return $users;
    }
 */
    protected function getUsers(){
/*         $users=[
            ['id'=>1, 'name'=>'Ana', 'phone'=>'912226847'],
            ['id'=>2, 'name'=>'Luís', 'phone'=>'915156414'],
            ['id'=>3, 'name'=>'Miguel', 'phone'=>'915551782'],
            ['id'=>4, 'name'=>'Jessica', 'phone'=>'351+ 956915397'],
        ]; */

        $users=DB::table('users')
            //->where('name','Sara')
            ->get();

        //dd($users);

        return $users;
    }

    /* private function getUsersInfo(){
        $usersInfo = [
            '1'=>[
                'name'=>'Cesae',
                'address'=>'Rua Ciríaco Cardoso 186, 4150-212 Porto',
                'email'=>'cesae@cesae.pt'
            ],
            '2'=>[
                'name'=>'Cesa',
                'address'=>'Rua Ciríaco Cardoso 186, 4150-212 Porto',
                'email'=>'cesae@cesae.pt'
            ]
        ];
        return $usersInfo;
    }*/

    public function addUser() {
/*         /*User::
        /* insert([
            'name'=>'Luís',
            'email'=>'luis@gmail.com',
            'password'=>1255564
        ]); */
/*         updateOrInsert(
            [
                'email'=>'luis@gmail.com',
            ],
            [
            'name'=>'Luís',
            'email'=>'luis@gmail.com',
            'password'=>1255564
        ]) /*
        updateOrInsert(
            [
                'email'=>'liliana@gmail.com',
            ],
            [
            'name'=>'Liliana',
            'email'=>'liliana@gmail.com',
            'password'=>1255154
        ]); */

        return view('users.create_user');
    }

    public function createUser(Request $request){
        $photo=null;
        if(isset($request->id)){
            $request->validate([
                'name' => 'string|required|max:25',
                'address' => 'string|min:4',
                'zip_code' => 'regex:/[0-9]{4}-[0-9]{3}/',
                'photo' => 'image'
            ]);



            if($request->hasFile('photo')){
                $photo=Storage::putFile('uploadedImages', $request->photo);
            }

            User::where('id',$request->id)
            ->update([
                'name' => $request->name,
                'address' => $request->address,
                'zip_code' => $request->zip_code,
                'photo'=> $photo
            ]);

        }else{
            $request->validate([
                'name' => 'string|required|max:25',
                'email' => 'email|required',
                'password' => 'required|min:5',
                'photo' => 'image'
            ]);

            User::insert([
                'name' => $request->name,
                'email' => $request->email,
                'password' => Hash::make($request->password),
                'created_at'=>new \DateTime(),
                'photo'=> $photo
            ]);
        }

        return redirect()->back()->with('massage','User adicionado com sucesso');
    }


}
