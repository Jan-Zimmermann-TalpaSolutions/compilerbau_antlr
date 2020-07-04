grammar Demo;

program: programPart+ ;

programPart: statement #MainStatement
            | functionDefinition #ProgPartFunctionDefnition
            ;

statement: println ';'
           | varDeclaration ';'
           | assignment ';'
           | branch
           | loop
           ;

branch: 'if' '(' condition=expression ')' onTrue=block 'else' onFalse=block
        ;

loop:   'while' '(' condition=expression ')'  onTrue=block #While
    ;

block: '{' statement* '}' ;

expression: left=expression '/' right=expression #Div
        | left=expression '*' right=expression #Mult
        | left=expression '-' right=expression #Minus
        | left=expression '+' right=expression #Plus
        | left=expression operator=('<' | '<=' | '>' | '>=') right=expression #Relational
        | number=NUMBER #Number
        | varName=IDENTIFIER #Variable
        | functionCall #funcCallExpression
        ;



varDeclaration: 'int' varName=IDENTIFIER ;

assignment: varName=IDENTIFIER '=' expr=expression;

println: 'println(' argument=expression ')' ;

functionDefinition: 'int' funcName= IDENTIFIER '(' params=parameterDeclaration')' '{' statements=statementList 'return' returnValue=expression ';' '}';

functionCall: funcName= IDENTIFIER '(' arguments=expressionList ')' ;

statementList: statement*;

parameterDeclaration: declarations+=varDeclaration (',' declarations+=varDeclaration)*
                    |
                    ;

expressionList: expressions+=expression(',' expressions+=expression)*
                |
                ;

NUMBER: [0-9]+;
WHITESPACE: [ \t\n\r]+ -> skip;
IDENTIFIER: [a-zA-Z][a-zA-Z]*;