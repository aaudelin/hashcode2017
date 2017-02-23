package output;

import input.Video;

import java.util.List;

public class CacheSortie {

	int id;
	
	List<Video> listeVideo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Video> getListeVideo() {
		return listeVideo;
	}

	public void setListeVideo(List<Video> listeVideo) {
		this.listeVideo = listeVideo;
	}

	public CacheSortie(int id, List<Video> listeVideo) {
		super();
		this.id = id;
		this.listeVideo = listeVideo;
	}
	
}
