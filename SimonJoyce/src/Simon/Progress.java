package Simon;

import java.awt.Graphics2D;

import guiPractice8.component.Component;

public class Progress extends Component implements ProgressInterfaceJoyce {

	private String round;
	
	public Progress(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRound(int roundNumber) {
		round = "Round" +roundNumber;

	}

	@Override
	public void setSequenceNum(int size) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Graphics2D arg0) {
		// TODO Auto-generated method stub

	}

}
