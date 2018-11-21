/*
 * Lists.java
 * @author Frank Hildesheim, Leipzig 2013, 2014, 2015, 2016, 2017, 2018 (c), <FrankHildesheim@mail.ru>
 * Last change: 2018 Oct 29
 * ==================================================================================================================================================
 */

//===================================================================================================================================================
// Klasse 'Lists'
//===================================================================================================================================================
public class Lists {
	//String Keys
	public SortedStringList		question;                                                       // Standard Question (Yes / NO)
	public SortedStringList		pb_methods;                                                     // Playback Methods (DVD / DVDNAV / VCD)
	public SortedStringList  	containers;                                                     // Video Containers (AVI / MP4 / DVD / MPEG2 / MSK)
	public SortedStringList  	vid_encoders;                                                   // Video Encoders (DivX, H264, MP2, Xvid)
	public SortedStringList  	vid_ffourcc;                                                    // Fource some Video ... 
	public SortedStringList  	enc_modes;                                                      // Encoding Modes (Fast, Medium, Slow)
	public SortedStringList  	audio_encoders;                                                 // Audio Encoders (AC3, Faac, Flac, MP2, MP3)
	public SortedStringList		audio_modes;                                                    // Audio Modes (Stereo, Joint-Stereo, Dualchannel, Mono)
	public SortedStringList		resample_rates;                                                 // Resample Rates
	public SortedStringList		video_formats;                                                  // Video Formats (VCD, SVCD, VGA, DVD, HDTV, FullHD)
	public SortedStringList  	scale_heights;                                                  // Scaling Values (Height)
	public SortedStringList  	sw_scalers;                                                     // Software Scalers
	public SortedStringList		dsize_heights;                                                  // Dsizing Values (Height)
	public SortedStringList  	dsize_aspects;                                                  // Dsize Aspects (Display Size|Aspect)
	public SortedStringList  	aspect_methods;                                                 // Aspect Methods
	// Integer Keys
	public SortedIntegerList 	chapters;                                                       // DVD Chapters
	public SortedIntegerList 	audio_ids_dvd;                                                  // Audio IDs DVD
	public SortedIntegerList 	audio_ids_vid;                                                  // Audio IDs Video
	public SortedIntegerList 	vid_bitrates;                                                   // Video Encoding Bitrates
	public SortedIntegerList 	audio_bitrates;                                                 // Audio Encoding Bitrates
	public SortedIntegerList 	audio_qualities;                                                // MP3 Audio Qualities
	public SortedIntegerList 	audio_volumes;                                                  // Audio Volumes
	public SortedIntegerList	movie_widths;                                                   // Movie Widths
	public SortedIntegerList	movie_heights;                                                  // Movie Heights
	public SortedIntegerList 	crop_widths;                                                    // Cropping Values (Width)
	public SortedIntegerList 	crop_heights;                                                   // Cropping Values (Height)
	public SortedIntegerList 	scale_widths;                                                   // Scaling Values (Width)
	public SortedIntegerList 	dsize_widths;                                                   // Dsizing Values (Width)
	public SortedIntegerList 	expand_widths;                                                  // Expanding Values (Width)
	public SortedIntegerList 	expand_heights;                                                 // Expanding Values (Height)
	public SortedIntegerList 	end_positions;                                                  // Endpositions (Min)
	// Playback Methods
	public static final String      DVD_PLAYBACK 	= "d";                                          // DVD Playback
	public static final String      DVDNAV_PLAYBACK = "n";                                          // DVD-Nav. Playback
	public static final String      VCD_PLAYBACK 	= "v";                                          // VCD Playback
	// Digits
	public static final String      MINUS_TEN 	= "-10";                                        // String Minus Ten
	public static final String      MINUS_ONE 	= "-1";                                         // String Minus One
	public static final String      NULL            = "0";                                          // String Null
	public static final String      ONE             = "1";                                          // String One
	public static final String      TEN             = "10";                                         // String Ten
	// Device Resolutions
	public static final String      IPOD_WIDTH 	= "320";                                        // iPod Width
	public static final String      IPOD_HEIGHT 	= "240";                                        // iPod Height
	public static final String      VCD_WIDTH 	= "352";                                        // VCD Width
	public static final String      VCD_HEIGHT 	= "288";                                        // VCD Height
	public static final String      SVCD_WIDTH 	= "480";                                        // SVCD WIDTH
	public static final String      SVCD_HEIGHT 	= "576";                                        // SVCD Height
	public static final String      DVD_WIDTH 	= "720";                                        // PAL DVD Width
	public static final String      DVD_HEIGHT 	= "576";                                        // PAL DVD Height
	public static final String      XGA_WIDTH 	= "1024";                                       // XGA Width
	public static final String      XGA_HEIGHT 	= "768";                                        // XGA Height
	public static final String      HDTV_WIDTH 	= "1280";                                       // HDTV Width
	public static final String      HDTV_HEIGHT 	= "720";                                        // HDTV Height
	public static final String      FHD_WIDTH 	= "1920";                                       // Full HD Width
	public static final String      FHD_HEIGHT 	= "1080";                                       // Full HD Height
	// Misc Rates
	public static final String      DVD_MUXRATE 	= "15000";                                      // Muxrate for DVD Container
	public static final String      MP2_MUXRATE 	= "2500";                                       // Muxrate for MP2 Container
	public static final String      DVD_VRC_MAXRATE = "9800";                                       // VRC Maxrate for DVD Container
	public static final String      MP2_VRC_MAXRATE = "5000";                                       // VRC Maxrate for MP2 Container
	public static final String      DVD_VRC_BUFSIZE = "1835";                                       // VRC Buffer Size for DVD Container
	public static final String      MP2_VRC_BUFSIZE = "917";                                        // VRC Buffer Size for MP2 Container
	public static final String      HIGH_SRATE 	= "48000";                                      // High Audio Sample Rate (Hz)
	public static final String      NORM_SRATE 	= "44100";                                      // Normal Audio Sample Rate (Hz)
	public static final String      LOW_SRATE 	= "22050";                                      // LOW Audio Sample Rate (Hz)
	// Output Formats
	public static final String      OF_3GP          = "3gp";                                        // 3GP Format
	public static final String      OF_AVI          = "avi";                                        // AVI Format
	public static final String      OF_FLV          = "flv";                                        // FLV Format
	public static final String      OF_MOV          = "mov";                                        // MOV Format
	public static final String      OF_MPG          = "mpg";                                        // MPG Format
	public static final String      OF_MPEG         = "mpeg";                                       // MPEG Format
	public static final String      OF_MP2          = "mp2";                                        // MP2 Format
	public static final String      OF_MP4          = "mp4";                                        // MP4 Format
	public static final String      OF_MKV          = "mkv";                                        // MKV Format
	public static final String      OF_VOB          = "vob";                                        // VOB Format
	public static final String      OF_WEBM         = "webm";                                       // WEBM Format
	// Video Containers
	public static final String      CONT_AVI        = "a";                                          // AVI Container
	public static final String      CONT_DVD        = "d";                                          // DVD Container
	public static final String      CONT_FLV        = "f";                                          // Flash Container
	public static final String      CONT_MP4        = "m";                                          // MP4 Container
	public static final String      CONT_VCD        = "v";                                          // MP2 Container
	public static final String      CONT_TSK        = "t";                                          // Matroska Container
	// Video Encoders
	public static final String      VNC_DIVX        = "d";                                          // DivX Encoder
	public static final String      VNC_H264        = "h";                                          // H264 / X264 Encoder
	public static final String      VNC_MPG2        = "m";                                          // Mpeg2 Encoder
	public static final String      VNC_THEO        = "t";                                          // Theora Encoder
	public static final String      VNC_XVID        = "x";                                          // Xvid Encoder
	// Video Formats
	public static final String      VFM_DVD		= "d";                                          // DVD Format
	public static final String      VFM_FHD		= "f";                                          // Full HD Format
	public static final String      VFM_HDTV	= "h";                                          // HD ready Format
	public static final String      VFM_IPOD	= "i";                                          // iPod Format
	public static final String      VFM_SVCD	= "s";                                          // SVCD Format
	public static final String      VFM_VCD		= "v";                                          // VCD Format
	public static final String      VFM_XGA		= "x";                                          // XGA Format
	// Encoding Method
	public static final String      EM_FAST         = "f";                                          // Fast Encoding Mode
	public static final String      EM_NORM         = "n";                                          // Normal Encoding Mode
	public static final String      EM_SLOW         = "s";                                          // Slow Encoding Mode
	// Audio Encoders
	public static final String      ANC_AC3         = "3";                                          // AC3 Encoder
	public static final String      ANC_AAC         = "a";                                          // ACC Encoder
	public static final String      ANC_COP         = "c";                                          // Copy only
	public static final String      ANC_FLC         = "f";                                          // Flac Encoder
	public static final String      ANC_MP3         = "m";                                          // MP3 Encoder
	public static final String      ANC_TWO         = "t";                                          // Mpeg2 Encoder
	// MP3 Audio Modes
	public static final String      AM_JOINT        = "j";                                          // Joint-Stereo Audio Mode
	public static final String      AM_DUAL         = "d";                                          // Dualchannel Audio Mode
	public static final String      AM_MONO         = "m";                                          // Mono Audio Mode
	public static final String      AM_STEREO       = "s";                                          // Stereo Audio Mode
	// Resample Rates
	public static final String      HIGH_RESAMPLE   = "h";                                          // High Resample Rate (48000Hz)
	public static final String      LOW_RESAMPLE    = "l";                                          // Low Resample Rate (22050Hz)
	public static final String      NORM_RESAMPLE   = "n";                                          // Normal Resample Rate (44100Hz)
	// Software Scaler
	public static final String      SWS_BICUBIC 	= "b";                                          // Bicubic Software Scaler
	public static final String      SWS_FAST_BILINEAR = "f";                                        // Fast Bilinear Software Scaler
	public static final String      SWS_GAUSS 	= "g";                                          // Gauss Software Scaler
	public static final String      SWS_LANCZOS 	= "l";                                          // Lanczos Software Scaler
	// Question
	public static final String      YES             = "y";                                          // Answer Yes
	public static final String      NO              = "n";                                          // Answer No
	
	
	//===========================================================================================================================================
	// Konstruktor
	//===========================================================================================================================================
	public Lists() {
		// Standard Question
		this.question = new SortedStringList();
		this.question.put(YES, "(Y)es");
		this.question.put(NO,  "(N)o");
		// Playback Methods
		this.pb_methods = new SortedStringList();
		this.pb_methods.put(DVD_PLAYBACK,    "(D)VD");
		this.pb_methods.put(DVDNAV_PLAYBACK, "(N)AV");
		this.pb_methods.put(VCD_PLAYBACK,    "(V)CD");
		// Chapters
		this.chapters = new SortedIntegerList();
		this.chapters.put(0,   "(0)");
		this.chapters.put(1,   "(1)");
		this.chapters.put(2,   "(2)");
		this.chapters.put(3,   "(3)");
		this.chapters.put(4,   "(4)");
		this.chapters.put(5,   "(5)");
		this.chapters.put(6,   "(6)");
		this.chapters.put(7,   "(7)");
		this.chapters.put(8,   "(8)");
		this.chapters.put(9,   "(9)");
		this.chapters.put(10,  "(10)");
		this.chapters.put(11,  "(11)");
		this.chapters.put(12,  "(12)");
		this.chapters.put(13,  "(13)");
		this.chapters.put(14,  "(14)");
		this.chapters.put(15,  "(15)");
		this.chapters.put(16,  "(16)");
		this.chapters.put(17,  "(17)");
		this.chapters.put(18,  "(18)");
		this.chapters.put(19,  "(19)");
		this.chapters.put(20,  "(20)");
		this.chapters.put(21,  "(21)");
		this.chapters.put(22,  "(22)");
		this.chapters.put(23,  "(23)");
		this.chapters.put(24,  "(24)");
		this.chapters.put(25,  "(25)");
		// Audio IDs DVD
		this.audio_ids_dvd = new SortedIntegerList();
		this.audio_ids_dvd.put(128, "(128)");
		this.audio_ids_dvd.put(129, "(129)");
		this.audio_ids_dvd.put(130, "(130)");
		this.audio_ids_dvd.put(131, "(131)");
		this.audio_ids_dvd.put(132, "(132)");
		this.audio_ids_dvd.put(133, "(133)");
		// Audio IDs Video
		this.audio_ids_vid = new SortedIntegerList();
		this.audio_ids_vid.put(0, "(0)");
		this.audio_ids_vid.put(1, "(1)");
		this.audio_ids_vid.put(2, "(2)");
		this.audio_ids_vid.put(3, "(3)");
		this.audio_ids_vid.put(4, "(4)");
		this.audio_ids_vid.put(5, "(5)");
		// Containers
		this.containers = new SortedStringList();
		this.containers.put(CONT_AVI, "(A)VI");
		this.containers.put(CONT_DVD, "(D)VD");
		this.containers.put(CONT_FLV, "(F)LV");
		this.containers.put(CONT_MP4, "(M)P4");
		this.containers.put(CONT_TSK, "(T)SK");
		this.containers.put(CONT_VCD, "(V)CD");
		// Video Encoders
		this.vid_encoders = new SortedStringList();
		this.vid_encoders.put(VNC_DIVX, "(D)ivX");
		this.vid_encoders.put(VNC_H264, "(H)264");
		this.vid_encoders.put(VNC_MPG2, "(M)peg2");
		this.vid_encoders.put(VNC_THEO, "(T)heo");
		this.vid_encoders.put(VNC_XVID, "(X)vid");
		// Video Bitrates
		this.vid_bitrates = new SortedIntegerList();
		this.vid_bitrates.put(250,   "(250)");
		this.vid_bitrates.put(500,   "(500)");
		this.vid_bitrates.put(750,   "(750)");
		this.vid_bitrates.put(1000,  "(1000)");
		this.vid_bitrates.put(1250,  "(1250)");
		this.vid_bitrates.put(1500,  "(1500)");
		this.vid_bitrates.put(2000,  "(2000)");
		this.vid_bitrates.put(2500,  "(2500)");
		this.vid_bitrates.put(3000,  "(3000)");
		this.vid_bitrates.put(3500,  "(3500)");
		this.vid_bitrates.put(5000,  "(5000)");
		this.vid_bitrates.put(7500,  "(7500)");
		// FFourcc Strings
		this.vid_ffourcc = new SortedStringList();
		this.vid_ffourcc.put(VNC_DIVX, "DX50");
		this.vid_ffourcc.put(VNC_H264, "H264");
		this.vid_ffourcc.put(VNC_XVID, "XVID");
		// Encoding Modes
		this.enc_modes = new SortedStringList();
		this.enc_modes.put(EM_FAST, "(F)ast");
		this.enc_modes.put(EM_NORM, "(N)ormal");
		this.enc_modes.put(EM_SLOW, "(S)low");
		// Audio Encoders
		this.audio_encoders = new SortedStringList();
		this.audio_encoders.put(ANC_AC3, "AC(3)");
		this.audio_encoders.put(ANC_AAC, "(A)AC");
		this.audio_encoders.put(ANC_COP, "(C)OPY");
		this.audio_encoders.put(ANC_FLC, "(F)LAC");
		this.audio_encoders.put(ANC_MP3, "(M)P3");
		this.audio_encoders.put(ANC_TWO, "(T)WO");
		// Audio Bitrates
		this.audio_bitrates = new SortedIntegerList();
		this.audio_bitrates.put(64,  "(64)");
		this.audio_bitrates.put(96,  "(96)");
		this.audio_bitrates.put(128, "(128)");
		this.audio_bitrates.put(192, "(192)");
		this.audio_bitrates.put(224, "(224)");
		this.audio_bitrates.put(256, "(256)");
		this.audio_bitrates.put(320, "(320)");
		this.audio_bitrates.put(384, "(384)");
		this.audio_bitrates.put(448, "(448)");
		// Audio Qualities
		this.audio_qualities = new SortedIntegerList();
		this.audio_qualities.put(0, "(0)");
		this.audio_qualities.put(2, "(2)");
		this.audio_qualities.put(4, "(4)");
		this.audio_qualities.put(6, "(6)");
		this.audio_qualities.put(8, "(8)");
		// Audio Volumes
		this.audio_volumes = new SortedIntegerList();
		this.audio_volumes.put(0,   "(0)dB");
		this.audio_volumes.put(1,   "(1)dB");
		this.audio_volumes.put(5,   "(5)dB");
		this.audio_volumes.put(10,  "(10)dB");
		this.audio_volumes.put(15,  "(15)dB");
		this.audio_volumes.put(20,  "(20)dB");
		// MP3 Audio Modes
		this.audio_modes = new SortedStringList();
		this.audio_modes.put(AM_DUAL,   "(D)ualchannel");
		this.audio_modes.put(AM_JOINT,  "(J)oint-Stereo");
		this.audio_modes.put(AM_MONO,   "(M)ono");
		this.audio_modes.put(AM_STEREO, "(S)tereo");
		// Resampling Rates
		this.resample_rates = new SortedStringList();
		this.resample_rates.put(HIGH_RESAMPLE, "(H)igh");
		this.resample_rates.put(LOW_RESAMPLE,  "(L)ow");
		this.resample_rates.put(NORM_RESAMPLE, "(N)ormal");
		// Movie Widths
		this.movie_widths = new SortedIntegerList();
		this.movie_widths.put(640, 	"(640)");
		this.movie_widths.put(720, 	"(720)");
		this.movie_widths.put(800, 	"(800)");
		this.movie_widths.put(1024,     "(1024)");
		this.movie_widths.put(1280,     "(1280)");
		this.movie_widths.put(1920,     "(1920)");
		// Movie Heights
		this.movie_heights = new SortedIntegerList();
		this.movie_heights.put(480,     "(480)");
		this.movie_heights.put(576,     "(576)");
		this.movie_heights.put(688, 	"(688)");
		this.movie_heights.put(720, 	"(720)");
		this.movie_heights.put(736, 	"(736)");
		this.movie_heights.put(768, 	"(768)");
		this.movie_heights.put(800, 	"(800)");
		this.movie_heights.put(816, 	"(816)");
		this.movie_heights.put(1080, 	"(1080)");
		this.movie_heights.put(1200, 	"(1200)");
		// Crop Widths
		this.crop_widths = new SortedIntegerList();
                this.crop_widths.put(560, 	"(560)");
		this.crop_widths.put(640, 	"(640)");
		this.crop_widths.put(656, 	"(656)");
		this.crop_widths.put(672, 	"(672)");
		this.crop_widths.put(688, 	"(688)");
		this.crop_widths.put(704, 	"(704)");
		this.crop_widths.put(720, 	"(720)");
		this.crop_widths.put(1024, 	"(1024)");
		this.crop_widths.put(1280, 	"(1280)");
		this.crop_widths.put(1920, 	"(1920)");
		// Crop Heights
		this.crop_heights = new SortedIntegerList();
		this.crop_heights.put(240, 	"(240)");
		this.crop_heights.put(288, 	"(288)");
		this.crop_heights.put(384, 	"(384)");
		this.crop_heights.put(400, 	"(400)");
		this.crop_heights.put(416, 	"(416)");
		this.crop_heights.put(432, 	"(432)");
		this.crop_heights.put(448, 	"(448)");
		this.crop_heights.put(480, 	"(480)");
		this.crop_heights.put(528, 	"(528)");
		this.crop_heights.put(544, 	"(544)");
		this.crop_heights.put(560, 	"(560)");
		this.crop_heights.put(576, 	"(576)");
		this.crop_heights.put(688, 	"(688)");
		this.crop_heights.put(720, 	"(720)");
		this.crop_heights.put(736, 	"(736)");
		this.crop_heights.put(800, 	"(800)");
		this.crop_heights.put(816, 	"(816)");
		this.crop_heights.put(1024,     "(1024)");
		this.crop_heights.put(1080,     "(1080)");
		this.crop_heights.put(1280,     "(1280)");
		// Video Formats
		this.video_formats = new SortedStringList();
		this.video_formats.put(VFM_DVD,     "(D)VD");
		this.video_formats.put(VFM_FHD,     "(F)HD");
		this.video_formats.put(VFM_HDTV,    "(H)DTV");
		this.video_formats.put(VFM_IPOD,    "(i)Pod");
		this.video_formats.put(VFM_SVCD,    "(S)VCD");
		this.video_formats.put(VFM_VCD,     "(V)CD");
		this.video_formats.put(VFM_XGA,     "(X)GA");
		// Scale Widths
		this.scale_widths = new SortedIntegerList();
		this.scale_widths.put(320,          "(320) iPod");
		this.scale_widths.put(352,          "(352) VCD");
		this.scale_widths.put(480,          "(480) SVCD");
		this.scale_widths.put(640,          "(640) VGA");
		this.scale_widths.put(720,          "(720) DVD");
		this.scale_widths.put(800,          "(800) SVGA");
		this.scale_widths.put(1024,         "(1024) XGA");
		this.scale_widths.put(1280,         "(1280) HDTV");
		// Scale Heights
		this.scale_heights = new SortedStringList();
		this.scale_heights.put("-1",        "(-1) org. Movie Width");
		this.scale_heights.put("-2",        "(-2) pre. Aspect Ratio");
		this.scale_heights.put("-3",        "(-3) org. Aspect Ratio");
		// Software Scalers
		this.sw_scalers = new SortedStringList();
		this.sw_scalers.put(SWS_BICUBIC,        "(B)icubic");
		this.sw_scalers.put(SWS_FAST_BILINEAR, 	"(F)ast Bilinear");
		this.sw_scalers.put(SWS_GAUSS,          "(G)auss");
		this.sw_scalers.put(SWS_LANCZOS,        "(L)anczos");
		// Dsize Widths
		this.dsize_widths = new SortedIntegerList();
		this.dsize_widths.put(240, "(240)");
		this.dsize_widths.put(320, "(320)");
		this.dsize_widths.put(352, "(352)");
		this.dsize_widths.put(480, "(480)");
		this.dsize_widths.put(512, "(512)");
		this.dsize_widths.put(640, "(640)");
		this.dsize_widths.put(704, "(704)");
		this.dsize_widths.put(720, "(720)");
		this.dsize_widths.put(800, "(800)");
		// Dsize Heights
		this.dsize_heights = new SortedStringList();
		this.dsize_heights.put("0",  "(0) 	org. Display Width");
		this.dsize_heights.put("-1", "(-1) 	org. Video Width");
		this.dsize_heights.put("-2", "(-2) 	org. Display Aspect Ratio");
		this.dsize_heights.put("-3", "(-3) 	org. Video Aspect Ratio");
		// Dsize Aspects
		this.dsize_aspects = new SortedStringList();
		this.dsize_aspects.put("0", 	"(0)");
		this.dsize_aspects.put("1.33", 	"(1.33)");
		this.dsize_aspects.put("1.78", 	"(1.78)");
		this.dsize_aspects.put("1.85", 	"(1.85)");
		this.dsize_aspects.put("2.40", 	"(2.40)");
		// Aspect Methods
		this.aspect_methods = new SortedStringList();
		this.aspect_methods.put("-1", "(-1) Ignore org.ASR");
		this.aspect_methods.put("0",  "(0) max.D-ASR");
		this.aspect_methods.put("1",  "(1) min.D-ASR");
		this.aspect_methods.put("2",  "(2) max.V-ASR");
		this.aspect_methods.put("3",  "(3) min.V-ASR");
		// Expand Widths
		this.expand_widths = new SortedIntegerList();
		this.expand_widths.put(480, "(480)");
		this.expand_widths.put(704, "(704)");
		this.expand_widths.put(720, "(720)");
		// Expand Heights
		this.expand_heights = new SortedIntegerList();
		this.expand_heights.put(352, "(352)");
		this.expand_heights.put(400, "(400)");
		this.expand_heights.put(480, "(480)");
		this.expand_heights.put(576, "(576)");
		// Endpositions
		this.end_positions = new SortedIntegerList();
		this.end_positions.put(1,  "(1) Min");
		this.end_positions.put(2,  "(2) Min");
		this.end_positions.put(5,  "(5) Min");
		this.end_positions.put(10, "(10) Min");
		this.end_positions.put(15, "(15) Min");
		this.end_positions.put(20, "(20) Min");
		this.end_positions.put(30, "(30) Min");
	}
}
/*
 * End Lists.java
 */ 
