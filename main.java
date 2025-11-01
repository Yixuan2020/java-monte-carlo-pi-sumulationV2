
/**
 * Write a description of class main here.
 *
 * @author (yixuan)
 * @version (a version number or a date)
 */
import sas.*;
import java.awt.Color;

public class main
{
    // instance variables - replace the example below with your own
    View fenster;
    Circle kreis;
    Rectangle quadrat;
    Circle punkt;
    Text Ausfuehrungszeit;
    Text punkt_anzahl_display;
    Text treffer_display;
    Text ratio_display;
    Text pi_display;
    
    int versuche = 50000;
    volatile double punkt_anzahl = 0;
    volatile double treffer_zahl = 0;
    /**
     * Constructor for objects of class main
     */
    public main()
    {
        // initialise instance variables
        fenster = new View(900,600);
        quadrat = new Rectangle(0,0,600,600,Color.GRAY);
        kreis = new Circle(0, 0, 300,Color.WHITE);
        punkt = new Circle(0,0, 1,Color.RED);
        //kein IntegerToString weil java bei str + int den int automatisch zu str convertiert
        punkt_anzahl_display = new Text(610, 20, "Anzahl von Punkte:" + punkt_anzahl, Color.BLACK);
        punkt_anzahl_display.setFontMonospaced(true, 15);
        
        
        treffer_display = new Text(610, 50,"Anzahl von Treffer:" + treffer_zahl, Color.BLACK);
        treffer_display.setFontMonospaced(true, 15);
        
        ratio_display = new Text( 610, 80,"Ratio T/A:" + 0, Color.BLACK);
        ratio_display.setFontMonospaced(true, 15);
        
        pi_display = new Text(610, 110," π:" + 0, Color.BLACK);
        pi_display.setFontMonospaced(true, 20);
        
        
        //systemzeit am start loggen
        long start = System.currentTimeMillis();
        
        display_thread display = new display_thread(this);
        display.start();

        
        for(int i = 1; i<=versuche; i++)
        {
            random_dot();
            punkt_anzahl = i;
        }
        
        //systemzeit am ende loggen
        long end = System.currentTimeMillis();
        
        Ausfuehrungszeit = new Text(610,500,"Ausfuehrungszeit: " + (end - start) + " ms",Color.BLACK);
        Ausfuehrungszeit.setFontMonospaced(true, 15);
        System.out.println("Execution time: " + (end - start) + " ms");
        Runtime.getRuntime().halt(0);
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void random_dot()
    {
        //punkt.clone();
        punkt.moveTo((int)(Math.random() * (601-1)),((int)(Math.random() * (601-1))));
        //punkt.moveTo(-1,300);
        double x = punkt.getShapeX();
        double y = punkt.getShapeY();
        if ((x-300)*(x-300) + (y-300)*(y-300) <= 300*300)
        {
            treffer_zahl++;
        }
        
        /*if ()
        {
            treffer_zahl++;
        }
        */
    }
        public static void main(String[] args)
    {
        new main();
    }
}