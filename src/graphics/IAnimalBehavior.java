package graphics;

/***
 * @author shaked asido
 */
public interface IAnimalBehavior {

    String getAnimalName();
    int getSize();
    void eatInc();
    int getEatCount();
    boolean getChanges();
    void setChanges (boolean state);

}
