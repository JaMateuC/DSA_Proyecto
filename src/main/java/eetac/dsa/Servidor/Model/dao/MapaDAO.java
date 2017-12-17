package eetac.dsa.Servidor.Model.dao;

import eetac.dsa.Servidor.Model.jsonpojo.EscenarioJSON;

public class MapaDAO extends DAO{

    @OrderFields(indice = 0)
    private String nom;
    @OrderFields(indice = 1)
    private String direccioFile;

    public MapaDAO() {
    }

    @OrderGetMethods(indice = 0)
    public String getNom() {
        return nom;
    }

    @OrderSetMethods(indice = 0)
    public void setNom(String nom) {
        this.nom = nom;
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

        this.setNom(mapa.getNombre());
        //this.setDireccioFile();

    }
}
