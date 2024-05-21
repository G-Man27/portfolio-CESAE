<?php

namespace App\Http\Controllers;

use App\Models\Band;
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

        $id='Todos os Álbuns';


    return view('albums',compact('albums','id'));
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
        //dd($request);
        //$image_path=null;
        if(isset($request->id)){
            $request->validate([
                'name' => 'string|required',
                'image_path' => 'image',
                'band_id' => 'required',
                //'songs' => 'text',
                //'release_date' => 'date'
            ]);



            if($request->hasFile('image_path')){
                $image_path=Storage::putFile('uploadedImages', $request->image_path);

                Album::where('id',$request->id)
                ->update([
                'name' => $request->name,
                'image_path'=> $image_path,
                'release_date'=>$request->release_date,
                'songs'=>$request->songs
                ]);
            }

            Album::where('id',$request->id)
            ->update([
                'name' => $request->name,
                'release_date'=>$request->release_date,
                'songs'=>$request->songs
            ]);

            $message='Album alterado com sucesso';

        }else{
            $image_path=null;

            $request->validate([
                'name' => 'string|required',
                'image_path' => 'image',
                'band_id' => 'required',
                //'songs' => 'text',
                //'release_date' => 'date'
            ]);

            if($request->image_path!=null){
                $image_path=Storage::putFile('uploadedImages', $request->image_path);
            }

            Album::insert([
                'name' => $request->name,
                'image_path'=> $image_path,
                'band_id'=> $request->band_id,
                'release_date'=>$request->release_date,
                'songs'=>$request->songs
            ]);

            $message='Album adicionado com sucesso';
        }

        return redirect()->route('band.albums',[$request->band_id])->with('message');
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
    public function show($id)
    {
        $search=request()->query('search')?request()->query('search'):null;
        $albums=Album::where('band_id',$id)->get();


        if ($search) {
            $albums=Album::where('band_id',$id)->where('name', 'LIKE', "%{$search}%")->get();
        } else {
            $albums=Album::where('band_id',$id)->get();
        }

        $id=Band::where('id',$id)->First();


    return view('albums',compact('albums','id'));
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(Album $album)
    {
        $id=null;
        return view('album_view',compact('album','id'));
    }

    public function new($id)
    {
        $album=null;
        return view('album_view',compact('album','id'));
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
        $album->delete();
        return redirect()->back()->with('message','Banda apagada com sucesso');
    }
}
