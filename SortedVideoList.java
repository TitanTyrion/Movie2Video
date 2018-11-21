/*
 * SortedVideoList.java
 * @author Frank Hildesheim, Leipzig 2013, 2014, 2015, 2016, 2017, 2018 (c), <FrankHildesheim@mail.ru>
 * Last change: 2018 Oct 29
 * ==================================================================================================================================================
 */

import java.io.File;
import java.util.Arrays;


//===================================================================================================================================================
// KLasse 'SortedVideoList'
//===================================================================================================================================================
public class SortedVideoList {
	//
	private final File      dir;									// Working Directory
	private final String[]  list_dir;								// List with Files in WDR
	private final SortedIntegerList list_videos;                                                    // Sorted List with Name of Videofiles
	private String name;                                                                            // Video Name
	private String file_extension;                                                                  // Video-File Extension
	
	
	//===========================================================================================================================================
	// Konstruktor
	//===========================================================================================================================================
	public SortedVideoList(File dir) {
		//
		this.dir = dir;
		this.list_dir = new File(this.dir.getPath()).list();
		this.list_videos = new SortedIntegerList();
	}
	
	
	//===========================================================================================================================================
	// Methode 'search'
	//===========================================================================================================================================
	public void search() {
		// Sort List
		Arrays.sort(this.list_dir);
		// Search in List (Evtl. besser fuer jedes Suffix eine eigene For-Schleife - Sortierung - oder zuerst separate Listen???)
		for (int i = 0; i < this.list_dir.length; i++) {
			// AVI-, MPEG-, MOV- and MP4-Videos
			if (this.list_dir[i].contains("." + Lists.OF_3GP) || this.list_dir[i].contains("." + Lists.OF_AVI) || 
				this.list_dir[i].contains("." + Lists.OF_FLV) || this.list_dir[i].contains("." + Lists.OF_MOV) ||
				this.list_dir[i].contains("." + Lists.OF_MPG) || this.list_dir[i].contains("." + Lists.OF_MPEG) ||
				this.list_dir[i].contains("." + Lists.OF_MP2) || this.list_dir[i].contains("." + Lists.OF_MP4) || 
				this.list_dir[i].contains("." + Lists.OF_MKV) || this.list_dir[i].contains("." + Lists.OF_VOB) ||
				this.list_dir[i].contains("." + Lists.OF_WEBM)) {
				// Add Videos to new List
				this.list_videos.put(i, this.list_dir[i]);
			}
		}
	}
	
	
	//===========================================================================================================================================
	// Methode 'size'
	//===========================================================================================================================================
	public Integer size() {
		// Return List Size
		return (this.list_videos.size());
	}
	
	
	//===========================================================================================================================================
	// Methode 'get'
	//===========================================================================================================================================
	public String get(Integer key) {
		// Return Value
		return (this.list_videos.get(key));
	}
	
	
	//===========================================================================================================================================
	// Methode 'getVideo'
	//===========================================================================================================================================
	public String[] getVideo(Integer key) {
		// 3GP Videos
		if (this.list_videos.get(key).contains("." + Lists.OF_3GP)) {
			this.file_extension = Lists.OF_3GP;
			this.name = this.list_videos.get(key).replace("." + this.file_extension, "");
		// AVI Videos
		} else if (this.list_videos.get(key).contains("." + Lists.OF_AVI)) {
			this.file_extension = Lists.OF_AVI;
			this.name = this.list_videos.get(key).replace("." + this.file_extension, "");
		// Flash Videos
		} else if (this.list_videos.get(key).contains("." + Lists.OF_FLV)) {
			this.file_extension = Lists.OF_FLV;
			this.name = this.list_videos.get(key).replace("." + this.file_extension, "");
		// Mov Videos
		} else if (this.list_videos.get(key).contains("." + Lists.OF_MOV)) {
			this.file_extension = Lists.OF_MOV;
			this.name = this.list_videos.get(key).replace("." + this.file_extension, "");
		// MPG Videos
		} else if (this.list_videos.get(key).contains("." + Lists.OF_MPG)) {
			this.file_extension = Lists.OF_MPG;
			this.name = this.list_videos.get(key).replace("." + this.file_extension, "");
		// MPEG Video
		} else if (this.list_videos.get(key).contains("." + Lists.OF_MPEG)) {
			this.file_extension = Lists.OF_MPEG;
			this.name = this.list_videos.get(key).replace("." + this.file_extension, "");
		// MP2 Videos
		} else if (this.list_videos.get(key).contains("." + Lists.OF_MP2)) {
			this.file_extension = Lists.OF_MP2;
			this.name = this.list_videos.get(key).replace("." + this.file_extension, "");
		// MP4 Videos
		} else if (this.list_videos.get(key).contains("." + Lists.OF_MP4)) {
			this.file_extension = Lists.OF_MP4;
			this.name = this.list_videos.get(key).replace("." + this.file_extension, "");
		// MKV Videos
		} else if (this.list_videos.get(key).contains("." + Lists.OF_MKV)) {
			this.file_extension = Lists.OF_MKV;
			this.name = this.list_videos.get(key).replace("." + this.file_extension, "");
		// VOB Videos
		} else if (this.list_videos.get(key).contains("." + Lists.OF_VOB)) {
			this.file_extension = Lists.OF_VOB;
			this.name = this.list_videos.get(key).replace("." + this.file_extension, "");
		// WEBM Videos
		} else if (this.list_videos.get(key).contains("." + Lists.OF_WEBM)) {
			this.file_extension = Lists.OF_WEBM;
			this.name = this.list_videos.get(key).replace("." + this.file_extension, "");
		}
		//
		String[] video_file = {this.name, this.file_extension};
		// Return Video Files Array
		return (video_file);
	}
}
/*
 * End SortedVideoList.java
 */