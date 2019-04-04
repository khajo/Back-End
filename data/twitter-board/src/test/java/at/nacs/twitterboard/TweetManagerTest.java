package at.nacs.twitterboard;

import lombok.Setter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ConfigurationProperties("dataset")
class TweetManagerTest {

    @Autowired
    TweetManager manager;

    @Autowired
    TweetRepository repository;

    @Setter
    Tweet tweet;

    @BeforeEach
    void before() {
        repository.save(tweet);
    }

    @AfterEach
    void after() {
        repository.deleteAll();
    }

    @Test
    void getAllTweets() {
        List<Tweet> allTweets = manager.getAllTweets();
      Assertions.assertThat(allTweets.size()).isEqualTo(1);
    }

    @Test
    void getUserAllTweets() {
        List<Tweet> mustafa = manager.getUserAllTweets("mustafa");
        Assertions.assertThat(mustafa.size()).isEqualTo(1);

    }

    @Test
    void post() {
        manager.post(tweet);
        Assertions.assertThat(tweet.getId()).isNotNull();
    }

    @Test
    void getTweetById() {
        Optional<Tweet> tweetById = manager.getTweetById(Mockito.anyString());
        Assertions.assertThat(tweetById.get()).isNotNull();
    }

    @Test
    void addLike() {
    }

    @Test
    void addComment() {
    }
}