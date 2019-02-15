import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

	    //ZufälligeKartenerzeugen
		IKarte[] res = ZufälligeKartenerzeugen();
		System.out.println("ZufälligeKarten:");
		System.out.println(Arrays.toString(res));
		System.out.println("------------------------------------------");
		
		
		//Sortierung nach nur Farbe 
		BubbleSort.sort(res , (IKarte k) -> ((int) k.farbe().getValue()));
		System.out.println("Sortierung nach nur Farbe");		
		System.out.println(Arrays.toString(res));
		System.out.println("------------------------------------------");
		

		//Sortierung nach Farbe und nummer
		System.out.println("Sortierung nach Farbe und nummer");
		BubbleSort.sort(res , (IKarte k) -> ((int) k.hashCode()));
		System.out.println(Arrays.toString(res));
		System.out.println("------------------------------------------");
	}

	private static IKarte[] ZufälligeKartenerzeugen() {
		IKarte[] res = new IKarte[52];
		for (int i = 0; i < 52; i++) 
			res[i] = new Karte(i);
		
		werkzeuge.shuffleArray(res);
		return res;
	}
}
