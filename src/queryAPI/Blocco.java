package queryAPI;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;

//https://static.javadoc.io/com.google.code.gson/gson/2.6.2/com/google/gson/JsonObject.html
// 		\-> REFERENCE REFERENCE REFERENCE REFERENCE REFERENCE 
/*
 * Questa classe � la rappresentazione JAVA di un blocco [blockchain]
 * 
 * L'idea � quella di tenere traccia di una blokchain utilizzando prima le chiamate API
 * messe a disposizione dai blockExplorer [utile per studiare le chiamate http/json in java].
 * 
 * E dopo utilizzando direttamente le chiamate RPC al daemon-wallet.
 */

/*
 * La classe blocco � la rappresentazione d
 */
/**
 * @author
 *
 */
public class Blocco {
	
	ArrayList block1=new ArrayList<>();
	Map<Object, String> block= new HashMap<Object, String>();
	
	private String hash;
	private int confirmation;
	private int size;
	private int height;
	private int version; // ????
	private String merkleroot;
	private int mint;
	private int time; // esempio--> 15092044
	private int nonce;
	private int bits;
	private float difficulty;
	private String blocktrust;
	private String chaintrust;
	private String previousHash;// hash del blocco precedente
	private String nextHash;// Hash del blocco successivo
	private String flags;// deve ammettere due tipi -> "proof-of-work"\"proof-of-stake"
	private String proofHash;// corrisponde alla soluzione, all'hash del blocco
	private String entropybit;
	private String modifier;
	private String modifierchecksum;
	private String[] tx; // hash della transazione, merkleroot

	/*
	 * Semplice costruttore 1=1
	 */
	public Blocco(String hash, int confirmation, int size, int height, int version, int time, int nonce, int bits,
			float difficulty, String previousHash, String nextHash, String flags, String proofHash, String[] tx) {

		super();
		this.hash = hash;
		this.confirmation = confirmation;
		this.size = size;
		this.height = height;
		this.version = version;
		this.time = time;
		this.nonce = nonce;
		this.bits = bits;
		this.difficulty = difficulty;
		this.previousHash = previousHash;
		this.nextHash = nextHash;
		this.flags = flags;
		this.proofHash = proofHash;
		this.tx = tx;
	}

	/*SS
	 * Il costruttore della classe Blocco prende un oggetto JSON come parametro e lo
	 * "deserializza" inserendo le informazioni nelle rispettive variabili
	 */
	public Blocco(JsonObject oggettoAPI) {
		String value = null;
		for (Object key : oggettoAPI.keySet()) {
			value = oggettoAPI.get((String) key).toString();
			value = value.replace("\"", "").replace("[", "").replace("]", "");
			block.put(key, value);	
			block1.add(block);
		}
	}

	public ArrayList getBlock1() {
		return block1;
	}

	public void setBlock1(ArrayList block1) {
		this.block1 = block1;
	}

	public void setBlock(Map<Object, String> block) {
		this.block = block;
	}

	@Override
	public String toString() {
		return "Blocco [hash=" + hash + ", confirmation=" + confirmation + ", size=" + size + ", height=" + height
				+ ", version=" + version + ", merkleroot=" + merkleroot + ", mint=" + mint + ", time=" + time
				+ ", nonce=" + nonce + ", bits=" + bits + ", difficulty=" + difficulty + ", blocktrust=" + blocktrust
				+ ", chaintrust=" + chaintrust + ", previousHash=" + previousHash + ", nextHash=" + nextHash
				+ ", flags=" + flags + ", proofHash=" + proofHash + ", entropybit=" + entropybit + ", modifier="
				+ modifier + ", modifierchecksum=" + modifierchecksum + ", tx=" + Arrays.toString(tx) + "]";
	}

	public String getMerkleroot() {
		return merkleroot;
	}

	public void setMerkleroot(String merkleroot) {
		this.merkleroot = merkleroot;
	}

	public int getMint() {
		return mint;
	}

	public void setMint(int mint) {
		this.mint = mint;
	}

	public Map getBlock() {
		return block;
	}

	public String getBlocktrust() {
		return blocktrust;
	}

	public void setBlocktrust(String blocktrust) {
		this.blocktrust = blocktrust;
	}

	public String getChaintrust() {
		return chaintrust;
	}

	public void setChaintrust(String chaintrust) {
		this.chaintrust = chaintrust;
	}

	public String getEntropybit() {
		return entropybit;
	}

	public void setEntropybit(String entropybit) {
		this.entropybit = entropybit;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public String getModifierchecksum() {
		return modifierchecksum;
	}

	public void setModifierchecksum(String modifierchecksum) {
		this.modifierchecksum = modifierchecksum;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public int getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(int confirmation) {
		this.confirmation = confirmation;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getNonce() {
		return nonce;
	}

	public void setNonce(int nonce) {
		this.nonce = nonce;
	}

	public int getBits() {
		return bits;
	}

	public void setBits(int bits) {
		this.bits = bits;
	}

	public float getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(float difficulty) {
		this.difficulty = difficulty;
	}

	public String getPreviousHash() {
		return previousHash;
	}

	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}

	public String getNextHash() {
		return nextHash;
	}

	public void setNextHash(String nextHash) {
		this.nextHash = nextHash;
	}

	public String getFlags() {
		return flags;
	}

	public void setFlags(String flags) {
		this.flags = flags;
	}

	public String getProofHash() {
		return proofHash;
	}

	public void setProofHash(String proofHash) {
		this.proofHash = proofHash;
	}

	public String[] getTx() {
		return tx;
	}

	public void setTx(String[] tx) {
		this.tx = tx;
	}

	public Blocco() {
		System.out.println("Sono un blocco vuoto :( perch� mi fai questo :'0 ");
	}

}
