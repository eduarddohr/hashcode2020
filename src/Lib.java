import java.util.Comparator;

public class Lib {
	public int nrCarti;
	public int nrZileInregistrare;
	public int nrCartiPerZi;
	public int[] idCarti;
	
	public Lib(int nrC, int nrZile, int nrCp) {
		nrCarti = nrC;
		nrZileInregistrare = nrZile;
		nrCartiPerZi = nrCp;
	}
	
	public void setIdCarti(int[] idCarti) {
		idCarti = idCarti.clone();
	}
	
	public String toString() {
		return nrZileInregistrare + " ";
	}
}
