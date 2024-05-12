<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\UserController;
use App\Http\Controllers\IndexController;
use App\Http\Controllers\BandController;
use App\Http\Controllers\AlbumController;

Route::get('/', [IndexController::class,'redirect']);

Route::fallback([IndexController::class,'fallback']);

Route::get('/home', [IndexController::class,'index'])->name('home');

Route::post('/create-band', [BandController::class, 'createBand'])->name('bands.create');

Route::post('/create-album', [AlbumController::class, 'createAlbum'])->name('albums.create');

Route::post('/create-song', [Controller::class, 'createSong'])->name('songs.create');


