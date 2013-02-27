import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class TestPartie {
	public TestPartie(){
		this.plateau = new Plateau();

	}
	
	private Plateau plateau;
	
	@Test
	public void lePionAFiniSaCourse(){
		Joueur joueur = new Joueur("Romain", plateau, 4);
		Assert.assertFalse(joueur.getPionRapide(1).getCase() instanceof CaseTerminee);

		joueur.getPionRapide(1).setCase(joueur.getCaseRampe(4));
		joueur.getPionRapide(1).avancer(6, plateau, joueur);
		Assert.assertTrue(joueur.getPionRapide(1).getCase() instanceof CaseTerminee);
	}
	
	@Test
	public void testLeJoueurAGagne(){
		Joueur joueur = new Joueur("Romain", plateau, 4);
		ArrayList<Pion> pions = joueur.getPions();
		boolean fini = true;
		for(int i = 0; i < pions.size(); i++){
			if(!(pions.get(i).getCase() instanceof CaseTerminee))
				fini = false;
		}
		Assert.assertFalse(fini);
		
		fini = true;
		joueur.getPionRapide(1).setCase(plateau.getCaseTerminee());
		joueur.getPionRapide(2).setCase(plateau.getCaseTerminee());
		joueur.getPionDestructeur(1).setCase(plateau.getCaseTerminee());
		joueur.getPionDestructeur(2).setCase(plateau.getCaseTerminee());
		for(int i = 0; i < pions.size(); i++){
			if(!(pions.get(i).getCase() instanceof CaseTerminee))
				fini = false;
		}
		Assert.assertTrue(fini);
	}
	
	@Test
	public void jePeuxObtenirLeNombreDeJoueurs(){
		Partie partie = new Partie(3);
		Assert.assertEquals(3, partie.getNbJoueurs());

		partie = new Partie(4);
		Assert.assertEquals(4, partie.getNbJoueurs());
	}
}
