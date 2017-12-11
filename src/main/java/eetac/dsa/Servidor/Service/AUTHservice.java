package eetac.dsa.Servidor.Service;

import eetac.dsa.Servidor.Model.jsonpojo.UsuarioJSON;
import org.apache.logging.log4j.LogManager;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@Path("/auth")
public class AUTHservice
{
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(JSONService.class.getName());
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Integer login(UsuarioJSON user)
    {

        if(user.getPassword().equals("123"))    //En el equals va la respuesta de la memoria (password)
        {
            return(new Random().nextInt(2048)+1);
        }

        logger.info(user.getPassword());
        return 0;
    }
}