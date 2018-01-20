var btnAplicar = document.getElementById("Aplicar");
var mapa = document.getElementById("mapa");
var cells = document.getElementsByTagName("td");
var selectBtn = document.getElementById("celdasSelect");
var selectedOption = 'green';
var listaCeldasJSON;
var mapaResultado;
var btnGuardar = document.getElementById('Guardar');
var nivelDeZona = document.getElementById('nivelDeZona');
var formRes = document.getElementById('resultado');
const colorInit = 'green';
var pasos = document.getElementsByClassName("pas");
var pasosDiv = document.getElementById("pasos");
var step = 0;
var inicioCreador = document.getElementById("inicioCreador");
var mapaTabla = document.getElementById("mapaTabla");
var mapaStep = document.getElementById("mapaStep");
var infoGrupo = document.getElementsByClassName("infoGrupo");
var celdas;
var inOut = document.getElementById("inOut");
var ultimoMapa;
var celdaIn;
var celdaOut;
var inRow = document.getElementById("inRow");
var outRow = document.getElementById("outRow");
var columns = document.getElementById("columns");
var rows = document.getElementById("rows");
var btnAtras = document.getElementById("Atras");
var btnAtras2 = document.getElementById("Atras2");
var parametrosNumDiv = document.getElementById("parametrosNumberDiv");
var btnEnvNumPar = document.getElementById("envNumPar");
var parametrosSelect = document.getElementById("parametroSelect");
var resultadoGuardar = document.getElementById("resultadoGuardar")

cells[0].style.backgroundColor = colorInit;
onClickTd();
loadData();
crearPasos();
loadUltimoMapa();

function crearPasos() {

    for(var i = 0; i < pasos.length; i++){

        var context = pasos[i].getContext('2d');
        var centerX = pasos[i].width / 2;
        var centerY = pasos[i].height / 2;
        var radius = pasos[i].width / 2 - 5;
        context.beginPath();
        context.arc(centerX, centerY, radius, 0, 2 * Math.PI, false);
        if(i === step){
            context.fillStyle = 'white';
        }else if(i < step) {
            context.fillStyle = 'green';
        }else{
            context.fillStyle = 'black';
        }
        context.fill();
        context.lineWidth = 2;
        context.strokeStyle = '#003300';
        context.stroke();

    }

}

btnAplicar.addEventListener("click", function(){

    switch(step){
        case 0:
            if(columns.value.length != 0){
                if(rows.value.length != 0){
                    if(columns.value >= 3 && rows.value >= 3){
                        if(nivelDeZona.value.length != 0){
                            if(nivelDeZona.value > 0){
                                step1();
                                step++;
                                crearPasos();
                            }else{
                                alert("Nivel de zona minimo 1");
                            }
                        }else{
                            alert("Nivel de zona no introducido");
                        }
                    }  else{
                        alert("Los valores minimos para columnas y filas son 3");
                    }
                }else{
                    alert("Numero de filas no introducido");
                }
            }else{
                alert("Numero de columnas no introducido");
            }

            break;
        case 1:
            step2();
            step++;
            crearPasos();
            break;
        default:
            break;

    }



});

btnAtras.addEventListener("click",Atras)

btnAtras2.addEventListener("click",Atras)

function cerrarFormParm()
{
    while (parametrosSelect.firstChild) {
        parametrosSelect.removeChild(parametrosSelect.firstChild);
    }
    parametrosNumberDiv.hidden = false;
    parametrosSelect.hidden = true;
}

btnEnvNumPar.addEventListener("click",function(){
    parametrosNumberDiv.hidden = true;
    parametrosSelect.hidden = false;

    var numParametros = document.getElementById("parametros").value;
    for(var i=0;i<numParametros;i++)
    {
        var tipo = document.createElement("SELECT");
        tipo.setAttribute("class","form-control");
        tipo.setAttribute("name","tipo");
        tipo.setAttribute("id","tipoParm"+i);

        var optionInt = document.createElement("OPTION");
        optionInt.setAttribute("class","form-control");
        optionInt.setAttribute("value","int");

        var optionStr = document.createElement("OPTION");
        optionStr.setAttribute("class","form-control");
        optionStr.setAttribute("value","Str");

        var optionDou = document.createElement("OPTION");
        optionDou.setAttribute("class","form-control");
        optionDou.setAttribute("value","dou");

        var tStr = document.createTextNode("Str");
        var tDou = document.createTextNode("dou");
        var t = document.createTextNode("int");

        optionInt.appendChild(t);
        optionStr.appendChild(tStr);
        optionDou.appendChild(tDou);
        tipo.appendChild(optionInt);
        tipo.appendChild(optionStr);
        tipo.appendChild(optionDou);
        parametrosSelect.appendChild(tipo);
        var valor = document.createElement("INPUT");
        valor.setAttribute("id","prmVal"+i);
        valor.setAttribute("class","form-control");
        valor.setAttribute("value",0);
        parametrosSelect.appendChild(valor);
    }

})

