import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static int[] scorCarti;

	public static void main(String[] argv) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("b.txt"))) {
			String line;
			line = br.readLine();

			String[] splited = line.split("\\s+");
			int nrCarti = Integer.parseInt(splited[0]);
			int nrLib = Integer.parseInt(splited[1]);
			int nrZile = Integer.parseInt(splited[2]);
			FileWriter myWriter = new FileWriter("filename.txt");

			line = br.readLine();
			splited = line.split("\\s+");
			scorCarti = Arrays.stream(splited).mapToInt(Integer::parseInt).toArray();

			ArrayList<Lib> biblioteci = new ArrayList<Lib>(nrLib);

			int i;
			for (i = 0; i < nrLib; i++) {
				line = br.readLine();
				splited = line.split("\\s+");
				Lib lib = new Lib(Integer.parseInt(splited[0]), Integer.parseInt(splited[1]),
						Integer.parseInt(splited[2]), i);

				biblioteci.add(lib);

				line = br.readLine();
				splited = line.split("\\s+");
				int[] idCarti = Arrays.stream(splited).mapToInt(Integer::parseInt).toArray();
				lib.setIdCarti(idCarti);
			}

			Collections.sort(biblioteci, new NrZileComparator());
			System.out.print(biblioteci);

			int numarLibInscrise = 0;
			String textFinal = "";

			int sum = -1;
			System.out.println(nrZile);
//			while (numarLibInscrise < biblioteci.size()
//					&& sum + biblioteci.get(numarLibInscrise).nrZileInregistrare <= nrZile) {
//				sum += biblioteci.get(numarLibInscrise++).nrZileInregistrare;
//			}
			
			int index = 0;

			for(index = 0; index < biblioteci.size(); index++) {
				Lib carte = biblioteci.get(index);
				if(sum + carte.nrZileInregistrare > nrZile) {
					numarLibInscrise = index;
					break;
				}
				
				sum = sum+carte.nrZileInregistrare; 
			}
			System.out.println(sum);
			System.out.println(numarLibInscrise);
			
			int zileSignUp = 0;

//			for (i = 0; i < numarLibInscrise; i++) {
//				biblioteci.get(i).sortCarti();
//				//biblioteci.get(i).printCarti();
//				//System.out.println(" ");
//			}

			//for (i = 0; i < numarLibInscrise; i++) {
				textFinal += numarLibInscrise;
				textFinal += "\n";
				for (int j = 0; j < numarLibInscrise; j++) {
					int numarCarti = (nrZile - zileSignUp) * biblioteci.get(j).nrCartiPerZi;
					zileSignUp += biblioteci.get(j).nrZileInregistrare;
					textFinal += biblioteci.get(j).id + " ";
					textFinal += numarCarti + "\n";

					for (int k = 0; k < (numarCarti); k++) {
						textFinal += biblioteci.get(j).idCarti[k] + " ";
						if(biblioteci.get(j).id == 10) {
							System.out.println("ceva");
						}
					}
					textFinal += "\n";
				}

			//}

			System.out.println(zileSignUp);
			myWriter.write(textFinal);
			myWriter.close();

		}
	}
}
