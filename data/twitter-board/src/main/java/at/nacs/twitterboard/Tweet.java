package at.nacs.twitterboard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder

public class Tweet {

    private String id;
    private String user;
    private String message;
    private int likes;
    private List<String> comments;
    private LocalDateTime timestamp;

}
