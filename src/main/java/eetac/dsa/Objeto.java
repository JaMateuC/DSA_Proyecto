package eetac.dsa;

public abstract class Objeto
{
    private String nombre;
    private String descripcion;

    public Objeto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public abstract void funcion(Personaje personaje);
    public abstract void funcion(Monstruo monstruo);
}
