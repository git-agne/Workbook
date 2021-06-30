package ires.corso.part2.todo;

import java.io.Serializable;
import java.time.LocalDate;

public class ToDo implements Serializable, Comparable<ToDo>
{
    // id, titolo, descrizione, data di inserimento, data di consegna, priorità, stato

    private enum priority {
        ALTA,
        MEDIA,
        BASSA
    }
    private enum state {
        DA_FARE,
        COMPLETATA,
        ANNULLATA,
        IN_ESECUZIONE
    }

    private static Long idIncr = 0l;

    protected final Long id;
    private String title;
    private String description;
    protected LocalDate insertionDate;
    private LocalDate deliveryDate;

    public ToDo cloneForUpdate() {
        // Fabbrica una copia esatta del TO-DO

        ToDo newToDo = new ToDo(this.id, this.title, this.description, this.insertionDate, this.deliveryDate);
        return newToDo;
    }

    protected long getNewId() {
        idIncr = ++idIncr;
        return ++idIncr;
    }

    @Override
    public int compareTo(ToDo o) {
        if(this.getDeliveryDate().toString() == o.getDeliveryDate().toString()) {
            return 0;
        }
        else {
            return -1;
        }
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

    public ToDo(String title, String description, LocalDate insertionDate, LocalDate deliveryDate) {
        this.id = getNewId();
        this.title = title;
        this.description = description;
        this.insertionDate = insertionDate;
        this.deliveryDate = deliveryDate;
    }

    public ToDo(Long id, String title, String description, LocalDate insertionDate, LocalDate deliveryDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.insertionDate = insertionDate;
        this.deliveryDate = deliveryDate;
    }


}
