package at.nacs.twitterboard;

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
    Tweet putLike(@PathVariable String id) {
        return manager.addLike(id).get();
    }

    @PutMapping("/{id}/comments")
    Tweet putComment(@PathVariable String id,@RequestBody String comment) {
        return manager.addComment(id,comment).get();
    }

}
