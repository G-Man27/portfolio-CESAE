<?php

namespace App\Http\Controllers;

use App\Models\Album;
use App\Models\AlbumSong;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Storage;

class AlbumController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $search=request()->query('search')?request()->query('search'):null;

        if ($search) {
            $albums=Album::where('name', 'LIKE', "%{$search}%")->get();
        } else {
            $albums=Album::get();
        }


    return view('home.index',compact('albums'));
    }

    public function viewAlbums($id){
        $albums=AlbumSong::join('albums', 'albums.id', '=','album_song.album_id' )
        ->join('songs', 'songs.id', '=','album_song.song_id' )
        ->where('id',$id)->get()
        ->select('albums.*','songs.name as song_name','songs.id as song_id');
        return view('users.user_view',compact('albums'));
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
                'image_path' => 'image'
            ]);



            if($request->hasFile('image_path')){
                $image_path=Storage::putFile('uploadedImages', $request->image_path);
            }

            Album::where('id',$request->id)
            ->update([
                'name' => $request->name,
                'image_path'=> $image_path
            ]);

            $message='Album alterado com sucesso';

        }else{
            $request->validate([
                'name' => 'string|required',
                'image_path' => 'image'
            ]);

            Album::insert([
                'name' => $request->name,
                'image_path'=> $image_path
            ]);

            $message='Album adicionado com sucesso';
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
    public function show(Album $album)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(Album $album)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, Album $album)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Album $album)
    {
        //
    }
}
