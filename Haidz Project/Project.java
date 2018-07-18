import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JLabel;

public class Project implements ActionListener{

    JTextArea txtSentence;
    JTextField txtLogic;
    
    JFrame mnfrm;
    JButton btnToSentence;
    JButton btnToLogic;

    String[] words;
    String wordPool = "";

    String[] randomPhrasePool = {"hot","cool","warm","freezing","wet","dry","humid","blazing"};

   public Project(){ //Constructor
   //initializeUI();
   System.out.println("Project is Running."); // prints Hello World
    
   JFrame mnfrm = new JFrame("Discrete Math - Project ");
   JPanel pnl = new JPanel();
   JPanel leftpnl = new JPanel();
   JPanel rightpnl = new JPanel();

   txtLogic = new JTextField(20);
   txtSentence = new JTextArea(5,20);

   JLabel lbl = new JLabel("Hello World");
   JButton btnToSentence = new JButton("Convert to Sentence");
   JButton btnToLogic = new JButton("Convert to Logic");
   

   mnfrm.add(pnl);
   pnl.add(rightpnl);rightpnl.setBackground(Color.green);rightpnl.setBounds(300,0,300,300);
   pnl.add(leftpnl);leftpnl.setBackground(Color.red);leftpnl.setBounds(0,0,300,300);


   rightpnl.add(txtLogic);
   leftpnl.add(txtSentence);

   rightpnl.add(btnToSentence);
   leftpnl.add(btnToLogic);
   btnToSentence.setBounds(100, 100,200,200);

   btnToLogic.addActionListener(this);
   btnToSentence.addActionListener(this);
   
   pnl.setLayout(null);
   

   //Main Frame Properties
   mnfrm.setVisible(true);
   mnfrm.setSize(600,400);
   mnfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String []args) {//Create instance of a new Project
   Project run = new Project();
   }

   public void initializeUI(){
  
   }
   public void clearWordBase(){
    for(int i=0;i < words.length;i++){
        words[i] = "";
    }
    wordPool = "";
   }
   //System.out.println(":"+e.getActionCommand().toString()); // prints Hello World

   public void actionPerformed(ActionEvent e){
    if(e.getActionCommand().equals("Convert to Sentence")){//e.getActionCommand() = Get the text on the component
    //txtSentence.setText("I have thunked logic!");
    txtSentence.setText(ConvertIntoSentence(txtLogic.getText().toString()));//Convert the text input into a string
    
    }else if(e.getActionCommand().equals("Convert to Logic")){
    ConvertIntoLogic(txtSentence.getText().toString());//Convert the text input into a string


   }
   }

