<?php

namespace App\Http\Controllers;

use App\Models\Task;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class TasksController extends Controller
{
    public function allTasks(?string $id = null) {
        if($id==null){
            $allTasks= $this->getTasks();
            $users=User::get();
        return view('tarefas',compact('allTasks','users','id'/* ,'users' */));
        }else{
            $allTasks=$this->getTasks()->where('id',$id);
            $users=User::get();
        return view('tarefas',compact('allTasks','users','id'/* ,'users' */));
        }

        //dd($allTasks);
        //$users=DB::table('users')->where('id','=','tasks.user_id')->get();
    }

    public function getTasks() {
        $tasks=Task::leftjoin('users', 'tasks.user_id', '=','users.id' )
        ->select('tasks.*', 'users.name as name_user','users.email')
        ->get();
        return $tasks;
    }

    public function createTask(Request $request){
        //dd($request->all());
        if(isset($request->id)){
            $request->validate([
                'name' => 'string|required',
                'description' => 'max:100',
                //'user_id' => 'required',
            ]);

            Task::where('id',$request->id)
            ->update([
                'name' => $request->name,
                'description' => $request->description,
                'user_id' => $request->user_id,
            ]);

            $message='Tarefa alterada com sucesso';

        }else {
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

            $message='Tarefa adicionada com sucesso';
        }


        return redirect('/tasks')->with('message', $message, 'id', null);
    }

}
