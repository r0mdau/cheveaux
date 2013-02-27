
public class PionDestructeur extends Pion {

	public PionDestructeur(){
		
	}
	
	public PionDestructeur(CaseTrajet laCase, Joueur leJoueur){
		this.maCase = laCase;
		laCase.setPion(this);
		this.leJoueur = leJoueur;
	}
	
	private void detruitPionRapideSurSonPassage(int position, Plateau plateau){
		for(int i = this.getCase().getPosition(); i < position; ++i){
			if(i > 51) i -= 52;
			CaseTrajet laCase = plateau.getCaseTrajet(i);
			if(laCase.aUnPionAdversaireDessus(leJoueur) && laCase.getPion() instanceof PionRapide)
				laCase.getPion().remetPionAuDebut();
		}
	}

	public void avancer(int de, Plateau plateau, Joueur leJoueur) {	
		if(this.lePionNEstPasSortiDeLEcurie(leJoueur) && de == 6){
			Case laCaseApresDepart = plateau.getCaseTrajet(leJoueur.getCaseDepart().getPosition() + 1);
			if(!laCaseApresDepart.aUnPionDuJoueurDessus(leJoueur)){
				if(laCaseApresDepart.aUnPionAdversaireDessus(leJoueur))
					laCaseApresDepart.getPion().remetPionAuDebut();
				this.maCase = laCaseApresDepart;
				laCaseApresDepart.setPion(this);
			}
		}
		else if(this.lePionAFiniSaCourseTrajet(leJoueur)){
			this.monterSurRampe(de, leJoueur);
		}
		else if(this.lePionEstSurLaRampe()){
			this.avancerSurRampe(de, leJoueur, plateau);
		}
		else if(this.lePionNEstPasSurLaCaseDepart(leJoueur)){
//			TODO : la fonction remetCompteurAuDebut appartient-elle à la bonne classe ?
			int nouvellePosition = this.remetCompteurAuDebut(this.getCase().getPosition() + de);

			if(this.lePionRisqueDepasserLaCaseArrivee(leJoueur, plateau, nouvellePosition))
				nouvellePosition = leJoueur.getCaseArrivee().getPosition();
			
			this.detruitPionRapideSurSonPassage(nouvellePosition, plateau);			
			
			CaseTrajet laCase = plateau.getCaseTrajet(nouvellePosition);
			if(!laCase.aUnPionDuJoueurDessus(leJoueur)){
				if(laCase.aUnPionAdversaireDessus(leJoueur))			
					laCase.getPion().remetPionAuDebut();
				this.maCase.setPion(null);
				laCase.setPion(this);
				this.maCase = laCase;
			}			
		}
		else{
			System.out.println("Votre pion destructeur ne peut pas sortir.");
		}
	}
}
