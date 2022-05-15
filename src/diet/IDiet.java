package diet;
import food.*;
import animals.*;
/**
 *
 * @author shaked asido
 *
 */
public interface IDiet {
    boolean canEat(EFoodType food);
    double eat(Animal animal, IEdible food);}