import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;


public class QuestionWindow implements ActionListener {

	ArrayList<String> questions = new ArrayList<String>();
	ArrayList<String> options = new ArrayList<String>();
	ArrayList<Character> correctanswers = new ArrayList<Character>();
	
	char guess,answer;
	static int totalQuestions = 0 , correctGuesses = 0 ;
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
			
			if(seconds == 0) 
				displayAnswer();
		}
	});


	public QuestionWindow() {
		correctGuesses = 0;
		//Questions and answers
		
		//Historical
		if( QuestionFieldsWindow.HistoricalIsSelected() ){	

			questions.add(" من أي قارة هي جمهورية لاتفيا ");
			questions.add(" ما هو نظام الحكم بدولة عمان؟ ");
			questions.add(" من كان أول رئيس وزراء للجزائر؟");
			questions.add(" من هو المؤرخ اليوناني المعروف بـ أبو التاريخ؟ ");
			questions.add(" كم عدد أيام الأسبوع في العصور الرومانية القديمة؟");
			questions.add(" أي من هذه الدول كانت محايدة في الحرب العالمية الأولى؟");
			questions.add(" انتهت الحرب العالمية الأولى في");
			questions.add(" ما كانت أهرامات مصر؟");
			questions.add(" ما اسم أول حضارة بشرية؟");
			questions.add(" في أي سنة انتحر هتلر؟");
			
			options.add(" اوروبا "); options.add("امريكا الجنوبية  "); options.add(" افرقيا ");
			options.add("جمهوري "); options.add("سلطاني  "); options.add (" اماراتي   ");
			options.add("عبد الحميد مهري "); options.add("بن يوسف بن خدة  "); options.add(" احمد بن بلة ");
			options.add("اوريدوت  "); options.add("أريانوت"); options.add(" سوسيدس");
			options.add("6 "); options.add("8 "); options.add(" 12");
			options.add("انجلترا   "); options.add("ايطاليا  "); options.add(" نرويج ");
			options.add("1918 "); options.add("1920 "); options.add(" 1945");
			options.add("المزارات  "); options.add(" مقابر "); options.add(" مراكز القيادة ");
			options.add("الانطة المصرية   "); options.add("اغريق  "); options.add(" بلاد الرافدين   ");
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
		if( QuestionFieldsWindow.GeographylIsSelected() ){	
		
			questions.add(" اين تقع جزر القمر");
			questions.add(" ما هو اطول نهر فى العالم");
			questions.add(" اول جبل نصب في الارض هو جبل؟");
			questions.add(" كم عدد الدول في أفريقيا؟");
			questions.add(" أي من القارات التالية يقطعها خط الاستواء؟");
			questions.add(" هي عاصمة تركيا؟");
			questions.add(" أي من الدول التالية يفصل بينها مضيق جبل طارق");
			questions.add(" ما هي أصغر دولة في العالم؟");
			questions.add(" ما هو أكبر جبل في الجزائر");
			questions.add(" ما هي أكبر صحراء في العالم؟");
		
			options.add("المحيط الهندي"); options.add(" البحر العربي "); options.add(" المحيط الاطلسي ");
			options.add("الميسيسيبي"); options.add(" النيل "); options.add(" نهر دجلة والفرات  ");
			options.add(" سقرة"); options.add("المكتم "); options.add("  ابي قبيس"); 
			options.add("54 "); options.add("48 "); options.add(" 62");
			options.add("افريقيا "); options.add("امريكا الجنوبية "); options.add("اوروبا");
			options.add("اسطنول "); options.add("ازمير  "); options.add(" انقرة "); 
			options.add(" البرتغال و المغرب  "); options.add("الجزائر و اسبانيا "); options.add("المغرب و اسبانيا ");
			options.add(" دبي "); options.add(" مدينة الفاتيكان");options.add("القاهرة");
			options.add("ادرار اوملاط "); options.add("بوزريعة ");options.add(" طاهات");
			options.add("انتارتيكا"); options.add("السورية  "); options.add("غوبي ");
		
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
		if( QuestionFieldsWindow.ReligiousIsSelected() ){	
		
			questions.add(" ما هي السورة التي لقبت بعروس القرآن الكريم");
			questions.add(" ما هي السورة التي أسلم بسببها عمر بن الخطاب رضى الله عنه؟");
			questions.add(" من هو أول نبي قام بسرد الشعر");
			questions.add(" من هو اول من امر بجمع القران الكريم");
			questions.add(" ما متى شرع شهر رمضان؟");
			questions.add(" ما المقصود بيوم الفرقان الذي ذكره الله تعالى في القرآن؟");
			questions.add(" أول صلاة فرضت على النبي؟");
			questions.add(" من أول من قال سبحان ربي الأعلى ؟");
			questions.add(" ما هو أول عملة في تاريخ الدولة الإسلامية؟");
			questions.add(" متي حولت القبله من بيت المقدس الى الكعبه؟");
		
			options.add(" الرحمان"); options.add("القارعة "); options.add("يس ");
			options.add("البقرة"); options.add(" طه"); options.add("الاعراف ");
			options.add("سيدنا نوح "); options.add("سيدنا ابراهيم "); options.add("سيدنا ادم "); 
			options.add("ابوبكر الصديق "); options.add("النبي محمد (ص) "); options.add("عثمان ابو عفان ");
			options.add(" الثالثة للهجرة"); options.add("الثانية للهجرة"); options.add("الرابعة للهجرة");
			options.add("فتح مكة "); options.add("غزوة احد"); options.add("غزوة بدر");
			options.add("الظهر "); options.add(" الفجر"); options.add(" العصر");
			options.add("سيدنا ادم "); options.add("سيدنا اسرافيل "); options.add("النبي محمد (ص)");
			options.add(" الدولار"); options.add("الدرهم "); options.add("الدينار "); 
			options.add("2 للهجرة "); options.add("5 للهجرة  "); options.add("10 للهجرة  ");
		
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
		if(QuestionFieldsWindow.ScientificIsSelected()){	
		
			questions.add(" ما الإسم الذي يطلق على ميكانيك الأجسام الساكنة؟");
			questions.add(" ما هو إسم الجهاز الذي يستخدم في قياس الضغط الجوي ؟");
			questions.add(" من هو العالم الذي إخترع التلسكوب ؟");
			questions.add(" من السيدة التي قامت بإختراع جهاز غساله الأطباق ؟");
			questions.add(" ؟ من بين هذه الكواكب ...ماهي الاقوى من حيث الجاذبية");
			questions.add(" صودا الغسيل هو الاسم الشائع لـ  ؟");
			questions.add(" كم عدد الألوان التي يمكن تحصل عليها عند تجزئة اللون الأبيض");
			questions.add(" تحتوي المياه الغازية على؟");
			questions.add(" كم عدد الإلكترونات التي تمتلكها ذرة الهيدروجين؟");
			questions.add(" ما هو المعدن الأفضل ناقلية للكهرباء");
		
			options.add("الاستاتيكا"); options.add("تاكيساتا"); options.add("ميكانيك الاجسام ");
			options.add(" تارمومتر"); options.add("بارومتر "); options.add("امبير متر ");
			options.add("ابن سينا"); options.add("اينشتاين "); options.add(" غاليلو"); 
			options.add("جوزفين كوشران"); options.add(" ماري اندرسون"); options.add("مليتا اندرسون");
			options.add(" المريخ"); options.add("الارض"); options.add("القمر");
			options.add(" بيكاربونات الصوديوم"); options.add(" الصوديوم"); options.add("كربونات الصوديوم ");
			options.add("7 "); options.add(" 8"); options.add(" 9");
			options.add(" حمض الكربونيك"); options.add("ثاني أكسيد الكربون "); options.add("حامض الكبريتيك");	
			options.add("2 "); options.add("5 "); options.add("1 "); 
			options.add("الفضة "); options.add("  التيتانيوم "); options.add("النيكل ");
		
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
		if(QuestionFieldsWindow.ProgramminglIsSelected()){	
		
			questions.add(" abstract class كم كائن يمكن إنشاءه من كلاس مجرد ");
			questions.add(" يشار إلى الحلقة التكرارية التي لا تنتهي أبدًا باسم");
			questions.add(" أي أمر سيوقف حلقة تكرارية غير منتهية ؟");
			questions.add(" تُستخدم للاحتفاظ الدائم بالبيانات بكمية كبيرة من البيانات ");
			questions.add(" هي مجموعة متتالية من مواقع الذاكرة التي لها نفس النوع");
			questions.add(" الكمبيوتر هو");
			questions.add(" C.U. تعني ");
			questions.add(" هي؟ IRQ  العبارة الكاملة لـ");
			questions.add(" BASIC, C و COBOL و Java  \n هي امثلة عن اي نوع من انواع لغات البرمجة");
			questions.add(" تسمى عملية البحث عن الأخطاء وتصحيحها في البرنامج ");
		
			options.add("لا يمكن انشاء كائنات"); options.add("انشاء عدد كبير من الكائنات "); options.add("3 كائنات ");
			options.add("  while حلقة 'while loop'"); options.add("حلقة لا نهائية 'Infinite loop'"); options.add("حلقة متكررة 'recursive loop'");
			options.add("Alt + C"); options.add("Shift + C"); options.add("Ctrl + C");
			options.add("الملفات"); options.add("المتغيرات"); options.add("المؤشرات");
			options.add("المؤشرات"); options.add("المصفوفات"); options.add("سلسلة");
			options.add("تلفزيون"); options.add("برنامج"); options.add("آلة");
			options.add("Control Unit"); options.add("Contral Unit"); options.add("Center United");
			options.add("Internet Recall Que"); options.add(" Interrupt Request"); options.add("interquartile range");
			options.add("لغة الكمبيوتر"); options.add("لغة منخفضة المستوى"); options.add("لغة عالية المستوى");
			options.add("التصحيح 'Debugging' ");options.add("يتم المسح 'Scanning'"); options.add("تجميع'Compiling'"); 
		
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
		if( QuestionFieldsWindow.SportIsSelected() ){	
		
			questions.add(" من أين بدأت كرة القدم لأول مرة؟ ");
			questions.add(" في أي بلد كانت أول بطولة لكأس العالم لكرة القدم");
			questions.add(" في أي رياضة يمكنك الفوز بكأس ديفيس؟");
			questions.add(" من هو لاعب كرة القدم الأكثر شهرة في التاريخ؟");
			questions.add(" كم عدد المباريات التي خسرها محمد علي في مسيرته؟");
			questions.add(" أول دولة عربية تشارك في كأس العالم؟");
			questions.add(" متى انضم ميسي إلى نادي برشلونة؟");
			questions.add(" من فاز بكأس العالم 2018؟");
			questions.add(" كم هدف سجل محرز في دوري ابطال اوروبا");
			questions.add(" كم عدد اللاعين في فريق اليسبول");
		
			options.add("انجلترا "); options.add("سويسرا"); options.add("المانيا ");
			options.add("مصر "); options.add("النرويج "); options.add("المانيا ");
			options.add("كرة القدم "); options.add("كرة السلة "); options.add("التنس");
			options.add("بيله "); options.add("سواريز "); options.add(" ابراهيم اوفيتش");
			options.add(" ثلاثة"); options.add("واحدة "); options.add("اثنان ");
			options.add("المغرب "); options.add("الاردن "); options.add("الجزائر  ");
			options.add("13 سنة"); options.add(" 12 سنة"); options.add("15 سنة ");
			options.add(" مصر"); options.add("فرنسا "); options.add(" الجزائر");
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
		if(QuestionFieldsWindow.ArtisticIsSelected()){	
		
			questions.add("من أنقد ميكاسا في الحلقة الأولى");
			questions.add("من أنقد نوبارا في الحلقة الأخيرة من هذا الموسم في جيجيتيو؟");
			questions.add("من أعاد ساسكي بعد صحراء كاغويا في أنمي ناروتو؟");
			questions.add("من هم الأشخاص الذين كان يقتلهم كيرا في ديث نوت");
			questions.add("من هو ابن ملك القراصنة");
			questions.add("ماهي المنظمة السرية التي يعمل لصالحها أكايشويتشي؟");
			questions.add("ماهو اسم والد ناروتواوزوماكي؟");
			questions.add("ما اسم المزرعة التي ولدت فيها ايما و أصدقاؤها؟");
			questions.add("من هي الشخصية التي تغلبت على سيل؟");
			questions.add("من هو أول من علم غونو كيلوا التحكم في النين؟");
		
			options.add("إيرين"); options.add("غريشا"); options.add("كارلا");
			options.add("ميغومي"); options.add(" كايسن إيتادوري"); options.add("غوجوساتوري");
			options.add("ناروتو"); options.add("ساكورا"); options.add("أوبيتو");
			options.add("المجرمين"); options.add(" أشخاص عاديين "); options.add("السارقين");
			options.add("مونكي دي لوفي"); options.add("بورتجاس دي ايس"); options.add("رورونوازورو");
			options.add("منظمة الرداء الأسود"); options.add("CIA"); options.add("FBI");
			options.add("ناميكازيميناتو"); options.add("ناميكازيميناتو"); options.add("كاكاشيهاتاكي");
			options.add("مزرعةلامبدا"); options.add("غريس فيلد"); options.add("مزرعةمينيرفا");
			options.add("فيجيتا؟"); options.add("سونغوكو"); options.add("سونجوهان");
			options.add("وينج"); options.add("هيسوكا"); options.add("نيتيرو");
		
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

		secondsLeft.setBounds(40 , 10, 400, 60);
		secondsLeft.setBackground(Color.green);
		secondsLeft.setForeground(Color.black);
		secondsLeft.setFont(new Font("Serif",Font.BOLD,30));
		secondsLeft.setBorder(BorderFactory.createBevelBorder(1));
		secondsLeft.setOpaque(true);
		setMaxS();
		secondsLeft.setHorizontalAlignment(JTextField.CENTER);
		secondsLeft.setText(String.valueOf(seconds));
		               
		timeLabel.setBounds(460, 10, 150, 60);
		timeLabel.setBackground(Methods.backgroundColor);
		timeLabel.setForeground(Methods.foregroundColor);
		timeLabel.setFont(new Font("Serif",Font.BOLD,24));
		timeLabel.setHorizontalAlignment(JTextField.RIGHT);
		timeLabel.setText("الوقت المتبقي ");

		questionNumber.setBounds(5, 80 , 620, 50);
		questionNumber.setBackground(Methods.backgroundColor);
		questionNumber.setForeground(Methods.foregroundColor);
		questionNumber.setFont(new Font("Serif",Font.BOLD,30));
		questionNumber.setBorder(BorderFactory.createBevelBorder(1));
		questionNumber.setHorizontalAlignment(JTextField.CENTER);
		questionNumber.setEditable(false);
			
		questionText.setBounds(5,130, 620, 100);
		questionText.setLineWrap(true);
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
	
		switch( LevelWindow.WhichLevelIsSelected() ) {
	
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
		
			new ResltatWindow();
			QuestionWindow.setVisible(false);
		}
		
		else {
		
			questionNumber.setText("  السؤال  "+ (qn + 1) ) ;
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


				if(correctanswers.get(c[qn] -1) != 'A'){
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
					OptionC.addMouseListener(new java.awt.event.MouseAdapter() {
				
						public void mouseEntered(java.awt.event.MouseEvent evt) {
							OptionC.setBackground(new Color(0,255,0));
						}
					
						public void mouseExited(java.awt.event.MouseEvent evt) {
							OptionC.setBackground(new Color(0,255,0));
						}
					});
				
				}
				
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
	
		return ( " ( "+ correctGuesses+ " / "+ totalQuestions +" ) " ) ;
	
	}
		
}
