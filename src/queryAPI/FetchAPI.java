package queryAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

//hash -> 00000000c55a663c30e69d208049c680ccbfe97e4ebea4b1339e70af156eb368
// api -> getblock?hash=
//http://framechain.ddns.net/api/getblock?hash=
//00000000c55a663c30e69d208049c680ccbfe97e4ebea4b1339e70af156eb368

//Questa classe ha il compito di chiamare le API del sito e ritornare un JsonObject.

//Spetterà ad un'altra classe il compito di "decodificare" l'oggetto json nell'apposita classe Blocco
public class FetchAPI {

	private static String link = "http://framechain.ddns.net/api/";
	private static String apiGetBlockHASH = "getblock?hash=";
	private static String apiGetBlockNUMBER = "getblockhash?index=";
	private static String apiGetBlockCOUNT = "getblockcount";
	public static String getLink() {
		return link;
	}

	public static void setLink(String link) {
		FetchAPI.link = link;
	}

	public static String getApiGetBlockHASH() {
		return apiGetBlockHASH;
	}

	public static void setApiGetBlockHASH(String apiGetBlockHASH) {
		FetchAPI.apiGetBlockHASH = apiGetBlockHASH;
	}

	public static String getApiGetBlockNUMBER() {
		return apiGetBlockNUMBER;
	}

	public static void setApiGetBlockNUMBER(String apiGetBlockNUMBER) {
		FetchAPI.apiGetBlockNUMBER = apiGetBlockNUMBER;
	}

	public static String getApiGetBlockCOUNT() {
		return apiGetBlockCOUNT;
	}

	public static void setApiGetBlockCOUNT(String apiGetBlockCOUNT) {
		FetchAPI.apiGetBlockCOUNT = apiGetBlockCOUNT;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public HttpURLConnection getRequest() {
		return request;
	}

	public void setRequest(HttpURLConnection request) {
		this.request = request;
	}

	public BufferedReader getBuf() {
		return buf;
	}

	public void setBuf(BufferedReader buf) {
		this.buf = buf;
	}

	// public static String hash =
	// "00000000c55a663c30e69d208049c680ccbfe97e4ebea4b1339e70af156eb368";
	private URL url;
	private HttpURLConnection request = null;
	private BufferedReader buf;

	/**
	 * @param blockNumber ->> numbero intero del blocco di cui si deve trovare l'hash
	 * @return String ->> HASH del blocco
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

	public String getBlockHash(int blockNumber) throws IOException {
		String contenent = null;
		url = new URL(link + "" + apiGetBlockNUMBER + "" + blockNumber);
		try {
			request = (HttpURLConnection) url.openConnection();
			request.connect();
			buf = new BufferedReader(new InputStreamReader((InputStream) request.getContent()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// La chiamata API restituisce solamente una stringa, contenente l'HASH del blocco.
		contenent = buf.readLine().toString();
		return contenent;
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
			request.connect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Convert to a JSON object to print data
		JsonParser jp = new JsonParser(); // from gson
		JsonElement root = null;
		try {
			root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
		} catch (IOException e) {
			e.printStackTrace();
		} // Convert the input
			// stream to a json
			// element
		JsonObject oggetto = root.getAsJsonObject();
		return oggetto;
	}

	public int getBlockCount() throws IOException {
		url = new URL(link + "" + apiGetBlockCOUNT);
		String contenent;
		try {
			request = (HttpURLConnection) url.openConnection();
			request.connect();
			buf = new BufferedReader(new InputStreamReader((InputStream) request.getContent()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		contenent = buf.readLine().toString();
		//System.out.println(contenent +" ");
		int temp=Integer.parseInt(contenent);
		return temp;
	}
}
