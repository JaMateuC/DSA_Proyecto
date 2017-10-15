package eetac.dsa.Combate.Ataques;

import eetac.dsa.Combate.AtaqueFisica;
import eetac.dsa.Combate.MonstruoEntidad;
import org.jbox2d.common.Vec2;

public class Pisoton extends AtaqueFisica
{
    public Pisoton() {
        super("Pisoton", 3f, 1f);
        this.comportamiento = Comportamiento.FisicaLuegoAtaque;
    }

    @Override
    public void soloFisica(MonstruoEntidad atacante) {
        atacante.getBody().applyLinearImpulse(new Vec2(0,-30), atacante.getBody().getWorldCenter());
    }
}
