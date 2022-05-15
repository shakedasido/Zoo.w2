package animals;
import graphics.*;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import diet.*;
import food.*;
import mobility.*;
/**
 *
 * @author shaked asido
 *
 */
public abstract class Animal extends Mobile implements IEdible,IDrawable,IAnimalBehavior{

    private String name;
    private double weight=0;
    private IDiet diet;

    private final int EAT_DISTANCE = 10;
    private int size;
    private String col;
    private int horSpeed;
    private int verSpeed;
    private boolean coordChanged;
    private Thread thread;
    private int x_dir=1;
    private int y_dir=1;
    private int eatCount;
    private ZooPanel pan;
    private BufferedImage img1, img2;

    public Animal(String kind, int size, double weight, int horSpeed, int verSpeed, String col, ZooPanel pan)
    {
        super(new Point(0,0));
        this.name = kind;
        this.size=size;
        this.weight = weight;
        this.horSpeed = horSpeed;
        this.verSpeed = verSpeed;
        this.col = col;
        this.pan = pan;
        this.pan.repaint();
    }

    public Animal(String s, Point p)
    {
        super(p);
        setName(s);

    }


    private boolean setName(String s) {
        this.name=s;
        return true;
    }


    public double getWeight() {


        return this.weight;

    }

    public String getAnimalName() {

        //MessageUtility.logGetter(this.name, "getName", this.name);

        return this.name;

    }

    public boolean SetWeight(double weight)
    {
        boolean isSuccess = (weight >= 0);
        if (isSuccess)
        {
            this.weight = weight;
        }
        else
        {
            this.weight = 0;
        }
        return isSuccess;
    }

    protected boolean setDiet(IDiet d)
    {
        this.diet=d;

        return true;

    }

    public boolean eat(IEdible other)
    {
        boolean x=true;
        double wad=diet.eat(this, other);

        if(wad==0)
            x = false;
        else
        {
            this.SetWeight(this.weight+wad);
        }


        return x;
    }

    public double move(Point p)
    {
        double d=super.move(p);

        double w=this.getWeight();

        this.SetWeight(w-(d*w*0.00025));

        this.coordChanged=true;

        boolean x= (d==0?false:true);


        return d;
    }
    public abstract EFoodType getFoodType();

    public int getEatDistance() {return this.EAT_DISTANCE;}

    @Override
    public String getColor()
    {

        return col;
    }

    @Override
    public int getEatCount() {
        // TODO Auto-generated method stub
        return eatCount;
    }

    @Override
    public void eatInc() {
        eatCount++;

    }

    public int getSize() {return this.size;}

    @Override
    public boolean getChanges() {return this.coordChanged;}
    public void setChanges (boolean state) {this.coordChanged=state;}

    public int getHorSpeed() {return this.horSpeed;}
    public int getVerSpeed() {return this.verSpeed;}

    //nm=name
    @Override
    public void loadImages(String nm) {
        String color = this.col;
        switch(color) {
            case "Red":
                try {
                    img1 = ImageIO.read(new File(PICTURE_PATH + nm + "_r_1.png"));
                    img2 = ImageIO.read(new File(PICTURE_PATH + nm + "_r_2.png"));
                }
                catch (IOException e) { System.out.println("Cannot load image"); }
                break;
            case "Blue":
                try {
                    img1 = ImageIO.read(new File(PICTURE_PATH + nm + "_b_1.png"));
                    img2 = ImageIO.read(new File(PICTURE_PATH + nm + "_b_2.png"));
                }
                catch (IOException e) { System.out.println("Cannot load image"); }
                break;
            case "Natural":
                try {
                    img1 = ImageIO.read(new File(PICTURE_PATH + nm+ "_n_1.png"));
                    img2 = ImageIO.read(new File(PICTURE_PATH + nm+ "_n_2.png"));
                }
                catch (IOException e) { System.out.println("Cannot load image"); }
                break;
            default:
                System.out.println("Cannot load image");
        }
    }

    public boolean isChange() {return this.coordChanged;}

    public void resetChange() {this.coordChanged=false;}

    public void drawObject (Graphics g)
    {

        if(x_dir==1) // animal goes to the right side
            g.drawImage(img1, this.getLocation().GetX()-size/2, this.getLocation().GetY() -size/10, size, size, pan);
        else // animal goes to the left side
            g.drawImage(img2, this.getLocation().GetX(), this.getLocation().GetY() -size/10, size, size, pan);
    }

    public boolean SetDiet(IDiet diet)
    {
        this.diet=diet;
        return true;
    }


}