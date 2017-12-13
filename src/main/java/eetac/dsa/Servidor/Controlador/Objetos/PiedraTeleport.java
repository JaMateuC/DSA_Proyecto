package eetac.dsa.Servidor.Controlador.Objetos;

import eetac.dsa.Flag;
import eetac.dsa.Servidor.Controlador.Monstruo;
import eetac.dsa.Servidor.Controlador.Objeto;
import eetac.dsa.Servidor.Controlador.Personaje;
import eetac.dsa.Servidor.MundoControlador;
import eetac.dsa.Servidor.ResultadoServidor;
import eetac.dsa.Servidor.Sesion;

public class PiedraTeleport extends Objeto
{

    private int posicionX;
    private int posicionY;
    private String escenario;

    public PiedraTeleport(int posicionX, int posicionY, String escenario) {
        super("Piedra de teletransporte", "Teleporta a una posicion neutral deseada", "Teleport",Destino.Personaje);
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
        /*Sesion sesion = MundoControlador.getInstance().getSesion(personaje.getNombre());
        if(sesion!=null)
        {
            sesion.cargarEscenarioFichero(escenario);
            rel.getFlag().addFlag(Flag.cargarEscenario);
            rel.setEscenario(sesion.getEscenario());
            sesion.getProtagonista().mover(posicionX,posicionY,rel);
        }*/
    }

    @Override
    public void funcion(Monstruo monstruo) {

    }
}
