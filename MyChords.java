import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
import java.io.*; 
import javax.sound.sampled.*; 

public class MyChords extends JFrame implements ActionListener {
    JButton btn1, btn2, btn3; 
    AudioClip click; 

    public MyChords(){
        setSize(800,800);
        btn1 = new JButton("E Minor 9");
        btn2 = new JButton("A Sus 13"); 
        btn3 = new JButton("D Maj 9"); 
        setTitle("Omnichord v1.0"); 
        setLayout(new GridLayout());
        getContentPane().add(btn1); 
        getContentPane().add(btn2); 
        getContentPane().add(btn3); 

        btn1.addActionListener(MyChords.this); 
        btn2.addActionListener(MyChords.this);
        btn3.addActionListener(MyChords.this);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }
    public void playEMinor9() {
        try {
            URL url = new URL("https://mustang-data-kmp.azurewebsites.net/eMinor9.wav"); 
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url); 
            Clip clip = AudioSystem.getClip(); 
            clip.open(audioIn); 
            clip.start(); 
        }
        catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace( );
        }
    }
    public void playAsus13() {
        try {
            URL url2 = new URL("https://mustang-data-kmp.azurewebsites.net/Asus13.wav"); 
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url2); 
            Clip clip = AudioSystem.getClip(); 
            clip.open(audioIn); 
            clip.start(); 
        }
        catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace( );
        }
    }

    public void playDMaj9() {
        try {
            URL url3 = new URL("https://mustang-data-kmp.azurewebsites.net/DMaj9.wav"); 
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url3); 
            Clip clip = AudioSystem.getClip(); 
            clip.open(audioIn); 
            clip.start(); 
        }
        catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace( );
        }
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btn1) {
            playEMinor9(); 
            //click.loop();
        }
        if (e.getSource() == btn2) {
            playAsus13(); 
        }
        if (e.getSource() == btn3) {
            playDMaj9(); 
        }
    }
    public static void main(String[] args) {
        System.out.println("Omnichord starting..."); 
        System.out.println("  _      _      _" + " " + "     _      _      _" + "\n" +
        ">(.)__ <(.)__ =(.)__" + " " + ">(.)__ <(.)__ =(.)__" + "\n" + 
        " (___/  (___/  (___/" + " " + " (___/  (___/  (___/" + "\n" +
        "an internet connection is required for this program. Have fun!");
        MyChords tst = new MyChords(); 
        tst.setVisible(true); 
    }
}