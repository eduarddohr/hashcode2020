import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Lib {
	public int nrCarti;
	public int nrZileInregistrare;
	public int nrCartiPerZi;
	public Integer[] idCarti;
	public int id;
	
	public Lib(int nrC, int nrZile, int nrCp, int id) {
		nrCarti = nrC;
		nrZileInregistrare = nrZile;
		nrCartiPerZi = nrCp;
		this.id = id;
	}
	
	public void setIdCarti(int[] idCarti) {
		this.idCarti = Arrays.stream(idCarti.clone()).boxed().toArray(Integer[]::new);
	}
	
	public String toString() {
		return nrZileInregistrare + " ";
	}
	
	public void sortCarti() {
		Arrays.sort(this.idCarti,new ScorCartiComparator());
	}
	
	public void printCarti() {
		for(int id : idCarti) {
			System.out.print("scor " + Main.scorCarti[id]);
		}
	}
}
