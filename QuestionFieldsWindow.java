import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class QuestionFieldsWindow implements ActionListener {

	JFrame QuestionFieldsWindow = new JFrame("Quiz Game");
	
	JMenuBar menuBar = new JMenuBar();
	JMenu file = new JMenu("ملف");
	JMenuItem howToPlay = new JMenuItem("كيفية اللعب");
	JMenuItem changeColor = new JMenuItem("تغيير اللون ");
	JMenuItem highScor = new JMenuItem("أعلى تحصيل");
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
	
	public QuestionFieldsWindow(){

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
		chooseQuestionFields.setText("حدد مجالات الأسئلة");
		chooseQuestionFields.setBorder(BorderFactory.createEtchedBorder(1));
		chooseQuestionFields.setBackground(Methods.backgroundColor);
		chooseQuestionFields.setForeground(Methods.foregroundColor);
		chooseQuestionFields.setFont(new Font("Serif",Font.BOLD,30));
		chooseQuestionFields.setHorizontalAlignment(JTextField.CENTER);
	
		/* CheckBoxs properties */
		hisCheckBox.setText("تاريخية ");
		hisCheckBox.setBounds(100,160,150,50);
		hisCheckBox.setBackground(Methods.borderColor);
		hisCheckBox.setForeground(Methods.foregroundColor);
		hisCheckBox.setFont(new Font("Serif",Font.BOLD,20));
		
		geoCheckBox.setText("جغرافية");
		geoCheckBox.setBounds(400,160,150,50);
		geoCheckBox.setBackground(Methods.borderColor);
		geoCheckBox.setForeground(Methods.foregroundColor);
		geoCheckBox.setFont(new Font("Serif",Font.BOLD,20));

		religCheckBox.setText("دينية");
		religCheckBox.setBounds(100,230,150,50);
		religCheckBox.setBackground(Methods.borderColor);
		religCheckBox.setForeground(Methods.foregroundColor);
		religCheckBox.setFont(new Font("Serif",Font.BOLD,20));

		scienCheckBox.setText("علمية");
		scienCheckBox.setBounds(400,230,150,50);
		scienCheckBox.setBackground(Methods.borderColor);
		scienCheckBox.setForeground(Methods.foregroundColor);
		scienCheckBox.setFont(new Font("Serif",Font.BOLD,20));

		progCheckBox.setText("برمجية");
		progCheckBox.setBounds(100,300,150,50);
		progCheckBox.setBackground(Methods.borderColor);
		progCheckBox.setForeground(Methods.foregroundColor);
		progCheckBox.setFont(new Font("Serif",Font.BOLD,20));

		sportCheckBox.setText("رياضية");
		sportCheckBox.setBounds(400,300,150,50);
		sportCheckBox.setBackground(Methods.borderColor);
		sportCheckBox.setForeground(Methods.foregroundColor);
		sportCheckBox.setFont(new Font("Serif",Font.BOLD,20));

		ArtCheckBox.setText(" أنمي ");
		ArtCheckBox.setBounds(250,370,150,50);
		ArtCheckBox.setBackground(Methods.borderColor);
		ArtCheckBox.setForeground(Methods.foregroundColor);
		ArtCheckBox.setFont(new Font("Serif",Font.BOLD,20));
	
		/*Play Now Button properties */
		playNowButton.setBounds(175, 460, 300 , 70);
		playNowButton.setFont(new Font("Serif",Font.BOLD,30));
		playNowButton.setFocusable(false);
		playNowButton.addActionListener(this);
		playNowButton.setText("إبدأ اللعب");
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

		if(e.getSource() == playNowButton){

			if( hisCheckBox.isSelected()   || geoCheckBox.isSelected()   ||
				religCheckBox.isSelected() || scienCheckBox.isSelected() || 
				progCheckBox.isSelected()  || sportCheckBox.isSelected() || ArtCheckBox.isSelected() ) {		

					new QuestionWindow();
					QuestionFieldsWindow.setVisible(false);

			}
			
			else{
			
				JDialog dialog = new JDialog(QuestionFieldsWindow);
				final JLabel l = new JLabel("يجب تحديد على الأقل مجال واحد ");
				JButton b = new JButton("حسنا");
				
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
				l.setFont(new Font("Serif",Font.BOLD,24));
				l.setHorizontalAlignment(JTextField.CENTER);
			}
		}

		/*how to play action (dialog window ) */
		if(e.getSource() == howToPlay){
		
			JDialog H_P = new JDialog(QuestionFieldsWindow, "كيفية اللعب");
			JTextArea howToPlay_text  =new JTextArea();
			JButton b = new JButton("حسنا");
			
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

		/*change color action (colors window ) */
		
		if(e.getSource() ==changeColor){
		
			Color c = JColorChooser.showDialog(null,"لوحة الألوان", Methods.borderColor);
		
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
		
		/*high score action (show highest score ) */
		if(e.getSource() == highScor){
		
			JDialog H_S = new JDialog(QuestionFieldsWindow,"أعلى تحصيل ");
			final JLabel l = new JLabel("أعلى تحصيل " + (Methods.readBestScorefromTheFile()) + " %");
			JButton b = new JButton("حسنا");
			
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
