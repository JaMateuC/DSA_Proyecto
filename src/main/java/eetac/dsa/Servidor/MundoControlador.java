package eetac.dsa.Servidor;

import eetac.dsa.Servidor.Model.jsonpojo.MonstruoJSON;
import eetac.dsa.Servidor.Model.jsonpojo.ObjetoJSON;
import eetac.dsa.Servidor.Model.jsonpojo.UsuarioJSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
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

        //dummy session
        UsuarioJSON usuarioJSON = new UsuarioJSON();
        usuarioJSON.setNombre("oscar");
        usuarioJSON.setPassword("oscar");
        usuarioJSON.setEmail("oscar@gmail.com");
        usuarioJSON.setGenero(true);
        usuarioJSON.setX(1);
        usuarioJSON.setY(1);
        ArrayList<MonstruoJSON> monstruoJSONS = new ArrayList<>();
        monstruoJSONS.add(new MonstruoJSON("MonstruoEjemplo",0,3,-1, UUID.randomUUID().toString()));
        usuarioJSON.setMonstruos(monstruoJSONS);
        usuarioJSON.setInventario(new ArrayList<ObjetoJSON>());
        Sesion sesion = new Sesion(usuarioJSON,null);
        sesion.cargarEscenarioFichero("src/main/resources/Escenarios/Escenario1.json");
        sesiones.put(0,sesion);

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
