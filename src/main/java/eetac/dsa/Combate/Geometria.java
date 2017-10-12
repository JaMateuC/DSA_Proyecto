package eetac.dsa.Combate;

public class Geometria {
    enum Tipos {pla,esferica};
    Tipos tipo;

    public Geometria(Tipos tipo) {
        this.tipo = tipo;
    }

    public Tipos getTipo() {
        return tipo;
    }
}
