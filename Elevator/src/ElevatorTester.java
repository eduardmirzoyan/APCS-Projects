
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ElevatorTester extends JPanel implements ActionListener {

  private JButton[] buttons;
  private JButton act;
  private Elevator theElevator;
  
  private JButton save;
  private JButton load;
  
  public ElevatorTester() {
  	super(new BorderLayout());
  	
  	buttons = new JButton[3];
  	buttons[0] = new JButton("1");
  	buttons[1] = new JButton("2");
  	buttons[2] = new JButton("3");
  	act = new JButton("ACT");
  	
  	save = new JButton("Save");
  	load = new JButton("Load");
  	
  	for(JButton b : buttons)
  		b.setBackground(Color.LIGHT_GRAY);
  	
  	theElevator = new Elevator(act,buttons);
  	add(theElevator, BorderLayout.CENTER);
  	
  	JPanel right = new JPanel(new GridLayout(1,2));
  	JPanel top = new JPanel();
  	JPanel bottom = new JPanel();
  	
  	JPanel buttonBox = new JPanel(new GridLayout(3,1));
  	for (int i = 2; i >= 0; i--) {
  		JButton b = buttons[i];
  		b.addActionListener(this);
  		buttonBox.add(b);
  	}
  	top.add(buttonBox);
  	right.add(top);
  	
  	act.addActionListener(this);
  	bottom.add(act);
  	right.add(act);
  	
  	save.addActionListener(this);
  	right.add(save);
  	load.addActionListener(this);
  	right.add(load);
  	
  	add(right, BorderLayout.NORTH);
  }
  
  
  public void actionPerformed(ActionEvent e) {
  	for (int i = 0; i < 3; i++) {
  		if (e.getSource() == buttons[i]) {
  			theElevator.pushButton(i);
  			return;
  		}
  	}
  	if (e.getSource() == act) {
  		theElevator.act();
  	}
  	if (e.getSource() == save) {
  		Elevator.saveState(theElevator, "selevator.esf");
  	}
  	if (e.getSource() == load) {
  		Elevator newE = Elevator.loadState("selelavor.esf");
  		if(newE == null) {
  			return;
  		}
  		newE.initializeGUI(act, buttons);
  		remove(theElevator);
  		theElevator = newE;
  		add(theElevator);
  		revalidate();
  		repaint();
  	}
  
  		
  }
  
	
  public static void main(String[] args)
  {
    JFrame w = new JFrame("Elevator Simulation");
    w.setBounds(100, 100, 480, 640);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ElevatorTester panel = new ElevatorTester();
    w.add(panel);
    w.setResizable(true);
    w.setVisible(true);
    
  }
	
}
