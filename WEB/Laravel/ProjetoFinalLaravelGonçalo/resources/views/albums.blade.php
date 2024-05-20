@extends('layouts.fe')

@section('title')
    <title>Álbuns</title>
@endsection

@section('content')
@if (session('message'))
        <div class="alert alert-sucess">{{session('message')}}</div>
        <hr>
    @endif

    <h1>
        @if ($id=='Todos os Álbuns')
            {{$id}}
        @else
            {{$id->name}}
        @endif
    </h1>

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
                    @auth()
                        <td><a href="{{route('album.view',$album)}}" class="btn btn-warning">Modificar</a></td>
                        @if (Auth::user()->user_type == \App\Models\User::TYPE_ADMIN)
                            <td><a href="{{route('album.delete',$album)}}" class="btn btn-danger">Apagar</a></td>
                        @endif
                    @endauth
                </tr>
            @endforeach
        </tbody>
    </table>
@endsection
