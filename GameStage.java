import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameStage extends JFrame {
	JButton b1;
	JButton b2;
	JButton b3;
	JPanel panel;
	ImageIcon img;
	public GameStage(){
		b1 = new JButton("Start game");
		b2 = new JButton("Sound");
		b3 = new JButton("Exit");
		img  = new ImageIcon(getClass().getResource("titleset_air.jpg").getFile());
		//panel.setBackground(new Color(img));
	}
}
