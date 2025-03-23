package Objects;


import java.time.LocalDateTime;
import java.util.UUID;

public class Task {

    private UUID id;
    private String name;
    private String description;
    private String deadline;

    public Task(String name, String description, String deadline) {
        this.name = name;
        this.id = UUID.randomUUID();
        this.description = description;
        this.deadline = deadline;
    }
}
