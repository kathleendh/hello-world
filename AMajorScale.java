/*
 * Class AMajorScale.  Extends NoteKey.  
 * Creates a HashMap to covert numbers represting musical pitches to the 
 * corosponding letter pitch for the AMajorScale. 
 */
package songmaker;

import java.util.HashMap;

/**
 *
 * @author Kathleen Hess
 */
public class AMajorScale extends NoteKey{
    
    public HashMap setAMajor;
    
    //Constructor for AMajorScale
    public AMajorScale()
    {
    super();
    //Creates a new map for pairing numbers with note names.
    setAMajor = new HashMap();
    //Stores the number values with the corosponding note of the scale.
    setAMajor.put("1", "A4 ");
    setAMajor.put("2", "A#4 ");
    setAMajor.put("3", "B4 ");
    setAMajor.put("4", "C5 ");
    setAMajor.put("5", "C#5 ");
    setAMajor.put("6", "D5 ");
    setAMajor.put("7", "D#5 ");
    setAMajor.put("8", "E5 ");
    setAMajor.put("9", "F5 ");
    setAMajor.put("10", "F#5 ");
    setAMajor.put("11", "G5 ");
    setAMajor.put("12", "G#5 ");
    setAMajor.put("13", "A5 ");
    setAMajor.put("R", "R ");
    
            
    
}
    
    /**
     * Get the key value for the letter.
     */
    public String getNoteKey(String letter)
    {
      String key = super.getLetterKey(letter);
      String letKey = (String) setAMajor.get(key);
     return letKey;
    }
    
}
