package eetac.dsa.Servidor.Model.dao;

import eetac.dsa.Servidor.Controlador.Monstruo;
import eetac.dsa.Servidor.Model.jsonpojo.MonstruoJSON;
import eetac.dsa.Servidor.Model.jsonpojo.ObjetoJSON;
import eetac.dsa.Servidor.Model.jsonpojo.UsuarioJSON;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UsuarioDAO {

    @OrderFields(indice = 0)
    private String nombre;
    @OrderFields(indice = 1)
    private String password;
    @OrderFields(indice = 2)
    private int x;
    @OrderFields(indice = 3)
    private int y;
    @OrderFields(indice = 4)
    private boolean genero;


    public UsuarioDAO() {
    }

    @OrderGetMethods(indice = 0)
    public String getNombre() {
        return nombre;
    }

    @OrderSetMethods(indice = 0)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @OrderGetMethods(indice = 1)
    public String getPassword() {
        return password;
    }

    @OrderSetMethods(indice = 1)
    public void setPassword(String password) {
        this.password = password;
    }

    @OrderGetMethods(indice = 2)
    public int getX() {
        return x;
    }

    @OrderSetMethods(indice = 2)
    public void setX(int x) {
        this.x = x;
    }

    @OrderGetMethods(indice = 3)
    public int getY() {
        return y;
    }

    @OrderSetMethods(indice = 3)
    public void setY(int y) {
        this.y = y;
    }

    @OrderGetMethods(indice = 4)
    public boolean isGenero() {
        return genero;
    }

    @OrderSetMethods(indice = 4)
    public void setGenero(boolean genero) {
        this.genero = genero;
    }

    public void parseToUsuario(UsuarioJSON usuario){

        this.setNombre(usuario.getNombre());
        this.setGenero(usuario.isGenero());
        this.setPassword(usuario.getPassword());
        this.setX(usuario.getX());
        this.setY(usuario.getY());

    }

    public ArrayList<ObjetoDAO> parseInventario(UsuarioJSON usuario){

        ArrayList<ObjetoJSON> listObjetos= usuario.getInventariol();
        if(listObjetos.size() >= 0) {
            ObjetoDAO objetoD = new ObjetoDAO();
            ArrayList<ObjetoDAO> listObjetoDAO = new ArrayList<>();

            for (ObjetoJSON objeto : listObjetos) {

                objetoD.parseToObject(objeto, usuario.getNombre());
                listObjetoDAO.add(objetoD);

            }

            return listObjetoDAO;
        }

        return null;

    }

    public ArrayList<MonstruoDAO> parseMonstruos(UsuarioJSON usuario){

        ArrayList<MonstruoJSON> listMonsturos = usuario.getMonstruosl();
        if(listMonsturos.size() >= 0) {
            MonstruoDAO monstruoD = new MonstruoDAO();
            ArrayList<MonstruoDAO> listMonstruoDAO = new ArrayList<>();

            for (MonstruoJSON monstruo : listMonsturos) {

                monstruoD.parseToMonstruo(monstruo, usuario.getNombre());
                listMonstruoDAO.add(monstruoD);

            }

            return listMonstruoDAO;
        }

        return null;

    }

}
