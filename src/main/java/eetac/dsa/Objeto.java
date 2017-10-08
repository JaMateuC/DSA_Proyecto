package eetac.dsa;

public abstract class Objeto
{
    private String nombre;
    private String tipo;
    private String descripcion;

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Objeto(String nombre, String descripcion, String tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;

    }

    public abstract void funcion(Personaje personaje);
    public abstract void funcion(Monstruo monstruo);
}
