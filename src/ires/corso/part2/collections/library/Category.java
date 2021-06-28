package ires.corso.part2.collections.library;

public class Category
{
    //    - Categoria (titolo, descrizione)

    private String title;
    private String description;

    public Category(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
