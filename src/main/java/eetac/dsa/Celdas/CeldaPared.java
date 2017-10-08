package eetac.dsa.Celdas;

import eetac.dsa.Celda;
import eetac.dsa.Personaje;

public class CeldaPared extends Celda {

    public CeldaPared(String tipo, float probObjeto, float probMonstruo, Boolean andable) {
        super("Pared", 0, 0, false);
    }

    @Override
    public Boolean accionEncima() {
        return null;
    }

    @Override
    public Boolean accionActivar(Personaje activador) {
        return null;
    }
}
