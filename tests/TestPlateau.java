import org.junit.Assert;
import org.junit.Test;

public class TestPlateau {	
	public TestPlateau(){
		this.plateau = new Plateau();
	}
	
	private Plateau plateau;
	
	@Test
	public void recupererCaseTrajet(){
		for(int i = 0; i < 52; i++){
			Assert.assertTrue(plateau.getCaseTrajet(i) instanceof CaseTrajet);
			Assert.assertEquals(i, plateau.getCaseTrajet(i).getPosition());
		}
	}
	
	@Test
	public void recupererCaseTerminee(){
		Assert.assertTrue(this.plateau.getCaseTerminee() instanceof CaseTerminee);
	}
}
