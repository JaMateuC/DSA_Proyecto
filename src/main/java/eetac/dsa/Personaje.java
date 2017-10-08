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

    public boolean mover(Celda celda,int x,int y)
    {
        if(celda.accion(this))
        {
            this.posicion.setLocation(x,y);
            return true;
        }
        else return false;
    }

    public void hacerAccion(Celda celda)
    {
        celda.accionActivar(this);
    }

    public boolean usarObjetoAMonstruo(int indiceInventario,int indiceMonstruo)
    {
        if(indiceInventario<inventario.obtenerTamaño()&&indiceMonstruo<lista_montruos.getTamaño())
        {
            Objeto obj= inventario.buscarObjeto(indiceInventario);
            obj.funcion(lista_montruos.obtenerMonstruo(indiceMonstruo));
            inventario.quitarObjeto(obj);
            return true;
        }
        return false;
    }

    public boolean usarObjetoAMonstruo(String nombreObjeto,int indiceMonstruo)
    {
        Objeto tmp = inventario.buscarObjetoPorNombre(nombreObjeto);
        if(indiceMonstruo<lista_montruos.getTamaño()&&tmp!=null)
        {
            tmp.funcion(lista_montruos.obtenerMonstruo(indiceMonstruo));
            inventario.quitarObjeto(tmp);
            return true;
        }

        return false;
    }

    public boolean usarObjeto(String nombreObjeto)
    {
        Objeto tmp = inventario.buscarObjetoPorNombre(nombreObjeto);
        if(tmp!=null)
        {
            tmp.funcion(this);
            inventario.quitarObjeto(tmp);
            return true;
        }

        return false;
    }

    public boolean usarObjeto(int indiceInventario)
    {
        if(indiceInventario<inventario.obtenerTamaño())
        {
            Objeto obj= inventario.buscarObjeto(indiceInventario);
            obj.funcion(this);
            inventario.quitarObjeto(obj);
            return true;
        }
        return false;
    }


    public boolean añadirMonstruo(Monstruo monstruo)
    {
        return lista_montruos.añadirMonstruo(monstruo);
    }

    public boolean quitarMonstruo(Monstruo monstruo)
    {
        return lista_montruos.añadirMonstruo(monstruo);
    }

    public Monstruo obtenerMonstruo(int i)
    {
        return lista_montruos.obtenerMonstruo(i);
    }
}
