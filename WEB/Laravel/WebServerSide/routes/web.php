<?php

use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return redirect('/home');
});

Route::fallback(function(){
    return view('errors.fallback');
});

Route::get('/welcome', function () {
    return view('welcome');
})->name('home.welcome');

Route::get('/hello', function () {
    return view('hello');
})->name('home.hello');

Route::get('/hello/{name}', function ($name) {
    return '<h2>Olá '.$name.'</h2>';
});

Route::get('/home', function () {
    return view('home.index');
})->name('home');

Route::get('/users', function () {
    return view('users.all_users');
})->name('users');
