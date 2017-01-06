import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by vector on 16/12/9.
 */
public class data {
    @Test
    public void testDate()
    {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        System.out.println(format.format(date));
    }
}
