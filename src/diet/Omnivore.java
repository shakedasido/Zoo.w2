package diet;

import food.*;
import animals.*;
/**
 *
 * @author shaked asido
 *
 */
public class Omnivore implements IDiet {

    public boolean canEat(EFoodType food)
    {
        Carnivore c = new Carnivore();
        Herbivore h = new Herbivore();

        return c.canEat(food) || h.canEat(food);
    }

    public double eat(Animal animal, IEdible food)
    {
        Carnivore c=new Carnivore();
        Herbivore h = new Herbivore();

        if(c.canEat(food.getFoodType()))
            return c.eat(animal, food);
        else if(h.canEat(food.getFoodType()))
            return h.eat(animal, food);

        return 0;
    }

    public String toString()
    {
        return "[Omnivore]";

    }

}