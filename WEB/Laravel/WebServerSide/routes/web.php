<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\UserController;
use App\Http\Controllers\IndexController;

Route::get('/', [IndexController::class,'redirect']);

Route::fallback([IndexController::class,'fallback']);

Route::get('/welcome', function () {
    return view('welcome');
})->name('home.welcome');

Route::get('/hello/{name?}', [IndexController::class,'hello'])->name('home.hello');

Route::get('/home', [IndexController::class,'index'])->name('home');

Route::get('/users', [UserController::class, 'allUsers'])->name('users');
