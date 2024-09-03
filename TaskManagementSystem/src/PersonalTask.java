public class PersonalTask extends Task {
    private String relatedPerson;

    public PersonalTask(String taskName, int priority, String dueDate, String relatedPerson) {
        super(taskName, priority, dueDate);
        this.relatedPerson = relatedPerson;
    }

    public String getRelatedPerson() {
        return relatedPerson;
    }
}
