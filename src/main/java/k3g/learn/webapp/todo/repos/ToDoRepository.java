package k3g.learn.webapp.todo.repos;

import java.util.List;

import k3g.learn.webapp.todo.model.ToDoItem;

public interface ToDoRepository {
	Long insert(ToDoItem item);
	List<ToDoItem> findAll();
	ToDoItem findById(Long id);
	void update(ToDoItem item);
	void delete(ToDoItem item);
}
