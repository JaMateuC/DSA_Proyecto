package eetac.dsa.Servidor.Controlador;

import java.util.Vector;

/**
 * classe que encapsula un vector de monstruos.
 * contiene los metodos necesarios para acceder y quitar los monstruos del inventario del personaje
 */
public class Lista_Monstruos {
    Vector<Monstruo> monstruos;

    int maxMonstruos = 6;

    public Lista_Monstruos() {
        monstruos = new Vector<Monstruo>();
    }

    public boolean añadirMonstruo(Monstruo monstruo)
    {
        if(monstruos.size()<maxMonstruos)
        {
            monstruos.add(monstruo);
            return true;
        }
        return false;
    }

    /**
     * quita un monstruo a partir del indice
     * @param i
     *
     * @return devuelve si la operacion se ha podido completar
     */
    public boolean quitarMonstruoPorPosicion(int i)
    {
        if(monstruos.size()>i)
        {
            monstruos.remove(i);
            return true;
        }
        return false;
    }

    public boolean quitarMonstruo(Monstruo monstruo)
    {
        return monstruos.remove(monstruo);
    }

    /**
     * obtiene un monstruo segun su posicion en el inventario
     * @param i posicion del monstruo en el inventario
     * @return
     */
    public Monstruo obtenerMonstruo(int i)
    {
        if(monstruos.size()>i)
        {
            return monstruos.get(i);
        }
        return null;
    }

    public int getTamaño()
    {
        return monstruos.size();
    }
}
