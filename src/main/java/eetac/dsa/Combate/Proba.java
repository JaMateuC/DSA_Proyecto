package eetac.dsa.Combate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*public class Proba {
    public static void main( String[] args )
    {
        //1. Create the frame.
        JFrame frame = new JFrame("FrameDemo");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        frame.pack();



        frame.setVisible(true);

        Comabte comabte = new Comabte(40);
        ObjetoFisico esfera =new ObjetoFisico(20,5,4,new GeometriaEsferica(4));
        esfera.añadirFuerza(new Fuerza(0.f,-9.8f*4));
        comabte.añadirObjetoFisico(esfera);
        ObjetoFisico plano =new ObjetoFisico(0,0,4,new GeometriaPla(0,1));
        comabte.añadirObjetoFisico(plano);
        long startTime;
        long endTime;
        long duration = 0;

        while (true)
        {
            startTime = System.nanoTime();
            comabte.actualizar((float)(duration*Math.pow(10,-9)));
            endTime = System.nanoTime();
            duration = (endTime - startTime);

        }
    }
}*/
public class Proba extends JFrame {
    // Define constants
    public static final int CANVAS_WIDTH  = 640;
    public static final int CANVAS_HEIGHT = 480;

    // Declare an instance of the drawing canvas,
    // which is an inner class called DrawCanvas extending javax.swing.JPanel.
    private DrawCanvas canvas;

    // Constructor to set up the GUI components and event handlers
    public Proba() {
        canvas = new DrawCanvas();    // Construct the drawing canvas
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

        // Set the Drawing JPanel as the JFrame's content-pane
        Container cp = getContentPane();
        cp.add(canvas);
        // or "setContentPane(canvas);"

        setDefaultCloseOperation(EXIT_ON_CLOSE);   // Handle the CLOSE button
        pack();              // Either pack() the components; or setSize()
        setTitle("......");  // "super" JFrame sets the title
        setVisible(true);    // "super" JFrame show
    }

    /**
     * Define inner class DrawCanvas, which is a JPanel used for custom drawing.
     */
    private class DrawCanvas extends JPanel implements ActionListener{

        Comabte comabte;
        ObjetoFisico esfera;
        ObjetoFisico plano;
        long startTime;
        long endTime;
        long duration = 0;
        Timer timer;

        public DrawCanvas()
        {
            comabte = new Comabte(40);

            plano =new ObjetoFisico(0,0,4,new GeometriaPla(0,1));
            comabte.añadirObjetoFisico(plano);

            esfera =new ObjetoFisico(20,20,4,new GeometriaEsferica(4));
            esfera.añadirFuerza(new Fuerza(0.f,-9.8f*4));
            comabte.añadirObjetoFisico(esfera);

            setBackground(Color.BLACK);
            setPreferredSize(new Dimension(640, 480));
            setDoubleBuffered(true);

            timer = new Timer(10, this);
            timer.start();

        }


        // Override paintComponent to perform your own painting
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);     // paint parent's background

            startTime = System.nanoTime();
            //comabte.actualizar((float)(duration*Math.pow(10,-9)));
            comabte.actualizar(0.01f);
            endTime = System.nanoTime();
            duration = (endTime - startTime);

            g.setColor(Color.YELLOW);    // set the drawing color
            g.drawOval(100-(int)(4*esfera.getPosicion().getX()), 100-(int)(4*esfera.getPosicion().getY()), 32, 32);

            g.setColor(Color.RED);
            g.fillRect(0, 140, 640, 4);

            /*setBackground(Color.BLACK);  // set background color for this JPanel

            // Your custom painting codes. For example,
            // Drawing primitive shapes

            g.setColor(Color.RED);       // change the drawing color
            g.fillOval(300, 310, 30, 50);
            g.fillRect(400, 350, 60, 50);
            // Printing texts
            g.setColor(Color.WHITE);
            g.setFont(new Font("Monospaced", Font.PLAIN, 12));
            g.drawString("Testing custom drawing ...", 10, 20);*/
        }

        public void actionPerformed(ActionEvent e) {


            repaint();
        }
    }



    // The entry main method
    public static void main(String[] args) {
        // Run the GUI codes on the Event-Dispatching thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Proba(); // Let the constructor do the job

            }
        });
    }
}