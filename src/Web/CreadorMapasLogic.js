var btnAplicar = document.getElementById("Aplicar");
var mapa = document.getElementById("mapa");
var cells = document.getElementsByTagName("td");
var selectBtn = document.getElementById("celdasSelect");
var dataCells;
var selectedOption = 'green';
var cellType = 'Empty';
var listaCeldasJSON;
var mapaResultado;
var btnGuardar = document.getElementById('Guardar');

onClickTd();
loadData();

btnAplicar.addEventListener("click", function(){
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
                    mapa.rows[i].cells[j].setAttribute('class','mapCell')
                }

        }
    }

    onClickTd();

});

function onClickTd(){
    for(var i = 0; i < cells.length; i++){
        cells[i].addEventListener("click",function(){
            this.style.backgroundColor = selectedOption;
            this.setAttribute('class','mapCell');
        });
    }
}

function loadData(){
    loadJSON("/myapp/user/getCeldasEncontrables",gotData)
}

function gotData(data){
    data.forEach(function(element){
        var newCelda = document.createElement("div")
        newCelda.style.backgroundColor = element.image;
        newCelda.setAttribute("class",'celda');
        selectBtn.appendChild(newCelda);

        selectCell();
    })

    listaCeldasJSON = data;



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
    for(var i = 0; i < opciones.length; i++){
            opciones[i].addEventListener("click",function(){

                for(var i = 0; i < opciones.length; i++){
                    opciones[i].removeAttribute('id');
                }

                this.setAttribute('id','select');
                selectedOption = this.style.backgroundColor;

            })
    }
}

function creadorResultado(){
    mapaResultado = '[';
    for(var i = 0; i<cells.length; i++){
        data.forEach(function(element){
            if(cells[i].style.backgroundColor === element.image){
                mapaResultado += element;
            }
        })
    }

    mapaResultado += ']';
}

btnGuardar.addEventListener("click", function(){
    creadorResultado();
})

