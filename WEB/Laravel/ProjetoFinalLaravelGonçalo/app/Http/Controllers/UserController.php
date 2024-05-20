<?php

namespace App\Http\Controllers;

use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Storage;

class UserController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $allUsers= User::get();
        $search=request()->query('search')?request()->query('search'):null;

        if ($search) {
            $allUsers=User::where('name', 'LIKE', "%{$search}%")->get();
        } else {
            $allUsers=User::get();
        }

        return view('users.all_users',compact('allUsers'));
    }


    public function viewUser($id){
        $users=User::where('id',$id)->get();
        $use=true;
        return view('users.user_view',compact('users','use'));
    }


    public function addUser() {
        return view('users.create_user');
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create(Request $request)
    {
        $photo=null;
        if(isset($request->id)){
            $request->validate([
                'name' => 'string|required|max:25',
            ]);




            User::where('id',$request->id)
            ->update([
                'name' => $request->name,
                'user_type'=>$request->user_type
            ]);

        }else{
            $request->validate([
                'name' => 'string|required|max:25',
                'email' => 'email|required',
                'password' => 'required|min:8',
            ]);

            User::insert([
                'name' => $request->name,
                'email' => $request->email,
                'password' => Hash::make($request->password),
                'created_at'=>new \DateTime(),
            ]);
        }

        return redirect()->back()->with('message','User adicionado com sucesso');
    }

    public function deleteUser($id){
        User::where('id',$id)->delete();
        return redirect()->back();
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(string $id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        //
    }
}
