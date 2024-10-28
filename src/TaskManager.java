import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la interfaz ITaskManager, que gestiona la asignación y
 * almacenamiento de tareas, usuarios y proyectos.
 * Cumple con el principio de Inversión de Dependencias (DIP) al depender
 * de las interfaces ITask, IUser e IProject en lugar de sus implementaciones.
 * También sigue el principio Abierto/Cerrado (OCP) al permitir la extensión
 * mediante nuevas implementaciones de las interfaces, sin modificar el código
 * de TaskManager.
 */
public class TaskManager implements ITaskManager {
    private List<IUser> users;
    private List<IProject> projects;
    private List<ITask> tasks;

    public TaskManager() {
        this.users = new ArrayList<>();
        this.projects = new ArrayList<>();
        this.tasks = new ArrayList<>();
    }

    public void addUser(IUser user) { users.add(user); }
    public void addProject(IProject project) { projects.add(project); }
    public void assignTaskToUser(ITask task, IUser user) { user.assignTask(task); }
    public void addTaskToProject(ITask task, IProject project) { project.addTask(task); }
    public void addTask(ITask task) { tasks.add(task); }

    public ITask findTaskByTitle(String title) {
        for (ITask task : tasks) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                return task;
            }
        }
        return null;
    }

    public IUser findUserByName(String name) {
        for (IUser user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    public IProject findProjectByName(String name) {
        for (IProject project : projects) {
            if (project.getName().equalsIgnoreCase(name)) {
                return project;
            }
        }
        return null;
    }
}
