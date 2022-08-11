import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The "Val" class.
 *
 * <p>contains all the method connected to a logical value.
 * implements the "Expression" interface.
 *
 * @author Tal Mizrahi.
 * @since 19/04/2022
 */
public class Val implements Expression {
    private boolean val; // boolean value represented as "T" or "F" in the system.

    /**
     * a constructor for "Val".
     *
     * @param value the value of "val".
     */
    public Val(Boolean value) {
        setVal(value);
    }

    /**
     * a setter for the value.
     *
     * @param b the new value of "val".
     */
    protected void setVal(Boolean b) {
        this.val = b;
    }

    /**
     * a getter for "val".
     *
     * @return the boolean value of "val".
     */
    protected Boolean getVal() {
        return this.val;
    }

    /**
     * evaluates if the expression is true or false.
     *
     * @param assignment the map of values and their boolean value.
     * @return a boolean value of the expression according to the variables values.
     * @throws Exception if the expression can not be evaluated.
     */
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return getVal();
    }

    /**
     * evaluates if the expression is true or false.
     *
     * @return a boolean value of the expression according to the variables values.
     * @throws Exception if the expression can not be evaluated.
     */
    @Override
    public Boolean evaluate() throws Exception {
        return getVal();
    }

    /**
     * returning new list, because no variable is stored in this class the list is empty.
     *
     * @return new empty list.
     */
    @Override
    public List<String> getVariables() {
        return new ArrayList<>();
    }

    /**
     * converts the expression from logical to string.
     *
     * @return the string representation of the expression.
     */
    @Override
    public String toString() {
        if (!getVal()) {
            return "F";
        }
        return "T";
    }

    /**
     * replacing all the appearances of an expression with a new value according to the present value.
     *
     * @param var        the new variable we're assigning.
     * @param expression the expression we replace.
     * @return the new expression.
     */
    @Override
    public Expression assign(String var, Expression expression) {
        return this;
    }

    /**
     * returning the value according to the present value.
     *
     * @return a boolean value.
     */
    @Override
    public Expression nandify() {
        return this;
    }

    /**
     * returning the value according to the present value.
     *
     * @return a boolean value.
     */
    @Override
    public Expression norify() {
        return this;
    }

    /**
     * returning the value according to the present value.
     *
     * @return a boolean value.
     */
    @Override
    public Expression simplify() {
        return this;
    }
}