//alert('Ficheiro externo')
//document.write('aaa')

function mostrarLista(){
    document.write("<ul>")
    for (let i = 0; i <= 10; i++) {
        document.write("<li>"+ i +"</li>")        
    }
    document.write("</ul>")
}

function corFundo(cor) {
    document.body.style.background = cor
}

function corFundoAmarelo() {
    document.body.style.background = "yellow"
}

function corFundoVerde() {
    document.body.style.background = "green"
}

function corFundoLaranja() {
    document.body.style.background = "orange"
}

function mudarCor() {
    cor = document.getElementById("input-cor").value
    document.body.style.background = cor
}

function mudarCorRadio() {
    radioAmarelo = document.getElementById("cor-fundo-amarelo")
    radioVerde = document.getElementById("cor-fundo-verde")

    if (radioAmarelo.checked) {
        document.body.style.background = radioAmarelo.value
    } else if(radioVerde.checked){
        document.body.style.background = radioVerde.value
    }
}
 function mudarCorSelect() {
    cor = document.getElementById("cor-select").value

    if (cor != "") {
        document.body.style.background = cor
        document.getElementById("erro-select").style.display = "none" //errado, incompleto
    } else {
        alert('Selecione uma cor')
        document.getElementById("erro-select").style.display = "inline"
    }
 }