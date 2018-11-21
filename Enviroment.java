/*
 * Enviroment.java
 * @author Frank Hildesheim, Leipzig 2013, 2014, 2015, 2016, 2017, 2018 (c), <FrankHildesheim@mail.ru>
 * Last change: 2018 Oct 29
 * ==================================================================================================================================================
 */

import java.io.File;


//===================================================================================================================================================
// Klasse 'Enviroment'
//===================================================================================================================================================
public class Enviroment {
	// System & Devices
	private final String		os;                                                             // Operating System
	private final String 		user;                                                           // User
	private final String 		fs;                                                             // Separator
	private final String 		player;                                                         // Mplayer Binary
	private final String 		encoder;                                                        // Mencoder Binary
	private final String 		dev_null;                                                       // Device Null	
	private final String		dev_dvd;                                                        // CD-ROM / DVD Device
        private final File		wdr;                                                            // Working Directory
	private final SortedStringList  dvd_devices;                                                    // DVD Devices List
	private final SortedStringList  frm_devices;                                                    // Formated List with Linux DVD Devices
	private String                  frm_dvd;                                                        // Full Device-Path of CD-ROM / DVD
	
	
	//===========================================================================================================================================
	// Konstruktor
	//===========================================================================================================================================
	public Enviroment() {
		// Operating System
		this.os = System.getProperty("os.name").toLowerCase();
		this.user = System.getProperty("user.name");
		this.fs = File.separator;
		// List with OS depended DVD-Devices
		this.dvd_devices = new SortedStringList();
		this.frm_devices = new SortedStringList();
            // Linux
            switch (this.os) {
                case "linux":
                    this.player = "mplayer" ;
                    this.encoder = "mencoder";
                    this.dev_null = this.fs + "dev" + this.fs + "null";
                    this.dev_dvd = this.fs + "dev" + this.fs + "sr0";
                    this.wdr = new File(this.fs + "home" + this.fs + this.user + this.fs + "Temp" + this.fs + "Videos");
                    // DVD Devices
                    this.dvd_devices.put("0", "CD(0)");
                    this.dvd_devices.put("1", "CD(1)");
                    this.dvd_devices.put("2", "CD(2)");
                    // DVD Devices (Full Path)
                    this.frm_devices.put("0", this.fs + "dev" + this.fs + "sr0");
                    this.frm_devices.put("1", this.fs + "dev" + this.fs + "sr1");
                    this.frm_devices.put("2", this.fs + "dev" + this.fs + "sr2");
                    // MacOS
                    break;
                case "darwin":
                    this.player = "mplayer" ;
                    this.encoder = "mencoder";
                    this.dev_null = this.fs + "dev" + this.fs + "null";
                    this.dev_dvd = this.fs + "dev_null" + this.fs + "disk0";
                    this.wdr = new File(this.fs + "Users" + this.fs + this.user + this.fs + "Temp" + this.fs + "Videos");
                    // DVD Devices
                    this.dvd_devices.put("0", "CD(0)");
                    this.dvd_devices.put("1", "CD(1)");
                    this.dvd_devices.put("2", "CD(2)");
                    // DVD Devices (Full Path)
                    this.frm_devices.put("0", this.fs + "device" + this.fs + "disk0");
                    this.frm_devices.put("1", this.fs + "device" + this.fs + "disk1");
                    this.frm_devices.put("2", this.fs + "device" + this.fs + "disk2");
                    // Windows
                    break;
                case "windows 8.1":
                    this.player = "mplayer.exe";
                    this.encoder = "mencoder.exe";
                    this.dev_null = "NUL";
                    this.dev_dvd = "D:";
                    this.wdr = new File("C:" + this.fs + "Temp");
                    // DVD Devices
                    this.dvd_devices.put("d", "(D):");
                    this.dvd_devices.put("e", "(E):");
                    this.dvd_devices.put("f", "(F):");
                    // DVD Devices (Full Path)
                    this.frm_devices.put("d", "D:");
                    this.frm_devices.put("e", "E:");
                    this.frm_devices.put("f", "F:");
                    // NetBSD
                    break;
                case "netbsd":
                    this.player = "mplayer";
                    this.encoder = "mencoder";
                    this.dev_null = this.fs + "dev" + this.fs + "null";
                    this.dev_dvd = this.fs + "dev" + this.fs + "rcd0d";
                    this.wdr = new File(this.fs + "home" + this.fs + this.user + this.fs + "Temp" + this.fs + "Videos");
                    // DVD Devices
                    this.dvd_devices.put("0", "CD(0)");
                    this.dvd_devices.put("1", "CD(1)");
                    this.dvd_devices.put("2", "CD(2)");
                    // DVD Devices (Full Path)
                    this.frm_devices.put("0", this.fs + "dev" + this.fs + "rcd0d");
                    this.frm_devices.put("1", this.fs + "dev" + this.fs + "rcd1d");
                    this.frm_devices.put("2", this.fs + "dev" + this.fs + "rcd2d");
                    // OpenBSD
                    break;
                case "openbsd":
                    this.player = "mplayer";
                    this.encoder = "mencoder";
                    this.dev_null = this.fs + "dev" + this.fs + "null";
                    this.dev_dvd = this.fs + "dev" + this.fs + "rcd0c";
                    this.wdr = new File(this.fs + "home" + this.fs + this.user + this.fs + "Temp" + this.fs + "Videos");
                    // DVD Devices
                    this.dvd_devices.put("0", "CD(0)");
                    this.dvd_devices.put("1", "CD(1)");
                    this.dvd_devices.put("2", "CD(2)");
                    // DVD Devices (Full Path)
                    this.frm_devices.put("0", this.fs + "dev" + this.fs + "rcd0c");
                    this.frm_devices.put("1", this.fs + "dev" + this.fs + "rcd1c");
                    this.frm_devices.put("2", this.fs + "dev" + this.fs + "rcd2c");
                    // Other
                    break;
                default:
                    this.player = "mplayer" ;
                    this.encoder = "mencoder";
                    this.dev_null = this.fs + "dev" + this.fs + "null";
                    this.dev_dvd = this.fs + "dev" + this.fs + "cd0a";
                    this.wdr = new File(this.fs + "home" + this.fs + this.user + this.fs + "Temp" + this.fs + "Videos");
                    // DVD Devices
                    this.dvd_devices.put("0", "CD(0)");
                    this.dvd_devices.put("1", "CD(1)");
                    this.dvd_devices.put("2", "CD(2)");
                    // DVD Devices (Full Path)
                    this.frm_devices.put("0", this.fs + "dev" + this.fs + "cd0a");
                    this.frm_devices.put("1", this.fs + "dev" + this.fs + "cd1a");
                    this.frm_devices.put("2", this.fs + "dev" + this.fs + "cd2a");
                    break;
            }
	}
	
	
	//===========================================================================================================================================
	// Methode 'getPlayer'
	//===========================================================================================================================================
	public String getPlayer() {
		// Return Player
		return (this.player);
	}
	
	
	//===========================================================================================================================================
	// Methode 'getEncoder'
	//===========================================================================================================================================
	public String getEncoder() {
		// Return Encoder
		return (this.encoder);
	}
	
	
	//===========================================================================================================================================
	// Methode 'getDevice'
	//===========================================================================================================================================
	public String getDevice() {
		// Return Device Null
		return (this.dev_null);
	}
	
	
	//===========================================================================================================================================
	// Methode 'getFrmDevice'
	//===========================================================================================================================================
	public String getFrmDevice(String d) {
		// Get full Path DVD Device
		this.frm_dvd = this.frm_devices.get(d);
		// Return DVD Device
		return (this.frm_dvd);
	}
	
	
	//===========================================================================================================================================
	// Methode 'getDVD'
	//===========================================================================================================================================
	public String getDVD() {
		// Return DVD Device
		return (this.dev_dvd);
	}
	
	
	//===========================================================================================================================================
	// Methode 'getFS'
	//===========================================================================================================================================
	public String getFS() {
		// Return FileSeparator
		return (this.fs);
	}
	
	
	//===========================================================================================================================================
	// Methode 'getWDR'
	//===========================================================================================================================================
	public File getWDR() {
		// Return WDR
		return (this.wdr);
	}
	
	
	//===========================================================================================================================================
	// Methode 'getDvdDevices'
	//===========================================================================================================================================
	public SortedStringList getDvdDevices() {
		// Return DVD Devices
		return (this.dvd_devices);
	}
}
//
// End Enviremont.java
//
