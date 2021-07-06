package ires.corso.part2.todo;

import java.io.Serializable;
import java.time.LocalDate;

public class ToDo implements Serializable
{
    public enum Priority {
        ALTA,
        MEDIA,
        BASSA
    }
    public enum State {
        DA_FARE,
        COMPLETATA,
        ANNULLATA,
        IN_ESECUZIONE
    }

    protected Long id;
    private String title;
    private String description;
    protected LocalDate insertionDate;
    private LocalDate deliveryDate;
    private Priority priority;
    private State state;

    public ToDo cloneForUpdate() {
        ToDo newToDo = new ToDo(this.title, this.description, this.insertionDate, this.deliveryDate, this.priority, this.state);
        return newToDo;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public State getState() {
        return state;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getInsertionDate() {
        return insertionDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public ToDo(String title, String description, LocalDate insertionDate, LocalDate deliveryDate, Priority prio) {
        this.title = title;
        this.description = description;
        this.insertionDate = insertionDate;
        this.deliveryDate = deliveryDate;
        this.priority = prio;
        this.state = State.DA_FARE;
    }

    public ToDo(String title, String description, LocalDate insertionDate, LocalDate deliveryDate, Priority prio, State state) {
        this.title = title;
        this.description = description;
        this.insertionDate = insertionDate;
        this.deliveryDate = deliveryDate;
        this.priority = prio;
        this.state = state;
    }

    public ToDo(Long id, String title, String description, LocalDate insertionDate, LocalDate deliveryDate, Priority prio, State state) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.insertionDate = insertionDate;
        this.deliveryDate = deliveryDate;
        this.priority = prio;
        this.state = state;
    }
}
