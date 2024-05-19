@extends('layouts.fe')

@section('title')
    <title>Home</title>
@endsection

@section('content')
@if (session('message'))
        <div class="alert alert-sucess">{{session('message')}}</div>
    @endif
    <hr>

    <form action="" method="get">
        <input type="text" name="search" value="{{request()->query('search')}}">
        <button type="btn btn-info">Procurar</button>
    </form>
    <br>

    <table class="table">
        <thead>
          <tr class="table-dark">
            <th scope="col" >#id</th>
            <th scope="col" >Imagem</th>
            <th scope="col">Nome</th>
            <th scope="col">Data de lançamento</th>
          </tr>
        </thead>
        <tbody>
            @foreach ($albums  as $album)
                <tr class="table-info">
                    <th scope="row" class="table-secondary">{{$album->id}}</th>
                    <td>
                        <img width="50px" height="50px"
                         src="{{$album->image_path ? asset('storage/'.$album->image_path) :
                         asset('img/noimage.jpg')}}"
                         alt="">
                    </td>
                    <td>{{$album->name}}</td>
                    <td>{{$album->release_date}}</td>
                    <td><a href="{{route('user.view',$user->id)}}" class="btn btn-info">Ver</a></td>
                    <td><a href="{{route('users.delete',$user->id)}}" class="btn btn-danger">Apagar</a></td>
                </tr>
            @endforeach
        </tbody>
    </table>
@endsection
