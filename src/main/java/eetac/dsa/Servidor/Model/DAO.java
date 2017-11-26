package eetac.dsa.Servidor.Model;

import eetac.dsa.Servidor.Controlador.*;

import java.sql.*;
import java.util.Properties;

public class DAO {

    private Connection con = null;
    private String nombreUsuario = "";
    private String password = "";
    private String dbms = "mysql";
    private String nombreServidor = "localhost";
    private String puerto = "8060";
    private String dbNombre = "";

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
        } else if (this.dbms.equals("derby")) {
            this.con = DriverManager.getConnection(
                    "jdbc:" + this.dbms + ":" +
                            this.dbNombre +
                            ";create=true",
                    connectionProps);
        }
    }

    /*INSERT STATMENTS*/

    public void addUsuarioNuevo(Usuario usuario) throws SQLException{

        PreparedStatement addUsuarioN;

        String usuarioStatment = "INSERT INTO USUARIOS VALUES (?,?,?,?,?,?)";

        addUsuarioN = this.con.prepareStatement(usuarioStatment);

        addUsuarioN.setString(1,usuario.getNombre());
        addUsuarioN.setString(2,usuario.getPassword());
        addUsuarioN.setString(3,usuario.getEmail());
        addUsuarioN.setBoolean(4,usuario.getGenero());
        addUsuarioN.setDouble(5,usuario.getPosicion().getX());
        addUsuarioN.setDouble(6,usuario.getPosicion().getY());
        addUsuarioN.executeUpdate();

    }

    public void addMosntruoNuevo(Monstruo monstruo) throws SQLException{

        PreparedStatement addMonstruoN;

        String monstruoStatment = "INSERT INTO MONSTRUO VALUES (?,?,?,?,?,?,?,?,?)";

        addMonstruoN = this.con.prepareStatement(monstruoStatment);

        addMonstruoN.setString(1,monstruo.getIdMonstruo());
        addMonstruoN.setInt(2,monstruo.getNivel());
        addMonstruoN.setInt(3,monstruo.getExperiencia());
        addMonstruoN.setInt(4,monstruo.getVidaBase());
        addMonstruoN.setInt(5,monstruo.getAtaqueBase());
        addMonstruoN.setInt(6,monstruo.getDefensaBase());
        addMonstruoN.setInt(7,monstruo.getExperienciaBase());
        addMonstruoN.setInt(8,monstruo.getVidaActual());
        addMonstruoN.setString(9,monstruo.getTipo());
        addMonstruoN.executeUpdate();

    }

    public void addRelacionObjetos(Usuario usuario, Objeto objeto) throws SQLException{

        PreparedStatement addRelacionObjeto;

        String objetoStatment = "INSERT INTO INVENTARIO VALUES (?,?,?)";

        addRelacionObjeto = this.con.prepareStatement(objetoStatment);

        addRelacionObjeto.setString(1,usuario.getNombre());
        addRelacionObjeto.setString(2,objeto.getNombre());
        addRelacionObjeto.setInt(3,usuario.getInventario().buscarObjetoPorNombre(objeto.getNombre()).getNumPropiedad());
        addRelacionObjeto.executeUpdate();

    }

    public void addRelacionAtaque(Monstruo monstruo, Ataque ataque) throws SQLException{

        PreparedStatement addRelacionAtaque;

        String ataqueStatment = "INSERT INTO LISTAQTAQUES VALUES (?,?)";

        addRelacionAtaque = this.con.prepareStatement(ataqueStatment);

        addRelacionAtaque.setString(1,monstruo.getIdMonstruo());
        addRelacionAtaque.setString(2,ataque.getNombre());
        addRelacionAtaque.executeUpdate();

    }

    public void addRelacionMonstruo(Usuario usuario, Monstruo monstruo) throws SQLException {

        PreparedStatement addRelacionAtaque;

        String ataqueStatment = "INSERT INTO LISTMONSTRUOSUSUARIOS VALUES (?,?)";

        addRelacionAtaque = this.con.prepareStatement(ataqueStatment);

        addRelacionAtaque.setString(2, monstruo.getIdMonstruo());
        addRelacionAtaque.setString(1, usuario.getNombre());
        addRelacionAtaque.executeUpdate();
    }

    /*DELETE STATMENTS*/

    public void dropUsuario(Usuario usuario) throws SQLException{

        PreparedStatement dropUsuario;

        String usuarioStatment = "DELETE FROM USUARIOS WHERE ID_USUARIO = ?";

        dropUsuario = this.con.prepareStatement(usuarioStatment);

        dropUsuario.setString(1,usuario.getNombre());
        dropUsuario.executeUpdate();

    }

    public void dropMosntruo(Monstruo monstruo) throws SQLException{

        PreparedStatement dropMonstruo;

        String monstruoStatment = "DELETE FROM MONSTRUOS WHERE ID_MONSTRUO = ?";

        dropMonstruo = this.con.prepareStatement(monstruoStatment);

        dropMonstruo.setString(1,monstruo.getIdMonstruo());
        dropMonstruo.executeUpdate();

    }

    public void dropRelacionObjetos(Usuario usuario, Objeto objeto) throws SQLException{

        PreparedStatement dropRelacionObjeto;

        String objetoStatment = "INSERT INTO INVENTARIO WHERE ID_OBJETO = ? AND ID_USUARIO = ?";

        dropRelacionObjeto = this.con.prepareStatement(objetoStatment);

        dropRelacionObjeto.setString(2,usuario.getNombre());
        dropRelacionObjeto.setString(1,objeto.getNombre());
        dropRelacionObjeto.executeUpdate();

    }

    public void dropRelacionAtaque(Monstruo monstruo, Ataque ataque) throws SQLException{

        PreparedStatement addRelacionAtaque;

        String ataqueStatment = "INSERT INTO LISTAQTAQUES WHERE ID_MONSTRUO = ? AND ID_ATAQUE = ?";

        addRelacionAtaque = this.con.prepareStatement(ataqueStatment);

        addRelacionAtaque.setString(1,monstruo.getIdMonstruo());
        addRelacionAtaque.setString(2,ataque.getNombre());
        addRelacionAtaque.executeUpdate();

    }

    public void dropRelacionMonstruo(Usuario usuario, Monstruo monstruo) throws SQLException {

        PreparedStatement addRelacionAtaque;

        String ataqueStatment = "INSERT INTO LISTMONSTRUOSUSUARIOS WHERE ID_MONSTRUO = ? AND ID_USUARIO = ?";

        addRelacionAtaque = this.con.prepareStatement(ataqueStatment);

        addRelacionAtaque.setString(2, monstruo.getIdMonstruo());
        addRelacionAtaque.setString(1, usuario.getNombre());
        addRelacionAtaque.executeUpdate();
    }

    /*SELECT STATMENTS*/

    public void selectUsuarioAllInfo(String nombre) throws SQLException{

        PreparedStatement selectUsuario;

        String usuarioStatment = "SELECT * FROM USUARIOS WHERE ID_USUARIO = ?";

        selectUsuario = this.con.prepareStatement(usuarioStatment);

        selectUsuario.setString(1,nombre);
        ResultSet result = selectUsuario.executeQuery();

        while (result.next()) {



        }

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

}
