import java.util.List;

/**
 * Representa una interfaz para un proyecto en el sistema.
 * Cumple con el principio de Segregación de Interfaces (ISP),
 * proporcionando solo los métodos necesarios para un proyecto.
 */
public interface IProject {
    String getName();
    void setName(String name);
    void addTask(ITask task);
    List<ITask> getTasks();
}
