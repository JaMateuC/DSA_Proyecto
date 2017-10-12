package eetac.dsa.Combate;

public class GeometriaEsferica extends Geometria {
    float radi;

    public GeometriaEsferica( float radi) {
        super(Tipos.esferica);
        this.radi = radi;
    }

    public float getRadi() {
        return radi;
    }
}
