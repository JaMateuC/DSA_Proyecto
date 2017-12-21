package eetac.dsa.Servidor.Model.jsonpojo.querysclient;

import eetac.dsa.Servidor.Model.jsonpojo.UsuarioJSON;

public class QueryUpdateUsuario {
    int key;
    UsuarioJSON usuarioJson;
    String nomEscenarip;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public UsuarioJSON getUsuarioJson() {
        return usuarioJson;
    }

    public void setUsuarioJson(UsuarioJSON usuarioJson) {
        this.usuarioJson = usuarioJson;
    }

    public String getNomEscenarip() {
        return nomEscenarip;
    }

    public void setNomEscenarip(String nomEscenarip) {
        this.nomEscenarip = nomEscenarip;
    }
}
