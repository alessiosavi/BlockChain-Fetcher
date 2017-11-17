package queryAPI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Questa classe dovrà essere un implementazione di un arraylist
 * 
 * Per rappresentare una blockchain, sceglieremo di utilizzare un metodo che, dato il numero del blocco,
 * esegue una chiamata API al sito e ritorna l'oggetto Blocco corrispondente al numero passato come parametro.
 */

public class BlockChain {
	/*
	 * Questa classe sarà l'ArrayList che conterrà la blockchain L'idea è quella di
	 * utlizzare la funzione di FetchApi-> getBlock per ottenere le informazioni
	 * relative al blocco. Una volta ottentuo l'oggetto JSON, dovremo riuscire a
	 * convertire le informazioni nei campi del blocco ######### PUO' ESSERE UTILE
	 * CREARE UN COSTRUTTORE CHE PRENDE UN OGGETTO JSON E INSERISCE LE INFO NEL
	 * BLOCCO
	 */

	/*
	 * Questa classe dovrà implementare thread e dobbiamo riuscire a trovare una
	 * struttura dati molto più efficiente sia dal punto di vista delle performance
	 * (semplici ed efficaci), sia dal punto di vista della stabilità
	 * (multithreading, sicurezza in sezione critica)
	 */

	@SuppressWarnings("rawtypes")
	private ArrayList<ArrayList> chain = new ArrayList<>();
	private ArrayList<Object> blocco = new ArrayList<>();
	public static FetchAPI api; // JsonObject
	public static Blocco oggettoJSON;

	@SuppressWarnings("unchecked")
	public BlockChain() throws IOException {

		String hash;
		api = new FetchAPI();
		int nBlocchi = 800; // api.getBlockCount();
		int nThread = 8;
		int blocchiThread = nBlocchi / nThread;
		for (int j = 0; j < nThread; j++) {
			System.out.println("#############################");
			System.out.println("#######INIZIO THREAD##########");
			System.out.println("#############################");
			for (int i = j * blocchiThread; i < blocchiThread; i++) {
				hash = api.getBlockHash(i);// prendo l'hash del blocco
				oggettoJSON = new Blocco(api.getBlock(hash));
				blocco = oggettoJSON.getBlock1();
				chain.add(i, blocco);// aggiungo alla chain[nell'indice i] il blocco ottenuto // usando il
										// costruttore
				System.out.println("BLOCK " + i); // della classe blocco sul oggetto JsonObject ottentuto dalla chiamata
													// API.
				System.out.println(chain.get(i).toString());
				System.out.println("\n");
			}
		}

	}

	public ArrayList<ArrayList> getChain() {
		return chain;
	}

	public void setChain(ArrayList<ArrayList> chain) {
		this.chain = chain;
	}

	public ArrayList<Object> getBlocco() {
		return blocco;
	}

	public void setBlocco(ArrayList<Object> blocco) {
		this.blocco = blocco;
	}

	public static FetchAPI getApi() {
		return api;
	}

	public static void setApi(FetchAPI api) {
		BlockChain.api = api;
	}

	public static Blocco getOggettoJSON() {
		return oggettoJSON;
	}

	public static void setOggettoJSON(Blocco oggettoJSON) {
		BlockChain.oggettoJSON = oggettoJSON;
	}


}
