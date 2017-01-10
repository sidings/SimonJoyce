package Simon;

public class MoveGabriel implements MoveInterfaceJoyce {

private ButtonInterfaceJoyce button;	
	
	public MoveGabriel(ButtonInterfaceJoyce b) {
		this.button = b;
	}

	@Override
	public ButtonInterfaceJoyce getButton() {
		return button;
	}
}
