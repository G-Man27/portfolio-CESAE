@extends('layouts.fe')

@section('title')
    <title>Home</title>
@endsection

@section('content')
@if (session('message'))
        <div class="alert alert-sucess">{{session('message')}}</div>
        <hr>
    @endif
    @if (Auth::user()->user_type == \App\Models\User::TYPE_ADMIN)
        <a href="{{route()}}" class="btn btn-sucess">Adicionar Banda</a></td>
        <hr>
    @endif
    

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
            <th scope="col">Telefone</th>
          </tr>
        </thead>
        <tbody>
            @foreach ($allUsers  as $user)
                <tr class="table-info">
                    <th scope="row" class="table-secondary">{{$user->id}}</th>
                    <td>
                        <img width="50px" height="50px"
                         src="{{$user->photo ? asset('storage/'.$user->photo) :
                         asset('img/noimage.jpg')}}"
                         alt="">
                    </td>
                    <td>{{$user->name}}</td>
                    <td>{{$user->email}}</td>
                    <td><a href="{{route('user.view',$user->id)}}" class="btn btn-warning">Modificar</a></td>
                    <td><a href="{{route('users.delete',$user->id)}}" class="btn btn-danger">Apagar</a></td>
                </tr>
            @endforeach
        </tbody>
    </table>
@endsection
