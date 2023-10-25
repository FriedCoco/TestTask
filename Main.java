public class CircularPath {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Пожалуйста, укажите два аргумента: n и m.");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        StringBuilder path = new StringBuilder();
        int[] circularArray = new int[n];

        // Инициализируем круговой массив от 1 до n
        for (int i = 0; i < n; i++) {
            circularArray[i] = i + 1;
        }

        int current = 0;

        // Пока не обойдем весь круговой массив
        while (n > 0) {
            // Добавляем текущий элемент к пути
            path.append(circularArray[current]);

            // Удаляем текущий элемент из кругового массива
            for (int i = current; i < n - 1; i++) {
                circularArray[i] = circularArray[i + 1];
            }

            // Вычисляем следующий индекс, учитывая длину интервала m
            current = (current + m - 1) % n;

            // Уменьшаем размер массива
            n--;

            // Добавляем пробел, если есть еще элементы в пути
            if (n > 0) {
                path.append(" ");
            }
        }

        System.out.println(path.toString());
    }
}
