/*
 * Creates the GUI for the SongMaker.
 */
package songmaker;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import java.lang.Object;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Kathleen Hess
 */
public class SongGUI {
    
    private JFrame frame;
    private JPanel mainPanel;
    private JTextArea textEntered;
    public String instrumentName;
    public String keyName;
    public String noteList;
    public int tempoValue;
    public String tempo;
    final JFileChooser fc; 
    
    /** Constructor 
     * Creates a new songGui and sets initial values. 
     */
    public SongGUI()
    {
        makeFrame();
        instrumentName = "Piano";
        keyName = "A_Major";
        fc = new JFileChooser();
        
    }
    
     /**
     * Open a file chooser. And open selected
     * text file to the Song text panel.
     */
    private void open() throws IOException{
       int returnVal = fc.showOpenDialog(frame);
        
            BufferedReader reader = new BufferedReader(
            new FileReader("textSave.text"));
            try {
                StringBuilder openedText = new StringBuilder();
                String line = reader.readLine();
                while (line !=null){
                 openedText.replace(0, 100, line);
                 line = reader.readLine();
                }
                String everything = openedText.toString();
                textEntered.append(everything);
            }
            finally{
           reader.close();
            }
       
    }
    
     /**
     * Saves the text from the songText panel to a file.
     */
    public void save() throws java.io.IOException
    {
     FileWriter saveFile = new FileWriter("textSave.text"); 
      
     System.out.println("saved text is " + textEntered.getText());
     saveFile.write(textEntered.getText());
     saveFile.close();
    }
    
    /**
     * Quit the application.
     */
    private void quit()
    {
        System.exit(0);
    }
    
      /**
     * Create a dialog box with the about info. 
     */
    private void about()
    {
     JPanel panelAbout = new JPanel(new GridLayout(4, 0));
     JTextField textField1 = new JTextField("Song Maker");
     JTextField textField2 = new JTextField("Kathleen Hess");
     JTextField textField3 = new JTextField("Final Project");
     JTextField textField4 = new JTextField("CS162");
     panelAbout.add(textField1);
     panelAbout.add(textField2);
     panelAbout.add(textField3);
     panelAbout.add(textField4);
     
     
     
     panelAbout.add(textField2);
     JOptionPane.showMessageDialog(frame, panelAbout);
    }
    
    /**
     * Creates a dialog box with the how to use info.
     */
    private void help()
    {
        JPanel panelHelp = new JPanel(new GridLayout(4,0));
        JTextArea helpArea = new JTextArea("How to use Song Maker:");
        JTextArea helpArea1 = new JTextArea("1) Enter text in the Enter text here box");
        JTextArea helpArea2 = new JTextArea("2) Select instrument, key, and tempo");
        JTextArea helpArea3 = new JTextArea("3) Click play");
        
        panelHelp.add(helpArea);
        panelHelp.add(helpArea1);
        panelHelp.add(helpArea2);
        panelHelp.add(helpArea3);
        
        
     JOptionPane.showMessageDialog(frame, panelHelp);
    }
    
    /**
     * Creates the noteList for playing from the text entered.
     */
    public void createNoteList()
    {
       String[] letList =  textEntered.getText().split("");
       ArrayList<String> nList= new ArrayList<String>();
       String k;
       String n;
       if(keyName=="A_Major"){
           AMajorScale scale = new AMajorScale();
           for(int i=1; i< letList.length-1; i++){
            k = letList[i];
           n = scale.getNoteKey(k);
           nList.add(n);
           
         }}
       
       else if(keyName=="C_Major"){
           CMajorScale scale = new CMajorScale();
            for(int i=1; i< letList.length-1; i++){
            k = letList[i];
            n = scale.getNoteKey(k);
           nList.add(n);
           
       }}
    
       else if(keyName=="F#_Major"){
           FSharpMajorScale scale = new FSharpMajorScale();
            for(int i=1; i< letList.length-1; i++){
            k = letList[i];
            n = scale.getNoteKey(k);
           nList.add(n);
           
       }}
       
       else if(keyName=="G_Minor"){
           GMinorScale scale = new GMinorScale();
            for(int i=1; i< letList.length-1; i++){
            k = letList[i];
            n = scale.getNoteKey(k);
           nList.add(n);
           
       }}
       
       StringBuilder result = new StringBuilder();
       for(String results: nList){
           result.append(results.toString());
          
       }
       noteList = result.toString();
      
    }
        

    
    /**
     * Plays the SongPlayer.
     */
    public void play()
    {
       InstrumentKey instrumentKey = new InstrumentKey();
       String instKey = instrumentKey.getInstrumentKey(instrumentName);
       createNoteList();
       SongPlayer songPlayer = new SongPlayer(tempo, instKey, noteList);
       songPlayer.playSong();  
    }
    
    
   
    /**
     * Returns the Instrument name currently selected.
     */
    public void getName()
    {
        System.out.println(instrumentName);
       
    }
    
    /**
     * Takes the value from the tempo slider and converts it to the needed
     * value for the player. 
     */
    private void changeTempo()
    {
        tempo = "T" + tempoValue + " ";
    }
    
