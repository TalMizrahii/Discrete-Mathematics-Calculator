import java.util.ArrayList;
import java.util.List;

/**
 * The "UnaryExpression" class.
 *
 * <p>contains all the method connected unary expressions.
 * implements the "Expression" interface, extends the "BinaryExpression" class.
 *
 * @author Tal Mizrahi.
 * @since 19/04/2022
 */
public abstract class UnaryExpression extends BaseExpression implements Expression {
    private Expression expression; //the expression we use.

    /**
     * a constructor for the expression.
     *
     * @param expression the new expression we assign.
     */
    public UnaryExpression(Expression expression) {
        setExpression(expression);
    }

    @Override
    public List<String> getVariables() {
        List<String> list = new ArrayList<>();
        if (getExpression() != null) {
            list.addAll(getExpression().getVariables());
        }
        return list;
    }

    /**
     * a getter for the expression.
     *
     * @return the expression.
     */
    protected Expression getExpression() {
        return this.expression;
    }

    /**
     * a setter for the expression.
     *
     * @param expression the new expression's value.
     */
    protected void setExpression(Expression expression) {
        this.expression = expression;
    }
}
