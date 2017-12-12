package eetac.dsa.Servidor;

import eetac.dsa.Flag;
import eetac.dsa.Servidor.Controlador.*;
import eetac.dsa.Servidor.Controlador.Celdas.CeldaCambioEscenario;
import eetac.dsa.Servidor.Model.jsonpojo.EscenarioJSON;
import eetac.dsa.Servidor.Model.jsonpojo.KeyUser;
import eetac.dsa.Servidor.Model.jsonpojo.UsuarioJSON;
import eetac.dsa.Servidor.Model.jsonpojo.resultsserver.ResultCambiarEscenario;
import eetac.dsa.Servidor.Model.jsonpojo.resultsserver.ResultLoginArgs;

import java.util.HashMap;
import java.util.Random;

public class Sesion {
    Escenario escenario;
    Usuario protagonista;
    Monstruo monstruoCombate;

    public Sesion(Usuario protagonista, String nombreEscenario) {
        this.protagonista = protagonista;
        monstruoCombate=null;

        cargarEscenarioFichero(nombreEscenario);
        escenario.getCelda((int)protagonista.getPosicion().getX(),(int)protagonista.getPosicion().getY()).setPersonajeEncima(protagonista);
    }

    public Escenario getEscenario() {
        return escenario;
    }

    public Usuario getProtagonista() {
        return protagonista;
    }

    public ResultCambiarEscenario cambiarEscenario(int x,int y)
    {
        Celda celda = escenario.getCelda(x,y);
        if(celda.getTipo().equals(CeldaCambioEscenario.class.getSimpleName()))
        {
            CeldaCambioEscenario cCE = (CeldaCambioEscenario)celda;
            ResultCambiarEscenario resultCambiarEscenario = new ResultCambiarEscenario();
            resultCambiarEscenario.setPermitido(false);
            cargarEscenarioFichero(cCE.getEscenario());
            resultCambiarEscenario.setX(cCE.getX());
            resultCambiarEscenario.setY(cCE.getY());
            resultCambiarEscenario.setPermitido(true);
            return resultCambiarEscenario;
        }
        ResultCambiarEscenario resultCambiarEscenario = new ResultCambiarEscenario();
        resultCambiarEscenario.setPermitido(false);
        return resultCambiarEscenario;
    }

    public ResultLoginArgs resultLoginArgs() throws Exception
    {
        ResultLoginArgs resultLoginArgs = new ResultLoginArgs();
        EscenarioJSON escenarioJSON = new EscenarioJSON();
        escenarioJSON.fromEscenario(escenario);
        resultLoginArgs.setEscenarioJSON(escenarioJSON);
        UsuarioJSON usuarioJSON = new UsuarioJSON();
        usuarioJSON.fromUsuario(protagonista);
        resultLoginArgs.setUsuarioJSON(usuarioJSON);
        resultLoginArgs.setPermitido(true);
        return resultLoginArgs;
    }


    public boolean cargarEscenarioFichero(String nombre)
    {
        try {
            escenario = CargadorJSON.jsonAEscenario(CargadorJSON.ficheroAJSON("src/main/resources/Escenarios/" + nombre + ".json"));
            //personajesDelEscenario = CargadorJSON.jsonAPersonajes(CargadorJSON.ficheroAJSON("src/main/resources/Escenarios/Personajes"+nombre+".json"));
        }
        catch (Exception e)
        {
            //logger.error("error al cargar un escenario");
            return false;
        }
        return true;
    }
}
