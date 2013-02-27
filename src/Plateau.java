import java.util.ArrayList;

public class Plateau {
	public Plateau(){						
		this.initialiserCasesTrajet();
		this.caseTerminee = new CaseTerminee();
	}

	private void initialiserCasesTrajet(){
		this.casesTrajet = new ArrayList<CaseTrajet>();
		for(int i = 0; i <= 51 ; i++){
			this.casesTrajet.add(new CaseTrajet(i));
		}
	}
	
	public CaseTrajet getCaseTrajet(int indice){
		return this.casesTrajet.get(indice);
	}		
	
	public CaseTerminee getCaseTerminee(){
		return this.caseTerminee;
	}
	
	private ArrayList<CaseTrajet> casesTrajet;	//	contient toutes les cases du parcours
	private CaseTerminee caseTerminee;			//	case abstraites permettant de définir si un pion a entièrement fini sa course
}
