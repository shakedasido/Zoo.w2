package diet;

import food.*;
import animals.*;
/**
 *
 * @author shaked asido
 *
 */
public class Herbivore implements IDiet {

    public boolean canEat(EFoodType food)
    {
        return food == EFoodType.VEGETABLE;
    }
    public double eat(Animal animal, IEdible food)
    {
        if(!canEat(food.getFoodType()))
            return 0;

        return animal.getWeight()*0.07;
    }

    public String toString()
    {
        return "[Herbivore]";

    }
}