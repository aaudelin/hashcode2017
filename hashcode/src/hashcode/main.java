package hashcode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import input.Endpoint;
import input.First;
import input.Request;
import input.Video;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String chaine="";
		String fichier ="fichiertexte.txt";
		
		boolean isEndpoint = true;
		boolean isCache = false;
		boolean isRequest = false;
		Endpoint lastEndpoint = null ;
		
		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			int numligne = 0;
			while ((ligne=br.readLine())!=null){
				numligne++;
				First first = new First();
				if(numligne==1){
					String[] ligne1 = ligne.split(" ");
					
					first.setNbVideos(Integer.valueOf(ligne1[0]));
					first.setNbEndpoints(Integer.valueOf(ligne1[1]));
					first.setNbRequests(Integer.valueOf(ligne1[2]));
					first.setNbCaches(Integer.valueOf(ligne1[3]));
					first.setCachesCapacity(Integer.valueOf(ligne1[4]));
					
				}
				
				if(numligne==2){
					int idVideo = 0;
					String[] ligne2 = ligne.split(" ");
					List<Video> videos = new ArrayList<Video>();
					for (String size : ligne2) {
						Video video = new Video();
						video.setSize(Integer.valueOf(size));
						video.setId(idVideo);
						videos.add(video);
						idVideo ++;
					}
					
				}
				
				int nbEndpoint = first.getNbEndpoints();
				int idEndpoint= 0;
				
				int idCache = 0;
				
				
				List<Endpoint> endpoints = new ArrayList<Endpoint>();
				if(numligne>2){
					
					if (isEndpoint) {
					isEndpoint = false;
					Endpoint endpoint = new Endpoint();
					endpoint.setId(idEndpoint);
					String[] ligneEndpoint = ligne.split(" ");
					endpoint.setDatacenterLatency(Integer.valueOf(ligneEndpoint[0]));
					endpoint.setNbCaches(Integer.valueOf(ligneEndpoint[1]));
					idEndpoint++;
					if(endpoint.getNbCaches()==0 ){
						isCache= false;
						if(idEndpoint!= nbEndpoint){
						isEndpoint = true;
						}else {
						isRequest = true;
						
						}
					}else {
						isCache = true;
						isRequest = false;
					}
					
					
					lastEndpoint = endpoint;
					endpoints.add(lastEndpoint);
					
					} else if (isCache){
						int nbCache = lastEndpoint.getNbCaches();
						String[] ligneCache = ligne.split(" ");
						lastEndpoint.getCacheLatency().put(Integer.valueOf(ligneCache[0]), Integer.valueOf(ligneCache[1]));
						nbCache--;
						if(nbCache==0){
							isCache = false;
							if(nbEndpoint!=endpoints.size()){
								isEndpoint = true;
								isRequest = false;
							}else {
								isEndpoint = false;
								isRequest = true;
							}
						}else {
							isCache = true;
						}
					} else if (isRequest){
						Request request= new Request();
						
					}
					
					
					
					
					
				}
				
				
				
				
				
				
				
				
				
				
				
			
				
				System.out.println(ligne);
				chaine+=ligne+"\n";
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}

	}

}
