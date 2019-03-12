import com.mf3110.Calculator;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

import static org.junit.Assert.*;

public class CalculatorTest {

    //코드 리팩토링(calculator 인스턴스 생성 중복 제거)
    private Calculator cal = new Calculator();

    @Test
    public void add() {
        assertEquals(9,cal.add(6,3));
    }

    @Test
    public void subtract() {
        assertEquals(3,cal.subtract(6,3));
    }

    @Test
    public void multiply() {
        assertEquals(18,cal.multiply(6,3));
    }

    @Test
    public void divide() {
        assertEquals(2,cal.divide(6,3));
    }
}