package eetac.dsa.Servidor;

import eetac.dsa.Servidor.Model.jsonpojo.EscenarioJSON;
import eetac.dsa.Servidor.Model.jsonpojo.UsuarioJSON;
import eetac.dsa.Servidor.Model.jsonpojo.resultsserver.ResultLoginArgs;

public class Sesion {
    EscenarioJSON escenario;
    UsuarioJSON protagonista;

    public Sesion(UsuarioJSON protagonista, String nombreEscenario) {
        this.protagonista = protagonista;

        cargarEscenarioFichero(nombreEscenario);
    }

    public EscenarioJSON getEscenario() {
        return escenario;
    }

    public UsuarioJSON getProtagonista() {
        return protagonista;
    }

    /*public ResultCambiarEscenario cambiarEscenario(int x,int y)
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
    }*/

    public ResultLoginArgs resultLoginArgs() throws Exception
    {
        ResultLoginArgs resultLoginArgs = new ResultLoginArgs();
        EscenarioJSON escenarioJSON = escenario;
        resultLoginArgs.setEscenarioJSON(escenarioJSON);
        UsuarioJSON usuarioJSON = protagonista;
        resultLoginArgs.setUsuarioJSON(usuarioJSON);
        resultLoginArgs.setPermitido(true);
        return resultLoginArgs;
    }


    public boolean cargarEscenarioFichero(String nombre)
    {
        try {
            //escenario = CargadorJSON.jsonAEscenario(CargadorJSON.ficheroAJSON("src/main/resources/Escenarios/" + nombre + ".json"));
        }
        catch (Exception e)
        {
            //logger.error("error al cargar un escenario");
            return false;
        }
        return true;
    }
}
