package eetac.dsa.Servidor.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import eetac.dsa.Servidor.Model.ConsultaDB;
import eetac.dsa.Servidor.Model.jsonpojo.EscenarioJSON;
import eetac.dsa.Servidor.Model.jsonpojo.UsuarioJSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.lang.reflect.Type;

@Path("/web")
public class WEBservice {

    private static final Logger logger = LogManager.getLogger(WEBservice.class.getName());

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
            File f = new File("src/Web/Creador de mapas.css");
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
            File f = new File("src/Web/Creador de mapas.js");
            return new FileInputStream(f);
        }catch (Exception e){
            return null;
        }

    }

    @POST
    @Path("/guardarMapa")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public EscenarioJSON guardarMapa(EscenarioJSON newEscenario){

        try {
            String filePath = new File("").getAbsolutePath();
            FileWriter file = new FileWriter(filePath + "/src/main/resources/Escenarios/" + newEscenario.getNombre() + ".json");
            Gson gson = new Gson();
            Type type = new TypeToken<EscenarioJSON>(){}.getType();
            String json = gson.toJson(newEscenario,type);
            file.write(json);
            file.flush();
            file.close();
            return newEscenario;
        }catch(Exception e){

            logger.error("Error: " + e.getMessage());
            return null;

        }

    }
}
