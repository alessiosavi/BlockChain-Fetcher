package queryAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

//hash -> 00000000c55a663c30e69d208049c680ccbfe97e4ebea4b1339e70af156eb368
// api -> getblock?hash=
//http://framechain.ddns.net/api/getblock?hash=
//00000000c55a663c30e69d208049c680ccbfe97e4ebea4b1339e70af156eb368


//Questa classe ha il compito di chiamare le API del sito e ritornare un JsonObject.

//Spetterà ad un'altra classe il compito di "decodificare" l'oggetto json nell'apposita classe Blocco
public class FetchAPI {
	
	public static String link = "http://framechain.ddns.net/api/";
	public static String apiGetBlockHASH = "getblock?hash=";
	public static String apiGetBlockNUMBER="/getblockhash?index=";
	//public static String hash = "00000000c55a663c30e69d208049c680ccbfe97e4ebea4b1339e70af156eb368";
	private URL url;
	private HttpURLConnection request=null;
	
	public FetchAPI() {
		
	}

	
	//QUESTA RESTITUISCE SOLAMENTE L'HASH DEL BLOCCO, IL RISULTATO (una stringa)  DEVE ESSERE DATO IN PASTO AL
	// METODO SCRITTO PIù IN BASSO
	public JsonObject getJSON(int blockNumber) throws MalformedURLException {
		url = new URL(link + "" + apiGetBlockNUMBER + "" + blockNumber);
		try {
			request = (HttpURLConnection) url.openConnection();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		try {
			request.connect();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// Convert to a JSON object to print data
		JsonParser jp = new JsonParser(); // from gson
		JsonElement root = null;
		try {
			root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // Convert the input
																								// stream to a json
																								// element
		JsonObject oggetto = root.getAsJsonObject(); 
		return oggetto;
	}
	
	
	
	public JsonObject getJSON(String hash) throws MalformedURLException {
		url = new URL(link + "" + apiGetBlockHASH + "" + hash);
		try {
			request = (HttpURLConnection) url.openConnection();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		try {
			request.connect();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// Convert to a JSON object to print data
		JsonParser jp = new JsonParser(); // from gson
		JsonElement root = null;
		try {
			root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
		} catch (JsonIOException e) {
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} // Convert the input
																								// stream to a json
																								// element
		JsonObject oggetto = root.getAsJsonObject(); 
		return oggetto;
	}

}
