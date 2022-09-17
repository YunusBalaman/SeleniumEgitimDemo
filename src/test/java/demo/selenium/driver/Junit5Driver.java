package demo.selenium.driver;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class Junit5Driver {

    @BeforeAll
    public static void beforeAll(){

        System.out.println("beforeAll");
    }

    @BeforeEach
    public void beforeEach(){

        System.out.println("beforeEach");
    }

    @AfterEach
    public void afterEach(){

        System.out.println("afterEach");
    }

    @AfterAll
    public static void afterAll(){

        System.out.println("afterAll");
    }
}
