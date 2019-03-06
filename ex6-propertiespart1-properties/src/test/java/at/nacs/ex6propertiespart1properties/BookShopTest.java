package at.nacs.ex6propertiespart1properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookShopTest {


    @Autowired
    BookShop bookShop;


    @ParameterizedTest
    @CsvSource({
            "HarryPotter,3",
            "TheFoundation,2",
            "TheLordOfTheRings,4",
    })
    void getBooks(String expectesKey,Integer expectedValue) {
        Map<String, Integer> books = bookShop.getBooks();
        System.out.println(books.keySet());
        System.out.println(books.values());
        Assertions.assertEquals(expectedValue,books.get(expectesKey));

//    System.out.println(books.values());
//    System.out.println(books.size());
  //  System.out.println(books.values().contains(copy));
  //  System.out.println(books.keySet().contains(bookName));

    }
}