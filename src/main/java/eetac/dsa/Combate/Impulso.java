package eetac.dsa.Combate;

public class Impulso extends Fuerza{

    float timpo;

    /**
     * Esta classe representa un "impulso" es decir una fuerza actuando durante un tiempo en especifico
     * @param x fuerza en el eje x
     * @param y fuerza en el eje y
     * @param tiempo tiempo durante el cual afecta la fuerza
     */
    public Impulso(float x, float y,float tiempo) {
        super(x, y);
        this.timpo = tiempo;
    }

    public float getTimpo() {
        return timpo;
    }

    public void reducirTiempo(float tiempo)
    {
        this.timpo-=tiempo;
        if(tiempo<0)
            this.timpo = 0;
    }
}
