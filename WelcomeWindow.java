import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WelcomeWindow implements ActionListener {

	JFrame welcomeWindow = new JFrame("Quiz Game");

	/*welcomeWindow  continer*/
	JLabel logoLabel =new JLabel(new ImageIcon(getClass().getResource("/img/logo.png")));
	JButton arabicLangugeButton =new JButton();
	JButton englishLangugeButton =new JButton();
	ImageIcon im = new ImageIcon(getClass().getResource("/img/logo.png"));

	public WelcomeWindow() {

		welcomeWindow.setSize(650, 650);
		welcomeWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcomeWindow.getContentPane().setBackground(new Color(69,69,69));
		welcomeWindow.setResizable(false);
		welcomeWindow.setLayout(null);
		welcomeWindow.setIconImage(im.getImage());

		/*logoLabel properties*/
		logoLabel.setBounds(68,10,500,350);
		logoLabel.setBackground(Methods.borderColor);
		logoLabel.setForeground(Methods.foregroundColor);
		logoLabel.setBorder(BorderFactory.createEtchedBorder(1));
		logoLabel.setFont(new Font("Serif",Font.BOLD,30));
		logoLabel.setHorizontalAlignment(JTextField.CENTER);

		/*arabicLangugeButton properties*/
		arabicLangugeButton.setBounds(175,380, 300 , 70);
		arabicLangugeButton.setFont(new Font("Serif",Font.BOLD,30));
		arabicLangugeButton.setFocusable(false);
		arabicLangugeButton.addActionListener(this);
		arabicLangugeButton.setText(" Arabic العربية");
		arabicLangugeButton.setBackground(new Color(40,40,40));
		arabicLangugeButton.setForeground(Methods.foregroundColor);
		arabicLangugeButton.setBorder(BorderFactory.createLineBorder(Methods.borderColor,3,true));

		/* Adding Hover */
		arabicLangugeButton.addMouseListener(new java.awt.event.MouseAdapter() {

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				arabicLangugeButton.setBackground(Methods.borderColor);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				arabicLangugeButton.setBackground(new Color(40,40,40));
			}
		});

		/*englishLangugeButton properties*/
		englishLangugeButton.setBounds(175, 480,300, 70);
		englishLangugeButton.setFont(new Font("Serif",Font.BOLD,30));
		englishLangugeButton.setFocusable(false);
		englishLangugeButton.addActionListener(this);
		englishLangugeButton.setText("English الإنجليزية");
		englishLangugeButton.setBackground(new Color(40,40,40));
		englishLangugeButton.setForeground(Methods.foregroundColor);
		englishLangugeButton.setBorder(BorderFactory.createLineBorder(Methods.borderColor,3,true));
			/* Adding Hover */
		englishLangugeButton.addMouseListener(new java.awt.event.MouseAdapter() {

			public void mouseEntered(java.awt.event.MouseEvent evt) {
				englishLangugeButton.setBackground(Methods.borderColor);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				englishLangugeButton.setBackground(new Color(40,40,40));
			}
		});

		/* Adding continer welcomeWindow */
		welcomeWindow.add(logoLabel);
		welcomeWindow.add(arabicLangugeButton);
		welcomeWindow.add(englishLangugeButton);
		
		welcomeWindow.setVisible(true);
		welcomeWindow.setLocation(350,40);
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == arabicLangugeButton){
			new LevelWindow();
			welcomeWindow.setVisible(false);
		}
	
		if(e.getSource() == englishLangugeButton){
			new LevelWindowE();
			welcomeWindow.setVisible(false);
		}
	}
	
}
