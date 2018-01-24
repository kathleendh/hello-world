/*
 * Class InstrumentKey.  Stores the values for JFuge for selected instruments
 * in a HashMap.  
 */
package songmaker;

import java.util.HashMap;

/**
 *
 * @author Kathleen Hess
 */
public class InstrumentKey  {
  
    public HashMap selectInstrument;
    
   /*
    * Constructor for class InstrumentKey.
    */
    public InstrumentKey()
    {
        //Creates a hashMap
        selectInstrument = new HashMap();
        //Stores the instrument names with the approapate SongPlayer code. 
        selectInstrument.put("Piano", "I0 ");
        selectInstrument.put("Harpischord", "I6 ");
        selectInstrument.put("Accoridan", "I21 ");
        selectInstrument.put("Glockenspiel", "I9 ");
        selectInstrument.put("Guitar", "I24 ");
        selectInstrument.put("Violin", "I40 ");
        selectInstrument.put("Trombone", "I57 ");
        selectInstrument.put("Brass_Section", "I61 ");
    }
    
    /**
     * Add new instruments to the InstrumentKey.  Need to input the
     * JFugue instrument token. 
     */
    public void addInstrumentKey(String kind, String key)
    {
        selectInstrument.put(kind, key);
    }
    
    public String getInstrumentKey(String instrument)
    {
        String key = (String) selectInstrument.get(instrument);
        return key;
    }
    
}
