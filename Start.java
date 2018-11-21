/*
 * Start.java
 * @author Frank Hildesheim, Leipzig 2013, 2014, 2015, 2016, 2017, 2018 (c), <FrankHildesheim@mail.ru>
 * Last change: 2018 Nov 01
 * ==================================================================================================================================================
 */

import java.io.IOException;


//===================================================================================================================================================
// Klasse 'Start'
//===================================================================================================================================================
public class Start {
	// Definiere neues Objekt
	static Movie2Video m2v;
	static Lists    sl;
	static String   new_m2v;
	static String   version;
	static String   last_chg;
	
	
	//===========================================================================================================================================
	// Programm Start
	//===========================================================================================================================================
	public static void main(String[] args) throws IOException {
		// New Instance
		m2v = new Movie2Video();
		sl = new Lists();
		new_m2v = "";
		version = "0.4.9.30";
		last_chg = "2018-11-01";
		//
		System.out.println("|=====================================================================================");
		System.out.println("|Movie2Video: Frank Hildesheim, Leipzig 2013 - 2018 <FrankHildesheim@mail.ru> (c)");
		System.out.println("|M2V-Version: " + version);
		System.out.println("|Last Change: " + last_chg);
		System.out.println("|Your System: " + System.getProperty("os.name").toLowerCase());
		System.out.println("|=====================================================================================\n");
		// 
		while (! new_m2v.equals(Lists.NO)) {
			// Start Program new
			newM2V();
		}
		// Program End
		System.out.println("===============================================================================================\n");
		System.out.println("Program finished!");
		System.exit(0);
	}
	
	
	//===========================================================================================================================================
	// Methode 'newM2V'
	//===========================================================================================================================================
	private static void newM2V() {
		// Movie2Video
		while (! sl.question.containsKey(new_m2v)) {
			System.out.print("Start new M2V \t" + sl.question.values() + ": ");
			new_m2v = m2v.cons.readLine();
		}
		// Movie2Video starts / restarts here
		if (new_m2v.equals(Lists.YES)) {
			try {
				// Reset all Input Data
				m2v.resetData();
				// Read Console Input
				m2v.dataInput();
				// Execute Commands
				m2v.execCommands();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			// Reset for new Session
			new_m2v = "";
		}
	}
}
/*
 * End Start.java
 */
