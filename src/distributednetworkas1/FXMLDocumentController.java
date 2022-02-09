/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributednetworkas1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Carlos Garcia
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Button button;

    @FXML
    private Text decryptedEcnrypted;

    @FXML
    private TextArea inputText;
    
    @FXML
    private TextArea outputText;

    @FXML
    private RadioButton encryptRadio;
    
    @FXML
    private RadioButton decyptRadio;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        button.setOnAction(event ->
        {
            encryptOrDecypt();
        });
        
        
    } 
    public void encryptOrDecypt(){
        if(encryptRadio.isSelected())
        {
            decryptedEcnrypted.setText("The encrypted message is:");
            encryptMessage();
        }
        else if(decyptRadio.isSelected())
        {
            decryptedEcnrypted.setText("The decrypted message is:");
            decryptedMessage();
        }
    }
    public void encryptMessage(){
        String[] plainText = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", " ", ",", ".", ":", ";", "-", "!"};
        String[] cipherText = {" ", "v", "r", ";", "i", "c", "o", "s", "m", "j", ":", "h", "w", "q", "g", "n", "x", "d", "p", "z", "!", "e", ",", "b", "u", ".", "k", "f", "y", "a", "l", "-", "t"};
    
        String output = inputText.getText();
        String temp = "";
        String encypted = "";
        for(int i = 0; i < output.length(); i++)
        {
            temp = String.valueOf(output.charAt(i));
            for(int j = 0; j < plainText.length; j++)
            {
                String encryptLetter = plainText[j];
                if(encryptLetter.equalsIgnoreCase(temp))
                {
                    encypted = encypted + cipherText[j];
                    j = plainText.length;
                }
                else if(j+1 == plainText.length)
                {
                    encypted = encypted + temp;
                }
            }
        }
        outputText.setText(encypted);
    }
     public void decryptedMessage(){
        String[] plainText = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", " ", ",", ".", ":", ";", "-", "!"};
        String[] cipherText = {" ", "v", "r", ";", "i", "c", "o", "s", "m", "j", ":", "h", "w", "q", "g", "n", "x", "d", "p", "z", "!", "e", ",", "b", "u", ".", "k", "f", "y", "a", "l", "-", "t"};
    
        String output = inputText.getText();
        String temp = "";
        String deencypted = "";
        for(int i = 0; i < output.length(); i++)
        {
            temp = String.valueOf(output.charAt(i));
            for(int j = 0; j < cipherText.length; j++)
            {
                String encryptLetter = cipherText[j];
                if(encryptLetter.equalsIgnoreCase(temp))
                {
                    deencypted = deencypted + plainText[j];
                    j = cipherText.length;
                }
                else if(j+1 == cipherText.length)
                {
                    deencypted = deencypted + temp;
                }
            }
        }
        outputText.setText(deencypted);
    }
    
    @FXML
    private Button exitButton;

    @FXML
    void close(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    
}
