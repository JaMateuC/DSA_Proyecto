package eetac.dsa.Servidor.Service;

import eetac.dsa.Servidor.Model.ConsultaDB;
import eetac.dsa.Servidor.Model.dao.UsuarioDAO;
import eetac.dsa.Servidor.Model.jsonpojo.KeyUser;
import eetac.dsa.Servidor.Model.jsonpojo.UsuarioJSON;
import eetac.dsa.Servidor.MundoControlador;
import eetac.dsa.Servidor.Sesion;
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
        UsuarioJSON userExistente = ConsultaDB.getInstance().getUsuarioEntero(user.getNombre());

        if (userExistente.getPassword().equals(user.getPassword()))    //En el equals va la respuesta de la memoria (password)
        {
            if(MundoControlador.getInstance().UsuarioYaLoggeado(user))
            {
                key.setKey(-1);  //Usuario ya loggeado
            }

            else
            {
                user = userExistente;
                key.setKey((new Random().nextInt(2048) + 1));
                MundoControlador.getInstance().addSesion(key.getKey(), new Sesion(user));
            }
        }
        else{ key.setKey(0); }
        logger.info(key.getKey());
        return key;
    }

    @GET
    @Path("/logout/{key}")
    @Produces(MediaType.APPLICATION_JSON)
    public String logout(@PathParam("key") int key)
    {

        if(MundoControlador.getInstance().closeSession(key)){

            return "{\"Result\" : \"OK\"}";
        }else{
            return "{\"Result\" : \"Error\"}";
        }

    }



}