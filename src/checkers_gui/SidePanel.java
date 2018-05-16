package checkers_gui;
import java.awt.*;

import javax.swing.*;
//http://www.twoplayergames.org/files/mobile_games/o1/Master_Checkers/sounds/king.mp3
//https://www.pixlis.com/background-image-checkers-chequered-checkered-squares-seamless-tileable-porsche-saddle-brown-236nr7.html
//https://codecanyon.net/item/master-checkers-html5-board-game/12469262
//https://cdn.tutsplus.com/psd/uploads/2014/02/checkersGameInterface0.jpg
@SuppressWarnings("serial")
public class SidePanel extends JPanel{
	private ImageIcon background;
	public SidePanel(ImageIcon icon) {
		background = icon;
		setLayout(null);
		//setPreferredSize(new Dimension(180,400));
	}
	Image board_image = background.getImage();
	public void paintComponent(Graphics g) {
		g.drawImage(board_image, 0, 0, getWidth(), getHeight(), this);
	}
}

