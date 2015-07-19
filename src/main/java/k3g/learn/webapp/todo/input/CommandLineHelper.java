package k3g.learn.webapp.todo.input;

import java.io.Console;

import k3g.learn.webapp.todo.ToDoCommand;
import k3g.learn.webapp.todo.ToDoCommand.CommandEnum;
import k3g.learn.webapp.todo.model.ToDoItem;
import k3g.learn.webapp.todo.repos.ToDoRepository;

public class CommandLineHelper {
	Console console;
	ToDoRepository rep;

	public CommandLineHelper(Console c, ToDoRepository rep) {
		console = c;
		this.rep = rep;
	}

	public ToDoCommand handleUserInput() {
		ToDoCommand cmd = null;

		String helpMsg = "\nChoose from following options: \n"
				+ "'c' for create todo item, it will prompt for details about new item\n"
				+ "'a' for listing all todo items\n"
				+ "'u' for updating a signup entry\n"
				+ "'g' to display an existing entry\n"
				+ "'d' for deleting an entry\n" + "'e' for exit";
		System.out.println(helpMsg);
		String line = console.readLine();
		if (line.equals("c")) {
			System.out.println("What is label for new todo item:");
			line = console.readLine();
			ToDoItem item = new ToDoItem();
			item.setLabel(line);
			item.setCompleted(false);
			cmd = new ToDoCommand();
			cmd.setCmd(CommandEnum.INSERT);
			cmd.setItem(item);
		} else if (line.equals("a")) {
			cmd = new ToDoCommand();
			cmd.setCmd(CommandEnum.LIST_ALL);
		} else if (line.equals("u")) {
			System.out.println("What is id of the existing todo item:");
			line = console.readLine();
			Long id = Long.parseLong(line);
			System.out.println("What is new label for existing todo item:");
			line = console.readLine();
			String label = line;
			System.out
					.println("Do you want to mark this todo item completed [true/false]:");
			line = console.readLine();
			boolean isCompleted = Boolean.parseBoolean(line);
			ToDoItem item = new ToDoItem();
			item.setId(id);
			item.setLabel(label);
			item.setCompleted(isCompleted);
			cmd = new ToDoCommand();
			cmd.setCmd(CommandEnum.UPDATE);
			cmd.setItem(item);
		} else if (line.equals("g")) {
			System.out.println("What is todo item id:");
			line = console.readLine();
			Long id = Long.parseLong(line);
			ToDoItem item = new ToDoItem();
			item.setId(id);
			cmd = new ToDoCommand();
			cmd.setCmd(CommandEnum.GET);
			cmd.setItem(item);
		} else if (line.equals("d")) {
			System.out.println("What is todo item id for delete:");
			line = console.readLine();
			Long id = Long.parseLong(line);
			ToDoItem item = new ToDoItem();
			item.setId(id);
			cmd = new ToDoCommand();
			cmd.setCmd(CommandEnum.DELETE);
			cmd.setItem(item);
		} else if (line.equals("e")) {
			System.out.println("Exiting...");
			System.exit(0);
		}

		return cmd;
	}
}
