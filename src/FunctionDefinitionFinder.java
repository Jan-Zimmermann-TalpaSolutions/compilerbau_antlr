import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashSet;
import java.util.Set;

public class FunctionDefinitionFinder {

    public static FunctionList findFunction(ParseTree tree){
        final FunctionList definedFunctions = new FunctionList();
        new DemoBaseVisitor<Void>() {
            @Override
            public Void visitFunctionDefinition(DemoParser.FunctionDefinitionContext ctx) {
                String functionName = ctx.funcName.getText();
                int parameterCount = ctx.params.declarations.size();
                if(definedFunctions.contains(functionName, parameterCount)){
                    throw new FunctionAlreadyDefinedException(ctx.funcName);
                }
                definedFunctions.add(functionName, parameterCount);
                return null;
            }
        }.visit(tree);
        return definedFunctions;
    }

}
