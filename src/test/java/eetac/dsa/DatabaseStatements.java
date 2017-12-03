package eetac.dsa;

import eetac.dsa.Servidor.Controlador.Monstruo;
import eetac.dsa.Servidor.Model.jsonpojo.MonstruoJSON;
import eetac.dsa.Servidor.Model.dao.DAO;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class DatabaseStatements {

    MonstruoJSON monstruo;

    @Before
    public void prepareClass(){

        monstruo = new MonstruoJSON("Hierba",100,1,1000);

    }

    @Test
    public void addTest(){

        try{
            monstruo.insertDB();
            monstruo.deleteDB();
            monstruo.selectDB();
            monstruo.updateDB();
        }catch (SQLException e){
            e.getSQLState();
        }

    }

}
