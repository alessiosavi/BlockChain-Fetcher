package queryAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static BlockChain chain;
	public static Scanner reader;// Reading from System.in
	static int nBlocchi;
	public static int nThread=8;

	public void startVecchio() throws IOException {
		Main main = new Main();
		main.gui();
		boolean check = false;
		while (!check) {
			nBlocchi = main.getInputNBlocchi();
			// reader = new Scanner(System.in);
			// nBlocchi = reader.nextInt();
			chain = new BlockChain(nBlocchi);
			check = true;
		}

	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.gui();
		boolean check = false;
		while (!check) {
			nBlocchi = main.getInputNBlocchi();
			// reader = new Scanner(System.in);
			// nBlocchi = reader.nextInt();
			main.StartThread(nBlocchi, nThread);
			check = true;
		}

	}

	public int getInputNBlocchi() throws IOException {
		boolean lock = false;
		String temp = null;

		while (!lock) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			temp = br.readLine();
			if (temp.equals("")) {
				System.out.println("Verranno Scaricati 20 blocchi [default]");
				nBlocchi = 20;
				lock = true;
			} else if (isStringInt(temp)) {
				System.out.println("Verranno Scaricati " + Integer.parseInt(temp) + " blocchi");
				nBlocchi = Integer.parseInt(temp);
				lock = true;
			}
		}
		return nBlocchi;

	}

	public boolean isStringInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException ex) {
			System.out.println("Perchè mi fai questo :(");
			return false;
		}
	}

	public ArrayList<List<Integer>> dividiBlocchi(int nBlocchi, int nThread) {

		int nextThread = 0;
		ArrayList<List<Integer>> listOfLists = new ArrayList<>();
		for (int i = 0; i < nThread; i++) {
			listOfLists.add(new ArrayList<>());
		}
		for (int i = 0; i < nBlocchi; i++) {
			listOfLists.get(nextThread).add(i);
			if (nextThread == (nThread - 1)) {
				nextThread = 0;
			} else {
				nextThread++;
			}
		}

		return listOfLists;
	}

	public void StartThread(int nBlocchi, int nThread) {
		chain=new BlockChain();
		ArrayList<List<Integer>> listOfLists = dividiBlocchi(nBlocchi, nThread);
		List<FetchThread> listOfThread = new ArrayList<>();
		for (int i = 0; i < nThread; i++) {
			listOfThread.add(new FetchThread(listOfLists.get(i)));
			listOfThread.get(i).run();
		}
		System.out.println("ORA CRASHA MA VA BENE UGUALE !!");
		for (int i = 0; i < nThread; i++) {
			// chain.setChain(chain.getChain().add((Blocco)
			// listOfThread.get(i).getChain().getChain()));
			chain.concatChain(listOfThread.get(i).getBlockChain().getChain());
		}

	}
	/*
	 * listOfT = new List<MioThread> listoflist = dividi(nb, nt) for nt
	 * listOfT.add(new MioT(listOflist.get(nt))) listOfT.get(nT).run()
	 * 
	 * 
	 * ...
	 * 
	 * for nt getChain
	 * 
	 */

	public void gui() {
		System.out.println("####################################################");
		System.out.println("####   FETCHAIN!## V-0.0.01, STILL LEARNING (:\t####");
		System.out.println("####   Inserire numero di blocchi da scaricare\t####");
		System.out.println("####   \t     \\->[20 blocchi default]<-/\t\t####");
		System.out.println("####################################################");

	}

}
