package mobility;
/**
 *
 * @author tomer handali, shaked asido
 *
 */
public class Point {
    private int x;
    private int y;
    public static final int min_x=0;
    public static final int max_x=800;
    public static final int min_y=0;
    public static final int max_y=600;

    public Point(int x, int y) //throws IllegalArgumentException
    {
		/*if(x<min_x || x>max_x || y<min_y || y>max_y)
			throw new IllegalArgumentException
			("X range must be within ["+min_x+","+max_x+"]\n"
			+ "Y range must be within ["+min_y+","+max_y+"]\n");*/

        // wanted to add exception throw but problematic with exercise requirement to have a point with illegal values
        this.x=x;
        this.y=y;
    }
    public Point(Point other)
    {
        this.x=other.x;

        this.y=other.y;

    }


    public int GetX() {return this.x;}

    public int GetY() {return this.y;}

    public boolean setx(int x)
    {
        if(x<min_x || x>max_x)
            return false;

        this.x=x;
        return true;
    }

    public boolean sety(int y)
    {
        if(y<min_y||y>max_y)
            return false;

        this.y=y;
        return true;
    }

    public boolean setpoint(int x,int y)
    {
        if(!checkBoundaries(new Point(x,y)))
            return false;

        this.x=x;
        this.y=y;

        return true;
    }

    public boolean setpoint(Point other)
    {
        if(!checkBoundaries(other))
            return false;

        this.x=other.x;
        this.y=other.y;

        return true;
    }

    public boolean equals(Point other) {return this.x == other.x && this.y == other.y;}


    public static boolean checkBoundaries(Point p) { return p.x >= min_x && p.x <= max_x && p.y >= min_y && p.y <= max_y;}

    public String toString() {return ("( "+this.x+" , "+this.y+" )");}

}