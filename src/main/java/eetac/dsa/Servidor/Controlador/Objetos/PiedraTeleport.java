package eetac.dsa.Servidor.Controlador.Objetos;

import eetac.dsa.Servidor.Controlador.Monstruo;
import eetac.dsa.Mundo;
import eetac.dsa.Servidor.Controlador.Objeto;
import eetac.dsa.Servidor.Controlador.Personaje;

public class PiedraTeleport extends Objeto
{

    private int posicionX;
    private int posicionY;
    private String escenario;

    public PiedraTeleport(int posicionX, int posicionY, String escenario) {
        super("Piedra de teletransporte", "Teleporta a una posicion neutral deseada", "Teleport");
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.escenario = escenario;
    }

    @OrdenParametro(indice = 0)
    public int getPosicionX() {
        return posicionX;
    }

    @OrdenParametro(indice = 1)
    public int getPosicionY() {
        return posicionY;
    }

    @OrdenParametro(indice = 2)
    public String getEscenario() {
        return escenario;
    }

    @Override
    public void funcion(Personaje personaje) {
        if(personaje.getNombre().equals(Mundo.getInstance().getNombrePersonaje()))
        {
            Mundo.getInstance().cambiarEscenario(escenario);
            personaje.setPosicion(posicionX,posicionY);
        }
        else
            Mundo.getInstance().getPersonajesActivos().remove(personaje.getNombre());
    }

    @Override
    public void funcion(Monstruo monstruo) {

    }
}
