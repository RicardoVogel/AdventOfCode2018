import java.io.*;
import java.util.*;

public class d23c1 {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("d23input.txt" ));

        int maxRad = 0;
        int[] maxCoord = new int[3];
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            int radius = Integer.parseInt(line.split("=")[2]);
            if (radius > maxRad){
                maxRad = radius;
                String[] coord = line.split("=")[1].replace("<", "").replace(">, r", "").split(",");
                maxCoord[0] = Integer.parseInt(coord[0]);
                maxCoord[1] = Integer.parseInt(coord[1]);
                maxCoord[2] = Integer.parseInt(coord[2]);

            }
        }
        sc.close();

        System.out.println(maxRad);

        Scanner sca = new Scanner(new File("d23input.txt" ));

        int counter = 0;
        while(sca.hasNextLine()){
            String line = sca.nextLine();
            int radius = Integer.parseInt(line.split("=")[2]);
            String[] coord = line.split("=")[1].replace("<", "").replace(">, r", "").split(",");
            int distance = Math.abs(Integer.parseInt(coord[0]) - maxCoord[0]) +
                    Math.abs(Integer.parseInt(coord[1]) - maxCoord[1]) +
                    Math.abs(Integer.parseInt(coord[2]) - maxCoord[2]);

            if(maxRad >= distance) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
