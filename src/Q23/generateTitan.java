package Q23;

import java.util.*;

public class generateTitan {
    private Scanner input;
    private int numTitans;

    public generateTitan() {
    }

    public int getNumTitans() {
        return numTitans;
    }

    /**
     * Method that generates random number of titans and prints it out
     * it also calculates distance taken to get to the titan
     */
    public void generateTitans(int numTitans) {


        int distance = 0;


        Pair[] data = new Pair[numTitans];
        int[] indexed = new int[numTitans];
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(numTitans, new TitanComparator());


        for (int i = 0; i < numTitans; i++) {
            data[i] = new Pair(i + 1, randomTitanType());
            pq.add(data[i]);
        }

        System.out.println(Arrays.toString(data));


        while (!pq.isEmpty()) {
            for (int i = 0; i < indexed.length; i++) {
                indexed[i] = pq.poll().getIndex();
                System.out.print("Titan " + indexed[i] + "->");
            }


        }
        distance = getSumDiference(indexed);
        System.out.println("\nTotal distance moved: " + distance + "\n");


    }

    private int getSumDiference(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length - 1; ++i) {
            sum += Math.abs(arr[i] - arr[i + 1]);
        }
        sum += arr[0];
        return sum;
    }


    public static double randomInt(double min, double max) {

        double random = (max - min + 1) * Math.random() + min;
        return random;

    }

    public static String randomPattern() {
        String[] arrayOfPattern = {"not repeated pattern", "repeated pattern", "normal pattern"};
        String pattern = get(arrayOfPattern);
        return pattern;
    }


    private static String get(String[] array) {
        Random generator = new Random();
        int rnd = generator.nextInt(array.length);
        return array[rnd];
    }

    public static Titan getTitan(Titan[] array) {
        Random generator = new Random();
        int rnd = generator.nextInt(array.length);
        return array[rnd];
    }

    /**
     * generates a random Titan
     *
     * @return
     */
    public static Titan randomTitanType() {
        Random generator = new Random();
        double max = 99;
        double min = 1;

        int height = (int) randomInt(min, max);
        int speed = (int) randomInt(min, max);
        int legs = (int) randomInt(0, 4);
        boolean climb = generator.nextBoolean();
        String pattern = randomPattern();
        Titan[] arrayOfTitanType = {new Titan(height, legs, speed, pattern, climb), new abnormalTitan(), new nineTitan()};
        Titan patternType = getTitan(arrayOfTitanType);
        return patternType;
    }


}

