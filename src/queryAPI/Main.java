package queryAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

}
