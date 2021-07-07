import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ResltatWindowE implements ActionListener {

	JFrame resltatWindow = new JFrame("Quiz Game");

	JMenuBar menuBar = new JMenuBar();
	JMenu file = new JMenu("File");
	JMenuItem howToPlay = new JMenuItem("How To Play");
	JMenuItem changeColor = new JMenuItem("Change Color");
	JMenuItem highScor = new JMenuItem("Highest score");
	ImageIcon im = new ImageIcon(getClass().getResource("/img/logo.png"));
	
	/*resltatPanel continer*/
	JPanel remAndRusl = new JPanel();
	JTextField remark =new JTextField();
	JTextField highestScore =new JTextField();
	JTextField numberRight =new JTextField();
	JTextField percentage =new JTextField();
	JButton replayButton =new JButton();
	JButton ExitButton =new JButton();
	
	public ResltatWindowE() {
	
		resltatWindow.setSize(650, 650);
		resltatWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		resltatWindow.getContentPane().setBackground(new Color(69,69,69));
		resltatWindow.setResizable(false);
		resltatWindow.setLayout(null);
		resltatWindow.setIconImage(im.getImage());
	
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
	
		/*remark and resltat panel properties  */
		remAndRusl.setBounds(40,40,550,360);
		remAndRusl.setBackground(new Color(40,40,40));
		remAndRusl.setLayout(null);
	
		/*remark properties */
		remAndRusl.add(remark);
		remark.setBounds(0, 0, 550, 90);
		remark.setText(getRemark());
		remark.setBorder(BorderFactory.createEtchedBorder(1));
		remark.setBackground(Methods.backgroundColor);
		remark.setForeground(Methods.foregroundColor);
		remark.setFont(new Font("Serif",Font.BOLD,30));
		remark.setHorizontalAlignment(JTextField.CENTER);
		remark.setEditable(false);
	
		/* highest Score properties */
		remAndRusl.add(highestScore);
		highestScore.setBounds(0, 90,550,90);
		highestScore.setText(" Best Score  " + Methods.readBestScorefromTheFile() +" % " );
		highestScore.setBorder(BorderFactory.createEtchedBorder(1));
		highestScore.setBackground(Methods.backgroundColor);
		highestScore.setForeground(Methods.foregroundColor);
		highestScore.setFont(new Font("Serif",Font.BOLD,30));
		highestScore.setHorizontalAlignment(JTextField.LEFT);
		highestScore.setEditable(false);
	
		/*number right properties */
		remAndRusl.add(numberRight);
		numberRight.setBounds(0, 180, 550, 90);
		numberRight.setText(" Right answers " + QuestionWindowE.numberRight() );
		numberRight.setBorder(BorderFactory.createEtchedBorder(1));
		numberRight.setBackground(Methods.backgroundColor);
		numberRight.setForeground(Methods.foregroundColor);
		numberRight.setFont(new Font("Serif",Font.BOLD,30));
		numberRight.setHorizontalAlignment(JTextField.LEFT);
		numberRight.setEditable(false);
	
		/*percentage properties */
		remAndRusl.add(percentage);
		percentage.setBounds(0, 270, 550, 90);
		percentage.setText( " Percentage "+ QuestionWindowE.results() +" % " );
		percentage.setBorder(BorderFactory.createEtchedBorder(1));
		percentage.setBackground(Methods.backgroundColor);
		percentage.setForeground(Methods.foregroundColor);
		percentage.setFont(new Font("Serif",Font.BOLD,30));
		percentage.setHorizontalAlignment(JTextField.LEFT);
		percentage.setEditable(false);

		highestScore.setBackground(Methods.borderColor);
		remark.setBackground(Methods.borderColor);
		numberRight.setBackground(Methods.borderColor);
		percentage.setBackground(Methods.borderColor);
		replayButton.setBackground(Methods.borderColor);
	
		/*replay Button properties */
		replayButton.setBounds(350 ,435, 200 , 70);
		replayButton.setFont(new Font("Serif",Font.BOLD,30));
		replayButton.setFocusable(false);
		replayButton.addActionListener(this);
		replayButton.setText("Replay");
		replayButton.setBackground(new Color(40,40,40));
		replayButton.setForeground(Methods.foregroundColor);
		replayButton.setBorder(BorderFactory.createLineBorder(Methods.borderColor,3,true));
		replayButton.addMouseListener(new java.awt.event.MouseAdapter() {
		
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				replayButton.setBackground(Methods.borderColor);
			}
		
			public void mouseExited(java.awt.event.MouseEvent evt) {
				replayButton.setBackground(new Color(40,40,40));
			}
		});
	
		/*Exit Button properties */
		ExitButton.setBounds(80,435 , 200 ,70);
		ExitButton.setFont(new Font("Serif",Font.BOLD,30));
		ExitButton.setFocusable(false);
		ExitButton.addActionListener(this);
		ExitButton.setText("Exit");
		ExitButton.setBackground(new Color(40,40,40));
		ExitButton.setForeground(Methods.foregroundColor);
		ExitButton.setBorder(BorderFactory.createLineBorder(Methods.borderColor,3,true));
		ExitButton.addMouseListener(new java.awt.event.MouseAdapter() {
	
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				ExitButton.setBackground(Methods.borderColor);
			}
	
			public void mouseExited(java.awt.event.MouseEvent evt) {
				ExitButton.setBackground(new Color(40,40,40));
			}
		});
		
		/* Adding resltatWindow */
		resltatWindow.add(remAndRusl);		
		resltatWindow.add(replayButton);
		resltatWindow.add(ExitButton);
		resltatWindow.setJMenuBar(menuBar);
	
		resltatWindow.setVisible(true);
		resltatWindow.setLocation(350, 40);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == ExitButton ) {
	
			Methods.writeBestScoreInTheFile();
			System.exit(0);
	
		}
	
		if(e.getSource() == replayButton){
	
			Methods.writeBestScoreInTheFile();
			QuestionFieldsWindowE.InSelected();
			new WelcomeWindow();
			resltatWindow.setVisible(false);
	
		}
	
		if(e.getSource() == howToPlay){
	
			JDialog H_P = new JDialog(resltatWindow , "How To Play");
			JTextArea howToPlay_text  =new JTextArea();
			JButton b = new JButton("Ok");
			
			H_P.setIconImage(im.getImage());
			H_P.setLocationRelativeTo(resltatWindow);
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
				highestScore.setBackground(Methods.borderColor);
				remark.setBackground(Methods.borderColor);
				numberRight.setBackground(Methods.borderColor);
				percentage.setBackground(Methods.borderColor);
				replayButton.setBackground(Methods.borderColor);
				replayButton.setBorder(BorderFactory.createLineBorder(Methods.borderColor,3,true));
				ExitButton.setBackground(Methods.borderColor);
				ExitButton.setBorder(BorderFactory.createLineBorder(Methods.borderColor,3,true));
		
			}
		}
		
		if(e.getSource() == highScor){
		
			JDialog H_S = new JDialog(resltatWindow,"Best Score");
			final JLabel l = new JLabel("Best Score" + (Methods.readBestScorefromTheFile()) + " %");
			JButton b = new JButton("Ok");

			H_S.setIconImage(im.getImage());
			H_S.setLocationRelativeTo(resltatWindow);
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
	
	/*method return Remark */
	String getRemark(){
	
		String r = "" ;
	
		if(QuestionWindow.results() <= 20)
			r = "You can do better";
	
		if(20 < QuestionWindow.results() && QuestionWindow.results() <= 40)
			r = "Keep learning";
	
		if(40 < QuestionWindow.results() && QuestionWindow.results() <= 60)
			r = "Well done,but you lack a little focus";
		
		if(60 < QuestionWindow.results() && QuestionWindow.results() <= 80)
			r = "You have good skills";
	
		if(80 < QuestionWindow.results())
			r = "Great standard and excellent job";

		return r;
	}

}
