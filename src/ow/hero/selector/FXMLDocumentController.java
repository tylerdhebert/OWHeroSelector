/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ow.hero.selector;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import java.util.Scanner;
import java.io.File;
import java.util.Random;

/**
 *
 * @author Tyler
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    TextField playerNameTextField1 = new TextField();
    
    @FXML
    TextField playerNameTextField2 = new TextField();
    
    @FXML
    TextField playerNameTextField3 = new TextField();
    
    @FXML
    TextField playerNameTextField4 = new TextField();
    
    @FXML
    TextField playerNameTextField5 = new TextField();
    
    @FXML
    TextField playerNameTextField6 = new TextField();
    
    @FXML
    Button addPlayerButton = new Button();
    
    @FXML
    Button generateHeroesButton = new Button();
    
    @FXML
    GridPane GridPane = new GridPane();
    
    @FXML
    Button resetButton = new Button();
    
    
    String p1 = "";
    String p2 = "";
    String p3 = "";
    String p4 = "";
    String p5 = "";
    String p6 = "";
    int firstTime = 0;
    
    @FXML
    private void addPlayerButtonPressed(ActionEvent event) {
        int row = GridPane.getRowIndex(addPlayerButton);
        
        switch (row) {
            case 2:
                GridPane.setRowIndex(addPlayerButton, 3);
                playerNameTextField2.setVisible(true);
                break;
            case 3:
                GridPane.setRowIndex(addPlayerButton, 4);
                playerNameTextField3.setVisible(true);
                break;
            case 4:
                GridPane.setRowIndex(addPlayerButton, 5);
                playerNameTextField4.setVisible(true);
                break;
            case 5:
                GridPane.setRowIndex(addPlayerButton, 6);
                playerNameTextField5.setVisible(true);
                break;
            case 6:
                GridPane.setRowIndex(addPlayerButton, 7);
                playerNameTextField6.setVisible(true);
                addPlayerButton.setVisible(false);
                playerNameTextField1.requestFocus();
                break;
            
        }
            
    }
    
    @FXML
    private void generateHeroesButtonPressed(ActionEvent event)
    {
        int fileIterator = 0;
        int tempIndex;
        
        
        String tempHero;
        String heroList[] = new String[29];
        String teamComp[] = new String[6];
        Random rand = new Random(System.currentTimeMillis());

        
        try (Scanner scanner = new Scanner(new File("hero_list.txt"))) {
            
            while (scanner.hasNextLine())
            {
                heroList[fileIterator] = scanner.nextLine();
                fileIterator++;
            }        
        } catch (Exception e) { e.printStackTrace(); }
        
        for (int i = 0; i < 6; i++)
	{

		tempIndex = (rand.nextInt(29-i) + 0);
		teamComp[i] = heroList[tempIndex];
		tempHero = heroList[28 - i];
		heroList[28 - i] = heroList[tempIndex];
		heroList[tempIndex] = tempHero;
		
	}
        
        if (firstTime == 0)
        {
        p1 = playerNameTextField1.getText();
        p2 = playerNameTextField2.getText();
        p3 = playerNameTextField3.getText();
        p4 = playerNameTextField4.getText();
        p5 = playerNameTextField5.getText();
        p6 = playerNameTextField6.getText();
        firstTime++;
        }
        
        
        playerNameTextField1.setText(p1 + " will play " + teamComp[0]);
        playerNameTextField2.setText(p2 + " will play " + teamComp[1]);
        playerNameTextField3.setText(p3 + " will play " + teamComp[2]);
        playerNameTextField4.setText(p4 + " will play " + teamComp[3]);
        playerNameTextField5.setText(p5 + " will play " + teamComp[4]);
        playerNameTextField6.setText(p6 + " will play " + teamComp[5]);
        
        playerNameTextField1.setFocusTraversable(false);
        playerNameTextField2.setFocusTraversable(false);
        playerNameTextField3.setFocusTraversable(false);
        playerNameTextField4.setFocusTraversable(false);
        playerNameTextField5.setFocusTraversable(false);
        playerNameTextField6.setFocusTraversable(false);
        
        playerNameTextField1.setEditable(false);
        playerNameTextField2.setEditable(false);
        playerNameTextField3.setEditable(false);
        playerNameTextField4.setEditable(false);
        playerNameTextField5.setEditable(false);
        playerNameTextField6.setEditable(false);
        
 }
    
    @FXML
    private void resetButtonPressed(ActionEvent event)
    {
        firstTime = 0;
        playerNameTextField1.setText("");
        playerNameTextField2.setText("");
        playerNameTextField3.setText("");
        playerNameTextField4.setText("");
        playerNameTextField5.setText("");
        playerNameTextField6.setText("");
        
        
        playerNameTextField2.setVisible(false);
        playerNameTextField3.setVisible(false);
        playerNameTextField4.setVisible(false);
        playerNameTextField5.setVisible(false);
        playerNameTextField6.setVisible(false);
        
        playerNameTextField1.setFocusTraversable(true);
        playerNameTextField2.setFocusTraversable(true);
        playerNameTextField3.setFocusTraversable(true);
        playerNameTextField4.setFocusTraversable(true);
        playerNameTextField5.setFocusTraversable(true);
        playerNameTextField6.setFocusTraversable(true);
        
        playerNameTextField1.setEditable(true);
        playerNameTextField2.setEditable(true);
        playerNameTextField3.setEditable(true);
        playerNameTextField4.setEditable(true);
        playerNameTextField5.setEditable(true);
        playerNameTextField6.setEditable(true);
        
        GridPane.setRowIndex(addPlayerButton, 2);
        addPlayerButton.setVisible(true);
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
