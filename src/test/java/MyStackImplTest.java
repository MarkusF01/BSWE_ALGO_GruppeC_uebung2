import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lecture.MyStack;
import org.lecture.MyStackImpl;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackImplTest {

    private MyStack stack;

    @BeforeEach
    public void setUp() {
        stack = new MyStackImpl();
        stack.init();
    }

    @Test
    public void testPushAndPop() {
        stack.push(42);
        assertEquals(42, stack.pop());
        assertTrue(stack.empty());
    }

    @Test
    public void testTop() {
        stack.push(42);
        assertEquals(42, stack.top());
        assertFalse(stack.empty());
    }

    @Test
    public void testEmpty() {
        assertTrue(stack.empty());
        stack.push(42);
        assertFalse(stack.empty());
        stack.pop();
        assertTrue(stack.empty());
    }

    @Test
    public void testInit() {
        stack.push(42);
        assertFalse(stack.empty());
        stack.init();
        assertTrue(stack.empty());
    }

    @Test
    public void testPopOnEmptyStack() {
        assertThrows(IllegalStateException.class, () -> stack.pop());
    }

    @Test
    public void testTopOnEmptyStack() {
        assertThrows(IllegalStateException.class, () -> stack.top());
    }
}
