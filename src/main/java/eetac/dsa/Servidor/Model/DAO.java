package eetac.dsa.Servidor.Model;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.Properties;
import eetac.dsa.Servidor.Model.PropertiesDB;

public class DAO {

    private Connection con = null;
    private String nombreUsuario;
    private String password;
    private String dbms;
    private String nombreServidor;
    private String puerto;
    private String dbNombre;


    public void initProperties(){

        this.nombreUsuario = PropertiesDB.getInstance().getText("nombreUsuario");
        this.password = PropertiesDB.getInstance().getText("password");
        this.dbms = PropertiesDB.getInstance().getText("dbms");
        this.nombreServidor = PropertiesDB.getInstance().getText("nombreServidor");
        this.puerto = PropertiesDB.getInstance().getText("puerto");
        this.dbNombre = PropertiesDB.getInstance().getText("dbNombre");

    }

    public void getConnection() throws SQLException {

        Properties connectionProps = new Properties();
        connectionProps.put("user", this.nombreUsuario);
        connectionProps.put("password", this.password);

        if (this.dbms.equals("mysql")) {
            this.con = DriverManager.getConnection(
                    "jdbc:" + this.dbms + "://" +
                            this.nombreServidor +
                            ":" + this.puerto + "/",
                    connectionProps);
        } else if (this.dbms.equals("mysql")) {
            this.con = DriverManager.getConnection(
                    "jdbc:" + this.dbms + ":" +
                            this.dbNombre +
                            ";create=true",
                    connectionProps);
        }
    }

    /*INSERT STATMENTS*/

    public void insertDB(){

        StringBuffer  buffer = new StringBuffer();

        buffer.append("INSERT INTO ");
        buffer.append(this.getClass().getSimpleName());
        buffer.append(" (");

        for( Field field : this.getClass().getDeclaredFields()){
            buffer.append(field.getName()+",");

        }

        buffer.delete(buffer.length()-1,buffer.length());
        buffer.append(") ");
        buffer.append("Values");
        buffer.append(" (");
        for(Method method : this.getClass().getDeclaredMethods()){
            if (method.getName().startsWith("get"))
                try{
                    buffer.append(method.invoke(this,null).toString() + ",");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

        }
        buffer.delete(buffer.length()-1,buffer.length());
        buffer.append(") ");

    }

    /*DELETE STATMENTS*/

    public void deleteDB(){

        StringBuffer  buffer = new StringBuffer();

        buffer.append("DELETE FROM ");
        buffer.append(this.getClass().getSimpleName());
        buffer.append(" WHERE ");
        for( Field field : this.getClass().getDeclaredFields()){
            if (field.getName().startsWith("id")){
                buffer.append(field.getName());
            }
        }

        buffer.append(" = ");

        buffer.append(getIDObject());

    }

    /*SELECT STATMENTS*/

    public void selectDB(){
        StringBuffer  buffer = new StringBuffer();

        buffer.append("SELECT * FROM ");
        buffer.append(this.getClass().getSimpleName());
        buffer.append(" WHERE ");
        for( Field field : this.getClass().getDeclaredFields()){
            if (field.getName().startsWith("id")){
                buffer.append(field.getName());
            }
        }

        buffer.append(" = ");

        buffer.append(getIDObject());
    }

    public void selectMonstruoAllInfo(String nombre) throws SQLException{

        PreparedStatement selectMonstruo;

        String monstruoStatment = "SELECT * FROM MONSTRUOS WHERE ID_MONSTRUO = ?";

        selectMonstruo = this.con.prepareStatement(monstruoStatment);

        selectMonstruo.setString(1,nombre);
        ResultSet result = selectMonstruo.executeQuery();

        while (result.next()) {



        }

    }

    /*UPDATE STATMENTS*/

    public String getIDObject(){

        for(Method method : this.getClass().getDeclaredMethods()){
            if (method.getName().startsWith("getID")){
                try{
                    String id = method.invoke(this,null).toString();
                    return id;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        }

        return "";

    }

}
