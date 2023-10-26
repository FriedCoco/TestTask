import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MinMovesToEqualize {
    public static void main(String[] args) {
        String inputFileName = args[0];

        List<Integer> numbers = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        int minMoves = minMovesToEqualize(numbers);
        System.out.println(minMoves);
    }

    public static int minMovesToEqualize(List<Integer> nums) {
        int sum = 0;
        int average;

        for (int num : nums) {
            sum += num;
        }

        average = sum / nums.size();

        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - average);
        }

        return moves;
    }
}
