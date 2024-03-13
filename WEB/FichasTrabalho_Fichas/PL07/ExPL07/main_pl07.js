function mudarFundoVermelho() {
    document.body.style.background = "red"
}
function mudarFundoAquamarine() {
    document.body.style.background = "aquamarine"
}
function mudarFundoUva() {
    document.body.style.background = "rgb(141, 42, 180)"
}

function lorem() {
    document.getElementById("p1").style.display = "initial"
    document.getElementById("blorem").style.display = "none"
}

function showFrase() {
    par=document.getElementById("ex3")
    b = document.getElementById("f1")
    
    if (par.style.visibility == "hidden") {
        par.style.visibility = "visible"
        b.textContent = "Esconder frase"
    } else {
        par.style.visibility = "hidden"
        b.textContent = "Mostrar frase"
    }
}

function showText() {
    par=document.getElementById("p2")
    b = document.getElementById("b2")
    
    if (par.style.display == "none") {
        par.style.display = "block"
        b.textContent = "Ocultar"
        document.getElementById("ex3b").style.visibility= "visible"
    } else {
        par.style.display = "none"
        b.textContent = "Mostrar"
    }
}

function showFrase2() {
    par=document.getElementById("ex3b")
    b = document.getElementById("f2")
    
    if (par.style.visibility == "hidden") {
        par.style.visibility = "visible"
        b.textContent = "Esconder frase"
    } else {
        par.style.visibility = "hidden"
        b.textContent = "Mostrar frase"
    }
}

function fillText() {
    texto = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Excepturi maiores eaque, quibusdam vero tempore rerum aliquam! Dignissimos, veniam sapiente. Repellat perspiciatis aliquam repellendus laboriosam eius dolores exercitationem non magnam ipsum?"
    par = document.getElementById("p3")
    b= document.getElementById("b3")

    if (par.textContent.length == 0) {
        par.innerText = texto
        b.textContent = "Apagar"
    } else {
        par.innerText = ""
        b.textContent = "Preencher"
    }
}


function aumentarTexto() {
    document.getElementById("p-ex4").style.fontSize = "40px"
    document.getElementById("p-ex4").style.textAlign = "center"
}
function diminuirTexto() {
    document.getElementById("p-ex4").style.fontSize = "10px"
    document.getElementById("p-ex4").style.textAlign = "right"
}

document.getElementById("p-ex4").style.fontSize = "15px"
function mudarTamanho(tam) {
    par = document.getElementById("p-ex4")
    novoTam= parseInt(par.style.fontSize) + tam
    par.style.fontSize= novoTam + "px"
}