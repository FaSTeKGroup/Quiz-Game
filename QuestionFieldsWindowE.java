import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QuestionFieldsWindowE implements ActionListener {

	JFrame QuestionFieldsWindow = new JFrame("Quiz Game");
	
	JMenuBar menuBar = new JMenuBar();
	JMenu file = new JMenu("File");
	JMenuItem howToPlay = new JMenuItem("How To Play");
	JMenuItem changeColor = new JMenuItem("Change Color");
	JMenuItem highScor = new JMenuItem("Highest score");
	ImageIcon im = new ImageIcon(getClass().getResource("/img/logo.png"));
	
	/*QuestionFieldsPanel continer*/
	JLabel chooseQuestionFields=new JLabel();
	static JCheckBox hisCheckBox =new JCheckBox();
	static JCheckBox geoCheckBox =new JCheckBox();
	static JCheckBox religCheckBox =new JCheckBox();
	static JCheckBox scienCheckBox =new JCheckBox();
	static JCheckBox progCheckBox =new JCheckBox();
	static JCheckBox sportCheckBox =new JCheckBox();
	static JCheckBox ArtCheckBox =new JCheckBox();
	JButton playNowButton =new JButton();
	
	public QuestionFieldsWindowE(){

		QuestionFieldsWindow.setSize(650, 650);
		QuestionFieldsWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		QuestionFieldsWindow.getContentPane().setBackground(Methods.backgroundColor);
		QuestionFieldsWindow.setResizable(false);
		QuestionFieldsWindow.setLayout(null);
		QuestionFieldsWindow.setIconImage(im.getImage());
	
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
	
		/*choose Question fields properties */
		chooseQuestionFields.setBounds(0, 0, 650,100);
		chooseQuestionFields.setText("Choose the questions fields");
		chooseQuestionFields.setBorder(BorderFactory.createEtchedBorder(1));
		chooseQuestionFields.setBackground(Methods.backgroundColor);
		chooseQuestionFields.setForeground(Methods.foregroundColor);
		chooseQuestionFields.setFont(new Font("Serif",Font.BOLD,30));
		chooseQuestionFields.setHorizontalAlignment(JTextField.CENTER);
	
		/* CheckBoxs properties */
		hisCheckBox.setText("Historical");
		hisCheckBox.setBounds(100,160,150,50);
		hisCheckBox.setBackground(Methods.borderColor);
		hisCheckBox.setForeground(Methods.foregroundColor);
		hisCheckBox.setFont(new Font("Serif",Font.BOLD,20));
		
		geoCheckBox.setText("Geography");
		geoCheckBox.setBounds(400,160,150,50);
		geoCheckBox.setBackground(Methods.borderColor);
		geoCheckBox.setForeground(Methods.foregroundColor);
		geoCheckBox.setFont(new Font("Serif",Font.BOLD,20));

		religCheckBox.setText("Religious");
		religCheckBox.setBounds(100,230,150,50);
		religCheckBox.setBackground(Methods.borderColor);
		religCheckBox.setForeground(Methods.foregroundColor);
		religCheckBox.setFont(new Font("Serif",Font.BOLD,20));

		scienCheckBox.setText("Scientific");
		scienCheckBox.setBounds(400,230,150,50);
		scienCheckBox.setBackground(Methods.borderColor);
		scienCheckBox.setForeground(Methods.foregroundColor);
		scienCheckBox.setFont(new Font("Serif",Font.BOLD,20));

		progCheckBox.setText("Programming");
		progCheckBox.setBounds(100,300,150,50);
		progCheckBox.setBackground(Methods.borderColor);
		progCheckBox.setForeground(Methods.foregroundColor);
		progCheckBox.setFont(new Font("Serif",Font.BOLD,20));

		sportCheckBox.setText("Sport");
		sportCheckBox.setBounds(400,300,150,50);
		sportCheckBox.setBackground(Methods.borderColor);
		sportCheckBox.setForeground(Methods.foregroundColor);
		sportCheckBox.setFont(new Font("Serif",Font.BOLD,20));

		ArtCheckBox.setText("Animation");
		ArtCheckBox.setBounds(250,370,150,50);
		ArtCheckBox.setBackground(Methods.borderColor);
		ArtCheckBox.setForeground(Methods.foregroundColor);
		ArtCheckBox.setFont(new Font("Serif",Font.BOLD,20));
	
		/*Play Now Button properties */
		playNowButton.setBounds(175, 460, 300 , 70);
		playNowButton.setFont(new Font("Serif",Font.BOLD,30));
		playNowButton.setFocusable(false);
		playNowButton.addActionListener(this);
		playNowButton.setText("Start playing");
		playNowButton.setBackground(new Color(40,40,40));
		playNowButton.setForeground(Methods.foregroundColor);
		playNowButton.setBorder(BorderFactory.createLineBorder(Methods.borderColor,3,true));
		playNowButton.addMouseListener(new java.awt.event.MouseAdapter() {
	
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				playNowButton.setBackground(Methods.borderColor);
			}
	
			public void mouseExited(java.awt.event.MouseEvent evt) {
				playNowButton.setBackground(new Color(40,40,40));
			}
		});
		
		/*Adding QuestionFieldsWindow */
		QuestionFieldsWindow.add(hisCheckBox);  	
		QuestionFieldsWindow.add(geoCheckBox);  	
		QuestionFieldsWindow.add(religCheckBox); 	
		QuestionFieldsWindow.add(scienCheckBox);	
		QuestionFieldsWindow.add(progCheckBox);  
		QuestionFieldsWindow.add(sportCheckBox); 	
		QuestionFieldsWindow.add(ArtCheckBox);
		QuestionFieldsWindow.setJMenuBar(menuBar);
		QuestionFieldsWindow.add(chooseQuestionFields);		
		QuestionFieldsWindow.add(playNowButton);	
		
		QuestionFieldsWindow.setVisible(true);
        QuestionFieldsWindow.setLocation(350, 40);
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==playNowButton){

			if(hisCheckBox.isSelected()|| geoCheckBox.isSelected()||
				religCheckBox.isSelected() || scienCheckBox.isSelected() || 
				progCheckBox.isSelected() || sportCheckBox.isSelected() || ArtCheckBox.isSelected()){

					new QuestionWindowE();
					QuestionFieldsWindow.setVisible(false);
			}
			
			else{
			
				JDialog dialog = new JDialog(QuestionFieldsWindow);
				final JLabel l = new JLabel("At least one Field must be selected");
				JButton b = new JButton("Ok");
				dialog.setIconImage(im.getImage());

				dialog.setLocationRelativeTo(QuestionFieldsWindow);
				dialog.setLayout(null);
				dialog.setSize(340, 170);
				dialog.setModal(false);
				dialog.setLocation(500,300);
				dialog.add(l);
				dialog.add(b);
				dialog.setVisible(true);
				dialog.getContentPane().setBackground(Methods.backgroundColor);
				dialog.setResizable(false);
				dialog.setLayout(null);
				
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
						dialog.setVisible(false);
					}
				});

				l.setBounds(10,10,310,50);
				l.setBorder(BorderFactory.createEtchedBorder(1));
				l.setBackground(Methods.backgroundColor);
				l.setForeground(Methods.foregroundColor);
				l.setFont(new Font("Serif",Font.BOLD,18));
				l.setHorizontalAlignment(JTextField.CENTER);
			}
		}

		/*how to play action (dialog window ) */
		if(e.getSource() == howToPlay){
		
			JDialog H_P = new JDialog(QuestionFieldsWindow , "How To Play");
			JTextArea howToPlay_text  =new JTextArea();
			JButton b = new JButton("Ok");
			
			H_P.setIconImage(im.getImage());
			H_P.setLocationRelativeTo(QuestionFieldsWindow);
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
				hisCheckBox.setBackground(Methods.borderColor);
				geoCheckBox.setBackground(Methods.borderColor);
				religCheckBox.setBackground(Methods.borderColor);
				scienCheckBox.setBackground(Methods.borderColor);
				progCheckBox.setBackground(Methods.borderColor);
				sportCheckBox.setBackground(Methods.borderColor);
				ArtCheckBox.setBackground(Methods.borderColor);
				playNowButton.setBorder(BorderFactory.createLineBorder(Methods.borderColor,3,true));
			}
		}
		
		if(e.getSource() == highScor){
		
			JDialog H_S = new JDialog(QuestionFieldsWindow,"Best Score");
			final JLabel l = new JLabel("Best Score" + (Methods.readBestScorefromTheFile()) + " %");
			JButton b = new JButton("Ok");

			H_S.setIconImage(im.getImage());
			H_S.setLocationRelativeTo(QuestionFieldsWindow);
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

	/* method return which  fields are selected */ 
	static boolean HistoricalIsSelected(){
	
		return hisCheckBox.isSelected();
	
	}
	
	static boolean GeographylIsSelected(){
	
		return geoCheckBox.isSelected();
	
	}
	
	static boolean ReligiousIsSelected(){
	
		return religCheckBox.isSelected();
	
	}
	
	static boolean ScientificIsSelected(){
	
		return scienCheckBox.isSelected();
	
	}
	
	static boolean ProgramminglIsSelected(){
	
		return progCheckBox.isSelected();
	
	}
	
	static boolean SportIsSelected(){
	
		return sportCheckBox.isSelected();
	
	}
	
	static boolean ArtisticIsSelected(){
	
		return ArtCheckBox.isSelected();
	
	}
	
	static void InSelected() {
	
		hisCheckBox.setSelected(false);
		geoCheckBox.setSelected(false);
		religCheckBox.setSelected(false);
		scienCheckBox.setSelected(false);
		progCheckBox.setSelected(false);
		sportCheckBox.setSelected(false);
		ArtCheckBox.setSelected(false);
	
	}
}
