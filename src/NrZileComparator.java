import java.util.Comparator;

public class NrZileComparator implements Comparator<Lib> {
	@Override
	public int compare(Lib o1, Lib o2) {
		return o1.nrZileInregistrare - o2.nrZileInregistrare;
	}
}
