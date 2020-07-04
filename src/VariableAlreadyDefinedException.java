import org.antlr.v4.runtime.Token;

public class VariableAlreadyDefinedException extends CompileException{

    private String varName;

    public VariableAlreadyDefinedException(Token token) {
        super(token);
        varName = token.getText();
    }

    @Override
    public String getMessage() {
        return line + ":" + column + " variable already definied: <" + varName + ">";
    }
}
