import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PointCirclePosition {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java PointCirclePosition circle.txt points.txt");
            return;
        }

        try {
            // Чтение данных из файла с координатами окружности
            BufferedReader circleReader = new BufferedReader(new FileReader(args[0]));
            String[] circleCoords = circleReader.readLine().split(" ");
            float circleX = Float.parseFloat(circleCoords[0]);
            float circleY = Float.parseFloat(circleCoords[1]);
            float radius = Float.parseFloat(circleReader.readLine());
            circleReader.close();

            // Чтение данных из файла с координатами точек
            BufferedReader pointsReader = new BufferedReader(new FileReader(args[1]));
            String line;
            while ((line = pointsReader.readLine()) != null) {
                String[] pointCoords = line.split(" ");
                float pointX = Float.parseFloat(pointCoords[0]);
                float pointY = Float.parseFloat(pointCoords[1]);

                int position = getPointPosition(circleX, circleY, radius, pointX, pointY);
                System.out.println(position);
            }
            pointsReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для определения положения точки относительно окружности
    private static int getPointPosition(float circleX, float circleY, float radius, float pointX, float pointY) {
        float distance = (float) Math.sqrt(Math.pow(pointX - circleX, 2) + Math.pow(pointY - circleY, 2));

        if (distance == radius) {
            return 0; // Точка лежит на окружности
        } else if (distance < radius) {
            return 1; // Точка внутри окружности
        } else {
            return 2; // Точка снаружи окружности
        }
    }
}
