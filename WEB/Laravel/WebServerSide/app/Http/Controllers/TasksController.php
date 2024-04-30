<?php

namespace App\Http\Controllers;

use App\Models\Task;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class TasksController extends Controller
{
    public function allTasks() {
        $allTasks= $this->getTasks();
        $users=User::get();
        //dd($allTasks);
        //$users=DB::table('users')->where('id','=','tasks.user_id')->get();
        return view('tarefas',compact('allTasks','users'/* ,'users' */));
    }

    public function getTasks() {
        $tasks=Task::leftjoin('users', 'tasks.user_id', '=','users.id' )
        ->select('tasks.*', 'users.name as name_user','users.email')
        ->get();
        return $tasks;
    }

    public function createTask(Request $request){
        //dd($request->all());
        $request->validate([
            'name' => 'string|required',
            'description' => 'max:100',
            'user_id' => 'required',
        ]);

        Task::insert([
            'name' => $request->name,
            'description' => $request->description,
            'user_id' => $request->user_id,
        ]);

        return redirect()->back()->with('massage','Tarefa adicionada com sucesso');
    }
}
