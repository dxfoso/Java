import java.util.Random;

public class werkzeuge {
	//shuffleArray 
	public static void shuffleArray(IKarte[] array) {
		int index;
		IKarte temp;
		Random random = new Random();
		for (int i = array.length - 1; i > 0; i--) {
			index = random.nextInt(i + 1);
			temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
	}
}
