@extends('layouts.fe')

@section('title')
    <title>Reset Password</title>
@endsection

@section('content')
    <h1>Alteração de password:</h1>
    <hr>
    <form method="POST" action="{{route('password.update')}}">
        @csrf
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email address</label>
            <input name="email" type="email" value="{{request()->email}}" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Password</label>
            <input name="password" type="password"  id="exampleInputPassword1" class="form-control @error('password') is-invalid @enderror">
            @error('password')
                <div class="invalid-feedback">{{$message}}</div>
            @enderror
        </div>
        <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">Password Confirmation</label>
            <input name="password_confirmation" type="password" class="form-control" id="exampleInputPassword1">
            <input type="hidden" name="token" value="{{request()->route('token')}}">
        </div>
        <input type="hidden" name="token" value="{{request()->route('token')}}">
        <button type="submit" class="btn btn-primary">Alterar Password</button>
    </form>
@endsection
