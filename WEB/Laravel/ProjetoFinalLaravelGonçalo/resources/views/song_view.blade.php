@extends('layouts.fe')

@section('content')
    <h5>Update Tarefa</h5>
    <form method="POST" action="{{route('tasks.create')}}">
        @csrf

        <div class="mb-3">
        <label for="SelectSong" class="form-label">song: </label>
        <select name="song_id" class="form-select" aria-label="Default select example" id="SelectSong">
            <option value="" selected>Open this select menu</option>
            @foreach ($songs as $song)
                @if ($song->id==$album_song->song_id)
                    <option value="{{$album_song->song_id}}" selected>{{$album_song->song_name}}</option>
                @else
                    <option value="{{$song->id}}">{{$song->name}}</option>
                @endif
            @endforeach
        </select>


        <input type="hidden" name="id" value="{{$album_song->album_id}}">
        <input type="hidden" name="id" value="{{$album_song->song_id}}">

        <div class="mb-3">
        <label for="exampleInputName" class="form-label">Nome Canção</label>
        <input name="name" value="{{$task->name}}" type="text" class="form-control" id="exampleInputName">
        @error('name')
            <small style="color: red">Insira um nome para a canção</small>
        @enderror
        </div>

        <div class="mb-3">
        <label for="SelectUser" class="form-label">song: </label>
        <select name="user_id" class="form-select" aria-label="Default select example" id="SelectUser">
            @if ($task->user_id==null)
                <option value="" selected>Open this select menu</option>
            @endif
            @foreach ($users as $user)
                @if ($user->id==$task->user_id)
                    <option value="{{$task->user_id}}" selected>{{$task->name_user}}</option>
                @else
                    <option value="{{$user->id}}">{{$user->name}}</option>
                @endif
            @endforeach
        </select>
        @error('user_id')
            <small style="color: red">Escolha uma opção</small>
        @enderror
        </div>
        <button type="submit" class="btn btn-primary">Guardar alterações</button>
    </form>
@endsection