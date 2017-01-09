package Simon;

public class Move implements MoveInterfaceJoyce {

	private ButtonInterfaceJoyce button;
	
	public Move(ButtonInterfaceJoyce b) {
		this.button = b;
	}

	@Override
	public ButtonInterfaceJoyce getButton() {
		return button;
	}

}
