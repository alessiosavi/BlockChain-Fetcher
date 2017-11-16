package queryAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


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
	public static String apiGetBlockNUMBER = "/getblockhash?index=";
	// public static String hash =
	// "00000000c55a663c30e69d208049c680ccbfe97e4ebea4b1339e70af156eb368";
	private URL url;
	private HttpURLConnection request = null;
	private BufferedReader buf;

	/**
	 * @param blockNumber
	 *            -> numbero intero del blocco di cui si deve trovare l'hash
	 * @return String -> HASH del blocco
	 * @throws IOException
	 * 
	 *             - Il metodo prende come parametro il numero del blocco e apre una
	 *             connessione con il sito. - L'url è formato dal link sito +
	 *             chiamata API + parametro da cercare. - La chiamata API non
	 *             necessita di particolari accorgimenti, in quanto ritorna una
	 *             singola linea contenente l'hash del blocco inserito come
	 *             parametro. [DEBUG ON] -> Il metodo non restituisce una stringa,
	 *             ma un oggetto utilizzasto per testare la corretta esecuzione.
	 */
	public JsonObject getBlockHash(int blockNumber) throws IOException {
		System.out.println("getBlockHash iniziato");
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
		String contenent = null;
		try {
			buf = new BufferedReader(new InputStreamReader((InputStream) request.getContent()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Sono getBlockHash");
		contenent = buf.readLine().toString();
		System.out.println(contenent);
		JsonObject ogg = getBlock(contenent);
		return ogg;
	}

	/**
	 * @param hash
	 *            -> HASH del blocco
	 * @return JsonObjecct -> Oggetto Json(gson) da decodificare in BLOCCO
	 * @throws MalformedURLException
	 * 
	 *             - Il metodo prende come parametro l'hash del blocco, ed effutta
	 *             una chiamata API per ricevere le informazioni del blocco in
	 *             formato Json. L'oggetto Json ottenuto andrà poi dato in pasto
	 *             alla classe Blocco, che provvederà a creare il blocco vero e
	 *             proprio.
	 * 
	 */
	public JsonObject getBlock(String hash) throws MalformedURLException {
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
