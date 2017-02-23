package input;

import java.util.HashMap;
import java.util.Map;

public class Endpoint {
	
	int id;
	int datacenterLatency;
	int nbCaches;
	Map<Integer, Integer> cacheLatency; // idcache / latence
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDatacenterLatency() {
		return datacenterLatency;
	}
	public void setDatacenterLatency(int datacenterLatency) {
		this.datacenterLatency = datacenterLatency;
	}
	public Map<Integer, Integer> getCacheLatency() {
		if(cacheLatency==null){
			cacheLatency = new HashMap<Integer, Integer>();
		}
		return cacheLatency;
	}
	public void setCacheLatency(Map<Integer, Integer> cacheLatency) {
		this.cacheLatency = cacheLatency;
	}
	public int getNbCaches() {
		return nbCaches;
	}
	public void setNbCaches(int nbCaches) {
		this.nbCaches = nbCaches;
	}
	
	

}
