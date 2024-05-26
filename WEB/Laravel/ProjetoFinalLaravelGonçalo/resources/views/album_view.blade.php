@extends('layouts.fe')

@section('title')
    <title>Álbum</title>
@endsection

@section('content')
    <div>
        <form method="POST" action="{{route('album.create')}}" enctype="multipart/form-data">
            @csrf
            @if ($album==null)
                <input type="hidden" name="band_id" value="{{$id}}">
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
                <div class="mb-3">
                    <label for="exampleInputName" class="form-label">Songs</label>
                    <textarea name="songs"   class="form-control" id="exampleInputName" style="height:200px"></textarea>
                    @error('songs')
                        <small style="color: red">Insira um nome</small>
                    @enderror
                </div>
                <div class="mb-3">
                    <label for="exampleInputName" class="form-label">Data</label>
                    <input name="release_date" type="date" class="form-control" id="exampleInputName">
                    @error('release_date')
                        <small style="color: red">Insira uma data válida</small>
                    @enderror
                </div>

            @else
                <input type="hidden" name="id" value="{{$album->id}}">
                <input type="hidden" name="band_id" value="{{$album->band_id}}">


                <div class="mb-3">
                    <label for="exampleInputName" class="form-label">Nome</label>
                    <input name="name" value="{{$album->name}}" type="text" class="form-control" id="exampleInputName">
                    @error('name')
                        <small style="color: red">Insira um nome</small>
                    @enderror
                </div>

                <div class="mb-3">
                    <label for="image_path" class="form-label">Imagem</label>
                    <input name="image_path"  accept="image/*" type="file" class="form-control" id="image_path">
                    @error('image_path')
                        <small style="color: red">Ficheiro Inválido</small>
                    @enderror
                </div>
                <div class="mb-3">
                    <label for="exampleInputName" class="form-label">Songs</label>
                    <textarea name="songs"   class="form-control" id="exampleInputName" style="height:200px">{{$album->songs}}</textarea>
                    @error('songs')
                        <small style="color: red">Insira um nome</small>
                    @enderror
                </div>
                <div class="mb-3">
                    <label for="exampleInputName" class="form-label">Data</label>
                    <input name="release_date" value="{{$album->release_date}}" type="date" class="form-control" id="exampleInputName">
                    @error('release_date')
                        <small style="color: red">Insira uma data válida</small>
                    @enderror
                </div>
            @endif
            <button type="submit" class="btn btn-primary">Guardar</button>
        </form>
    </div>
@endsection
