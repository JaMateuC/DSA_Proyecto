package eetac.dsa;

/**
 * Plantilla de un Monstruo, los diferentes tipos de monstruo herederan de esta classe.
 * vida, ataque,defensa no son los valores usados en el combate.
 * los valores usados seran del estilo ataque*nivel.
 * para obtener los valores usados en comabte usar los metodos getVidaEfectva, getAtaqueEfectivo etz.
 */
public abstract class Monstruo {
    int nivel;
    int experiencia;
    int vida;
    int ataque;
    int defensa;
    Lista_Ataques lista_ataques;

    String tipo;

    public Monstruo(int vida, int ataque, int defensa, String tipo) {
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.tipo = tipo;
        lista_ataques = new Lista_Ataques();
    }

    public int getNivel() {
        return nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    /**
     * obten la vida corregido por el nivel
     * @return vida*nivel
     */
    public int getVidaEfectiva() {
        return vida*nivel;
    }

    /**
     * obten el ataque corregido por el nivel
     * @return ataque*nivel
     */
    public int getAtaqueEfectivo() {
        return ataque*nivel;
    }

    /**
     * obten la defensa corregido por el nivel
     * @return defensa*nivel
     */
    public int getDefensaEfectiva() {
        return defensa;
    }

    public String getTipo() {
        return tipo;
    }


}
