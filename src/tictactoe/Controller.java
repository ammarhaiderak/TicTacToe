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
public class Controller {

    private MyView v;       //view
    private Grid g;         //model

    public Controller(MyView v, Grid g) {
        this.v = v;
        this.g = g;
    }

    public void markOnGrid(int rowIndex, int colIndex, int player) {

        if (g.addAt(rowIndex, colIndex, player)) 
        {    
            v.updateGrid();     //updates the grid in GUI 
            g.evaluate();       //evalues in model/Grid class                           
        }
    }

}
