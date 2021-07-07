
import java.util.Random;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public abstract class Methods {
	
	static Color backgroundColor = new Color(43,43,43); 
	static Color foregroundColor = new Color(240,240,240);
	static Color borderColor = new Color(189,81,81);

	public static void ChangeColor(Color bC){
		borderColor = bC;
	}

    static int [] c ; 
    static int index, i ,j ;
    static boolean v ;
    static Random rand = new Random();

    static void QuestionsIndex(int []cp){
        i = 0 ;
        c = cp ; 
     
        while( i != c.length ){
     
            v = true ;
            index = rand.nextInt(c.length+1);
            j = 0;
     
            while(v == true && j != c.length ){
     
                if(index == c[j])
                    v = false;
                j++;
            }       
     
            if(v == true){
                c[i] = index;
                i++;
            } 
        }
    }
    
    static File bs = new File("best-score.txt");
    
    static int readBestScorefromTheFile(){
     
        try{ 
            Scanner scn = new Scanner(bs);
            String s = scn.nextLine();
          
            scn.close();
            return Integer.parseInt(s);
        }
     
        catch(FileNotFoundException fe){}
     
        return 0 ;   
    }
  
    static void writeBestScoreInTheFile(){
     
        try{ 
            int cBestScore = readBestScorefromTheFile();
            PrintWriter  ws = new PrintWriter(bs);

            if(QuestionWindow.results() > cBestScore )
                ws.print( QuestionWindow.results());
            else if ( QuestionWindowE.results() > cBestScore )
                ws.print( QuestionWindowE.results() );
            else
                ws.print( cBestScore );
                
            ws.close();   
        }
        
        catch(FileNotFoundException fe){}
    }
}
