@extends('layouts.fe')

@section('content')
    <div>
        <form method="POST" action="{{route('albums.create')}}" enctype="multipart/form-data">
            @csrf
            <input type="hidden" name="id" value="{{$albums->id}}">
            <div class="mb-3">
                <label for="exampleInputName" class="form-label">Nome</label>
                <input name="name" value="{{$albums->name}}" type="text" class="form-control" id="exampleInputName">
                @error('name')
                    <small style="color: red">Insira um nome</small>
                @enderror
            </div>

            <div class="mb-3">
                <label for="photo" class="form-label">Photo</label>
                <input name="photo" accept="image/*" type="file" class="form-control" id="photo">
                @error('photo')
                    photo
                @enderror
            </div>
            <button type="submit" class="btn btn-primary">Guardar Alterações</button>
        </form>
    </div>
@endsection