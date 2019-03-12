import com.mf3110.Calculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

import static org.junit.Assert.*;

public class CalculatorTest {

    //코드 리팩토링(calculator 인스턴스 생성 중복 제거)
    private Calculator cal;

    //@before 어노테이션 안에 있어야만  @RunWith @Rule 같은 어노테이션을 사용해 기능을 확장할 수 있다.
    @Before
    public void setup(){
        cal= new Calculator();
        System.out.println("before");
    }

    @Test
    public void add() {
        assertEquals(9,cal.add(6,3));
        System.out.println("add");
    }

    @Test
    public void subtract() {
        assertEquals(3,cal.subtract(6,3));
        System.out.println("subtract");
    }

    @Test
    public void multiple() {
        assertEquals(18,cal.multiple(6,3));
        System.out.println("multiple");
    }

    @Test
    public void divide() {
        assertEquals(2,cal.divide(6,3));
        System.out.println("divide");
    }

    @After
    public void teardown(){
        System.out.println("teardown");
    }
}