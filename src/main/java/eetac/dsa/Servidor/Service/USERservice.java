package eetac.dsa.Servidor.Service;

import eetac.dsa.Servidor.CargadorJSON;

import eetac.dsa.Servidor.Model.ConsultaDB;

import eetac.dsa.Servidor.Model.jsonpojo.*;
import eetac.dsa.Servidor.Model.jsonpojo.querysclient.*;
import eetac.dsa.Servidor.Model.jsonpojo.resultsserver.ResultCambiarEscenario;
import eetac.dsa.Servidor.Model.jsonpojo.resultsserver.ResultLoginArgs;
import eetac.dsa.Servidor.Model.jsonpojo.resultsserver.ResultadoAceptar;
import eetac.dsa.Servidor.MundoControlador;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Collections;

@Path("/user")
public class USERservice
{
    @GET
    @Path("/profile/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public UsuarioJSON getUsuario(@PathParam("nombre") String nombre)
    {
        //Buscar Usuario por nombre y devolverlo al cliente
        UsuarioJSON user = ConsultaDB.getInstance().getUsuarioBasic(nombre);
        user.setPassword(null);                 //La contraseña no se envia al cliente
        return user;
    }

    @GET
    @Path("/getLoginArgs/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultLoginArgs getLoggingArgs(@PathParam("id") int key)
    {
        try
        {
            return MundoControlador.getInstance().getSesion(key).resultLoginArgs();
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @POST
    @Path("/cambiarEscenario")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ResultCambiarEscenario getCambiarEscenario(QueryCambiarEscenario qCamEsc)
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

    @GET
    @Path("/getMonstruosEncontrables")
    @Produces(MediaType.APPLICATION_JSON)
    public MonstruoJSON[][] getMonstruosEncontrables()
    {
        try
        {
            return CargadorJSON.monstruosEncontrables();
        }

        catch (Exception e)
        {
            return null;
        }
    }

    @GET
    @Path("/getObjetosEncontrables")
    @Produces(MediaType.APPLICATION_JSON)
    public ObjetoJSON[][] getObjetosEncontrables()
    {
        try
        {
            return CargadorJSON.objetosEncontrables();
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
            resultadoAceptar.setPermitido(ConsultaDB.getInstance().updateUserDB(qUpUsuario.getUsuarioJson(),qUpUsuario.getNomEscenari()));

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

        ArrayList<MonstruoJSON> list;
        list = ConsultaDB.getInstance().getMonstruosUsuario(nombre);

            /*if(MapUsuarios.getInstance().getUsuarios().containsKey(nombre))
                return MapUsuarios.getInstance().getUsuarios().get(nombre).getMonstruosl();
            return null;*/

        return list;
    }

    @GET
    @Path("/ranking")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<UsuarioJSON> ranking()
    {
        ArrayList<UsuarioJSON> list;

        list = ConsultaDB.getInstance().getAllUsers();

        //ArrayList<UsuarioJSON> list = new ArrayList<UsuarioJSON>(MapUsuarios.getInstance().getUsuarios().values());
        Collections.sort(list,UsuarioJSON.Productoventascomparator);
        return list;
    }

    @GET
    @Path("/getCeldasEncontrables")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCeldasEncontrables()
    {
        try
        {
            return Response.ok().entity(CargadorJSON.celdasEncontrables()).header("Access-Control-Allow-Origin", "*").build();
        }
        catch (Exception e)
        {
            return null;
        }
    }
}