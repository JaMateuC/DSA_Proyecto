package eetac.dsa.Servidor;

import eetac.dsa.Servidor.Model.jsonpojo.MonstruoJSON;

import java.util.HashMap;
import java.util.Vector;

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
        monstruosEncontrables = new Vector<>();

    }

    public Sesion getSesion(int key)
    {
        return sesiones.get(key);
    }

    public void addSesion(int key,Sesion sesion)
    {
        sesiones.put(key,sesion);
    }

    public Vector<Vector<MonstruoJSON>> monstruosEncontrables;
}
