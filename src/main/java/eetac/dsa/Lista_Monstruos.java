package eetac.dsa;

import java.util.Vector;

/**
 * classe que encapsula un vector de monstruos.
 * contiene los metodos necesarios para acceder y quitar los monstruos del inventario del personaje
 */
public class Lista_Monstruos {
    Vector<Monstruo> monstruos;

    public Lista_Monstruos() {
        monstruos = new Vector<Monstruo>();
    }

    public boolean añadirMonstruo(Monstruo monstruo)
    {
        if(monstruos.size()<6)
        {
            monstruos.add(monstruo);
            return true;
        }
        return false;
    }

    /**
     * quita un monstruo a partir del indice
     * @param i indice del monstruo, comienza por 1
     *
     * @return devuelve si la operacion se ha podido completar
     */
    public boolean quitarMonstruoPorPosicion(int i)
    {
        if(monstruos.size()<i)
        {
            monstruos.remove(i-1);
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
     * @param i posicion del monstruo en el inventario, comienza en 1
     * @return
     */
    public Monstruo obtenerMonstruo(int i)
    {
        if(monstruos.size()<i)
        {
            return monstruos.get(i-1);
        }
        return null;
    }
}
