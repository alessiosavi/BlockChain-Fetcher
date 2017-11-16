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
	 * 
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
