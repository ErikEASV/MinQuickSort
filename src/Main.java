public class Main {
    private static int antal = 0;

    public static void main(String[] args) {
        System.out.println("Quicksort");
        int liste[] = {5,8,4,2,3,1,7,6};
        quicksort(liste);
        System.out.print("Resultat: ");
        udskriv(liste, 0 ,liste.length-1);
    }

    public static void quicksort(int[] array) {
        quicksort(array, 0, array.length-1);
    }

    private static void quicksort(int[] array, int left, int right) {
        System.out.print(++antal + " ny liste: ");

        udskriv(array, left, right);
        if (left >= right)
            return;

        int pivot = array[(left+right)/2];
        int index = partition(array, left, right, pivot);

        System.out.println("Pivot="+pivot);
        System.out.print("venstre: "); udskriv(array, left, index-1);
        System.out.print("højre: "); udskriv(array, index, right);

        quicksort(array, left, index - 1);
        quicksort(array, index, right);

        System.out.print("venstre sorteret: "); udskriv(array, left, index-1);
        System.out.print("højre sorteret: "); udskriv(array, index, right);
    }

    private static int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot)     // flyt venstre pointer sålænge element er mindre end pivot
                left++;
            while (array[right] > pivot)    // flyt højre point sålænge element er større end pivot
                right--;
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }

        return left; // partition point mellem de to lister
    }

    private static void swap(int[] array, int left, int right) {
        int tmp;
        tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    private static void udskriv(int[] liste, int left, int right) {
        left = 0; right = liste.length-1;
        for (int i=left; i<=right; i++)
            System.out.print(liste[i]+" ");
        System.out.println();
    }
}