package k3g.learn.webapp.todo.repos.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import k3g.learn.webapp.todo.model.ToDoItem;
import k3g.learn.webapp.todo.repos.ToDoRepository;

public class InMemoryToDoRepository implements ToDoRepository {
	private AtomicLong currentId = new AtomicLong();
	private ConcurrentHashMap<Long, ToDoItem> toDos = new ConcurrentHashMap<>();

	public Long insert(ToDoItem item) {
		Long id = currentId.incrementAndGet();
		item.setId(id);
		toDos.putIfAbsent(id, item);
		return id;
	}

	public List<ToDoItem> findAll() {
		List<ToDoItem> itemList = new ArrayList<>(toDos.values());
		Collections.sort(itemList);
		return itemList;
	}

	public ToDoItem findById(Long id) {
		return toDos.get(id);
	}

	public void update(ToDoItem item) {
		toDos.replace(item.getId(), item);
	}

	public void delete(ToDoItem item) {
		toDos.remove(item.getId());
	}

}
