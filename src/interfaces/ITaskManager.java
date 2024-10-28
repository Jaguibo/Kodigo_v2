/**
 * Interfaz para gestionar tareas, usuarios y proyectos en el sistema.
 * Cumple con el principio de Inversión de Dependencias (DIP) al depender
 * de abstracciones en lugar de implementaciones concretas.
 */
public interface ITaskManager {
    void addUser(IUser user);
    void addProject(IProject project);
    void assignTaskToUser(ITask task, IUser user);
    void addTaskToProject(ITask task, IProject project);
}
