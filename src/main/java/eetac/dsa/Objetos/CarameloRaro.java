package eetac.dsa.Objetos;

import eetac.dsa.Monstruo;
import eetac.dsa.Objeto;
import eetac.dsa.Personaje;

public class CarameloRaro extends Objeto{

    public CarameloRaro() {
        super("Caramelo Raro","Sube al monstruo 1 nivel", "Caramelo");
    }

    @Override
    public void funcion(Personaje personaje) {

    }

    @Override
    public void funcion(Monstruo monstruo) {
        monstruo.setNivel(monstruo.getNivel()+1);
    }
}
