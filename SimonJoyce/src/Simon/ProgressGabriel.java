package Simon;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice8.component.Component;

public class ProgressGabriel extends Component implements ProgressInterfaceJoyce {

	private boolean gameOver;
	private String round;
	private String moves;
	
	public ProgressGabriel() {
		super(60, 60, 120, 50);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setRound(int roundNumber) {
		round = "Round "+roundNumber;
		update();
	}

	@Override
	public void setSequenceNum(int sequenceNumber) {
		moves = "                     Sequence length "+sequenceNumber;
		update();
	}

	@Override
	public void gameOver() {
		gameOver = true;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		FontMetrics fm = g.getFontMetrics();
		if(gameOver){
			g.setColor(new Color(255,55,90));
			g.fillOval(0, 0, 120, 70);
			g.setColor(Color.white);
			String go = "GAME OVER!";
			g.drawString(go, (120 - fm.stringWidth(go))/2, 20);
			g.drawString(moves, (50 - fm.stringWidth(moves))/2, 40);

		}else{
			g.setColor(new Color(220,255,230));
			g.fillOval(0, 0, 120,70);
			g.setColor(Color.black);
			g.drawOval(0, 0, 120-1, 70-1);
			if(round !=null && moves != null){

				g.drawString(round, (120 - fm.stringWidth(round))/2, 20);
				g.drawString(moves, (50 - fm.stringWidth(moves))/2, 40);
			}
		}
	}


}
