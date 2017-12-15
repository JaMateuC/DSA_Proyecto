package eetac.dsa.Servidor;

import eetac.dsa.Servidor.Model.jsonpojo.EscenarioJSON;
import eetac.dsa.Servidor.Model.jsonpojo.UsuarioJSON;
import eetac.dsa.Servidor.Model.jsonpojo.resultsserver.ResultLoginArgs;

public class Sesion {
    EscenarioJSON escenario;
    UsuarioJSON protagonista;

    public Sesion(UsuarioJSON protagonista, String nombreEscenario) {
        this.protagonista = protagonista;
        //TODO: Es te que buscar un escenari a partir del seu nom i llavors obtindre la seva dirrecio
        cargarEscenarioFichero(nombreEscenario/*aqui aniria la direccio del fitcher*/ );
    }

    public EscenarioJSON getEscenario() {
        return escenario;
    }

    public UsuarioJSON getProtagonista() {
        return protagonista;
    }


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


    public boolean cargarEscenarioFichero(String direccion)
    {
        try {
            escenario = CargadorJSON.fileToEscenario(direccion);
        }
        catch (Exception e)
        {
            //logger.error("error al cargar un escenario");
            return false;
        }
        return true;
    }
}
