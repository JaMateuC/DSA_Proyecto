package eetac.dsa;

import eetac.dsa.Servidor.Model.dao.DAO;
import eetac.dsa.Servidor.Model.dao.MonstruoDAO;
import eetac.dsa.Servidor.Model.dao.ObjetoDAO;
import eetac.dsa.Servidor.Model.dao.UsuarioDAO;
import eetac.dsa.Servidor.Model.jsonpojo.MonstruoJSON;
import eetac.dsa.Servidor.Model.jsonpojo.ObjetoJSON;
import eetac.dsa.Servidor.Model.jsonpojo.UsuarioJSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TestParse {

    MonstruoDAO monstruoD;
    MonstruoJSON monstruo;
    MonstruoJSON monstruo2;
    ObjetoJSON objeto;
    ObjetoJSON objeto2;
    UsuarioJSON usuario1;
    ArrayList<ObjetoDAO> listObj;
    ArrayList<MonstruoDAO> listMon;
    UsuarioDAO usuarioD;
    ArrayList<ObjetoJSON> listObjetos;
    ArrayList<MonstruoJSON> listMonstruos;

    private static final Logger logger = LogManager.getLogger(DAO.class.getName());

    @Before
    public void beforeTest(){

        monstruo = new MonstruoJSON("Fuego",0,1,2, "aaa");
        monstruo2 = new MonstruoJSON("Hierba",0,1,2, "bbb");
        monstruoD = new MonstruoDAO();
        usuarioD = new UsuarioDAO();
        objeto = new ObjetoJSON("Pvida","botella","aaa");
        objeto2 = new ObjetoJSON("Pastel","comida","bbb");
        listMonstruos = new ArrayList<>();
        listMonstruos.add(monstruo);
        listMonstruos.add(monstruo2);
        listObjetos = new ArrayList<>();
        listObjetos.add(objeto);
        listObjetos.add(objeto2);
        listObj = new ArrayList<>();
        usuario1 = new UsuarioJSON(listObjetos,listMonstruos,"jaume","aaa","bbb",true);



    }

    @Test
    public void testUsuario(){

        usuarioD.parseToUsuario(usuario1);
        //monstruoD.parseToMonstruo(monstruo);
        //logger.info(monstruoD.toString());
        logger.info(usuarioD.getId() + " " + usuarioD.getPassword());

    }

    @Test
    public void testObjetos(){

        listObj = usuarioD.parseInventario(usuario1);

        for(ObjetoDAO obj: listObj){

            logger.info(obj.toString());

        }


    }

    @Test
    public void testMonstruos(){

        listMon = usuarioD.parseMonstruos(usuario1);

        for(MonstruoDAO mon: listMon){

            logger.info(mon.toString());

        }

    }

}
