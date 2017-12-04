package eetac.dsa.Servidor.Model.jsonpojo;

import eetac.dsa.Servidor.Controlador.Monstruo;
import eetac.dsa.Servidor.Model.dao.DAO;

public class MonstruoJSON{
    String tipo;
    int experiencia;
    int nivel;
    int vidaActual;

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

    public Monstruo toMonstruo() throws Exception
    {
        Class monstruoClass = Class.forName("eetac.dsa.Servidor.Controlador.Monstruos." + tipo);
        Monstruo monstruo = (Monstruo) monstruoClass.getDeclaredConstructor(int.class, int.class).newInstance((Object) nivel, (Object) experiencia);
        monstruo.setVidaActual(vidaActual);
        return monstruo;
    }

    public void fromMonstruo(Monstruo monstruo){
        this.tipo = monstruo.getClass().getSimpleName();
        this.experiencia = monstruo.getExperiencia();
        this.nivel = monstruo.getNivel();
        this.vidaActual = monstruo.getVidaActual();
    }
}
