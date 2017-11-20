package eetac.dsa;

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
    public ResultadoServidor action(@PathParam("username") String userName, int x, int y)
    {
        return MundoControlador.getInstance().getSesion(userName).hacerAccion(x, y);
    }

    @POST
    @Path("/{username}/position")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultadoServidor position(@PathParam("username") String userName, int x, int y)
    {
        return MundoControlador.getInstance().getSesion(userName).mover(x, y);
    }

    @POST
    @Path("/{username}/usarObjeto/monstruo")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultadoServidor useObject(@PathParam("username") String userName, int indexObjeto, int indexMonstruo)
    {
        return MundoControlador.getInstance().getSesion(userName).usarObjetoMonstruo(indexObjeto, indexMonstruo);
    }

    @POST
    @Path("/{username}/usarObjeto/protagonista")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResultadoServidor useObject(@PathParam("username") String userName, int index)
    {
        return MundoControlador.getInstance().getSesion(userName).usarObjetoProtagonista(index);
    }
}