@extends('layouts.fe')

@section('title')
    <title>Bands</title>
@endsection

@section('content')
    <a href="{{route('home')}}"><i class="bi bi-arrow-return-left"></i>Voltar a pagina principal</a>
    <h1>Bandas:</h1>
    @if (session('message'))
        <div class="alert alert-success">{{session('message')}}</div>
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
                    <td>{{$user->name}}</td>
                    <td>{{$user->email}}</td>
                    <td><a href="{{route('user.view',$user->id)}}" class="btn btn-info">Ver</a></td>
                    <td><a href="{{route('users.delete',$user->id)}}" class="btn btn-danger">Editar</a></td>
                    <td><a href="{{route('users.delete',$user->id)}}" class="btn btn-danger">Apagar</a></td>
                </tr>
            @endforeach
        </tbody>
    </table>
    @if ($use!=null)
            <div>
                <form method="POST" action="{{route('users.create')}}">
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

                    <div class="mb-3">
                    <label for="exampleInputAddress" class="form-label">Morada</label>
                    <input name="address" value="{{$user->address}}" type="text" class="form-control" id="exampleInputAddress">
                    @error('address')
                        <small style="color: red">Insira uma morada válida</small>
                    @enderror
                    </div>

                    <div class="mb-3">
                    <label for="exampleInputZip" class="form-label">Código Postal</label>
                    <input name="zip_code" value="{{$user->zip_code}}" type="text" class="form-control" id="exampleInputZip" placeholder="0000-000">
                    @error('zip_code')
                        <small style="color: red">Insira um zip-code válido</small>
                    @enderror
                    </div>
                    <button type="submit" class="btn btn-primary">Guardar Alterações</button>
                </form>
            </div>
        @endif
@endsection