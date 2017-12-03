package eetac.dsa.Servidor.Model;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.Properties;

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

    public void insertDB() throws SQLException{

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

        Statement st = this.con.createStatement();

        st.executeQuery(buffer.toString());

    }

    /*DELETE STATMENTS*/

    public void deleteDB() throws SQLException{

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

        Statement st = this.con.createStatement();

        st.executeQuery(buffer.toString());

    }

    /*SELECT STATMENTS*/

    public void selectDB() throws SQLException{
        StringBuffer  buffer = new StringBuffer();

        buffer.append("SELECT * FROM ");
        buffer.append(this.getClass().getSimpleName());
        buffer.append(" WHERE ");
        for( Field field : this.getClass().getDeclaredFields()){
            if (field.getName().startsWith("iD")){
                buffer.append(field.getName());
            }
        }

        buffer.append(" = ");

        buffer.append(getIDObject());

        Statement st = this.con.createStatement();

        ResultSet rs = st.executeQuery(buffer.toString());

        while(rs.next()){

            for( Field field : this.getClass().getDeclaredFields()){
                for(Method method : this.getClass().getDeclaredMethods()){
                    String fieldC = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                    if (method.getName().equals("set" + fieldC))
                        try{
                            method.invoke(this,null);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }

                }

            }

        }

    }

    /*UPDATE STATMENTS*/

    public void updateDB() throws SQLException{

        StringBuffer  buffer = new StringBuffer();

        buffer.append("UPDATE ");
        buffer.append(this.getClass().getSimpleName());
        buffer.append(" SET ");
        for( Field field : this.getClass().getDeclaredFields()){
            for(Method method : this.getClass().getDeclaredMethods()){

                buffer.append(field.getName() + " = ");

                String fieldC = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                if (method.getName().equals("get" + fieldC))
                    try{
                        buffer.append(method.invoke(this,null).toString());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

            }

        }
        buffer.append(" WHERE ");
        for( Field field : this.getClass().getDeclaredFields()){
            if (field.getName().startsWith("iD")){
                buffer.append(field.getName());
            }
        }

        buffer.append(getIDObject());

        Statement st = this.con.createStatement();

        st.executeQuery(buffer.toString());

    }

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
