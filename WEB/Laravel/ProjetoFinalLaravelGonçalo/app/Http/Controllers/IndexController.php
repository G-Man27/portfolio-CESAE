<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class IndexController extends Controller
{
    public function fallback(){
        return view('errors.fallback');
    }
    public function redirect() {
        return redirect('/home');
    }
}
