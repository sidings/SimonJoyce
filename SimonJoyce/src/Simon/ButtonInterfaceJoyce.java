package Simon;

import java.awt.Color;

import guiPractice.components.Action;
import guiPractice.components.Clickable;

public interface ButtonInterfaceJoyce extends Clickable {

	void setColor(Color color);

	void setX(int x);

	void setY(int y);
	
	void setAction(Action a);

	void highlight();

	void dim();

}
