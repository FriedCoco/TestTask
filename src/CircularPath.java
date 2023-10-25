import java.util.ArrayList;
import java.util.List;
public class CircularPath {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        ArrayList<Integer> circularArray = new ArrayList<>();
        ArrayList<Integer> iterationArray = new ArrayList<>();
        ArrayList<List<Integer>> finalArrayOfArrays = new ArrayList<>();



        for (int j = 1; j <= n; j++) {
            circularArray.add(j);
        }

        int index = 1;
        int lastDigit = 0;
        while (lastDigit != 1) {
            index--;
            if (index == -1) index = m;

            for (int i = 0; i < m; i++) {
                iterationArray.add(circularArray.get(index));
                index = getNextIndex(circularArray, index);
            }
            lastDigit = iterationArray.get(iterationArray.size()-1);
            finalArrayOfArrays.add(new ArrayList<>(iterationArray));
            iterationArray.clear();

        }

        for (List<Integer> finalArrayOfArray : finalArrayOfArrays) {
            System.out.print(finalArrayOfArray.get(0));
        }


    }

    private static int getNextIndex(ArrayList<Integer> array, int current) {
        if (current < array.size() - 1) {
            return current + 1;
        } else {
            return 0;
        }
    }


}
