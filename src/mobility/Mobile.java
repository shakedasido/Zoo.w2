package mobility;

/**
 *
 * @author shaked asido
 *
 */
public abstract class Mobile implements Ilocatable {
    private Point location; //current location
    private double totalDistance; // distance the object traveled>=0

    public Mobile(Point p)
    {
        this.location= new Point(p);
        this.totalDistance=0;
    }

    public void addTotalDistance(double d)
    {
        this.totalDistance+=d;

    }

    public double calcDistance(Point p)
    {
        return Math.sqrt(Math.pow(this.location.GetX()-p.GetX(), 2)+Math.pow(this.location.GetY()-p.GetY(),2));

    }

    public double move(Point p)
    {
        if(this.location.equals(p)||!Point.checkBoundaries(p)) return 0;

        double distance = this.calcDistance(p);

        this.addTotalDistance(distance);

        this.setLocation(p);

        return distance;
    }

    public Point getLocation(){return this.location;}
    public boolean setLocation(Point p)
    {
        this.location.setpoint(p);
        return true;

    }

}