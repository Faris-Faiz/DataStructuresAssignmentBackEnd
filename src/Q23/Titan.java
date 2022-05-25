package Q23;

import Q24.Vertex;

public class Titan {

    private int height;
    private int legs;
    private int speed;
    protected int risk;
    private boolean climb;
    private String pattern;
    private Vertex location;
    private Vertex[] path = new Vertex[3];


    public Titan() {
    }

    public Titan(int height, int legs, int speed, String pattern, boolean climb) {
        this.height = height;
        this.legs = legs;
        this.speed = speed;
        this.pattern = pattern;
        this.climb = climb;

    }


    public Vertex[] getPath() {
        return path;
    }

    public void setPath(Vertex[] path) {
        path[0] = getLocation();
        this.path = path;
    }


    public Vertex getLocation() {
        return location;
    }

    public void setLocation(Vertex location) {
        this.location = location;
    }



    public int getHeight() {
        return height;
    }

    public int getHeightRisk() {
        if (height > 20) return 3;
        else if (height > 10) return 2;
        else return 1;


    }

    public int getLegs() {
        return legs;
    }

    public int getLegsRisk() {
        if (legs == 0) return 1;
        else if (legs == 2) return 2;
        else if (legs == 4) return 3;
        return 0;
    }

    public int getSpeed() {
        return speed;
    }

    public int getSpeedRisk() {
        if (speed > 20) return 3;
        else if (speed > 10) return 2;
        else return 1;

    }

    public int getRisk() {
        this.risk = getHeightRisk() + getLegsRisk() + getSpeedRisk() + getPatternRisk() + getClimbRisk();
        return this.risk;
    }

    public boolean isClimb() {
        return climb;
    }

    public int getClimbRisk() {
        if (isClimb()) return 3;
        else return 1;
    }

    public String getPattern() {
        return pattern;
    }

    public int getPatternRisk() {
        if (this.pattern.equals("not repeated pattern")) return 3;
        else if (this.pattern.equals("repeated pattern")) return 2;
        else return 1;

    }

    @Override
    public String toString() {
        return "\nTitan{" + "height=" + height + ", legs=" + legs + ", speed=" + speed + ", climb=" + climb + ", pattern='" + pattern + '\'' + ", risk=" + getRisk() + '}';
    }



}
