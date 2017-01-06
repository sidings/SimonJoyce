package Simon;

import java.awt.Color;
import java.util.ArrayList;

import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import guiPractice.sampleGames.ClickableScreen;

public class SimonScreenJoyce extends ClickableScreen implements Runnable {

	private ProgressInterfaceJoyce progress;
	private ArrayList<MoveInterfaceJoyce> moves;
	private ButtonInterfaceJoyce[] buttons;
	private TextLabel text;
	private boolean userTurn;
	private int roundNumber;
	private int sequenceIndex;
	private int lastSelectedButton;
	
	public SimonScreenJoyce(int width, int height) {
		super(width, height);
		Thread play = new Thread(this);
		play.start();
	}

	@Override
	public void run() {
		text.setText("");
	    nextRound();
	}

	private void nextRound() {
		userTurn = false;
		roundNumber++;
		moves.add(randomMove());
		progress.setRound(roundNumber);
		progress.setSequenceNum(moves.size());
		changeText("Simon's Turn!");
		playSequence();
		changeText("Your Turn!");
		userTurn = true;
		sequenceIndex = 0;
	}

	private void playSequence() {
		ButtonInterfaceJoyce b;
		b = null;
		for(int i = 0; i < moves.size(); i++){
			if (b != null)b.dim();
			b = moves.get(i).getButton();
			b.highlight();
			int sleepTime = 5000/(roundNumber+1);
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		b.dim();
	}

	private void changeText(String string) {
		try {
			text.setText(string);
			Thread.sleep(1000);
			text.setText("");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		addButtons(viewObjects);
		progress = getProgress();
		moves = new ArrayList<MoveInterfaceJoyce>();
		text = new TextLabel(130, 230, 300, 40, "Let's play Simon!");
		lastSelectedButton = -1;
		moves.add(randomMove());
		moves.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(text);
	}

	private MoveInterfaceJoyce randomMove() {
		Button b;
		int idx = (int) (Math.random()*buttons.length);
		while (idx == lastSelectedButton){
			idx = (int) (Math.random()*buttons.length);
		}
		b = (Button) buttons[idx];
		return getMove(b);
	}

	private MoveInterfaceJoyce getMove(Button b) {
		return null;
	}

	private void addButtons(ArrayList<Visible> viewObjects) {
		int numberOfButtons = 6;
		Color[] colorArr = {Color.yellow, Color.blue, Color.green, Color.red, Color.orange, Color.MAGENTA};
		for(int i = 0; i < numberOfButtons; i++){
			final ButtonInterfaceJoyce b = getAButton();
			b.setColor(colorArr[i]);
			b.setX(30*i + 30);
			b.setY(50);
			b.setAction(new Action(){
				public void act(){
					if(userTurn){
						Thread blink = new Thread(new Runnable(){

							public void run() {
								b.highlight();
								try {
									Thread.sleep(800);
									b.dim();
								} catch (InterruptedException e) {
									e.printStackTrace();
								}
							}
							
						});
						blink.start();
						if (b == moves.get(sequenceIndex).getButton()) sequenceIndex ++;
						else{
							progress.gameOver();
						}
						if(sequenceIndex == moves.size()){
							Thread nextRound = new Thread(SimonScreenJoyce.this);
							nextRound.start();
						}
					}
				}
			});
			viewObjects.add(b);
		}
	}

	private ButtonInterfaceJoyce getAButton() {
		// TODO Auto-generated method stub
		return null;
	}

	private ProgressInterfaceJoyce getProgress() {
		return null;
	}

}
