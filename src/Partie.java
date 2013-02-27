import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Partie {
	
	public Partie(int nbJoueurs){
		this.quitter = false;
		this.nbJoueurs = nbJoueurs;
	}
	
	public Partie(int nbJoueurs, Plateau plateau, char type){
		this.quitter = false;
		this.nbJoueurs = nbJoueurs;
		this.type = type;
		this.joueurs = new ArrayList<Joueur>();
		this.initialiserJoueurs(plateau);		
	}
	
	private void initialiserJoueurs(Plateau plateau){		
		Joueur joueur1 = null;
		Joueur joueur2 = null;
		Joueur joueur3 = null;
		Joueur joueur4 = null;
				
		for(int i = 1; i <= this.nbJoueurs; i++){
			String prenom = "";
			Scanner scan = new Scanner(System.in);
			System.out.println("Joueur numero " + i + ", saisissez votre prenom :");
			prenom = scan.nextLine();
			if (i == 1){
				joueur1 = new Joueur(prenom, plateau, 1);
				this.joueurs.add(joueur1);
			}
			else if (i == 2){
				joueur2 = new Joueur(prenom, plateau, 3);
				this.joueurs.add(joueur2);
			}
			else if (i == 3){
				joueur3 = new Joueur(prenom, plateau, 2);
				this.joueurs.add(joueur3);
			}
			else if (i == 4){
				joueur4 = new Joueur(prenom, plateau, 4);
				this.joueurs.add(joueur4);
			}
			prenom = "";
		}
		
		System.out.println("\n#####################################################");		
		System.out.println("Les joueurs sont initalises, la partie peut commencer");
		System.out.println("#####################################################\n\n");
	}
	
	public void quitter(){
		this.quitter = true;
	}
	
	public boolean quitte(){
		return this.quitter;
	}
	
	public int getNbJoueurs(){
		return this.nbJoueurs;
	}
	
	private boolean leJoueurAGagne(Joueur leJoueur){
		boolean fini = true;
		ArrayList<Pion> pions = leJoueur.getPions();
		for(int i = 0; i < pions.size(); i++){
			if(!(pions.get(i).getCase() instanceof CaseTerminee))
				fini = false;
		}
		return fini;
	}
	
	public boolean unJoueurAGagner(){
		boolean fini = false;
		for(int i = 0; i < this.joueurs.size(); i++){
			if(this.leJoueurAGagne(this.joueurs.get(i)))
				fini = true;
		}
		return fini;
	}
	
	public Joueur getJoueurGagnant(){
		for(int i = 0; i < this.nbJoueurs; i++){
			if(this.leJoueurAGagne(this.joueurs.get(i)))
				return this.joueurs.get(i);
		}
		return null;
	}
	
	private boolean laPartieEstAutomatique(){
		return this.type == 'a';
	}
	
	public void jouer(Plateau plateau){
		int pion = 0, de = 1;
		for(int i = 0; i < this.nbJoueurs; i++){			
			do{
				de = this.joueurs.get(i).lanceLeDe();
				this.afficherDe(de);
				if(this.laPartieEstAutomatique()){
					pion = this.partieAutomatique(i, de);
				}else{
					pion = this.partieManuelle(i);
				}
				
				if(pion == 1 || pion == 2)
					this.joueurs.get(i).getPionRapide(pion).avancer(de, plateau, this.joueurs.get(i));	
				else
					this.joueurs.get(i).getPionDestructeur(pion - 2).avancer(de, plateau, this.joueurs.get(i));
				
				this.afficherEtatDesPions();
				
				System.out.println("\n\nLancer de des no : "+ ++this.compteur);
			}while(de == 6 && !this.unJoueurAGagner());
		}
	}
	
	private void afficherDe(int de){
		System.out.println("########   #######");
		System.out.println("#      #   #     #");
		System.out.println("#  de  #   #  "+ de +"  #");
		System.out.println("#      #   #     #");
		System.out.println("########   #######");
	}
	
	private void afficherEtatDesPions(){
		System.out.println("\n###################### POSITIONS ####################");
		for (int a=1;a<=this.nbJoueurs;a++){
			for(int j=1;j<=2;j++){
				if(!(this.joueurs.get(a-1).getPionRapide(j).getCase() instanceof CaseTerminee)){
					if(this.joueurs.get(a-1).getPionRapide(j).getCase() instanceof CaseRampe)
						System.out.println(j+") "+this.joueurs.get(a-1).getNom() + " Pion Rapide sur la RAMPE : " + this.joueurs.get(a-1).getPionRapide(j).getCase().getPosition());
					else
						System.out.println(j+") "+this.joueurs.get(a-1).getNom() + " Pion Rapide : " + this.joueurs.get(a-1).getPionRapide(j).getCase().getPosition());
				}
			}
			for(int j=1;j<=2;j++){
				if(!(this.joueurs.get(a-1).getPionDestructeur(j).getCase() instanceof CaseTerminee)){
					if(this.joueurs.get(a-1).getPionDestructeur(j).getCase() instanceof CaseRampe)
						System.out.println(j+") "+this.joueurs.get(a-1).getNom() + " Pion Destructeur sur la RAMPE : " + this.joueurs.get(a-1).getPionDestructeur(j).getCase().getPosition());
					else
						System.out.println(j+") "+this.joueurs.get(a-1).getNom() + " Pion Destructeur : " + this.joueurs.get(a-1).getPionDestructeur(j).getCase().getPosition());
				}
			}
			System.out.println("--> "+this.joueurs.get(a-1).getNom()+" case d'arrivee numero : "+this.joueurs.get(a-1).getCaseArrivee().getPosition()+"\n");
		}
		System.out.println("################# FIN DES POSITIONS #################");
	}
	
	private int partieManuelle(int i){
		Scanner scan = new Scanner(System.in);
		int pion = 1;
		System.out.println(this.joueurs.get(i).getNom() + " : Choisissez votre pion a jouer (1,2,3,4) :");
		try{ 
		   pion = scan.nextInt(); 
		} 
		catch(InputMismatchException ime){ 
			System.out.println("\nValeur saisie non numerique ou hors des limites int");
		}
		
		if(pion < 1) pion = 1;
		else if(pion > 4) pion =4;
		return pion;
	}
	
	private int partieAutomatique(int i, int de){
		if(this.joueurs.get(i).getPionRapide(1).getCase() instanceof CaseRampe)
			return 1;
		else if(this.joueurs.get(i).getPionRapide(2).getCase() instanceof CaseRampe)
			return 2;
		else if(this.joueurs.get(i).getPionDestructeur(1).getCase() instanceof CaseRampe)
			return 3;
		else if(this.joueurs.get(i).getPionDestructeur(2).getCase() instanceof CaseRampe)
			return 4;
		
		if(this.joueurs.get(i).getPionRapide(1).getCase() == this.joueurs.get(i).getCaseDepart() && de == 6)
			return 1;
		else if(this.joueurs.get(i).getPionRapide(2).getCase() == this.joueurs.get(i).getCaseDepart() && de == 6)
			return 2;
		else if(this.joueurs.get(i).getPionDestructeur(1).getCase() == this.joueurs.get(i).getCaseDepart() && de == 6)
			return 3;
		else if(this.joueurs.get(i).getPionDestructeur(2).getCase() == this.joueurs.get(i).getCaseDepart() && de == 6)
			return 4;
		
		if(!(this.joueurs.get(i).getPionRapide(1).getCase() instanceof CaseTerminee))
			return 1;
		else if(!(this.joueurs.get(i).getPionRapide(2).getCase() instanceof CaseTerminee))
			return 2;
		else if(!(this.joueurs.get(i).getPionDestructeur(1).getCase() instanceof CaseTerminee))
			return 3;
		else
			return 4;
	}
	
	private char type;					//	permet de définir si le jeu joue tout seul ou avec une interaction de l'utilisateur
	private int compteur;				//	permet de compter le nombre de lancés de dés
	private ArrayList<Joueur> joueurs;	//	contient tous les joueurs de la partie et permet de les faire jouer chacun leur tour
	private boolean quitter;			//	amélioration non codée qui permettrai de terminer prématurément la partie
	private int nbJoueurs;				//	permet d'initialiser le nombre de joueurs dans le tableau de joueurs
}
