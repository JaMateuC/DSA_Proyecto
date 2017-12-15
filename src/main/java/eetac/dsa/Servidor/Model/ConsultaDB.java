package eetac.dsa.Servidor.Model;

import eetac.dsa.Servidor.Model.dao.UsuarioDAO;
import eetac.dsa.Servidor.Model.jsonpojo.UsuarioJSON;

import java.sql.SQLException;

public class ConsultaDB {

    private static ConsultaDB singleConsulta = null;

    private ConsultaDB(){

    }

    public static ConsultaDB getInstance(){

        if(singleConsulta == null){

            singleConsulta = new ConsultaDB();

        }

        return singleConsulta;

    }

    public UsuarioJSON getUsuario(String name) throws SQLException{

        UsuarioDAO usuarioD = new UsuarioDAO();
        UsuarioJSON usuario = new UsuarioJSON();
        usuarioD.selectDB(name);
        usuario.parseFromDB(usuarioD);
        return usuario;

    }

}
