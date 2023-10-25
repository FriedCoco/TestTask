public class CircularPath {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("����������, ������� ��� ���������: n � m.");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        StringBuilder path = new StringBuilder();
        int[] circularArray = new int[n];

        // �������������� �������� ������ �� 1 �� n
        for (int i = 0; i < n; i++) {
            circularArray[i] = i + 1;
        }

        int current = 0;

        // ���� �� ������� ���� �������� ������
        while (n > 0) {
            // ��������� ������� ������� � ����
            path.append(circularArray[current]);

            // ������� ������� ������� �� ��������� �������
            for (int i = current; i < n - 1; i++) {
                circularArray[i] = circularArray[i + 1];
            }

            // ��������� ��������� ������, �������� ����� ��������� m
            current = (current + m - 1) % n;

            // ��������� ������ �������
            n--;

            // ��������� ������, ���� ���� ��� �������� � ����
            if (n > 0) {
                path.append(" ");
            }
        }

        System.out.println(path.toString());
    }
}