function Atras() {

    switch(step){

        case 2:
            stepBack1();
            step1();
            step--;
            crearPasos();
            break;
        case 1:
            stepBack2();
            step--;
            crearPasos();
            break;
        default:
            break;

    }

}

function onClickTd(){
    for(var i = 0; i < cells.length; i++){
        cells[i].addEventListener("click",function(){
            this.style.backgroundColor = selectedOption;
            this.setAttribute('class','mapCell');
            var numPar = document.getElementById("parametros").value;
            if(parametrosSelect.hidden === false&&numPar>0)
            {
                this.innerHTML = "";

                for(var p=0;p<numPar;p++)
                {
                    var ch1 = document.getElementById("tipoParm"+p);
                    ch1.setAttribute("hidden","true");
                    this.appendChild(ch1);

                    var ch2 = document.getElementById("prmVal"+p);
                    ch2.setAttribute("hidden","true");
                    this.appendChild(ch2);
                }
                //this.innerHTML = args;
            }
            cerrarFormParm();
        });
    }
}

function loadData(){
    loadJSON("/myapp/user/getCeldasEncontrables",gotData)
}

function gotData(data){

    var i = 1;

    data.forEach(function(element){
        var newCelda = document.createElement("span");
        newCelda.style.backgroundColor = element.image;
        newCelda.setAttribute("class",'celda');
        selectBtn.appendChild(newCelda);

        selectCell();


        var newCelda = document.createElement("span");
        newCelda.setAttribute("class",'celda');
        selectBtn.appendChild(newCelda);

        i++;

    });
    var separador = document.createElement("div");
    separador.setAttribute("class",'separador');
    selectBtn.appendChild(separador);


    listaCeldasJSON = data;
    celdas = document.getElementsByClassName("celda");

}

function loadJSON(path, success, error)
{
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                if (success)
                    success(JSON.parse(xhr.responseText));
            } else {
                if (error)
                    error(xhr);
            }
        }
    };
    xhr.open("GET", path, true);
    xhr.send();
}

function selectCell(){
    var opciones = document.getElementsByClassName('celda')
    for(var i = 0; i < opciones.length; i = i+2){
            opciones[i].addEventListener("click",function(){

                for(var i = 0; i < opciones.length; i++){
                    opciones[i].removeAttribute('id');
                }

                selectedOption = this.style.backgroundColor;
                this.setAttribute('id','select');
            })
    }
}

function loadUltimoMapa(){

    loadJSON("/myapp/web/creadorMapas/ultimoMapa",gotMapa)

}

function gotMapa(data) {

    ultimoMapa = data.nombre;

}

function crearInOutCelda() {

    var columns = document.getElementById("columns")

    celdaIn = {

        "tipo": "CeldaCambioEscenario",
        "numArgs": 3,
        "args": "{\"Str0\": \"" + ultimoMapa + "\", \"int1\": " + (inRow.value-1) +", \"int2\": 0}",
        "image": null

    }

    celdaOut = {

        "tipo": "CeldaCambioEscenario",
        "numArgs": 3,
        "args": "{\"Str0\": \"" + (ultimoMapa+2) + "\", \"int1\": "+  (outRow.value-1) +", \"int2\":" + columns.value + "}",
        "image": null

    }

}

function creadorResultado(){

    crearInOutCelda();

    mapaResultado = {
                        'ancho' : mapa.rows[0].cells.length - 1,
                        'alto' : mapa.rows.length - 1,
                        'nombre' : "Escenario "+ (parseInt(ultimoMapa.substring(9,10)) + 1),
                        'nivelDeZona' : nivelDeZona.value,
                        'celdaJSON' : [],
                    };

    var i = 0;
    for(var k = 1; k < mapa.rows.length; k++){
        var row = [];
        for(var j = 1; j<mapa.rows[0].cells.length; j++){
        var image = cells[i].style.backgroundColor;
            if(j === 1 && k == inRow.value){

                row.push(celdaIn);
                i++;

            }else if(j === (mapa.rows[0].cells.length-1) && k == outRow.value) {

                row.push(celdaOut);
                i++;

            }else{
                listaCeldasJSON.forEach(function (element) {

                    if (image === element.image) {
                        if(cells[i].childNodes.length>0)
                        {
                            var args = "{";
                                for(var p=0;p<cells[i].childNodes.length-1;p+=2)
                                {
                                    args +="\"";
                                    args += cells[i].childNodes[p].value+p/2;
                                    args +="\":";
                                    if(cells[i].childNodes[p].value==="int")
                                    {
                                        args += cells[i].childNodes[p+1].value;
                                    }
                                    if(cells[i].childNodes[p].value==="dou")
                                    {
                                        args += cells[i].childNodes[p+1].value;
                                    }
                                    if(cells[i].childNodes[p].value==="Str")
                                    {
                                        args += "\""+cells[i].childNodes[p+1].value+"\"";
                                    }
                                    if(p<cells[i].childNodes.length-2)
                                    {
                                        args += ","
                                    }
                                }
                                args += "}";
                            var celdaTmp = {
                                "tipo" : element.tipo,
                                "args" : args,
                                "numArgs" : cells[i].childNodes.length/2
                            }
                            row.push(celdaTmp);
                        }
                        else
                        row.push(element);
                        i++;
                    }

                });
            }

        }
        mapaResultado.celdaJSON.push(row);
    }


}

