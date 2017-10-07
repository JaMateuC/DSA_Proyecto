package eetac.dsa;

import java.util.Vector;

public class Lista_Ataques {
    Vector<Ataque> lista_ataques;
    int maxAtaques = 4;

    public Lista_Ataques() {
        lista_ataques = new Vector<Ataque>();
    }

    public Boolean añadirAtaque(Ataque ataque)
    {
        if(lista_ataques.size()<maxAtaques)
        {
            lista_ataques.add(ataque);
            return true;
        }
        return false;
    }

    /**
     * devuelve el ataque en la posicion i, si no existe devuelve null;
     * @param i
     * @return
     */
    public Ataque getAtaque(int i)
    {
        if(i<lista_ataques.size())
        {
            return lista_ataques.get(i);
        }
        return null;
    }

    public int getNumeroAtaques()
    {
        return lista_ataques.size();
    }
}
