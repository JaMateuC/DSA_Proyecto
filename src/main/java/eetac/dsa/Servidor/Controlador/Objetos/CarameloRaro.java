package eetac.dsa.Servidor.Controlador.Objetos;

import eetac.dsa.Servidor.Controlador.Monstruo;
import eetac.dsa.Servidor.Controlador.Objeto;
import eetac.dsa.Servidor.Controlador.Personaje;
import eetac.dsa.Servidor.ResultadoServidor;

public class CarameloRaro extends Objeto{

    public CarameloRaro() {
        super("Caramelo Raro","Sube al monstruo 1 nivel", "Caramelo",Destino.Monstruo);
    }

    @Override
    public void funcion(Personaje personaje) {

    }

    @Override
    public void funcion(Monstruo monstruo) {
        monstruo.setNivel(monstruo.getNivel()+1);
    }
}
