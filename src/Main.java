import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public void saveFile(ArrayList<Task> data){
        /*
        * Creates a save file and writes over it.
        * Arguments:
        *   data (ArrayList<Task>): The data to be saved in the json file.
        * Returns: Nothing
        */
        // Creates a json object
    }

    public static void main(String[] args) {
        System.out.println("================================= Task Scheduler ================================= ");
        // Initializing variables
        boolean finish = false;
        boolean menu = true;
        boolean taskMenu = false;
        boolean lookMenu = false;
        int input;
        Calendar2 calendar = new Calendar2();
        Scanner user = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<Task>();
        // Core menus loops
        while (!finish){
            // Main menu
            if (menu){
                System.out.println("=== Menu ===");
                System.out.println("1. Schedule Task / Event");
                System.out.println("2. Look at all Tasks / Events");
                System.out.println("3. Load file");
                System.out.println("4. Save file");
                System.out.println("5. Quit");
                input = calendar.getInt("Your response (1-4): ");

                switch(input){
                    case 1:
                        menu = false;
                        taskMenu = true;
                        break;
                    case 2:
                        menu = false;
                        lookMenu = true;
                        break;
                    case(3):
                    case(4):
                    case(5):
                        finish = true;
                }
            }
            // Create task
            else if(taskMenu){
                System.out.println("First choose the date: ");
                calendar.changeDate();
                System.out.print("Please input the title: ");
                String title = user.nextLine();
                System.out.print("Please input the description: ");
                String description = user.nextLine();
                int importance = calendar.getInt("Input the importance (Any Whole Number): ");
                tasks.add(new Task(title, calendar.getDate(), description, importance));
                System.out.println("Task created succesfully!");
                System.out.println();
                taskMenu = false;
                menu = true;
            }
            // See all tasks
            else if(lookMenu){
                int i = -1;
                for (Task task1: tasks){
                    i++;
                    System.out.println("=== Tasks ===");
                    System.out.println(i +". "+ task1.getTitle() + " " + task1.getDueDate());
                }
                System.out.println("-1. Menu");
                int choice = calendar.getInt("Your choice: ");
                if (choice == -1){
                    menu = true;
                    lookMenu = false;
                }
                else if(choice > -1 & choice < tasks.size()){
                    boolean taskViewer = true;
                    while (taskViewer) {
                        System.out.println("Event / Task: " + tasks.get(choice).getTitle());
                        System.out.println("Due date: " + tasks.get(choice).getDueDate());
                        System.out.println("Description" + tasks.get(choice).getDueDate());
                        System.out.println("Importance" + tasks.get(choice).getImportance());
                        System.out.println("");
                        System.out.println("1. Remove task / event");
                        System.out.println("2. Edit title");
                        System.out.println("3. Edit due date");
                        System.out.println("4. Edit description");
                        System.out.println("5. Edit title");
                        System.out.println("6. Choose another");
                        int taskEdit = calendar.getInt("Your choice: ");
                        switch (taskEdit) {
                            case (1):
                                tasks.remove(choice);
                                System.out.println("Event / Task removed successfully!");
                                break;
                            case (2):
                                System.out.print("Please input the new title: ");
                                String title = user.nextLine();
                                tasks.get(choice).setTitle(title);
                                break;
                            case (3):
                                calendar.changeDate();
                                tasks.get(choice).setDueDate(calendar.getDate());
                                break;
                            case (4):
                                System.out.print("Please input the new description: ");
                                String description = user.nextLine();
                                tasks.get(choice).setDescription(description);
                                break;
                            case (5):
                                int importance = calendar.getInt("Please input the new importance");
                                tasks.get(choice).setImportance(importance);
                                break;
                            case(6):
                                taskViewer = false;
                        }
                    }
                }
            }
        }
    }
}