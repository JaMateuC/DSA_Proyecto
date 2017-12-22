package eetac.dsa.Servidor.Model.dao;

import eetac.dsa.Servidor.Model.jsonpojo.EscenarioJSON;

public class MapaDAO extends DAO{

    @OrderFields(indice = 0)
    private String id;
    @OrderFields(indice = 1)
    private String direccioFile;

    public MapaDAO() {
    }

    @OrderGetMethods(indice = 0)
    public String getId() {
        return id;
    }

    @OrderSetMethods(indice = 0)
    public void setId(String id) {
        this.id = id;
    }

    @OrderGetMethods(indice = 1)
    public String getDireccioFile() {
        return direccioFile;
    }

    @OrderSetMethods(indice = 1)
    public void setDireccioFile(String direccioFile) {
        this.direccioFile = direccioFile;
    }

    public void parseToMapa(EscenarioJSON mapa){

        this.setId(mapa.getNombre());
        //this.setDireccioFile();

    }
}
