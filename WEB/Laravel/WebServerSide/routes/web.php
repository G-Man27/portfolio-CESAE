<?php

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\UserController;
use App\Http\Controllers\GiftsController;
use App\Http\Controllers\IndexController;
use App\Http\Controllers\TasksController;

Route::get('/', [IndexController::class,'redirect']);

Route::fallback([IndexController::class,'fallback']);

Route::get('/welcome', function () {
    return view('welcome');
})->name('home.welcome');

Route::get('/hello/{name?}', [IndexController::class,'hello'])->name('home.hello');

Route::get('/home', [IndexController::class,'index'])->name('home');

Route::get('/users', [UserController::class, 'allUsers'])->name('users');

Route::get('/user/{name?}', [UserController::class, 'viewUser_name'])->name('users.view');

Route::get('/user/user_id/{id}', [UserController::class, 'viewUser'])->name('user.view');

Route::get('/add_user', [UserController::class, 'addUser'])->name('users.add');

Route::post('/create-user', [UserController::class, 'createUser'])->name('users.create');

Route::get('/delete_user/{id}', [UserController::class, 'deleteUser'])->name('users.delete');

Route::get('/tasks', [TasksController::class, 'allTasks'])->name('tasks');

Route::post('/create-task', [TasksController::class, 'createTask'])->name('tasks.create');

Route::get('/gifts', [GiftsController::class, 'allGifts'])->name('gifts');

Route::get('/gifts/{id}', [GiftsController::class, 'viewGift'])->name('gift.view');

Route::get('/delete_gift/{id}', [GiftsController::class, 'deleteGift'])->name('gift.delete');
