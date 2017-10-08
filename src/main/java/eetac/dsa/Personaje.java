package eetac.dsa;

import java.awt.*;

/**
 * La clase Personaje otorga los atributos comunes a Usuario y Enenmigo
 */
public abstract class Personaje
{
    private String nombre;
    private String escenario;
    private Point posicion;
    private Lista_Monstruos lista_montruos;
    private Inventario inventario;
    private boolean genero;

    public Personaje(String nombre, String escenario, int x, int y, boolean genero)
    {
        this.nombre = nombre;
        this.escenario = escenario;
        posicion = new Point(x,y);
        this.lista_montruos = new Lista_Monstruos();
        this.inventario = new Inventario();
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEscenario(String escenario) {
        this.escenario = escenario;
    }

    public void setPosicion(int x,int y) {
        this.posicion.setLocation(x,y);
    }

    public String getEscenario() {
        return escenario;
    }

    public Point getPosicion() {
        return posicion;
    }

    public Lista_Monstruos getLista_montruos() {
        return lista_montruos;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public boolean getGenero() {
        return genero;
    }


    public boolean mover(Celda celda,int x,int y)
    {
        if(celda.accion(this))
        {
            this.posicion.setLocation(x,y);
            return true;
        }
        else return false;
    }

}
