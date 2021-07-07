import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;


public class QuestionWindowE implements ActionListener {

	ArrayList<String> questions = new ArrayList<String>();
	ArrayList<String> options = new ArrayList<String>();
	ArrayList<Character> correctanswers = new ArrayList<Character>();
	
	char guess,answer;
	static int totalQuestions = 0 , correctGuesses ;
	int seconds ;
	
	int c[];

	JFrame QuestionWindow = new JFrame("Quiz Game");
	ImageIcon im = new ImageIcon(getClass().getResource("/img/logo.png"));
	
	/*QuestionWindow continer*/
	JTextField questionNumber=new JTextField();
	JTextArea questionText=new JTextArea();
	JButton OptionA =new JButton();
	JButton OptionB =new JButton();	
	JButton OptionC =new JButton();
	JLabel timeLabel =new JLabel();
	JLabel secondsLeft = new JLabel();

	Timer timer = new Timer(1000,new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			secondsLeft.setText(String.valueOf(seconds));
	
			if(seconds == 5 )
				secondsLeft.setBackground(Color.YELLOW);
	
			if(seconds == 3)
				secondsLeft.setBackground(Color.red);
	
			if(seconds <= 0)
				displayAnswer();
		}
	});

	public QuestionWindowE() {

		correctGuesses = 0 ;

		//Questions and answers
		//Historical
		if( QuestionFieldsWindowE.HistoricalIsSelected() ){	
		
			questions.add("from which continent is republic of Latvia ? ");
			questions.add("what is the system of government in the state of Oman ?");
			questions.add("who is the first prime minister of Algeria ?");
			questions.add(" who is the greek historian known as the father of history ? ");
			questions.add("how many days of the week in ancient roman times ?  ");
			questions.add(" which of these countries was neutral in the first world war ?");
			questions.add("the first world war ended in : ");
			questions.add("  what were the pyramids of Egypt ?");
			questions.add(" what is the name of the first human sivilisation ");
			questions.add("in what year did Hitler commit suicide ?");
		
			options.add(" Europe"); options.add("South america "); options.add(" Africa");
			options.add("Republican"); options.add("Ultanate "); options.add(" Emirate ");
			options.add("Abd al hamid mahri "); options.add("ben yousef ben khada "); options.add(" Ahmed ben bella");
			options.add("Herodotus "); options.add("Arianaut "); options.add(" Socides");
			options.add("6 "); options.add("8 "); options.add(" 12");
			options.add("England  "); options.add("Italy  "); options.add(" Norway ");
			options.add("1918 "); options.add("1920 "); options.add(" 1945");
			options.add("Shrines  "); options.add(" Cemeteries "); options.add(" Command centers ");
			options.add("The Egyptian inca  "); options.add("Greek "); options.add(" Mesopotamia ");
			options.add(" 1945"); options.add("1950 "); options.add(" 1951");
		
			correctanswers.add('A');
			correctanswers.add('B');
			correctanswers.add('C');
			correctanswers.add('A');
			correctanswers.add('B');
			correctanswers.add('C');
			correctanswers.add('A');
			correctanswers.add('B');
			correctanswers.add('C');
			correctanswers.add('A');
		}
		
		//Geography
		if( QuestionFieldsWindowE.GeographylIsSelected() ){	
			
			questions.add("Where is Comoros located ? ");
			questions.add("what is the longest river in the world ? ");
			questions.add("what is the first mountain erected in the earth ? ");
			questions.add("how many countries are in africa ? ");
			questions.add("which of the following continents crossed by the equator ? ");
			questions.add(" what is the capital of turkey ?");
			questions.add(" Which of the following countries separated by the strait of Gibraltar");
			questions.add("what is the smallest country in the world ? ");
			questions.add(" the highest  mountain in Algeria is");
			questions.add(" What is the bigest desert in the world?");
		
			options.add(" The indian ocean "); options.add(" The Arabian sea "); options.add("The pacific ocean   ");
			options.add("Mississippi river"); options.add(" Nile ");  options.add("Tigris river  ");
			options.add(" Saqarah"); options.add("El-maktam "); options.add(" Abi Qabiss");
			options.add("54 "); options.add("48 "); options.add(" 62");
			options.add("Africa "); options.add("South America "); options.add("Europe");
			options.add("Istanbul "); options.add("Izmir  "); options.add(" Ankara ");
			options.add("Portugal and marocco  "); options.add("Algeria and spain  "); options.add("Marocco and spain  ");
			options.add(" Dubai "); options.add(" Vatican city"); options.add("Cairo  ");
			options.add("Adhrar ou-mellat "); options.add("Bouzeriaa "); options.add(" Tahat");
			options.add(" Antarctic"); options.add("Syrian  "); options.add("Gobi ");
		
			correctanswers.add('A');
			correctanswers.add('B');
			correctanswers.add('C');
			correctanswers.add('A');
			correctanswers.add('B');
			correctanswers.add('C');
			correctanswers.add('A');
			correctanswers.add('B');
			correctanswers.add('C');
			correctanswers.add('A');
		}
		
		//Religious
		if( QuestionFieldsWindowE.ReligiousIsSelected() ){	
		
			questions.add("What is the surah that was named the Bride of the Holy Quran?");
			questions.add("The surah for which Omar ibn al-Khattab inverted to islam");
			questions.add("Who was the first prophet hwo tell Who Poems");
			questions.add("The first to order the collection of the Holy Quran");
			questions.add("whene did ramadan Proceeded");
			questions.add("What is the Day of Al-Furqan that Allah mentioned in the Qur'an?");
			questions.add("The first prayer imposed on the Prophet");
			questions.add("Whom is the first who said praise god the highest");
			questions.add("What is his first work in the history of the Islamic state?");
			questions.add("When did al-Qiblah turned from Holy House to kaaba?");
		
			options.add("Al-rahman "); options.add("Al-qariaa "); options.add("yassin ");
			options.add(" Al-Baqarah"); options.add(" Taha"); options.add("Al-Aaraf ");
			options.add("Nouah(pbuh) "); options.add("Ibrahim(pbuh) "); options.add("adam(pbuh) ");
			options.add("Abu-bakr "); options.add("Prophet muhammed(pbuh) "); options.add("Outhman abu-aafan ");
			options.add(" 3 for migration"); options.add("2 for migration "); options.add("4 for migration ") ;
			options.add("the openning of makaah "); options.add("Ouhoud invasion"); options.add(" Badr invation");
			options.add("El-Duhor "); options.add(" El-fadjr"); options.add(" El-asr");
			options.add("Adam(pbuh) "); options.add("Israfil(pbuh) "); options.add("Prophet muhammed(pbuh) ");
			options.add(" Dollar"); options.add("Dirham "); options.add("Dinar ");
			options.add("2 for migration  "); options.add("5 for migration  "); options.add("10 for migration  ");
		
			correctanswers.add('A');
			correctanswers.add('B');
			correctanswers.add('C');
			correctanswers.add('A');
			correctanswers.add('B');
			correctanswers.add('C');
			correctanswers.add('A');
			correctanswers.add('B');
			correctanswers.add('C');
			correctanswers.add('A');
				
		}
		
		//Scientific
		if(QuestionFieldsWindowE.ScientificIsSelected()){	
		
			questions.add("What's the name given to the mechanics of static object ?");
			questions.add("What is the name of the device used to measure atmospheric pressure ?");
			questions.add("Hwo is the scientist who invented the telescope?");
			questions.add("The lady who invented the dishwasher machine?");
			questions.add("Among these planets ... What's the strongest in gravity?");
			questions.add("wich gravity is stronger between the solar system plants");
			questions.add("washing soda is the common name for what?");
			questions.add("How many colors can you get when you separate white colore?");
			questions.add("How many electrons does a hydrogen atom have?");
			questions.add("What is the best metal for the transmission of electricity");
		
			options.add("Estatica"); options.add(" Takesata"); options.add("Body mechanism ");
			options.add(" Termometr"); options.add("Parometr "); options.add("Ampermetr ");
			options.add("Ibn-sina "); options.add("Eienstin "); options.add(" Galilio");
			options.add("Josephine kouchrane "); options.add(" Marry andersson"); options.add("Melita anderson");
			options.add(" mars"); options.add("Earth "); options.add(" moon");
			options.add("moon "); options.add("mars "); options.add(" Earth");
			options.add("Baking Soda "); options.add(" sodium bicarbunate"); options.add(" sodium");
			options.add(" 8"); options.add("7 "); options.add(" 9");
			options.add("2 "); options.add("5 "); options.add("1 "); 
			options.add("silver "); options.add("  titanum "); options.add("Nickel ");
		
			correctanswers.add('A');
			correctanswers.add('B');
			correctanswers.add('C');
			correctanswers.add('A');
			correctanswers.add('B');
			correctanswers.add('C');
			correctanswers.add('A');
			correctanswers.add('B');
			correctanswers.add('C');
			correctanswers.add('A');

		}
		
		//Programming
		if(QuestionFieldsWindowE.ProgramminglIsSelected()){	
		
			questions.add("How many instances of an abstract class can be created");
			questions.add("A loop that never ends is referred to as a(n)_________.");
			questions.add("Which command will stop an infinite loop?");
			questions.add("___________are used for data persistence permanent retention of large amount of data");
			questions.add("__________ is a consecutive group of memory location that all have the same type");
			questions.add("Computer is a ___________ ");
			questions.add("C.U. means");
			questions.add("The full form of IRQ is?");
			questions.add("BASIC, C and COBOL and Java are examples of which language?");
			questions.add("The process of finding and correcting errors in a program is called");
		
			options.add("Cannot create objects"); options.add("Create a large number of objects"); options.add("3 objects");
			options.add("while loop"); options.add("Infinite loop"); options.add("recursive loop");
			options.add("Alt + C"); options.add("Shift + C"); options.add("Ctrl + C");
			options.add("files"); options.add("Variables"); options.add("Pointers");
			options.add("Pointers"); options.add("Arrays"); options.add("String");
			options.add("TV"); options.add("Program"); options.add("Machine");
			options.add("Control Unit"); options.add("Contral Unit"); options.add("Center United");
			options.add("Internet Recall Que"); options.add(" Interrupt Request"); options.add("interquartile range");
			options.add("Computer language"); options.add("Low-level language"); options.add(" High-level language");
			options.add("Debugging");options.add("Scanning"); options.add("Compiling"); 
			
			correctanswers.add('A');
			correctanswers.add('B');
			correctanswers.add('C');
			correctanswers.add('A');
			correctanswers.add('B');
			correctanswers.add('C');
			correctanswers.add('A');
			correctanswers.add('B');
			correctanswers.add('C');
			correctanswers.add('A');
		}
		
		//Sport
		if( QuestionFieldsWindowE.SportIsSelected() ){	
		
			questions.add("Where did football first start? ");
			questions.add("Where is the first world cup held?");
			questions.add("In which sport can you win the Davis Cup?");
			questions.add("Who is the most famous football player in history?");
			questions.add("When did Messi join FC Barcelona");
			questions.add("He won the 2018 World Cup?");
			questions.add("How many games has Muhammad Ali lost in his career?");
			questions.add("First Arab Country Participated in the World Cup?");
			questions.add("How many goals Mahrez scored in the Champions League ");
			questions.add("How many players are on a baseball team? ");
		
			options.add("England  "); options.add("Switzerland "); options.add("germany ");
			options.add("Egybt "); options.add("Norway "); options.add("Germany ");
			options.add("Football "); options.add("Bascatball "); options.add(" Tennis");
			options.add("Pillih "); options.add("Swarez "); options.add(" Ibrahimivich");
			options.add(" Three"); options.add("One "); options.add("Two ");
			options.add("Maroc "); options.add("Jordan "); options.add("Algeria  ");
			options.add("13 years old "); options.add(" 12 years old"); options.add("15 years old ");
			options.add(" Egybt"); options.add("France "); options.add(" Algeria");
			options.add("3 "); options.add("2 "); options.add("4 ");
			options.add("9 "); options.add("10 "); options.add("11 ");
		
			correctanswers.add('A');
			correctanswers.add('B');
			correctanswers.add('C');
			correctanswers.add('A');
			correctanswers.add('B');
			correctanswers.add('C');
			correctanswers.add('A');
			correctanswers.add('B');
			correctanswers.add('C');
			correctanswers.add('A');
		}
		
		//Artistic
		if(QuestionFieldsWindowE.ArtisticIsSelected()){	
		
			questions.add("WhosavedMikasa in episode 01 ?");
			questions.add("WhosavedNubara in the last episode of thisseason of JujutsuKaisen ?");
			questions.add("Whobrought back SaksiafterKagoyadesert in Naruto Anime ?");
			questions.add("Who are the personsthatKirawaskilling in Death Note ?");
			questions.add("Whois the son of the king of pirates Goul Di Rodger ?");
			questions.add("What secret organisation Akai Chuitshiworked for ?");
			questions.add("Whatis the name of NarutoOzomaki’sfather ?");
			questions.add("What’s the name of the farmthat Emma and herfriendsgrow up in ?");
			questions.add("Whois the characterthatdefetedSill ?");
			questions.add("Whowas the first to teachgoon and kiloa to control theNeen?");
		
			options.add("Eren"); options.add("Grisha"); options.add("Karla");
			options.add("Gojosaturi"); options.add("KaissenItaduri"); options.add("Migumi");
			options.add("Sakura"); options.add("Natuto"); options.add("Obito");
			options.add("Criminals"); options.add("Normal people"); options.add("Thieves");
			options.add("RoronuraZuro"); options.add("Portgas Di Ace"); options.add("Monkey Di Lufi");
			options.add("The black robe organisation "); options.add("CIA"); options.add("FBI");
			options.add("NamikaziMinatu"); options.add("IrukaOmino"); options.add("KakashiHataki");
			options.add("Lambda farm"); options.add("Gricefield"); options.add("Minirvafarm");
			options.add("SoonGuko"); options.add("Vigita"); options.add("SoonJuhan");
			options.add("Wing"); options.add("Hisuka"); options.add("Nitiru");
		
			correctanswers.add('A');
			correctanswers.add('B');
			correctanswers.add('C');
			correctanswers.add('A');
			correctanswers.add('B');
			correctanswers.add('C');
			correctanswers.add('A');
			correctanswers.add('B');
			correctanswers.add('C');
			correctanswers.add('A');
		}
		
		QuestionWindow.setSize(650, 650);
		QuestionWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		QuestionWindow.getContentPane().setBackground(new Color(69,69,69));
		QuestionWindow.setResizable(false);
		QuestionWindow.setLayout(null);
		QuestionWindow.setIconImage(im.getImage());

		secondsLeft.setBounds(170 , 10, 400, 60);
		secondsLeft.setBackground(Color.green);
		secondsLeft.setForeground(Color.black);
		secondsLeft.setFont(new Font("Serif",Font.BOLD,30));
		secondsLeft.setBorder(BorderFactory.createBevelBorder(1));
		secondsLeft.setOpaque(true);
		setMaxS();
		secondsLeft.setHorizontalAlignment(JTextField.CENTER);
		secondsLeft.setText(String.valueOf(seconds));
		               
		timeLabel.setBounds(40, 10, 130, 60);
		timeLabel.setBackground(Methods.backgroundColor);
		timeLabel.setForeground(Methods.foregroundColor);
		timeLabel.setFont(new Font("Serif",Font.BOLD,30));
		timeLabel.setHorizontalAlignment(JTextField.LEFT);
		timeLabel.setText(" Timer ");

		questionNumber.setBounds(5, 80 , 620, 50);
		questionNumber.setBackground(Methods.backgroundColor);
		questionNumber.setForeground(Methods.foregroundColor);
		questionNumber.setFont(new Font("Serif",Font.BOLD,30));
		questionNumber.setBorder(BorderFactory.createBevelBorder(1));
		questionNumber.setHorizontalAlignment(JTextField.CENTER);
		questionNumber.setEditable(false);
			
		questionText.setBounds(5,130, 620, 100);
		questionText.setLineWrap(true) ;
		questionText.setWrapStyleWord(true);
		questionText.setBackground(Methods.backgroundColor);
		questionText.setForeground(Methods.foregroundColor);
		questionText.setFont(new Font("Serif",Font.BOLD,30));
		questionText.setBorder(BorderFactory.createBevelBorder(1));
		questionText.setEditable(false);
			
		OptionA.setBounds(45,260, 550, 80);
		OptionA.setFont(new Font("Serif",Font.BOLD,30));
		OptionA.setFocusable(false);
		OptionA.addActionListener(this);
		OptionA.setBackground(new Color(40,40,40));
		OptionA.setForeground(Methods.foregroundColor);
		OptionA.setBorder(BorderFactory.createLineBorder(Methods.borderColor,3,true));

		OptionB.setBounds(45, 365, 550, 80);
		OptionB.setFont(new Font("Serif",Font.BOLD,30));
		OptionB.setFocusable(false);
		OptionB.addActionListener(this);
		OptionB.setBackground(new Color(40,40,40));
		OptionB.setForeground(Methods.foregroundColor);
		OptionB.setBorder(BorderFactory.createLineBorder(Methods.borderColor,3,true));	

		OptionC.setBounds(45, 470, 550, 80);
		OptionC.setFont(new Font("Serif",Font.BOLD,30));
		OptionC.setFocusable(false);
		OptionC.addActionListener(this);
		OptionC.setBackground(new Color(40,40,40));
		OptionC.setForeground(Methods.foregroundColor);
		OptionC.setBorder(BorderFactory.createLineBorder(Methods.borderColor,3,true));

		QuestionWindow.add(questionNumber);		
		QuestionWindow.add(questionText);
		QuestionWindow.add(OptionA);
		QuestionWindow.add(OptionB);
		QuestionWindow.add(OptionC);
		QuestionWindow.add(timeLabel);
		QuestionWindow.add(secondsLeft);
		
		QuestionWindow.setVisible(true);
		QuestionWindow.setLocation(350,40);
		totalQuestions = questions.size();
		c = new int[totalQuestions];
		Methods.QuestionsIndex(c);
		c = Methods.c;
		nextQestion();

	}
	
	void addMouseListenerMethod(){
		OptionA.addMouseListener(new java.awt.event.MouseAdapter() {
		
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				OptionA.setBackground(Methods.borderColor);
			}
		
			public void mouseExited(java.awt.event.MouseEvent evt) {
				OptionA.setBackground(new Color(40,40,40));
			}
		});
		OptionB.addMouseListener(new java.awt.event.MouseAdapter() {
		
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				OptionB.setBackground(Methods.borderColor);
			}
		
			public void mouseExited(java.awt.event.MouseEvent evt) {
				OptionB.setBackground(new Color(40,40,40));
			}
		});	
		OptionC.addMouseListener(new java.awt.event.MouseAdapter() {
		
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				OptionC.setBackground(Methods.borderColor);
			}
		
			public void mouseExited(java.awt.event.MouseEvent evt) {
				OptionC.setBackground(new Color(40,40,40));
			}
		});
	}

	void  setMaxS(){
	
		switch( LevelWindowE.WhichLevelIsSelected() ) {
	
			case 'H':
				seconds = 8 ;
				break;
	
			case 'M':
				seconds = 10 ;
				break;

			case 'B':
				seconds = 12 ;
				break;
		}
	} 

	int qn = 0 ;

	public void nextQestion() {
		addMouseListenerMethod();
		if( qn >= totalQuestions ) {
		
			new ResltatWindowE();
			QuestionWindow.setVisible(false);
		
		}
		else {
		
			questionNumber.setText(" Question "+ (qn + 1) ) ;
			questionText.setText( questions.get( c[qn] -1)) ;
			OptionA.setText( options.get(  ( c[qn] -1)*3) ) ;
			OptionB.setText( options.get( (( c[qn] -1)*3) + 1 ) ) ;
			OptionC.setText( options.get( (( c[qn] -1)*3) + 2) ) ;

			secondsLeft.setBackground(Color.green);
			
			timer.start();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		OptionA.setEnabled(false);
		OptionB.setEnabled(false);
		OptionC.setEnabled(false);
		
		if(e.getSource() == OptionA) {
		
			answer = 'A';
			if(answer == correctanswers.get(c[qn] -1))
				correctGuesses++;
		}
		
		if(e.getSource() == OptionB) {
		
			answer = 'B';
			if(answer == correctanswers.get(c[qn] -1))
				correctGuesses++;
		}
		
		if(e.getSource() == OptionC) {
		
			answer = 'C';
			if(answer == correctanswers.get(c[qn] -1))
				correctGuesses++;
			}
		
		displayAnswer();
	}
		
	public void displayAnswer() {
		
		timer.stop();

		OptionA.setEnabled(false);
		OptionB.setEnabled(false);
		OptionC.setEnabled(false);		

		if(correctanswers.get(c[qn] -1) != 'A'){ 
		
			OptionA.setBackground(new Color(255,0,0));
			OptionA.setBorder(BorderFactory.createLineBorder(new Color(255,0,0),3,true));
			
			OptionA.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
				OptionA.setBackground(new Color(255,0,0));
				}
				public void mouseExited(java.awt.event.MouseEvent evt) {
					OptionA.setBackground(new Color(255,0,0));
				}
			});
		
		}
		else{
		
			OptionA.setBackground(new Color(0,255,0));
			OptionA.setBorder(BorderFactory.createLineBorder(new Color(0,255,0),3,true));
			
			OptionA.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
				OptionA.setBackground(new Color(0,255,0));
				}
				public void mouseExited(java.awt.event.MouseEvent evt) {
					OptionA.setBackground(new Color(0,255,0));
				}
			});

		}
		
		if(correctanswers.get(c[qn] -1) != 'B'){
		
			OptionB.setBackground(new Color(255,0,0));
			OptionB.setBorder(BorderFactory.createLineBorder(new Color(255,0,0),3,true));
			
			OptionB.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
				OptionB.setBackground(new Color(255,0,0));
				}
				public void mouseExited(java.awt.event.MouseEvent evt) {
					OptionB.setBackground(new Color(255,0,0));
				}
			});
		}
		else{
		
			OptionB.setBackground(new Color(0,255,0));
			OptionB.setBorder(BorderFactory.createLineBorder(new Color(0,255,0),3,true));
	
			OptionB.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
				OptionB.setBackground(new Color(0,255,0));
				}
				public void mouseExited(java.awt.event.MouseEvent evt) {
					OptionB.setBackground(new Color(0,255,0));
				}
			});
		}
	
		if(correctanswers.get(c[qn] -1) != 'C'){
	
			OptionC.setBackground(new Color(255,0,0));
			OptionC.setBorder(BorderFactory.createLineBorder(new Color(255,0,0),3,true));
			
			OptionC.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
				OptionC.setBackground(new Color(255,0,0));
				}
				public void mouseExited(java.awt.event.MouseEvent evt) {
					OptionC.setBackground(new Color(255,0,0));
				}
			});
		}
		else{
		
			OptionC.setBackground(new Color(0,255,0));
			OptionC.setBorder(BorderFactory.createLineBorder(new Color(0,255,0),3,true));
		
			OptionC.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
				OptionC.setBackground(new Color(0,255,0));
				}
				public void mouseExited(java.awt.event.MouseEvent evt) {
					OptionC.setBackground(new Color(0,255,0));
				}
			});
		}
		
		Timer pause = new Timer(3000,new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
		
				OptionA.setBackground(Methods.backgroundColor);
				OptionB.setBackground(Methods.backgroundColor);
				OptionC.setBackground(Methods.backgroundColor);
		
				OptionA.setBorder(BorderFactory.createLineBorder(Methods.borderColor,3,true));
				OptionB.setBorder(BorderFactory.createLineBorder(Methods.borderColor,3,true));
				OptionC.setBorder(BorderFactory.createLineBorder(Methods.borderColor,3,true));
				
				answer =' ';
				setMaxS();
				secondsLeft.setText(String.valueOf(seconds));
		
				OptionA.setEnabled(true);
				OptionB.setEnabled(true);
				OptionC.setEnabled(true);

				qn++;
				nextQestion();
			}
		});
		
		pause.setRepeats(false);
		pause.start();
	}

	static int results() {
		
		return ( (int)((correctGuesses /(double)totalQuestions)*100) );
	
	}
	
	static String numberRight(){
	
		return ( " ( "+correctGuesses+" / "+ totalQuestions +" ) " ) ;
	
	}
		
}
