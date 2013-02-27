
public class PionRapide extends Pion {
	public PionRapide(){
		
	}
	
	public PionRapide(CaseTrajet laCase, Joueur leJoueur){
		this.maCase = laCase;
		laCase.setPion(this);
		this.leJoueur = leJoueur;
	}
	
	public void avancer(int de, Plateau plateau, Joueur leJoueur){
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
//			+ 1 car Pion rapide	
//			TODO : la fonction remetCompteurAuDebut appartient-elle à la bonne classe ?
			int nouvellePosition = this.remetCompteurAuDebut(this.getCase().getPosition() + de + 1);

			if(this.lePionRisqueDepasserLaCaseArrivee(leJoueur, plateau, nouvellePosition)){
				nouvellePosition = leJoueur.getCaseArrivee().getPosition();
			}				
			
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
			System.out.println("Votre pion rapide ne peut pas sortir.");
		}
	}
}
