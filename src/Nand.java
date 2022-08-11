import java.util.Map;

/**
 * The "Nand" class.
 *
 * <p>contains all the method connected to a logical 'Nand'.
 * implements the "Expression" interface, extends the "BinaryExpression" class.
 *
 * @author Tal Mizrahi.
 * @since 19/04/2022
 */
public class Nand extends BinaryExpression implements Expression {

    /**
     * a constructor for "Nand", using the binaryExpression constructor.
     *
     * @param expression1 the left expression.
     * @param expression2 the right expression.
     */
    public Nand(Expression expression1, Expression expression2) {
        super(expression1, expression2);
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
        try {
            return !(getExpression1().evaluate(assignment) && getExpression2().evaluate(assignment));
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
            return !(this.getExpression1().evaluate() && this.getExpression2().evaluate());
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
        String str1 = getExpression1().toString();
        String str2 = getExpression2().toString();

        return "(" + str1 + " A " + str2 + ")";
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
        return new Nand(getExpression1().assign(var, expression), getExpression2().assign(var, expression));
    }

    /**
     * recusivley keeping to nandify the expressions.
     *
     * @return the equivalent "Nand" representation.
     */
    @Override
    public Expression nandify() {
        return new Nand(getExpression1().nandify(), getExpression2().nandify());
    }

    @Override
    public Expression norify() {
        return new Nor(new Nor(new Nor(getExpression1().norify(), getExpression1().norify()),
                new Nor(getExpression2().norify(), getExpression2().norify())),
                new Nor(new Nor(getExpression1().norify(), getExpression1().norify()),
                        new Nor(getExpression2().norify(), getExpression2().norify())));
    }

    /**
     * simplifying the expression using the "And" logic.
     *
     * @return the simplified expression.
     */
    @Override
    public Expression simplify() {

        if (getExpression1().simplify().toString().equals("F") || getExpression2().simplify().toString().equals("F")) {
            return new Val(true);
        }
        if (getExpression1().simplify().toString().equals("T") && getExpression2().simplify().toString().equals("T")) {
            return new Val(false);
        }
        if (getExpression2().simplify().toString().equals("T")) {
            return new Not(getExpression1().simplify());
        }
        if (getExpression1().simplify().toString().equals("T")) {
            return new Not(getExpression2().simplify());
        }
        if (getExpression1().simplify().toString().equals(getExpression2().simplify().toString())) {
            return new Not(getExpression1().simplify());
        }
        if (getExpression2().simplify().toString().equals(getExpression1().simplify().toString())) {
            return new Not(getExpression2().simplify());
        }

        return new Nand(getExpression1().simplify(), getExpression2().simplify());
    }
}
