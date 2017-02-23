package input;

import java.util.Map;

public class Request {
	
	Endpoint endpoint;
	Map<Video, Integer> videosRequest; // video / nombre videos
	public Endpoint getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(Endpoint endpoint) {
		this.endpoint = endpoint;
	}
	public Map<Video, Integer> getVideosRequest() {
		return videosRequest;
	}
	public void setVideosRequest(Map<Video, Integer> videosRequest) {
		this.videosRequest = videosRequest;
	}
	
	

}
