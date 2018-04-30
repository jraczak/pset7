/**
*  TestSets.java
*
*  @version: Last Modified April 6, 2018
*  @author:  Henry Leitner
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class TestSets
{
  static void menu()
  {
     System.out.println ();
     System.out.print ("Type 1 to CREATE SET A\n");
     System.out.print ("Type 2 to CREATE SET B\n");
     System.out.print ("Type 3 to CREATE INTERSECTION (A * B)\n");
     System.out.print ("Type 4 to CREATE UNION (A + B)\n");
     System.out.print ("Type 5 to CREATE DIFFERENCE (A - B)\n");
     System.out.print ("Type 6 to DISPLAY CARDINALITY OF SET A\n");
     System.out.print ("Type 7 to DISPLAY CARDINALITY OF SET B\n");
     System.out.print ("Type 8 to TEST IF SET A IS SUBSET OF SET B\n");
     System.out.print ("Type 9 to TEST IF SET B IS SUBSET OF SET A\n");
     System.out.print ("Type any OTHER # to EXIT PROGRAM \n\n");
     System.out.print ("Command: ");
  }

  public static void main (String [] args)
  {

      //JFrame frame = new JFrame("Bitset Demo GUI");
      //frame.setSize(960, 600);
      //frame.getContentPane().setLayout(new BorderLayout());
      //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
      //String titleText = "Welcome to the Bitset demo interface!";
      //String introText = "<html> Use the controls below to create Bitsets and explore operations on " +
      //        "and between them. <br>Use the exit button at the bottom to quit the program.</html>";
      //JLabel titleLabel = new JLabel(titleText, JLabel.CENTER);
      //JLabel introLabel = new JLabel(introText, JLabel.CENTER);
//
      //JPanel northPanel = new JPanel();
      //northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
      //northPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
      //northPanel.add(titleLabel);
      //northPanel.add(introLabel);
      //frame.add(northPanel, BorderLayout.NORTH);
//
      //JPanel westPanel = new JPanel();
      //westPanel.setLayout(new GridBagLayout());
      //westPanel.setMaximumSize(new Dimension(75, 300));
      //GridBagConstraints westPanelConstraints = new GridBagConstraints();
//
      //String setAText = "<html>Create set A by typing integers less than 16, separated by spaces,<br>" +
      //        "and then pressing the create button.</html>";
      //JLabel setALabel = new JLabel(setAText);
      //westPanelConstraints.gridx = 0;
      //westPanelConstraints.gridy = 0;
      //westPanel.add(setALabel, westPanelConstraints);
//
      //frame.add(westPanel, BorderLayout.WEST);
//
//
      //frame.setVisible(true);

      Bitset setA = new Bitset (16);
      Bitset setB = new Bitset (8);

      //TODO Move UI construction to its own method to clean up main

      JFrame frame = new JFrame("Bitset Demo GUI");
      frame.setSize(960, 600);
      frame.getContentPane().setLayout(new GridBagLayout());
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      GridBagConstraints constraints = new GridBagConstraints();

      //String titleText = "Welcome to the Bitset demo interface!";
      String introText = "<html>Welcome to the Bitset demo interface!<br>" +
              "Use the controls below to create Bitsets and explore operations on " +
              "and between them. <br>Use the exit button at the bottom to quit the program.</html>";
      //JLabel titleLabel = new JLabel(titleText, JLabel.CENTER);
      JLabel introLabel = new JLabel(introText, JLabel.CENTER);
      constraints.gridx = 0;
      constraints.gridy = 0;
      constraints.gridwidth = 12;
      constraints.fill = GridBagConstraints.HORIZONTAL;
      constraints.anchor = GridBagConstraints.CENTER;
      constraints.insets = new Insets(10, 10, 10, 10);

      frame.add(introLabel, constraints);

      // BEGIN ROW 2

      constraints.gridx = 0;
      constraints.gridy = 1;
      constraints.gridwidth = 6;


      String setAText = "Add any SINGLE integer < 16 to add to set A";
      JLabel setALabel = new JLabel(setAText);
      setALabel.setForeground(Color.BLUE);
      String setBText = "Add any SINGLE integer < 8 to add to set B";
      JLabel setBLabel = new JLabel(setBText);
      setBLabel.setForeground(Color.RED);

      frame.add(setALabel, constraints);

      constraints.gridx = 6;
      constraints.gridy = 1;
      constraints.gridwidth = 6;

      frame.add(setBLabel, constraints);

      // BEGIN ROW 3

      constraints.gridx = 0;
      constraints.gridy = 2;
      constraints.gridwidth = 4;

      JTextField setATextField = new JTextField("", 20);
      frame.add(setATextField, constraints);

      constraints.gridx = 4;
      constraints.gridy = 2;
      constraints.gridwidth = 2;
      JButton createAButton = new JButton("Create A");
      frame.add(createAButton, constraints);

      constraints.gridx = 6;
      constraints.gridy = 2;
      constraints.gridwidth = 4;
      JTextField setBTextField = new JTextField("", 20);
      frame.add(setBTextField, constraints);
      constraints.gridx = 10;
      constraints.gridy = 2;
      constraints.gridwidth = 2;
      JButton createBButton = new JButton("Create B");
      frame.add(createBButton, constraints);

      // BEGIN ROW 4 (gridy=3)
      constraints.gridy = 3;

      JLabel inSetA = new JLabel("Set A: ");
      constraints.gridx = 0;
      constraints.gridwidth = 2;
      frame.add(inSetA, constraints);

      JLabel setAContents = new JLabel();
      setAContents.setForeground(Color.BLUE);
      constraints.gridx = 2;
      constraints.gridwidth = 4;
      frame.add(setAContents, constraints);

      JLabel inSetB = new JLabel("Set B: ");
      constraints.gridx = 6;
      constraints.gridwidth = 2;
      frame.add(inSetB, constraints);

      JLabel setBContents = new JLabel();
      setBContents.setForeground(Color.RED);
      constraints.gridx = 8;
      constraints.gridwidth = 4;
      frame.add(setBContents, constraints);


      // SET UP BUTTONS
      //TODO handle parse int error
      createAButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              setA.include(Integer.parseInt(setATextField.getText()));
              System.out.println("Updated Set A: " + setA.toString());
              setAContents.setText(setA.toString());
              setATextField.setText("");
              //TODO Add cardinality update
          }
      });

      createBButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              setB.include(Integer.parseInt(setBTextField.getText()));
              setBContents.setText(setB.toString());
              setBTextField.setText("");
              //TODO: Add cardinality update
          }
      });


      //JPanel northPanel = new JPanel();
      //northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
      //northPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
      //northPanel.add(titleLabel);
      //northPanel.add(introLabel);
      //frame.add(northPanel, BorderLayout.NORTH);
//
      //JPanel westPanel = new JPanel();
      //westPanel.setLayout(new GridBagLayout());
      //westPanel.setMaximumSize(new Dimension(75, 300));
//
      //String setAText = "<html>Create set A by typing integers less than 16, separated by spaces,<br>" +
      //        "and then pressing the create button.</html>";
      //JLabel setALabel = new JLabel(setAText);
      //westPanel.add(setALabel);
//
      //frame.add(westPanel, BorderLayout.WEST);


      frame.setVisible(true);

     int command;

     Scanner keyboard = new Scanner (System.in);
     do
     {
         menu();

         switch (command = keyboard.nextInt ())
         {
            case 1:
              System.out.println ("Type some small integers, each < 16"
                                 + ", and type DONE when all done!");
              setA.readSet(keyboard);
              System.out.print ("     SET A = " + setA);
              break;

            case 2:
              System.out.println ("Type some small integers, each < 8"
                                 + ", and type DONE when all done!");
              setB.readSet(keyboard);
              System.out.print ("     SET B = " + setB);
              break;

           case 3:
              System.out.print ("     Intersection (A * B) = ");
              System.out.print (setA.intersect(setB));
              break;

	       case 4:
              System.out.print ("     Union (A + B) = ");
              System.out.print (setA.union(setB));
              break;

           case 5:
              System.out.print ("     Difference (A - B) = ");
              System.out.print (setA.difference(setB));
              break;

             case 6:
                 System.out.print("Cardinality of Set A: ");
                 System.out.print(setA.cardinality());
                 break;

             case 7:
                 System.out.print("Cardinality of Set B: ");
                 System.out.print(setB.cardinality());
                 break;

             case 8:
                 System.out.print("Set A is subset of Set B: ");
                 System.out.print(setA.isSubset(setB));
                 break;

             case 9:
                 System.out.print("Set B is subset of Set A: ");
                 System.out.print(setB.isSubset(setA));
                 break;

           default:  System.exit(0);

         }
       } while (command > 0 && command < 10);
  }
}
