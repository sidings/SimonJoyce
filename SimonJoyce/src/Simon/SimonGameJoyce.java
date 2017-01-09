package Simon;

import guiPractice8.GUIApplication;

public class SimonGameJoyce extends GUIApplication {

	public static void main(String[] args){
		SimonGameJoyce game = new SimonGameJoyce();
		Thread app = new Thread(game);
		app.start();
	}
	
	public SimonGameJoyce() {
		
	}

	@Override
	protected void initScreen() {
		SimonScreenJoyce ssj = new SimonScreenJoyce(getWidth(), getHeight());
		setScreen(ssj);
	}

}
