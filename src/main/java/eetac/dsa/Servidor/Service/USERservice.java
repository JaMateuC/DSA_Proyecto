package eetac.dsa.Servidor.Service;

import eetac.dsa.Servidor.MapUsuarios;
import eetac.dsa.Servidor.Model.dao.UsuarioDAO;
import eetac.dsa.Servidor.Model.jsonpojo.MonstruoJSON;
import eetac.dsa.Servidor.Model.jsonpojo.KeyUser;
import eetac.dsa.Servidor.Model.jsonpojo.ResultadoServidorJSON;
import eetac.dsa.Servidor.Model.jsonpojo.UsuarioJSON;
import eetac.dsa.Servidor.Model.jsonpojo.querysclient.*;
import eetac.dsa.Servidor.Model.jsonpojo.resultsserver.ResultCambiarEscenario;
import eetac.dsa.Servidor.Model.jsonpojo.resultsserver.ResultLoginArgs;
import eetac.dsa.Servidor.MundoControlador;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

@Path("/user")
public class USERservice
{
    private static final Logger logger = LogManager.getLogger(USERservice.class.getName());

    private String name;

    @GET
    @Path("/profile/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public UsuarioJSON getUsuario(@PathParam("nombre") String nombre)
    {
        //Buscar Usuario por nombre y devolverlo al cliente
        try {
            UsuarioDAO userD = new UsuarioDAO();
            userD.selectDB(nombre);


            UsuarioJSON user = new UsuarioJSON();
            user.parseFromDB(userD);
            //user.setNombre(nombre);
            user.setPassword(null);                 //La contraseña no se envia al cliente
            user.setEmail(nombre + "@dsa.edu");
            //user.setGenero(true);

            return user;
        }catch (SQLException e){
            return null;                          // TODO: poner otro error
        }


    }

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
    }
*/
    @GET
    @Path("/listamonstruo/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<MonstruoJSON> pruebaandroid(@PathParam("nombre") String nombre) {

        logger.info(nombre);
        if(MapUsuarios.getInstance().getUsuarios().containsKey(nombre))
            return MapUsuarios.getInstance().getUsuarios().get(nombre).getMonstruosl();
        return null;
    }

    @GET
    @Path("/ranking")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<UsuarioJSON> ranking() {

        ArrayList<UsuarioJSON> list = new ArrayList<UsuarioJSON>(MapUsuarios.getInstance().getUsuarios().values());
        Collections.sort(list,UsuarioJSON.Productoventascomparator);
        return list;

    }


}


