import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ryangross on 2/15/17.
 */
public class UserIOTest {
    UserIO aUI;

    @Before
    public void setUp() {
        aUI = new UserIO();
    }

    @Test
    public void isValidTest() {
        String valid = "0400";
        String invalid = "04:67 a.m";
        Assert.assertTrue(aUI.isValidInput(valid));
        Assert.assertFalse(aUI.isValidInput(invalid));
    }

}
