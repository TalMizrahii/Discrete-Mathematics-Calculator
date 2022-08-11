import java.util.List;
import java.util.Map;

/**
 * The "Expression" interface.
 *
 * <p>contains all the method signatures connected to a logical expression.
 *
 * @author Tal Mizrahi.
 * @since 19/04/2022
 */

public interface Expression {

    /**
     * Evaluate the expression using the variable values provide in the assignment, and return the result.
     *
     * @param assignment the map of values and their boolean value.
     * @return a boolean value of the expression according to the variables values.
     * @throws Exception If the expression contains a variable which is not in the assignment, an exception, is thrown.
     */
    Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

    /**
     * A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     *
     * @return a boolean value of the expression according to the variables values.
     * @throws Exception If the expression contains a variable which is not in the assignment, an exception, is thrown.
     */
    Boolean evaluate() throws Exception;

    /**
     * Returns a list of the variables in the expression.
     *
     * @return a list with all variables.
     */
    List<String> getVariables();


    /**
     * Returns a nice string representation of the expression.
     *
     * @return a string.
     */
    String toString();

    /**
     * replacing all the appearances of an expression with a new var.
     *
     * @param var        the new variable we're assigning.
     * @param expression the expression we replace.
     * @return the new expression.
     */
    Expression assign(String var, Expression expression);


    /**
     * Returns the expression tree resulting from converting all the operations to the logical Nand operation.
     *
     * @return the equivalent "Nand" representation.
     */
    Expression nandify();

    /**
     * Returns the expression tree resulting from converting all the operations to the logical Nor operation.
     *
     * @return the equivalent "Nor" representation.
     */
    Expression norify();

    /**
     * simplifying the expression using the current class's logic.
     *
     * @return the simplified expression.
     */
    Expression simplify();
}