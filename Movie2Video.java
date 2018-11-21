/*
 * Movie2Video.java
 * @author Frank Hildesheim, Leipzig 2013, 2014, 2015, 2016, 2017, 2018 (c), <FrankHildesheim@mail.ru>
 * Last change: 2018 Nov 01
 * ==================================================================================================================================================
 */

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


//===================================================================================================================================================
// Klasse 'Movie2Video'
//===================================================================================================================================================
public class Movie2Video {
	// Thread Sleep Time
	public int              thread_time;                                                            // Thread Time (Ms)
	// Enviroment
	public Enviroment	env;									// OS depended Values
	public String	   	fs;                                                                     // File Separator
	public File             wdr;									// Working Directory
	// Files in WDR
	private final String	dmp_string;								// Name of Dump File
	private final String	tmp_string;								// Name of Temp File
        private final String    sbt_string;                                                             // Name of Subtitles File
        private final File      idx_file;								// File 'subtitles.idx'
	private final File      sub_file;								// File 'subtitles.sub'
	private final File      log_file;								// File 'divx2pass.log'
	private final File      mbt_file;								// File 'divx2pass.log.mbtree'
        //
	private String		org_of;									// Org. Video File Extension / Output Format
	private File	   	dmp_file;								// File 'dump.*'
	private File	   	tmp_file;								// File	'temp.*'
	// Binaries & Devices
	private final String    player;									// Binary 'mplayer'
	private final String    encoder;								// Binary 'mencoder'
	private final String    dev_null;								// Device Null
	private String	   	dev_dvd;								// CDROM- / DVD-Device
	// DVD / Movie
	private String	   	chg_device;								// Change CDROM / DVD Device (y/n)
	private String	   	create_dump;                                                            // Create CDROM / DVD Dump (y/n)
	private String		save_dump;								// Save CDROM / DVD Dump (y/n)
	private String	   	pb_method;								// CDROM / DVD Playback Method
	private String	   	check_wdr;								// Check WDR for Video Files (y/n)
	private String	   	name;									// Movie Name
	private String	   	movie_nr;								// Movie Nr. / Video ID
	private String	   	start_chapter;                                                          // Chapter Nr. (Start)
	private String	   	end_chapter;                                                            // Chapter Nr. (End) 
	private String	   	aid;									// Audio ID
	// Custom Settings
        private String          non_interleave;                                                         // Non-Interleaved AVI Video (y/n)
	private String	   	vnc;									// Video Encoder
        private String	   	container;								// Video Container
	private String	   	vbr;									// Video Bitrate
	private String		vfm;									// Video Format
	private String	   	enc_mode;								// Encoding Mode
	private String	   	anc;									// Audio Encoder
	private String	   	abr;									// Audio Bitrate
	private String	   	aq;                                                                     // Audio Quality
	private String	   	am;                                                                     // Audio Mode
	private String	   	cbr;									// Constant Bitrate (y/n)
	private String	   	mc;                                                                     // Maximum AV-Sync Correction
	private String	   	av_sync;								// AV-Sync Correction
	private String	   	ffourcc;								// Video Fourcc (y/n)
	private String	   	forceidx;								// AVI Index (y/n) 
	private String	   	of;                                                                     // Extension / Output Format
	// Test Mode
	private String	   	test_mode;								// Test Mode (y/n)
	private String	   	end_pos;								// Endposition (Min.)
	private String	   	end_time;								// Endtime of Encoding (hh:mm:ss.ms)
	private String		start_time;								// Starttime of Encoding (hh:mm:ss.ms)
	// Audio Filter
	private String	   	audio_filter;                                                           // Audio Filrer (y/n)
	private String	   	resample_rate;                                                          // Resample Rate (High, Normal, Low)
	private String 	   	set_volume;                                                             // Set new Audio Volume (y/n)
	private String	   	audio_volume;                                                           // Audio Volume (dB)
	// Movie Size
	private String		movie_width;                                                            // Movie Width
	private String		movie_height;                                                           // Movie Height
	// Crop Filter
	private String          crop_filter;                                                            // Crop Filter (y/n)
	private String          crop_width;								// Crop Width
	private String          crop_height;                                                            // Crop Height
	private String          crop_left;								// Crop Left Mark
	private String          crop_top;								// Crop Top Mark
	// Video Format
	private String		set_vfm;								// Set Video Format (y/n)
	// Scale Filter
	private String	   	scale_filter;                                                           // Scale Filter (y/n)
	private String	   	scale_width;                                                            // Scale Width
	private String	   	scale_height;                                                           // Scale Height
	private String	   	sw_scaler;								// Software Scaler
	// Dsize Filter
	private String	   	dsize_filter;                                                           // Dsize Filter (y/n)
	private String	   	dsize_aspect;                                                           // Dsize Aspect
	private String	   	dsize_width;                                                            // Dsize Width
	private String	   	dsize_height;                                                           // Dsize Height
	private String	   	aspect_method;                                                          // Dsize Ratio
	// Expand Filter
	private String	   	expand_filter;                                                          // Expand Filter (y/n)
	private String	   	expand_width;                                                           // Expand Width
	private String	   	expand_height;                                                          // Expand Height
	private String	   	expand_left;                                                            // Expand Left Mark
	private String	   	expand_top;								// Expand Top Mark
	// Parameter Lists
	private Parms_OAC  	parms_oac;								// OAC Parameter List (OAC)
	private Parms_OVC  	parms_ovc;								// OVC Parameter List (OVC1, OVC2)
	private Parms_VF   	parms_vf;								// VF Parameter List (VF, SWS)
	private Parms_AF   	parms_af;								// AF Parameter List (AF)
	// Misc Parameters
	private String	   	chp_parms;								// Chapter Parameter
	private String	   	oac_parms;								// OAC Parameter
	private String	   	ovc_parms1;								// OVC Parameter (Pass 1)
	private String	   	ovc_parms2;								// OVC Parameter (Pass 2)
	private String	   	vf_parms;								// VF Parameter
	private String	   	ffourcc_parms;                                                          // FFourcc Parameter
	private String	   	forceidx_parms;                                                         // Forceidx Parameter
        private String          nilavi_parms;                                                           // Non-Interleave Parameter
	private String	   	of_parms;								// Output Format Parameter
	private String		start_parms;                                                            // Startposition Parameter
	private String	   	end_parms;								// Endposition Parameter
	// Execution Binary Strings
	public String	   	os_system0;								// Execution Command for Mplayer
	public String	   	os_system1;								// Execution Command for Mencoder (Pass 1)
	public String	   	os_system2;								// Execution Command for Mencoder (Pass 2)
	// Sorted Lists (String Keys)
	public Lists 	  	sorted_lists;                                                           // Sorted Lists (String- or Integer-Keys)
	public SortedStringList	dvd_devs;                                                               // DVD Devices (OS depended)
	public SortedVideoList 	list_videos;                                                            // Videos in WDR
	// Konsole
	public Console          cons;                                                                   // Terminal Console
	
	
	//===========================================================================================================================================
	// Konstruktor
	//===========================================================================================================================================
	public Movie2Video() {
		// Enviroment & OS depended Vars
		this.env        = new Enviroment();
		this.fs         = this.env.getFS();
		this.wdr        = this.env.getWDR();
		this.player     = this.env.getPlayer();
		this.encoder    = this.env.getEncoder();
		this.dev_null   = this.env.getDevice();
		this.dvd_devs   = this.env.getDvdDevices();
                // Console
                this.cons       = System.console();
		// Thread Sleep Time
		this.thread_time = 1500;
                // Dump-/ Temp-Filename Strings
                this.dmp_string = "dump";
		this.tmp_string = "temp";
                this.sbt_string = "subtitles";
		// Subtitles- & Log-Files
		this.idx_file = new File(this.wdr + this.fs + this.sbt_string + ".idx");
		this.sub_file = new File(this.wdr + this.fs + this.sbt_string + ".sub");
		this.log_file = new File(this.wdr + this.fs + "divx2pass.log");
		this.mbt_file = new File(this.wdr + this.fs + "divx2pass.log.mbtree");
		// Sorted Lists Class
		this.sorted_lists = new Lists();
	}
	
	
	//===========================================================================================================================================
	// Methode 'resetData'
	//===========================================================================================================================================
	public void resetData() {
		// Reset all Variables
		this.create_dump = "";
		this.save_dump = "";
		this.pb_method = "";
		this.check_wdr = "";
		this.chg_device = "";
		this.dev_dvd = "";
		this.org_of = "";
		this.name = "";
		this.movie_nr = Lists.NULL;
		this.start_chapter = Lists.MINUS_ONE;
		this.end_chapter = Lists.MINUS_ONE;
		this.aid = Lists.MINUS_ONE;
                this.non_interleave = "";
		this.vnc = "";
                this.container = "";
		this.vbr = Lists.NULL;
		this.vfm = "";
		this.enc_mode = "";
		this.anc = "";
		this.abr = Lists.NULL;
		this.aq = Lists.TEN;
		this.am = "";
		this.cbr = "";
		this.mc = "";
		this.av_sync = "";
		this.ffourcc = "";
		this.forceidx = "";
                this.nilavi_parms = "";
		this.of = "";
		this.test_mode = "";
		this.end_pos = Lists.NULL;
		this.end_time = Lists.NULL;
		this.start_time= Lists.NULL;
		this.audio_filter = "";
		this.resample_rate = "";
		this.set_volume = "";
		this.audio_volume = Lists.MINUS_ONE;
		this.movie_width = Lists.NULL;
		this.movie_height = Lists.NULL;
		this.crop_filter = "";
		this.crop_width = Lists.NULL;
		this.crop_height = Lists.NULL;
		this.crop_left = Lists.NULL;
		this.set_vfm = "";
		this.scale_filter = "";
		this.scale_width = Lists.NULL;
		this.scale_height = Lists.ONE;
		this.sw_scaler = "";
		this.dsize_filter = "";
		this.dsize_aspect = Lists.MINUS_ONE;
		this.dsize_width = Lists.NULL;
		this.dsize_height = Lists.NULL;
		this.aspect_method = Lists.NULL;
		this.expand_filter = "";
		this.expand_width = Lists.NULL;
		this.expand_height = Lists.NULL;
		this.expand_left = Lists.NULL;
		this.expand_top = Lists.NULL;
		this.chp_parms = "";
		this.oac_parms = "";
		this.ovc_parms1 = "";
		this.ovc_parms2 = "";
		this.vf_parms = "";
		this.ffourcc_parms = "";
		this.forceidx_parms = "";
		this.of_parms = "";
		this.start_parms="";
		this.end_parms = "";
		this.os_system0 = "";
		this.os_system1 = "";
		this.os_system2 = "";
	}
	
	
	//===========================================================================================================================================
	// Methode 'dataInput'
	//===========================================================================================================================================
	public void dataInput() {
		// Dump DVD
		while (! this.sorted_lists.question.containsKey(this.create_dump)) {
                        System.out.print("VCD/DVD->Dump \t" + this.sorted_lists.question.values() + ": ");
                        this.create_dump = cons.readLine();
		}
		// With Dump File
		if (this.create_dump.equals(Lists.YES)) {
                        // Playback Method
                        while (! this.sorted_lists.pb_methods.containsKey(this.pb_method)) {
                                System.out.print("With Playback \t" + this.sorted_lists.pb_methods.values() + ": ");
                                this.pb_method = cons.readLine();
                        }
                        // Set Original File Extension
                        this.org_of = Lists.OF_VOB;
                        // Default DVD Device
                        while (! this.sorted_lists.question.containsKey(this.chg_device)) {
                                System.out.print("Change Device \t" + this.sorted_lists.question.values() + ": ");
                                this.chg_device = cons.readLine();
                        }
                        // Change DVD Device
                        if (this.chg_device.equals(Lists.YES)) {
                                // DVD Device
                                while (! this.dvd_devs.containsKey(this.dev_dvd)) {
                                        System.out.print("DVD Device is \t" + this.dvd_devs.values() + ": ");
                                        this.dev_dvd = cons.readLine();
                                }
                                // Full Path Device
                                this.dev_dvd = this.env.getFrmDevice(this.dev_dvd);
                        // Don't change DVD Device
                        } else if (! this.chg_device.equals(Lists.YES)) {
                                // Default DVD Device
                                this.dev_dvd = this.env.getDVD();
                                System.out.println("DVD Device is \t[(Use 1st CD-ROM Device)]: " + this.dev_dvd);
                        }
                        // Name (DVD Movie)
                        System.out.print("Movie Name is \t[(Title of Video)]: ");
                        this.name = cons.readLine();
                        // Movie Nr. on DVD
                        while (! this.movie_nr.matches("[1-99]")) {
                                System.out.print("Movie VideoID \t[(1 - 99)]: ");
                                this.movie_nr = cons.readLine();
                        }
                        // Chapter Nr. (Begin)
                        while (! this.sorted_lists.chapters.containsKey(Integer.parseInt(this.start_chapter))) {
                                System.out.print("Chapter ----> \t[(0 - 25)]: ");
                                this.start_chapter = cons.readLine();
                        }
                        // Chapter Nr. (End)
                        while (! this.sorted_lists.chapters.containsKey(Integer.parseInt(this.end_chapter))) {
                                System.out.print("<---- Chapter \t[(0 - 25)]: ");
                                this.end_chapter = cons.readLine();
                        }
                        // Audio ID (Vob File)
                        while (! this.sorted_lists.audio_ids_dvd.containsKey(Integer.parseInt(this.aid))) {
                                System.out.print("Movie AudioID \t" + this.sorted_lists.audio_ids_dvd.values() + ": ");
                                this.aid = cons.readLine();
                        }
		// Without Dump File
		} else if (! this.create_dump.equals(Lists.YES)) {
			// Check WDR for Video Files
			System.out.print("Search in WDR \t" + this.sorted_lists.question.values() + ": ");
			this.check_wdr = cons.readLine();
			// Without Video File Check in WDR
			if (! this.check_wdr.equals(Lists.YES)) {
				System.exit(1);
			}
			// New Sorted Video List
			this.list_videos = new SortedVideoList(this.env.getWDR());
			// Search for Videos in Directory
			this.list_videos.search();
			// No Video File found in WDR
			if (this.list_videos.size() == 0) {
				System.out.println("No Video-File \t[" + this.env.getWDR() + "]: Good by...");
				// Exit Program
				System.exit(1);
			// Only 1 Video File found in WDR
			} else if (this.list_videos.size() == 1) {
				System.out.println("Videos in WDR \t[(0" + String.valueOf(this.list_videos.size()) +  ") - '" + this.list_videos.get(this.list_videos.size() -1) + "']");
			// More than 1 Video File found in WDR
			} else if (this.list_videos.size() > 1) {
				// For all founded Videos in List
				for (int i = 1; i < this.list_videos.size(); i++) {
					// 1. Video
					if (i == 1) {
						System.out.println("Videos in WDR \t[(0" + String.valueOf(i) +  ") - '" + this.list_videos.get(i -1) + "',");
					// 2. - 9. Video
					} else if (i > 1 && i <= 9) {
						System.out.println("\t\t (0" + String.valueOf(i) +  ") - '" + this.list_videos.get(i -1) + "',");
					// 10. - xxx Video
					} else if (i > 9) {
						System.out.println("\t\t (" + String.valueOf(i) +  ") - '" + this.list_videos.get(i -1) + "',");
					}
                                }
                                // Last Video
                                if (this.list_videos.size() < 10) {
                                        System.out.println("\t\t (0" + String.valueOf(this.list_videos.size()) +  ") - '" + this.list_videos.get(this.list_videos.size() -1) + "']");
                                } else if (this.list_videos.size() >= 10) {
                                        System.out.println("\t\t (" + String.valueOf(this.list_videos.size()) +  ") - '" + this.list_videos.get(this.list_videos.size() -1) + "']");
                                }
			}
			// Nr. of Video File ( 1 )
			if (this.list_videos.size() == 1) {
				System.out.print("Set Video Nr. \t[(0" + this.list_videos.size() + ")]: ");
			// Nr. of Video File ( > 1 < 10 ) 
			} else if (this.list_videos.size() > 1 && this.list_videos.size() < 10) {
				System.out.print("Set Video Nr. \t[(01-0" + this.list_videos.size() + ")]: ");
			// Nr. of Video File ( >= 10 )
			} else if (this.list_videos.size() >= 10) {
				System.out.print("Set Video Nr. \t[(01-" + this.list_videos.size() + ")]: ");
			}
			// Select one Video File
			String nr = cons.readLine();
			// Get Video Name & Original File Extension
			System.out.println("Video Name is \t[(" + this.list_videos.getVideo(Integer.parseInt(nr) -1)[0] + ")]: " + this.list_videos.getVideo(Integer.parseInt(nr) -1)[0]);
			this.name = this.list_videos.getVideo(Integer.parseInt(nr) -1)[0];
			this.org_of = this.list_videos.getVideo(Integer.parseInt(nr) -1)[1];
			// Audio ID (File is a VOB)
			if (this.org_of.equals(Lists.OF_VOB)) {
				while (! this.sorted_lists.audio_ids_dvd.containsKey(Integer.parseInt(this.aid))) {
					System.out.print("Movie AudioID \t" + this.sorted_lists.audio_ids_dvd.values() + ": ");
					this.aid = cons.readLine();
				}
			// Audio ID (File isn't a VOB)
			} else if (! this.org_of.equals(Lists.OF_VOB)) {
				while (! this.sorted_lists.audio_ids_vid.containsKey(Integer.parseInt(this.aid))) {
					System.out.print("Video AudioID \t" + this.sorted_lists.audio_ids_vid.values() + ": ");
					this.aid = cons.readLine();
				}
			}
                        // Non-Interleave AVI Video
                        if (this.org_of.equals(Lists.OF_AVI)) {
                                while (! this.sorted_lists.question.containsKey(this.non_interleave)) {
                                        System.out.print("NonInterleave \t" + this.sorted_lists.question.values() + ": ");
                                        this.non_interleave = cons.readLine();
                                }
                        }
		}
		// Video Encoder
		while (! this.sorted_lists.vid_encoders.containsKey(this.vnc)) {
			System.out.print("Video Encoder \t" + this.sorted_lists.vid_encoders.values() + ": ");
			this.vnc = cons.readLine();	
		}
                // Video Container
                switch (this.vnc) {
                        // Container for DivX Encoder
                        case Lists.VNC_DIVX:
                                while (! this.sorted_lists.containers.containsKey(this.container)) {
                                        System.out.print("Container-Typ \t[" + this.sorted_lists.containers.get(Lists.CONT_AVI) + ", " + this.sorted_lists.containers.get(Lists.CONT_MP4) + ", " +  this.sorted_lists.containers.get(Lists.CONT_TSK) + "]: ");
                                        this.container = cons.readLine();
                                }
                                break;
                        // Container for H264 Encoder       
                        case Lists.VNC_H264:
                                while (! this.sorted_lists.containers.containsKey(this.container)) {
                                        System.out.print("Container-Typ \t[" + this.sorted_lists.containers.get(Lists.CONT_MP4) + ", " +  this.sorted_lists.containers.get(Lists.CONT_TSK) + "]: ");
                                        this.container = cons.readLine();
                                }
                                break;
                        // Container for MPEG2 Encoder     
                        case Lists.VNC_MPG2:
                                while (! this.sorted_lists.containers.containsKey(this.container)) {
                                        System.out.print("Container-Typ \t[" + this.sorted_lists.containers.get(Lists.CONT_DVD) + ", " + this.sorted_lists.containers.get(Lists.CONT_VCD) + "]: ");
                                        this.container = cons.readLine();
                                }
                                break;
                        // Container for Theora Encoder      
                        case Lists.VNC_THEO:
                                while (! this.sorted_lists.containers.containsKey(this.container)) {
                                        System.out.print("Container-Typ \t[" + this.sorted_lists.containers.get(Lists.CONT_TSK) + "]: ");
                                        this.container = cons.readLine();
                                }
                                break;
                        // Container for Xvid Encoder
                        case Lists.VNC_XVID:
                                while (! this.sorted_lists.containers.containsKey(this.container)) {
                                        System.out.print("Container-Typ \t[" + this.sorted_lists.containers.get(Lists.CONT_AVI) + ", " + this.sorted_lists.containers.get(Lists.CONT_MP4) + ", " +  this.sorted_lists.containers.get(Lists.CONT_TSK) + "]: ");
                                        this.container = cons.readLine();
                                }
                                break;
                        default:
                                break;
                }
		// Video Bitrate
		while (! this.sorted_lists.vid_bitrates.containsKey(Integer.parseInt(this.vbr))) {
			System.out.print("Video Bitrate \t" + this.sorted_lists.vid_bitrates.values() + ": ");
			this.vbr = cons.readLine();
		}
		// Encoding Mode
		while (! this.sorted_lists.enc_modes.containsKey(this.enc_mode)) {
			System.out.print("Encoding Mode \t" + this.sorted_lists.enc_modes.values() + ": ");
			this.enc_mode = cons.readLine();
		}
                // Video Container Settings
                switch (this.container) {
                        // AVI Container Settings
                        case Lists.CONT_AVI:
                                // Video FFourcc
                                while (! this.sorted_lists.question.containsKey(this.ffourcc)) {
                                        System.out.print("FFourcc Video \t" + this.sorted_lists.question.values() + ": ");
                                        this.ffourcc = cons.readLine();
                                }
                                // Force Index Rebuilding
                                while (! this.sorted_lists.question.containsKey(this.forceidx)) {
                                        System.out.print("Index Rebuild \t" + this.sorted_lists.question.values() + ": ");
                                        this.forceidx = cons.readLine();
                                }
                                // Audio Encoder
                                while (! this.sorted_lists.audio_encoders.containsKey(this.anc)) {
                                        System.out.print("Audio Encoder \t[" + this.sorted_lists.audio_encoders.get(Lists.ANC_AC3) + ", " + this.sorted_lists.audio_encoders.get(Lists.ANC_MP3) + ", " + this.sorted_lists.audio_encoders.get(Lists.ANC_COP) + "]: ");
                                        this.anc = cons.readLine();
                                }
                                // Force a constant Bitrate in AVI Containers
                                this.cbr = Lists.YES;
                                break;
                        // DVD / MPEG2 Container Settings    
                        case Lists.CONT_DVD:
                        case Lists.CONT_VCD:
                                // Audio Encoder
                                while (! this.sorted_lists.audio_encoders.containsKey(this.anc)) {
                                        System.out.print("Audio Encoder \t[" + this.sorted_lists.audio_encoders.get(Lists.ANC_AC3) + ", " + this.sorted_lists.audio_encoders.get(Lists.ANC_TWO) + ", " + this.sorted_lists.audio_encoders.get(Lists.ANC_COP) + "]: ");
                                        this.anc = cons.readLine();
                                }
                                // AV Syncronisation for AC3 and MP2 Audio
                                if (this.anc.equals(Lists.ANC_AC3) || this.anc.equals(Lists.ANC_TWO)) {
                                        while (! this.sorted_lists.question.containsKey(this.av_sync)) {
                                                System.out.print("AV Sync-Flags \t" + this.sorted_lists.question.values() + ": ");
                                                this.av_sync = cons.readLine();
                                        }
                                // Force AV Syncronisation for Audio Copy (org.AC3)
                                } else if (this.anc.equals(Lists.ANC_COP)) {
                                        System.out.println("AV Sync-Flags \t" + this.sorted_lists.question.values() + ": " + Lists.YES);
                                        this.av_sync = Lists.YES;
                                }
                                break;
                        // MP4 Container Settings
                        case Lists.CONT_MP4:
                                // Audio Encoder
                                while (! this.sorted_lists.audio_encoders.containsKey(this.anc)) {
                                        System.out.print("Audio Encoder \t[" + this.sorted_lists.audio_encoders.get(Lists.ANC_AAC) + ", " + this.sorted_lists.audio_encoders.get(Lists.ANC_MP3) + ", " + this.sorted_lists.audio_encoders.get(Lists.ANC_COP) + "]: ");
                                        this.anc = cons.readLine();
                                }
                                break;
                        // Matroska Container Settings
                        case Lists.CONT_TSK:
                                // Force Index Rebuilding
                                while (! this.sorted_lists.question.containsKey(this.forceidx)) {
                                        System.out.print("Index Rebuild \t" + this.sorted_lists.question.values() + ": ");
                                        this.forceidx = cons.readLine();
                                }
                                // Audio Encoder
                                while (! this.sorted_lists.audio_encoders.containsKey(this.anc)) {
                                        System.out.print("Audio Encoder \t[" + this.sorted_lists.audio_encoders.get(Lists.ANC_AAC) + ", " + this.sorted_lists.audio_encoders.get(Lists.ANC_AC3) + ", " + this.sorted_lists.audio_encoders.get(Lists.ANC_FLC) + ", " + this.sorted_lists.audio_encoders.get(Lists.ANC_MP3) + ", " + this.sorted_lists.audio_encoders.get(Lists.ANC_COP) + "]: ");
                                        this.anc = cons.readLine();
                                }
                                break;
                        default:
                                break;
                }
                // Audio Encoder Settings
                switch (this.anc) {
                        // AAC / AC3 / FLAC Encoder Settings
                        case Lists.ANC_AAC:
                        case Lists.ANC_AC3:
                        case Lists.ANC_FLC:
                                // Audio Bitrate
                                while (! this.sorted_lists.audio_bitrates.containsKey(Integer.parseInt(this.abr))) {
                                        System.out.print("Audio Bitrate \t" + this.sorted_lists.audio_bitrates.values() + ": ");
                                        this.abr = cons.readLine();
                                }
                                break;
                        // MP2 Encoder Settings
                        case Lists.ANC_TWO:
                                // Audio Bitrate
                                while (! this.sorted_lists.audio_bitrates.containsKey(Integer.parseInt(this.abr))) {
                                        System.out.print("Audio Bitrate \t" + this.sorted_lists.audio_bitrates.values() + ": ");
                                        this.abr = cons.readLine();
                                }
                                // Audio Mode
                                while (! this.sorted_lists.audio_modes.containsKey(this.am)) {
                                        System.out.print("Audio Mode is \t" + this.sorted_lists.audio_modes.values() + ": ");
                                        this.am = cons.readLine();
                                }
                                break;
                        // MP3 Encoder Settings
                        case Lists.ANC_MP3:
                                // Audio Bitrate
                                while (! this.sorted_lists.audio_bitrates.containsKey(Integer.parseInt(this.abr))) {
                                        System.out.print("Audio Bitrate \t" + this.sorted_lists.audio_bitrates.values() + ": ");
                                        this.abr = cons.readLine();
                                }
                                // Audio Quality
                                while (! this.sorted_lists.audio_qualities.containsKey(Integer.parseInt(this.aq))) {
                                        System.out.print("Audio Quality \t" + this.sorted_lists.audio_qualities.values() + ": ");
                                        this.aq = cons.readLine();
                                }
                                // Audio Mode
                                while (! this.sorted_lists.audio_modes.containsKey(this.am)) {
                                        System.out.print("Audio Mode is \t" + this.sorted_lists.audio_modes.values() + ": ");
                                        this.am = cons.readLine();
                                }
                                // Constant Bitrate for MP3
                                while (! this.sorted_lists.question.containsKey(this.cbr)) {
                                        System.out.print("With CBR Mode \t" + this.sorted_lists.question.values() + ": ");
                                        this.cbr = cons.readLine();
                                }
                                break;
                        default:
                                break;
                }
		// All Audio Encoders (Not AC3-Copy)
		if (! this.anc.equals(Lists.ANC_COP)) {
			// Audio Filters
			while (! this.sorted_lists.question.containsKey(this.audio_filter)) {
				System.out.print("Audio Filters \t" + this.sorted_lists.question.values() + ": ");
				this.audio_filter = cons.readLine();
			}
			// Audio Filter Settings
			if (this.audio_filter.equals(Lists.YES)) {
				this.setAudioFilter();
			}
		}
		// Crop Filter
		while (! this.sorted_lists.question.containsKey(this.crop_filter)) {
			System.out.print("With Cropping \t" + this.sorted_lists.question.values() + ": ");
			this.crop_filter = cons.readLine();
		}
		// Crop Filter Settings
		if (this.crop_filter.equals(Lists.YES)) {
			this.setCropFilter();
		}
		// Video Format 
		while (! this.sorted_lists.question.containsKey(this.set_vfm)) {
			System.out.print("Select Format \t" + this.sorted_lists.question.values() + ": ");
			this.set_vfm = cons.readLine();
		}
		// Video Format
		if (this.set_vfm.equals(Lists.YES)) {
			while (! this.sorted_lists.video_formats.containsKey(this.vfm)) {
				System.out.print("Vid-Format is \t" + this.sorted_lists.video_formats.values() + ": ");
				this.vfm = cons.readLine();
			}
			// Force Scale Filter Settings
			this.scale_filter = Lists.YES;
		// Scale Filter
		} else if (! this.set_vfm.equals(Lists.YES)) {
			while (! this.sorted_lists.question.containsKey(this.scale_filter)) {
				System.out.print("Scaling Video \t" + this.sorted_lists.question.values() + ": ");
				this.scale_filter = cons.readLine();
			}
		}
		// Scale Filter Settings
		if (this.scale_filter.equals(Lists.YES)) {
			this.setScaleFilter();
		}
		// Dsize Filter
		while (! this.sorted_lists.question.containsKey(this.dsize_filter)) {
			System.out.print("Change Aspect \t" + this.sorted_lists.question.values() + ": ");
			this.dsize_filter = cons.readLine();
		}
		// Dsize Filter Settings
		if (this.dsize_filter.equals(Lists.YES)) {
			this.setDsizeFilter();
		}
		// Expand Filter
		while (! this.sorted_lists.question.containsKey(this.expand_filter)) {
			System.out.print("Expand Filter \t" + this.sorted_lists.question.values() + ": ");
			this.expand_filter = cons.readLine();
		}
		// Expand Filter Settings
		if (this.expand_filter.equals(Lists.YES)) {
			this.setExpandFilter();
		}
		// Set Test Mode
		while (! this.sorted_lists.question.containsKey(this.test_mode)) {
			System.out.print("Run Test-Mode \t" + this.sorted_lists.question.values() + ": ");
			this.test_mode = cons.readLine();
		}
		// Test Mode Settings & Start-Stop Position
		if (this.test_mode.equals(Lists.YES)) {
			// Only Endposition
			this.setEndPosition();
		} else if (! this.test_mode.equals(Lists.YES)) {
			// Start- / Stop-Position
			this.setStartStopPosition();
		}
		// Save Dump File
		while (! this.sorted_lists.question.containsKey(this.save_dump)) {
			System.out.print("Save DumpFile \t" + this.sorted_lists.question.values() + ": ");
			this.save_dump = cons.readLine();
		}
	}
	
	
	//===========================================================================================================================================
	// Methode 'setAudioFilter'
	//===========================================================================================================================================
	private void setAudioFilter() {
		// Change Audio Volume
		while (! this.sorted_lists.question.containsKey(this.set_volume)) {
			System.out.print("Change Volume \t" + this.sorted_lists.question.values() + ": ");
			this.set_volume = cons.readLine();
		}
		// Audio Volume
		if (this.set_volume.equals(Lists.YES)) {
			while (! this.sorted_lists.audio_volumes.containsKey(Integer.parseInt(this.audio_volume))) {
				System.out.print("New Volume is \t" + this.sorted_lists.audio_volumes.values() + ": ");
				this.audio_volume = cons.readLine();
			}
		}
		// Resampling Rate
		while (! this.sorted_lists.resample_rates.containsKey(this.resample_rate)) {
			System.out.print("Resample Rate \t" + this.sorted_lists.resample_rates.values() + ": ");
			this.resample_rate = cons.readLine();
		}
	}
	
	
	//===========================================================================================================================================
	// Methode 'setCropFilter'
	//===========================================================================================================================================
	private void setCropFilter() {
	   	// Movie Width
		while (! this.sorted_lists.movie_widths.containsKey(Integer.parseInt(this.movie_width))) {
			System.out.print("Org. Width is \t" + this.sorted_lists.movie_widths.values() + ": ");
			this.movie_width = cons.readLine();
		}
		// Movie Height
		while (! this.sorted_lists.movie_heights.containsKey(Integer.parseInt(this.movie_height))) {
			System.out.print("And Height is \t" + this.sorted_lists.movie_heights.values() + ": ");
			this.movie_height = cons.readLine();
		}
		// Crop Width
		while (! this.sorted_lists.crop_widths.containsKey(Integer.parseInt(this.crop_width))) {
			System.out.print("Crop Width is \t" + this.sorted_lists.crop_widths.values() + ": ");
			this.crop_width = cons.readLine();
		}
		// Crop Height
		while (! this.sorted_lists.crop_heights.containsKey(Integer.parseInt(this.crop_height))) {
			System.out.print("And Height is \t" + this.sorted_lists.crop_heights.values() + ": ");
			this.crop_height = cons.readLine();
		}
		// Crop Left
		int cl = (Integer.parseInt(this.movie_width) - Integer.parseInt(this.crop_width)) / 2;
		System.out.print("Set Crop Left \t[(" + String.valueOf(cl) + ")]: ");
		this.crop_left = cons.readLine();
		// Crop Top
		int ct = (Integer.parseInt(this.movie_height) - Integer.parseInt(this.crop_height)) / 2;
		System.out.print("And Top Value \t[(" + String.valueOf(ct) + ")]: ");
		this.crop_top = cons.readLine();
	}
	
	
	//===========================================================================================================================================
	// Methode 'setScaleFilter'
	//===========================================================================================================================================
	private void setScaleFilter() {
		// With Video Format
		if (this.set_vfm.equals(Lists.YES)) {
                        switch (this.vfm) {
                                // DVD Format
                                case Lists.VFM_DVD:
                                        this.scale_width = Lists.DVD_WIDTH;
                                        this.scale_height = Lists.DVD_HEIGHT;
                                        break;
                                // Full HD Format
                                case Lists.VFM_FHD:
                                        this.scale_width = Lists.FHD_WIDTH;
                                        this.scale_height = Lists.FHD_HEIGHT;
                                        break;
                                // HD ready Format
                                case Lists.VFM_HDTV:
                                        this.scale_width = Lists.HDTV_WIDTH;
                                        this.scale_height = Lists.HDTV_HEIGHT;
                                        break;
                                // iPod Format
                                case Lists.VFM_IPOD:
                                        this.scale_width = Lists.IPOD_WIDTH;
                                        this.scale_height = Lists.IPOD_HEIGHT;
                                        break;
                                // SVCD Format
                                case Lists.VFM_SVCD:
                                        this.scale_width = Lists.SVCD_WIDTH;
                                        this.scale_height = Lists.SVCD_HEIGHT;
                                        break;
                                // VCD Format
                                case Lists.VFM_VCD:
                                        this.scale_width = Lists.VCD_WIDTH;
                                        this.scale_height = Lists.VCD_HEIGHT;
                                        break;
                                // XGA Format
                                case Lists.VFM_XGA:
                                        this.scale_width = Lists.XGA_WIDTH;
                                        this.scale_height = Lists.XGA_HEIGHT;
                                        break;
                                default:
                                        break;
                        }
                // Without Video Format
		} else if (! this.set_vfm.equals(Lists.YES)) {
			// Scale Width
			while (! this.sorted_lists.scale_widths.containsKey(Integer.parseInt(this.scale_width))) {
				System.out.print("Set New Width \t" + this.sorted_lists.scale_widths.values() + ": ");
				this.scale_width = cons.readLine();
			}
			// Scale Height
			while (! this.sorted_lists.scale_heights.containsKey(this.scale_height)) {
                                System.out.print("New Height is \t" + this.sorted_lists.scale_heights.values() + ": ");
                                this.scale_height = cons.readLine();
			}
		}
		// Software Scaler
		while (! this.sorted_lists.sw_scalers.containsKey(this.sw_scaler)) {
			System.out.print("Set SW-Scaler \t" + this.sorted_lists.sw_scalers.values() + ": ");
			this.sw_scaler = cons.readLine();
		}
	}
	
	
	//===========================================================================================================================================
	// Methode 'setDsizeFilter'
	//===========================================================================================================================================
	private void setDsizeFilter() {
		// Dsize Aspect
		while (! this.sorted_lists.dsize_aspects.containsKey(this.dsize_aspect)) {
			System.out.print("Size / Aspect \t" + this.sorted_lists.dsize_aspects.values() + ": ");
			this.dsize_aspect = cons.readLine();
		}
		// Without Dsize Aspect
		if (this.dsize_aspect.equals(Lists.NULL)) {
			// Dsize Width
			while (! this.sorted_lists.dsize_widths.containsKey(Integer.parseInt(this.dsize_width))) {
				System.out.print("Display Width \t" + this.sorted_lists.dsize_widths.values() + ": ");
				this.dsize_width = cons.readLine();
			}
			// Dsize Height
			while (! this.sorted_lists.dsize_heights.containsKey(this.dsize_height)) {
				System.out.print("And Height is \t" + this.sorted_lists.dsize_heights.values() + ": ");
				this.dsize_height = cons.readLine();
			}
			// Aspect Method
			while (! this.sorted_lists.aspect_methods.containsKey(this.aspect_method)) {
				System.out.print("Aspect Method \t" + this.sorted_lists.aspect_methods.values() + ": ");
				this.aspect_method = cons.readLine();
			}
		}
		
	}
	
	
	//===========================================================================================================================================
	// Methode 'setExpandFilter'
	//===========================================================================================================================================
	private void setExpandFilter() {
		// Expand Width
		while (! this.sorted_lists.expand_widths.containsKey(Integer.parseInt(this.expand_width))) {
			System.out.print("Set New Width \t" + this.sorted_lists.expand_widths.values() + ": ");
			this.expand_width = cons.readLine();
		}
		// Expand Height
		while (! this.sorted_lists.expand_heights.containsKey(Integer.parseInt(this.expand_height))) {
			System.out.print("New Height is \t" + this.sorted_lists.expand_heights.values() + ": ");
			this.expand_height = cons.readLine();
		}
		// Expand Left
		this.expand_left = "0"; // wrong
		// Expand Top
		this.expand_top = "0"; // wrong
	}
	
	
	//===========================================================================================================================================
	// Methode 'setEndPosition'
	//===========================================================================================================================================
	private void setEndPosition() {
		// Some End Positions For Test Mode
		while (! this.sorted_lists.end_positions.containsKey(Integer.parseInt(this.end_pos))) {
			System.out.print("Last Position \t" + this.sorted_lists.end_positions.values() + ": ");
			this.end_pos = cons.readLine();
		}
		// Format Time String
		if (Integer.parseInt(this.end_pos) < 10 ) {
			// End Position < 10 Min.
			this.end_time = "00:0" + this.end_pos + ":00.00";
		} else if (Integer.parseInt(this.end_pos) >= 10 ) {
			// End Position >= 10 Min.
			this.end_time = "00:" + this.end_pos + ":00.00";
		}
	}
	
	
	//===========================================================================================================================================
	// Methode 'setStartStopPosition'
	//===========================================================================================================================================
	private void setStartStopPosition() {
		// Start Time
		while (! this.start_time.matches("[0-9][0-9]:[0-9][0-9]:[0-9][0-9]") && (! this.start_time.isEmpty())) {
			System.out.print("Start Time is \t[(hh:mm:ss)]: ");
			this.start_time = cons.readLine();
		}
		// End Time
		while (! this.end_time.matches("[0-9][0-9]:[0-9][0-9]:[0-9][0-9]") && (! this.end_time.isEmpty())) {
			System.out.print("Last Position \t[(hh:mm:ss)]: ");
			this.end_time = cons.readLine();
		}
	}
	

