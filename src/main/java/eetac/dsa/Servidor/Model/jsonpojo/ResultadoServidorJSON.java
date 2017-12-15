package eetac.dsa.Servidor.Model.jsonpojo;

public class ResultadoServidorJSON {
    long flag;
    EscenarioJSON escenario;
    int x;
    int y;
    UsuarioJSON protagonista;
    ObjetoJSON objeto;
    int indiceObjeto;
    MonstruoJSON monstruo;

    public long getFlag() {
        return flag;
    }

    public void setFlag(long flag) {
        this.flag = flag;
    }

    public EscenarioJSON getEscenario() {
        return escenario;
    }

    public void setEscenario(EscenarioJSON escenario) {
        this.escenario = escenario;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public UsuarioJSON getProtagonista() {
        return protagonista;
    }

    public void setProtagonista(UsuarioJSON protagonista) {
        this.protagonista = protagonista;
    }

    public ObjetoJSON getObjeto() {
        return objeto;
    }

    public void setObjeto(ObjetoJSON objeto) {
        this.objeto = objeto;
    }

    public int getIndiceObjeto() {
        return indiceObjeto;
    }

    public void setIndiceObjeto(int indiceObjeto) {
        this.indiceObjeto = indiceObjeto;
    }

    public MonstruoJSON getMonstruo() {
        return monstruo;
    }

    public void setMonstruo(MonstruoJSON monstruo) {
        this.monstruo = monstruo;
    }


    public ResultadoServidorJSON() {
    }

}
