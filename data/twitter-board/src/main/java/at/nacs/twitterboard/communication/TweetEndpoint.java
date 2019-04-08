package at.nacs.twitterboard.communication;

import at.nacs.twitterboard.presistence.Tweet;
import at.nacs.twitterboard.logic.TweetManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweets")
@RequiredArgsConstructor
public class TweetEndpoint {

    private final TweetManager manager;

    @GetMapping
    List<Tweet> getAll() {
        return manager.getAllTweets();
    }


    @GetMapping("/user/{user}")
    List<Tweet> getOne(@PathVariable String user) {
        return manager.getUserAllTweets(user);
    }


    @PostMapping
    Tweet post(@RequestBody Tweet tweet) {
        return manager.post(tweet);
    }

    @PutMapping("/{id}/likes")
    void putLike(@PathVariable String id) {
         manager.addLike(id);
    }

    @PutMapping("/{id}/comments")
    void putComment(@PathVariable String id,@RequestBody String comment) {
         manager.addComment(id,comment);
    }

}
