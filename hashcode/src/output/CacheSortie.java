package output;

import input.Video;

import java.util.List;

public class CacheSortie {

	int id;

	
	List<Integer> listeIdVideo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Integer> getListeVideo() {
		return listeIdVideo;
	}

	public void setListeVideo(List<Integer> listeVideo) {
		this.listeIdVideo = listeVideo;
	}

	public CacheSortie(int id, List<Integer> listeIdVideo) {
		super();
		this.id = id;
		this.listeIdVideo = listeIdVideo;
	}
	
}
