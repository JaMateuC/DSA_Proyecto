package eetac.dsa;

import eetac.dsa.Servidor.Controlador.Objeto;
import eetac.dsa.Servidor.Model.dao.DAO;
import eetac.dsa.Servidor.Model.dao.MonstruoDAO;
import eetac.dsa.Servidor.Model.dao.ObjetoDAO;
import eetac.dsa.Servidor.Model.jsonpojo.MonstruoJSON;
import eetac.dsa.Servidor.Model.jsonpojo.ObjetoJSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class TestParse {

    MonstruoDAO monstruoD;
    MonstruoJSON monstruo;
    ObjetoJSON objeto;
    ObjetoJSON objeto2;
    ObjetoDAO[] listObj;

    private static final Logger logger = LogManager.getLogger(DAO.class.getName());

    @Before
    public void beforeTest(){

        monstruo = new MonstruoJSON("Fuego",0,1,2, "aaa");
        monstruoD = new MonstruoDAO();
        objeto = new ObjetoJSON("")


    }

    @Test
    public void testMonstruo(){

        monstruoD.parseToMonstruo(monstruo);
        logger.info(monstruoD.toString());

    }

}
