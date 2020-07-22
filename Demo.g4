grammar Demo;

program: programPart+ ;

programPart: statement #MainStatement
            | functionDefinition #ProgPartFunctionDefnition
            ;

statement: println ';'
           | varDeclaration ';'
           | assignment ';'
           | branch
           ;

branch: 'watwenn' '(' condition=expression ')' onTrue=block 'sonstdat' onFalse=block
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



varDeclaration: 'janzezahl' varName=IDENTIFIER ;

assignment: varName=IDENTIFIER '=' expr=expression;

println: 'zeichma(' argument=expression ')' ;

functionDefinition: 'janzezahl' funcName= IDENTIFIER '(' params=parameterDeclaration')' '{' statements=statementList 'hauraus' returnValue=expression ';' '}';

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