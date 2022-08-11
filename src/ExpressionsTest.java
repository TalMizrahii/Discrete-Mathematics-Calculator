import java.util.Map;
import java.util.TreeMap;

/**
 * The run class of the program.
 *
 * @author Tal Mizrahi.
 * @since 19/04/2022
 */
public class ExpressionsTest {
    /**
     * main method.
     *
     * @param args empty.
     * @throws Exception if a problem occurs in the evaluation processes.
     */
    public static void main(String[] args) throws Exception {
        // create new expression.
        Expression e1 = new And(new Or(new Val(false), new Var("Y")),
                new Var("X"));
        System.out.println(e1);
        // create map of variables and values.
        Map<String, Boolean> assignment = new TreeMap<>();
        assignment.put("Y", true);
        assignment.put("X", false);
        // evaluate and print the expression.
        System.out.println(e1.evaluate(assignment));
        // nandify the expression and print it.
        System.out.println(e1.nandify());
        // norify the expression and print it.
        System.out.println(e1.norify());
        // simplify the expression and print it.
        System.out.println(e1.simplify());
    }
}