<?php

namespace App\Http\Controllers;

use App\Models\Album;
use App\Models\AlbumSong;
use App\Models\Band;
use App\Models\Song;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Storage;

class BandController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {

        $search=request()->query('search')?request()->query('search'):null;

        if ($search) {
            $allBands=Band::where('name', 'LIKE', "%{$search}%")->get();
        } else {
            $allBands=Band::get();
        }

        foreach($allBands as $bands){
            $bands->album_count=Album::where('band_id','=',$bands->id)->count();
        }



    return view('home.index',compact('allBands'));

    }

    /**
     * Show the form for creating a new resource.
     */
    public function create(Request $request)
    {
        //$image_path=null;
        if(isset($request->id)){
            $request->validate([
                'name' => 'string|required',
                'image_path' => 'image'
            ]);



            if($request->hasFile('image_path')){
                $image_path=Storage::putFile('uploadedImages', $request->image_path);

                Band::where('id',$request->id)
                ->update([
                'name' => $request->name,
                'image_path'=> $image_path
                ]);
            };

            Band::where('id',$request->id)
            ->update([
                'name' => $request->name,
            ]);

            $message='Banda alterada com sucesso';

        }else{
            //dd($request->image_path);
            $image_path=null;

            $request->validate([
                'name' => 'string|required',
                'image_path' => 'image'
            ]);
            if($request->image_path!=null){
                $image_path=Storage::putFile('uploadedImages', $request->image_path);
            }
            Band::insert([
                'name' => $request->name,
                'image_path'=> $image_path
            ]);

            $message='Banda adicionada com sucesso';
        }

        return redirect('/home')->with('message');
    }


    /**
     * Store a newly created resource in storage.
     */
    public function store()
    {
        $band=null;
        return view('band_view',compact('band'));
    }

    /**
     * Display the specified resource.
     */
    public function show(Band $band)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(Band $band)
    {
        return view('band_view',compact('band'));
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, Band $band)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(Band $band)
    {
        Album::where('band_id',$band->id)->delete();
        $band->delete();
        return redirect('/home')->with('message','Banda apagada com sucesso');
    }

    public function deleteBand($id){
        Song::where('band_id',$id)->delete();
        AlbumSong::where('band_id',$id)->delete();
        Album::where('band_id',$id)->delete();
        Band::where('id',$id)->delete();
        return redirect()->back();
    }
}
