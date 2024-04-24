<?php

namespace App\Http\Controllers;

use App\Models\Task;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class TasksController extends Controller
{
    public function allTasks() {
        $allTasks= $this->getTasks();
        //dd($allTasks);
        //$users=DB::table('users')->where('id','=','tasks.user_id')->get();
        return view('tarefas',compact('allTasks'/* ,'users' */));
    }

    public function getTasks() {
        $tasks=Task::leftjoin('users', 'tasks.user_id', '=','users.id' )
        ->select('tasks.*', 'users.name as name_user','users.email')
        ->get();
        return $tasks;
    }
}
