<?php

namespace App\Http\Controllers;

use App\Models\Song;
use Illuminate\Http\Request;

class SongController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        //
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create(Request $request)
    {
        $image_path=null;
        if(isset($request->id)){
            $request->validate([
                'name' => 'string|required',
            ]);




            Song::where('id',$request->id)
            ->update([
                'name' => $request->name,
            ]);

            $message='Canção alterada com sucesso';

        }else{
            $request->validate([
                'name' => 'string|required',
                'image_path' => 'image'
            ]);

            Song::insert([
                'name' => $request->name,
            ]);

            $message='Canção adicionada com sucesso';
        }

        return redirect()->back()->with('message');
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
    public function show(Song $song)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(Song $song)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, Song $song)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Song $song)
    {
        //
    }
}
