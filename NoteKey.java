/*Class NoteKey.  Creates a Hashmap to assign albhebet letters to a 
 * numrical value representing a musical note. 
 */
package songmaker;

import java.util.HashMap;

/**
 *
 * @author Kathleen Hess
 */
public abstract class NoteKey {
    
    public HashMap setLetterSeq;
    
    /**
     * Constructor for NoteKey.  
     */
    public NoteKey()
    {
        //Creates a hash map for pairing letters with numbers.
        setLetterSeq = new HashMap();
        //Stores the letters with a number value for a scale note.
        //Assigns baised on common letter and note frequency.
        setLetterSeq.put("e", "1");
        setLetterSeq.put("t", "5");
        setLetterSeq.put("a", "6");
        setLetterSeq.put("o", "8");
        setLetterSeq.put("n", "10");
        setLetterSeq.put("r", "13");
        setLetterSeq.put("i", "1");
        setLetterSeq.put("s", "5");
        setLetterSeq.put("h", "6");
        setLetterSeq.put("d", "8");
        setLetterSeq.put("l", "10");
        setLetterSeq.put("f", "13");
        setLetterSeq.put("c", "3");
        setLetterSeq.put("m", "12");
        setLetterSeq.put("u", "3");
        setLetterSeq.put("g", "12");
        setLetterSeq.put("y", "2");
        setLetterSeq.put("p", "4");
        setLetterSeq.put("w", "7");
        setLetterSeq.put("b", "9");
        setLetterSeq.put("v", "11");
        setLetterSeq.put("k", "2");
        setLetterSeq.put("x", "4");
        setLetterSeq.put("j", "7");
        setLetterSeq.put("q", "9");
        setLetterSeq.put("z", "11");
        setLetterSeq.put(" ", "R");
        }
    
    /**
     * Get the key value for the letter.
     * @pram letter
     */
    public String getLetterKey(String letter)
    {
      String key = (String) setLetterSeq.get(letter);
       return key;
    }
}
