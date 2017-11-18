package eetac.dsa.Servidor.Controlador.Celdas;

import eetac.dsa.Flag;
import eetac.dsa.Servidor.Controlador.Celda;
import eetac.dsa.Mundo;
import eetac.dsa.Servidor.Controlador.Personaje;
import eetac.dsa.Servidor.MundoControlador;
import eetac.dsa.Servidor.Resultado;
import eetac.dsa.Servidor.Sesion;

public class CeldaCambioEscenario extends Celda {

    String escenario;
    int x;
    int y;

    public CeldaCambioEscenario(String escenario,int x,int y) {
        super("CambioDeEscenario", 0, 0, true);
        this.x = x;
        this.y = y;
        this.escenario = escenario;
    }

    @Override
    public boolean accionEncima(Personaje personaje, Resultado rel) {
        Sesion sesion = MundoControlador.getInstance().getSesion(personaje.getNombre());

        if(sesion!=null)
        {
            sesion.cargarEscenarioFichero(escenario);
            rel.getFlag().addFlag(Flag.cargarEscenario);
            rel.setEscenario(sesion.getEscenario());
            sesion.getProtagonista().mover(x,y,rel);
            return true;
        }
        return false;
    }

    @Override
    public boolean accionActivar(Personaje activador,Resultado rel) {
        return false;
    }
}
