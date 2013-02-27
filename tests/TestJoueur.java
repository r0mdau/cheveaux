import org.junit.Assert;
import org.junit.Test;

public class TestJoueur {
	public TestJoueur(){
		this.plateau = new Plateau();
		this.joueur = new Joueur("Thomas", plateau, 1);
	}
	
	private Plateau plateau;
	private Joueur joueur;
	
	@Test
	public void jePeuxObtenirLeNom(){
		Joueur player = new Joueur("Jerome");
		Assert.assertEquals("Jerome", player.getNom());
		player = new Joueur("Romain");
		Assert.assertEquals("Romain", player.getNom());
	}
	
	@Test
	public void leJoueurFaitUnNombreEntreUnEtSix(){
		Assert.assertTrue(this.joueur.lanceLeDe() <= 6 && this.joueur.lanceLeDe() >=1);
	}		
	
	@Test
	public void lesJoueursSontInitialisesSurLePlateauAvec13CasesDEcart(){
		Joueur joueur = new Joueur("Thomas", plateau, 1);
		Joueur joueur2 = new Joueur("Thomas", plateau, 2);
		Joueur joueur3 = new Joueur("Thomas", plateau, 3);
		Joueur joueur4 = new Joueur("Thomas", plateau, 4);
		
		int curs = 4;
		Assert.assertSame(plateau.getCaseTrajet(curs), joueur4.getCaseDepart());
		Assert.assertSame(plateau.getCaseTrajet(curs - 1), joueur4.getCaseArrivee());
		
		curs += 13;
		Assert.assertSame(plateau.getCaseTrajet(curs), joueur3.getCaseDepart());
		Assert.assertSame(plateau.getCaseTrajet(curs - 1), joueur3.getCaseArrivee());
		
		curs += 13;
		Assert.assertSame(plateau.getCaseTrajet(curs), joueur2.getCaseDepart());
		Assert.assertSame(plateau.getCaseTrajet(curs - 1), joueur2.getCaseArrivee());
		
		curs +=13;
		Assert.assertSame(plateau.getCaseTrajet(curs), joueur.getCaseDepart());
		Assert.assertSame(plateau.getCaseTrajet(curs - 1), joueur.getCaseArrivee());
	}
	
	@Test
	public void testGetPionRapide(){
		Assert.assertTrue(this.joueur.getPionRapide(1) instanceof PionRapide);
		Assert.assertTrue(this.joueur.getPionRapide(2) instanceof PionRapide);
	}
	
	@Test
	public void testGetPionDestructeur(){
		Assert.assertTrue(this.joueur.getPionDestructeur(1) instanceof PionDestructeur);
		Assert.assertTrue(this.joueur.getPionDestructeur(2) instanceof PionDestructeur);
	}
	
	@Test
	public void testGetCaseDepart(){
		Assert.assertTrue(this.joueur.getCaseDepart() instanceof CaseTrajet);
		Assert.assertEquals(43, this.joueur.getCaseDepart().getPosition());
	}
	
	@Test
	public void testGetCaseArrivee(){
		Assert.assertTrue(this.joueur.getCaseDepart() instanceof CaseTrajet);
		Assert.assertEquals(42, this.joueur.getCaseArrivee().getPosition());
	}
	
	@Test
	public void lePionAFiniSaCourse(){
		this.joueur.getPionRapide(1).setCase(plateau.getCaseTerminee());
		Assert.assertEquals(this.joueur.getPionRapide(1).getCase(), plateau.getCaseTerminee());
	}
	
	@Test
	public void testGetCaseRampe(){
		for(int i = 0; i < 5; i++){
			Assert.assertTrue(this.joueur.getCaseRampe(i) instanceof CaseRampe);
			Assert.assertEquals(i, this.joueur.getCaseRampe(i).getPosition());
		}
	}
}
