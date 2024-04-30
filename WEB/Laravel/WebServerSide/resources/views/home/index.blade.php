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
        <a href="{{route('users.view')}}">
            <li>User</li>
        </a>
        <a href="{{route('tasks')}}">
            <li>Tasks</li>
        </a>
        <a href="{{route('gifts')}}">
            <li>Prendas</li>
        </a>
    </ul>

    <hr>
    <h5>A soma é {{$sum}}, {{$hellovar}}!</h5>
    <h6>Primeira STRING: {{$hellovar}}.</h6>
    <h5>{{$myArray[1]}}</h5>
    <h5>A {{$myArray2[0]}} tem {{$myArray2[1]}} anos</h5>
    <h5>A {{$myArrayAssociativo['name']}} tem {{$myArrayAssociativo['age']}} anos e trabalha como {{$myArrayAssociativo['profession']}}</h5>

    <hr>
    <h5>Info de {{$cesaeInfo['name']}}:</h5>
    <ul>
        <li>{{$cesaeInfo['address']}}</li>
        <li>{{$cesaeInfo['email']}}</li>
    </ul>
@endsection
