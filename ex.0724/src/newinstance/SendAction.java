package newinstance;

public class SendAction implements Action{
	
//	public SendAction() {
//		System.out.println("SendAction::SendAction() invoked.");
//	}

	public SendAction(String actionName, int age) {
		System.out.println("SendAction::SendAction(actionName) invoked.");
	}
	
	@Override
	public void execute() {
	System.out.println("Sending data...");
		
	}

}
