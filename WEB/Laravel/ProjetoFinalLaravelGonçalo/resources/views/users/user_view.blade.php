@extends('layouts.fe')

@section('content')
<a href="{{route('users')}}"><i class="bi bi-arrow-return-left"></i>Voltar a users</a>
    <h1>Olá, sou um user</h1>
    @if ($users!=null)
        <div class="table-responsive">
            <table class="table">
                <thead>
                <tr class="table-dark">
                    <th scope="col" >#id</th>
                    <th scope="col">Nome</th>
                    <th scope="col">Email</th>
                    <th scope="col" >UserType</th>
                    <th scope="col">email_verified_at</th>
                    <th scope="col">Password</th>
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
                            <td>{{$user->user_type}}</td>
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
        @if ($use!=null)
            <div>
                <form method="POST" action="{{route('users.create')}}" enctype="multipart/form-data">
                    @csrf
                    <input type="hidden" name="id" value="{{$user->id}}">
                    <div class="mb-3">
                    <label for="exampleInputName" class="form-label">Nome</label>
                    <input name="name" value="{{$user->name}}" type="text" class="form-control" id="exampleInputName">
                    @error('name')
                        <small style="color: red">Insira um nome</small>
                    @enderror
                    </div>

                    <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Email address</label>
                    <input name="email" readonly value="{{$user->email}}" type="email" class="form-control" id="exampleInputEmail" aria-describedby="emailHelp">
                    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                    @error('email')
                        <small style="color: red">Insira um email válido</small>
                    @enderror
                    </div>
                    @if (Auth::user()->user_type == \App\Models\User::TYPE_ADMIN)
                        <div class="mb-3">
                            <label for="exampleInputEmail1" class="form-label">User Type</label>
                            <input name="user_type" value="{{$user->email}}" type="number" class="form-control" id="" aria-describedby="">
                            @error('user_type')
                                <small style="color: red">Insira um type válido</small>
                            @enderror
                        </div>
                    @endif
                    <button type="submit" class="btn btn-primary">Guardar Alterações</button>
                </form>
            </div>
        @endif
    @endif
@endsection
