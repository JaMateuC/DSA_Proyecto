package eetac.dsa.Servidor.Controlador.Celdas;

import eetac.dsa.Servidor.Controlador.Celda;
import eetac.dsa.Servidor.Controlador.Personaje;
import eetac.dsa.Servidor.ResultadoServidor;

public class CeldaCesped extends Celda {
    public CeldaCesped() {
        super(CeldaCesped.class.getSimpleName(), 1f, 0.2f, true);
    }

    @Override
    public boolean accionEncima(Personaje personaje, ResultadoServidor rel) {
        return false;
    }

    @Override
    public boolean accionActivar(Personaje activador,ResultadoServidor rel) {
        return false;
    }
}
