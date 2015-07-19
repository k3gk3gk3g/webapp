package k3g.learn.webapp.todo.repos;

import k3g.learn.webapp.todo.repos.impl.InMemoryToDoRepository;

public class ReposFactory {
	private static ToDoRepository repos = new InMemoryToDoRepository();
	
	public static ToDoRepository getToDoRepository() {
		return repos; 
	}
}