btnGuardar.addEventListener("click", function(){
    if(inRow.value.length != 0 && outRow.value.length != 0){
        if(parseInt(inRow.value) > 0 && parseInt(outRow.value) > 0 && parseInt(inRow.value) <= parseInt(rows.value) && parseInt(outRow.value) <= parseInt(rows.value)){
            creadorResultado();
            var xhr = new XMLHttpRequest();
            xhr.open(formRes.getAttribute("method"), formRes.getAttribute("action"), true);
            xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
            xhr.send(JSON.stringify(mapaResultado));
            xhr.onreadystatechange = function()
            {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        response = JSON.parse(xhr.responseText);
                        if(response !== "" && response.key === 1){

                            guardarOk();

                        }else{

                            alert("Error al guardar");

                        }
                    }
                }
            };
        }else{
            alert("Valor minimo de filas 1 y maximo " + rows.value);
        }
    }else{
        alert("Falta por introducir la fila de entrada y/o salida");
    }

})

function step1() {

    mapa.innerHTML = "";
    var columns = document.getElementById("columns");
    var rows = document.getElementById("rows");
    for(var i = 0; i <= parseInt(rows.value); i++){

        mapa.insertRow();
        mapa.rows[i].insertCell();
        mapa.rows[i].cells[0].outerHTML = "<th></th>";
        if(i !== 0){
            mapa.rows[i].cells[0].outerHTML = "<th>"+i+"</th>";
        }

        for(var j = 1; j <= parseInt(columns.value); j++){

            mapa.rows[i].insertCell();

            if(i === 0 && j !== 0){
                mapa.rows[i].cells[j].outerHTML = "<th>"+j+"</th>";
            }else{
                mapa.rows[i].cells[j].setAttribute('class','mapCell');
                mapa.rows[i].cells[j].style.backgroundColor = colorInit;
            }

        }
    }
    onClickTd();

    inicioCreador.hidden = true;
    btnAtras.hidden = false;
    mapaStep.hidden = false;
    var widthTableDiv = (parseInt(columns.value)+4)*30 + 20;
    var heigthTableDiv = (parseInt(rows.value)+3)*30;
    var widthTable = (parseInt(columns.value)+1)*30 + 20;
    var heigthTable = (parseInt(rows.value)+1)*30 + 20;
    if(widthTableDiv > 1000){
        infoGrupo[0].style.width = "1000px";
        mapaTabla.style.width = "900px";
    }else {
        infoGrupo[0].style.width = widthTableDiv + "px";
        mapaTabla.style.width = widthTable + "px";
        mapaTabla.style.overflowX = "hidden";
        mapa.style.width = (widthTable - 5) + "px";

    }

    if(heigthTable > 1500){

        infoGrupo[0].style.height = "1500px";
        mapaTabla.style.width = "900px";

    }else {
        infoGrupo[0].style.height = heigthTableDiv + "px";
        mapaTabla.style.overflowY = "hidden";
    }


}

function step2(){

    infoGrupo[0].style.minHeight = "400px";
    infoGrupo[0].style.height = "400px";
    infoGrupo[0].style.width = "450px";
    mapaStep.hidden = true;
    inOut.hidden = false;
    btnAplicar.hidden = true;
    btnAtras.hidden = true;

}

function stepBack2(){

    inicioCreador.hidden = false;
    btnAtras.hidden = true;
    mapaStep.hidden = true;
    infoGrupo[0].style.width = "450px";
    infoGrupo[0].style.height = "400px";

}

function stepBack1() {

    mapaStep.hidden = false;
    inOut.hidden = true;
    btnAplicar.hidden = false;
    btnAtras.hidden = false;

}

function guardarOk() {

    pasosDiv.hidden = true;
    resultadoGuardar.hidden = false;
    inOut.hidden = true;

}
