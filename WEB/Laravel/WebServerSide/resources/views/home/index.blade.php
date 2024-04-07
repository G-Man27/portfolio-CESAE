@extends('layouts.fe')

@section('title')
    <title>Home</title>
@endsection

@section('content')
    <div style="text-align: center">
        <img class="test_img" src="{{asset('img\sample-image.jpg')}}" alt="">
    </div>
    <h3>Olá, estou em casa!</h3>
    <ul>
        <a href="{{route('home.welcome')}}">
            <li>Welcome</li>
        </a>
        <a href="{{route('home.hello')}}">
            <li>Hello</li>
        </a>
        <a href="{{route('users')}}">
            <li>Users</li>
        </a>
    </ul>
@endsection
