package eetac.dsa.Servidor.Controlador.Objetos;

import eetac.dsa.Servidor.Controlador.Monstruo;
import eetac.dsa.Servidor.Controlador.Objeto;
import eetac.dsa.Servidor.Controlador.Personaje;
import eetac.dsa.Servidor.Resultado;

public class CarameloRaro extends Objeto{

    public CarameloRaro() {
        super("Caramelo Raro","Sube al monstruo 1 nivel", "Caramelo",Destino.Monstruo);
    }

    @Override
    public void funcion(Personaje personaje, Resultado rel) {

    }

    @Override
    public void funcion(Monstruo monstruo, Resultado rel) {
        monstruo.setNivel(monstruo.getNivel()+1);
    }
}
