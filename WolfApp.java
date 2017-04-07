package CAApp.edu.neu.cyse6200.app;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * A Test application for the Wolfram Celular Autonomon application
 * 
 * @author MMUNSON
 *
 */
public class WolfApp extends CAApp {

	private static Logger log = Logger.getLogger(WolfApp.class.getName());

	protected JPanel northPanel = null;
	protected JButton startSquare = null;
	protected JButton startSimpleHex = null;
	protected JButton startHex = null;
	protected JButton pauseBtn = null;
	protected JButton stopBtn = null;
	private CACanvas caPanel = null;
	private int depth = 24;
	Thread myThread;

	/**
	 * Sample app constructor
	 */
	public WolfApp() {
		caPanel = new CACanvas(depth, 1);
		frame.setSize(900, 1000);
		frame.setTitle("WolfApp");
		frame.add(caPanel, BorderLayout.CENTER); // Add to the center of our
		frame.setVisible(true); // The UI is built, so display it
	}

	

	public JPanel getNorthPanel() {
		northPanel = new JPanel();
		northPanel.setLayout(new FlowLayout());

		startSquare = new JButton("Square");
		startSquare.addActionListener(this); // Allow the app to hear about button
		northPanel.add(startSquare);

		startSimpleHex = new JButton("SimpleHex"); // Allow the app to hear about button
		startSimpleHex.addActionListener(this);
		northPanel.add(startSimpleHex);
		
		startHex = new JButton("Hex"); // Allow the app to hear about button
		startHex.addActionListener(this);
		northPanel.add(startHex);
		
		pauseBtn = new JButton("Pause"); // Allow the app to hear about button
		pauseBtn.addActionListener(this);
		northPanel.add(pauseBtn);
		
		stopBtn = new JButton("Stop"); // Allow the app to hear about button
		stopBtn.addActionListener(this);
		northPanel.add(stopBtn);

		return northPanel;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		log.info("We received an ActionEvent " + ae);
		if (ae.getActionCommand().equalsIgnoreCase("Hex")) {
			myThread = new Thread(){
				public void run(){
					CAFlake test = new CAFlake(65);
					CARule change = new CARule();
					for (int i = 0 ; i < depth * 2; i++){
						//caPanel = new CACanvas(test);
						//frame.setSize(1000, 1000);
						//frame.setTitle("WolfApp");
						//frame.add(caPanel, BorderLayout.CENTER); // Add to the center of our
						//frame.setVisible(true);
						caPanel.repaint();
						//test.flake = change.ruleHex(test.flake, 65);
						try{
							Thread.sleep(200);
						} catch (Exception ex){}
					}
				}
			};
			myThread.start();
			System.out.println("Start pressed");
		} else if (ae.getActionCommand().equalsIgnoreCase("Pause")) {
			myThread.stop();
			System.out.println("Stop pressed");
		} else if (ae.getActionCommand().equalsIgnoreCase("Stop")) {
			myThread.stop();
			caPanel = new CACanvas(depth, 1);
			frame.setSize(900, 1000);
			frame.setTitle("WolfApp");
			frame.add(caPanel, BorderLayout.CENTER); // Add to the center of our
			frame.setVisible(true);
			System.out.println("Stop pressed");
		}
		else if (ae.getActionCommand().equalsIgnoreCase("Square")) {
			myThread = new Thread(){
				public void run(){
					CAFlake test = new CAFlake(65);
					CARule change = new CARule();
					frame.remove(caPanel);
					caPanel = new CACanvas(test, depth, 2);
					frame.setSize(1000, 1000);
					frame.setTitle("WolfApp");
					frame.add(caPanel, BorderLayout.CENTER); // Add to the center of our
					frame.setVisible(true);
					for (int i = 0 ; i < depth; i++){
						
						caPanel.repaint();
						//test.flake = change.ruleHex(test.flake, 65);
						try{
							Thread.sleep(200);
						} catch (Exception ex){}
					}
				}
			};
			myThread.start();
			System.out.println("Start pressed");
		}
		else if (ae.getActionCommand().equalsIgnoreCase("SimpleHex")) {
			myThread = new Thread(){
				public void run(){
					CAFlake test = new CAFlake(65);
					CARule change = new CARule();
					frame.remove(caPanel);
					caPanel = new CACanvas(test, depth, 3);
					frame.setSize(900, 1000);
					frame.setTitle("WolfApp");
					frame.add(caPanel, BorderLayout.CENTER); // Add to the center of our
					frame.setVisible(true);
					for (int i = 0 ; i < depth; i++){
						
						caPanel.repaint();
						//test.flake = change.ruleHex(test.flake, 65);
						try{
							Thread.sleep(200);
						} catch (Exception ex){}
					}
				}
			};
			myThread.start();
			System.out.println("Start pressed");
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// log.info("Window opened");
	}

	@Override
	public void windowClosing(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// log.info("Window iconified");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// log.info("Window deiconified");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// log.info("Window activated");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		log.info("Window deactivated");
	}

	/**
	 * Sample Wolf application starting point
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		WolfApp wapp = new WolfApp();
		// log.info("WolfApp started");

	}
}

/*class MyRunnable implements Runnable{
	public void run(){}
}*/
