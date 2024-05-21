@extends('layouts.fe')

@section('title')
    <title>Band</title>
@endsection

@section('content')
@if ($band==null)
    <div>
        <form method="POST" action="{{route('band.create')}}" enctype="multipart/form-data">
            @csrf
            <div class="mb-3">
            <label for="exampleInputName" class="form-label">Nome</label>
            <input name="name" type="text" class="form-control" id="exampleInputName">
            @error('name')
                <small style="color: red">Insira um nome</small>
            @enderror
            </div>

            <div class="mb-3">
                <label for="image_path" class="form-label">Imagem</label>
                <input name="image_path" accept="image/*" type="file" class="form-control" id="image_path">
                @error('image_path')
                    <small style="color: red">Ficheiro Inválido</small>
                @enderror
            </div>
            <button type="submit" class="btn btn-primary">Guardar</button>
        </form>
    </div>
@else
    <div>
        <form method="POST" action="{{route('band.create')}}" enctype="multipart/form-data">
            @csrf
            <input type="hidden" name="id" value="{{$band->id}}">
            <div class="mb-3">
            <label for="exampleInputName" class="form-label">Nome</label>
            <input name="name" value="{{$band->name}}" type="text" class="form-control" id="exampleInputName">
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
            <button type="submit" class="btn btn-primary">Guardar</button>
        </form>
    </div>
@endif



@endsection
