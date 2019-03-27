package at.nacs.twitterboard;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TweetManager {

    private final TweetRepository repository;


    List<Tweet> getAllTweets() {
        return repository.findAllByOrderByTimestampDesc();
    }

    List<Tweet> getUserAllTweets(String user) {
        return repository.findAllByUserOrderByTimestampDesc(user);
    }

    Tweet post(Tweet tweet) {
        tweet.setTimestamp(LocalDateTime.now());
        return repository.save(tweet);
    }

    Optional<Tweet> getTweetById(String id) {
        Optional<Tweet> optionalTweet = repository.findById(id);
        if (optionalTweet.isPresent()) {

            return Optional.of(optionalTweet.get());
        }
        return Optional.empty();

    }

    Optional<Tweet> addLike(String id) {
        Optional<Tweet> tweet = getTweetById(id);
        int likes = tweet.get().getLikes();
        tweet.get().setLikes(likes+1);
        repository.save(tweet.get());
        return tweet;
    }

    Optional<Tweet> addComment(String id, String comment) {
        Optional<Tweet> tweet = getTweetById(id);
        List<String> commentList = tweet.get().getComments();
        commentList.add(comment);
        tweet.get().setComments(commentList);
        repository.save(tweet.get());
        return tweet;
    }
}
