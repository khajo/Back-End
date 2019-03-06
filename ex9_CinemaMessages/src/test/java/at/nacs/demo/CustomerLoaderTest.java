package at.nacs.demo;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerLoaderTest {

    @Autowired
    CustomerLoader customerLoader;

   @Test
    void getCustomers() {
       System.out.println(customerLoader.getCustomers());
    }
}