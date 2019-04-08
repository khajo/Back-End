package at.nacs.twitterboard.presistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data


public class Tweet {

    private String id;
    private String user;
    private String message;
    private int likes;
    private List<String> comments;
    private LocalDateTime timestamp;

}
