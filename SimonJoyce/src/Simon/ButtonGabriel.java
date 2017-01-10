package Simon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice8.component.Action;
import guiPractice8.component.Component;

public class ButtonGabriel extends Component implements ButtonInterfaceJoyce {
	
	private boolean selected;
	private Color color;
	private Action action;
	private Color selectedColor;

	public ButtonGabriel() {
		super(0, 0, 50, 50);
	}

	@Override
	public void act() {
		action.act();
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
		update();
	}

	@Override
	public void setAction(Action action) {
		this.action = action;
	}

	@Override
	public void highlight() {
		selected= true;
		selectedColor = color;
		update();
	}

	@Override
	public void dim() {
		selectedColor = Color.gray;
		selected = false;
		update();
	}

	@Override
	public boolean isHovered(int x, int y) {
		double distance = Math.sqrt(Math.pow(x-(getX()+50/2), 2)+Math.pow(y-(getY()+50/2), 2));
		return distance < 50/2;
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(selectedColor != null){
			g.setColor(selectedColor);
		}
		else{
			g.setColor(Color.gray);
		}
		g.fillOval(0, 0, 50, 50);
		g.setColor(Color.black);
		g.drawOval(0, 0, 50-1, 50-1);
		if(selected){
			g.setColor(Color.white);
			
		}
	}

}
