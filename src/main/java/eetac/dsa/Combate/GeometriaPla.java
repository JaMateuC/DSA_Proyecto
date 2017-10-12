package eetac.dsa.Combate;

import javax.vecmath.Vector2f;
import java.awt.geom.Point2D;

public class GeometriaPla extends Geometria{
    Vector2f vectorDireccio;

    public GeometriaPla(float x,float y) {
        super(Tipos.pla);
        this.vectorDireccio = new Vector2f(x,y);
    }

    public Vector2f getVectorDireccio() {
        return vectorDireccio;
    }
}
