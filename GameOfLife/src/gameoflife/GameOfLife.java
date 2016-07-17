
package gameoflife;

import javax.swing.*;

public class GameOfLife extends JFrame {

  private GUI gof;

  public GameOfLife() {
    setTitle("Game of Life");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gof = new GUI(this);
    gof.initialize(getContentPane());
    setSize(768, 540);
    setVisible(true);
  }

  public static void main(String[] args) {
    new GameOfLife();
  }

}
