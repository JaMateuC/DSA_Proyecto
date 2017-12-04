package eetac.dsa;

import eetac.dsa.Servidor.Controlador.Monstruo;
import eetac.dsa.Servidor.Model.dao.MonstruoDAO;
import eetac.dsa.Servidor.Model.jsonpojo.MonstruoJSON;
import eetac.dsa.Servidor.Model.dao.DAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

public class DatabaseStatements {

    MonstruoDAO monstruo;
    MonstruoDAO monstruo1;
    MonstruoDAO monstruo3;
    private static final Logger logger = LogManager.getLogger(DAO.class.getName());

    @Before
    public void prepareClass(){

        monstruo = new MonstruoDAO("Primero","Hierba",100,1,1000,"Jaume");
        monstruo1 = new MonstruoDAO("Primero","Fuego",100,1,1000,"Jaume");
        monstruo3 = new MonstruoDAO();

    }

    @Test
    public void addTest(){

        try{
            monstruo.insertDB();
        }catch (SQLException e){
            logger.error(e.getSQLState());
            logger.error(e.getErrorCode());
        }

    }

    @Test
    public void deleteTest(){

        try{
            monstruo.deleteDB();
        }catch (SQLException e){
            e.getSQLState();
        }

    }

    @Test
    public void selectTest(){

        try{
            monstruo3.selectDB("Primero");
        }catch (SQLException e){
            e.getSQLState();
        }

        logger.info(monstruo3.toString());

        assertEquals("Primero",monstruo3.getId());

    }

    @Test
    public  void updateTest(){

        try{
            monstruo1.updateDB();
        }catch (SQLException e){
            e.getSQLState();
        }

    }

}
