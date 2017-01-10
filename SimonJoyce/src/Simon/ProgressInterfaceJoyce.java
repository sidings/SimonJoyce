package Simon;

import guiPractice8.component.Visible;

public interface ProgressInterfaceJoyce extends Visible {

	void setRound(int roundNumber);
	
	void setSequenceNum(int sequenceNumber);
		
	void gameOver();
}
