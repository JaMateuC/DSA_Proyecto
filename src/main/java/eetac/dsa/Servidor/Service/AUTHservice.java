package eetac.dsa.Servidor.Service;

import eetac.dsa.Servidor.MapUsuarios;
import eetac.dsa.Servidor.Model.jsonpojo.KeyUser;
import eetac.dsa.Servidor.Model.jsonpojo.UsuarioJSON;
import org.apache.logging.log4j.LogManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@Path("/auth")
public class AUTHservice
{
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public KeyUser login(UsuarioJSON user)
    {
        KeyUser key = new KeyUser();
        if(MapUsuarios.getInstance().loggin(user.getNombre(), user.getPassword()))    //En el equals va la respuesta de la memoria (password)
        {
            key.setKey((new Random().nextInt(2048)+1));
            return key;
        }
        key.setKey(0);
        return key;
    }
}