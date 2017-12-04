package eetac.dsa;

import eetac.dsa.Servidor.Controlador.Monstruo;
import eetac.dsa.Servidor.Model.dao.MonstruoDAO;
import eetac.dsa.Servidor.Model.jsonpojo.MonstruoJSON;
import eetac.dsa.Servidor.Model.dao.DAO;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class DatabaseStatements {

    MonstruoDAO monstruo;

    @Before
    public void prepareClass(){

        monstruo = new MonstruoDAO("Primero","Hierba",100,1,1000,"Jaume");

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
            monstruo.selectDB();
        }catch (SQLException e){
            e.getSQLState();
        }

    }

    @Test
    public  void updateTest(){

        try{
            monstruo.updateDB();
        }catch (SQLException e){
            e.getSQLState();
        }

    }

}
