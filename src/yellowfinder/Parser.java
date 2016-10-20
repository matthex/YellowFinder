package yellowfinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {
	
	static int i = 1;
	
	public static String takeFile (File file) throws FileNotFoundException {
		
		String Yellows = "";
		
			Scanner scanner = new Scanner (file);
				
		while(scanner.hasNextLine()){
			String OneYellow = scanLine(scanner.nextLine());
			if (OneYellow != null){
				Yellows = Yellows + OneYellow;
			}
		}
		return Yellows;
	}
	
	static String scanLine (String line){
		
		String OneYellow = null;
		
		Scanner linescanner = new Scanner (line);
		if (linescanner.hasNext()){
			String inline = line;
			String yellow = linescanner.findInLine("Yellow flag state 0-&gt;1");
			if (yellow != null){
				Scanner inlinescanner = new Scanner (inline);
				inlinescanner.useDelimiter("\"");
				inlinescanner.next();
				String timeString = inlinescanner.next();
				//System.out.println(timeString);
				
				float time = Float.valueOf( timeString ).floatValue();
				//System.out.println(time);
				int min = (int) Math.floor(time / 60);
				//System.out.println(min);
				int sek = (int) (time%60);
				String sekS = ""+sek;	//int sek zu String
				if (sekS.length()==1){
					sekS = "0"+sekS;	//0 vorne dran stellen, falls Sek nur eine Stelle hat
				}
				
				OneYellow = "Gelbphase #" + i + ": " + min + ":" + sekS + "\n \n";
				
				i++;
			}
		}
		return OneYellow;
	}


}