    /**
     * Makes the frame for the SongMaker.
     */
    public void makeFrame()
    {
      frame = new JFrame("Song Maker");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      
      /** 
       * Makes the menu bar and components. 
       */
      JMenuBar menubar = new JMenuBar();
      frame.setJMenuBar(menubar);
      JMenu menu;
      JMenuItem item;
      
      // Create the file menu.
       menu = new JMenu("File");
       menubar.add(menu);
       
       item = new JMenuItem("Open");
       item.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){try {
                    open();
                } catch (IOException ex) {
                    Logger.getLogger(SongGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
}
       });
       menu.add(item);
       
       item = new JMenuItem("Save");
       item.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){try {
                    save();
                } catch (IOException ex) {
                    Logger.getLogger(Shape.class.getName()
                            ).log(Level.SEVERE, null, ex);
                }
           }
           
       });
       menu.add(item);
       
       item = new JMenuItem("Quit");
       item.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){quit();}
       });
       menu.add(item);
      
       // Creates the help menu.
       menu = new JMenu("Help");
       menubar.add(menu);
       
       item = new JMenuItem("Help");
       item.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){help();}
       });
       menu.add(item);
       
       item = new JMenuItem("About");
       item.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){about();}
       });
       menu.add(item);
       
       // Creates the panel.
       Container contentPane = frame.getContentPane();
       mainPanel= new JPanel(new GridLayout(3, 2));
       mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
       mainPanel.setBackground(new Color(255, 255, 204));
     
      contentPane.add(mainPanel);
       
      //Creates the text field for new text to be entered.
       final JTextField enterText = new JTextField(10);
       enterText.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){
           String text = enterText.getText();
           char c;
           boolean pass = true;
           for(int i= 0; i< text.length(); i++){
               c= text.subSequence(i,i+1).charAt(0);
               
                   if(Character.isDigit(c)){
                      
                        try {
                            throw new InvalidEntryException();
                        } 
                        catch (InvalidEntryException ex) {
                            textEntered.append("That is not a valid entry!" + "\n");
                            enterText.selectAll();
                             pass = false;
                        }}}
           if(pass){
               text = text.toLowerCase().replaceAll("[!-?-.]","");
           textEntered.setText(text + "\n");
           enterText.selectAll();
           textEntered.setCaretPosition(textEntered.getDocument().getLength());
           }
           }
       });
       
        TitledBorder enterTitle;
       enterTitle = BorderFactory.createTitledBorder("Enter text here:");
       enterText.setBorder(enterTitle);
       mainPanel.add(enterText);
       
       //Creates the text field that displays the text that was entered. 
            textEntered = new JTextArea();
            
        TitledBorder enteredTitle;
       enteredTitle = BorderFactory.createTitledBorder("Song text:");
       textEntered.setBorder(enteredTitle);
            
      mainPanel.add (textEntered);
      
      //Creates the ComboBox to select which instrument to use for playback.
      String[] instrumentChoices = {"Piano", "Harpischord", "Accoridan",
          "Glockenspiel", "Guitar", "Violin", "Trombone", "Brass_Section"};
      JComboBox instrumentList = new JComboBox(instrumentChoices);
      instrumentList.setSelectedIndex(0);
      instrumentList.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
          JComboBox cb1 = (JComboBox)e.getSource();
          instrumentName = (String)cb1.getSelectedItem();
          
      }});
      
     
      TitledBorder instTitle;
       instTitle = BorderFactory.createTitledBorder("Select Instrument");
       instrumentList.setBorder(instTitle);
       
      mainPanel.add(instrumentList);
      
      //Creates the ComboBox to select which key to use for playback.
      String[] keyChoices = {"A_Major", "C_Major", "F#_Major", "G_Minor"};
      JComboBox keyList = new JComboBox(keyChoices);
      keyList.setSelectedIndex(0);
      keyList.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
          JComboBox cb2 = (JComboBox)e.getSource();
          keyName = (String)cb2.getSelectedItem();
          
      }});
      
     
      TitledBorder keyTitle;
       keyTitle = BorderFactory.createTitledBorder("Select Key");
       keyList.setBorder(keyTitle);
       
      mainPanel.add(keyList);
      
       //Creates the slider to select the tempo.
      JSlider tempoSlide = new JSlider(40, 220 ,120);
       tempoSlide.setMajorTickSpacing(50);
       tempoSlide.setPaintTicks(true);
       tempoSlide.setPaintLabels(true);
       mainPanel.add(tempoSlide, BorderLayout.SOUTH);
       tempoSlide.addChangeListener(new ChangeListener(){
           public void stateChanged(ChangeEvent e){
               JSlider source = (JSlider)e.getSource();
               if(!source.getValueIsAdjusting()){
               tempoValue = (int)source.getValue();
               changeTempo();
               }}
       }
               );
       
       TitledBorder tempoTitle;
       tempoTitle = BorderFactory.createTitledBorder("Select Tempo");
       tempoSlide.setBorder(tempoTitle);
      
      //Creates the play button.
      JButton playButton = new JButton("Play");
       playButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){play();}
       });
      mainPanel.add(playButton);
     
     
      
      frame.pack();
       
       Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
      frame.setLocation(d.width/2-frame.getWidth()/2, d.height/2-frame.getHeight()/2);
       frame.setVisible(true);
    }

 
}
