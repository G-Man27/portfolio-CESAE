<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
    echo "<h1>PHP</h1><h2>Mensagem php</h2>";

    $sobrenome = "Silva";
    echo "Olá 'Zé' Manel $sobrenome";
    echo"<hr>";
    echo "Olá ".'"Zé"'." Manel " . $sobrenome;
    echo"<hr>";
    echo 'Olá "Zé" Manel $sobrenome';
    echo"<hr>";
    echo 'Olá "Zé" Manel ' . $sobrenome;
    
    
    ?>
    
</body>
</html>