package Simon;

import java.awt.Color;
import java.util.ArrayList;

import guiPractice8.component.Action;
import guiPractice8.component.Button;
import guiPractice8.component.TextLabel;
import guiPractice8.component.Visible;
import guiPractice8.ClickableScreen;

public class SimonScreenJoyce extends ClickableScreen implements Runnable {

	private ArrayList<MoveInterfaceJoyce> moves;
	private TextLabel label;
	private ButtonInterfaceJoyce[] button;
	private ProgressInterfaceJoyce progress;
	
	private int roundNumber;
	private boolean incomingInput;
	private int sequenceIndex;
	private int lastSelectedButton;
	

	public SimonScreenJoyce(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();

	}

	@Override
	public void run() {
		label.setText("");
	    nextRound();
	}

	public void nextRound() {
		incomingInput = false;
		roundNumber++;
		moves.add(randomMove());
		progress.setRound(roundNumber);
		progress.setSequenceNum(moves.size());
		changeText("Follow the color sequence!");
		label.setText("");
		playSequence();
		changeText("Your turn.");
		incomingInput = true;
		sequenceIndex =0;
		
	}

	private void playSequence() {
		ButtonInterfaceJoyce b =null;
		for(MoveInterfaceJoyce sequence: moves){
			if(b!=null)//{
				b.dim();
				b=sequence.getButton();
				b.highlight();
				int sleepTime = (int)(long)(1500*(2.0/(roundNumber+2)));
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
		b.dim();
	}

	private void changeText(String string) {
		try{
			label.setText(string);
			Thread.sleep(600);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		addButtons(viewObjects);
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Simon Game");
		moves = new ArrayList<MoveInterfaceJoyce>();
		lastSelectedButton = -1;
		moves.add(randomMove());
		moves.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
	}

	private MoveInterfaceJoyce randomMove() {
		int select = (int) (Math.random()*button.length);
		while(select == lastSelectedButton){
			select = (int) (Math.random()*button.length);
		}
		lastSelectedButton = select;
		return new MoveGabriel(button[select]);
	}

	private MoveInterfaceJoyce getMove(ButtonInterfaceJoyce b) {
		return null;
	}

	private ProgressInterfaceJoyce getProgress() {
		return new ProgressGabriel();
	}

	public void addButtons(ArrayList<Visible> viewObjects) {
		int numberOfButtons = 6;
		Color[] colorArray = {Color.red, Color.blue, new Color(240,160,70), new Color(20,255,140), Color.yellow, new Color(180,90,210)};
		button = new ButtonInterfaceJoyce[numberOfButtons];
		for(int i =0; i <numberOfButtons;i++){
			button[i] = getAButton();
			button[i].setColor(colorArray[i]);
			button[i].setX(160 + (int)(50+(50*i)));
			button[i].setY(200);
			final ButtonInterfaceJoyce b = button[i];
			b.dim();
			b.setAction(new Action(){
				public void act(){
					if(incomingInput){
						Thread blink = new Thread(new Runnable(){
							
							public void run(){
								b.highlight();
								try{
									Thread.sleep(400);
								} catch (InterruptedException e){
									e.printStackTrace();
								}
								b.dim();
							}
							
						});
						
						blink.start();
						
						if(incomingInput && moves.get(sequenceIndex).getButton() == b){
							sequenceIndex++;
						}
						else if(incomingInput){
							progress.gameOver();
							return;
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
		return new ButtonGabriel();
	}
		

}