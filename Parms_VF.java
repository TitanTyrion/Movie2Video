/*
 * Parms_VF.java
 * @author Frank Hildesheim, Leipzig 2013, 2014, 2015, 2016, 2017, 2018 (c), <FrankHildesheim@msn.com>
 * Last change: 2018 Oct 29
 * ==================================================================================================================================================
 */

//===================================================================================================================================================
// Klasse 'Parms_VF'
//===================================================================================================================================================
public class Parms_VF {
	// Crop Filter
	private final String 	crop_filter;                                                            // Crop Filter (y/n)
	private final String 	crop_width;                                                             // Crop Width
	private final String	crop_height;                                                            // Crop Height
	private final String 	crop_left;                                                              // Crop Left Mark
	private final String	crop_top;                                                               // Crop Top Mark
	// Scale Filter
	private final String	scale_filter;                                                           // Scale Filter (y/n)
	private final String 	scale_width;                                                            // Scale Width
	private final String 	scale_height;                                                           // Scale Height
	// Software Scaler
	private final String 	sw_scaler;                                                              // Software Scaler
	// Dsize Filter
	private final String	dsize_filter;                                                           // Dsize Filter (y/n)
	private final String	dsize_aspect;                                                           // Dsize Aspect
	private final String 	dsize_width;                                                            // Dsize Width
	private final String	dsize_height;                                                           // Dsize Height
	private final String 	aspect_method;                                                          // Dsize Ratio
	// Expand Filter
	private final String	expand_filter;                                                          // Expand Filter (y/n)
	private final String	expand_width;                                                           // Expand Width
	private final String	expand_height;                                                          // Expand Height
	private final String	expand_left;                                                            // Expand Left Mark
	private final String	expand_top;                                                             // Expand Top Mark
	// Misc Parameters
	private final String 	crop_parms;                                                             // Crop Parameters
	private final String	scale_parms;                                                            // Scale Parameters
	private final String	dsize_parms;                                                            // Dsize Parameters
	private final String	expand_parms;                                                           // Expand Parameters
        // Misc Parameters
        private String 	sws_parms;                                                                      // Software Scaler Parameters
	private String	vf_parms;                                                                       // Video Filter Parameters
	
	
	//===========================================================================================================================================
	// Konstruktor
	//===========================================================================================================================================
	public Parms_VF(String crop_filter, String crop_width, String crop_height, String crop_left, String crop_top, String scale_filter, 
			String scale_width, String scale_height, String sw_scaler, String dsize_filter, String dsize_aspect, String dsize_width, 
			String dsize_height, String aspect_method, String expand_filter, String expand_width, String expand_height,
			String expand_left, String expand_top) {
		//
		this.crop_filter    = crop_filter;
		this.crop_width     = crop_width;
		this.crop_height    = crop_height;
		this.crop_left      = crop_left;
		this.crop_top       = crop_top;
		this.scale_filter   = scale_filter;
		this.scale_width    = scale_width;
		this.scale_height   = scale_height;
		this.sw_scaler      = sw_scaler;
		this.dsize_filter   = dsize_filter;
		this.dsize_aspect   = dsize_aspect;
		this.dsize_width    = dsize_width;
		this.dsize_height   = dsize_height;
		this.aspect_method  = aspect_method;
		this.expand_filter  = expand_filter;
		this.expand_width   = expand_width;
		this.expand_height  = expand_height;
		this.expand_left    = expand_left;
		this.expand_top     = expand_top;
                //
                this.sws_parms      = "";
                this.vf_parms       = "";
		// Initialize Parameter Strings
		this.crop_parms = "crop=" + this.crop_width + ":" + this.crop_height + ":" + this.crop_left + ":" + this.crop_top;
		this.scale_parms = "scale=" + this.scale_width + ":" + this.scale_height;
                //
		if (this.dsize_aspect.equals(Lists.NULL)) {
			this.dsize_parms = "dsize=" + this.dsize_width + ":" + this.dsize_height + ":" + this.aspect_method;
		} else {
			this.dsize_parms = "dsize=" + this.dsize_aspect;
		}
		this.expand_parms = "expand=" + this.expand_width + ":" + this.expand_height + ":" + this.expand_left + ":" + this.expand_top;
	}
	
	
	//===========================================================================================================================================
	// Methode 'setParms'
	//===========================================================================================================================================
	public void setParms() {
		// Crop
		if (this.crop_filter.equals(Lists.YES)) {
			// Scale
			if (this.scale_filter.equals(Lists.YES)) {
				// Set SWS Parms
				this.setSWS();
				// Dsize
				if (this.dsize_filter.equals(Lists.YES)) {
					this.vf_parms = this.crop_parms + "," + this.dsize_parms + "," + this.scale_parms + ",harddup" + this.sws_parms;
				// No Dsize
				} else if (! this.dsize_filter.equals(Lists.YES)) {
					this.vf_parms = this.crop_parms + "," + this.scale_parms + ",harddup" + this.sws_parms;
				}
			// No Scale
			} else if (! this.scale_filter.equals(Lists.YES)) {
				// Dsize
				if (this.dsize_filter.equals(Lists.YES)) {
					this.vf_parms = this.crop_parms + "," + this.dsize_parms + ",harddup";
				// No Dsize
				} else if (! this.dsize_filter.equals(Lists.YES)) {
					this.vf_parms = this.crop_parms + ",harddup";
				}
			}
		// No Crop
		} else if (! this.crop_filter.equals(Lists.YES)) {
			// Scale
			if (this.scale_filter.equals(Lists.YES)) {
				// SWS
				this.setSWS();
				// Dsize
				if (this.dsize_filter.equals(Lists.YES)) {
					this.vf_parms = this.dsize_parms + "," + this.scale_parms + ",harddup" + this.sws_parms;
				// No Dsize
				} else if (! this.dsize_filter.equals(Lists.YES)) {
					// Expand
					if (this.expand_filter.equals(Lists.YES)) {
						this.vf_parms = this.scale_parms + "," + this.expand_parms + ",harddup" + this.sws_parms;
					// No Expand
					} else if (! this.expand_filter.equals(Lists.YES)) {
						this.vf_parms = this.scale_parms + ",harddup" + this.sws_parms;
					}
				}
			// No Scale
			} else if (! this.scale_filter.equals(Lists.YES)) {
				this.vf_parms = "harddup";
			}
		}
	}
	
	
	//===========================================================================================================================================
	// Methode 'setSWS'
	//===========================================================================================================================================
	private void setSWS() {
            // Bicubic
            switch (this.sw_scaler) {
                case Lists.SWS_BICUBIC:
                    this.sws_parms = " -sws 2";
                    // Fast Bilinear
                    break;
                case Lists.SWS_FAST_BILINEAR:
                    this.sws_parms = " -sws 0";
                    // Gauss
                    break;
                case Lists.SWS_GAUSS:
                    this.sws_parms = " -sws 7";
                    // Lanczos
                    break;
                case Lists.SWS_LANCZOS:
                    this.sws_parms = " -sws 9";
                    break;
                default:
                    break;
            }
	}
	
	
	//===========================================================================================================================================
	// Methode 'getParms'
	//===========================================================================================================================================
	public String getParms() {
		// Return Parms
		return (vf_parms);
	}
}
/*
 * End Parms_VF.java
 */