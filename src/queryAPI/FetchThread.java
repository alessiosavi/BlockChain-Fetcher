package queryAPI;

import java.io.IOException;
import java.util.List;

public class FetchThread extends Thread {

	private List<Integer> list;
	private FetchAPI api = new FetchAPI();
	private BlockChain chain = new BlockChain();

	public FetchThread(List<Integer> lista) {
		setList(lista);
	}

	@Override
	public void run() {
		try {
			chain.calcola(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return the list
	 */
	public List<?> getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(List<Integer> list) {
		this.list = list;
	}

	/**
	 * @return the api
	 */
	public FetchAPI getApi() {
		return api;
	}

	/**
	 * @param api
	 *            the api to set
	 */
	public void setApi(FetchAPI api) {
		this.api = api;
	}

	/**
	 * @return the chain
	 */
	public BlockChain getBlockChain() {
		return chain;
	}

	/**
	 * @param chain
	 *            the chain to set
	 */
	public void setBlockChain(BlockChain chain) {
		this.chain = chain;
	}

}
