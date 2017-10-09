package eetac.dsa;

/**
 * ataque de ejemplo, sacrifica la mitad de tu vida actual para dañar la mitad de la vida actual del enemigo
 */
public class AtaqueEjemplo extends Ataque {
    public AtaqueEjemplo() {
        super("sacrificio", 0.f);
    }

    @Override
    public void extraEnemigo(Monstruo enemigo)
    {
        enemigo.vidaActual/=2;
    }

    public void extraAtacante(Monstruo atacante)
    {
        atacante.vidaActual/=2;
    }
}
