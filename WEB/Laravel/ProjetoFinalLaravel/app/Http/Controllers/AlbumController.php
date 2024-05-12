<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class AlbumController extends Controller
{
    public function viewAlbums($id){
        $albums=Album::where('id',$id)->get();
        $use=true;
        return view('album_view',compact('albums','use'));
    }

    public function deleteAlbum($id){
        Task::where('user_id',$id)->update(['user_id'=>null]);//TODO
        Album::where('id',$id)->delete();
        return redirect()->back();
    }


    public function createAlbum(Request $request){//TODO
        //dd($request->all());
        if(isset($request->id)){
            $request->validate([
                'name' => 'string|required',
                'description' => 'max:100',
                //'user_id' => 'required',
            ]);

            Album::where('id',$request->id)
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


            Album::insert([
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
