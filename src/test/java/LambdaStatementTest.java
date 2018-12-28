import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;

/**
 * Created by mtumilowicz on 2018-12-28.
 */
public class LambdaStatementTest {

    private int x = 5;

    @Test
    public void increment() {
        Consumer<String> increment = s -> x++;

        increment.accept("a");
        increment.accept("a");
        increment.accept("a");
        increment.accept("a");

        assertThat(x, is(9));
    }

    @Test
    public void add_to_list() {
        var list = new LinkedList<String>();
        Consumer<String> add = list::add;

        add.accept("a");

        assertThat(list, hasSize(1));
    }

    @Test
    public void add_in_foreach() {
        var source = List.of(1, 2, 3);
        var target = new LinkedList<Integer>();

        source.forEach(target::add);

        assertThat(target, is(source));
    }

    @Test
    public void class_creation() {
        Consumer<Integer> create = X::new;

        create.accept(1);
        create.accept(1);
        
        assertThat(X.counter, is(2));
    }
}

class X {
    static int counter;

    X(int i) {
        counter++;
    }
}