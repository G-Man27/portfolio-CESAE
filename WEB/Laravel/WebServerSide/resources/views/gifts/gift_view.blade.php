@extends('layouts.fe')

@section('content')
    <div class="table-responsive">
        <table class="table">
            <thead>
            <tr class="table-dark">
                <th scope="col" >#id</th>
                <th scope="col">Nome</th>
                <th scope="col">Nome do user</th>
                <th scope="col">Valor previsto</th>
                <th scope="col">Valor Gasto</th>
                <th scope="col">Descrição</th>
            </tr>
            </thead>
            <tbody>
                <tr class="table-info">
                    <th scope="row" class="table-secondary">{{$gift->id}}</th>
                    <td>{{$gift->name}}</td>
                    <td>{{$gift->name_user}}</td>
                    <td>{{$gift->valor_previsto}} €</td>
                    <td>{{$gift->valor_gasto}} €</td>
                    <td>{{$gift->descricao}}</td>
                </tr>
            </tbody>
        </table>
    </div>
@endsection
