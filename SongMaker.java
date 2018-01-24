/*
 * Creates a new SongMaker.
 */
package songmaker;

import org.jfugue.*;

/**
 *
 * @author Kathleen Hess
 */
public class SongMaker {
     
    public SongPlayer songPlayer;
    public Pattern noteSeq;
    public SongGUI guiS;
    public InstrumentKey instrument;
    
    /**
     * Constructor.
     */
    public SongMaker()
    {
     noteSeq = new Pattern("C D G F#");
     instrument = new InstrumentKey();
    }
    
   
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        SongGUI guiS = new SongGUI();
        //SongPlayer songPlayer = new SongPlayer();
    }   
    
    /**
     * Gets the instrument type selected and assigns it to the instrument
     * for the SongPlayer.
     */
    public void setInstrument()
    {
       

       guiS.getName();
     

    }

}
    