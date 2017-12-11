package eetac.dsa.Servidor.Service;

import eetac.dsa.Servidor.Model.jsonpojo.UsuarioJSON;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/new")
public class NEWservice
{
    @POST
    @Path("/user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Integer registro(UsuarioJSON user)
    {
        //La función registra al usuario y devuelve un codigo



        //-1; //No se ha podido registrar
        return 0;


    }
}
