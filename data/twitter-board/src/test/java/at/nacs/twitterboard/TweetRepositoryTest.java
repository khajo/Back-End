package at.nacs.twitterboard;

import lombok.Setter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
@ConfigurationProperties("dataset")
class TweetRepositoryTest {
    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    TweetManager manager;

    @Setter
    Tweet tweet;

    @BeforeEach
    void before() {
        tweetRepository.save(tweet);
    }

    @AfterEach
    void after() {
        tweetRepository.deleteAll();
    }

    @Test
    void getAll() {
        List<Tweet> tweets = manager.getAllTweets();
        Tweet actualTweet = tweets.get(0);
        Assertions.assertThat(actualTweet).isEqualTo(tweet);
    }

    @Test
    void getTweetById() {
        Tweet actual = manager.getTweetById(tweet.getId()).get();

        Assertions.assertThat(actual).isEqualTo(tweet);
    }
}