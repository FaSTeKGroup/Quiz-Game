import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LevelWindowE implements ActionListener {

	JFrame levelWindow = new JFrame("Quiz Game");

	JMenuBar menuBar = new JMenuBar();
	JMenu file = new JMenu("File");
	JMenuItem howToPlay = new JMenuItem("How To Play");
	JMenuItem changeColor = new JMenuItem("Change Color");
	JMenuItem highScor = new JMenuItem("Highest score");
	ImageIcon im = new ImageIcon(getClass().getResource("/img/logo.png"));

	/*levelWindow continer*/
	JLabel chooseLevel=new JLabel("Select the level");
	
	static JRadioButton begginerRadioButton = new JRadioButton("Easy",true);
	static JRadioButton middleRadioButton = new JRadioButton("Medium");
	static JRadioButton higherRadioButton = new JRadioButton("Hard");
	JButton nextPageButton = new JButton("Next");
	ButtonGroup group = new ButtonGroup();
	
	public LevelWindowE() {
		
		levelWindow.setSize(650, 650);
		levelWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		levelWindow.getContentPane().setBackground(new Color(69,69,69));
		levelWindow.setResizable(false);
		levelWindow.setLayout(null);
		levelWindow.setIconImage(im.getImage());
	
		/*adding menu bar and items */
		menuBar.add(file);
		file.add(changeColor);
		file.add(howToPlay);
		file.add(highScor);
		menuBar.setBorder(BorderFactory.createEtchedBorder(1));
		menuBar.setBackground(new Color(100,100,100));
		file.setFont(new Font("Serif",Font.PLAIN,20));
		changeColor.addActionListener(this);
		howToPlay.addActionListener(this);
		highScor.addActionListener(this);
	
		/*choose Level Label properties */
		chooseLevel.setBounds(0, 20, 650, 100);
		chooseLevel.setBorder(BorderFactory.createEtchedBorder(1));
		chooseLevel.setBackground(Methods.backgroundColor);
		chooseLevel.setForeground(Methods.foregroundColor);
		chooseLevel.setFont(new Font("Serif",Font.BOLD,30));
		chooseLevel.setHorizontalAlignment(JTextField.CENTER);
	
		/* Radio Buttons properties */
		group.add(begginerRadioButton);
		group.add(middleRadioButton);
		group.add(higherRadioButton);
		begginerRadioButton.setBounds(250, 170,160,70);
		begginerRadioButton.setBackground(Methods.borderColor);
		begginerRadioButton.setForeground(Methods.foregroundColor);
		begginerRadioButton.setFont(new Font("Serif",Font.BOLD,30));

		middleRadioButton.setBounds(250,255, 160,70);
		middleRadioButton.setBackground(Methods.borderColor);
		middleRadioButton.setForeground(Methods.foregroundColor);
		middleRadioButton.setFont(new Font("Serif",Font.BOLD,30));

		higherRadioButton.setBounds(250, 340, 160,70);
		higherRadioButton.setBackground(Methods.borderColor);
		higherRadioButton.setForeground(Methods.foregroundColor);
		higherRadioButton.setFont(new Font("Serif",Font.BOLD,30));
	
		/*next Page button properties */
		nextPageButton.setBounds(175, 450, 300 , 70);
		nextPageButton.setFont(new Font("Serif",Font.BOLD,30));
		nextPageButton.setFocusable(false);
		nextPageButton.addActionListener(this);
		nextPageButton.setBackground(new Color(40,40,40));
		nextPageButton.setForeground(Methods.foregroundColor);
		nextPageButton.setBorder(BorderFactory.createLineBorder(Methods.borderColor,3,true));
		nextPageButton.addMouseListener(new java.awt.event.MouseAdapter() {
	
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				nextPageButton.setBackground(Methods.borderColor);
			}
	
			public void mouseExited(java.awt.event.MouseEvent evt) {
				nextPageButton.setBackground(new Color(40,40,40));
			}

		});

		/*Adding levelWindow */
		levelWindow.add(chooseLevel);		
		levelWindow.add(begginerRadioButton);	
		levelWindow.add(middleRadioButton);	
		levelWindow.add(higherRadioButton);
		levelWindow.add(nextPageButton);
		levelWindow.setJMenuBar(menuBar);

		levelWindow.setVisible(true);
        levelWindow.setLocation(350, 40);
	}
	
	/* -/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/- */
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == nextPageButton ){
			new QuestionFieldsWindowE();
			levelWindow.setVisible(false);
		}

		/*how to play action (dialog window ) */
		if(e.getSource() == howToPlay){
			JDialog H_P = new JDialog(levelWindow , "How To Play");
			JTextArea howToPlay_text  =new JTextArea();
			JButton b = new JButton("Ok");
			
			H_P.setIconImage(im.getImage());
			H_P.setLocationRelativeTo(levelWindow);
			H_P.setLayout(null);
			H_P.setSize(800,500);
			H_P.setModal(false);
			H_P.setLocation(280,100);
			H_P.add(b);
			H_P.add(howToPlay_text);
			H_P.setVisible(true);
			H_P.getContentPane().setBackground(Methods.backgroundColor);
			H_P.setResizable(false);
			H_P.setLayout(null);

			howToPlay_text.setBounds(18,20,750,360);
			howToPlay_text.setLineWrap(true);
			howToPlay_text.setWrapStyleWord(true);
			howToPlay_text.setBackground(Methods.backgroundColor);
			howToPlay_text.setForeground(Methods.foregroundColor);
			howToPlay_text.setFont(new Font("Serif",Font.BOLD,22));
			howToPlay_text.setEditable(false);
			howToPlay_text.setText("Welcome to the most educational and fun games, where you can educate yourself in a fun and interesting way, and in your own way, you can choose your own world that you belong to you can choose your favorite colore, and make it to correct the background of the game , aslo you may choose others fields categories such as Historical, religoins, or scientific, To make the game more competitive and intresting, you can definer your playing level. \nThis game is shorted in some of the rulese : \n- To have three levels ( Easy, Medium and Hard ), which are measured by the response time for each question for each level ** Easy 12 seconds  ** Medium 10 seconds ** Hard 8 seconds\nIn each field there are 10 questions and in each question there are three suggestions of which only one is correct.");

			b.setBounds(340, 400, 80, 40);
			b.setFont(new Font("Serif",Font.BOLD,25));
			b.setFocusable(false);
			b.setBackground(new Color(40,40,40));
			b.setForeground(Methods.foregroundColor);
			b.setBorder(BorderFactory.createLineBorder(Methods.borderColor,2,true));
			b.addMouseListener(new java.awt.event.MouseAdapter() {

				public void mouseEntered(java.awt.event.MouseEvent evt) {
					b.setBackground(Methods.borderColor);
				}

				public void mouseExited(java.awt.event.MouseEvent evt) {
					b.setBackground(new Color(40,40,40));
				}
			});
			b.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					H_P.setVisible(false);
				}
			});
		}
		
		if(e.getSource() == changeColor){
		
			Color c = JColorChooser.showDialog(null,"Color Chooser", Methods.borderColor);
			if (c !=null ){
				Methods.ChangeColor(c);
				chooseLevel.setBackground(Methods.borderColor);
				begginerRadioButton.setBackground(Methods.borderColor);
				middleRadioButton.setBackground(Methods.borderColor);
				higherRadioButton.setBackground(Methods.borderColor);
				nextPageButton.setBackground(Methods.borderColor);
				nextPageButton.setBorder(BorderFactory.createLineBorder(Methods.borderColor,3,true));
			}
		}
		
		if(e.getSource() == highScor){
		
			JDialog H_S = new JDialog(levelWindow,"Best Score");
			final JLabel l = new JLabel("Best Score" + (Methods.readBestScorefromTheFile()) + " %");
			JButton b = new JButton("Ok");

			H_S.setIconImage(im.getImage());
			H_S.setLocationRelativeTo(levelWindow);
			H_S.setLayout(null);
			H_S.setSize(340, 170);
			H_S.setModal(false);
			H_S.setLocation(500,300);
			H_S.add(l);
			H_S.add(b);
			H_S.setVisible(true);
			H_S.getContentPane().setBackground(Methods.backgroundColor);
			H_S.setResizable(false);
			H_S.setLayout(null);

			b.setBounds(120, 70, 80, 40);
			b.setFont(new Font("Serif",Font.BOLD,25));
			b.setFocusable(false);
			b.setBackground(new Color(40,40,40));
			b.setForeground(Methods.foregroundColor);
			b.setBorder(BorderFactory.createLineBorder(Methods.borderColor,2,true));
			b.addMouseListener(new java.awt.event.MouseAdapter() {
		
				public void mouseEntered(java.awt.event.MouseEvent evt) {
					b.setBackground(Methods.borderColor);
				}
		
				public void mouseExited(java.awt.event.MouseEvent evt) {
					b.setBackground(new Color(40,40,40));
				}
			});
			b.addActionListener(new ActionListener() {
		
				@Override
				public void actionPerformed(ActionEvent e) {
					H_S.setVisible(false);
				}
			});

			l.setBounds(10,10,310,50);
			l.setBorder(BorderFactory.createEtchedBorder(1));
			l.setBackground(Methods.backgroundColor);
			l.setForeground(Methods.foregroundColor);
			l.setFont(new Font("Serif",Font.BOLD,24));
			l.setHorizontalAlignment(JTextField.CENTER);
		}		
	}
	
	/* method return which level is selected */
	static char WhichLevelIsSelected(){
	
		if(higherRadioButton.isSelected())
			return 'H';
	
		else if(middleRadioButton.isSelected())
			return 'M';
	
		else
			return 'B';
	}
}
