package queryAPI;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;

//https://static.javadoc.io/com.google.code.gson/gson/2.6.2/com/google/gson/JsonObject.html
// 		\-> REFERENCE REFERENCE REFERENCE REFERENCE REFERENCE 
/*
 * Questa classe è la rappresentazione JAVA di un blocco [blockchain]
 * 
 * L'idea è quella di tenere traccia di una blokchain utilizzando prima le chiamate API
 * messe a disposizione dai blockExplorer [utile per studiare le chiamate http/json in java].
 * 
 * E dopo utilizzando direttamente le chiamate RPC al daemon-wallet.
 */

/*
 * La classe blocco è la rappresentazione d
 */
/**
 * @author
 *
 */
public class Blocco {

	Map<String, String> blocco = new HashMap<String, String>();
	/*
	 * private String hash; private int confirmation; private int size; private int
	 * height; private int version; // ???? private String merkleroot; private int
	 * mint; private int time; // esempio--> 15092044 private int nonce; private int
	 * bits; private float difficulty; private String blocktrust; private String
	 * chaintrust; private String previousHash;// hash del blocco precedente private
	 * String nextHash;// Hash del blocco successivo private String flags;// deve
	 * ammettere due tipi -> "proof-of-work"\"proof-of-stake" private String
	 * proofHash;// corrisponde alla soluzione, all'hash del blocco private String
	 * entropybit; private String modifier; private String modifierchecksum; private
	 * String[] tx; // hash della transazione, merkleroot
	 */
	/*
	 * Semplice costruttore 1=1
	 */

	/*
	 * Il costruttore della classe Blocco prende un oggetto JSON come parametro.
	 * Ogni coppia di informazioni è salvata in una mappa [che costituisce il
	 * "Blocco" stesso]
	 */

	public Blocco(JsonObject oggettoAPI) {
		String value = null;
		System.out.println(oggettoAPI);
		// key -> [hash,time,diff ecc..] value -> [034e32sf3,UnixTime(?), ecc..]
		for (Object key : oggettoAPI.keySet()) {
			value = oggettoAPI.get((String) key).toString();
			value = value.replace("\"", "").replace("[", "").replace("]", "");
			blocco.put((String) key, value);
		}
	}

	public boolean stampaBlocco() {
		for (Object obj : blocco.keySet()) {
			System.out.println(obj);
		}

		return true;
	}

	public Map<String, String> getBlocco() {
		return blocco;
	}

	public void setBlocco(Map<String, String> blocco) {
		this.blocco = blocco;
	}

	@Override
	public String toString() {
		return "Blocco [blocco=" + blocco + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}