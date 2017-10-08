package eetac.dsa;

public class PocionExperiencia extends Objeto{
    public PocionExperiencia(int experienciaExtra) {
        super("Pocion de Experiencia", "añade experiencia a un monstruo dado");
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
