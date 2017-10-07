package eetac.dsa;

public class Mundo {
    int dimensionX;
    int dimensionY;
    Celda[][] mapa;

    public Mundo(int dimensionX, int dimensionY) {
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        mapa = new Celda[dimensionX][dimensionY];
    }

    public void setCelda(int x,int y ,Celda celda)
    {
        mapa[x][y] = celda;
    }

    public Celda getCelda(int x,int y)
    {
        return mapa[x][y];
    }


}
