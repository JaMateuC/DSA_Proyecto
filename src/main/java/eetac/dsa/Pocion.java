package eetac.dsa;

public class Pocion extends Objeto
{

    int vida;

    public Pocion(int vida) {
        super("pocion", "perimite recuperar "+vida+" puntos de salud de un monstruo");
        this.vida = vida;
    }

    @Override
    public void funcion(Monstruo monstruo) {
        monstruo.añadirVida(vida);
    }

    @Override
    public void funcion(Personaje personaje) {

    }
}
