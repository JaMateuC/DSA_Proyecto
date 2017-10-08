package eetac.dsa;

public class Ataque {
    String nombre;
    float multiplicador;

    public Ataque(String nombre, float multiplicador) {
        this.nombre = nombre;
        this.multiplicador = multiplicador;
    }

    public String getNombre() {

        return nombre;
    }

    /**
     * funcion prevista para possibles efectos especiales de un ataque a un enemigo
     * @param enemigo enemigo el cual sera afectado por el extra
     */
    public void extraEnemigo(Monstruo enemigo)
    {

    }

    /**
     * funcion prevista para afectar al atacante
     * @param atacante
     */
    public void extraAtacante(Monstruo atacante)
    {

    }

    public float getMultiplicador() {
        return multiplicador;
    }
}
