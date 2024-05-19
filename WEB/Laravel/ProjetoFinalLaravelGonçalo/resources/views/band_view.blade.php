@extends('layouts.fe')

@section('content')
    <a href="{{route('users')}}"><i class="bi bi-arrow-return-left"></i>Voltar a users</a>
    <hr>
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
                <label for="image_path" class="form-label">Imagem</label>
                <input name="image_path" accept="image/*" type="file" class="form-control" id="image_path">
                @error('image_path')
                    Ficheiro Inválido
                @enderror
            </div>
            <button type="submit" class="btn btn-primary">Guardar Alterações</button>
        </form>
    </div>

@endsection
