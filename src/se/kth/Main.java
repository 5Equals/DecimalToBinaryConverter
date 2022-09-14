/**
 * Converts from decimal to binary.
 */

package se.kth;

public class Main {

    public static void main(String[] args) {
        int[] result = convertToBinary(113);
        printArray(result);
    }

    public static void printArray(int[] array) {
        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = array.length - 1; i >= 0; i--) {
            str.append(array[i]);
            if(i != 0) {
                str.append(", ");
            }
        }
        str.append("]");
        System.out.println(str.toString());
    }

    public static int[] convertToBinary(int number) {
        int[] result = new int[rankLargestNumberBase2Divider(number) + 1];
        int tempNumber = number;

        while (tempNumber != 0) {
            int tempRank = rankLargestNumberBase2Divider(tempNumber);
            tempNumber -= largestNumberBase2Divider(tempNumber);
            result[tempRank] = 1;
        }
        return result;
    }

    public static int rankLargestNumberBase2Divider(int number) {
        if(number < 3) {
            return number - 1;
        }

        int result = 1;
        int count = 0;
        while(result <= number) {
            result *= 2;
            count++;
        }
        count--;
        return count;
    }

    public static int largestNumberBase2Divider(int number) {
        if(number < 3) {
            return number;
        }

        int result = 1;
        while(result <= number) {
            result *= 2;
        }
        result /= 2;
        return result;
    }
}
