package eetac.dsa.Servidor;

import eetac.dsa.Servidor.Model.jsonpojo.UserLog;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@Path("/auth")
public class AUTHservice
{
    @POST
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    public int login(UserLog user)
    {
        //  A partir de UserLog se consulta la BBDD y devuelve la key de acceso
        if(user.getPassword().equals("123")) { return new Random().nextInt(2048); }
        return -1;
    }
}