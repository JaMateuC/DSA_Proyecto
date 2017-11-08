package eetac.dsa.Celdas;

import eetac.dsa.Celda;
import eetac.dsa.Mundo;
import eetac.dsa.Personaje;

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
    public boolean accionEncima() {
        if(Mundo.getInstance().getNombrePersonaje().equals(this.getPersonajeEncima().getNombre()))
        {
            Mundo.getInstance().cambiarEscenario(escenario);
        }
        else
            Mundo.getInstance().getPersonajesActivos().remove(this.getPersonajeEncima().getNombre());
        return true;
    }

    @Override
    public boolean accionActivar(Personaje activador) {
        return false;
    }
}
