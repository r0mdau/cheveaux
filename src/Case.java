
public abstract class Case {
	public Case(){
		this.pion = null;
	}
	
	public int getPosition(){
		return this.position;
	}
	
	public Pion getPion(){
		return this.pion;
	}
	
	public void setPion(Pion pion){
		this.pion = pion;
	}
	
	public boolean aUnPionAdversaireDessus(Joueur leJoueur){
		return this.pion != null && this.pion.getJoueur() != leJoueur;
	}
	
	public boolean aUnPionDuJoueurDessus(Joueur leJoueur){
		return this.pion != null && this.pion.getJoueur() == leJoueur;
	}
	
	private Pion pion; 		//	chaque case héberge un pion
	protected int position; //	chaque case est identifiée par sa position + son instance
}
