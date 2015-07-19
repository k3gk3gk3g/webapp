package k3g.learn.webapp.todo;

import java.io.Console;

import k3g.learn.webapp.todo.input.CommandLineHelper;
import k3g.learn.webapp.todo.repos.ReposFactory;
import k3g.learn.webapp.todo.repos.ToDoRepository;

public class ToDoApp {
	public static void main(String[] args) {
		ToDoApp app = new ToDoApp();
		app.execute(args);
	}

	public void execute(String[] args) {
		ToDoRepository rep = ReposFactory.getToDoRepository();
		Console c = System.console();
		if (c==null) {
			throw new RuntimeException("No console.");
		}
		
		String login = c.readLine("Enter your login: ");
		String password = new String(c.readPassword("Enter your password: "));
		
		if ("mypasswd".equals(password)) {
			System.out.println("Valid password");
		} else {
			System.out.println("Incorrect password..... ");
			login = c.readLine("Enter your login: ");
			password = new String(c.readPassword("Enter your password: "));
			
			if ("mypasswd".equals(password)) {
				System.out.println("Valid password");
			} else {
				System.out.println("Invalid password... Exiting");
				System.exit(1);
			}
		}
		
		CommandLineHelper ch = new CommandLineHelper(c, rep);
		while(true){
			ToDoCommand cmd = ch.handleUserInput();
			if (cmd != null) {
				cmd.execute(rep);
			}
		}
	}
}
