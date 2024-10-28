import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la interfaz IProject que representa un proyecto en el sistema.
 * Cumple con el principio de Responsabilidad Única (SRP) al encargarse solo
 * de la gestión de tareas en el contexto de un proyecto.
 */
public class Project implements IProject {
    private String name;
    private List<ITask> tasks;

    public Project(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public void addTask(ITask task) { tasks.add(task); }
    public List<ITask> getTasks() { return tasks; }
}
