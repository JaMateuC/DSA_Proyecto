package eetac.dsa.Servidor.Service;

import eetac.dsa.Servidor.Model.jsonpojo.KeyUser;
import eetac.dsa.Servidor.Model.jsonpojo.UserNew;

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
    @Produces(MediaType.APPLICATION_JSON)
    public KeyUser registro(UserNew user)
    {
        //La función registra al usuario y devuelve un codigo

        KeyUser key = new KeyUser();
        key.setKey(0);  //Registro con éxito
        //key.setKey(-1); //No se ha podido registrar
        return key;
    }
}
