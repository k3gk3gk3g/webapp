package k3g.learn.webapp.todo;

import k3g.learn.webapp.todo.model.ToDoItem;
import k3g.learn.webapp.todo.repos.ToDoRepository;

public class ToDoCommand {
	private CommandEnum cmd;
	private ToDoItem item;
	
	public CommandEnum getCmd() {
		return cmd;
	}

	public void setCmd(CommandEnum cmd) {
		this.cmd = cmd;
	}

	public ToDoItem getItem() {
		return item;
	}

	public void setItem(ToDoItem item) {
		this.item = item;
	}

	public enum CommandEnum {
		INSERT, UPDATE, GET, LIST_ALL, DELETE;
	}

	public void execute(ToDoRepository rep) {
		switch (this.getCmd()) {
		case INSERT:
			System.out.println("Saved todo item with id" + rep.insert(item));
			break;
		case UPDATE:
			rep.update(item);
			System.out.println("Updated todo item: " + rep.findById(item.getId()));
			break;
		case GET:
			System.out.println("Todo item: " + rep.findById(item.getId()));
			break;
		case DELETE:
			rep.delete(item);
			System.out.println("Deleted todo item with id: " + item.getId());
			break;
		case LIST_ALL:
			System.out.println("Listing all todo items:");
			for (ToDoItem item: rep.findAll()) {
				System.out.println(item);
			}
			break;
		default:;
		}
	}
}
