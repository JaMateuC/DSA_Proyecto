package eetac.dsa.Servidor.Service;

import eetac.dsa.Servidor.Model.dao.UsuarioDAO;
import eetac.dsa.Servidor.Model.jsonpojo.KeyUser;
import eetac.dsa.Servidor.Model.jsonpojo.UsuarioJSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.Random;

@Path("/auth")
public class AUTHservice
{
    private static final Logger logger = LogManager.getLogger(AUTHservice.class.getName());

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public KeyUser login(UsuarioJSON user)
    {
            KeyUser key = new KeyUser();
            logger.info("asd");

            UsuarioDAO usuarioD = new UsuarioDAO();

            try {
                usuarioD.selectDB(user.getNombre());

                if (usuarioD.getPassword().equals(user.getPassword()))    //En el equals va la respuesta de la memoria (password)
                {
                    key.setKey((new Random().nextInt(2048) + 1));

                    logger.info(key.getKey());

                }
            }catch (SQLException e){
                key.setKey(0);
                logger.info(key.getKey());
            }

            finally {

                return key;

            }
    }
}