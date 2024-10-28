import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Consola {
    public static void main(String[] args) {
        ITaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Task Management System ===");
            System.out.println("1. Agregar nueva tarea");
            System.out.println("2. Agregar nuevo proyecto");
            System.out.println("3. Agregar nuevo usuario");
            System.out.println("4. Asignar tarea a usuario");
            System.out.println("5. Asignar tarea a proyecto");
            System.out.println("6. Ver todas las tareas de un proyecto");
            System.out.println("7. Ver todas las tareas de un usuario");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            String option = scanner.nextLine();
            System.out.println();

            switch (option) {
                case "1":
                    AddTask(taskManager, scanner);
                    break;
                case "2":
                    AddProject(taskManager, scanner);
                    break;
                case "3":
                    AddUser(taskManager, scanner);
                    break;
                case "4":
                    AssignTaskToUser(taskManager, scanner);
                    break;
                case "5":
                    AssignTaskToProject(taskManager, scanner);
                    break;
                case "6":
                    ViewProjectTasks(taskManager, scanner);
                    break;
                case "7":
                    ViewUserTasks(taskManager, scanner);
                    break;
                case "8":
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        }
    }

    static void AddTask(ITaskManager taskManager, Scanner scanner) {
        System.out.print("Ingrese el título de la tarea: ");
        String title = scanner.nextLine();
        System.out.print("Ingrese la descripción de la tarea: ");
        String description = scanner.nextLine();
        System.out.print("Ingrese la fecha de vencimiento (yyyy-mm-dd): ");
        String dueDateInput = scanner.nextLine();
        Date dueDate = new Date();  // Conversión de fecha simplificada, ajustar según el formato deseado.

        ITask task = new Task(title, description, dueDate);
        System.out.println("Tarea agregada exitosamente.");
    }

    static void AddProject(ITaskManager taskManager, Scanner scanner) {
        System.out.print("Ingrese el nombre del proyecto: ");
        String name = scanner.nextLine();

        IProject project = new Project(name);
        taskManager.addProject(project);
        System.out.println("Proyecto agregado exitosamente.");
    }

    static void AddUser(ITaskManager taskManager, Scanner scanner) {
        System.out.print("Ingrese el nombre del usuario: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese el email del usuario: ");
        String email = scanner.nextLine();

        IUser user = new User(name, email);
        taskManager.addUser(user);
        System.out.println("Usuario agregado exitosamente.");
    }

    static void AssignTaskToUser(ITaskManager taskManager, Scanner scanner) {
        ITask task = SelectTask(taskManager, scanner);
        IUser user = SelectUser(taskManager, scanner);

        if (task != null && user != null) {
            taskManager.assignTaskToUser(task, user);
            System.out.println("Tarea asignada al usuario exitosamente.");
        } else {
            System.out.println("No se pudo asignar la tarea. Verifique los datos.");
        }
    }

    static void AssignTaskToProject(ITaskManager taskManager, Scanner scanner) {
        ITask task = SelectTask(taskManager, scanner);
        IProject project = SelectProject(taskManager, scanner);

        if (task != null && project != null) {
            taskManager.addTaskToProject(task, project);
            System.out.println("Tarea asignada al proyecto exitosamente.");
        } else {
            System.out.println("No se pudo asignar la tarea. Verifique los datos.");
        }
    }

    static void ViewProjectTasks(ITaskManager taskManager, Scanner scanner) {
        IProject project = SelectProject(taskManager, scanner);

        if (project != null) {
            System.out.println("Tareas en el proyecto " + project.getName() + ":");
            for (ITask task : project.getTasks()) {
                System.out.println("- " + task.getTitle() + " (Vencimiento: " + task.getDueDate() + ", Completada: " + task.isCompleted() + ")");
            }
        } else {
            System.out.println("Proyecto no encontrado.");
        }
    }

    static void ViewUserTasks(ITaskManager taskManager, Scanner scanner) {
        IUser user = SelectUser(taskManager, scanner);

        if (user != null) {
            System.out.println("Tareas asignadas a " + user.getName() + ":");
            for (ITask task : user.getTasks()) {
                System.out.println("- " + task.getTitle() + ": " + task.getDescription());
            }
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    static ITask SelectTask(ITaskManager taskManager, Scanner scanner) {
        System.out.print("Ingrese el título de la tarea: ");
        String title = scanner.nextLine();
        // Implementar lógica para seleccionar y devolver la tarea buscada por título.
        return null; // Placeholder
    }

    static IUser SelectUser(ITaskManager taskManager, Scanner scanner) {
        System.out.print("Ingrese el nombre del usuario: ");
        String name = scanner.nextLine();
        // Implementar lógica para seleccionar y devolver el usuario buscado por nombre.
        return null; // Placeholder
    }

    static IProject SelectProject(ITaskManager taskManager, Scanner scanner) {
        System.out.print("Ingrese el nombre del proyecto: ");
        String name = scanner.nextLine();
        // Implementar lógica para seleccionar y devolver el proyecto buscado por nombre.
        return null; // Placeholder
    }
}
