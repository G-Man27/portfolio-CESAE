@extends('layouts.fe')
@section('title')
    <title>Dashboard</title>
@endsection

@section('content')
    <h1>Olá {{Auth::user()->name}}</h1>
    @if (Auth::user()->user_type == \App\Models\User::TYPE_ADMIN)
        <div class="alert alert-success">És um ADMIN</div>
    @endif
@endsection
