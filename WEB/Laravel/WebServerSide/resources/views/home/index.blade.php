<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h4>Olá, estou em casa!</h4>
    <ul>
        <a href="{{route('home.welcome')}}">
            <li>Welcome</li>
        </a>
        <a href="{{route('home.hello')}}">
            <li>Hello</li>
        </a>
        <a href="{{route('users')}}">
            <li>Users</li>
        </a>
    </ul>
</body>
</html>
