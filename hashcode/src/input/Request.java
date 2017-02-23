package input;

import java.util.Map;

public class Request {
	
	Endpoint endpoint;
	Video video;
	Integer nbRequest;
	public Endpoint getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(Endpoint endpoint) {
		this.endpoint = endpoint;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public Integer getNbRequest() {
		return nbRequest;
	}
	public void setNbRequest(Integer nbRequest) {
		this.nbRequest = nbRequest;
	}
	
	
	

}
