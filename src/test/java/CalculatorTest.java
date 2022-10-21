import org.example.Calculator;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
    @Test
    public void TestAdd(){
        var calculator = new Calculator();
        Assert.assertEquals(2+2, calculator.Add(2,2));
    }
}
