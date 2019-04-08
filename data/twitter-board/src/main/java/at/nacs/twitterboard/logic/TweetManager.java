package at.nacs.twitterboard.logic;


import at.nacs.twitterboard.presistence.Tweet;
import at.nacs.twitterboard.presistence.TweetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TweetManager {

    private final TweetRepository repository;


    public List<Tweet> getAllTweets() {
        return repository.findAllByOrderByTimestampDesc();
    }

    public List<Tweet> getUserAllTweets(String user) {
        return repository.findAllByUserOrderByTimestampDesc(user);
    }

    public Tweet post(Tweet tweet) {
        tweet.setTimestamp(LocalDateTime.now());
        return repository.save(tweet);
    }

    public Optional<Tweet> getTweetById(String id) {
        Optional<Tweet> optionalTweet = repository.findById(id);
        if (optionalTweet.isPresent()) {
            return Optional.of(optionalTweet.get());
        }
        return Optional.empty();

    }

    public void addLike(String id) {
        Optional<Tweet> optionalTweet = getTweetById(id);
        Tweet tweet = optionalTweet.get();
        int likes = tweet.getLikes();
        tweet.setLikes(likes + 1);
        repository.save(tweet);
    }

    public void addComment(String id, String comment) {
        Optional<Tweet> optionalTweet = getTweetById(id);
        Tweet tweet = optionalTweet.get();
        List<String> commentList = tweet.getComments();
        commentList.add(comment);
        tweet.setComments(commentList);
        repository.save(tweet);
    }
}
