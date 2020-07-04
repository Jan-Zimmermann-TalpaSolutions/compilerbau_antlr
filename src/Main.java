import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception{
        ANTLRInputStream inputStream = new ANTLRFileStream("code.demo");
        System.out.println(compile(inputStream));

    }

    public static String compile(ANTLRInputStream input) {
        DemoLexer lexer = new DemoLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DemoParser parser = new DemoParser(tokens);

        ParseTree tree = parser.program();
        FunctionList definedFunctions = FunctionDefinitionFinder.findFunction(tree);
        return createJasminFile(new MyVisitor(definedFunctions).visit(tree));
    }

    private static String createJasminFile(String instructions){
        return  ".class public HelloWorld\n" +
                ".super java/lang/Object\n" +
                "\n"+
                instructions;
    }
}
