package Simon;

import guiPractice.components.Visible;

public interface ProgressInterfaceJoyce extends Visible {

	void gameOver();

	void setRound(int roundNumber);

	void setSequenceNum(int size);

}
