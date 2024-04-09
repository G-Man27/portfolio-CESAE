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
                    <th scope="row" class="table-secondary">{{$user['id']}}</th>
                    <td>{{$user['name']}}</td>
                    <td>{{$user['phone']}}</td>
                </tr>
            @endforeach
        </tbody>
      </table>




@endsection
