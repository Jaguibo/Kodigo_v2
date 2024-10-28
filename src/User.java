import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la interfaz IUser que representa un usuario en el sistema.
 * Cumple con el principio de Responsabilidad Única (SRP), ya que solo
 * gestiona los datos y tareas asignadas a un usuario específico.
 */
public class User implements IUser {
    private String name;
    private String email;
    private List<ITask> tasks;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.tasks = new ArrayList<>();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public void assignTask(ITask task) { tasks.add(task); }
    public List<ITask> getTasks() { return tasks; }
}
