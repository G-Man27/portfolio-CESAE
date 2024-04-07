<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class IndexController extends Controller
{
    public function index(){
        return view('home.index');
    }
    public function fallback(){
        return view('errors.fallback');
    }
    public function redirect() {
        return redirect('/home');
    }
    public function hello (?string $name = null) {
        if ($name==null){
            return view('hello');
        }else{
            return '<h2>Olá '.$name.'</h2>';
        }

    }
}
