package k3g.learn.webapp.todo.model;

public class ToDoItem implements Comparable<ToDoItem> {
	private Long id;
	
	private String label;
	
	private boolean isCompleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	@Override
	public int compareTo(ToDoItem o) {
		return (this.id == o.id) ? 0 : ((this.id > o.id) ? 1 : -1);
	}
	
	@Override
	public String toString() {
		return "{id:" + id + ", label:'" + label + "', isCompleted:" + isCompleted + "}";
	}
}
