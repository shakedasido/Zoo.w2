package graphics;
import animals.Animal;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;


public class MoveAnimalDialog extends JDialog implements ItemListener, ActionListener {

    private JButton ok;
    private JSlider xDirSelection, yDirSelection;
    private Animal chosenAnimal;
    private JRadioButton[] Select1;
    private ZooPanel pan;
    private ArrayList<Animal> animalArrayList = new ArrayList<>(); //List of all the animals, max 10
    private String txt = null;

    public MoveAnimalDialog(ZooPanel pan, ArrayList<Animal> animalArrayList2, String title)
    {
        super(new JFrame(),title,true);
        this.pan = pan;
        setSize(700,50*(animalArrayList.size()+1)+400);
        animalArrayList.addAll(animalArrayList2);
        setLayout(new BorderLayout());
        MoveAnimalPanel();
    }

    public void MoveAnimalPanel()
    {

        JPanel AnimalChoice = new JPanel();
        JPanel CoordinatesPanel = new JPanel();
        JPanel OkAndCancelButtons = new JPanel();

        //Add Animal:
        //kind of animal
        AnimalChoice.setLayout(new GridLayout(animalArrayList.size(),1,10,0));
        AnimalChoice.setBorder(BorderFactory.createTitledBorder("Choose a kind of an animal: "));
        ButtonGroup AnimalsButton = new ButtonGroup();
        Select1 =new JRadioButton[animalArrayList.size()];

        int i=0;
        for(Animal animal : animalArrayList)
        {
            txt = animal.getAnimalName()+": Color: "+animal.getColor()+
                    ", Location: (" + animal.getLocation().GetX() +", "+animal.getLocation().GetY() + "), Speed: ("+animal.getHorSpeed()+
                    ", "+ animal.getVerSpeed()+" )";
            Select1[i] = new JRadioButton(txt, false);
            Select1[i].addItemListener(this);
            AnimalsButton.add(Select1[i]);
            AnimalChoice.add(Select1[i]);
            i++;
        }
        Select1[0].setSelected(true);


        //Coordinates of an animal
        CoordinatesPanel.setLayout(new GridLayout(2,2,25,-25));

        //X Coordinate of an animal
        JLabel XCoordinate = new JLabel("X Coordinate: ",JLabel.CENTER);
        CoordinatesPanel.add(XCoordinate);

        //Y Coordinate of an animal
        JLabel YCoordinate = new JLabel("Y Coordinate: ",JLabel.CENTER);
        CoordinatesPanel.add(YCoordinate);


        //Scale of the X Coordinate and Y Coordinate of the animal
        xDirSelection = new JSlider(0,800);
        xDirSelection.setMajorTickSpacing(100);
        xDirSelection.setMinorTickSpacing(10);
        xDirSelection.setMinorTickSpacing(1);
        xDirSelection.setPaintTicks(true);
        xDirSelection.setPaintLabels(true);
        CoordinatesPanel.add(xDirSelection);

        //Scale of the Horizontal speed of the animal
        yDirSelection = new JSlider(0,800);
        yDirSelection.setMajorTickSpacing(100);
        yDirSelection.setMinorTickSpacing(10);
        yDirSelection.setMinorTickSpacing(1);
        yDirSelection.setPaintTicks(true);
        yDirSelection.setPaintLabels(true);
        CoordinatesPanel.add(yDirSelection);


        OkAndCancelButtons.setLayout(new GridLayout(1,2,3,0));
        ok = new JButton("Ok");
        ok.addActionListener(this);
        ok.setBackground(new Color(167, 199, 231));  //light blue
        OkAndCancelButtons.add(ok);

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        cancel.setBackground(new Color(167, 199, 231));
        OkAndCancelButtons.add(cancel);


        add("North", AnimalChoice);
        add("Center" , CoordinatesPanel);
        add("South" , OkAndCancelButtons);
    }

    public void itemStateChanged(ItemEvent e)
    {
        int i=0;
        for(Animal an : animalArrayList)
        {
            if(Select1[i].isSelected())
            {
                chosenAnimal = an;
                break;
            }
            i++;
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == ok) //the user typed on the "Ok" button
        {
            //add the animal to the animals list as the user required.
            pan.MoveAnimal(chosenAnimal, xDirSelection.getValue(), yDirSelection.getValue());
            setVisible(false);
        }
        setVisible(false);
    }
}