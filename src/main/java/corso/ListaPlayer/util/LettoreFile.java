package corso.ListaPlayer.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class LettoreFile {
	
	public static HashMap<String, String> getDBCONF() {
		HashMap<String, String> ris = new HashMap<String, String>();
		
		Scanner file = null;
		String row;
		try {
			file = new Scanner(new File("res/dbConf.txt"));
			while(file.hasNextLine()) {
				row = file.nextLine();
				ris.put(row.split(";")[0], row.split(";")[1]);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(file != null) file.close();
		}
		
		return ris;
	}

}
