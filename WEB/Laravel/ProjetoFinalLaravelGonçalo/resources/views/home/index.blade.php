@extends('layouts.fe')

@section('title')
    <title>Home</title>
@endsection

@section('content')
@if (session('message'))
        <div class="alert alert-success">{{session('message')}}</div>
        <hr>
    @endif
    @auth()
    @if (Auth::user()->user_type == \App\Models\User::TYPE_ADMIN)
        <a href="{{route('band.new')}}" class="btn btn-success">Adicionar Banda</a></td>
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
          <tr class="table-dark" style="text-align:center">
            <th scope="col" >#id</th>
            <th scope="col" >Foto</th>
            <th scope="col">Nome</th>
            <th scope="col">Nº de Álbuns</th>
            <th scope="col"></th>
            @auth()
                <th scope="col"></th>
                @if (Auth::user()->user_type == \App\Models\User::TYPE_ADMIN)
                    <th scope="col"></th>
                    <th scope="col"></th>
                @endif
            @endauth
          </tr>
        </thead>
        <tbody>
            @foreach ($allBands  as $band)
                <tr class="table-info">
                    <th style="vertical-align: middle; text-align:center" scope="row" class="table-secondary">{{$band->id}}</th>
                    <td style="vertical-align: middle; text-align:center; max-height:50%">
                        <img class="img-fluid" style="max-height: 420px; object-fit: contain; "
                         src="{{$band->image_path ? asset('storage/'.$band->image_path) :
                         asset('img/noimage.jpg')}}"
                         alt="">
                    </td>
                    <td style="vertical-align: middle; text-align:center">{{$band->name}}</td>
                    <td style="vertical-align: middle; text-align:center">{{$band->album_count}}</td>
                    <td style="vertical-align: middle; text-align:center; background-color:teal"><a href="{{route('band.albums',$band->id)}}" class="btn btn-info">Ver Álbuns</a></td>
                        @auth()
                            <td style="vertical-align: middle; text-align:center; background-color:teal"><a href="{{route('band.view',$band->id)}}" class="btn btn-warning">Modificar</a></td>
                            @if (Auth::user()->user_type == \App\Models\User::TYPE_ADMIN)
                                <td style="vertical-align: middle; text-align:center; background-color:teal"><a href="{{route('band.delete',$band->id)}}" class="btn btn-danger">Apagar</a></td>
                                <td style="vertical-align: middle; text-align:center; background-color:teal"><a href="{{route('album.new',$band->id)}}" class="btn btn-success">Adicionar Álbum</a></td>
                            @endif
                        @endauth
                </tr>
            @endforeach
        </tbody>
    </table>
@endsection
