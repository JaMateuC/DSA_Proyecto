package eetac.dsa.Servidor;

import eetac.dsa.Servidor.Model.jsonpojo.EscenarioJSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;

public class CargadorJSON {
    private static final Logger logger = LogManager.getLogger(EscenarioJSON.class.getName());

    public static EscenarioJSON fileToEscenario(String direccion)throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        EscenarioJSON escenarioJSON =mapper.readValue(new File(direccion), EscenarioJSON.class);
        return escenarioJSON;
    }

    public static void EscenariotoFile(String direccion,EscenarioJSON escenarioJSON)throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(direccion), escenarioJSON);
    }
}