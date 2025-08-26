package Dog;

import static org.junit.Assert.*;
import org.junit.Test;

// 在测试中，需要有三部分：测试用例、调用方法、断言
// 其中，断言是用于检查条件是否为真的语句
public class DogTest {    
    @Test
    public void testSmall() {
        Dog d = new Dog(3);
        assertEquals("yip", d.noise());
    }

    @Test
    public void testLarge() {
        Dog d = new Dog(20);
        assertEquals("bark", d.noise());
    }
}
