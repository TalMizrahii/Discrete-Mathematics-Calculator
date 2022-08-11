import java.util.Map;

/**
 * The "Not" class.
 *
 * <p>contains all the method connected to a logical 'Not'.
 * implements the "Expression" interface, extends the "BinaryExpression" class.
 *
 * @author Tal Mizrahi.
 * @since 19/04/2022
 */
public class Not extends UnaryExpression implements Expression {

    /**
     * the constructor of "not", using the constructor of the unaryExpression.
     *
     * @param expression the expression we negate.
     */
    public Not(Expression expression) {
        super(expression);
    }

    /**
     * evaluating the expression by negating it.
     *
     * @param assignment the map of values and their boolean value.
     * @return a boolean value of the expression according to the variables values.
     * @throws Exception if the expression can not be evaluated.
     */
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        try {
            return !getExpression().evaluate(assignment);
        } catch (Exception exception) {
            System.out.println("Wrong!");
            return null;
        }
    }

    /**
     * evaluates if the expression is true or false.
     *
     * @return a boolean value of the expression according to the variables values.
     * @throws Exception if the expression can not be evaluated.
     */
    @Override
    public Boolean evaluate() throws Exception {
        try {
            return !(this.getExpression().evaluate());
        } catch (Exception exception) {
            System.out.println("Wrong!");
            return null;
        }
    }

    /**
     * converts the expression from logical to string.
     *
     * @return the string representation of the expression.
     */
    @Override
    public String toString() {
        String str = getExpression().toString();
        return "~" + "(" + str + ")";
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
        return new Not(getExpression().assign(var, expression));
    }

    /**
     * converting the expression from "Not" expression to a "Nand" expression.
     *
     * @return the equivalent "Nand" representation.
     */
    @Override
    public Expression nandify() {
        return new Nand(getExpression().nandify(), getExpression().nandify());
    }

    /**
     * converting the expression from "Not" expression to a "Nor" expression.
     *
     * @return the equivalent "Nor" representation.
     */
    @Override
    public Expression norify() {
        return new Nor(getExpression().norify(), getExpression().norify());
    }

    /**
     * simplifying the expression using the "And" logic.
     *
     * @return the simplified expression.
     */
    @Override
    public Expression simplify() {
        if (getExpression().simplify().toString().equals("F")) {
            return new Val(true);
        }
        if (getExpression().simplify().toString().equals("T")) {
            return new Val(false);
        }
        return new Not(getExpression().simplify());
    }
}
