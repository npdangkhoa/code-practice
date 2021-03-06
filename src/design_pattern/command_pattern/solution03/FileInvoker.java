package design_pattern.command_pattern.solution03;

public class FileInvoker {
	private Command command;

	public FileInvoker(Command command) {
		this.command = command;
	}
	
	public void execute() {
		command.execute();
	}	
}
