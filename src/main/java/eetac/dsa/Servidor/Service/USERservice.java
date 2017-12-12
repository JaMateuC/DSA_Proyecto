package eetac.dsa.Servidor.Service;

import eetac.dsa.Servidor.Model.jsonpojo.KeyUser;
import eetac.dsa.Servidor.Model.jsonpojo.ResultadoServidorJSON;
import eetac.dsa.Servidor.Model.jsonpojo.querysclient.*;
import eetac.dsa.Servidor.Model.jsonpojo.resultsserver.ResultCambiarEscenario;
import eetac.dsa.Servidor.Model.jsonpojo.resultsserver.ResultLoginArgs;
import eetac.dsa.Servidor.MundoControlador;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class USERservice
{
    private static final Logger logger = LogManager.getLogger(USERservice.class.getName());

    private String name;

    @POST
    @Path("/cambiarEscenario")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultCambiarEscenario cambiarEscenario(QueryCambiarEscenario qCE)
    {
        try
        {
            return MundoControlador.getInstance().getSesion(qCE.getKey()).cambiarEscenario(qCE.getX(),qCE.getY());
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @POST
    @Path("/getLogginArgs")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultLoginArgs getLoggingArgs(KeyUser keyUser)
    {
        try
        {
            return MundoControlador.getInstance().getSesion(keyUser.getKey()).resultLoginArgs();
        }
        catch (Exception e)
        {
            return null;
        }
    }


    /*@POST
    @Path("/iniciarCombate")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultadoServidorJSON iniciarCombate(QueryLogging queryLogging)
    {
        try
        {
            return ResultadoServidorJSON.fromResultadoServidorStatic(MundoControlador.getInstance().loggin(queryLogging.getNombre(),queryLogging.getPassword()));
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @POST
    @Path("/resultadoCombate")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultadoServidorJSON resultadoCombate(QueryLogging queryLogging)
    {
        try
        {
            return ResultadoServidorJSON.fromResultadoServidorStatic(MundoControlador.getInstance().loggin(queryLogging.getNombre(),queryLogging.getPassword()));
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @POST
    @Path("/obtenerObjeto")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultadoServidorJSON obtenerObjeto(QueryLogging queryLogging)
    {
        try
        {
            return ResultadoServidorJSON.fromResultadoServidorStatic(MundoControlador.getInstance().loggin(queryLogging.getNombre(),queryLogging.getPassword()));
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @POST
    @Path("/borrarObjeto")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultadoServidorJSON borrarObjeto(QueryLogging queryLogging)
    {
        try
        {
            return ResultadoServidorJSON.fromResultadoServidorStatic(MundoControlador.getInstance().loggin(queryLogging.getNombre(),queryLogging.getPassword()));
        }
        catch (Exception e)
        {
            return null;
        }
    }*/

}
