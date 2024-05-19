<?php

use App\Http\Controllers\BandController;
use App\Http\Controllers\IndexController;
use Illuminate\Support\Facades\Route;

Route::get('/', [IndexController::class,'redirect']);

Route::fallback([IndexController::class,'fallback']);

Route::get('/home', [BandController::class,'index'])->name('home');
