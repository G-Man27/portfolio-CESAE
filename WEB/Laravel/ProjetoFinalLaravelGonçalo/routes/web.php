<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\BandController;
use App\Http\Controllers\UserController;
use App\Http\Controllers\AlbumController;
use App\Http\Controllers\IndexController;
use App\Http\Controllers\DashboardController;

Route::get('/', [IndexController::class,'redirect']);

Route::fallback([IndexController::class,'fallback']);

Route::get('/home', [BandController::class,'index'])->name('home');

Route::get('/dashboard',[DashboardController::class,'home'])->name('dashboard.home')->middleware('auth');

Route::get('/user/user_id/{id}', [UserController::class, 'viewUser'])->name('user.view')->middleware('auth');

Route::get('/users', [UserController::class, 'index'])->name('users')->middleware('auth');

Route::post('/create-user', [UserController::class, 'create'])->name('users.create');

Route::get('/add_user', [UserController::class, 'addUser'])->name('users.add');

Route::get('/delete_user/{id}', [UserController::class, 'deleteUser'])->name('users.delete');

Route::post('/create_band', [BandController::class, 'create'])->name('band.create')->middleware('auth');

Route::post('/update_band', [BandController::class, 'create'])->name('band.update')->middleware('auth');

Route::get('/band/{band}', [BandController::class, 'edit'])->name('band.view')->middleware('auth');

Route::get('/new_band', [BandController::class, 'store'])->name('band.new')->middleware('auth');

Route::get('/delete_band/{band}', [BandController::class, 'destroy'])->name('band.delete')->middleware('auth');

Route::get('/albums', [AlbumController::class,'index'])->name('albums.all');

Route::get('/albums/{id}', [AlbumController::class, 'show'])->name('band.albums');

Route::post('/new_album/{id}', [AlbumController::class, 'new'])->name('album.new')->middleware('auth');

Route::post('/create_album', [AlbumController::class, 'create'])->name('album.create')->middleware('auth');

Route::post('/update_album', [AlbumController::class, 'create'])->name('album.update')->middleware('auth');

Route::get('/album/{album}', [AlbumController::class, 'edit'])->name('album.view')->middleware('auth');

Route::get('/delete_album/{album}', [AlbumController::class, 'destroy'])->name('album.delete')->middleware('auth');
