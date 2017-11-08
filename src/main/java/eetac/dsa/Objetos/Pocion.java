package eetac.dsa.Objetos;

import eetac.dsa.Monstruo;
import eetac.dsa.Objeto;
import eetac.dsa.Personaje;

public class Pocion extends Objeto
{

    int vida;

    public Pocion(String nombre,int vida) {
        super(nombre, "perimite recuperar "+vida+" puntos de salud de un monstruo","Pocion");
        this.vida = vida;
    }


    @OrdenParametro(indice = 1)
    public int getVida() {
        return vida;
    }

    @Override
    @OrdenParametro(indice=0)
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public void funcion(Monstruo monstruo) {
        monstruo.añadirVida(vida);
    }

    @Override
    public void funcion(Personaje personaje) {

    }
}
