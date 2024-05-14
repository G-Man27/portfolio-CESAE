@extends('layouts.fe')

@section('title')
    <title>Users</title>
@endsection

@section('content')
    <a href="{{route('home')}}"><i class="bi bi-arrow-return-left"></i>Voltar a pagina principal</a>
    <h2>Olá, aqui tens uma lista de todos os users</h2>
{{-- <ul>
        <li>
            {{$allUsers[0][1]}}:
            <ul>
                <li>{{$allUsers[0][2]}}</li>
            </ul>
        </li>
        <li>
            {{$allUsers[1][1]}}:
            <ul>
                <li>{{$allUsers[1][2]}}</li>
            </ul>
        </li>
        <li>
            {{$allUsers[2][1]}}:
            <ul>
                <li>{{$allUsers[2][2]}}</li>
            </ul>
        </li>
        <li>
            {{$allUsers[3][1]}}:
            <ul>
                <li>{{$allUsers[3][2]}}</li>
            </ul>
        </li>
    </ul>

         Nome: Telefone
    <ul>
        @foreach ($allUsers  as $user )
        <li>{{$user[1]}}: {{$user[2]}}</li>
        @endforeach
    </ul>
    <hr>
    <table class="table">
        <thead>
          <tr class="table-dark">
            <th scope="col" >#id</th>
            <th scope="col">Nome</th>
            <th scope="col">Telefone</th>
          </tr>
        </thead>
        <tbody>
            @foreach ($allUsers  as $user)
                <tr class="table-info">
                    <th scope="row" class="table-secondary">{{$user[0]}}</th>
                    <td>{{$user[1]}}</td>
                    <td>{{$user[2]}}</td>
                </tr>
            @endforeach
        </tbody>
      </table>
--}}
{{--<hr>
       <ul>
         @foreach ($allUsersInfo  as $user2 )
         <li>{{$user['1']['name']}}: {{$user['2']['name']}}</li>
         @endforeach
        </ul>
--}}

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
            <th scope="col" >Foto</th>
            <th scope="col">Nome</th>
            <th scope="col">Telefone</th>
          </tr>
        </thead>
        <tbody>
            @foreach ($allUsers  as $user)
                {{-- <tr class="table-info">
                    <th scope="row" class="table-secondary">{{$user['id']}}</th>
                    <td>{{$user['name']}}</td>
                    <td>{{$user['phone']}}</td>
                </tr> --}}
                <tr class="table-info">
                    <th scope="row" class="table-secondary">{{$user->id}}</th>
                    <td>
                        <img width="50px" height="50px"
                         src="{{$user->photo ? asset('storage/'.$user->photo) :
                         asset('img/nophoto.jpg')}}"
                         alt="">
                    </td>
                    <td>{{$user->name}}</td>
                    <td>{{$user->email}}</td>
                    <td><a href="{{route('user.view',$user->id)}}" class="btn btn-info">Ver</a></td>
                    <td><a href="{{route('users.delete',$user->id)}}" class="btn btn-danger">Apagar</a></td>
                </tr>
            @endforeach
        </tbody>
    </table>

    <hr>
    <h5>Adicionar user</h5>
    <form method="POST" action="{{route('users.create')}}">
    @csrf
    <div class="mb-3">
        <label for="exampleInputName" class="form-label">Nome</label>
        <input name="name" value="{{old('name')}}" type="text" class="form-control" id="exampleInputName">
        @error('name')
        <small style="color: red">Insira um nome</small>
        @enderror
    </div>

    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Email address</label>
        <input name="email" value="{{old('email')}}" type="email" class="form-control" id="exampleInputEmail" aria-describedby="emailHelp">
        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
        @error('email')
        <small style="color: red">Insira um email válido</small>
        @enderror
    </div>

    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Password</label>
        <input name="password" value="" type="password" class="form-control" id="exampleInputPassword">
        @error('password')
        <small style="color: red">Insira uma password válida</small>
        @enderror
    </div>

    <div class="mb-3 form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1">
        <label class="form-check-label" for="exampleCheck1">Check me out</label>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    </form>

@endsection
