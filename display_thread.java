import sas.*;
import java.awt.Color;

public class display_thread extends Thread
{
    private main mainThread;   // reference to main instance so we can read punkt_anzahl
    
    public display_thread(main m)
    {
        this.mainThread = m;
    }

    @Override
    public void run()
    {
        while (true)
        {
            mainThread.punkt_anzahl_display.setText("Anzahl von Punkte: " + mainThread.punkt_anzahl);
            mainThread.treffer_display.setText("Anzahl von Treffer:" + mainThread.treffer_zahl);
            mainThread.ratio_display.setText("Ratio T/A:"+ mainThread.treffer_zahl/mainThread.punkt_anzahl);
            mainThread.pi_display.setText(" π:" + 4*mainThread.treffer_zahl/mainThread.punkt_anzahl);
            //System.out.println(4*mainThread.treffer_zahl/mainThread.versuche);
            try
            {
                Thread.sleep(50);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
    }
}
