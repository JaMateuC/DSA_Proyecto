package eetac.dsa.Servidor.Model.dao;

import eetac.dsa.Servidor.Controlador.Objetos.OrdenParametro;

public class ObjetoDAO extends DAO{

    @OrderFields(indice = 0)
    String tipo;
    @OrderFields(indice = 1)
    String extra;
    @OrderFields(indice = 2)
    String nombreUsuario;

    public ObjetoDAO() { }

    @OrderMethods(indice = 0)
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @OrderMethods(indice = 1)
    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @OrderMethods(indice = 2)
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

}
