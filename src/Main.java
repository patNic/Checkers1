//import javax.swing.JFrame;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import checkers_gui.Launcher;
//import checkers_gui.MainPanel;

public class Main {
	public static void main(String[] args) {
		Launcher l = new Launcher();
		playAudio(l);
		/*JFrame f = new JFrame();
		MainPanel b = new MainPanel();
		f.add(b);
		f.setSize(1020,730);
		f.setVisible(true);
		f.setResizable(false);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
	}
	public static void playAudio(Launcher launch) {
		 try {
	         URL url = launch.getClass().getClassLoader().getResource("ot_soundtrack.wav");
	         System.out.println(url);
	         AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
	         Clip clip = AudioSystem.getClip();
	         clip.open(audioInputStream);
	         clip.loop(Clip.LOOP_CONTINUOUSLY);
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
		
	}
}