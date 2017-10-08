package eetac.dsa;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Enemigo enemigo = new Enemigo("Albert", "Primer", 0,0, true);
        int N = 0;
        for(int i = 0; i < 8; i++)
        {
            N = enemigo.Random();
            System.out.println("N = " + N);
        }
    }
}
