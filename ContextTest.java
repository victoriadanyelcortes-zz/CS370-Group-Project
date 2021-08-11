import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ContextTest {

    @Test
    public void test() {

        String testName = "test dummy";

        Context context = new Context(new FreshmanStudent());

        context.executeNameStrategy(testName);

        assertEquals("Student name is: test dummy and there grade level is freshman", context.executeNameStrategy(testName));

    }


}