@extends('layouts.fe')

@section('title')
    <title>Gifts</title>
@endsection

@section('content')
    <a href="{{route('home')}}"><i class="bi bi-arrow-return-left"></i>Voltar a pagina principal</a>
    <h2>Olá, aqui tens uma lista de todas as prendas</h2>

    <hr>

    <table class="table">
        <thead>
          <tr class="table-dark">
            <th scope="col" >#id</th>
            <th scope="col">Nome</th>
            <th scope="col">Nome do user</th>
            <th scope="col">Valor previsto</th>
          </tr>
        </thead>
        <tbody>
            @foreach ($allGifts  as $gift)
                <tr class="table-info">
                    <th scope="row" class="table-secondary">{{$gift->id}}</th>
                    <td>{{$gift->name}}</td>
                    <td>{{$gift->name_user}}</td>
                    <td>{{$gift->valor_previsto}} €</td>
                    <td><a href="{{route('gift.view',$gift->id)}}" class="btn btn-info">Ver detalhes</a></td>
                    <td><a href="{{route('gift.delete',$gift->id)}}" class="btn btn-danger">Apagar</a></td>
                </tr>
            @endforeach
        </tbody>
      </table>




@endsection
