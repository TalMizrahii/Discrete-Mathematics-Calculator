import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The "Var" class.
 *
 * <p>contains all the method connected to a logical variable expression.
 * implements the "Expression" interface.
 *
 * @author Tal Mizrahi.
 * @since 19/04/2022
 */
public class Var implements Expression {
    private String variable; // The logical variable.

    /**
     * a constructor for the variable.
     *
     * @param variable the variable we use.
     */
    public Var(String variable) {
        setVariable(variable);
    }

    /**
     * A setter for the variable.
     *
     * @param variable1 The new variable value.
     */
    protected void setVariable(String variable1) {
        this.variable = variable1;
    }

    /**
     * A getter for the variable.
     *
     * @return the variable as a string.
     */
    protected String getVariable() {
        return this.variable;
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
        if (assignment.get(getVariable()) != null) {
            return assignment.get(getVariable());
        } else {
            throw new Exception("No variable!");
        }
    }

    /**
     * the method cannot resolve the expression without a map, therefor returning null.
     *
     * @return null.
     * @throws Exception if the expression can not be evaluated.
     */
    @Override
    public Boolean evaluate() throws Exception {
        return null;
    }

    /**
     * creating a new list of all variables.
     *
     * @return the list with all variables.
     */
    @Override
    public List<String> getVariables() {
        List<String> var = new ArrayList<>();
        var.add(getVariable());
        return var;
    }

    /**
     * the variables are strings, so returning their value.
     *
     * @return the string representation of the variable.
     */
    @Override
    public String toString() {
        return getVariable();
    }

    /**
     * replacing all the appearances of an expression with a new var.
     *
     * @param var        the new variable we're assigning.
     * @param expression the expression we replace.
     * @return the new expression.
     */
    @Override
    public Expression assign(String var, Expression expression) {
        if (var.equals(getVariable())) {
            return expression;
        }
        return this;
    }

    /**
     * the base of the expression, so returning this.
     *
     * @return the current variable.
     */
    @Override
    public Expression nandify() {
        return this;
    }

    /**
     * the base of the expression, so returning this.
     *
     * @return the current variable.
     */
    @Override
    public Expression norify() {
        return this;
    }

    /**
     * cannot simplify an atomic expression, so returning this.
     *
     * @return the current variable.
     */
    @Override
    public Expression simplify() {
        return this;
    }
}