        //===========================================================================================================================================
        // Methode 'renameFile'
        //===========================================================================================================================================
        private void renameFile(File f, String name, String of) {
                // If File exists
                if (f.exists()) {
                        if (f.isFile()) {
                                try {
                                        Thread.sleep(this.thread_time);
                                        // Rename File
                                        if (f.renameTo(new File(this.wdr + this.fs + name + "." + of))) {
                                                System.out.println("\tFile [" + f.toString() + "] was successfully renamed!");
                                        }
                                } catch (Exception ex) {
                                        System.out.println("\tFile [" + f.toString() + "] wasn't successfully renamed!");
                                        ex.printStackTrace();
                                }
                        } else {
                                System.out.println("\tError! [" + f.toString() + "] is not an ordinary file!");
                        }
                } else {
                        System.out.println("\tFile [" + f.toString() + "] does not exists!");
                }
        }

    
	//===========================================================================================================================================
	// Methode 'deleteFile'
	//===========================================================================================================================================
	private void deleteFile(File f) {
		// If File exists
		if (f.exists()) {
			if (f.isFile()) {
				try {
					Thread.sleep(this.thread_time);
					// Delete File
					f.delete();
					System.out.println("\tFile [" + f.toString() + "] was successfully deleted!");
				} catch (Exception ex) {
					System.out.println("\tFile [" + f.toString() + "] wasn't successfully deleted!");
					ex.printStackTrace();
				}
			} else {
				System.out.println("\tError! [" + f.toString() + "] is not an ordinary file!");
			}
		} else {
			System.out.println("\tFile [" + f.toString() + "] does not exists!");
		}
	}
	
	
	//===========================================================================================================================================
	// Methode 'setAllParms'
	//===========================================================================================================================================
	private void setAllParms() {
		// Set Chaper Parameters
		if (! this.start_chapter.equals(Lists.NULL) && ! this.end_chapter.equals(Lists.NULL)) {
			this.chp_parms = " -chapter " + this.start_chapter + "-" + this.end_chapter;
		}
		// Set OAC Parameters
		this.parms_oac = new Parms_OAC(this.anc, this.abr, this.aq, this.am, this.cbr);
		this.parms_oac.setParms();
		this.oac_parms = this.parms_oac.getParms();
		// Set OVC Parameters
		this.parms_ovc = new Parms_OVC(this.vnc, this.vbr, this.enc_mode, this.container);
		this.parms_ovc.setParms();
		this.ovc_parms1 = this.parms_ovc.getParms()[0];
		this.ovc_parms2 = this.parms_ovc.getParms()[1];
		// Set VF / AF Parameters
		this.parms_vf = new Parms_VF(this.crop_filter, this.crop_width, this.crop_height, this.crop_left, this.crop_top,
				 	     this.scale_filter, this.scale_width, this.scale_height, this.sw_scaler, this.dsize_filter,
					     this.dsize_aspect, this.dsize_width, this.dsize_height, this.aspect_method, this.expand_filter,
                                             this.expand_width, this.expand_height, this.expand_left, this.expand_top);
		// Set Video Filter Parameters
		this.parms_vf.setParms();
		this.vf_parms = " -vf " + this.parms_vf.getParms();
		// Audio Filters
		if (this.audio_filter.equals(Lists.YES)) {
			this.parms_af = new Parms_AF(this.audio_filter, this.resample_rate, this.set_volume, this.audio_volume);
			// Set Audio Filter Parameters
			this.parms_af.setParms();
			// Add Audio Filter Parameters to OAC Parameters
			this.oac_parms = this.oac_parms + this.parms_af.getParms();
		}
		// Set FFourcc_Parameters
		if (this.ffourcc.equals(Lists.YES)) {
			this.ffourcc_parms = " -ffourcc " + this.sorted_lists.vid_ffourcc.get(this.vnc);
		}
		// Set Forceidx_Parameters
		if (this.forceidx.equals(Lists.YES)) {
			this.forceidx_parms = " -forceidx";
		}
                // Set Non-Interleave Parameters
                if (this.non_interleave.equals(Lists.YES)) {
                        this.nilavi_parms = " -ni";
                }
                // Set Specified Container Format Parameters
                switch (this.container) {
                        // AVI Container
                        case Lists.CONT_AVI:
                                this.of = Lists.OF_AVI;
                                this.of_parms = " -of " + this.of;
                                break;
                        // DVD Container
                        case Lists.CONT_DVD:
                                this.of = Lists.OF_MPEG;
                                this.of_parms = " -of " + this.of + " -mpegopts format=dvd:tsaf:muxrate=" + Lists.DVD_MUXRATE + ":vframerate=25:vbitrate=" + this.vbr + " -ofps 25";
                                // Skip AV-Sync Correction
                                if (this.av_sync.equals(Lists.YES)) {
                                        this.mc = " -mc 0 -noskip";
                                }
                                break;
                        // VCD Container 
                        case Lists.CONT_VCD:
                                this.of = Lists.OF_MPEG;
                                this.of_parms = " -of " + this.of + " -mpegopts format=xdvcd:tsaf:muxrate=" + Lists.MP2_MUXRATE + ":vframerate=25:vbitrate=" + this.vbr + " -ofps 25";
                                // Skip AV-Sync Correction
                                if (this.av_sync.equals(Lists.YES)) {
                                        this.mc = " -mc 0 -noskip";
                                }
                                break;
                        // MP4 Container           
                        case Lists.CONT_MP4:
                                this.of = Lists.OF_MP4;
                                this.of_parms = " -of lavf -lavfopts format=" + this.of;
                                break;
                        // Matroska Container           
                        case Lists.CONT_TSK:
                                this.of = Lists.OF_MKV;
                                this.of_parms = " -of lavf -lavfopts format=matroska";
                                break;
                        default:
                                break;
                }
		// Set Temp File
		this.tmp_file = new File(this.wdr + this.fs + this.tmp_string + "." + this.of);
		// Set Dump File (With DVD/VCD Dump)
                if (this.create_dump.equals(Lists.YES)) {
                        this.dmp_file = new File(this.wdr + this.fs + this.dmp_string + "." + Lists.OF_VOB);
                // Set Dump File (With Video Source File)
                } else {
                        // Orignal Video Source File
                        this.dmp_file = new File(this.wdr + this.fs + this.name + "." + this.org_of);
                        // Rename Video Source File
                        this.renameFile(this.dmp_file, this.dmp_string, this.org_of);
                        // ???
                        this.dmp_file = new File(this.wdr + this.fs + this.dmp_string + "." + this.org_of);
                }
		// Set Endposition Parameters
		if (this.test_mode.equals(Lists.YES)) {
			this.end_parms = " -endpos " + this.end_time;
		// Set Start- / EndTime Parameters
		} else if (! this.test_mode.equals(Lists.YES)) {
			if (! this.start_time.isEmpty()) {
				this.start_parms = " -ss " + this.start_time;
			}
			if (! this.end_time.isEmpty()) {
				this.end_parms = " -endpos " + this.end_time;
			}
		}
                // Set Mplayer Execution Parameters
                switch (this.pb_method) {
                        // DVD Playback
                        case Lists.DVD_PLAYBACK:
                                this.os_system0 = this.player + " dvd://" + this.movie_nr + " -dvd-device " + this.dev_dvd + this.chp_parms + " -nocache -dumpstream -dumpfile " + this.dmp_file.toString();
                                break;
                        // DVD Navigation
                        case Lists.DVDNAV_PLAYBACK:
                                this.os_system0 = this.player + " dvdnav://" + this.movie_nr + " -dvd-device " + this.dev_dvd + this.chp_parms + " -nocache -dumpstream -dumpfile " + this.dmp_file.toString();
                                break;
                        // VCD Playback
                        case Lists.VCD_PLAYBACK:
                                this.os_system0 = this.player + " vcd://" + this.movie_nr + " -cdrom-device " + this.dev_dvd + this.chp_parms + " -nocache -dumpstream -dumpfile " + this.dmp_file.toString();
                                break;
                        default:
                                break;
                }
                // Mencoder Pass1
		this.os_system1 = this.encoder + " " + this.dmp_file.toString() + this.start_parms + this.end_parms + this.mc + this.nilavi_parms + " -nosound" + this.vf_parms + " -ovc " + this.ovc_parms1 + this.ffourcc_parms + this.forceidx_parms + this.of_parms + " -o " + this.dev_null;
		// Mencoder Pass2
                this.os_system2 = this.encoder + " " + this.dmp_file.toString() + this.start_parms + this.end_parms + this.mc + this.nilavi_parms + " -vobsubout " + this.sbt_string + " -aid " + this.aid + this.vf_parms + " -oac " + this.oac_parms + " -ovc " + this.ovc_parms2 + this.ffourcc_parms + this.forceidx_parms + this.of_parms + " -o " + this.tmp_file.toString();
	}
	

