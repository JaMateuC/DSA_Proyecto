package eetac.dsa.Servidor.Model;

import eetac.dsa.Servidor.Model.dao.DAO;
import eetac.dsa.Servidor.Model.dao.MonstruoDAO;
import eetac.dsa.Servidor.Model.dao.ObjetoDAO;
import eetac.dsa.Servidor.Model.dao.UsuarioDAO;
import eetac.dsa.Servidor.Model.jsonpojo.MonstruoJSON;
import eetac.dsa.Servidor.Model.jsonpojo.ObjetoJSON;
import eetac.dsa.Servidor.Model.jsonpojo.UsuarioJSON;

import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultaDB extends DAO {

    private static ConsultaDB singleConsulta = null;

    private ConsultaDB(){

    }

    public static ConsultaDB getInstance(){

        if(singleConsulta == null){

            singleConsulta = new ConsultaDB();

        }

        return singleConsulta;

    }

    public UsuarioJSON getUsuarioBasic(String name) throws SQLException{

        UsuarioDAO usuarioD = new UsuarioDAO();
        UsuarioJSON usuario = new UsuarioJSON();
        usuarioD.selectDB(name);
        usuario.parseFromDB(usuarioD);
        return usuario;

    }

    public ArrayList<ObjetoJSON> getObjtosUsuario(String name) throws SQLException{

        UsuarioDAO usuarioD = new UsuarioDAO();
        ArrayList<ObjetoDAO> listObj;
        ArrayList<ObjetoJSON> objetoJSONArrayList = new ArrayList<>();

        usuarioD.selectDB(name);
        listObj = usuarioD.selectListObjetoDB();

        for(ObjetoDAO obj: listObj){

            ObjetoJSON objetoJSON = new ObjetoJSON();
            objetoJSON.parseFromObjectDB(obj);
            objetoJSONArrayList.add(objetoJSON);

        }

        return objetoJSONArrayList;

    }

    public ArrayList<MonstruoJSON> getMonstruosUsuario(String name) throws SQLException{

        UsuarioDAO usuarioD = new UsuarioDAO();
        ArrayList<MonstruoDAO> monstruoDAOArrayList;
        ArrayList<MonstruoJSON> monstruoJSONArrayList = new ArrayList<>();

        usuarioD.selectDB(name);
        monstruoDAOArrayList = usuarioD.selectListMonstruoDB();

        for(MonstruoDAO mon: monstruoDAOArrayList){

            MonstruoJSON monstruoJSON = new MonstruoJSON();
            monstruoJSON.parseFromMonstruoDB(mon);
            monstruoJSONArrayList.add(monstruoJSON);

        }

        return monstruoJSONArrayList;

    }

    public UsuarioJSON getUsuarioEntero(String name)throws SQLException{

        UsuarioJSON usuarioJSON;
        usuarioJSON = ConsultaDB.getInstance().getUsuarioBasic(name);
        usuarioJSON.setInventariol(ConsultaDB.getInstance().getObjtosUsuario(usuarioJSON.getNombre()));
        usuarioJSON.setMonstruosl(ConsultaDB.getInstance().getMonstruosUsuario(usuarioJSON.getNombre()));
        return usuarioJSON;

    }

    public  ArrayList<UsuarioJSON> getAllUsers() throws SQLException{

        ArrayList<UsuarioDAO> usuarioDAOArrayList;
        ArrayList<UsuarioJSON> usuarioJSONArrayList = new ArrayList<>();

        usuarioDAOArrayList = selectAllUsers();

        for(UsuarioDAO usuarioDAO: usuarioDAOArrayList){

            UsuarioJSON usuarioJSON = new UsuarioJSON();
            usuarioJSON = ConsultaDB.getInstance().getUsuarioEntero(usuarioDAO.getId());
            usuarioJSONArrayList.add(usuarioJSON);

        }

        return usuarioJSONArrayList;

    }

}
