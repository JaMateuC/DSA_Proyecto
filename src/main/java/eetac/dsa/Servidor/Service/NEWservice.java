package eetac.dsa.Servidor.Service;


import eetac.dsa.Servidor.Model.ConsultaDB;

import eetac.dsa.Servidor.Model.jsonpojo.KeyUser;
import eetac.dsa.Servidor.Model.jsonpojo.UsuarioJSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/new")
public class NEWservice
{
    private static final Logger logger = LogManager.getLogger(NEWservice.class.getName());

    @POST
    @Path("/user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public KeyUser registro(UsuarioJSON user)
    {
        //La función registra al usuario y devuelve un codigo
        KeyUser key = new KeyUser();

        if(ConsultaDB.getInstance().ExistUser(user.getNombre())){
            key.setKey(1);
            logger.error("Id: " + user.getNombre() + " ya existente");
            return key;

        }

        if(ConsultaDB.getInstance().insertUser(user)) {

            key.setKey(0);
            logger.info("Usuario: " + user.getNombre() + " registrado");
            return key;

        }


        key.setKey(-1);
        logger.error("Error en el registro");

        //key.setKey(0);  //Registro con éxito
        // key.setKey(-1); //No se ha podido registrar
        // key.setKey(1); //Usuario ya existente

        return key;



    }
}


