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

	private List<Object> chain = new ArrayList<Object>();
	public static FetchAPI api = new FetchAPI(); // <<- Si occupa di prendere i blocchi tramite API [restituisce Oggetto
													// JSON
	int nBlocchi = 20;// api.getBlockCount();
	int nThread = 8; // non utilizzata!!
	int blocchiThread = nBlocchi / nThread;
	public static Blocco blocco;

	public BlockChain(int n) throws IOException {
		for (int i = 0; i < n; i++) {
			chain.add(new Blocco(api.getBlock(i)));
			System.out.println("/-> BLOCK " + i + "<-\\");
			System.out.println(chain.get(i));
		}
		printChain();
	}

	public void printChain() {
		int i = 0;
		stampa("INIZIO STAMPA CHAIN [stmp1]");
		for (Object b : chain) {
			System.out.println(i + ") " + b.toString());
			i++;
		}
		stampa("FINE STAMPA CHAIN COMPLETA [stmp1]");

	}

	public void stampa(String Stringa) {
		System.out.println("#############################");
		System.out.println("#######" + nThread + "##########");
		System.out.println("#############################");
	}

}
