/*
 * SongPlayer, uses JFugue to create notes from entered 
 * noteSequence.
 */
package songmaker;

import org.jfugue.*;
/**
 *
 * @author Kathleen Hess
 */
public class SongPlayer {
    
    public String playPattern;
    public Player player;
    public String noteSeq;
    public String instrument;
    public String tempo;
    /**
     * Constructor for class SongPlayer
     * @param temp, inst, notes
     */
    public SongPlayer(String temp, String inst, String notes)
    {
      player = new Player();
      noteSeq = notes;
      tempo = temp;
      instrument = inst;
      
     
    }
    
    
    /** 
     * Creates the play pattern by combining the instrument, tempo
     * and note sequence.
     */
    public void makePattern()
    {
        playPattern = tempo  + instrument + noteSeq;
    }
    /**
     * Changes the sequence of notes to be played.
     * @param notes
     */
    public void setNoteSeq(String note)
    {
       noteSeq = note;
       
    }
    
    /**
     * Changes the tempo.
     * @pram newTempo
     */
    public void changeTempo(String newTempo)
    {
      tempo = newTempo;
    }
    
    /**
     * Changes the instrument used for playback.
     * @pram inst JFuge code for specific instrument.  
     */
    public void changeInstrument(String inst)
    {
        instrument = inst;
    }
    
    
     /**
     * Plays the pattern. Uses the makePattern method to 
     * create the pattern to be played. 
     */
    public void playSong() {
        makePattern();
        player.play(playPattern);
        }
    
   
}
