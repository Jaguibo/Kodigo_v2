import java.util.List;

/**
 * Representa una interfaz para un usuario en el sistema.
 * Segrega solo los métodos específicos que un usuario necesita
 * de acuerdo con el principio de Segregación de Interfaces (ISP).
 */
public interface IUser {
    String getName();
    void setName(String name);
    String getEmail();
    void setEmail(String email);
    void assignTask(ITask task);
    List<ITask> getTasks();
}
