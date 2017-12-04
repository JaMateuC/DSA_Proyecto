package eetac.dsa.Servidor.Model.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Properties;

public abstract class DAO {

    private Connection con = null;
    private String nombreUsuario;
    private String password;
    private String dbms;
    private String nombreServidor;
    private String puerto;
    private String dbNombre;

    private static final Logger logger = LogManager.getLogger(DAO.class.getName());

    public void initProperties(){

        this.nombreUsuario = PropertiesDB.getInstance().getText("nombreUsuario");
        this.password = PropertiesDB.getInstance().getText("password");
        this.dbms = PropertiesDB.getInstance().getText("dbms");
        this.nombreServidor = PropertiesDB.getInstance().getText("nombreServidor");
        this.puerto = PropertiesDB.getInstance().getText("puerto");
        this.dbNombre = PropertiesDB.getInstance().getText("dbNombre");

    }

    public void getConnection() throws SQLException {

        initProperties();
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.nombreUsuario);
        connectionProps.put("password", this.password);

        this.con = DriverManager.getConnection(
               "jdbc:" + this.dbms + "://" +
               this.nombreServidor +
               ":" + this.puerto + "/",
               connectionProps);

        logger.info(con.toString());

    }

    /*INSERT STATMENTS*/

    public void insertDB() throws SQLException{

        //getConnection();

        StringBuffer  buffer = new StringBuffer();

        buffer.append("INSERT INTO ");
        buffer.append(this.getClass().getSimpleName());
        buffer.append(" (");

        Field[] fields = ordenarFields();

        for( Field field : fields){
            buffer.append(field.getName()+",");

        }

        buffer.delete(buffer.length()-1,buffer.length());
        buffer.append(") ");
        buffer.append("Values");
        buffer.append(" (");

        Method[] methods = ordenarMethods();

        for(Method method : methods){

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

        logger.info(buffer.toString());

        //Statement st = this.con.createStatement();

        //st.executeQuery(buffer.toString());

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

        logger.info(buffer.toString());

        //Statement st = this.con.createStatement();

        //st.executeQuery(buffer.toString());

    }

    /*SELECT STATMENTS*/

    public void selectDB() throws SQLException{
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

        logger.info(buffer.toString());

        /*Statement st = this.con.createStatement();

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

        }*/

    }

    /*UPDATE STATMENTS*/

    public void updateDB() throws SQLException{

        StringBuffer  buffer = new StringBuffer();

        buffer.append("UPDATE ");
        buffer.append(this.getClass().getSimpleName());
        buffer.append(" SET ");

        Field[] fields = ordenarFields();
        Method[] methods = ordenarMethods();

        for( Field field : fields){

            int fieldIndex = 1;

            Annotation aField = field.getAnnotation(OrderFields.class);
            if (aField != null && aField instanceof OrderFields){
                final OrderFields anotacion = (OrderFields) aField;
                fieldIndex = anotacion.indice();
            }

            buffer.append(field.getName() + " = ");

            for(Method method : methods){



                int methodIndex = 0;

                Annotation aMethod = method.getAnnotation(OrderMethods.class);
                if (aMethod != null && aMethod instanceof OrderMethods){
                    final OrderMethods anotacion = (OrderMethods) aMethod;
                    methodIndex = anotacion.indice();
                }


                if (fieldIndex == methodIndex)
                    try{
                        buffer.append(method.invoke(this,null).toString() + " ");
                        break;
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

            }

        }
        buffer.append(" WHERE ");
        for( Field field : this.getClass().getDeclaredFields()){
            if (field.getName().startsWith("id")){
                buffer.append(field.getName());
                break;
            }
        }

        buffer.append(" = ");

        buffer.append(getIDObject());

        logger.info(buffer.toString());

        //Statement st = this.con.createStatement();

        //st.executeQuery(buffer.toString());

    }

    public String getIDObject(){

        for(Method method : this.getClass().getDeclaredMethods()){
            if (method.getName().startsWith("getId")){
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

    public Field[] ordenarFields(){

        Field[] fields = this.getClass().getDeclaredFields();
        Arrays.sort(fields, new Comparator<Field>() {
            @Override
            public int compare(Field o1, Field o2) {
                OrderFields or1 = o1.getAnnotation(OrderFields.class);
                OrderFields or2 = o2.getAnnotation(OrderFields.class);
                if (or1 != null && or2 != null) {
                    return or1.indice() - or2.indice();
                } else
                if (or1 != null && or2 == null) {
                    return -1;
                } else
                if (or1 == null && or2 != null) {
                    return 1;
                }
                return o1.getName().compareTo(o2.getName());
            }
        });

        return fields;

    }

    public Method[] ordenarMethods(){

        Method[] methods = this.getClass().getDeclaredMethods();
        Arrays.sort(methods, new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                OrderMethods or1 = o1.getAnnotation(OrderMethods.class);
                OrderMethods or2 = o2.getAnnotation(OrderMethods.class);
                if (or1 != null && or2 != null) {
                    return or1.indice() - or2.indice();
                } else
                if (or1 != null && or2 == null) {
                    return -1;
                } else
                if (or1 == null && or2 != null) {
                    return 1;
                }
                return o1.getName().compareTo(o2.getName());
            }
        });

        return methods;

    }

}
