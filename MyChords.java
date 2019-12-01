import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
import java.io.*; 
import javax.sound.sampled.*; 

public class MyChords extends JFrame implements ActionListener {
    JButton btn1, btn2; 
    // AudioClip click; 

    public MyChords(){
        setSize(800,800);
        btn1 = new JButton("test");
        btn2 = new JButton("stop test"); 
        setTitle("Omnichordv1.0"); 
        setLayout(new FlowLayout());
        getContentPane().add(btn1); 
        getContentPane().add(btn2); 

        btn1.addActionListener(MyChords.this); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }
    public void playSound(String soundName) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }
        catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace( );
        }
    } 

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btn1) {
            playSound("test.wav"); 
            click.loop();
        }
        if (e.getSource() == btn2) {
            click.stop(); 
        }
    }
    public static void main(String[] args) {
        System.out.println("Omnichord starting..."); 
        MyChords tst = new MyChords(); 
        tst.setVisible(true); 
    }
}