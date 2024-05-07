@extends('layouts.fe')

@section('content')
    @if ($id!=0)
        <a href="{{route('tasks')}}"><i class="bi bi-arrow-return-left"></i>Voltar a todas as tarefas</a>
    @else
        <a href="{{route('home')}}"><i class="bi bi-arrow-return-left"></i>Voltar a pagina principal</a>
    @endif
    <h1>Tasks</h1>

    @if (session('message'))
        <div class="alert alert-success">{{session('message')}}</div>
    @endif
    <hr>

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
                    <td><a href="{{route('tasks',$task->id)}}" class="btn btn-info">Update</a></td>
                </tr>
            @endforeach
        </tbody>
    </table>

    <hr>
    @if ($id!=null)
        <h5>Update Tarefa</h5>
        <form method="POST" action="{{route('tasks.create')}}">
            @csrf

            <input type="hidden" name="id" value="{{$task->id}}">

            <div class="mb-3">
            <label for="exampleInputName" class="form-label">Nome da tarefa</label>
            <input name="name" value="{{$task->name}}" type="text" class="form-control" id="exampleInputName">
            @error('name')
                <small style="color: red">Insira um nome para a tarefa</small>
            @enderror
            </div>

            <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Descrição</label>
            <input name="description" value="{{$task->description}}" type="text" class="form-control" id="exampleInputDescription">
            @error('description')
                <small style="color: red">Insira uma descrição com tamanho inferior a 100 caratéres</small>
            @enderror
            </div>

            <div class="mb-3">
            <label for="SelectUser" class="form-label">Atribuir a: </label>
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

            <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Check me out</label>
            </div>
            <button type="submit" class="btn btn-primary">Guardar alterações</button>
        </form>
    @else
        <h5>Nova Tarefa</h5>
        <form method="POST" action="{{route('tasks.create')}}">
            @csrf
            <div class="mb-3">
            <label for="exampleInputName" class="form-label">Nome da tarefa</label>
            <input name="name" value="" type="text" class="form-control" id="exampleInputName">
            @error('name')
                <small style="color: red">Insira um nome para a tarefa</small>
            @enderror
            </div>

            <div class="mb-3">
            <label for="exampleInputEmail1" class="form-label">Descrição</label>
            <input name="description" value="" type="text" class="form-control" id="exampleInputDescription">
            @error('description')
                <small style="color: red">Insira uma descrição com tamanho inferior a 100 caratéres</small>
            @enderror
            </div>

            <div class="mb-3">
            <label for="SelectUser" class="form-label">Atribuir a: </label>
            <select name="user_id" class="form-select" aria-label="Default select example" id="SelectUser">
                <option value="" selected>Open this select menu</option>
                @foreach ($users as $user)
                    <option value="{{$user->id}}">{{$user->name}}</option>
                @endforeach
            </select>
            @error('user_id')
                <small style="color: red">Escolha uma opção</small>
            @enderror
            </div>

            <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Check me out</label>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    @endif

@endsection
