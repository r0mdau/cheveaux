import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		int nbJoueurs = 0;
		String type = null;
		Scanner scan = new Scanner(System.in);

		System.out.print("Saisissez le nombre de joueurs (4 max) :");
		try { 
		   nbJoueurs = scan.nextInt(); 
		} 
		catch(InputMismatchException ime){ 
			System.out.println("\nValeur saisie non numerique ou hors des limites int");
		}
		if (nbJoueurs<2) nbJoueurs=2;
		else if (nbJoueurs>4) nbJoueurs=4;
		
		
		System.out.println("Partie automatique ou manuelle ? (a/m)");
		scan.nextLine();
		type = scan.nextLine();
		char carac = type.charAt(0);
		if(carac != 'a' && carac != 'm') carac = 'm';
		
		Plateau plateau = new Plateau();
		Partie partie = new Partie(nbJoueurs, plateau, carac);
		
		do{	
			partie.jouer(plateau);
		}while(!partie.unJoueurAGagner());
		System.out.println("\n\nBravo a "+partie.getJoueurGagnant().getNom()+" pour avoir remporte la partie du jeu des petits cheveaux !");
	}
}
