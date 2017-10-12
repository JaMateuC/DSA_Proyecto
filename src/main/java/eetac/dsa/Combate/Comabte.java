package eetac.dsa.Combate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Vector;

public class Comabte {
    Vector<ObjetoFisico> objetos;
    float tics;
    Vector<Colision> colisiones;
    float tiempoAcumulado;

    private static final Logger logger = LogManager.getLogger(Comabte.class.getName());


    public Comabte(float tics) {
        this.objetos = new Vector<ObjetoFisico>();
        this.colisiones = new Vector<Colision>();
        this.tics = 1.f/tics;
        tiempoAcumulado = 0;
    }

    public void añadirObjetoFisico(ObjetoFisico objetoFisico)
    {
        objetos.add(objetoFisico);
    }

    public void quitarObetoFisico(ObjetoFisico objetoFisico)
    {
        objetos.remove(objetoFisico);
    }

    void calcularAceleraciones()
    {
        for (ObjetoFisico obj:objetos) {
            obj.calcularAceleracion(tics);
        }
    }

    void calcularPosiciones(float time)
    {
        for (ObjetoFisico obj:objetos) {
            obj.calcularPosicion(time);
        }
    }

    void buscarColisiones()
    {
        for (int i = 0; i < objetos.size(); i++) {
            for (int j = i+1; j < objetos.size(); j++) {
                if(Colision.isColisio(objetos.get(i),objetos.get(j)))
                {
                    colisiones.add(new Colision(objetos.get(i),objetos.get(j)));
                    logger.debug("encontrada colision");
                }
            }
        }
    }

    public void actualizar(float time)
    {
        if(tiempoAcumulado+time>tics&&tiempoAcumulado+time-tics<tics)
        {

            calcularPosiciones(tics-tiempoAcumulado);
            buscarColisiones();
            calcularAceleraciones();
            calcularPosiciones(tiempoAcumulado+time-tics);
            tiempoAcumulado = tiempoAcumulado+time-tics;
        }
        else if(tiempoAcumulado+time<tics)
        {
            calcularPosiciones(time);
            tiempoAcumulado += time;
        }
        else if(time>tics)
        {
            calcularPosiciones(tics-tiempoAcumulado);
            buscarColisiones();
            calcularAceleraciones();
            tiempoAcumulado=0;
            actualizar(time-(tics-tiempoAcumulado));
        }
    }
}
