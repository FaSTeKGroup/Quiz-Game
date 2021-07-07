import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ResltatWindow implements ActionListener {

	JFrame resltatWindow = new JFrame("Quiz Game");
	
	JMenuBar menuBar = new JMenuBar();
	JMenu file = new JMenu("ملف");
	JMenuItem howToPlay = new JMenuItem("كيفية اللعب");
	JMenuItem changeColor = new JMenuItem("تغيير اللون ");
	JMenuItem highScor = new JMenuItem("أعلى تحصيل");
	ImageIcon im = new ImageIcon(getClass().getResource("/img/logo.png"));
	
	/*resltatPanel continer*/
	JPanel remAndRusl = new JPanel();
	JTextField remark =new JTextField();
	JTextField highestScore =new JTextField();
	JTextField numberRight =new JTextField();
	JTextField percentage =new JTextField();
	JButton replayButton =new JButton();
	JButton ExitButton =new JButton();
	
	public ResltatWindow() {
	
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
		highestScore.setText("  %  "+ ( Methods.readBestScorefromTheFile() ) + " أعلى تحصيل  " );
		highestScore.setBorder(BorderFactory.createEtchedBorder(1));
		highestScore.setBackground(Methods.backgroundColor);
		highestScore.setForeground(Methods.foregroundColor);
		highestScore.setFont(new Font("Serif",Font.BOLD,30));
		highestScore.setHorizontalAlignment(JTextField.RIGHT);
		highestScore.setEditable(false);
	
		/*number right properties */
		remAndRusl.add(numberRight);
		numberRight.setBounds(0, 180, 550, 90);
		numberRight.setText("  عدد الأجوبة الصحيحة  " + QuestionWindow.numberRight() );
		numberRight.setBorder(BorderFactory.createEtchedBorder(1));
		numberRight.setBackground(Methods.backgroundColor);
		numberRight.setForeground(Methods.foregroundColor);
		numberRight.setFont(new Font("Serif",Font.BOLD,30));
		numberRight.setHorizontalAlignment(JTextField.RIGHT);
		numberRight.setEditable(false);
	
		/*percentage properties */
		remAndRusl.add(percentage);
		percentage.setBounds(0, 270, 550, 90);
		percentage.setText( "  %  "+ QuestionWindow.results() +" نسبة الأجوبة الصحيحة  " );
		percentage.setBorder(BorderFactory.createEtchedBorder(1));
		percentage.setBackground(Methods.backgroundColor);
		percentage.setForeground(Methods.foregroundColor);
		percentage.setFont(new Font("Serif",Font.BOLD,30));
		percentage.setHorizontalAlignment(JTextField.RIGHT);
		percentage.setEditable(false);

		highestScore.setBackground(Methods.borderColor);
		remark.setBackground(Methods.borderColor);
		numberRight.setBackground(Methods.borderColor);
		percentage.setBackground(Methods.borderColor);
		replayButton.setBackground(Methods.borderColor);
	
		/*replay Button properties */
		replayButton.setBounds(80,435, 200 , 70);
		replayButton.setFont(new Font("Serif",Font.BOLD,30));
		replayButton.setFocusable(false);
		replayButton.addActionListener(this);
		replayButton.setText("إعادة اللعب");
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
		ExitButton.setBounds(350,435 , 200 ,70);
		ExitButton.setFont(new Font("Serif",Font.BOLD,30));
		ExitButton.setFocusable(false);
		ExitButton.addActionListener(this);
		ExitButton.setText("خروج");
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
			QuestionFieldsWindow.InSelected();
			new WelcomeWindow();
			resltatWindow.setVisible(false);
	
		}
	
		if(e.getSource() == howToPlay){
	
			JDialog H_P = new JDialog(resltatWindow, "كيفية اللعب");
			JTextArea howToPlay_text  =new JTextArea();
			JButton b = new JButton("حسنا");
			
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
			howToPlay_text.setFont(new Font("Serif",Font.BOLD,26));
			howToPlay_text.setEditable(false);
			howToPlay_text.setText("\nمرحبا بك في اكثر الالعاب الثقافية و الممتعة حيث يمكنك تثقيف نفسك بطرقة ممتعة \nو شيقة و بطريقتك الخاصة اذ يمكنك اختيار العالم الخاص بك يمكنك اختيار لونك المفضل\nو جعله في تصميم خلفية اللعبة ايضا اختيار مجالات متنوعة منها تاريخية دينية\nعلمية و غيرها و لجعل اللعبة اكثر منافسة و تشويق يمكنك تحديد مستوى لعبك \n و تختصر هذه اللعبة في بعض من القواعد لديك ثلاث مستويات (مبتدئ-متوسط-صعب) \nو ذلك يقاس على مدة الايجابة على كل سؤال لكل مستوك \nالمبتدئ 12 ثانية ** المتوسط 10 ثواني  ** الصعب 8 ثواني \nفي كل مجال يوجد 10 أسئلة و لكل سؤال يوجد ثلاث اقتراحات \nمن بينها وحدة فقط صحيحة ");

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
	
		if(e.getSource() ==changeColor){
	
			Color c = JColorChooser.showDialog(null,"لوحة الألوان", Methods.borderColor);
	
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
	
			JDialog H_S = new JDialog(resltatWindow,"أعلى تحصيل ");
			final JLabel l = new JLabel("أعلى تحصيل " + (Methods.readBestScorefromTheFile()) + " %");
			JButton b = new JButton("حسنا");
			
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
			r = "لابأس يا بطل عليك المراجعة أكثر ";
	
		if(20 < QuestionWindow.results() && QuestionWindow.results() <= 40)
			r = "استمر في التعلم";
	
		if(40 < QuestionWindow.results() && QuestionWindow.results() <= 60)
			r = "حسن ينقصه قليل من التركيز ";
		
		if(60 < QuestionWindow.results() && QuestionWindow.results() <= 80)
			r = "تملك مهارات جيدة";
	
		if(80 < QuestionWindow.results())
			r = "مستوى رائع و عمل ممتاز";
		
		return r;
	}
}
