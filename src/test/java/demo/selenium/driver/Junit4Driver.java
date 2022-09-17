package demo.selenium.driver;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class Junit4Driver {

    @BeforeClass
    public static void beforeClass(){

        System.out.println("beforeClass");
    }

    @Before
    public void before(){

        System.out.println("before");
    }

    @After
    public void after(){

        System.out.println("after");
    }

    @AfterClass
    public static void afterClass(){

        System.out.println("afterClass");
    }

}
