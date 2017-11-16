package eetac.dsa.Servidor.Controlador.Celdas;

import eetac.dsa.Servidor.Controlador.Celda;
import eetac.dsa.Servidor.Controlador.Personaje;

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
