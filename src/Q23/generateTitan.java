package Q23;

import java.util.*;

public class generateTitan {
  
    private int numTitans;
    private int[] indexed ;
    private ArrayList<Pair> sorted;
    private ArrayList<Pair> data = new ArrayList<>();
    private int distanceTravelled =0;
    private  PriorityQueue<Pair> pq;


    public generateTitan() {
    }

    public ArrayList<Pair> getSorted() {
        return sorted;
    }


    public int getNumTitans() {
        return numTitans;
    }

    /**
     * Method that generates random number of titans and prints it out
     * it also calculates distance taken to get to the titan
     */
    public ArrayList<Pair> generateTitan(int numTitans) {
        this.numTitans = numTitans;



        for (int i = 0; i < numTitans; i++) {
            data.add(new Pair(i + 1, randomTitanType()));


        }

        System.out.println(data);
        return data;


    }

    /**
     * Method that sorts titan according to its priority
     * @param data an unsorted list of titans
     * @return a sorted queue of titans
     */

    public PriorityQueue<Pair> sortTitan(ArrayList<Pair> data){

        pq = new PriorityQueue<Pair>(data.size(), new TitanComparator());
        for(int i=0; i< data.size();i++){
            pq.add(data.get(i));
        }
        System.out.println(pq);
        return pq;

    }

    /**
     * add more random titans to the list
     * @param num number of titans to be added
     * @param data a list with the added titans
     */
    public void addTitan(int num, ArrayList<Pair> data){
        this.data = data;

        for (int i = numTitans; i < numTitans+num; i++) {
            data.add(new Pair(i +1, randomTitanType()));
        }

        this.numTitans = numTitans+num;
        System.out.println(data);


    }

    /**
     * Calculates distance taken to kill the titans
     * @param pq accepts a sorted list of titans
     */
    public void calculateDistance(PriorityQueue<Pair> pq) {

        indexed = new int[getNumTitans()];
        sorted= new ArrayList<>();
        while (!pq.isEmpty()) {
            for (int i = 0; i < getNumTitans(); i++) {
                sorted.add(pq.poll());
                indexed[i] = sorted.get(i).getIndex();
                System.out.print("Titan " + indexed[i] + "->");
            }

        }


        distanceTravelled = getSumDiference(indexed);
        System.out.println("\nTotal distance moved: " + distanceTravelled + "\n");



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
    private Titan randomTitanType() {
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

