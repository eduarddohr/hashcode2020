import java.util.Comparator;

public class ScorCartiComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return Main.scorCarti[o2] - Main.scorCarti[o1];
	}

}
