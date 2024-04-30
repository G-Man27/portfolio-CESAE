<?php

namespace App\Http\Controllers;

use App\Models\Gift;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class GiftsController extends Controller
{
    public function allGifts() {
        $allGifts= $this->getGifts();
        return view('gifts.all_gifts',compact('allGifts'));
    }

    public function getGifts() {
        $tasks=Gift::leftjoin('users', 'gifts.user_id', '=','users.id' )
        ->select('gifts.*', 'users.name as name_user')
        ->get();
        return $tasks;
    }

    public function viewGift($id){
        $gift=Gift::leftjoin('users', 'gifts.user_id', '=','users.id' )
        ->select('gifts.*', 'users.name as name_user')
        ->where('gifts.id',$id)
        ->first();
        return view('gifts.gift_view',compact('gift'));
    }

    public function deleteGift($id){
        Gift::where('id',$id)->delete();
        return redirect()->back();
    }
}
