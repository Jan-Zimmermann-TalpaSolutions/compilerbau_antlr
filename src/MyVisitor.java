import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashMap;
import java.util.Map;

public class MyVisitor extends DemoBaseVisitor<String> {

    private Map<String, Integer> variables = new HashMap<>();
    private final FunctionList definedFunctions;
    private int branchCounter = 0;
    private int compareCount = 0;

    public MyVisitor(FunctionList definedFunctions) {
        super();
        if (definedFunctions == null) {
            throw new NullPointerException("definedFunctions");
        }
        this.definedFunctions = definedFunctions;
    }

    @Override
    public String visitPrintln(DemoParser.PrintlnContext ctx) {
        return "   getstatic java/lang/System/out Ljava/io/PrintStream;\n" +
                visit(ctx.argument) + "\n" +
                "   invokevirtual java/io/PrintStream/println(I)V\n";
    }

    @Override
    public String visitPlus(DemoParser.PlusContext ctx) {
        return visitChildren(ctx) + "\niadd";
    }

    @Override
    public String visitDiv(DemoParser.DivContext ctx) {
        return visitChildren(ctx) + "\nidiv";
    }

    @Override
    public String visitMult(DemoParser.MultContext ctx) {
        return visitChildren(ctx) + "\nimul";
    }

    @Override
    public String visitMinus(DemoParser.MinusContext ctx) {
        return visitChildren(ctx) + "\nisub";
    }

    @Override
    public String visitRelational(DemoParser.RelationalContext ctx) {
        int compareNum = compareCount;
        compareNum++;
        String jumpInstruction;
        switch (ctx.operator.getText()){
            case "<":
                jumpInstruction = "if_icmplt";
                break;
            case "<=":
                jumpInstruction = "if_icmple";
                break;
            case ">":
                jumpInstruction = "if_icmpgt";
                break;
            case ">=":
                jumpInstruction = "if_icmpge";
                break;
            default:
                throw new IllegalArgumentException("Unknown operator: " + ctx.operator.getText());
        }
        return visitChildren(ctx) + "\n" +
                jumpInstruction + " onTrue" + compareNum + "\n" +
                "ldc 0\n" +
                "goto onFalse" + compareNum + "\n" +
                "onTrue" + compareNum + ":\n" +
                "ldc 1\n" +
                "onFalse" + compareNum + ":";
    }

    @Override
    public String visitProgram(DemoParser.ProgramContext ctx) {
        String mainCode = "";
        String functions = "";
        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);
            String instructions = visit(child);
            if (child instanceof DemoParser.MainStatementContext) {
                mainCode += instructions + "\n";
            } else {
                functions += instructions + "\n";
            }
        }
        return functions + "\n" + "" +
                ".method public static main([Ljava/lang/String;)V\n" +
                "   .limit stack 100\n" +
                "   .limit locals 100\n" +
                "\n" +
                mainCode + "\n" +
                "   return\n" +
                "\n" +
                ".end method";
    }

    @Override
    public String visitStatement(DemoParser.StatementContext ctx) {
        return super.visitStatement(ctx);
    }

    @Override
    public String visitVariable(DemoParser.VariableContext ctx) {
        return "iload " + requireVariableIndex(ctx.varName);
    }

    @Override
    public String visitVarDeclaration(DemoParser.VarDeclarationContext ctx) {
        if (variables.containsKey(ctx.varName.getText())) {
            throw new VariableAlreadyDefinedException(ctx.varName);
        }
        variables.put(ctx.varName.getText(), variables.size());
        return "";
    }

    @Override
    public String visitAssignment(DemoParser.AssignmentContext ctx) {
        return visit(ctx.expr) + "\n" +
                "istore " + requireVariableIndex(ctx.varName);
    }

    @Override
    public String visitNumber(DemoParser.NumberContext ctx) {
        return "ldc " + ctx.number.getText();
    }

    @Override
    protected String aggregateResult(String aggregate, String nextResult) {
        if (aggregate == null) {
            return nextResult;
        }
        if (nextResult == null) {
            return aggregate;
        }
        return aggregate + "\n" + nextResult;
    }

    @Override
    public String visitFuncCallExpression(DemoParser.FuncCallExpressionContext ctx) {
        return super.visitFuncCallExpression(ctx);
    }

    @Override
    public String visitFunctionDefinition(DemoParser.FunctionDefinitionContext ctx) {
        Map<String, Integer> oldVariables = variables;
        variables = new HashMap<>();
        visit(ctx.params);
        String statementinstructions = visit(ctx.statements);
        String result = ".method public static " + ctx.funcName.getText() + "(";
        int numberOfParameters = ctx.params.declarations.size();
        result += stringRepeat("I", numberOfParameters);
        result += ")I\n" +
                ".limit locals 100\n" +
                ".limit stack 100\n" +
                (statementinstructions == null ? "" : statementinstructions + "\n") +
                visit(ctx.returnValue) + "\n" +
                "ireturn\n" +
                ".end method";
        variables = oldVariables;
        return result;
    }

    @Override
    public String visitFunctionCall(DemoParser.FunctionCallContext ctx) {
        int numberOfParameters = ctx.arguments.expressions.size();
        if (!definedFunctions.contains(ctx.funcName.getText(), numberOfParameters)) {
            throw new UndefinedFunctionException(ctx.funcName);
        }
        String instructions = "";
        String argumentsInstructions = visit(ctx.arguments);
        if (argumentsInstructions != null) {
            instructions += argumentsInstructions + "\n";
        }
        instructions += "invokestatic HelloWorld/" + ctx.funcName.getText() + "(";
        instructions += stringRepeat("I", numberOfParameters);
        instructions += ")I";
        return instructions;
    }


    @Override
    public String visitMainStatement(DemoParser.MainStatementContext ctx) {
        return super.visitMainStatement(ctx);
    }

    @Override
    public String visitProgPartFunctionDefnition(DemoParser.ProgPartFunctionDefnitionContext ctx) {
        return super.visitProgPartFunctionDefnition(ctx);
    }

    @Override
    public String visitBranch(DemoParser.BranchContext ctx) {
        String conditionInstruction = visit(ctx.condition);
        String onTrueInstructions = visit(ctx.onTrue);
        String onFalseInstructions = visit(ctx.onFalse);
        int branchNum = branchCounter;
        branchCounter++;

        return conditionInstruction + "\n" +
                "ifne ifTrue" + branchNum + "\n" +
                onFalseInstructions + "\n" +
                "goto endIf" + branchNum + "\n" +
                "ifTrue" + branchNum + ":\n" +
                onTrueInstructions + "\n" +
                "endIf" + branchNum + ":\n";
    }

    private int requireVariableIndex(Token varNameToken) {
        Integer varIndex = variables.get(varNameToken.getText());
        if (varIndex == null) {
            throw new UndeclaredVariableException(varNameToken);
        }
        return varIndex;
    }

    private String stringRepeat(String string, int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; ++i) {
            result.append(string);
        }
        return result.toString();
    }
}
