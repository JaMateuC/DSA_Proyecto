package eetac.dsa.Servidor;

import eetac.dsa.Flag;
import eetac.dsa.Servidor.Controlador.Escenario;
import eetac.dsa.Servidor.Controlador.Monstruo;
import eetac.dsa.Servidor.Controlador.Usuario;

import java.awt.*;
import java.util.Vector;

public class Resultado {
    Flag flag; //indica las acciones que tendra que hacer el cliente
    Escenario escenario;//si el flag contiene cargarEscenario, este campo se tiene que llenar
    Point posicion;//si el flag contiene moverProtagonista, este campo se tiene que llenar con la posicion en la que tiene que trasladarse el usuario
    Usuario protagonista; ////si el flag contiene cargarProtagonista, este campo se tiene que llenar con el usuario actual
    Object objeto; ////si el flag contiene añadirObjeto, este campo se tiene que llenar con el objeto que se añadira el cliente
    int indiceObjeto;//si el flag contiene borrarObjeto, este campo se tiene que llenar con el indice del objeto que se borrara
    Monstruo monstruo; //si el flag contiene iniciarCombate, este es el monstruo con el que combatira


    public Monstruo getMonstruo() {
        return monstruo;
    }

    public void setMonstruo(Monstruo monstruo) {
        this.monstruo = monstruo;
    }

    public Flag getFlag() {
        return flag;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }

    public Escenario getEscenario() {
        return escenario;
    }

    public void setEscenario(Escenario escenario) {
        this.escenario = escenario;
    }

    public Point getPosicion() {
        return posicion;
    }

    public void setPosicion(Point posicion) {
        this.posicion = posicion;
    }

    public Usuario getProtagonista() {
        return protagonista;
    }

    public void setProtagonista(Usuario protagonista) {
        this.protagonista = protagonista;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public int getIndiceObjeto() {
        return indiceObjeto;
    }

    public void setIndiceObjeto(int indiceObjeto) {
        this.indiceObjeto = indiceObjeto;
    }
}
