package eetac.dsa.Servidor.Service;

import eetac.dsa.Servidor.Controlador.Personaje;
import eetac.dsa.Servidor.Controlador.Usuario;
import eetac.dsa.Servidor.MapUsuarios;
import eetac.dsa.Servidor.Model.jsonpojo.KeyUser;
import eetac.dsa.Servidor.Model.jsonpojo.UsuarioJSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@Path("/auth")
public class AUTHservice
{
    private static final Logger logger = LogManager.getLogger(USERservice.class.getName());
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public KeyUser login(UsuarioJSON user)
    {
        logger.info(user.getNombre() + " " + user.getPassword());
        KeyUser key = new KeyUser();
        if(MapUsuarios.getInstance().loggin(user.getNombre(),user.getPassword()))    //En el equals va la respuesta de la memoria (password)
        {
            key.setKey((new Random().nextInt(2048)+1));
            return key;
        }
        key.setKey(0);
        return key;
    }
}