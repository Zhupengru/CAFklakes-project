package CAApp.edu.neu.cyse6200.app;

import java.util.logging.Logger;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 * A sample canvas that draws a rainbow of squares
 * @author MMUNSON
 */
public class CACanvas extends JPanel {

	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(CACanvas.class.getName());
    //private int cellSize = 20;
    private Color col = null;
    private long counter = 0L;
    private CAFlake Flake = new CAFlake(65);
    private CARule change  = new CARule();
    private int depth;
    private int depth1;
    private int rule;
	
    /**
     * CellAutCanvas constructor
     */
	public CACanvas() {
		col = Color.WHITE;
	}
	public CACanvas(CAFlake setFlake, int setDepth, int setRule){
		Flake = setFlake;
		depth = setDepth;
		depth1 = depth * 2;
		rule = setRule;
	}
	public CACanvas(int setDepth, int setRule){
		depth = setDepth;
		depth1 = depth * 2;
		rule = setRule;
	}
	

	/**
	 * The UI thread calls this method when the screen changes, or in response
	 * to a user initiated call to repaint();
	 */
	public void paint(Graphics g) {
		drawCellularAutomaton(g); // Our Added-on drawing
		
    }
	
	/**
	 * Draw the CA graphics panel
	 * @param g
	 */
	public void drawCellularAutomaton(Graphics g) {
		log.info("Drawing cell automation " + counter++);
		Graphics2D g2d = (Graphics2D) g;
		Dimension size = getSize();
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, size.width, size.height);
		
		g2d.setColor(Color.GREEN);
		g2d.drawString("BEGIN THE SHOW!!", 10, 15);
		
		int maxRows = 65;//size.height / cellSize;
		int sizei = size.width/maxRows;
		int oldsizei = sizei;
		int maxCols = 65;//size.width / cellSize;
		int sizej = (size.height - 20)/maxCols;
		int oldsizej = sizej;
		//flake = new int[65][65];
		if (rule == 3){
			for (int j = 0; j < maxRows; j++) {
				   for (int i = 0; i < maxCols; i++) {
					   int redVal = validColor(255- Math.abs(i+j - 32)*4);
					   int greenVal = validColor(255 - Math.abs(i+j - 32)*4);
					   int blueVal = validColor(255 -Math.abs(i+j - 32)*4);
					   if (Flake.flake[i + 1][j + 1] == 1)
						   col = new Color(redVal, greenVal, blueVal);
					   else col = Color.BLACK;
					   // Draw box, one pixel less to create a black outline
					   if (i % 2 == 0)
						   paintRect( g2d, i*sizei, j*sizej+20, sizei - 1, sizej - 1, col);
					   else
						   paintRect( g2d, i*sizei, j*sizej+20 + sizej / 2 , sizei - 1, sizej - 1, col);
					   
				   }
			}
			/*for(int i = 1; i < 66; i++){
				for (int j = 1; j < 66; j++){
					if (Flake.flake[i][j] == 1) System.out.print("■"+" ");
					else System.out.print("□"+" ");
				}
				System.out.println();
			}
			System.out.println("\n");*/
			if (depth > 0){
				Flake.flake = change.ruleSimpleHex(Flake.flake, 65);
				depth-=1;
			}
		}
		else if (rule == 2){
			for (int j = 0; j < maxRows; j++) {
				   for (int i = 0; i < maxCols; i++) {
					   int redVal = validColor(255- Math.abs(i+j - 32)*4);
					   int greenVal = validColor(255 - Math.abs(i+j - 32)*4);
					   int blueVal = validColor(255 -Math.abs(i+j - 32)*4);
					   if (Flake.flake[i + 1][j + 1] == 1)
						   col = new Color(redVal, greenVal, blueVal);
					   else col = Color.BLACK;
					   // Draw box, one pixel less to create a black outline
					   if (i % 2 == 0)
						   paintRect( g2d, i*sizei, j*sizej+20, sizei - 1, sizej - 1, col);
					   else
						   paintRect( g2d, i*sizei, j*sizej+20, sizei - 1, sizej - 1, col);
					   
				   }
			}
			/*for(int i = 1; i < 66; i++){
				for (int j = 1; j < 66; j++){
					if (Flake.flake[i][j] == 1) System.out.print("■"+" ");
					else System.out.print("□"+" ");
				}
				System.out.println();
			}
			System.out.println("\n");*/
			if (depth > 0){
				Flake.flake = change.rule(Flake.flake, 65);
				depth-=1;
			}
		}
		if (rule == 1){
			for (int j = 0; j < maxRows; j++) {
				   for (int i = 0; i < maxCols; i++) {
					   int redVal = validColor(255- Math.abs(i+j - 32)*4);
					   int greenVal = validColor(255 - Math.abs(i+j - 32)*4);
					   int blueVal = validColor(255 -Math.abs(i+j - 32)*4);
					   if (Flake.flake[i + 1][j + 1] == 1)
						   col = new Color(redVal, greenVal, blueVal);
					   else col = Color.BLACK;
					   // Draw box, one pixel less to create a black outline
					   if (i % 2 == 0)
						   paintRect( g2d, i*sizei, j*sizej+20, sizei - 1, sizej - 1, col);
					   else
						   paintRect( g2d, i*sizei, j*sizej+20 + sizej / 2 , sizei - 1, sizej - 1, col);
					   
				   }
			}
			/*for(int i = 1; i < 66; i++){
				for (int j = 1; j < 66; j++){
					if (Flake.flake[i][j] == 1) System.out.print("■"+" ");
					else System.out.print("□"+" ");
				}
				System.out.println();
			}
			System.out.println("\n");*/
			if (depth > 0){
				Flake.flake = change.ruleHex(Flake.flake, 65);
				depth--;
			}
		}
	}
	
	/*
	 * A local routine to ensure that the color value is in the 0 to 255 range;
	 */
	private int validColor(int colorVal) {
		if (colorVal > 255)
			colorVal = 255;
		if (colorVal < 0)
			colorVal = 0;
		return colorVal;
	}
	
	/*
	 * A convenience routine to set the color and paint a square
	 * @param g2d the graphics context
	 * @param x horizontal offset in pixels
	 * @param y vertical offset in pixels
	 * @param size the square size in pixels
	 * @param color the color to draw
	 */
	private void paintRect(Graphics2D g2d, int x, int y, int sizei, int sizej, Color color) {
		g2d.setColor(color);
		g2d.fillRect(x, y, sizei, sizej);
	}
	
}
