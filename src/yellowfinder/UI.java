package yellowfinder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.*;

public class UI {
	
	static File file;
	
	static void ui ()
	{
		
		
		final JFrame f = new JFrame( "Yellow Finder" ); 
		final JButton button1 = new JButton("Logdatei laden");
		final JButton button2 = new JButton("");
		final JFileChooser fc = new JFileChooser();
		final JTextArea ta = new JTextArea();
		
	    f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
	    
	    f.add(button1);
	    f.setSize( 150, 70 ); 
	    f.setVisible( true ); 
	    	    
	    
	    ActionListener a1 = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				f.add(fc);
				
				int Val = fc.showOpenDialog(fc);
				
				if (Val == JFileChooser.APPROVE_OPTION){
					file = fc.getSelectedFile();
				}
				else {}
				
				f.remove(button1);
				f.setSize(400, 80);
				button2.setText("Yellows finden in " + file.getName());
				f.add(button2);
				
			};
	    };
	    
	    ActionListener a2 = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				String Yellows = null;
				
				try {
					Yellows = Parser.takeFile(file);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				f.remove(button2);
				f.setSize(200, 400);
				f.add(ta);
				ta.setText(Yellows);
				f.add( new JScrollPane( ta ) ); 
			};
	    };
	    
	    button1.addActionListener(a1);
	    button2.addActionListener(a2);
	}

}
