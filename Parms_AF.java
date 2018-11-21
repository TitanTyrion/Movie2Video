/*
 * Parms_AF.java
 * @author Frank Hildesheim, Leipzig 2013, 2014, 2015, 2016, 2017, 2018 (c), <FrankHildesheim@mail.ru>
 * Last change: 2018 Oct 29
 * ==================================================================================================================================================
 */

//===================================================================================================================================================
// Klasse 'Parms_AF'
//===================================================================================================================================================
public class Parms_AF {
	// Audio Filter
	private final String    audio_filter;								// Audio Filter (y/n)
	private final String    resample_rate;								// Resample (Sample Rate Typ)
	private final String	set_volume;								// Change Audio Volume
	private final String	audio_volume;								// Audio Volume (dB)
        // Misc Parameters
	private String	vol_parms;									// Audio Volume Parameters
	private String  af_parms;									// Audio Parameters
	
	
	//===========================================================================================================================================
	// Konstruktor
	//===========================================================================================================================================
	public Parms_AF(String audio_filter, String resample_rate, String set_volume, String audio_volume) {
		this.audio_filter   = audio_filter;
		this.resample_rate  = resample_rate;
		this.set_volume     = set_volume;
		this.audio_volume   = audio_volume;
                //
                this.vol_parms      = "";
                this.af_parms       = "";
	}
	
	
	//===========================================================================================================================================
	// Methode 'setParms'
	//===========================================================================================================================================
	public void setParms() {
		// With Audio Filter
		if (this.audio_filter.equals(Lists.YES)) {
			// Set Volume Parms
			this.setVolume();
                    // Resample to high Rate
                    switch (this.resample_rate) {
                        case Lists.HIGH_RESAMPLE:
                            //
                            this.af_parms = " -srate " + Lists.HIGH_SRATE + this.vol_parms;
                            // Resample to normal Rate
                            break;
                        case Lists.NORM_RESAMPLE:
                            //
                            this.af_parms = " -srate " + Lists.NORM_SRATE + this.vol_parms;
                            // Resample to low Rate
                            break;
                        case Lists.LOW_RESAMPLE:
                            //
                            this.af_parms = " -srate " + Lists.LOW_SRATE + this.vol_parms;
                            break;
                        default:
                            break;
                    }
		}
	}
	
	
	//===========================================================================================================================================
	// Methode 'setVolume'
	//===========================================================================================================================================
	private void setVolume() {
		if (this.set_volume.equals(Lists.YES)) {
			this.vol_parms = " -af volume=" + this.audio_volume + ":0";
		} else {
			this.vol_parms = "";
		}
	}
	
	
	//===========================================================================================================================================
	// Methode 'getParms'
	//===========================================================================================================================================
	public String getParms() {
		// Return Parms
		return (af_parms);
	}
}
/*
 * End Parms_AF.java
 */
