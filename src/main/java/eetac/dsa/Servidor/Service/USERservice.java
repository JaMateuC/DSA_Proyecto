package eetac.dsa.Servidor.Service;

import eetac.dsa.Servidor.Model.jsonpojo.ResultadoServidorJSON;
import eetac.dsa.Servidor.Model.jsonpojo.querysclient.*;
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
    @Path("/accion")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultadoServidorJSON action(QueryHacerAccion queryHacerAccion)
    {
        try {
            return ResultadoServidorJSON.fromResultadoServidorStatic(
                    MundoControlador.getInstance().getSesion(queryHacerAccion.getUsuario()).hacerAccion(queryHacerAccion.getX(), queryHacerAccion.getY()));
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @POST
    @Path("/mover")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultadoServidorJSON position(QueryMover queryMover) {
        try {
            return ResultadoServidorJSON.fromResultadoServidorStatic(
                    MundoControlador.getInstance().getSesion(queryMover.getUsuario()).mover(queryMover.getX(), queryMover.getY()));
        } catch (Exception e) {
            return null;
        }
    }

    @POST
    @Path("/usarObjeto")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultadoServidorJSON useObject(QueryUsarObjeto queryUsarObjeto)
    {
        try {
            if(!queryUsarObjeto.isObjetivo())
                return ResultadoServidorJSON.fromResultadoServidorStatic(
                        MundoControlador.getInstance().getSesion(queryUsarObjeto.getUsuario()).
                                usarObjetoMonstruo(queryUsarObjeto.getIndice(), queryUsarObjeto.getIndiceMonstruo()));
            return ResultadoServidorJSON.fromResultadoServidorStatic(
                    MundoControlador.getInstance().getSesion(queryUsarObjeto.getUsuario()).
                            usarObjetoProtagonista(queryUsarObjeto.getIndice()));
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @POST
    @Path("/borrar")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultadoServidorJSON borar(QueryBorrar queryBorrar)
    {
        try {
            if(!queryBorrar.isObjetivo())
                return ResultadoServidorJSON.fromResultadoServidorStatic(
                        MundoControlador.getInstance().getSesion(queryBorrar.getUsuario()).borrarMonstruo(queryBorrar.getIndice()));
            return ResultadoServidorJSON.fromResultadoServidorStatic(
                    MundoControlador.getInstance().getSesion(queryBorrar.getUsuario()).borrarObjeto(queryBorrar.getIndice()));
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @POST
    @Path("/logging")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultadoServidorJSON borar(QueryLogging queryLogging)
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

}
