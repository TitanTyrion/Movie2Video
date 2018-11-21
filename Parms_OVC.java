/*
 * Parms_OVC.java
 * @author Frank Hildesheim, Leipzig 2013, 2014, 2015, 2016, 2017, 2018 (c), <FrankHildesheim@msn.com>
 * Last change: 2018 Oct 29
 * ==================================================================================================================================================
 */


//===================================================================================================================================================
// Klasse 'Parms_OVC'
//===================================================================================================================================================
public class Parms_OVC {
	// Video Encoder
	private final String 	vnc;                                                                    // Video Encoder
	private final String 	vbr;                                                                    // Video Bitrate
	private final String 	enc_mode;                                                               // Video Format
	private final String	container;                                                              // Video Container
	// OAC Parameters (Pass 1/2)
	private String	ovc_parms1;                                                                     // OVC Parameter (Pass 1)
	private String	ovc_parms2;                                                                     // OVC Parameter (Pass 2)
	
	
	//===========================================================================================================================================
	// Konstruktor
	//===========================================================================================================================================
	public Parms_OVC(String vnc, String vbr, String enc_mode, String container) {
		//
		this.vnc = vnc;
		this.vbr = vbr;
		this.enc_mode = enc_mode;
		this.container = container;
	}
	
	
	//===========================================================================================================================================
	// Methode 'setParms'
	//===========================================================================================================================================
	public void setParms() {
            // DivX5
            switch (this.vnc) {
                case Lists.VNC_DIVX:
                    // Fast Mode for AVI Container
                    if (this.enc_mode.equals(Lists.EM_FAST) && this.container.equals(Lists.CONT_AVI)) {
                        this.ovc_parms1 = "lavc -lavcopts vcodec=mpeg4:vpass=1:vbitrate=" + this.vbr + ":vme=4:mbd=1:dia=1:predia=1:last_pred=0:aglobal=0:vglobal=0";
                        this.ovc_parms2 = "lavc -lavcopts vcodec=mpeg4:vpass=2:vbitrate=" + this.vbr + ":vme=4:mbd=1:dia=1:predia=1:last_pred=0:aglobal=0:vglobal=0";
                        // Fast Mode for MP4 Container
                    } else if (this.enc_mode.equals(Lists.EM_FAST) && this.container.equals(Lists.CONT_MP4)) {
                        this.ovc_parms1 = "lavc -lavcopts vcodec=mpeg4:vpass=1:vbitrate=" + this.vbr + ":vme=4:mbd=1:dia=1:predia=1:last_pred=0:aic:aglobal=1:vglobal=1";
                        this.ovc_parms2 = "lavc -lavcopts vcodec=mpeg4:vpass=2:vbitrate=" + this.vbr + ":vme=4:mbd=1:dia=1:predia=1:last_pred=0:aic:aglobal=1:vglobal=1";
                        // Fast Mode for TSK Container
                    } else if (this.enc_mode.equals(Lists.EM_FAST) && this.container.equals(Lists.CONT_TSK)) {
                        this.ovc_parms1 = "lavc -lavcopts vcodec=mpeg4:vpass=1:vbitrate=" + this.vbr + ":vme=4:mbd=1:dia=1:predia=1:last_pred=0:aglobal=0:vglobal=0";
                        this.ovc_parms2 = "lavc -lavcopts vcodec=mpeg4:vpass=2:vbitrate=" + this.vbr + ":vme=4:mbd=1:dia=1:predia=1:last_pred=0:aglobal=0:vglobal=0";
                        // Normal Mode for AVI Container
                    } else if (this.enc_mode.equals(Lists.EM_NORM) && this.container.equals(Lists.CONT_AVI)) {
                        this.ovc_parms1 = "lavc -lavcopts vcodec=mpeg4:vpass=1:vbitrate=" + this.vbr + ":lumi_mask=0.1:dark_mask=0.1:tcplx_mask=0.1:scplx_mask=0.1:vme=4:mbd=2:v4mv:dia=1:predia=1:last_pred=2:vqcomp=0.6:aglobal=0:vglobal=0";
                        this.ovc_parms2 = "lavc -lavcopts vcodec=mpeg4:vpass=2:vbitrate=" + this.vbr + ":lumi_mask=0.1:dark_mask=0.1:tcplx_mask=0.1:scplx_mask=0.1:vme=4:mbd=2:v4mv:dia=1:predia=1:last_pred=2:vqcomp=0.6:aglobal=0:vglobal=0";
                        // Normal Mode for MP4 Container
                    } else if (this.enc_mode.equals(Lists.EM_NORM) && this.container.equals(Lists.CONT_MP4)) {
                        this.ovc_parms1 = "lavc -lavcopts vcodec=mpeg4:vpass=1:vbitrate=" + this.vbr + ":lumi_mask=0.1:dark_mask=0.1:tcplx_mask=0.1:scplx_mask=0.1:vme=4:mbd=2:v4mv:dia=1:predia=1:last_pred=2:vqcomp=0.6:aic:aglobal=1:vglobal=1";
                        this.ovc_parms2 = "lavc -lavcopts vcodec=mpeg4:vpass=2:vbitrate=" + this.vbr + ":lumi_mask=0.1:dark_mask=0.1:tcplx_mask=0.1:scplx_mask=0.1:vme=4:mbd=2:v4mv:dia=1:predia=1:last_pred=2:vqcomp=0.6:aic:aglobal=1:vglobal=1";
                        // Normal Mode for TSK Container
                    } else if (this.enc_mode.equals(Lists.EM_NORM) && this.container.equals(Lists.CONT_TSK)) {
                        this.ovc_parms1 = "lavc -lavcopts vcodec=mpeg4:vpass=1:vbitrate=" + this.vbr + ":lumi_mask=0.1:dark_mask=0.1:tcplx_mask=0.1:scplx_mask=0.1:vme=4:mbd=2:v4mv:dia=1:predia=1:last_pred=2:vqcomp=0.6:aglobal=0:vglobal=0";
                        this.ovc_parms2 = "lavc -lavcopts vcodec=mpeg4:vpass=2:vbitrate=" + this.vbr + ":lumi_mask=0.1:dark_mask=0.1:tcplx_mask=0.1:scplx_mask=0.1:vme=4:mbd=2:v4mv:dia=1:predia=1:last_pred=2:vqcomp=0.6:aglobal=0:vglobal=0";
                        // Slow Mode for AVI Container
                    } else if (this.enc_mode.equals(Lists.EM_SLOW) && this.container.equals(Lists.CONT_AVI)) {
                        this.ovc_parms1 = "lavc -lavcopts vcodec=mpeg4:vpass=1:vbitrate=" + this.vbr + ":lumi_mask=0.1:dark_mask=0.1:tcplx_mask=0.1:scplx_mask=0.1:vme=4:mbd=2:v4mv:mv0:trell:cbp:dia=2:predia=2:last_pred=3:vqcomp=0.6:cmp=3:subcmp=3:precmp=2:cmp=2:subcmp=2:preme=2:qns=2:aglobal=0:vglobal=0";
                        this.ovc_parms2 = "lavc -lavcopts vcodec=mpeg4:vpass=2:vbitrate=" + this.vbr + ":lumi_mask=0.1:dark_mask=0.1:tcplx_mask=0.1:scplx_mask=0.1:vme=4:mbd=2:v4mv:mv0:trell:cbp:dia=2:predia=2:last_pred=3:vqcomp=0.6:cmp=3:subcmp=3:precmp=2:cmp=2:subcmp=2:preme=2:qns=2:aglobal=0:vglobal=0";
                        // Slow Mode for MP4 Container
                    } else if (this.enc_mode.equals(Lists.EM_SLOW) && this.container.equals(Lists.CONT_MP4)) {
                        this.ovc_parms1 = "lavc -lavcopts vcodec=mpeg4:vpass=1:vbitrate=" + this.vbr + ":lumi_mask=0.1:dark_mask=0.1:tcplx_mask=0.1:scplx_mask=0.1:vme=4:mbd=2:v4mv:mv0:trell:cbp:dia=2:predia=2:last_pred=3:vqcomp=0.6:cmp=3:subcmp=3:precmp=2:cmp=2:subcmp=2:preme=2:qns=2:aic:aglobal=1:vglobal=1";
                        this.ovc_parms2 = "lavc -lavcopts vcodec=mpeg4:vpass=2:vbitrate=" + this.vbr + ":lumi_mask=0.1:dark_mask=0.1:tcplx_mask=0.1:scplx_mask=0.1:vme=4:mbd=2:v4mv:mv0:trell:cbp:dia=2:predia=2:last_pred=3:vqcomp=0.6:cmp=3:subcmp=3:precmp=2:cmp=2:subcmp=2:preme=2:qns=2:aic:aglobal=1:vglobal=1";
                        // Slow Mode for TSK Container
                    } else if (this.enc_mode.equals(Lists.EM_SLOW) && this.container.equals(Lists.CONT_TSK)) {
                        this.ovc_parms1 = "lavc -lavcopts vcodec=mpeg4:vpass=1:vbitrate=" + this.vbr + ":lumi_mask=0.1:dark_mask=0.1:tcplx_mask=0.1:scplx_mask=0.1:vme=4:mbd=2:v4mv:mv0:trell:cbp:dia=2:predia=2:last_pred=3:vqcomp=0.6:cmp=3:subcmp=3:precmp=2:cmp=2:subcmp=2:preme=2:qns=2:aglobal=0:vglobal=0";
                        this.ovc_parms2 = "lavc -lavcopts vcodec=mpeg4:vpass=2:vbitrate=" + this.vbr + ":lumi_mask=0.1:dark_mask=0.1:tcplx_mask=0.1:scplx_mask=0.1:vme=4:mbd=2:v4mv:mv0:trell:cbp:dia=2:predia=2:last_pred=3:vqcomp=0.6:cmp=3:subcmp=3:precmp=2:cmp=2:subcmp=2:preme=2:qns=2:aglobal=0:vglobal=0";
                    }
                    // H264
                    break;
                case Lists.VNC_H264:
                    // Fast Mode for MP4 Container
                    if (this.enc_mode.equals(Lists.EM_FAST) && this.container.equals(Lists.CONT_MP4)) {
                        this.ovc_parms1 = "x264 -x264encopts pass=1:threads=auto:bitrate=" + this.vbr + ":frameref=1:bframes=0:nodeblock:nocabac:direct_pred=none:partitions=none:me=dia:me_range=4:subq=1:nochroma_me:nomixed_refs:trellis=0:nr=0:profile=high:global_header";
                        this.ovc_parms2 = "x264 -x264encopts pass=2:threads=auto:bitrate=" + this.vbr + ":frameref=1:bframes=0:nodeblock:nocabac:direct_pred=none:partitions=none:me=dia:me_range=4:subq=1:nochroma_me:nomixed_refs:trellis=0:nr=0:profile=high:global_header";
                        // Fast Mode for TSK Container
                    } else if (this.enc_mode.equals(Lists.EM_FAST) && this.container.equals(Lists.CONT_TSK)) {
                        this.ovc_parms1 = "x264 -x264encopts pass=1:threads=auto:bitrate=" + this.vbr + ":frameref=1:bframes=0:nodeblock:nocabac:direct_pred=none:partitions=none:me=dia:me_range=4:subq=1:nochroma_me:nomixed_refs:trellis=0:nr=0:profile=high:global_header";
                        this.ovc_parms2 = "x264 -x264encopts pass=2:threads=auto:bitrate=" + this.vbr + ":frameref=1:bframes=0:nodeblock:nocabac:direct_pred=none:partitions=none:me=dia:me_range=4:subq=1:nochroma_me:nomixed_refs:trellis=0:nr=0:profile=high:global_header";
                        // Normal Mode for MP4 Container
                    } else if (this.enc_mode.equals(Lists.EM_NORM) && this.container.equals(Lists.CONT_MP4)) {
                        this.ovc_parms1 = "x264 -x264encopts pass=1:threads=auto:bitrate=" + this.vbr + ":frameref=4:bframes=3:deblock:direct_pred=auto:partitions=p8x8,b8x8:me=hex:me_range=16:subq=6:chroma_me:mixed_refs:trellis=1:weight_b:nr=0:profile=high:global_header";
                        this.ovc_parms2 = "x264 -x264encopts pass=2:threads=auto:bitrate=" + this.vbr + ":frameref=4:bframes=3:deblock:direct_pred=auto:partitions=p8x8,b8x8:me=hex:me_range=16:subq=6:chroma_me:mixed_refs:trellis=1:weight_b:nr=0:profile=high:global_header";
                        // Normal Mode for TSK Container
                    } else if (this.enc_mode.equals(Lists.EM_NORM) && this.container.equals(Lists.CONT_TSK)) {
                        this.ovc_parms1 = "x264 -x264encopts pass=1:threads=auto:bitrate=" + this.vbr + ":frameref=4:bframes=3:deblock:direct_pred=auto:partitions=p8x8,b8x8:me=hex:me_range=16:subq=6:chroma_me:mixed_refs:trellis=1:weight_b:nr=0:profile=high:global_header";
                        this.ovc_parms2 = "x264 -x264encopts pass=2:threads=auto:bitrate=" + this.vbr + ":frameref=4:bframes=3:deblock:direct_pred=auto:partitions=p8x8,b8x8:me=hex:me_range=16:subq=6:chroma_me:mixed_refs:trellis=1:weight_b:nr=0:profile=high:global_header";
                        // Slow Mode for MP4 Container
                    } else if (this.enc_mode.equals(Lists.EM_SLOW) && this.container.equals(Lists.CONT_MP4)) {
                        this.ovc_parms1 = "x264 -x264encopts pass=1:threads=auto:bitrate=" + this.vbr + ":frameref=10:bframes=12:deblock:direct_pred=auto:partitions=all:8x8dct:me=esa:me_range=24:subq=8:chroma_me:mixed_refs:trellis=2:weight_b:nr=0:profile=high:global_header";
                        this.ovc_parms2 = "x264 -x264encopts pass=2:threads=auto:bitrate=" + this.vbr + ":frameref=10:bframes=12:deblock:direct_pred=auto:partitions=all:8x8dct:me=esa:me_range=24:subq=8:chroma_me:mixed_refs:trellis=2:weight_b:nr=0:profile=high:global_header";
                        // Slow Mode for TSK Container
                    } else if (this.enc_mode.equals(Lists.EM_SLOW) && this.container.equals(Lists.CONT_TSK)) {
                        this.ovc_parms1 = "x264 -x264encopts pass=1:threads=auto:bitrate=" + this.vbr + ":frameref=10:bframes=12:deblock:direct_pred=auto:partitions=all:8x8dct:me=esa:me_range=24:subq=8:chroma_me:mixed_refs:trellis=2:weight_b:nr=0:profile=high:global_header";
                        this.ovc_parms2 = "x264 -x264encopts pass=2:threads=auto:bitrate=" + this.vbr + ":frameref=10:bframes=12:deblock:direct_pred=auto:partitions=all:8x8dct:me=esa:me_range=24:subq=8:chroma_me:mixed_refs:trellis=2:weight_b:nr=0:profile=high:global_header";
                    }
                    // Mpeg2
                    break;
                case Lists.VNC_MPG2:
                    // Fast Mode for DVD Container
                    if (this.enc_mode.equals(Lists.EM_FAST) && this.container.equals(Lists.CONT_DVD)) {
                        this.ovc_parms1 = "lavc -lavcopts vcodec=mpeg2video:vpass=1:vrc_buf_size=" + Lists.DVD_VRC_BUFSIZE + ":vrc_maxrate=" + Lists.DVD_VRC_MAXRATE + ":vbitrate=" + this.vbr + ":keyint=12:vstrict=0:lowdelay";
                        this.ovc_parms2 = "lavc -lavcopts vcodec=mpeg2video:vpass=2:vrc_buf_size=" + Lists.DVD_VRC_BUFSIZE + ":vrc_maxrate=" + Lists.DVD_VRC_MAXRATE + ":vbitrate=" + this.vbr + ":keyint=12:vstrict=0:lowdelay";
                        // Fast Mode for MPEG2 Container
                    } else if (this.enc_mode.equals(Lists.EM_FAST) && this.container.equals(Lists.CONT_VCD)) {
                        this.ovc_parms1 = "lavc -lavcopts vcodec=mpeg2video:vpass=1:vrc_buf_size=" + Lists.MP2_VRC_BUFSIZE + ":vrc_maxrate=" + Lists.MP2_VRC_MAXRATE + ":vbitrate=" + this.vbr + ":keyint=15:vstrict=0:lowdelay";
                        this.ovc_parms2 = "lavc -lavcopts vcodec=mpeg2video:vpass=2:vrc_buf_size=" + Lists.MP2_VRC_BUFSIZE + ":vrc_maxrate=" + Lists.MP2_VRC_MAXRATE + ":vbitrate=" + this.vbr + ":keyint=15:vstrict=0:lowdelay";
                        // Normal Mode for DVD Container
                    } else if (this.enc_mode.equals(Lists.EM_NORM) && this.container.equals(Lists.CONT_DVD)) {
                        this.ovc_parms1 = "lavc -lavcopts vcodec=mpeg2video:vpass=1:vrc_buf_size=" + Lists.DVD_VRC_BUFSIZE + ":vrc_maxrate=" + Lists.DVD_VRC_MAXRATE + ":vbitrate=" + this.vbr + ":keyint=12:trell:mbd=2:precmp=2:subcmp=2:cmp=2:dia=1:predia=1:cbp:mv0:lmin=1:dc=10:vstrict=0:lowdelay";
                        this.ovc_parms2 = "lavc -lavcopts vcodec=mpeg2video:vpass=2:vrc_buf_size=" + Lists.DVD_VRC_BUFSIZE + ":vrc_maxrate=" + Lists.DVD_VRC_MAXRATE + ":vbitrate=" + this.vbr + ":keyint=12:trell:mbd=2:precmp=2:subcmp=2:cmp=2:dia=1:predia=1:cbp:mv0:lmin=1:dc=10:vstrict=0:lowdelay";
                        // Normal Mode for MPEG2 Container
                    } else if (this.enc_mode.equals(Lists.EM_NORM) && this.container.equals(Lists.CONT_VCD)) {
                        this.ovc_parms1 = "lavc -lavcopts vcodec=mpeg2video:vpass=1:vrc_buf_size=" + Lists.MP2_VRC_BUFSIZE + ":vrc_maxrate=" + Lists.MP2_VRC_MAXRATE + ":vbitrate=" + this.vbr + ":keyint=15:trell:mbd=2:precmp=2:subcmp=2:cmp=2:dia=1:predia=1:cbp:mv0:lmin=1:dc=10:vstrict=0:lowdelay";
                        this.ovc_parms2 = "lavc -lavcopts vcodec=mpeg2video:vpass=2:vrc_buf_size=" + Lists.MP2_VRC_BUFSIZE + ":vrc_maxrate=" + Lists.MP2_VRC_MAXRATE + ":vbitrate=" + this.vbr + ":keyint=15:trell:mbd=2:precmp=2:subcmp=2:cmp=2:dia=1:predia=1:cbp:mv0:lmin=1:dc=10:vstrict=0:lowdelay";
                        // Slow Mode (Noch Anpassen! z.Z. Normal Mode) for DVD Container
                    } else if (this.enc_mode.equals(Lists.EM_SLOW) && this.container.equals(Lists.CONT_DVD)) {
                        this.ovc_parms1 = "lavc -lavcopts vcodec=mpeg2video:vpass=1:vrc_buf_size=" + Lists.DVD_VRC_BUFSIZE + ":vrc_maxrate=" + Lists.DVD_VRC_MAXRATE + ":vbitrate=" + this.vbr + ":keyint=12:trell:mbd=2:precmp=2:subcmp=2:cmp=2:dia=1:predia=1:cbp:mv0:lmin=1:dc=10:vstrict=0:lowdelay";
                        this.ovc_parms2 = "lavc -lavcopts vcodec=mpeg2video:vpass=2:vrc_buf_size=" + Lists.DVD_VRC_BUFSIZE + ":vrc_maxrate=" + Lists.DVD_VRC_MAXRATE + ":vbitrate=" + this.vbr + ":keyint=12:trell:mbd=2:precmp=2:subcmp=2:cmp=2:dia=1:predia=1:cbp:mv0:lmin=1:dc=10:vstrict=0:lowdelay";
                        // Slow Mode (Noch Anpassen! z.Z. Normal Mode) for MPEG2 Container
                    } else if (this.enc_mode.equals(Lists.EM_SLOW) && this.container.equals(Lists.CONT_VCD)) {
                        this.ovc_parms1 = "lavc -lavcopts vcodec=mpeg2video:vpass=1:vrc_buf_size=" + Lists.MP2_VRC_BUFSIZE + ":vrc_maxrate=" + Lists.MP2_VRC_MAXRATE + ":vbitrate=" + this.vbr + ":keyint=15:trell:mbd=2:precmp=2:subcmp=2:cmp=2:dia=1:predia=1:cbp:mv0:lmin=1:dc=10:vstrict=0:lowdelay";
                        this.ovc_parms2 = "lavc -lavcopts vcodec=mpeg2video:vpass=2:vrc_buf_size=" + Lists.MP2_VRC_BUFSIZE + ":vrc_maxrate=" + Lists.MP2_VRC_MAXRATE + ":vbitrate=" + this.vbr + ":keyint=15:trell:mbd=2:precmp=2:subcmp=2:cmp=2:dia=1:predia=1:cbp:mv0:lmin=1:dc=10:vstrict=0:lowdelay";
                    }
                    // Theora
                    break;
                case Lists.VNC_THEO:
                    // Fast Mode for TSK Container
                    if (this.enc_mode.equals(Lists.EM_FAST) && this.container.equals(Lists.CONT_TSK)) {
                        this.ovc_parms1 = "lavc -lavcopts vcodec=libtheora:vpass=1:vbitrate=" + this.vbr + ":vme=4:mbd=1:dia=1:predia=1:last_pred=0:aic:aglobal=0:vglobal=0";
                        this.ovc_parms2 = "lavc -lavcopts vcodec=libtheora:vpass=2:vbitrate=" + this.vbr + ":vme=4:mbd=1:dia=1:predia=1:last_pred=0:aic:aglobal=0:vglobal=0";
                        // Normal Mode for TSK Container
                    } else if (this.enc_mode.equals(Lists.EM_NORM) && this.container.equals(Lists.CONT_TSK)) {
                        this.ovc_parms1 = "lavc -lavcopts vcodec=libtheora:vpass=1:vbitrate=" + this.vbr + ":vme=4:mbd=1:dia=1:predia=1:last_pred=0:aic:aglobal=0:vglobal=0";
                        this.ovc_parms2 = "lavc -lavcopts vcodec=libtheora:vpass=2:vbitrate=" + this.vbr + ":vme=4:mbd=1:dia=1:predia=1:last_pred=0:aic:aglobal=0:vglobal=0";
                        // Slow Mode for TSK Container
                    } else if (this.enc_mode.equals(Lists.EM_SLOW) && this.container.equals(Lists.CONT_TSK)) {
                        this.ovc_parms1 = "lavc -lavcopts vcodec=libtheora:vpass=1:vbitrate=" + this.vbr + ":vme=4:mbd=1:dia=1:predia=1:last_pred=0:aic:aglobal=0:vglobal=0";
                        this.ovc_parms2 = "lavc -lavcopts vcodec=libtheora:vpass=2:vbitrate=" + this.vbr + ":vme=4:mbd=1:dia=1:predia=1:last_pred=0:aic:aglobal=0:vglobal=0";
                    }
                    // Xvid
                    break;
                case Lists.VNC_XVID:
                    // Fast Mode for AVI Container
                    if (this.enc_mode.equals(Lists.EM_FAST) && this.container.equals(Lists.CONT_AVI)) {
                        this.ovc_parms1 = "xvid -xvidencopts pass=1:max_bframes=0:vhq=0:me_quality=3:nochroma_me:nochroma_opt:quant_type=mpeg:nohq_ac:notrellis:nolumi_mask:autoaspect:bvhq=0";
                        this.ovc_parms2 = "xvid -xvidencopts pass=2:bitrate=" + this.vbr + ":max_bframes=0:vhq=0:me_quality=3:nochroma_me:nochroma_opt:quant_type=mpeg:nohq_ac:notrellis:nolumi_mask:autoaspect:bvhq=0";
                        // Fast Mode for MP4 Container
                    } else if (this.enc_mode.equals(Lists.EM_FAST) && this.container.equals(Lists.CONT_MP4)) {
                        this.ovc_parms1 = "xvid -xvidencopts pass=1:max_bframes=0:vhq=0:me_quality=3:nochroma_me:nochroma_opt:quant_type=mpeg:nohq_ac:notrellis:nolumi_mask:autoaspect:bvhq=0";
                        this.ovc_parms2 = "xvid -xvidencopts pass=2:bitrate=" + this.vbr + ":max_bframes=0:vhq=0:me_quality=3:nochroma_me:nochroma_opt:quant_type=mpeg:nohq_ac:notrellis:nolumi_mask:autoaspect:bvhq=0";
                        // Fast Mode for TSK Container
                    } else if (this.enc_mode.equals(Lists.EM_FAST) && this.container.equals(Lists.CONT_TSK)) {
                        this.ovc_parms1 = "xvid -xvidencopts pass=1:max_bframes=0:vhq=0:me_quality=3:nochroma_me:nochroma_opt:quant_type=mpeg:nohq_ac:notrellis:nolumi_mask:autoaspect:bvhq=0";
                        this.ovc_parms2 = "xvid -xvidencopts pass=2:bitrate=" + this.vbr + ":max_bframes=0:vhq=0:me_quality=3:nochroma_me:nochroma_opt:quant_type=mpeg:nohq_ac:notrellis:nolumi_mask:autoaspect:bvhq=0";
                        // Normal Mode for AVI Container
                    } else if (this.enc_mode.equals(Lists.EM_NORM) && this.container.equals(Lists.CONT_AVI)) {
                        this.ovc_parms1 = "xvid -xvidencopts pass=1:max_bframes=0:vhq=3:me_quality=6:chroma_me:chroma_opt:quant_type=mpeg:hq_ac:trellis:lumi_mask:autoaspect:bvhq=0";
                        this.ovc_parms2 = "xvid -xvidencopts pass=2:bitrate=" + this.vbr + ":max_bframes=0:vhq=3:me_quality=6:chroma_me:chroma_opt:quant_type=mpeg:hq_ac:trellis:lumi_mask:autoaspect:bvhq=0";
                        // Normal Mode for MP4 Container
                    } else if (this.enc_mode.equals(Lists.EM_NORM) && this.container.equals(Lists.CONT_MP4)) {
                        this.ovc_parms1 = "xvid -xvidencopts pass=1:max_bframes=1:bquant_ratio=162:bquant_offset=100:vhq=3:me_quality=6:chroma_me:chroma_opt:quant_type=mpeg:hq_ac:trellis:lumi_mask:autoaspect:bvhq=1";
                        this.ovc_parms2 = "xvid -xvidencopts pass=2:bitrate=" + this.vbr + ":max_bframes=1:bquant_ratio=162:bquant_offset=100:vhq=3:me_quality=6:chroma_me:chroma_opt:quant_type=mpeg:hq_ac:trellis:lumi_mask:autoaspect:bvhq=1";
                        // Normal Mode for TSK Container
                    } else if (this.enc_mode.equals(Lists.EM_NORM) && this.container.equals(Lists.CONT_TSK)) {
                        this.ovc_parms1 = "xvid -xvidencopts pass=1:max_bframes=1:bquant_ratio=162:bquant_offset=100:vhq=3:me_quality=6:chroma_me:chroma_opt:quant_type=mpeg:hq_ac:trellis:lumi_mask:autoaspect:bvhq=1";
                        this.ovc_parms2 = "xvid -xvidencopts pass=2:bitrate=" + this.vbr + ":max_bframes=1:bquant_ratio=162:bquant_offset=100:vhq=3:me_quality=6:chroma_me:chroma_opt:quant_type=mpeg:hq_ac:trellis:lumi_mask:autoaspect:bvhq=1";
                        // Slow Mode for AVI Container
                    } else if (this.enc_mode.equals(Lists.EM_SLOW) && this.container.equals(Lists.CONT_AVI)) {
                        this.ovc_parms1 = "xvid -xvidencopts pass=1:max_bframes=0:vhq=4:me_quality=6:chroma_me:chroma_opt:quant_type=mpeg:hq_ac:trellis:lumi_mask:autoaspect:bvhq=0";
                        this.ovc_parms2 = "xvid -xvidencopts pass=2:bitrate=" + this.vbr + ":max_bframes=0:vhq=4:me_quality=6:chroma_me:chroma_opt:quant_type=mpeg:hq_ac:trellis:lumi_mask:autoaspect:bvhq=0";
                        // Slow Mode for MP4 Container
                    } else if (this.enc_mode.equals(Lists.EM_SLOW) && this.container.equals(Lists.CONT_MP4)) {
                        this.ovc_parms1 = "xvid -xvidencopts pass=1:max_bframes=2:bquant_ratio=162:bquant_offset=100:vhq=4:me_quality=6:chroma_me:chroma_opt:quant_type=mpeg:hq_ac:trellis:lumi_mask:autoaspect:bvhq=1";
                        this.ovc_parms2 = "xvid -xvidencopts pass=2:bitrate=" + this.vbr + ":max_bframes=2:bquant_ratio=162:bquant_offset=100:vhq=4:me_quality=6:chroma_me:chroma_opt:quant_type=mpeg:hq_ac:trellis:lumi_mask:autoaspect:bvhq=1";
                        // Slow Mode for TSK Container
                    } else if (this.enc_mode.equals(Lists.EM_SLOW) && this.container.equals(Lists.CONT_TSK)) {
                        this.ovc_parms1 = "xvid -xvidencopts pass=1:max_bframes=2:bquant_ratio=162:bquant_offset=100:vhq=4:me_quality=6:chroma_me:chroma_opt:quant_type=mpeg:hq_ac:trellis:lumi_mask:autoaspect:bvhq=1";
                        this.ovc_parms2 = "xvid -xvidencopts pass=2:bitrate=" + this.vbr + ":max_bframes=2:bquant_ratio=162:bquant_offset=100:vhq=4:me_quality=6:chroma_me:chroma_opt:quant_type=mpeg:hq_ac:trellis:lumi_mask:autoaspect:bvhq=1";
                    }
                    break;
                default:
                    break;
            }
	}
	
	
	//===========================================================================================================================================
	// Methode 'getParms'
	//===========================================================================================================================================
	public String[] getParms() {
		// Add Parameters to Array
		String[] ovc_parms = {this.ovc_parms1, this.ovc_parms2};
		// Return Parameters
		return (ovc_parms);
	}
}
/*
 * End Parms_OVC.java
 */