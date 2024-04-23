@extends('layouts.fe')

@section('content')
    <h1>Tasks</h1>
    <table class="table table-bordered table-hover" style="vertical-align: middle; text-align: center">
        <thead>
        <tr class="table-dark" style="vertical-align: middle">
            <th scope="col" >#id</th>
            <th scope="col">Nome</th>
            <th scope="col">Descrição</th>
            <th scope="col">Due Date</th>
            <th scope="col">Status</th>
            <th scope="col">Assigned_to id</th>
            <th scope="col">Assigned_to Nome</th>
            <th scope="col">Assigned_to email</th>
        </tr>
        </thead>
        <tbody class="table-group-divider" style="color: red">
            @foreach ($allTasks  as $task)
                <tr class="table-info">
                    <th scope="row" class="table-secondary">{{$task->id}}</th>
                    <td>{{$task->name}}</td>
                    <td>{{$task->description}}</td>
                    <td>{{$task->due_at}}</td>
                    <td>{{$task->status}}</td>
                    <td>{{$task->user_id}}</td>
                    <td>{{$task->name_user}}</td>
                    <td>{{$task->email}}</td>
                </tr>
            @endforeach
        </tbody>
    </table>
@endsection
