package eetac.dsa.Servidor.Model.jsonpojo;

public class ObjetoJSON {
    String tipo;
    int numArgs;
    String args;

    public ObjetoJSON() { }

    public ObjetoJSON(String tipo, String args) {
        this.tipo = tipo;
        this.args = args;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNumArgs() {
        return numArgs;
    }

    public void setNumArgs(int numArgs) {
        this.numArgs = numArgs;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }



}
