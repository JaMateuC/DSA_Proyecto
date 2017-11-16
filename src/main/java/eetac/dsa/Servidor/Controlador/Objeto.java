package eetac.dsa.Servidor.Controlador;

public abstract class Objeto
{
    private String nombre;
    private String tipo;
    private String descripcion;

    public Objeto(String nombre, String descripcion, String tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public abstract void funcion(Personaje personaje);
    public abstract void funcion(Monstruo monstruo);
}
