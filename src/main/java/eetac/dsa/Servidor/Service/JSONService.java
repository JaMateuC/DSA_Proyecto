package eetac.dsa.Servidor.Service;

import eetac.dsa.Servidor.Controlador.Usuario;
import eetac.dsa.Servidor.Model.Testeo;
import eetac.dsa.Servidor.Model.jsonpojo.CeldaJSON;
import eetac.dsa.Servidor.Model.jsonpojo.ResultadoServidorJSON;
import eetac.dsa.Servidor.Model.jsonpojo.UsuarioJSON;
import eetac.dsa.Servidor.Model.jsonpojo.querysclient.*;
import eetac.dsa.Servidor.MundoControlador;
import org.apache.logging.log4j.LogManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.logging.Logger;

@Path("/json")

public class JSONService
{
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(JSONService.class.getName());

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



    //TEST


    @POST
    @Path("/test")
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON)
    public Testeo testeos(Testeo test)
    {
        if(test.getValue().equals("Albert")){  test.setValue("Ok");    }
        else{   test.setValue("NO");    }
        logger.info(test.getValue());
        //return test;

        return test;

    }

    @POST
    @Path("/registro")
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON)
    public UsuarioJSON registro(UsuarioJSON u)
    {
        return  u;

    }

    @POST
    @Path("/hacer2")
    @Consumes(MediaType.APPLICATION_JSON)
    public UsuarioJSON hacerpedido(UsuarioJSON test) {

        //return Response.status(201).entity("hecho").build();
        logger.info("asdsa");
        return test;
    }

    @GET
    @Path("/logtest")
    @Consumes(MediaType.APPLICATION_JSON)
    public Testeo logtest()
    {
        Testeo tst = new Testeo();
        tst.setValue("Hello World");
        return tst;
    }

    @GET
    @Path("/usuario/{nombre}/{pass}")
    @Produces(MediaType.APPLICATION_JSON)
    public UsuarioJSON pruebaandroid(@PathParam("nombre") String nombre, @PathParam("pass") String pass) {

        logger.info("asdsa");
        UsuarioJSON u = new UsuarioJSON();
        u.setEmail(nombre);
        u.setPassword(pass);
        u.setGenero(true);

        return u;

    }

    @POST
    @Path("/usuario2/{nombre}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public UsuarioJSON pruebaandroid2(@PathParam("nombre") String user, String pass) {

        logger.info(user+ " - " +pass);
        UsuarioJSON u = new UsuarioJSON();
        u.setEmail(user);
        u.setPassword(pass);
        u.setGenero(true);

        return u;
    }
}