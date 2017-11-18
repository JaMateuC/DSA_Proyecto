package eetac.dsa.Servidor.Controlador.Celdas;

import eetac.dsa.Servidor.Controlador.Celda;
import eetac.dsa.Servidor.Controlador.Personaje;
import eetac.dsa.Servidor.Resultado;

public class CeldaPared extends Celda {

    public CeldaPared() {
        super("Pared", 0, 0, false);
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
