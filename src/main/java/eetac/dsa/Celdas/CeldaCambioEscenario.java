package eetac.dsa.Celdas;

import eetac.dsa.Celda;
import eetac.dsa.Personaje;

public class CeldaCambioEscenario extends Celda {

    String escenario;
    int x;
    int y;

    public CeldaCambioEscenario(String escenario,int x,int y) {
        super("Cambio de escenario", 0, 0, true);
    }

    @Override
    public boolean accionEncima() {
        this.getPersonajeEncima().setEscenario(escenario);
        this.getPersonajeEncima().setPosicion(x,y);
        return true;
    }

    @Override
    public boolean accionActivar(Personaje activador) {
        return false;
    }
}
