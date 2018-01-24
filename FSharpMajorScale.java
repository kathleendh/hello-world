/*
 * Class FSharpMajorScale.  Extends NoteKey.  
 * Creates a HashMap to covert numbers represting musical pitches to the 
 * corosponding letter pitch for the FSharpMajorScale. 
 */
package songmaker;

import java.util.HashMap;

/**
 *
 * @author Kathleen Hess
 */

public class FSharpMajorScale extends NoteKey{
    
    public HashMap setFSharpMajor;
    
    //Constructor for AMajorScale
    public FSharpMajorScale()
    {
    super();
    //Creates a new map for pairing numbers with note names.
    setFSharpMajor = new HashMap();
    //Stores the number values with the corosponding note of the scale.
    setFSharpMajor.put("1", "F#5 ");
    setFSharpMajor.put("2", "G5 ");
    setFSharpMajor.put("3", "G#5 ");
    setFSharpMajor.put("4", "A5 ");
    setFSharpMajor.put("5", "A#5 ");
    setFSharpMajor.put("6", "B5 ");
    setFSharpMajor.put("7", "C6 ");
    setFSharpMajor.put("8", "C#6 ");
    setFSharpMajor.put("9", "D6 ");
    setFSharpMajor.put("10", "D#6 ");
    setFSharpMajor.put("11", "E6 ");
    setFSharpMajor.put("12", "F6 ");
    setFSharpMajor.put("13", "F#6 ");
    setFSharpMajor.put("R", "R ");
    }
    
    /**
     * Get the key value for the letter.
     */
    public String getNoteKey(String letter)
    {
      String key = super.getLetterKey(letter);
      String letKey = (String) setFSharpMajor.get(key);
     return letKey;
    }
}
