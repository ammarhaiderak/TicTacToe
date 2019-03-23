/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author ammar
 */
public interface MyView {
     public void displayWinner(int status);
     public void switchTurn();
     public void updateGrid();
}
