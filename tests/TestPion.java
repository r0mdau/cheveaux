import org.junit.Assert;
import org.junit.Test;

public class TestPion {
	public TestPion(){
		this.plateau = new Plateau();
	}
	
	private Plateau plateau;
	
	@Test
	public void jePeuxObtenirLaPositionDuPionRapideSurLeTrajet(){
		Joueur joueur = new Joueur("Romain", plateau, 4);
		Pion lePion = joueur.getPionRapide(1);
		Assert.assertEquals(4, lePion.getCase().getPosition());
		lePion.avancer(3, plateau, joueur);
		Assert.assertEquals(4, lePion.getCase().getPosition());
		lePion.avancer(6, plateau, joueur);
		Assert.assertEquals(5, lePion.getCase().getPosition());

		lePion.avancer(4, plateau, joueur);
		Assert.assertEquals(10, lePion.getCase().getPosition());
		
		lePion.avancer(33, plateau, joueur);
		Assert.assertEquals(44, lePion.getCase().getPosition());
		
		lePion.avancer(33, plateau, joueur);
		Assert.assertEquals(3, lePion.getCase().getPosition());				
	}
	
	@Test
	public void jePeuxObtenirLaPositionDuPionDestructeurSurLeTrajet(){
		Joueur joueur = new Joueur("Romain", plateau, 4);
		Pion lePion = joueur.getPionDestructeur(1);
		Assert.assertEquals(4, lePion.getCase().getPosition());
		lePion.avancer(3, plateau, joueur);
		Assert.assertEquals(4, lePion.getCase().getPosition());
		lePion.avancer(6, plateau, joueur);
		Assert.assertEquals(5, lePion.getCase().getPosition());

		lePion.avancer(4, plateau, joueur);
		Assert.assertEquals(9, lePion.getCase().getPosition());
		
		lePion.avancer(33, plateau, joueur);
		Assert.assertEquals(42, lePion.getCase().getPosition());
		
		lePion.avancer(33, plateau, joueur);
		Assert.assertEquals(3, lePion.getCase().getPosition());
	}
	
	@Test
	public void lePionDestructeurPasseSurSaRampe(){
		Joueur joueur = new Joueur("Romain", plateau, 4);
		Pion lePion = joueur.getPionDestructeur(1);
		lePion.setCase(joueur.getCaseArrivee());
		lePion.avancer(1, plateau, joueur);
		Assert.assertTrue(lePion.getCase() instanceof CaseRampe);
	}
	
	@Test
	public void lePionRapidePasseSurSaRampe(){
		Joueur joueur = new Joueur("Romain", plateau, 4);
		Pion lePion = joueur.getPionRapide(1);
		lePion.setCase(joueur.getCaseArrivee());
		lePion.avancer(1, plateau, joueur);
		Assert.assertTrue(lePion.getCase() instanceof CaseRampe);
	}
	
	@Test
	public void lePionRapideATermine(){
		Joueur joueur = new Joueur("Romain", plateau, 4);
		Pion lePion = joueur.getPionRapide(1);
		lePion.setCase(joueur.getCaseRampe(4));
		lePion.avancer(6, plateau, joueur);
		Assert.assertTrue(lePion.getCase() instanceof CaseTerminee);
	}
	
	@Test
	public void lePionDestructeurATermine(){
		Joueur joueur = new Joueur("Romain", plateau, 4);
		Pion lePion = joueur.getPionDestructeur(1);
		lePion.setCase(joueur.getCaseRampe(4));
		lePion.avancer(6, plateau, joueur);
		Assert.assertTrue(lePion.getCase() instanceof CaseTerminee);
	}
	
	@Test
	public void jePeuxObtenirLaCaseDUnPion(){
		Joueur joueur = new Joueur("Thomas", plateau, 1);		
		Assert.assertSame(plateau.getCaseTrajet(43), joueur.getPionDestructeur(1).getCase());
	}
	
	@Test
	public void jePeuxObtenirLaPositionDuPionSurSaRampe(){
		Joueur joueur = new Joueur("Romain", plateau, 4);
		Pion rapide = joueur.getPionRapide(1); 
		rapide.setCase(joueur.getCaseRampe(0));
		Assert.assertTrue(joueur.getPionRapide(1).getCase() instanceof CaseRampe);
		Assert.assertEquals(0, joueur.getPionRapide(1).getCase().getPosition());
		
		rapide.avancer(2, plateau, joueur);
		Assert.assertEquals(1, joueur.getPionRapide(1).getCase().getPosition());
	}
	
