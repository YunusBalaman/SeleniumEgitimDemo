package demo.selenium.test;

import demo.selenium.driver.Junit4Driver;
import org.junit.Assert;
import org.junit.Test;

public class Junit4Test extends Junit4Driver {


    @Test
    public void validLogin(){

        System.out.println("validLogin");
        Assert.assertEquals("validLogin hata","1","2");
    }

    @Test
    public void invalidLogin(){

        int x = 1;
        int y = 2;
        System.out.println("invalidLogin");
        Assert.assertTrue("expected: " + x + "  büyük degil actual: " + y,x>y);
    }

    @Test
    public void denemeToplama(){

        System.out.println(toplama(4,5));
        System.out.println(toplama(4,5,3,2));
    }

    public Integer toplama(Integer x, Integer y, Integer... z){

        int toplam = x + y;
        for (int i = 0; i < z.length; i++){
            toplam = toplam + z[i];
        }
        return toplam;
    }
}
