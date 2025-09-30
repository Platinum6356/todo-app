import org.example.TodoList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodoListTest
{
    @Test
    void addAndList(){
        TodoList t = new TodoList();
        t.add(" task1  ");
        assertEquals(1, t.size());
        assertEquals("task1", t.getAll().getFirst());
    }

    @Test
    void remove(){
        TodoList t = new TodoList();
        t.add("a");
        t.add("b");
        assertTrue(t.remove(0));
        assertEquals(1, t.size());
        assertFalse(t.remove(10));
    }

    @Test
    void addEmptyIgnored(){
        TodoList t = new TodoList();
        t.add("   ");
        assertEquals(0, t.size());
    }

    @Test
    void clearAll(){
        TodoList t = new TodoList();
        t.add("task1");
        t.add("task2");
        t.clearAll();
        assertEquals(0, t.size());
    }

    @Test
    void markDone(){
        TodoList t = new TodoList();
        t.add("task1");
        t.add("task2");
        assertTrue(t.markDone(1));
        assertFalse(t.markDone(10)); // неправильный индекс
        // Предполагаем, что после отметки задачи есть метод isDone, возвращающий true/false
        assertTrue(t.isDone(1));
        assertFalse(t.isDone(0));
    }

    @Test
    void search(){
        TodoList t = new TodoList();
        t.add("fix bug");
        t.add("write tests");
        t.add("deploy app");
        var results = t.search("test");
        assertEquals(1, results.size());
        assertEquals("write tests", results.get(0));
        results = t.search("nope");
        assertTrue(results.isEmpty());
    }


}