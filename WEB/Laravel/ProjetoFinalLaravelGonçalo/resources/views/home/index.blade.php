@extends('layouts.fe')

@section('title')
    <title>Home</title>
@endsection

@section('content')
@if (session('message'))
        <div class="alert alert-sucess">{{session('message')}}</div>
        <hr>
    @endif
    @auth()
    @if (Auth::user()->user_type == \App\Models\User::TYPE_ADMIN)
        <a href="{{route('band.new')}}" class="btn btn-sucess">Adicionar Banda</a></td>
        <hr>
    @endif
    @endauth


    <form action="" method="get">
        <input type="text" name="search" value="{{request()->query('search')}}">
        <button type="btn btn-info">Procurar</button>
    </form>
    <br>

    <table class="table">
        <thead>
          <tr class="table-dark">
            <th scope="col" >#id</th>
            <th scope="col" >Foto</th>
            <th scope="col">Nome</th>
            <th scope="col">Nº de Álbuns</th>
          </tr>
        </thead>
        <tbody>
            @foreach ($allBands  as $band)
                <tr class="table-info">
                    <th scope="row" class="table-secondary">{{$band->id}}</th>
                    <td>
                        <img width="50px" height="50px"
                         src="{{$band->image_path ? asset('storage/'.$band->image_path) :
                         asset('img/noimage.jpg')}}"
                         alt="">
                    </td>
                    <td>{{$band->name}}</td>
                    <td>{{$band->album_count}}</td>
                    <td><a href="{{route('band.albums',$band->id)}}" class="btn btn-info">Ver Álbuns</a></td>
                    @auth()
                        <td><a href="{{route('band.view',$band->id)}}" class="btn btn-warning">Modificar</a></td>
                        @if (Auth::user()->user_type == \App\Models\User::TYPE_ADMIN)
                            <td><a href="{{route('band.delete',$band->id)}}" class="btn btn-danger">Apagar</a></td>
                            <td><a href="{{route('album.new',$band->id)}}" class="btn btn-sucess">Adicionar Álbum</a></td>
                        @endif
                    @endauth
                </tr>
            @endforeach
        </tbody>
    </table>
@endsection
