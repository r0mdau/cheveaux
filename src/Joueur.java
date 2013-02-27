import java.util.ArrayList;

public class Joueur {
	public Joueur(String nom){
		this.nom = new String(nom);
	}
	
	public Joueur(String nom, Plateau plateau, int numero){
		this.nom = new String(nom);
		this.numero = numero;
		
//		Chaque joueur est initialise a 13 cases d'ecarts
		this.caseDepart = plateau.getCaseTrajet(43 - ((this.numero-1) * 13));
		this.caseArrivee = plateau.getCaseTrajet(42 - ((this.numero-1) * 13));
		
		this.caseRampe = new ArrayList<CaseRampe>();
		this.initialiserCasesRampe();
		
		this.pions = new ArrayList<Pion>();
		this.initialiserPionsDuJoueur();
	}
	
	private void initialiserCasesRampe() {
		for(int i = 0; i <= 4 ; i++){
			this.caseRampe.add(new CaseRampe(i));
		}
	}
	
	private void initialiserPionsDuJoueur(){
		for(int i = 0; i<2; i++)
			this.pions.add(new PionDestructeur(this.caseDepart, this));
		for(int i = 0; i<2; i++)
			this.pions.add(new PionRapide(this.caseDepart, this));
	}
	
	public int lanceLeDe(){
		return De.lancer();
	}
	
	public String getNom(){
		return this.nom;
	}
	
	public Case getCaseDepart(){
		return this.caseDepart;
	}
	
	public Case getCaseArrivee(){
		return this.caseArrivee;
	}
	
	public CaseRampe getCaseRampe(int indice){
		return this.caseRampe.get(indice);
	}
	
	public Pion getPionDestructeur(int indice){
		return this.pions.get(indice - 1);
	}
	
	public Pion getPionRapide(int indice){
		return this.pions.get(indice + 1);
	}
	
	public ArrayList<Pion> getPions(){
		return this.pions;
	}
	
	private String nom;	
	private int numero; 					//	chaque joueur est identifié à l'aide d'un numéro unique allant de 1 à 4
	private ArrayList<Pion> pions; 			//	Les deux premiers <Pion> sont des pions destructeurs, les deux derniers des pions rapides				
	private CaseTrajet caseDepart; 			//	Permet d'identifier si le pion du joueur est sur sa case de départ
	private CaseTrajet caseArrivee; 		//	Meme raison que caseDepart
	private ArrayList<CaseRampe> caseRampe; //	Chaque joueur possède sa propre rampe pour que le pion finisse sa course
}