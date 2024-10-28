import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Clase principal que proporciona una interfaz de usuario en consola.
 * Permite gestionar tareas, usuarios y proyectos.
 * Implementa el principio de Responsabilidad Única (SRP), ya que solo maneja
 * la interacción del usuario con el sistema, mientras que la lógica de negocio
 * reside en otras clases.
 */
public class Main {
    public static void main(String[] args) {
        ITaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Task Management System ===");
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
                case "1": addTask(taskManager, scanner); break;
                case "2": addProject(taskManager, scanner); break;
                case "3": addUser(taskManager, scanner); break;
                case "4": assignTaskToUser(taskManager, scanner); break;
                case "5": assignTaskToProject(taskManager, scanner); break;
                case "6": viewProjectTasks(taskManager, scanner); break;
                case "7": viewUserTasks(taskManager, scanner); break;
                case "8": System.out.println("Saliendo..."); scanner.close(); return;
                default: System.out.println("Opción no válida. Inténtelo de nuevo."); break;
            }
        }
    }

    static void addTask(ITaskManager taskManager, Scanner scanner) {
        System.out.print("Título de la tarea: ");
        String title = scanner.nextLine();
        System.out.print("Descripción: ");
        String description = scanner.nextLine();
        System.out.print("Fecha de vencimiento (yyyy-MM-dd): ");
        String dueDateInput = scanner.nextLine();

        Date dueDate = parseDate(dueDateInput);
        ITask task = new Task(title, description, dueDate);
        ((TaskManager) taskManager).addTask(task);
        System.out.println("Tarea agregada.");
    }

    static void addProject(ITaskManager taskManager, Scanner scanner) {
        System.out.print("Nombre del proyecto: ");
        String name = scanner.nextLine();
        IProject project = new Project(name);
        taskManager.addProject(project);
        System.out.println("Proyecto agregado.");
    }

    static void addUser(ITaskManager taskManager, Scanner scanner) {
        System.out.print("Nombre del usuario: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        IUser user = new User(name, email);
        taskManager.addUser(user);
        System.out.println("Usuario agregado.");
    }

    static void assignTaskToUser(ITaskManager taskManager, Scanner scanner) {
        ITask task = selectTask(taskManager, scanner);
        IUser user = selectUser(taskManager, scanner);
        if (task != null && user != null) {
            taskManager.assignTaskToUser(task, user);
            System.out.println("Tarea asignada a usuario.");
        } else {
            System.out.println("No se pudo asignar.");
        }
    }

    static void assignTaskToProject(ITaskManager taskManager, Scanner scanner) {
        ITask task = selectTask(taskManager, scanner);
        IProject project = selectProject(taskManager, scanner);
        if (task != null && project != null) {
            taskManager.addTaskToProject(task, project);
            System.out.println("Tarea asignada a proyecto.");
        } else {
            System.out.println("No se pudo asignar.");
        }
    }

    static void viewProjectTasks(ITaskManager taskManager, Scanner scanner) {
        IProject project = selectProject(taskManager, scanner);
        if (project != null) {
            for (ITask task : project.getTasks()) {
                System.out.println("- " + task.getTitle() + " (Vencimiento: " + task.getDueDate() + ")");
            }
        } else {
            System.out.println("Proyecto no encontrado.");
        }
    }

    static void viewUserTasks(ITaskManager taskManager, Scanner scanner) {
        IUser user = selectUser(taskManager, scanner);
        if (user != null) {
            for (ITask task : user.getTasks()) {
                System.out.println("- " + task.getTitle() + ": " + task.getDescription());
            }
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    static ITask selectTask(ITaskManager taskManager, Scanner scanner) {
        System.out.print("Título de la tarea: ");
        return ((TaskManager) taskManager).findTaskByTitle(scanner.nextLine());
    }

    static IUser selectUser(ITaskManager taskManager, Scanner scanner) {
        System.out.print("Nombre del usuario: ");
        return ((TaskManager) taskManager).findUserByName(scanner.nextLine());
    }

    static IProject selectProject(ITaskManager taskManager, Scanner scanner) {
        System.out.print("Nombre del proyecto: ");
        return ((TaskManager) taskManager).findProjectByName(scanner.nextLine());
    }

    static Date parseDate(String dateInput) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateInput);
        } catch (ParseException e) {
            System.out.println("Fecha no válida. Usando fecha actual.");
            return new Date();
        }
    }
}
