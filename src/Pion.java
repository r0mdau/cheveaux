
public abstract class Pion {
	public Pion(){
		this.tour = false;
	}
	
	public Case getCase(){
		return this.maCase;
	}
	
	abstract public void avancer(int de, Plateau plateau, Joueur leJoueur);
	
	public Joueur getJoueur(){
		return this.leJoueur;
	}
	
	protected void setCase(Case laCase){
		this.maCase = laCase;
	}
	
	protected int remetCompteurAuDebut(int position){
		if(position > 51){
			this.tour = true;
			return position - 52;
		}else if(position < 0){
			this.tour = false;
			return position + 52;
		}
		else return position;
	}
	
	protected void remetPionAuDebut(){
		this.tour = false;
		this.maCase.setPion(null);
		this.maCase = leJoueur.getCaseDepart();
	}
	
	protected boolean lePionNEstPasSortiDeLEcurie(Joueur leJoueur){
		return this.maCase == leJoueur.getCaseDepart();
	}
	
	protected boolean lePionNEstPasSurLaCaseDepart(Joueur leJoueur){
		return this.maCase != leJoueur.getCaseDepart();
	}
	
	protected boolean lePionRisqueDepasserLaCaseArrivee(Joueur leJoueur, Plateau plateau, int position){
		if(this.tour)
			return plateau.getCaseTrajet(position).getPosition() > leJoueur.getCaseArrivee().getPosition();
		return false;
	}
	
	protected boolean lePionAFiniSaCourseTrajet(Joueur leJoueur){
		return this.maCase == leJoueur.getCaseArrivee();
	}
	
	protected boolean lePionEstSurLaRampe(){
		return this.maCase instanceof CaseRampe;
	}
	
	protected void monterSurRampe(int de, Joueur leJoueur){
		if(de == 1){
			leJoueur.getCaseArrivee().setPion(null);
			this.maCase = leJoueur.getCaseRampe(0);
			leJoueur.getCaseRampe(0).setPion(this);
		}
		else{
			System.out.println("Votre pion ne peut pas monter sur la rampe.");
		}			
	}
	
	protected void avancerSurRampe(int de, Joueur leJoueur, Plateau plateau){
		if(de == 6){
			if(this.maCase == leJoueur.getCaseRampe(4)){
				leJoueur.getCaseRampe(3).setPion(null);
				this.setCase(plateau.getCaseTerminee());
				plateau.getCaseTerminee().setPion(this);
			}
		}else if(de > 1){
			if(this.maCase == leJoueur.getCaseRampe(de-2)){
				leJoueur.getCaseRampe(de-2).setPion(null);
				this.setCase(leJoueur.getCaseRampe(de-1));
				leJoueur.getCaseRampe(de-2).setPion(this);
			}
		}else{
			System.out.println("Votre pion ne peut pas passer à la case supérieure de la rampe.");
		}
	}
	
	protected Case maCase; 		//	chaque pion est sur une case
	protected Joueur leJoueur; 	//	chaque pion appartient à un joueur
	protected boolean tour; 	//	Savoir si le pion a fait le tour du plateau
}
