import java.util.Date;

/**
 * Representa una interfaz para una tarea (Task) en el sistema.
 * Cumple con el principio de Segregación de Interfaces (ISP) al definir
 * solo los métodos específicos necesarios para una tarea.
 */
public interface ITask {
    String getTitle();
    void setTitle(String title);
    String getDescription();
    void setDescription(String description);
    Date getDueDate();
    void setDueDate(Date dueDate);
    boolean isCompleted();
    void markAsCompleted();
}
