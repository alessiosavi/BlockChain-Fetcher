package queryAPI;


import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;


/*
 * Questa classe dovrà essere un implementazione di un arraylist
 * 
 * Per rappresentare una blockchain, sceglieremo di utilizzare un metodo che, dato il numero del blocco,
 * esegue una chiamata API al sito e ritorna l'oggetto Blocco corrispondente al numero passato come parametro.
 */
public class BlockChain  {
	/*
	 * Questa classe sarà l'ArrayList che conterrà la blockchain
	 * L'idea è quella di utlizzare la funzione di FetchApi-> getBlock per ottenere le informazioni
	 * relative al blocco. Una volta ottentuo l'oggetto JSON, dovremo riuscire a convertire le informazioni
	 * nei campi del blocco 
	 * ######### PUO' ESSERE UTILE CREARE UN COSTRUTTORE CHE PRENDE UN OGGETTO JSON E INSERISCE LE INFO NEL BLOCCO
	 */
	private List<Blocco> chain = new ArrayList<Blocco>();
	private Blocco blocco=new Blocco();

	
	
	
	public BlockChain() throws MalformedURLException{
		
		
		
	}
	

	public Blocco getBlocco() {
		return blocco;
	}

	public void setBlocco(Blocco blocco) {
		this.blocco = blocco;
	}


	/**
	 * @return the chain
	 */
	public List<Blocco> getChain() {
		return chain;
	}


	/**
	 * @param chain the chain to set
	 */
	public void setChain(List<Blocco> chain) {
		this.chain = chain;
	}
	

	
	
	
	
	
	
}
