package eetac.dsa.Combate;

import java.awt.geom.Point2D;
import java.util.Vector;

public class MonstruoFisico {
    Point2D.Float posicion;
    Point2D.Float velocidad;
    Point2D.Float aceleracion;
    Point2D.Float aceleracionFuerzas;
    Point2D.Float aceleracionImpulsos;
    float massa;

    float tiempoAcumulado;

    //tiempo desde el ultimo actualizarPosicion
    float timeDUPA;

    float tics;

    Vector<Fuerza> fuerzas;
    Vector<Impulso> impulsos;

    /**
     * representa los atributos fisicos de un monstruo
     * @param x posicion inicial en el eje x
     * @param y posicion inicial en el eje y
     * @param massa massa del monstruo
     * @param tics veces que se calculan las fuerzas cada segundo
     */
    public MonstruoFisico(float x,float y, float massa,int tics) {
        this.posicion = new Point2D.Float(x,y);
        this.massa = massa;
        velocidad = new Point2D.Float(0,0);
        aceleracion = new Point2D.Float(0,0);
        aceleracionFuerzas = new Point2D.Float(0,0);
        aceleracionImpulsos = new Point2D.Float(0,0);
        fuerzas = new Vector<Fuerza>();
        impulsos = new Vector<Impulso>();
        tiempoAcumulado = 0;
        timeDUPA = 0;
        this.tics = 1.f/(float)tics;
    }

    public Point2D.Float getPosicion() {
        return posicion;
    }

    public Point2D.Float getVelocidad() {
        return velocidad;
    }

    public Point2D.Float getAceleracion() {
        return aceleracion;
    }

    public float getMassa() {
        return massa;
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
        aceleracionFuerzas.setLocation(ax,ay);
    }

    void calcularAceleracionImpulsos()
    {
        float ax =0;
        float ay=0;
        for (Impulso f:impulsos) {
            ax += f.getX()/massa;
            ay += f.getY()/massa;
        }
        aceleracionImpulsos.setLocation(ax,ay);
    }

    void reducirTiempos()
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
    void calcularAceleracion()
    {
        calcularAceleracionFuerzas();
        calcularAceleracionImpulsos();
        aceleracion.setLocation(aceleracionFuerzas.getX()+aceleracionImpulsos.getX(),
                aceleracionFuerzas.getY()+aceleracionImpulsos.getY());
    }

    /**
     * calcula la posicion actual una vez ha pasado cierto tiempo
     * @param time tiempo transcurrido desde la ultima llamada de la funcion, ha de ser menor que 1/tics del constructor
     */
    void calcularPosicion(float time)
    {
        velocidad.setLocation(velocidad.getX()+aceleracion.getX()*time,velocidad.getY()+aceleracion.getY()*time);
        posicion.setLocation(posicion.getX()+velocidad.getX()*time,posicion.getY()+velocidad.getY()*time);
    }

    public void actualizar(float time)
    {
        if(tiempoAcumulado+time>tics&&tiempoAcumulado+time-tics<tics)
        {

            calcularPosicion(tics-tiempoAcumulado);
            reducirTiempos();
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
            reducirTiempos();
            calcularAceleracion();
            tiempoAcumulado=0;
            actualizar(time-(tics-tiempoAcumulado));
        }
    }
}
