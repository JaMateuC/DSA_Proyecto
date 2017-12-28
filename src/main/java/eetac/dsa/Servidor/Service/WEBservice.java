package eetac.dsa.Servidor.Service;

import eetac.dsa.Servidor.Model.ConsultaDB;
import eetac.dsa.Servidor.Model.jsonpojo.UsuarioJSON;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@Path("/web")
public class WEBservice {

    @GET
    @Path("/CreadorMapas")
    @Produces(MediaType.TEXT_HTML)
    public InputStream viewCreadorMapas()
    {

        try {
            File f = new File("src/Web/Creador de mapas.html");
            return new FileInputStream(f);
        }catch (Exception e){
            return null;
        }

    }

    @GET
    @Path("/assets/css")
    public InputStream viewCreadorCss()
    {

        try {
            File f = new File("src/Web/Creador de mapas style.css");
            return new FileInputStream(f);
        }catch (Exception e){
            return null;
        }

    }

    @GET
    @Path("/assets/js")
    public InputStream viewCreadorjs()
    {

        try {
            File f = new File("src/Web/CreadorMapasLogic.js");
            return new FileInputStream(f);
        }catch (Exception e){
            return null;
        }

    }

}
