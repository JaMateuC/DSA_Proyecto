package eetac.dsa.Servidor.Model.jsonpojo.resultsserver;

import eetac.dsa.Servidor.Model.jsonpojo.EscenarioJSON;
import eetac.dsa.Servidor.Model.jsonpojo.UsuarioJSON;

public class ResultLoginArgs {
    boolean permitido;
    UsuarioJSON usuarioJSON;
    EscenarioJSON escenarioJSON;

    public boolean isPermitido() {
        return permitido;
    }

    public void setPermitido(boolean permitido) {
        this.permitido = permitido;
    }

    public UsuarioJSON getUsuarioJSON() {
        return usuarioJSON;
    }

    public void setUsuarioJSON(UsuarioJSON usuarioJSON) {
        this.usuarioJSON = usuarioJSON;
    }

    public EscenarioJSON getEscenarioJSON() {
        return escenarioJSON;
    }

    public void setEscenarioJSON(EscenarioJSON escenarioJSON) {
        this.escenarioJSON = escenarioJSON;
    }
}
