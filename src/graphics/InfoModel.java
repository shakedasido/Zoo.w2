package graphics;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import animals.Animal;

/**
 *
 * @author tomer handali 206751489
 * this class is intended to be model for jtable to present info for animal array
 */
public class InfoModel extends AbstractTableModel{

    private ArrayList<Animal> arr; // animal array - data
    private final String[] columnNames= {"Animal","Color","Weight","Hor. speed","Ver. speed","Eat Counter"}; //column names

    public InfoModel(ArrayList<Animal> a)
    {
        this.arr=a;
    }

    @Override
    public int getRowCount() {

        return arr.size()+1; //row count is array size plus total eat count row
    }

    @Override
    public int getColumnCount() {

        return 6; // number of columns
    }

    public String getColumnName(int column) {return columnNames[column];} // column names

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Animal animal;

        if(rowIndex!=arr.size())
        {
            animal=arr.get(rowIndex);

            switch(columnIndex){ // a switch to return all animals data in the table

                case 0: return animal.getAnimalName();
                case 1: return animal.getColor();
                case 2: return animal.getWeight();
                case 3: return animal.getHorSpeed();
                case 4: return animal.getVerSpeed();
                case 5: return animal.getEatCount();

            }
        }
        else if(columnIndex==0) {return "Total";}
        else if(columnIndex==5)
        {
            int eatSum=0;
            for (Animal animal1 : arr) eatSum += animal1.getEatCount(); //calculating total eat count
            return eatSum;
        }
        return null;
    }
}