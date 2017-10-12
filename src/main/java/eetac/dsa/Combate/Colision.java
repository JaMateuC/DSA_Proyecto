package eetac.dsa.Combate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.vecmath.Vector2f;
import java.awt.geom.Point2D;

public class Colision {

    ObjetoFisico obj1;
    ObjetoFisico obj2;
    private static final Logger logger = LogManager.getLogger(ObjetoFisico.class.getName());

    public Colision(ObjetoFisico obj1, ObjetoFisico obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public ObjetoFisico getObj1() {
        return obj1;
    }

    public ObjetoFisico getObj2() {
        return obj2;
    }

    static public boolean isColisio(ObjetoFisico obj1, ObjetoFisico obj2)
    {
        if(obj1.getGeometria().getTipo()== Geometria.Tipos.esferica&&
                obj2.getGeometria().getTipo()== Geometria.Tipos.pla)
        {

        }

        if(obj1.getGeometria().getTipo()== Geometria.Tipos.esferica&&
                obj2.getGeometria().getTipo()== Geometria.Tipos.esferica)
        {
            GeometriaEsferica geom1 = (GeometriaEsferica)obj1.getGeometria();
            GeometriaEsferica geom2 = (GeometriaEsferica)obj2.getGeometria();
            double distancia = Math.sqrt(Math.pow(obj1.getPosicion().getX() - obj2.getPosicion().getX(),2)+
                    Math.pow(obj1.getPosicion().getY() - obj2.getPosicion().getY(),2));
            if(distancia<geom1.getRadi()+geom2.getRadi())
            {
                return true;
            }
            return false;
        }

        if(obj1.getGeometria().getTipo()== Geometria.Tipos.esferica&&
                obj2.getGeometria().getTipo()== Geometria.Tipos.pla)
        {
            GeometriaEsferica geom1 = (GeometriaEsferica)obj1.getGeometria();
            GeometriaPla geom2 = (GeometriaPla)obj2.getGeometria();

            double c;

            c = -geom2.getVectorDireccio().getX()*obj2.getPosicion().getX() -  geom2.getVectorDireccio().getY()*obj2.getPosicion().getY();

            double nomerador = Math.abs(geom2.getVectorDireccio().getX()*obj1.getPosicion().getX()+geom2.getVectorDireccio().getY()*obj1.getPosicion().getY()+c);
            double denominador = Math.sqrt(Math.pow(geom2.getVectorDireccio().getX(),2)+Math.pow(geom2.getVectorDireccio().getY(),2));

            double distancia = nomerador/denominador;
            //logger.debug(distancia);

            if(distancia<geom1.getRadi())
            {
                return true;
            }


            return false;
        }

        if(obj2.getGeometria().getTipo()== Geometria.Tipos.esferica&&
                obj1.getGeometria().getTipo()== Geometria.Tipos.pla)
        {
            GeometriaEsferica geom1 = (GeometriaEsferica)obj2.getGeometria();
            GeometriaPla geom2 = (GeometriaPla)obj1.getGeometria();

            double c;

            c = -geom2.getVectorDireccio().getX()*obj1.getPosicion().getX() -  geom2.getVectorDireccio().getY()*obj1.getPosicion().getY();

            double nomerador = Math.abs(geom2.getVectorDireccio().getX()*obj2.getPosicion().getX()+geom2.getVectorDireccio().getY()*obj2.getPosicion().getY()+c);
            double denominador = Math.sqrt(Math.pow(geom2.getVectorDireccio().getX(),2)+Math.pow(geom2.getVectorDireccio().getY(),2));

            double distancia = nomerador/denominador;
            //logger.debug(distancia);

            if(distancia<geom1.getRadi())
            {
                return true;
            }


            return false;
        }

        return false;
    }

    public void calcularColision()
    {
        if(obj1.getGeometria().getTipo()== Geometria.Tipos.esferica&&
                obj2.getGeometria().getTipo()== Geometria.Tipos.pla)
        {
            GeometriaPla plano = (GeometriaPla)obj2.getGeometria();
            Vector2f velocidad1 = obj1.getVelocidad();

            Point2D.Float perpendicular = new Point2D.Float(-(float)plano.getVectorDireccio().getY(),(float) plano.getVectorDireccio().getX());

        }
    }
}
