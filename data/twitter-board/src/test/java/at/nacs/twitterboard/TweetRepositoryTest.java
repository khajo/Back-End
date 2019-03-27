package at.nacs.twitterboard;/*
package at.nacs.twitterboard;


import lombok.Setter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
@ConfigurationProperties("dataset")
class TweetRepositoryTest {
//
//        @Test
//        void getAllOrderdByTimestamp() {
//            List<Tweet> tweets = manager.getAllOrderdByTimestamp();
//            Tweet actualTweet = tweets.get(0);
//            Assertions.assertThat(actualTweet).isEqualTo(tweet);
//        }


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
    void saveTweet() {
        repository.save(tweet);
        Tweet actual = manager.post(tweet);
        System.out.println(actual.getUser());
        // Assertions.assertThat(actual).isEqualTo(tweet);


    }


}*/
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
    void getTweetById () {
        Tweet actual = manager.getTweetById(tweet.getId()).get();

        Assertions.assertThat(actual).isEqualTo(tweet);
    }
}