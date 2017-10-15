package eetac.dsa.Combate.Ataques;

import eetac.dsa.Combate.AtaqueFisica;
import eetac.dsa.Combate.MonstruoEntidad;
import org.jbox2d.common.Vec2;

public class SaltoAereo extends AtaqueFisica {
    public SaltoAereo() {
        super("SaltoAereo", 0f, 1f);
        this.comportamiento = Comportamiento.SoloFisica;
    }

    @Override
    public void soloFisica(MonstruoEntidad atacante) {
        atacante.getBody().applyLinearImpulse(new Vec2(0,10), atacante.getBody().getWorldCenter());
    }
}
