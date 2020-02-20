import java.util.Comparator;

public class Lib {
	public int nrCarti;
	public int nrZileInregistrare;
	public int nrCartiPerZi;
	public int[] idCarti;
	public int id;
	
	public Lib(int nrC, int nrZile, int nrCp, int id) {
		nrCarti = nrC;
		nrZileInregistrare = nrZile;
		nrCartiPerZi = nrCp;
		this.id = id;
	}
	
	public void setIdCarti(int[] idCarti) {
		this.idCarti = idCarti.clone();
	}
	
	public String toString() {
		return nrZileInregistrare + " ";
	}
}
