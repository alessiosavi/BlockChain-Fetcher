package queryAPI;

import java.io.IOException;

import com.google.gson.JsonObject;

public class Main {

	public static FetchAPI getBlock; //JsonObject
	public static JsonObject oggettoJSON;
	public static Blocco blocco;
	public static BlockChain chain;
	public static void main(String[] args) throws IOException {
			
		//La classe FetchAPI ha un costruttore che inizializza i parametri della chiamata GET HTTP, 
		// e ritorna un oggetto JsonObject (gson) con del tipo (chiave,valore)
		//	|
		/*	\->	*/ getBlock=new FetchAPI();
				
		/*
		 * questo specifico passaggio non so quanto può essere utile,
		 * getBlock è già un oggetto JSON.		
		 */
		oggettoJSON=getBlock.getJSON();
		//System.out.println(oggettoJSON);
		//chain=new BlockChain();
		/*
		 * L'oggetto JSON verrà dato in pasto al costruttore, che provvederà a instanziare
		 * la classe Blocco con tutti i parametri.
		 */
		blocco=new Blocco(oggettoJSON);
	}

	
}
