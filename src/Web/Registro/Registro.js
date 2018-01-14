var nickName = document.getElementById("InputNickName");
var password = document.getElementById("InputPassword");
var repetirPassword = document.getElementById("InputRepetirPassword");
var email = document.getElementById("InputEmail");
var isHombre = document.getElementById("radio1");
var isMujer = document.getElementById("radio2");
var btnRegistrar = document.getElementById("Registrar");
var usuarios;
var nicknameCorrecto;

isHombre.checked = true;


nickName.addEventListener('click',function () {


    nickName.classList.add('cross');

})

nickName.addEventListener('onkeyup',function () {

    loadUsuarios(nickName.value);
    nicknameCorrecto = nickName.value;

})

btnRegistrar.addEventListener("click", function(){


    if(nicknameCorrecto){

        if(passwordCorrecta()){

            usaurioRegistrar = {
                "nombre": nicknameCorrecto,
                "password": password.value,
                "email": email.value,
                "genero": genero()
            }

            var xhr = new XMLHttpRequest();
            xhr.open(formRes.method, formRes.action, true);
            xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
            xhr.send(JSON.stringify(usaurioRegistrar));

        }else{

        }

    }else{

    }




})



var nicknameExist = function(){


}

function loadUsuarios(usuario){
    loadJSON("/myapp/web/usuarioExsistente/"+usuario,gotData)
}

function gotData(data){

    usuarios = data;

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

var passwordCorrecta = function () {

    if(password.value === repetirPassword.value){
        return true;
    }

    return false;

}

var genero = function () {

    if(isHombre.checked){

        return true;

    }

    return false;

}

