import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * The price for least efficient code goes to...
 */
public class d25c1 {
    public static final int size = 50;
    public static boolean[][][][] points = new boolean[size][size][size][size];
    public static boolean[][][][] visited = new boolean[size][size][size][size];
    static int counter = 0;
    static int amountOfPoints = 0;

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.nanoTime();

        Scanner sc0 = new Scanner(new File("d25input.txt"));
        while (sc0.hasNextLine()) {
            String str = sc0.nextLine();
            points[Integer.parseInt(str.split(",")[0]) + size / 2]
                    [Integer.parseInt(str.split(",")[1]) + size / 2]
                    [Integer.parseInt(str.split(",")[2]) + size / 2]
                    [Integer.parseInt(str.split(",")[3]) + size / 2] = true;
            amountOfPoints++;
        }

        for (int x = 0; x != size; x++) {
            for (int y = 0; y != size; y++) {
                for (int z = 0; z != size; z++) {
                    for (int t = 0; t != size; t++) {
                        if (points[x][y][z][t] && !visited[x][y][z][t]) {
                            boolean[][][][] visitedThisRun = new boolean[size][size][size][size];
                            recursion(x, y, z, t, visitedThisRun);
                            counter++;
                            System.out.println(counter);
                        }
                    }
                }
            }
        }
        System.out.println("ANSWER: " + counter);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        System.out.println("TIME: " + duration + "ms");
    }

    public static void recursion(int x, int y, int z, int t, boolean[][][][] visitedThisRun) {
        if (x < 0 || y < 0 || z < 0 || t < 0) {
            return;
        }
        if (x >= size || y >= size || z >= size || t >= size) {
            return;
        }
        if (!points[x][y][z][t] || visited[x][y][z][t] || visitedThisRun[x][y][z][t]) {
            return;
        }
        System.out.println(counter + " ... " + (x - size / 2) + "," + (y - size / 2) + "," + (z - size / 2) + "," + (t - size / 2));
        visitedThisRun[x][y][z][t] = true;
        for (int x1 = x - 3; x1 != x + 4; x1++) {
            for (int y1 = y - 3; y1 != y + 4; y1++) {
                for (int z1 = z - 3; z1 != z + 4; z1++) {
                    for (int t1 = t - 3; t1 != t + 4; t1++) {
                        if (x1 < 0 || y1 < 0 || z1 < 0 || t1 < 0) {
                            break;
                        }
                        if (x1 >= size || y1 >= size || z1 >= size || t1 >= size) {
                            break;
                        }
                        if (Math.abs(x1 - x) + Math.abs(y1 - y) + Math.abs(z1 - z) + Math.abs(t1 - t) <= 3) {
                            recursion(x1, y1, z1, t1, visitedThisRun);
                            visitedThisRun[x1][y1][z1][t1] = true;
                        }

                    }
                }
            }
        }
        visited[x][y][z][t] = true;
    }
}
