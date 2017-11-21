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

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		boolean check = false;
		main.gui();
		while (!check) {
			nBlocchi = main.getInputNBlocchi();
			// reader = new Scanner(System.in);
			// nBlocchi = reader.nextInt();
			chain = new BlockChain(nBlocchi);
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

	public void gui() {
		System.out.println("####################################################");
		System.out.println("####   FETCHAIN!## V-0.0.01, STILL LEARNING (:\t####");
		System.out.println("####   Inserire numero di blocchi da scaricare\t####");
		System.out.println("####   \t     \\->[20 blocchi default]<-/\t\t####");
		System.out.println("####################################################");

	}
	
	public ArrayList<List<Integer>> dividiblocchi (int nBlocchi){
		//per 8 thread;
		int nextThread = 0;
		List<Integer> t0 = new ArrayList<>();
		List<Integer> t1 = new ArrayList<>();
		List<Integer> t2 = new ArrayList<>();
		List<Integer> t3 = new ArrayList<>();
		List<Integer> t4 = new ArrayList<>();
		List<Integer> t5 = new ArrayList<>();
		List<Integer> t6 = new ArrayList<>();
		List<Integer> t7 = new ArrayList<>();
		ArrayList<List<Integer>> listaDiListe = new ArrayList<>();
		
		
		for (int i=0; i<nBlocchi; i++) {
			switch (nextThread) {
			case 0:
				nextThread = 1;
				t0.add(i);
				break;
			case 1:
				nextThread = 2;
				t1.add(i);
				break;
			case 2:
				nextThread = 3;
				t2.add(i);
				break;
			case 3:
				nextThread = 4;
				t3.add(i);
				break;
			case 4:
				nextThread = 5;
				t4.add(i);
				break;
			case 5:
				nextThread = 6;
				t5.add(i);
				break;
			case 6:
				nextThread = 7;
				t6.add(i);
				break;
			case 7:
				nextThread = 0;
				t7.add(i);
				break;
			}	
		}
		
		listaDiListe.add(t0);
		listaDiListe.add(t1);
		listaDiListe.add(t2);
		listaDiListe.add(t3);
		listaDiListe.add(t4);
		listaDiListe.add(t5);
		listaDiListe.add(t6);
		listaDiListe.add(t7);
		
		return listaDiListe;
		
		
	}

}
