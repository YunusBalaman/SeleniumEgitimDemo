package demo.selenium.test;

import demo.selenium.driver.Junit5Driver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Junit5Test extends Junit5Driver {

    @Order(1)
    @Test
    public void test1(){

        Assertions.assertEquals("2","2");
        Assertions.assertEquals("1","2","1 esit degil 2");
        Assertions.assertEquals("2","3");
    }

    @Order(3)
    @Test
    public void test2() {

        int x = 5;
        int y = 6;
        Assertions.assertTrue(x>y,"expected: " + x + "  büyük degil actual: " + y);
    }

    @Order(4)
    @Test
    public void test3(){

        String ip = null;//"134.34.43.11:6655";
        String expectedip = "134.34.43.11:";
        Assertions.assertNotNull(ip);
        Assertions.assertTrue(ip.equalsIgnoreCase(expectedip),"");
    }

    @Order(2)
    @Test
    public void test4(){
        String ad = "Ali";
        Assertions.assertEquals("ali", ad.toLowerCase());
    }

    @Order(6)
    @Test
    public void test5AssertAll(){
         Assertions.assertAll("",
                 () -> Assertions.assertEquals("2","2"),
                 () -> Assertions.assertEquals("1","2","1 esit degil 2"),
                 () -> Assertions.assertEquals("2","3")
              );
    }

    @Order(7)
    @Test
    public void test6AssertAll(){
        String ip = null;
        Assertions.assertAll("",
                () -> Assertions.assertEquals("2","2"),
                () -> Assertions.assertEquals("1","2","1 esit degil 2"),
                () -> Assertions.assertEquals("2","3"),
                () -> {
                    Assertions.assertEquals("2","2");
                    Assertions.assertEquals("1","2","1 esit degil 2");
                    Assertions.assertEquals("2","3");
                }
        );
        System.out.println("test bitti");
    }

    @Order(8)
    @ParameterizedTest
    @CsvFileSource(files = "./login.csv", numLinesToSkip = 1, delimiter=',')
    @DisplayName("MyTest")
    @Tag("MyTest")
    public void dataDriven(String username, String password){

        System.out.println(username);
        System.out.println(password);
    }

    @Order(5)
    @ParameterizedTest
    @CsvSource(value = {"2,1","3,1"}, delimiter=',')
    @DisplayName("MyTest")
    @Tag("MyTest")
    public void dataDriven2(String value1, String value2){

        System.out.println(value1);
        System.out.println(value2);
    }
}
