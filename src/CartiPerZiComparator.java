import java.util.Comparator;

public class CartiPerZiComparator implements Comparator<Lib> {

	@Override
	public int compare(Lib o1, Lib o2) {
		return o1.nrCartiPerZi - o2.nrCartiPerZi;
	}

}
