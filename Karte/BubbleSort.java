import java.util.function.Function;

public class BubbleSort {
    public static void sort(IKarte[] array , Function<IKarte,Integer> getValue ) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if ( getValue.apply(array[j - 1]) > getValue.apply(array[j])) {
                    swap(array, j, j - 1);
                }
            }
        }
    }

 
	private static void swap(IKarte[] array, int a, int b) {
        IKarte temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

