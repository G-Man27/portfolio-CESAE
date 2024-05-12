@extends('layouts.fe')

@section('content')
<a href="{{route('users')}}"><i class="bi bi-arrow-return-left"></i>Voltar a users</a>
    <h1>Olá, sou um user</h1>
    @if (session('message'))
        <div class="alert alert-success">{{session('message')}}</div>
    @endif
    <hr>
    @if ($users!=null)
        <div class="table-responsive">
            <table class="table">
                <thead>
                <tr class="table-dark">
                    <th scope="col" >#id</th>
                    <th scope="col">Nome</th>
                    <th scope="col">email</th>
                    <th scope="col">address</th>
                    <th scope="col">zip_code</th>
                    <th scope="col">email_verified_at</th>
                    <th scope="col">password</th>
                    <th scope="col">remember_token</th>
                    <th scope="col">created_at</th>
                    <th scope="col">updated_at</th>
                </tr>
                </thead>
                <tbody>
                    @foreach ($users  as $user)
                        <tr class="table-info">
                            <th scope="row" class="table-secondary">{{$user->id}}</th>
                            <td>{{$user->name}}</td>
                            <td>{{$user->email}}</td>
                            <td>{{$user->address}}</td>
                            <td>{{$user->zip_code}}</td>
                            <td>{{$user->email_verified_at}}</td>
                            <td>{{$user->password}}</td>
                            <td>{{$user->remember_token}}</td>
                            <td>{{$user->created_at}}</td>
                            <td>{{$user->updated_at}}</td>
                        </tr>
                    @endforeach
                </tbody>
            </table>
        </div>
    @endif
@endsection
