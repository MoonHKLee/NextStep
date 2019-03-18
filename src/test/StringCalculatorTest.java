import com.mf3110.StringCalculator;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;


public class StringCalculatorTest {

    public StringCalculator cal;

    @Before
    public void setup(){
        cal = new StringCalculator();
    }

    @Test //문자열이 비어있으면?
    public void add_null() throws Exception{
        assertEquals(0,cal.add(""));
    }

    @Test //문자열에 한개의 값을 넣으면?
    public void add_one() throws Exception{
        assertEquals(1,cal.add("1"));
        assertEquals(19992,cal.add("19992"));
        assertEquals(135,cal.add("135"));
        assertEquals(15,cal.add("15"));
    }

    @Test //문자열을 (:또는,)로 스플릿하면?
    public void add_split_nonCustomDelimeter() throws Exception{
        assertEquals(21,cal.add("1:2:3,4,5:6"));
        assertEquals(55,cal.add("1,2,3,4:5:6:7,8,9:10"));
    }

    @Test //문자열을 (커스텀구분자)로 스플릿하면?
    public void add_split_customDelimeter() throws Exception{
        assertEquals(15,cal.add("//;\n1;2;3;4;5"));
        assertEquals(15,cal.add("//:\n1:2:3:4:5"));
        assertEquals(15,cal.add("//k\n1k2k3k4k5"));
        assertEquals(21,cal.add("//o\n1o2o3o4o5o6"));
    }

    @Test (expected = RuntimeException.class) //문자열에 (음수)가 포함되면?
    public void add_split_negative() throws Exception{
        cal.add("-1,2,3");
    }
}