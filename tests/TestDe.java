import org.junit.Assert;
import org.junit.Test;

public class TestDe {
	@Test
	public void leDeRenvoiUnNombreEntreUnEtSix(){
		boolean resultat = false;
		if(De.lancer() <= 6 && De.lancer() >=1)
			resultat = true;
		Assert.assertTrue(resultat);
	}
}
