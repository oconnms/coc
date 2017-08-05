package com.lurch.coc;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.ws.http.HTTPException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class cocInterface {
	// Inspiration from ::: Created by Sa-muel Lo-pes Ma-strofr-ancisco - sa-muellm@l-ive.com 
	private static String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjU2ZGZhODcwLTMzNTEtNDRiZS1hNWNjLTkyY2UxNTg0NDY3OCIsImlhdCI6MTUwMTQxNTYwOSwic3ViIjoiZGV2ZWxvcGVyLzRmMTdiYzFkLWEzNDctZjEzNi01NzNkLTkwNjFhMmY4ZjhkNiIsInNjb3BlcyI6WyJjbGFzaCJdLCJsaW1pdHMiOlt7InRpZXIiOiJkZXZlbG9wZXIvc2lsdmVyIiwidHlwZSI6InRocm90dGxpbmcifSx7ImNpZHJzIjpbIjg2LjE1Ny45Ni4xNTEiXSwidHlwZSI6ImNsaWVudCJ9XX0._qO8P82rJG4wuyYmmqiwXoX8J3YNbL4UmMWqrXNWpxvMbkHXX-3AgAkpCLUpdQ1qzvwBYLkHTts4rIBRTbZjVA";

	public static void main(String[] args) {
		// getClansByParameters("Round Table II", null, null, null, null, null, null, null, null);
		getClansByTag("#V8YL2UL");
		// getLeagues();
	}
	
	public static String getClansByTag(String clanTag){
		try {
			String strUrl = "https://api.clashofclans.com/v1/clans/"+clanTag.replace("#", "%23");
			
			
            URL url = new URL (strUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Bearer " + token);
            connection.setRequestProperty("Accept", "application/json");
                        
            InputStream content = (InputStream)connection.getInputStream();
            BufferedReader in = new BufferedReader (new InputStreamReader (content));
            
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(in.readLine());
            String prettyJsonString = gson.toJson(je);
            System.out.println(prettyJsonString);
            
            connection.disconnect();
            
            return "1";
        } catch(HTTPException he){
        	he.printStackTrace();
        	return "null";
        } catch(Exception e){
        	e.printStackTrace();
        	return null;
        }
	}
	
	public static String getClanMembersByTag(String clanTag){
		try {
			String strUrl = "https://api.clashofclans.com/v1/clans/"+clanTag.replace("#", "%23")+"/members";
			
			
            URL url = new URL (strUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Bearer " + token);
            connection.setRequestProperty("Accept", "application/json");
                        
            InputStream content = (InputStream)connection.getInputStream();
            BufferedReader in = new BufferedReader (new InputStreamReader (content));
            
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(in.readLine());
            String prettyJsonString = gson.toJson(je);
            System.out.println(prettyJsonString);
            
            connection.disconnect();
            
            return "1";
        } catch(HTTPException he){
        	he.printStackTrace();
        	return "null";
        } catch(Exception e){
        	e.printStackTrace();
        	return null;
        }
	}

}
