package eetac.dsa.Servidor.Service;

import eetac.dsa.Servidor.MapUsuarios;
import eetac.dsa.Servidor.Model.jsonpojo.KeyUser;
import eetac.dsa.Servidor.Model.jsonpojo.UsuarioJSON;
import eetac.dsa.Servidor.MundoControlador;
import eetac.dsa.Servidor.Sesion;

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
    public KeyUser registro(UsuarioJSON user)
    {
        //La función registra al usuario y devuelve un codigo
        KeyUser key = new KeyUser();
        if (MapUsuarios.getInstance().Registrarse(user)) {
            MundoControlador.getInstance().addSesion(key.getKey(), new Sesion(new UsuarioJSON("pepito","aaa","a@gmail.com", 1, 1, true), "Escenario1"));
            key.setKey(0);
        }
        else
            key.setKey(-1);
        //key.setKey(0);  //Registro con éxito
        // key.setKey(-1); //No se ha podido registrar
        return key;
    }
}
