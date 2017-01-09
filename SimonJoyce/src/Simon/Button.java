package Simon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;

import guiPractice8.component.Action;
import guiPractice8.component.Component;

public class Button extends Component implements ButtonInterfaceJoyce {
	
	private Action action;
	private Color color;
	private boolean selected;
	private Color selectedColor;

	public Button(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void act() {
		action.act();
	}

	@Override
	public boolean isHovered(int x, int y) {
		double distance = Math.sqrt(Math.pow(x-(getX()+60/2), 2)+Math.pow(y-(getY()+60/2), 2));

		return distance < 60/2;
	}

	@Override
	public void setColor(Color c) {
		this.color = c;
		selectedColor=c;
		update();
	}

	@Override
	public void setAction(Action a) {
		this.action = a;

	}

	@Override
	public void highlight() {
		if(color != null){
			selectedColor = color;
		}
		selected = true;
		update();

	}

	@Override
	public void dim() {
		selectedColor = Color.gray;
		selected= false;
		update();

	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(selectedColor != null){
			g.setColor(selectedColor);
		}
		else g.setColor(Color.gray);
		g.fillOval(0, 0, 60,60 );
		g.setColor(Color.black);
		g.drawOval(0, 0, 59, 59);
		if(selected){
			g.setColor(Color.white);
			Polygon p = new Polygon();
			int s = (int)(5/8.0 * 60);
			int t = (int)(1.0/5*60)+4;
			p.addPoint(s-4, t-4);
			p.addPoint(s+7, t-2);
			p.addPoint(s+10, t);
			p.addPoint(s+14, t+10);
			p.addPoint(s+12, t+14);
			p.addPoint(s+8, t+3);
			g.fill(p);
		}
	}

}
