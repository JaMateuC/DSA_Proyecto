package eetac.dsa.Servidor;

import eetac.dsa.Servidor.Controlador.Escenario;
import eetac.dsa.Servidor.Controlador.Personaje;
import eetac.dsa.Servidor.Controlador.Usuario;

import java.util.HashMap;

public class MundoControlador {
    HashMap<String,Sesion> sesiones;

    static MundoControlador mundoControlador;

    static public MundoControlador getInstance() {
        if(mundoControlador==null)
            mundoControlador = new MundoControlador();
        return mundoControlador;
    }

    private MundoControlador() {
        sesiones = new HashMap<>();
    }

    public Sesion getSesion(String nombreusuario)
    {
        return sesiones.get(nombreusuario);
    }
}
