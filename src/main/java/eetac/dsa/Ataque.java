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

    public float getMultiplicador() {
        return multiplicador;
    }
}
