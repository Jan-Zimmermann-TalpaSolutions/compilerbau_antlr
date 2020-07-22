// Generated from C:/Users/jan/IdeaProjects/init\Demo.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DemoParser}.
 */
public interface DemoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DemoParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(DemoParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link DemoParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(DemoParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MainStatement}
	 * labeled alternative in {@link DemoParser#programPart}.
	 * @param ctx the parse tree
	 */
	void enterMainStatement(DemoParser.MainStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MainStatement}
	 * labeled alternative in {@link DemoParser#programPart}.
	 * @param ctx the parse tree
	 */
	void exitMainStatement(DemoParser.MainStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ProgPartFunctionDefnition}
	 * labeled alternative in {@link DemoParser#programPart}.
	 * @param ctx the parse tree
	 */
	void enterProgPartFunctionDefnition(DemoParser.ProgPartFunctionDefnitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ProgPartFunctionDefnition}
	 * labeled alternative in {@link DemoParser#programPart}.
	 * @param ctx the parse tree
	 */
	void exitProgPartFunctionDefnition(DemoParser.ProgPartFunctionDefnitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DemoParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(DemoParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DemoParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(DemoParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link DemoParser#branch}.
	 * @param ctx the parse tree
	 */
	void enterBranch(DemoParser.BranchContext ctx);
	/**
	 * Exit a parse tree produced by {@link DemoParser#branch}.
	 * @param ctx the parse tree
	 */
	void exitBranch(DemoParser.BranchContext ctx);
	/**
	 * Enter a parse tree produced by {@link DemoParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(DemoParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link DemoParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(DemoParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Div}
	 * labeled alternative in {@link DemoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDiv(DemoParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link DemoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDiv(DemoParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link DemoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariable(DemoParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link DemoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariable(DemoParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link DemoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumber(DemoParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link DemoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumber(DemoParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link DemoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMult(DemoParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link DemoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMult(DemoParser.MultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Relational}
	 * labeled alternative in {@link DemoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRelational(DemoParser.RelationalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Relational}
	 * labeled alternative in {@link DemoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRelational(DemoParser.RelationalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link DemoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPlus(DemoParser.PlusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link DemoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPlus(DemoParser.PlusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link DemoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMinus(DemoParser.MinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link DemoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMinus(DemoParser.MinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcCallExpression}
	 * labeled alternative in {@link DemoParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallExpression(DemoParser.FuncCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcCallExpression}
	 * labeled alternative in {@link DemoParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallExpression(DemoParser.FuncCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DemoParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(DemoParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DemoParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(DemoParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DemoParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(DemoParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link DemoParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(DemoParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link DemoParser#println}.
	 * @param ctx the parse tree
	 */
	void enterPrintln(DemoParser.PrintlnContext ctx);
	/**
	 * Exit a parse tree produced by {@link DemoParser#println}.
	 * @param ctx the parse tree
	 */
	void exitPrintln(DemoParser.PrintlnContext ctx);
	/**
	 * Enter a parse tree produced by {@link DemoParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(DemoParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DemoParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(DemoParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DemoParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(DemoParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link DemoParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(DemoParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link DemoParser#statementList}.
	 * @param ctx the parse tree
	 */
	void enterStatementList(DemoParser.StatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DemoParser#statementList}.
	 * @param ctx the parse tree
	 */
	void exitStatementList(DemoParser.StatementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link DemoParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterParameterDeclaration(DemoParser.ParameterDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link DemoParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitParameterDeclaration(DemoParser.ParameterDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link DemoParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(DemoParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DemoParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(DemoParser.ExpressionListContext ctx);
}