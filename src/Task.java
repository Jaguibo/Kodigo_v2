import java.util.Date;

/**
 * Implementación de la interfaz ITask que representa una tarea en el sistema.
 * Cumple con el principio de Responsabilidad Única (SRP), ya que solo
 * gestiona los datos y el estado de una tarea específica.
 */
public class Task implements ITask {
    private String title;
    private String description;
    private Date dueDate;
    private boolean isCompleted;

    public Task(String title, String description, Date dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = false;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Date getDueDate() { return dueDate; }
    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }
    public boolean isCompleted() { return isCompleted; }
    public void markAsCompleted() { isCompleted = true; }
}
