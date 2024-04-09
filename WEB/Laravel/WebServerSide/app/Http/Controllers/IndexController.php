<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class IndexController extends Controller
{
    public function index(){
        $sum = $this -> sum(1,3);
        $hellovar = $this->helloFunc();
        $cesaeInfo = $this->getCesaeInfo();

        $myArray=['Sara','José'];
        $myArray2=['Sara',37];

        $myArrayAssociativo=[
            'name'=>'Sara',
            'age'=>37,
            'profession'=>'web developer'
        ];
        //dd($cesaeInfo);

        return view('home.index',compact('sum','hellovar','myArray','myArray2','myArrayAssociativo','cesaeInfo'));
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

    protected function sum($num1,$num2){
        return $num1+$num2;
    }
    protected function helloFunc(){
        $hello='Olá mundo, estamos a aprender web';
        return $hello;
    }

    private function getCesaeInfo(){
        $cesaeInfo = [
            'name'=>'Cesae',
            'address'=>'Rua Ciríaco Cardoso 186, 4150-212 Porto',
            'email'=>'cesae@cesae.pt'
        ];
        return $cesaeInfo;
    }

}
