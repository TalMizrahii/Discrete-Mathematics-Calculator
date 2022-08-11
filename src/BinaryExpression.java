import java.util.ArrayList;
import java.util.List;

/**
 * The "And" class.
 *
 * <p>contains all the method connected to a logical 'and'.
 * implements the "Expression" interface, extends the "BinaryExpression" class.
 *
 * @author Tal Mizrahi.
 * @since 19/04/2022
 */
public abstract class BinaryExpression extends BaseExpression implements Expression {
    private Expression expression1;
    private Expression expression2;

    /**
     * a constructor for a binary expression.
     *
     * @param expression1 the left expression.
     * @param expression2 the right expression.
     */
    public BinaryExpression(Expression expression1, Expression expression2) {
        setExpression1(expression1);
        setExpression2(expression2);
    }

    /**
     * creating a new list of all variables, discarding duplications.
     *
     * @return the list with all variables.
     */
    @Override
    public List<String> getVariables() {
        //create two lists.
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        //check if the expressions are null.
        if (getExpression1() != null) {
            list.addAll(getExpression1().getVariables());
        }
        if (getExpression2() != null) {
            list.addAll(getExpression2().getVariables());
        }
        //remove duplications.
        for (String k : list) {
            if (!list2.contains(k)) {
                list2.add(k);
            }
        }
        return list2;
    }

    /**
     * a getter for expression1.
     *
     * @return expression1.
     */
    protected Expression getExpression1() {
        return this.expression1;
    }

    /**
     * a setter for expression1.
     *
     * @param expression1 the new value of expression1.
     */
    protected void setExpression1(Expression expression1) {
        this.expression1 = expression1;
    }

    /**
     * a getter for expression1.
     *
     * @return expression1.
     */
    protected Expression getExpression2() {
        return this.expression2;
    }

    /**
     * a setter for expression2.
     *
     * @param expression2 the new value of expression2.
     */
    protected void setExpression2(Expression expression2) {
        this.expression2 = expression2;
    }
}
