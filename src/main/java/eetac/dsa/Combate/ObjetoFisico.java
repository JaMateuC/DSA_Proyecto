package eetac.dsa.Combate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.vecmath.Vector2f;
import java.awt.geom.Point2D;
import java.util.Vector;

public class ObjetoFisico {
    Point2D.Float posicion;
    Vector2f velocidad;
    Vector2f aceleracion;
    Vector2f aceleracionFuerzas;
    Vector2f aceleracionImpulsos;
    float massa;

    float tiempoAcumulado;

    private static final Logger logger = LogManager.getLogger(ObjetoFisico.class.getName());

    //tiempo desde el ultimo actualizarPosicion
    float timeDUPA;


    Vector<Fuerza> fuerzas;
    Vector<Impulso> impulsos;

    Geometria geometria;

    /**
     * representa los atributos fisicos de un monstruo
     * @param x posicion inicial en el eje x
     * @param y posicion inicial en el eje y
     * @param massa massa del monstruo
     * @param geometria especifica la geometria del objecte
     */
    public ObjetoFisico(float x, float y, float massa, Geometria geometria) {
        this.posicion = new Point2D.Float(x,y);
        this.massa = massa;
        velocidad = new Vector2f(0,0);
        aceleracion = new Vector2f(0,0);
        aceleracionFuerzas = new Vector2f(0,0);
        aceleracionImpulsos = new Vector2f(0,0);
        fuerzas = new Vector<Fuerza>();
        impulsos = new Vector<Impulso>();
        tiempoAcumulado = 0;
        this.geometria = geometria;
    }

    public Point2D.Float getPosicion() {
        return posicion;
    }

    public Vector2f getVelocidad() {
        return velocidad;
    }

    public Vector2f getAceleracion() {
        return aceleracion;
    }

    public float getMassa() {
        return massa;
    }

    public Geometria getGeometria() {
        return geometria;
    }

    public void añadirFuerza(Fuerza fuerza)
    {
        fuerzas.add(fuerza);
    }

    public void añadirImpulso(Impulso impulso)
    {
        impulsos.add(impulso);
    }

     void calcularAceleracionFuerzas()
    {
        float ax =0;
        float ay=0;
        for (Fuerza f:fuerzas) {
            ax += f.getX()/massa;
            ay += f.getY()/massa;
        }
        aceleracionFuerzas.set(ax,ay);
    }

    void calcularAceleracionImpulsos()
    {
        float ax =0;
        float ay=0;
        for (Impulso f:impulsos) {
            ax += f.getX()/massa;
            ay += f.getY()/massa;
        }
        aceleracionImpulsos.set(ax,ay);
    }

    void reducirTiempos(float tics)
    {
        for (int i = 0; i < impulsos.size(); i++) {

            if(impulsos.get(i).getTimpo()>0)
            {
                impulsos.get(i).reducirTiempo(tics);
            }
            else
            {
                impulsos.remove(i);
                i--;
            }
        }
    }

    /**
     * calcula la aceleracion aplicada al objeto
     */
    void calcularAceleracion(float tics)
    {
        reducirTiempos(tics);
        calcularAceleracionFuerzas();
        calcularAceleracionImpulsos();
        aceleracion.set(aceleracionFuerzas.getX()+aceleracionImpulsos.getX(),
                aceleracionFuerzas.getY()+aceleracionImpulsos.getY());
    }

    /**
     * calcula la posicion actual una vez ha pasado cierto tiempo
     * @param time tiempo transcurrido desde la ultima llamada de la funcion, ha de ser menor que 1/tics del constructor
     */
    void calcularPosicion(float time)
    {
        velocidad.set(velocidad.getX()+aceleracion.getX()*time,velocidad.getY()+aceleracion.getY()*time);
        posicion.setLocation(posicion.getX()+velocidad.getX()*time,posicion.getY()+velocidad.getY()*time);
        //logger.debug(posicion);
    }

    public void actualizar(float time)
    {
        /*if(tiempoAcumulado+time>tics&&tiempoAcumulado+time-tics<tics)
        {

            calcularPosicion(tics-tiempoAcumulado);
            calcularAceleracion();
            calcularPosicion(tiempoAcumulado+time-tics);
            tiempoAcumulado = tiempoAcumulado+time-tics;
        }
        else if(tiempoAcumulado+time<tics)
        {
            calcularPosicion(time);
            tiempoAcumulado += time;
        }
        else if(time>tics)
        {
            calcularPosicion(tics-tiempoAcumulado);
            calcularAceleracion();
            tiempoAcumulado=0;
            actualizar(time-(tics-tiempoAcumulado));
        }*/
    }
}
