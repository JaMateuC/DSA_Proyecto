package eetac.dsa.Objetos;

import eetac.dsa.Monstruo;
import eetac.dsa.Objeto;
import eetac.dsa.Personaje;

import java.awt.*;

public class PiedraTeleport extends Objeto
{

    private int posicionX;
    private int posicionY;
    private String escenario;

    public PiedraTeleport(String nombre, String descripcion, String tipo, int posicionX, int posicionY, String escenario) {
        super("Piedra de teletransporte", "Teleporta a una posicion neutral deseada", "Teleport");
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.escenario = escenario;
    }

    @Override
    public void funcion(Personaje personaje) {
        personaje.setPosicion(this.posicionX, this.posicionY);
        personaje.setEscenario(escenario);
    }

    @Override
    public void funcion(Monstruo monstruo) {

    }
}
