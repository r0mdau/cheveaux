import java.util.ArrayList;

public class CaseTerminee extends Case{
	public CaseTerminee(){
		this.lesPionsFinis = new ArrayList<Pion>();
	}
	
	public void setPion(Pion lePion){
		this.lesPionsFinis.add(lePion);
	}
	
	private ArrayList<Pion> lesPionsFinis; //	les pions terminés sont stockés ici et non pas avec la méthode mère setPion
}
