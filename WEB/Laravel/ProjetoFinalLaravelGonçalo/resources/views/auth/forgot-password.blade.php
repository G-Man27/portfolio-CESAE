@extends('layouts.fe')

@section('content')
    <h1>Forgot password:</h1>
    <hr>
    @if (session('status'))
        <div class="alert alert-success">O email de recuperação foi enviado</div>
    @endif
    <form method="POST" action="{{route('password.email')}}">
        @csrf
        <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Email address</label>
            <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        </div>
        <button type="submit" class="btn btn-primary">Enviar Email</button>
    </form>
@endsection
