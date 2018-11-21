/*
 * Parms_OAC.java
 * @author Frank Hildesheim, Leipzig 2013, 2014, 2015, 2016, 2017, 2018 (c), <FrankHildesheim@mail.ru>
 * Last change: 2018 Oct 29
 * ==================================================================================================================================================
 */


//===================================================================================================================================================
// Klase 'Parms_OAC'
//===================================================================================================================================================
public class Parms_OAC {
	// Audio Encoder
	private final String 	anc;									// Audio Encoder
	private final String 	abr;									// Audio Bitrate
	private final String	aq;									// Audio Quality
	private final String	am;									// Audio Mode
	private final String	cbr;									// Constant Bitrate (y/n)
	// OAC Parameters
	private String 	oac_parms;                                                                      // OAC Parameters
	 
	
	//===========================================================================================================================================
	// Konstruktor
	//===========================================================================================================================================
	public Parms_OAC(String anc, String abr, String aq, String am, String cbr) {
		//
		this.anc    = anc;
		this.abr    = abr;
		this.aq     = aq;
		this.am     = am;
		this.cbr    = cbr;
                //
                this.oac_parms  = "";
	}
	
	
	//===========================================================================================================================================
	// Methode 'setParms'
	//===========================================================================================================================================
	public void setParms() {
            // AC3
            switch (this.anc) {
                case Lists.ANC_AC3:
                    this.oac_parms = "lavc -lavcopts acodec=ac3:abitrate=" + this.abr + " -channels 6";
                    // AAC
                    break;
                case Lists.ANC_AAC:
                    //this.oac_parms = "faac -faacopts mpeg=4:object=2:br=" + this.abr + ":raw:tns -channels 2";
                    this.oac_parms = "lavc -lavcopts acodec=libfaac:abitrate=" + this.abr + " -channels 2";
                    // FLAC
                    break;
                case Lists.ANC_FLC:
                    this.oac_parms = "lavc -lavcopts acodec=flac:abitrate=" + this.abr + " -channels 2";
                    // MP3
                    break;
                case Lists.ANC_MP3:
                    // Constant Bitrate
                    if (this.cbr.equals(Lists.YES)) {
                // Dualchannel Audio Mode
                switch (this.am) {
                    case Lists.AM_DUAL:
                        this.oac_parms = "mp3lame -lameopts cbr:br=" + this.abr + ":aq=" + this.aq + ":mode=2 -channels 2";
                        // Joint-Stereo Audio Mode
                        break;
                // Average Bitrate
                    case Lists.AM_JOINT:
                        this.oac_parms = "mp3lame -lameopts cbr:br=" + this.abr + ":aq=" + this.aq + ":mode=1 -channels 2";
                        // Mono Audio Mode
                        break;
                    case Lists.AM_MONO:
                        this.oac_parms = "mp3lame -lameopts cbr:br=" + this.abr + ":aq=" + this.aq + ":mode=3 -channels 1";
                        // Stereo Audio Mode
                        break;
                    case Lists.AM_STEREO:
                        this.oac_parms = "mp3lame -lameopts cbr:br=" + this.abr + ":aq=" + this.aq + ":mode=0 -channels 2";
                        break;
                    default:
                        break;
                }
                    } else if (! this.cbr.equals(Lists.YES)) {
                // Dualchannel Audio Mode
                switch (this.am) {
                    case Lists.AM_DUAL:
                        this.oac_parms = "mp3lame -lameopts abr:br=" + this.abr + ":aq=" + this.aq + ":mode=2 -channels 2";
                        // Joint-Stereo Audio Mode
                        break;
                    case Lists.AM_JOINT:
                        this.oac_parms = "mp3lame -lameopts abr:br=" + this.abr + ":aq=" + this.aq + ":mode=1 -channels 2";
                        // Mono Audio Mode
                        break;
                    case Lists.AM_MONO:
                        this.oac_parms = "mp3lame -lameopts abr:br=" + this.abr + ":aq=" + this.aq + ":mode=3 -channels 1";
                        // Stereo Audio Mode
                        break;
                    case Lists.AM_STEREO:
                        this.oac_parms = "mp3lame -lameopts abr:br=" + this.abr + ":aq=" + this.aq + ":mode=0 -channels 2";
                        break;
                    default:
                        break;
                }
                    }
                    // MP2
                    break;
                case Lists.ANC_TWO:
            // Dualchannel Audio Mode
            switch (this.am) {
                case Lists.AM_DUAL:
                    this.oac_parms = "twolame -twolameopts vbr=0:br=" + this.abr + ":mode=dual -channels 2";
                    // Joint-Stereo Audio Mode
                    break;
                case Lists.AM_JOINT:
                    this.oac_parms = "twolame -twolameopts vbr=0:br=" + this.abr + ":mode=jstereo -channels 2";
                    // Mono Audio Mode
                    break;
                case Lists.AM_MONO:
                    this.oac_parms = "twolame -twolameopts vbr=0:br=" + this.abr + ":mode=mono -channels 1";
                    // Stereo Audio Mode
                    break;
                case Lists.AM_STEREO:
                    this.oac_parms = "twolame -twolameopts vbr=0:br=" + this.abr + ":mode=stereo -channels 2";
                    break;
                default:
                    break;
            }
                    // COPY
                    break;
                case Lists.ANC_COP:
                    this.oac_parms = "copy ";
                    break;
                default:
                    break;
            }
	}
	
	
	//===========================================================================================================================================
	// Methode 'getParms'
	//===========================================================================================================================================
	public String getParms() {
		// return Parms
		return (this.oac_parms);
	}
}
/*
 * End Parms_OAC.java
 */
