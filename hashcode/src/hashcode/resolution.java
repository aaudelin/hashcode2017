package hashcode;

import input.CacheServer;
import input.Endpoint;
import input.Request;
import input.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import output.CacheSortie;
import output.Solution;

public class resolution {

	
	List<CacheServer> cacheServeur;
	
	List<Endpoint> endPoint;
	
	List<Video> video;
	
	List<Request> request;
	
	
	public Solution solvePbEmpirique(){
		
		ArrayList<CacheSortie> cacheSortieListe = new ArrayList<CacheSortie>();
		for(int i=0; i<cacheServeur.size();i++){
			
			CacheSortie cacheSortie = new CacheSortie(cacheServeur.get(i).getId(), new ArrayList<Integer>());
			cacheSortieListe.add(cacheSortie);
		
		}
		
		
		Solution solution = new Solution(cacheSortieListe);
		
		
		
		ArrayList<CacheServer> cacheServeurTmp = new ArrayList<CacheServer>();
		
		ArrayList<Endpoint> endPointTmp = new ArrayList<Endpoint>();
		
		ArrayList<Video> videoTmp = new ArrayList<Video>();
		
		ArrayList<Request> requestTmp = new ArrayList<Request>();
		
		cacheServeurTmp.addAll(cacheServeur);
		endPointTmp.addAll(endPoint);
		videoTmp.addAll(video);
		requestTmp.addAll(request);
		
		
		solution.setCacheSortie(cacheSortieListe);
		while(!requestTmp.isEmpty()){
			
			Request bestRequest = bestRequest(requestTmp);
			
			
			int idCache= SelectBestCache(bestRequest,cacheServeur,solution);
			
			if (idCache>=0){
			updateSolution (idCache, bestRequest.getVideo(),solution);
			
			}
			
			requestTmp.remove(bestRequest);
			
		}
		
		
		return solution;
		
		
	}
	
	
	public Solution resolv2(){
		
		ArrayList<CacheSortie> cacheSortieListe = new ArrayList<CacheSortie>();
		for(int i=0; i<cacheServeur.size();i++){
			
			CacheSortie cacheSortie = new CacheSortie(cacheServeur.get(i).getId(), new ArrayList<Integer>());
			cacheSortieListe.add(cacheSortie);
		
		}
		
		Solution solution = new Solution(cacheSortieListe);
		
		
		ArrayList<Integer[]> listeIdRequeteTri= new ArrayList<Integer[]>();
		
		listeIdRequeteTri = trierRequeteByScore(request);
		
		
		
		
		return solution;
	}
	
	
	

	private ArrayList<Integer[]> trierRequeteByScore(List<Request> request2) {
		// TODO Auto-generated method stub
		return null;
		
		
	}


	private void updateSolution(int idCache, Video video2, Solution solution) {
		if(!cacheContientVideo(solution.getCacheSortie().get(idCache).getListeVideo(),video2)){
		solution.getCacheSortie().get(idCache).getListeVideo().add(video2.getId());
		cacheServeur.get(idCache).setCapacityMax(cacheServeur.get(idCache).getCapacityMax()-video2.getSize());
		}
		
		
	}
	
	
	private boolean cacheContientVideo(List<Integer> lVideo, Video video){
		boolean res= false;
		
		for( int v : lVideo){
			if(v==video.getId()){
				res=true;
			}
		}
		
		return res;
	}
	
	private int Score (Request requete){
		
		int score=-1;
		return score;
		
	}




	private int SelectBestCache(Request bestRequest,
			List<CacheServer> lcacheServeurTmp, Solution solution) {
		// TODO Auto-generated method stub
		int idBest=-1;
		int latenceBest=0;
		try{
		int dataLatency = bestRequest.getEndpoint().getDatacenterLatency();
		
		Map<Integer,Integer> cacheLatencyMap = bestRequest.getEndpoint().getCacheLatency();
		
			
			
		
				for (Integer id : cacheLatencyMap.keySet()) {
				if(((dataLatency-cacheLatencyMap.get(id))>latenceBest&&bestRequest.getVideo().getSize()<lcacheServeurTmp.get(id).getCapacityMax())){
					latenceBest=dataLatency-cacheLatencyMap.get(id);
					idBest=id;
				}
				
			}			
		}
		catch (Exception e){
			return idBest;	
		}
		return idBest;
		
	}




	private Request bestRequest(ArrayList<Request> requestTmp) {
		// TODO Auto-generated method stub
		
		Request res = null;
		Request resTmp =null;
		
		double score=0;
		
		for (int i=0;i<requestTmp.size();i++){
			
			resTmp=requestTmp.get(i);
			double tmpScore=(double)resTmp.getNbRequest()*resTmp.getEndpoint().getDatacenterLatency()/(double)resTmp.getVideo().getSize();
			if (tmpScore>score){
				score=tmpScore;
				res=resTmp;
			}
		}				
		return res;
	}




	public List<CacheServer> getCacheServeur() {
		return cacheServeur;
	}

	public void setCacheServeur(ArrayList<CacheServer> cacheServeur) {
		this.cacheServeur = cacheServeur;
	}

	public List<Endpoint> getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(List<Endpoint> endPoint) {
		this.endPoint = endPoint;
	}

	public List<Video> getVideo() {
		return video;
	}

	public void setVideo(List<Video> video) {
		this.video = video;
	}

	public List<Request> getRequest() {
		return request;
	}

	public void setRequest(List<Request> request) {
		this.request = request;
	}

	public resolution(List<CacheServer> cacheServeur, List<Endpoint> endPoint,
			List<Video> video, List<Request> request) {
		super();
		this.cacheServeur = cacheServeur;
		this.endPoint = endPoint;
		this.video = video;
		this.request = request;
	}
	
	
	
	
	
	
	
}
