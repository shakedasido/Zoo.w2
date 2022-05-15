package diet;

import food.*;
import animals.*;

/**
 *
 * @author shaked asido
 *
 */
public class Carnivore implements IDiet {
    public boolean canEat(EFoodType food)
    {

        return food == EFoodType.MEAT;

    }
    public double eat(Animal animal, IEdible food)
    {

        if(!canEat(food.getFoodType()))
            return 0;


        return animal.getWeight()*0.1;

    }

    public String toString()
    {
        return "[Carnivore]";

    }


}