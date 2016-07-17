
package gameoflife;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JPanel implements ActionListener, ChangeListener {
  private Timer     timer;
  private Board     board;
  private JButton   start;
  private JButton   clear;
  private JButton   add;
  private JSlider   pred;
  private JComboBox figures;
  private JFrame    frame;
  private int iterNum  = 0;
  private final int maxDelay  = 500;
  private final int initDelay = 50;
  private boolean running   = false;

  public GUI(JFrame jf) {
    frame = jf;
    timer = new Timer(initDelay, this);
    timer.stop();
  }

  public void initialize(Container container) {
    container.setLayout(new BorderLayout());
    container.setSize(new Dimension(1024, 768));

    JPanel buttonPanel = new JPanel();

    start = new JButton("Start");
    start.setActionCommand("Start");
    start.setToolTipText("Starts clock");
    start.addActionListener(this);

    clear = new JButton("Clear");
    clear.setActionCommand("clear");
    clear.setToolTipText("Clears the board");
    clear.addActionListener(this);

    add = new JButton("Add");
    add.setActionCommand("add");
    add.setToolTipText("Adds predefined pattern");
    add.addActionListener(this);

    figures = new JComboBox(Pattern.setPattern());
    figures.setToolTipText("Pattern choice");

    pred = new JSlider();
    pred.setMinimum(0);
    pred.setMaximum(maxDelay);
    pred.setToolTipText("Time speed");
    pred.addChangeListener(this);
    pred.setValue(maxDelay - timer.getDelay());

    buttonPanel.add(start);
    buttonPanel.add(clear);
    buttonPanel.add(figures);
    buttonPanel.add(add);
    buttonPanel.add(pred);

    board = new Board(1024, 768 - buttonPanel.getHeight());
    container.add(board, BorderLayout.CENTER);
    container.add(buttonPanel, BorderLayout.SOUTH);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource().equals(timer)) {
      iterNum++;
      frame.setTitle("Game of Life (" + Integer.toString(iterNum) + " iteration)");
      board.iteration();
    } 
    else {
      String command = e.getActionCommand();
      if (command.equals("Start")) {
        if (!running) {
          timer.start();
          start.setText("Pause");
        }
        else {
          timer.stop();
          start.setText("Start");
        }
        running = !running;
        clear.setEnabled(true);
      } 
      else if (command.equals("clear")) {
        iterNum = 0;
        timer.stop();
        start.setEnabled(true);
        board.clear();
        frame.setTitle("Game Of Life");
      } 
      else if (command.equals("add")) {
        board.loadPattern((Pattern) figures.getSelectedItem());
      }

    }
  }

  public void stateChanged(ChangeEvent e) {
    timer.setDelay(maxDelay - pred.getValue());
  }
}
