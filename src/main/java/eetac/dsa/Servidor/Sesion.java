package eetac.dsa.Servidor;

import eetac.dsa.Flag;
import eetac.dsa.Servidor.Controlador.*;

import java.util.HashMap;

public class Sesion {
    Escenario escenario;
    Usuario protagonista;
    HashMap<String,Personaje> personajesDelEscenario;

    public Sesion(Usuario protagonista, String nombreEscenario) {
        this.protagonista = protagonista;

        cargarEscenarioFichero(nombreEscenario);
        escenario.getCelda((int)protagonista.getPosicion().getX(),(int)protagonista.getPosicion().getY()).setPersonajeEncima(protagonista);
    }

    public Escenario getEscenario() {
        return escenario;
    }

    public Usuario getProtagonista() {
        return protagonista;
    }


    public HashMap<String, Personaje> getPersonajesDelEscenario() {
        return personajesDelEscenario;
    }


    public Resultado mover(int x,int y)
    {
        Resultado rel = new Resultado();

        protagonista.mover(protagonista.getPosicion().x,protagonista.getPosicion().y,rel);

        return  rel;
    }

    public Resultado usarObjetoProtagonista(int index)
    {
        Resultado rel = new Resultado();
        if(protagonista.getInventario().buscarObjeto(index).getDestino() == Objeto.Destino.Personaje)
        {
            rel.getFlag().addFlag(Flag.borrarObjeto);
            rel.setIndiceObjeto(index);
            protagonista.usarObjeto(index,rel);
        }
        return rel;
    }

    public Resultado hacerAccion(int x,int y)
    {

        return null;
    }

    //public Resultado resultadoCombate()


    public boolean cargarEscenarioFichero(String nombre)
    {
        try {
            escenario = CargadorJSON.jsonAEscenario(CargadorJSON.ficheroAJSON("src/main/resources/Escenarios/" + nombre + ".json"));
            personajesDelEscenario = CargadorJSON.jsonAPersonajes(CargadorJSON.ficheroAJSON("src/main/resources/Escenarios/Personajes"+nombre+".json"));
        }
        catch (Exception e)
        {
            //logger.error("error al cargar un escenario");
            return false;
        }
        for (Personaje p:personajesDelEscenario.values()) {
            escenario.getCelda((int)p.getPosicion().getX(),(int)p.getPosicion().getY()).setPersonajeEncima(p);
        }
        return true;
    }
}
