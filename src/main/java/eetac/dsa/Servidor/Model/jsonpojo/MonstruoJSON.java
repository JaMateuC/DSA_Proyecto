package eetac.dsa.Servidor.Model.jsonpojo;


import eetac.dsa.Servidor.Model.dao.MonstruoDAO;

public class MonstruoJSON{
    String tipo;
    int experiencia;
    int nivel;
    int vidaActual;
    String nombre;

    public MonstruoJSON() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public MonstruoJSON(String tipo, int experiencia, int nivel, int vidaActual, String nombre) {
        this.tipo = tipo;
        this.experiencia = experiencia;
        this.nivel = nivel;
        this.vidaActual = vidaActual;
        this.nombre = nombre;
    }

    public void parseFromMonstruoDB(MonstruoDAO monstruo){

        this.setExperiencia(monstruo.getExperiencia());
        this.setNivel(monstruo.getNivel());
        this.setTipo(monstruo.getTipo());
        this.setVidaActual(monstruo.getVidaActual());
        this.setNombre(monstruo.getId());
    }

}
