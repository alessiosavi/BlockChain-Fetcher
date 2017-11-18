package queryAPI;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {


	public static BlockChain chain;
	public static Scanner reader;// Reading from System.in
	static int nBlocchi=20;
	
	public static void main(String[] args) {
		boolean check = false;
		System.out.println("##FETCHAIN!## V-0.0.01, STILL LEARNING (: ");
		System.out.println("Inserire numero di blocchi da scaricare:");
		System.out.println("[20 blocchi default]");
		while (!check) {
			try {
				reader = new Scanner(System.in);
				nBlocchi = reader.nextInt();
				chain = new BlockChain(nBlocchi);
				check=true;
			} catch (InputMismatchException | IOException io) {
				System.out.println("Perchè mi fai questo? :(");
			}
		}
	}

}
