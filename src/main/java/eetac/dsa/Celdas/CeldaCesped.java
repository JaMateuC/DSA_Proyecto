package eetac.dsa.Celdas;

import eetac.dsa.Celda;
import eetac.dsa.Personaje;

public class CeldaCesped extends Celda {
    public CeldaCesped() {
        super("Cesped", 1f, 0.2f, true);
    }

    @Override
    public boolean accionEncima() {
        return false;
    }

    @Override
    public boolean accionActivar(Personaje activador) {
        return false;
    }
}
