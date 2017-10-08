package eetac.dsa.Celdas;

import eetac.dsa.Celda;
import eetac.dsa.Personaje;

public class CeldaCambioEscenario extends Celda {

    public CeldaCambioEscenario(String tipo, float probObjeto, float probMonstruo, Boolean andable) {
        super("Cambio de escenario", 0, 0, true);
    }

    @Override
    public Boolean accionEncima() {
        return true;
    }

    @Override
    public Boolean accionActivar(Personaje activador) {
        return null;
    }
}
