@extends('layouts.fe')

@section('title')
    <title>Register</title>
@endsection

@section('content')
<h5>Adicionar user</h5>
    <form method="POST" action="{{route('users.create')}}" enctype="multipart/form-data">
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

    <div class="mb-3">
        <label for="photo" class="form-label">Photo</label>
        <input name="photo" accept="image/*" type="file" class="form-control" id="photo">
        @error('photo')
            photo
        @enderror
    </div>

    <div class="mb-3 form-check">
        <input type="checkbox" class="form-check-input" id="exampleCheck1">
        <label class="form-check-label" for="exampleCheck1">Check me out</label>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
    </form>

@endsection
