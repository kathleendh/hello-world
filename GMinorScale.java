/*
 * Class GMinorScale.  Extends NoteKey.  
 * Creates a HashMap to covert numbers represting musical pitches to the 
 * corosponding letter pitch for the GMinorScale. 
 */
package songmaker;

import java.util.HashMap;

/**
 *
 * @author Kathleen Hess
 */

public class GMinorScale extends NoteKey{
    
    public HashMap setGMinor;
    
    //Constructor for AMajorScale
    public GMinorScale()
    {
    super();
    //Creates a new map for pairing numbers with note names.
    setGMinor = new HashMap();
    //Stores the number values with the corosponding note of the scale.
    setGMinor.put("1", "G5 ");
    setGMinor.put("2", "G#5 ");
    setGMinor.put("3", "A5 ");
    setGMinor.put("4", "A#5 ");
    setGMinor.put("5", "B5 ");
    setGMinor.put("6", "C6 ");
    setGMinor.put("7", "C#6 ");
    setGMinor.put("8", "D6 ");
    setGMinor.put("9", "D#6 ");
    setGMinor.put("10", "E6 ");
    setGMinor.put("11", "F6 ");
    setGMinor.put("12", "F#6 ");
    setGMinor.put("13", "G6 ");
    setGMinor.put("R", "R ");
    }
    
    /**
     * Get the key value for the letter.
     */
    public String getNoteKey(String letter)
    {
      String key = super.getLetterKey(letter);
      String letKey = (String) setGMinor.get(key);
     return letKey;
    }
}