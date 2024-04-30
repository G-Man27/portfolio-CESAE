<?php

namespace App\Http\Controllers;

use App\Models\Task;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;

class UserController extends Controller
{
    public function allUsers() {

        $allUsers= $this->getUsers();
        // $allUsersInfo= $this->getUsersInfo();

    return view('users.all_users',compact('allUsers'/*,'allUsersInfo'*/,));
    }

    public function viewUser_name(?string $name = null) {
        if ($name==null){
            $users=null;
            return view('users.user_view',compact('users'));
        }else{
            $users=User::where('name','like',$name)->get();
            return view('users.user_view',compact('users'));
        }
    }

    public function viewUser($id){
        $users=User::where('id',$id)->get();
        return view('users.user_view',compact('users'));
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
        User::
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
        ]) */
        updateOrInsert(
            [
                'email'=>'liliana@gmail.com',
            ],
            [
            'name'=>'Liliana',
            'email'=>'liliana@gmail.com',
            'password'=>1255154
        ]);
    }

    public function createUser(Request $request){
        $request->validate([
            'name' => 'string|required|max:25',
            'email' => 'email|required',
            'password' => 'required|min:5',
        ]);

        User::insert([
            'name' => $request->name,
            'email' => $request->email,
            'password' => Hash::make($request->password),
        ]);

        return redirect()->back()->with('massage','User adicionado com sucesso');
    }


}
