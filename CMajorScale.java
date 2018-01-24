/*
 * Class CMajorScale.  Extends NoteKey.  
 * Creates a HashMap to covert numbers represting musical pitches to the 
 * corosponding letter pitch for the CMajorScale. 
 */
package songmaker;

import java.util.HashMap;

/**
 *
 * @author Kathleen Hess
 */

public class CMajorScale extends NoteKey{
    
    public HashMap setCMajor;
    
    //Constructor for AMajorScale
    public CMajorScale()
    {
    super();
    //Creates a new map for pairing numbers with note names.
    setCMajor = new HashMap();
    //Stores the number values with the corosponding note of the scale.
    setCMajor.put("1", "C4 ");
    setCMajor.put("2", "C#4 ");
    setCMajor.put("3", "D4 ");
    setCMajor.put("4", "D#5 ");
    setCMajor.put("5", "E5 ");
    setCMajor.put("6", "F5 ");
    setCMajor.put("7", "F#5 ");
    setCMajor.put("8", "G5 ");
    setCMajor.put("9", "G#5 ");
    setCMajor.put("10", "A5 ");
    setCMajor.put("11", "A#5 ");
    setCMajor.put("12", "B5 ");
    setCMajor.put("13", "C5 ");
    setCMajor.put("R", "R ");
    }
    
    /**
     * Get the key value for the letter.
     */
    public String getNoteKey(String letter)
    {
      String key = super.getLetterKey(letter);
      String letKey = (String) setCMajor.get(key);
     return letKey;
    }
}

