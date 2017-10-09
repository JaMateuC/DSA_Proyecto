package eetac.dsa;

public class MonstruoEjemplo extends Monstruo {
    public MonstruoEjemplo(int nivel,int experiencia) {
        super(20, 5, 3, "MonstruoEjemplo", 30,nivel);
        this.experiencia = experiencia;

        lista_ataques.añadirAtaque(new Ataque("patada",1.5f));
        lista_ataques.añadirAtaque(new Ataque("puñetazo",1.1f));
        lista_ataques.añadirAtaque(new AtaqueEjemplo());
    }
}
