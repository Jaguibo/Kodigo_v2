import java.util.Date;

public class TaskFactory {
    // Método para crear una instancia de ITask
    public ITask createTask(String title, String description, Date dueDate) {
        return new Task(title, description, dueDate);
    }

    // Método para crear una instancia de IUser
    public IUser createUser(String name, String email) {
        return new User(name, email);
    }

    // Método para crear una instancia de IProject
    public IProject createProject(String name) {
        return new Project(name);
    }
}
