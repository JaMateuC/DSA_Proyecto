package eetac.dsa.Servidor;

import eetac.dsa.Servidor.Model.jsonpojo.ResultadoServidorJSON;
import eetac.dsa.Servidor.MundoControlador;
import eetac.dsa.Servidor.ResultadoServidor;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/json")

public class JSONService
{
    @POST
    @Path("/{username}/action")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultadoServidorJSON action(@PathParam("username") String userName, int x, int y)
    {
        try {
            return ResultadoServidorJSON.fromResultadoServidorStatic(MundoControlador.getInstance().getSesion(userName).hacerAccion(x, y));
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @POST
    @Path("/{username}/position")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultadoServidorJSON position(@PathParam("username") String userName, int x, int y) {
        try {
            return ResultadoServidorJSON.fromResultadoServidorStatic(MundoControlador.getInstance().getSesion(userName).mover(x, y));
        } catch (Exception e) {
            return null;
        }
    }

    @POST
    @Path("/{username}/usarObjeto/monstruo")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultadoServidorJSON useObject(@PathParam("username") String userName, int indexObjeto, int indexMonstruo)
    {
        try {
            return ResultadoServidorJSON.fromResultadoServidorStatic(MundoControlador.getInstance().getSesion(userName).usarObjetoMonstruo(indexObjeto, indexMonstruo));
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @POST
    @Path("/{username}/usarObjeto/protagonista")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultadoServidorJSON useObject(@PathParam("username") String userName, int index)
    {
        try {
            return ResultadoServidorJSON.fromResultadoServidorStatic(MundoControlador.getInstance().getSesion(userName).usarObjetoProtagonista(index));
        }
        catch (Exception e)
        {
            return null;
        }
    }

}