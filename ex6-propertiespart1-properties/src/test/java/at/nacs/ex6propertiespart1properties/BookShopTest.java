package at.nacs.ex6propertiespart1properties;

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

//
//    @ParameterizedTest
//    @CsvSource({
//            "Harry Potter,3",
//            "The Foundation,2",
//            "The Lord of the Rings,4",
//    })
@Test
    void getBooks(String BookName,Integer copy) {
        Map<String, Integer> books = bookShop.getBooks();
    System.out.println(books);

    }
}