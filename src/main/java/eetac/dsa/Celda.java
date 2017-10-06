package eetac.dsa;

/**
 * La clase celda es una plantilla para cada conjunto de propiedades que tiene cada una de las posiciones del mapa
 */
public abstract class Celda
{
    String tipo;
    /**
     * probabilidad con la que aparece un objeto en esta celda
     */
    float probObjeto;

    /**
     * probabilidad con la que aparece un monstruo
     */
    float probMonstruo;

    Boolean anadable;

    /**
     * si existe un personaje encima esta propiedad es diferente de null.
     * solo un personaje por celda.
     */
    Personaje personajeEncima;


}