        //===========================================================================================================================================
	// Methode 'cleanWDR'
	//===========================================================================================================================================
	public void cleanWDR() {
		// Rename Video File
                System.out.println("Video File now renaming ...");
                this.renameFile(this.tmp_file, this.name, this.of);
                // Don't Save Dump File
                if (this.save_dump.equals(Lists.NO)) {
                        // Delete Dump File
                        System.out.println("Dump File now deleting ...");
                        this.deleteFile(this.dmp_file);
                // Save Dump File
                } else if (this.save_dump.equals(Lists.YES)) {
                        // Rename Dump File
                        System.out.println("Dump File now renaming ...");
                this.renameFile(this.dmp_file, this.name, this.org_of);
                }
		// Delete Subidx File
                System.out.println("IDX File now deleting ...");
                this.deleteFile(this.idx_file);
		// Delete Subtitles File
                System.out.println("SUB File now deleting ...");
                this.deleteFile(this.sub_file);
		// Delete Log File
                System.out.println("Log File now deleting ...");
                this.deleteFile(this.log_file);
		// Delete Mbtree File
                System.out.println("MBT File now deleting ...");
                this.deleteFile(this.mbt_file);
	}
	
	
	//===========================================================================================================================================
	// Methode 'execCommands'
	//===========================================================================================================================================
	public void execCommands() throws IOException {
		// Set all Parameters
		this.setAllParms();
		// With DVD Dump
		if (this.create_dump.equals(Lists.YES)) {
			// Execute Mplayer
			System.out.println("===============================================================================================\n");
			System.out.println("DVD Dump require, reading Media...\n");
			System.out.println(this.os_system0 + "\n");
			//
			try {
				Process pr0 = Runtime.getRuntime().exec(this.os_system0, null, this.env.getWDR());
				BufferedReader br0 = new BufferedReader(new InputStreamReader(pr0.getInputStream()));
				String in0;
				while((in0 = br0.readLine()) != null) {
					System.out.println(" Writing DVD to --> \t" + in0);
				}
				// Wait and then Destroy the Processe 
				Thread.sleep(this.thread_time);
				pr0.destroy();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else {
			// Don't Execute Mplayer
			System.out.println("===============================================================================================\n");
			System.out.println("No DVD Dump require, encoding selected Video...\n");
		}
		// Execute Mencoder (Pass 1)
		System.out.println("===============================================================================================\n");
		System.out.println(this.os_system1 + "\n");
		try {
			Process pr1 = Runtime.getRuntime().exec(this.os_system1, null, this.env.getWDR());
			BufferedReader br1 = new BufferedReader(new InputStreamReader(pr1.getInputStream()));
			String in1;
			while((in1 = br1.readLine()) != null) {
				System.out.println(" 1st Pass Encoding --> \t" + in1);
			}
			// Wait and then Destroy the Processe 
			Thread.sleep(this.thread_time);
			pr1.destroy();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// Execute Mencoder (Pass 2)
		System.out.println("===============================================================================================\n");
		System.out.println(this.os_system2 + "\n");
		try {
			Process pr2 = Runtime.getRuntime().exec(this.os_system2, null, this.env.getWDR());
			BufferedReader br2 = new BufferedReader(new InputStreamReader(pr2.getInputStream()));
			String in2;
			while((in2 = br2.readLine()) != null) {
				System.out.println(" 2nd Pass Encoding --> \t" + in2);
			}
			// Wait and then Destroy the Processe 
			Thread.sleep(this.thread_time);
			pr2.destroy();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// Clean Working Directory
		System.out.println("===============================================================================================\n");
		this.cleanWDR();
	}
}
/*
 * End Movie2Video.java
 */
