package newinstance;

public class ReceiveAction implements Action{
	
	public ReceiveAction() {
		System.out.println("ReceiveAction::ReceiveAction() invoked.");
	}
	@Override
	public void execute() {
		System.out.println("Receiving data...");
	}

	
} // end class
