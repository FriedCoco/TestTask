import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PointPosition {
    public static void main(String[] args) {

        try (BufferedReader File1Reader = new BufferedReader(new FileReader(args[0]));
             BufferedReader File2Reader = new BufferedReader(new FileReader(args[1]))) {

            String[] circleCenter = File1Reader.readLine().split(" ");
            float centerX = Float.parseFloat(circleCenter[0]);
            float centerY = Float.parseFloat(circleCenter[1]);
            float radius = Float.parseFloat(File1Reader.readLine());

            String line;
            while ((line = File2Reader.readLine()) != null) {
                String[] points = line.split(" ");
                float x = Float.parseFloat(points[0]);
                float y = Float.parseFloat(points[1]);

                int position = getPointPosition(centerX, centerY, radius, x, y);
                System.out.println(position);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getPointPosition(float centerX, float centerY, float radius, float x, float y) {
        float distance = (float) Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));
        if (distance < radius) {
            return 1; // Точка внутри окружности
        } else if (distance == radius) {
            return 0; // Точка лежит на окружности
        } else {
            return 2; // Точка снаружи окружности
        }
    }
}
