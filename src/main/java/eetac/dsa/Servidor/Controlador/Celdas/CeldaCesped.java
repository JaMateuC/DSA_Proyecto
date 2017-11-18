package eetac.dsa.Servidor.Controlador.Celdas;

import eetac.dsa.Servidor.Controlador.Celda;
import eetac.dsa.Servidor.Controlador.Personaje;
import eetac.dsa.Servidor.Resultado;

public class CeldaCesped extends Celda {
    public CeldaCesped() {
        super("Cesped", 1f, 0.2f, true);
    }

    @Override
    public boolean accionEncima(Personaje personaje, Resultado rel) {
        return false;
    }

    @Override
    public boolean accionActivar(Personaje activador,Resultado rel) {
        return false;
    }
}
