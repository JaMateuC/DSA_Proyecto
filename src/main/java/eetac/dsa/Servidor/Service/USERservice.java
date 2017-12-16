package eetac.dsa.Servidor.Service;

import eetac.dsa.Servidor.MapUsuarios;
import eetac.dsa.Servidor.Model.ConsultaDB;
import eetac.dsa.Servidor.Model.dao.UsuarioDAO;
import eetac.dsa.Servidor.Model.jsonpojo.MonstruoJSON;
import eetac.dsa.Servidor.Model.jsonpojo.KeyUser;
import eetac.dsa.Servidor.Model.jsonpojo.UsuarioJSON;
import eetac.dsa.Servidor.Model.jsonpojo.querysclient.*;
import eetac.dsa.Servidor.Model.jsonpojo.resultsserver.ResultCambiarEscenario;
import eetac.dsa.Servidor.Model.jsonpojo.resultsserver.ResultLoginArgs;
import eetac.dsa.Servidor.Model.jsonpojo.resultsserver.ResultadoAceptar;
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

            UsuarioJSON user = new UsuarioJSON();

            ConsultaDB.getInstance().getUsuarioBasic(nombre);

            user.setPassword(null);                 //La contraseña no se envia al cliente

            return user;
        }catch (SQLException e){
            return null;                          // TODO: poner otro error
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

    @POST
    @Path("/getEscenario")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultCambiarEscenario getLoggingArgs(QueryCambiarEscenario qCamEsc)
    {
        try
        {
            return MundoControlador.getInstance().getSesion(qCamEsc.getKey()).cambiarEscenario(qCamEsc.getNombre(),qCamEsc.getX(),qCamEsc.getY());
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @POST
    @Path("/updateUsuario")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultadoAceptar updateUsuario(QueryUpdateUsuario qUpUsuario)
    {
        try
        {
            MundoControlador.getInstance().getSesion(qUpUsuario.getKey()).setProtagonista(qUpUsuario.getUsuarioJson());
            ResultadoAceptar resultadoAceptar = new ResultadoAceptar();
            resultadoAceptar.setPermitido(true);
            return resultadoAceptar;
        }
        catch (Exception e)
        {
            ResultadoAceptar resultadoAceptar = new ResultadoAceptar();
            resultadoAceptar.setPermitido(false);
            return resultadoAceptar;
        }
    }

    @GET
    @Path("/listamonstruo/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<MonstruoJSON> pruebaandroid(@PathParam("nombre") String nombre) {

        ArrayList<MonstruoJSON> list = new ArrayList<>();

        try{
            list = ConsultaDB.getInstance().getMonstruosUsuario(nombre);

            /*if(MapUsuarios.getInstance().getUsuarios().containsKey(nombre))
                return MapUsuarios.getInstance().getUsuarios().get(nombre).getMonstruosl();
            return null;*/

        }catch (SQLException e){
            logger.error(e.getErrorCode() + "-" + e.getSQLState()+ ": " + e.getMessage());
        }

        finally {

            return list;

        }

    }

    @GET
    @Path("/ranking")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<UsuarioJSON> ranking() {

        ArrayList<UsuarioJSON> list = new ArrayList<>();

        try{
            list = ConsultaDB.getInstance().getAllUsers();

            //ArrayList<UsuarioJSON> list = new ArrayList<UsuarioJSON>(MapUsuarios.getInstance().getUsuarios().values());
            Collections.sort(list,UsuarioJSON.Productoventascomparator);

        }catch (SQLException e){
            logger.error(e.getErrorCode() + "-" + e.getSQLState()+ ": " + e.getMessage());
        }

        finally {

            return list;

        }

    }


}