	@Test
	public void lePionNEstPasSortiDeLEcurie(){
		Joueur joueur = new Joueur("Romain", plateau, 4);
		Pion pion = joueur.getPionDestructeur(1);
		Assert.assertTrue(pion.lePionNEstPasSortiDeLEcurie(joueur));
		
		pion.avancer(4, plateau, joueur);
		Assert.assertTrue(pion.lePionNEstPasSortiDeLEcurie(joueur));
		
		pion.avancer(6, plateau, joueur);
		Assert.assertFalse(pion.lePionNEstPasSortiDeLEcurie(joueur));
	}
	
	@Test
	public void lePionNEstPasSurLaCaseDepart(){
		Joueur joueur = new Joueur("Romain", plateau, 4);
		Pion pion = joueur.getPionDestructeur(1);
		Assert.assertFalse(pion.lePionNEstPasSurLaCaseDepart(joueur));
		
		pion.avancer(4, plateau, joueur);
		Assert.assertFalse(pion.lePionNEstPasSurLaCaseDepart(joueur));
		
		pion.avancer(6, plateau, joueur);
		Assert.assertTrue(pion.lePionNEstPasSurLaCaseDepart(joueur));
	}
	
	@Test
	public void lePionRisqueDepasserLaCaseArrivee(){
		Joueur joueur = new Joueur("Romain", plateau, 4);
		Pion pion = joueur.getPionDestructeur(1);
		Assert.assertFalse(pion.lePionRisqueDepasserLaCaseArrivee(joueur, plateau, 3));
		
		pion.avancer(6, plateau, joueur);
		Assert.assertFalse(pion.lePionRisqueDepasserLaCaseArrivee(joueur, plateau, 3));
		
		pion.avancer(51, plateau, joueur);
		Assert.assertTrue(pion.lePionRisqueDepasserLaCaseArrivee(joueur, plateau, pion.getCase().getPosition() + 5));
	}
	
	@Test
	public void lePionAFiniSaCourseTrajet(){
		Joueur joueur = new Joueur("Romain", plateau, 4);
		Pion pion = joueur.getPionDestructeur(1);
		Assert.assertFalse(pion.lePionAFiniSaCourseTrajet(joueur));
		
		pion.avancer(4, plateau, joueur);
		Assert.assertFalse(pion.lePionAFiniSaCourseTrajet(joueur));
		
		pion.avancer(6, plateau, joueur);
		Assert.assertFalse(pion.lePionAFiniSaCourseTrajet(joueur));
		
		pion.avancer(51, plateau, joueur);
		Assert.assertTrue(pion.lePionAFiniSaCourseTrajet(joueur));
	}
	
	@Test
	public void lePionEstSurLaRampe(){
		Joueur joueur = new Joueur("Romain", plateau, 4);
		Pion pion = joueur.getPionDestructeur(1);
		Assert.assertFalse(pion.lePionEstSurLaRampe());
		
		pion.avancer(4, plateau, joueur);
		Assert.assertFalse(pion.lePionEstSurLaRampe());
		
		pion.avancer(6, plateau, joueur);
		Assert.assertFalse(pion.lePionEstSurLaRampe());
		
		pion.avancer(51, plateau, joueur);
		Assert.assertFalse(pion.lePionEstSurLaRampe());
		
		pion.avancer(2, plateau, joueur);
		Assert.assertFalse(pion.lePionEstSurLaRampe());
		
		pion.avancer(1, plateau, joueur);
		Assert.assertTrue(pion.lePionEstSurLaRampe());
	}
	
	@Test
	public void testRemetCompteurAuDebut(){
		Joueur joueur = new Joueur("Romain", plateau, 4);
		Pion pion = joueur.getPionDestructeur(1);
		Assert.assertEquals(51, pion.remetCompteurAuDebut(-1));
		Assert.assertEquals(47, pion.remetCompteurAuDebut(-5));
		Assert.assertEquals(0, pion.remetCompteurAuDebut(52));
		Assert.assertEquals(5, pion.remetCompteurAuDebut(57));
	}
}
