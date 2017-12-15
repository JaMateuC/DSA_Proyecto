package eetac.dsa.Servidor;

import java.util.HashMap;

public class MundoControlador {
    HashMap<Integer,Sesion> sesiones;

    static MundoControlador mundoControlador;

    static public MundoControlador getInstance() {
        if(mundoControlador==null)
            mundoControlador = new MundoControlador();
        return mundoControlador;
    }

    private MundoControlador() {
        sesiones = new HashMap<>();
    }

    public Sesion getSesion(int key)
    {
        return sesiones.get(key);
    }

    public void addSesion(int key,Sesion sesion)
    {
        sesiones.put(key,sesion);
    }
}