   public String ConvertIntoSentence(String _toConvert){
   System.out.println("The logical proposition is: "+_toConvert);
   String[] stringbuilder = {"","","","","","","","","","","","","","","",""};
   if(_toConvert.contains("<=>")||_toConvert.contains("<->")){
   _toConvert = _toConvert.replace("<->","<=>");    
   if(_toConvert.equals("p <=> q")){
   return "Iff it is freezing, the ground will be frozen";
   }else if(_toConvert.equals("!p <=> !q")){
   return "If and only if the ground is not frozen will the lakes not be frozen";
   }else if(_toConvert.equals("!p <=> q")){
    return "If and only if the ground is not frozen will the lakes be liquid";
   }else if(_toConvert.equals("p <=> !q")){
    return "It is necessary to precipitate that the ground will be wet";
   }else{
    return "It is necessary to study in order to have good grades";
   }
   }else if(_toConvert.contains("->")||_toConvert.contains("=>")){
    _toConvert = _toConvert.replace("->","=>");    
    if(_toConvert.equals("(p ^ q)=> q")){
        return "If you study well and give your best then you will have good grades";
       }else if(_toConvert.equals("(p ^ !q)=> q")){
        return "If you study and do not slack off too much, then you will have good grades";
       }else if(_toConvert.equals("(!p ^ q)=> q")){
        return "If you do not stay up too late and study well, then you will have good grades";
       }else if(_toConvert.equals("(!p ^ !q)=>q")){
        return "If you do not study well and do not give your best, then you will fail the subject";   
       }
    if(_toConvert.equals("(p V q)=> q")){
        return "If you drink too much beer or too much wine, then you will get drunk";
       }else if(_toConvert.equals("(p V !q)=> q")){
        return "If you drink too much wine and not stay sober, then you will get drunk";
       }else if(_toConvert.equals("(!p V q)=> q")){
        return "If you do not get enough";
       }else if(_toConvert.equals("(!p V !q)=>q")){
        return "If you do not study well and do not give your best, then you will fail the subject";   
       }



   }else if(_toConvert.contains("V")){

   }else if(_toConvert.contains("^")){
   
   }else if(_toConvert.contains("!")){
    if(_toConvert.contains("!p")){
    stringbuilder[0]="It is not raining";
    }else if (_toConvert.contains("!q")){
 
    }
   }else if(_toConvert.contains("p")){
   stringbuilder[stringbuilder.length-2] = "it is raining";
   }else if (_toConvert.contains("q")){
   stringbuilder[stringbuilder.length-1] = "it is freezing";
   }
   return "Input error, please check input.";  
    }
   public void ConvertIntoLogic(String _toConvert){// ¬ ∧ ∨ → ↔
    //Check for Keywords
    System.out.println("The sentence is:" +_toConvert);
    if(_toConvert.contains("it is false that")||_toConvert.contains("it is not the case that")){
       _toConvert = _toConvert.replace("it is false that","not");
       _toConvert = _toConvert.replace("it is not the case that","not");
    }
    if(_toConvert.contains("if and only if")||_toConvert.contains("iff")){
        _toConvert = _toConvert.replace("if and only if","<=>");
        _toConvert = _toConvert.replace("iff","<=>");
     }
     if(_toConvert.contains("is necessary and sufficient")||_toConvert.contains("is required to be")){
        _toConvert = _toConvert.replace("is necessary and sufficient","<=>");
        _toConvert = _toConvert.replace("is required to be","<=>");
     }
     words = _toConvert.split("\\s+");
    for(int i=0;i < words.length;i++){//Keyword Filter
        String word = words[i]+"";
        word = " "+word+" ";
        if(word.contains(" not ")){//or
        word = "-";
        wordPool = wordPool + word;
        }else if(word.contains(" <=> ")){//then
        word = "<=>";
        wordPool = wordPool + word;
        }else if(word.contains(" and ")||word.contains(" but ")||word.contains(" however ")||word.contains(" although ")||word.contains(" furthermore ")){//And
        String string = "^";
		word = string;
        wordPool = wordPool + word;
        }else if(word.contains(" or both")){
        word = "/";
        wordPool = wordPool + word;     
        }else if(word.contains(" or ")||word.contains(" either ")){//or
        word = "V";
        wordPool = wordPool + word;
        }else if(word.contains(" nor ")||word.contains(" neither ")){//or
        word = "!V";
        wordPool = wordPool + word;
        
        }else if(word.contains(" then ")||word.contains(" so ")||word.contains(" therefore ")||word.contains(" without ")){//then
        word = "=>";
        wordPool = wordPool + word;
        }else{
        word = "+";
        wordPool = wordPool + word;
        }
        while(wordPool.contains("++")){
            wordPool = wordPool.replace("++", "+");
        }
        while(wordPool.contains("--")){
            wordPool = wordPool.replace("-", "-");
        }    
        while(wordPool.contains("-+")||wordPool.contains("+-")){
        wordPool = wordPool.replace("-+", "-");
        wordPool = wordPool.replace("+-", "-");
        }
        System.out.println(word); 
    }//Start converting the symbols into understandable logic (Ret of rules and combinations)
    System.out.println(wordPool+"\n\n\n");
    
    wordPool = wordPool.replace("/","");

    wordPool = wordPool.replace("!V","(!p V !q)");

    wordPool = wordPool.replace("-V-","(!p V !q)");
    wordPool = wordPool.replace("-V+","(!p V q)");
    wordPool = wordPool.replace("+V-","(p V !q)");
    wordPool = wordPool.replace("+V+","(p V q)");

    wordPool = wordPool.replace("-^-","(!p ^ !q)");
    wordPool = wordPool.replace("-^+","(!p ^ q)");
    wordPool = wordPool.replace("+^-","(p ^ !q)");
    wordPool = wordPool.replace("+^+","(p ^ q)");

    wordPool = wordPool.replace("-=>+","(!p => q)");
    wordPool = wordPool.replace("+=>-","(p => !q)");
    wordPool = wordPool.replace("-=>-","(!p => !q)");
    wordPool = wordPool.replace("+=>+","(p => q)");

    wordPool = wordPool.replace("(!p V !q)=>+","(!p => q)");
    wordPool = wordPool.replace("(p V !q)=>+","(p => q)");
    wordPool = wordPool.replace("(!p V q)=>+","(p => q)");
    wordPool = wordPool.replace("(p V q)=>+","(p => q)");

    wordPool = wordPool.replace("(!p ^ !q)=>+","(!p => q)");
    wordPool = wordPool.replace("(p ^ !q)=>+","(!p => q)");
    wordPool = wordPool.replace("(!p ^ q)=>+","(!p => q)");
    wordPool = wordPool.replace("(p ^ q)=>+","(p => q)");

    wordPool = wordPool.replace("(!p V !q)=>-","(!p => !q)");
    wordPool = wordPool.replace("(p V !q)=>-","(p => !q)");
    wordPool = wordPool.replace("(!p V q)=>-","(p => !q)");
    wordPool = wordPool.replace("(p V q)=>-","(p => !q)");

    wordPool = wordPool.replace("-(p ^ q)","!(p ^ q)");
    wordPool = wordPool.replace("-(!p ^ q)","!(!p ^ q)");
    wordPool = wordPool.replace("-(p ^ !q)","!(p ^ !q)");
    wordPool = wordPool.replace("-(!p ^ !q)","!(!p ^ !q)");

    wordPool = wordPool.replace("(p V q)V(p V q)","(p V q)");
    wordPool = wordPool.replace("(p V q)Vp","(p V q)");
    wordPool = wordPool.replace("(p V q)Vq","(p V q)");

    wordPool = wordPool.replace("(p ^ q)^(p ^ q)","(p ^ q)");
    wordPool = wordPool.replace("(p ^ q)^p","(p ^ q)");
    wordPool = wordPool.replace("(p ^ q)^q","(p ^ q)");

    wordPool = wordPool.replace("!(p V q)V(p V q)","(!p V q)");
    wordPool = wordPool.replace("(p V !q)Vp","(p V q)");
    wordPool = wordPool.replace("(!p V q)Vq","(p V q)");
    wordPool = wordPool.replace("(p V !q)V!p","(p V q)");
    wordPool = wordPool.replace("(!p V q)V!q","(p V q)");

    wordPool = wordPool.replace("(p ^ q)^(p ^ q)","(p ^ q)");
    wordPool = wordPool.replace("(p ^ q)^p","(p ^ q)");
    wordPool = wordPool.replace("(p ^ q)^q","(p ^ q)");

    wordPool = wordPool.replace("(p ^ !q)","!(p ^ !q)");
    wordPool = wordPool.replace("(!p ^ !q)","!(!p ^ !q)");
    
    wordPool = wordPool.replace("-<=>+","(!p <=> q)");
    wordPool = wordPool.replace("+<=>-","(p <=> !q)");
    wordPool = wordPool.replace("+<=>+","(p <=> q)");
    wordPool = wordPool.replace("-<=>-","(!p <=> !q)");

    wordPool = wordPool.replace("+-","!q");
    wordPool = wordPool.replace("+","p");
    wordPool = wordPool.replace("-","!p");

    System.out.println(wordPool);
    txtLogic.setText(wordPool);
    clearWordBase();





   }
}