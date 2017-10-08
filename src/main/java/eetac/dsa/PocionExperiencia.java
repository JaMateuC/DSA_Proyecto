package eetac.dsa;

public class PocionExperiencia extends Objeto{
    public PocionExperiencia(String nombre,int experienciaExtra) {
        super(nombre, "añade experiencia a un monstruo dado","Pocion de Experiencia");
        this.experienciaExtra = experienciaExtra;
    }

    int experienciaExtra;

    @Override
    public void funcion(Personaje personaje) {

    }

    @Override
    public void funcion(Monstruo monstruo) {
        monstruo.añadirExperiencia(experienciaExtra);
    }
}
