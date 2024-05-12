<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class BandController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function allBands() {

        $search=request()->query('search')?request()->query('search'):null;

        if ($search) {
            $allBands=Band::where('name', 'LIKE', "%{$search}%")->get();
        } else {
            $allBands= $this->getBands();
        }

        return view('home',compact('allBands'));    
    }

    public function getBands() {//TODO
        $bands=Band::leftjoin('users', 'tasks.user_id', '=','users.id' )
        ->select('tasks.*', 'users.name as name_user','users.email')
        ->get();
        return $bands;
    }

    public function deleteBand($id){
        Song::where()->delete();//TODO
        Album::where('user_id',$id)->delete();
        Band::where('id',$id)->delete();
        return redirect()->back();
    }


    public function createTask(Request $request){//TODO
        //dd($request->all());
        if(isset($request->id)){
            $request->validate([
                'name' => 'string|required',
                'description' => 'max:100',
                //'user_id' => 'required',
            ]);

            Band::where('id',$request->id)
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


            Band::insert([
                'name' => $request->name,
                'description' => $request->description,
                'user_id' => $request->user_id,
            ]);

            $message='Tarefa adicionada com sucesso';
        }


        return redirect('/tasks')->with('message', $message, 'id', null);
    }











    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        //
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
