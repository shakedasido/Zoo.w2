package food;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.Ilocatable;
import mobility.Point;

/**
 *
 * @author tomer handali 206751489
 * This class is intended to create a meat object to add to the screen with feed option
 */
public class Meat implements IEdible, Ilocatable, IDrawable{

    private Point location=null;
    private boolean eaten=false;
    private ZooPanel pan;
    private BufferedImage img;
    private int size;

    public Meat(ZooPanel p)
    {
        this.pan=p;
        this.location=new Point(Point.max_x/2,Point.max_y/2);
        this.size=50;
        loadImages("meat");

    }

    @Override
    public void loadImages(String nm) {


        BufferedImage image = null;

        try { image= ImageIO.read(new File(PICTURE_PATH + nm+ ".gif")); }
        catch (IOException e) { System.out.println("Cannot load image"); }

        img=image;

    }
    public String getPath() {return"assignment2_pictures//meat.gif";}

    @Override
    public void drawObject(Graphics g) {
        g.drawImage(img, this.getLocation().GetX()/*-size/2*/, Point.max_y- this.getLocation().GetY() -size/2, size, size, pan);


    }

    @Override
    public String getColor() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Point getLocation() {
        return this.location;
    }

    @Override
    public boolean setLocation(Point p) {

        this.location=p;

        return true;
    }

    @Override
    public EFoodType getFoodType() {
        return EFoodType.MEAT;

    }



}