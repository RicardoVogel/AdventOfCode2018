public class d11c2 {
    public static int[][] coords = new int[700][700];
    public final static int serialNr = 1788;

    public static void main(String[] args) {
        for (int x = 1; x != 301; x++) {
            for (int y = 1; y != 301; y++) {
                coords[x][y] = powerLevel(x, y, serialNr);
            }
        }

        int maxX = 0;
        int maxY = 0;
        int maxSize = 0;
        int maxPower = Integer.MIN_VALUE;
        for (int x = 1; x != 301; x++) {
            for (int y = 1; y != 301; y++) {
                int smallest = Math.min(x, y);
                for (int s = 1; s != 310 - smallest; s++) {
                    int thisPower = 0;
                    for (int a = 0; a != s; a++) {
                        for (int b = 0; b != s; b++) {
                            thisPower += coords[x + a][y + b];
                        }
                    }
                    if (thisPower > maxPower) {
                        maxX = x;
                        maxY = y;
                        maxSize = s;
                        maxPower = thisPower;
                    }
                }
            }
        }
        System.out.println(maxX + "," + maxY + "," + maxSize + "(" + maxPower + ")");
    }

    public static int powerLevel(int x, int y, int serial) {
        int rackID = x + 10;
        int powerLevel = rackID * y;
        powerLevel += serial;
        powerLevel *= rackID;
        String number = String.valueOf(powerLevel);
        char[] digits = number.toCharArray();
        try {
            String str = String.valueOf(digits[digits.length - 3]);
            powerLevel = Integer.parseInt(str);
        } catch (Error e) {
            powerLevel = 0;
        }
        powerLevel -= 5;
        return powerLevel;
    }
}
