package eetac.dsa.Servidor.Model.dao;

import eetac.dsa.Servidor.Controlador.Objetos.OrdenParametro;

public class MonstruoDAO extends DAO{

    @OrderFields(indice = 0)
    String id;
    @OrderFields(indice = 1)
    String tipo;
    @OrderFields(indice = 2)
    int experiencia;
    @OrderFields(indice = 3)
    int nivel;
    @OrderFields(indice = 4)
    int vidaActual;
    @OrderFields(indice = 5)
    String nombreUsuario;

    public MonstruoDAO() {
    }

    public MonstruoDAO(String id,String tipo, int experiencia, int nivel, int vidaActual, String nombreUsuario) {
        this.id = id;
        this.tipo = tipo;
        this.experiencia = experiencia;
        this.nivel = nivel;
        this.vidaActual = vidaActual;
        this.nombreUsuario = nombreUsuario;
    }

    @OrderMethods(indice = 0)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @OrderMethods(indice = 1)
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @OrderMethods(indice = 2)
    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    @OrderMethods(indice = 3)
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @OrderMethods(indice = 4)
    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    @OrderMethods(indice = 5)
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
