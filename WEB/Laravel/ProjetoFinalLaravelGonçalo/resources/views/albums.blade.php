@extends('layouts.fe')

@section('title')
    <title>Álbuns</title>
@endsection

@section('content')
    @if (session('message'))
        <div class="alert alert-success">{{session('message')}}</div>
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

    <table class="table table-responsive">
        <thead>
          <tr class="table-dark" style="text-align:center">
            <th scope="col" >#id</th>
            <th scope="col" >Imagem</th>
            <th scope="col">Nome</th>
            <th scope="col">Data de lançamento</th>
            <th scope="col">Músicas</th>
            @auth()
                <th scope="col"></th>
                @if (Auth::user()->user_type == \App\Models\User::TYPE_ADMIN)
                    <th scope="col"></th>
                @endif
            @endauth
          </tr>
        </thead>
        <tbody>
            @foreach ($albums  as $album)
                <tr class="table-info" style="">
                    <th style="vertical-align: middle; text-align:center" scope="row" class="table-secondary">{{$album->id}}</th>
                    <td style="vertical-align: middle; text-align:center">
                        <img class="img-fluid" style="max-height: 420px; object-fit: contain; "
                         src="{{$album->image_path ? asset('storage/'.$album->image_path) :
                         asset('img/noimage.jpg')}}"
                         alt="">
                    </td>
                    <td style="vertical-align: middle; text-align:center">{{$album->name}}</td>
                    <td style="vertical-align: middle; text-align:center">{{$album->release_date}}</td>
                    <td style="vertical-align: middle; text-align:left"><pre>{{$album->songs}}</pre></td>
                    @auth()
                        <td style="vertical-align: middle; text-align:center; background-color:teal"><a href="{{route('album.view',$album)}}" class="btn btn-warning">Modificar</a></td>
                        @if (Auth::user()->user_type == \App\Models\User::TYPE_ADMIN)
                            <td style="vertical-align: middle; text-align:center; background-color:teal"><a href="{{route('album.delete',$album)}}" class="btn btn-danger">Apagar</a></td>
                        @endif
                    @endauth
                </tr>
            @endforeach
        </tbody>
    </table>
@endsection
