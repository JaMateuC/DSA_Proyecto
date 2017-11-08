package eetac.dsa;

import eetac.dsa.Excepciones.CargarDeJsonException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;

public class Mundo {

    private static final Logger logger = LogManager.getLogger(Mundo.class.getName());

    Escenario escenario;
    HashMap<String,Personaje> personajesActivos;
    String nombrePersonaje;
    Personaje protagonista;

    private static Mundo mundo;

    private Mundo() {
        personajesActivos = new HashMap<String, Personaje>();
    }

    public static Mundo getInstance()
    {
        if(mundo==null)
            mundo = new Mundo();
        return mundo;
    }

    public HashMap<String, Personaje> getPersonajesActivos() {
        return personajesActivos;
    }

    public void setPersonajesActivos(HashMap<String, Personaje> personajesActivos) {
        this.personajesActivos = personajesActivos;
    }

    public Escenario getEscenario() {
        return escenario;
    }

    public String getNombrePersonaje() {
        return nombrePersonaje;
    }

    public Personaje getProtagonista(){return personajesActivos.get(nombrePersonaje);}

    public void setNombrePersonaje(String nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
        protagonista = getProtagonista();
    }

    private void cargarDeFichero(String nombre)
    {
        try {
            escenario = CargadorJSON.jsonAEscenario(CargadorJSON.ficheroAJSON("src/main/resources/Escenarios/" + nombre + ".json"));
            personajesActivos = CargadorJSON.jsonAPersonajes(CargadorJSON.ficheroAJSON("src/main/resources/Escenarios/Personajes"+nombre+".json"));
        }
        catch (Exception e)
        {
            //logger.error("error al cargar un escenario");
        }
        for (Personaje p:personajesActivos.values()) {
            escenario.getCelda((int)p.getPosicion().getX(),(int)p.getPosicion().getY()).setPersonajeEncima(p);
        }
    }

    public void cambiarEscenario(String nombre)
    {
        cargarDeFichero(nombre);
        personajesActivos.put(nombrePersonaje,protagonista);
    }

}
