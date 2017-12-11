package eetac.dsa.Servidor.Service;

import eetac.dsa.Servidor.Model.jsonpojo.KeyLog;
import eetac.dsa.Servidor.Model.jsonpojo.UserLog;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.security.Key;
import java.util.Random;

@Path("/auth")
public class AUTHservice
{
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public KeyLog login(UserLog user)
    {
        //  A partir de UserLog (nombre, password) se consulta la memoria y devuelve la key de acceso

        KeyLog key = new KeyLog();
        if(user.getPassword().equals("123"))    //En el equals va la respuesta de la memoria (password)
        {
            key.setKey(new Random().nextInt(2048));
            return key;
        }

        key.setKey(-1);
        return key;
    }
}