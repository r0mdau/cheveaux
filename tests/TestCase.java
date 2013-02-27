import org.junit.Assert;
import org.junit.Test;

public class TestCase {
	public TestCase(){
		this.plateau = new Plateau();
		this.joueur = new Joueur("Thomas", plateau, 1);
	}
	
	private Plateau plateau;
	private Joueur joueur;
	
	@Test
	public void jePeuxObtenirLaPositionDeLaCase(){
		Assert.assertEquals(4, plateau.getCaseTrajet(4).getPosition());
		Assert.assertEquals(51, plateau.getCaseTrajet(51).getPosition());
	}
	
	@Test
	public void jePeuxChangerLePionDeLaCase(){
		Pion pion = new PionRapide();
		Pion pion2 = new PionDestructeur();
		
		plateau.getCaseTrajet(4).setPion(pion);
		Assert.assertSame(pion, plateau.getCaseTrajet(4).getPion());
		
		plateau.getCaseTrajet(4).setPion(pion2);
		Assert.assertSame(pion2, plateau.getCaseTrajet(4).getPion());
	}
	
	@Test
	public void jePeuxObtenirLePionDUneCaseTrajet(){
		Assert.assertSame(null, plateau.getCaseTrajet(2).getPion());
		joueur.getPionRapide(1).avancer(6, plateau, joueur);
		Assert.assertSame(joueur.getPionRapide(1), plateau.getCaseTrajet(joueur.getCaseDepart().getPosition() + 1).getPion());
		
		joueur.getPionRapide(1).avancer(3, plateau, joueur);
		Assert.assertSame(joueur.getPionRapide(1), plateau.getCaseTrajet(joueur.getCaseDepart().getPosition() + 1 + 4).getPion());
	}
	
	@Test
	public void testLePionAUnPionAdversaireDessus(){
		Joueur adversaire = new Joueur("Thomas", plateau, 3);
		Assert.assertFalse(plateau.getCaseTrajet(2).aUnPionAdversaireDessus(joueur));
		plateau.getCaseTrajet(2).setPion(adversaire.getPionRapide(1));
		Assert.assertTrue(plateau.getCaseTrajet(2).aUnPionAdversaireDessus(joueur));
	}
	
	@Test
	public void testLePionAUnPionDuJoueurDessus(){
		Assert.assertFalse(plateau.getCaseTrajet(2).aUnPionDuJoueurDessus(joueur));
		plateau.getCaseTrajet(2).setPion(joueur.getPionRapide(1));
		Assert.assertTrue(plateau.getCaseTrajet(2).aUnPionDuJoueurDessus(joueur));
	}
}
