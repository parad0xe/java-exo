
class MergeTwoSortedList {
    static void printArray(int[] array) {
        System.out.print("Array[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if(i < array.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    static int[] merge(int[] array1, int[] array2) {
        int[] newArray = new int[array1.length + array2.length];

        for (int i = 0; i < array1.length; i++)
            newArray[i] = array1[i];

        for (int i = 0; i < array2.length; i++)
            newArray[array1.length + i] = array2[i];

        for (int i = newArray.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if(newArray[j] > newArray[i]) {
                    int tmp = newArray[j];
                    newArray[j] = newArray[i];
                    newArray[i] = tmp;
                }
            }
        }

        return newArray;
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 4};
        int[] array2 = {3, 5, 6};

        printArray(merge(array1, array2));
    }
}