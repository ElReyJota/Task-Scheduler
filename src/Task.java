import java.util.Date;

public class Task {
    /*
    * An instance of a task, used for tracking events, things to do or reminders.
    *
    * The responsibility of a task is to track its contents.
    *
    * Attributes:
    *   title (String): The name of the task, this helps to easily differentiate multiple tasks.
    *   dueDate (Date): The date for which the task has to be completed by.
    *   description (String): A short description of what the task entails.
    *   importance (int): How important the task is and how it should be prioritized.
    */
    private String title;
    private Date dueDate;
    private String description;
    private int importance;

    public Task(String ntitle, Date ndueDate, String ndescription, int nimportance){
        /*
        * Creates a basic instance of Task with its title and dueDate.
        *
        * Arguments:
        *   ntitle (String): The name of the task.
        *   ndueDate (String): When the task needs to be completed by.
        *   ndescription (String): What the task entails.
        *   nimportance (int): How important the task is.
        * Returns: Nothing
        */
        this.title = ntitle;
        this.dueDate = ndueDate;
        this.description = ndescription;
        this.importance = nimportance;
    }

    public String getTitle(){
        /*
        * Returns the title of the task.
        * Arguments: None.
        * Returns: title (String).
        * */
        return title;
    }

    public void setTitle(String ntitle){
        /*
        * Changes the title of the task.
        *
        * Arguments:
        *   ntitle (String): The name of the task.
        * Returns: Nothing
        */
        this.title = ntitle;
    }

    public Date getDueDate(){
         /*
         * Returns the dueDate of the task.
         * Arguments: None.
         * Returns: dueDate (Date).
         */
        return dueDate;
    }

    public void setDueDate(Date ndueDate){
         /*
         * Changes the due date of the task.
         *
         * Arguments:
         *   ndueDate (Date): The due date of the task.
         * Returns: Nothing
         */
        this.dueDate = ndueDate;
    }

    public String getDescription(){
         /*
         * Returns the description of the task.
         * Arguments: None.
         * Returns: description (String).
         */
        return description;
    }

    public void setDescription(String ndescription){
        /*
         * Changes the description of the task.
         *
         * Arguments:
         *   ndescription (String): The description of the task.
         * Returns: Nothing
         */
        this.description = ndescription;
    }

    public int getImportance(){
        /*
         * Returns the importance of the task.
         * Arguments: None.
         * Returns: importance (int).
         */
        return importance;
    }

    public void setImportance(int nimportance){
         /*
         * Changes the importance of the task.
         *
         * Arguments:
         *   nimportance (int): The importance of the task.
         * Returns: Nothing
         */
        this.importance = nimportance;
    }
}
