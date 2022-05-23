package Q23;

import java.util.Comparator;

public class TitanComparator implements Comparator<Pair> {


    @Override
    public int compare(Pair o1, Pair o2) {
        if (o1.getPairRisk() < o2.getPairRisk()) return 1;
        else if (o1.getPairRisk() > o2.getPairRisk()) return -1;
        return 0;
    }
}
