package checkers_gui;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Dialog extends JDialog{
	
	private static final long serialVersionUID = 1L;
	private JLabel exit, exitQuestion, yes, no;
	private JPanel panel;
	private Image board_image;
	private MouseListener mouseListener;
	public Dialog(){
		initComponents();
		
		setSize(1010,720);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setBackground(new Color(0, 0, 0, 120));
		setLayout(null);
		
		addComponent();
	}
	public void initComponents(){
		panel = new JPanel(){
			private static final long serialVersionUID = 1L;

			@Override
		     protected void paintComponent(Graphics g) {
		    	g.drawImage(board_image, 0, 0, getWidth(), getHeight(), panel);
		     }
		  };
		setSize(700, 350);
		panel.setBounds(160, 200, 700, 350);
		panel.setOpaque(false);
		panel.setLayout(null);
		
		board_image = new ImageIcon("src/images/exit_confirm.jpg").getImage();
		mouseListener = new MouseListener();
		
		yes = new JLabel("YES", SwingConstants.CENTER);
		yes.setBounds(90, 220, 200, 50);
		yes.setFont(new Font("Helvetica", Font.BOLD, 30));
		yes.setForeground(Color.WHITE);
		yes.setBackground(new Color(0, 0, 0, 100));
		yes.setOpaque(true);
		yes.addMouseListener(mouseListener);
		
		no = new JLabel("NO",SwingConstants.CENTER);
		no.setBounds(400, 220, 200, 50);
		no.setFont(new Font("Helvetica", Font.BOLD, 30));
		no.setForeground(Color.WHITE);
		no.setBackground(new Color(0, 0, 0, 100));
		no.setOpaque(true);
		no.addMouseListener(mouseListener);
	}
	public void addComponent(){
		add(panel);
		panel.add(yes);
		panel.add(no);
	}
	public void exit(){
		exit = new JLabel("EXIT CONFIRMATION");
		exit.setBounds(90, 40, 600, 50);
		exit.setFont(new Font("Helvetica", Font.BOLD+Font.ITALIC, 50));
		exit.setForeground(Color.WHITE);
		
		exitQuestion = new JLabel("Are you sure you want to exit?");
		exitQuestion.setBounds(60, 125, 600, 50);
		exitQuestion.setFont(new Font("Helvetica", Font.BOLD, 40));
		exitQuestion.setForeground(Color.WHITE);
		
		panel.add(exit);
		panel.add(exitQuestion);
		setVisible(true);
	}
	public void settings(){
		setVisible(true);
	}
	public Dialog outer(){
		return Dialog.this;
	}
	private class MouseListener extends MouseAdapter{
		public void mouseEntered(MouseEvent e){
			Object obj = e.getSource();
			
			if(obj == yes){
				yes.setFont(new Font("Helvetica", Font.BOLD, 35));
				yes.setForeground(Color.RED);
				yes.setOpaque(true);
			}
			else if(obj == no){
				no.setFont(new Font("Helvetica", Font.BOLD, 35));
				no.setForeground(Color.RED);
				no.setOpaque(true);
			}
			repaint();
			revalidate();
		}
		public void mouseExited(MouseEvent e){
			Object obj = e.getSource();
			
			if(obj == yes){
				yes.setFont(new Font("Helvetica", Font.BOLD, 30));
				yes.setForeground(Color.WHITE);
				yes.setOpaque(true);
			}
			else if(obj == no){
				no.setFont(new Font("Helvetica", Font.BOLD, 30));
				no.setForeground(Color.WHITE);
				no.setOpaque(true);
			}
			repaint();
			revalidate();
		}
		public void mouseClicked(MouseEvent e){
			Object obj = e.getSource();
			
			if(obj == yes){
				System.exit(0);
			}
			else if(obj == no){
				outer().dispose();
			}
			repaint();
			revalidate();
		}
	}
}