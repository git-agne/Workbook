package ires.corso.part2.collections.school;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Assignment
{
    //    - Assignment (titolo, descrizione [compiti])

    private final String title;
    private final String description;

    public Map<String, Integer> studentVotes = new HashMap<>();

    public void doAssignment(String studId) {
        Integer vote = ThreadLocalRandom.current().nextInt(1,11);
        studentVotes.put(studId, vote);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Assignment(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
