package animals;

import food.EFoodType;
import graphics.ZooPanel;
import diet.*;
import mobility.*;
/**
 *
 * @author shaked asido
 *
 */
public class Turtle extends Animal{

    public final static int defAge=1;
    public final static int minAge=0;
    public final static int maxAge=500;

    public static final double def_weight = 1;
    public static final Point def_location = new Point(80,0);



    private int age=1;

    /**
     * Constructor for the Turtle's name. It creates a specific Turtle, with a default location.
     *        represent the Turtle's name.
     */
    //Animal(String name, int size, double weight, int horSpeed, int verSpeed, String col, ZooPanel pan)
    public Turtle(int size, String col, int horSpeed, int verSpeed, ZooPanel pan) {
        super("Turtle", size, size*0.5, horSpeed, verSpeed, col, pan);
        setLocation(new Point(20,100));
        this.SetDiet(new Herbivore());
        this.SetWeight(size*0.5);
        loadImages("trt");
    }

    /**
     * Constructor for the Turtle's name. It creates a specific Turtle, with a default location.
     *        represent the Turtle's name.
     */

    public Turtle(int size, String col, int x_dir, int y_dir, int horSpeed, int verSpeed, ZooPanel pan) {
        super("Turtle", size, size*0.5, horSpeed, verSpeed, col, pan);
        setLocation(new Point(x_dir,y_dir));
        this.SetDiet(new Herbivore());
        this.SetWeight(size*0.5);
        loadImages("trt");
    }

    public Turtle(String s)
    {
        this(s,def_location);

    }

    public Turtle(String s, Point p)
    {
        this(s,p,def_weight);

    }

    public Turtle(String s, Point p, double w)
    {
        this(s,p,w,defAge);
    }
    public Turtle(String s, Point p, double w, int a)
    {
        super(s,p);


        this.SetWeight(w);
        this.setAge(a);
        this.setDiet(new Herbivore());
    }

    public EFoodType getFoodType()
    {

        return EFoodType.MEAT;

    }

    public boolean setAge(int a)
    {
        boolean x=true;

        if(a<minAge||a>maxAge)
            x= false;
        else
            this.age=a;


        if(this.age==-1) // constructor call -> if a isnt valid, age must be initialized with default value
        {
            x=true;
            this.age=defAge;


        }
        return x;

    }

    public int getAge() {


        return this.age;

    }

    public String toString()
    {
        return  "[ Turtle]: "+this.getAnimalName();
    }

}