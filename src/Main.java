import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] argv) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("a_example.txt"))) {
			String line;
			line = br.readLine();

			String[] splited = line.split("\\s+");
			int nrCarti = Integer.parseInt(splited[0]);
			int nrLib = Integer.parseInt(splited[1]);
			int nrZile = Integer.parseInt(splited[2]);

			line = br.readLine();
			splited = line.split("\\s+");
			int[] scorCarti = Arrays.stream(splited).mapToInt(Integer::parseInt).toArray();

			ArrayList<Lib> biblioteci = new ArrayList<Lib>(nrLib);

			int i;
			for (i = 0; i < nrLib; i++) {
				line = br.readLine();
				splited = line.split("\\s+");
				Lib lib = new Lib(Integer.parseInt(splited[0]), Integer.parseInt(splited[1]),
						Integer.parseInt(splited[2]));

				biblioteci.add(lib);

				line = br.readLine();
				splited = line.split("\\s+");
				int[] idCarti = Arrays.stream(splited).mapToInt(Integer::parseInt).toArray();
				lib.setIdCarti(idCarti);
			}

			Collections.sort(biblioteci, new NrZileComparator());
			System.out.print(biblioteci);
		}
	}
}
