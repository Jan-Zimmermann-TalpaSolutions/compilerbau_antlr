import jasmin.ClassFile;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

@Test()
public class CompilerTest {

    private Path tempDir;

    @BeforeMethod
    public void createTempDir() throws IOException {
        tempDir = Files.createTempDirectory("compilerTest");
    }

    @AfterMethod
    public void deleteTempDir() {
        deleteRecursive(tempDir.toFile());
    }

    private void deleteRecursive(File file) {
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                deleteRecursive(child);
            }
        }
        if (!file.delete()) {
            throw new Error("could not delete file <" + file + ">");
        }
    }

    @DataProvider
    public Object[][] provide_code_expectedText() throws Exception {
        return new Object[][]{
                {"plus", "zeichma(1+2);", "3" + System.lineSeparator()},
                {"chained plus", "zeichma(1+2+42);", "45" + System.lineSeparator()},
                {
                        "chained zeichma",
                        "zeichma(1); zeichma(2);",
                        "1" + System.lineSeparator() + "2" + System.lineSeparator()
                },
                {"minus", "zeichma(3-2);", "1" + System.lineSeparator()},
                {"mult", "zeichma(2*3);", "6" + System.lineSeparator()},
                {"div", "zeichma(6/2);", "3" + System.lineSeparator()},
                {"div_rest", "zeichma(7/2);", "3" + System.lineSeparator()},
                {"minus_plus", "zeichma(8-2+5);", "11" + System.lineSeparator()},
                {"mult_div", "zeichma(8/2*4);", "16" + System.lineSeparator()},
                {"plus_mult", "zeichma(2+3*3);", "11" + System.lineSeparator()},
                {"minus_mult", "zeichma(9-2*3);", "3" + System.lineSeparator()},

                {"var", "janzezahl foo; foo = 42; zeichma(foo);", "42" + System.lineSeparator()},
                {"one var parameter plus","janzezahl foo; foo = 42; zeichma(foo+2);", "44" + System.lineSeparator()},
                {"add two vars parameter","janzezahl a; janzezahl b; a=2; b=5; zeichma(a+b);", "7" + System.lineSeparator()},

                {"hauraus only function","janzezahl randomNumber() { hauraus 4;} zeichma(randomNumber());", "4" + System.lineSeparator()},

                example("functions/simple_function", "4" + System.lineSeparator() + "42" + System.lineSeparator()),
                example("functions/scopes", "4" + System.lineSeparator()),
                example("functions/int_parameters", "13" + System.lineSeparator()),
                example("functions/overloading", "0" + System.lineSeparator() + "42" + System.lineSeparator()),
                example("branches/if_int_false", "42" + System.lineSeparator()),


                {"lower than true", "zeichma(1<2);", "1" + System.lineSeparator()},
                {"lower than false", "zeichma(2<2);", "0" + System.lineSeparator()},

                {"lower than or equals true", "zeichma(2<=2);", "1" + System.lineSeparator()},
                {"lower than or equals false", "zeichma(3<=2);", "0" + System.lineSeparator()},

                {"greater than true", "zeichma(3 > 2);", "1" + System.lineSeparator()},
                {"greater than false", "zeichma(2 > 2);", "0" + System.lineSeparator()},

                {"greater than or equals true", "zeichma(2 >= 2);", "1" + System.lineSeparator()},
                {"greater than or equals false", "zeichma(1 >= 2);", "0" + System.lineSeparator()}
        };
    }

    private static String[] example(String name, String expected) throws Exception {
        try (InputStream in = CompilerTest.class.getResourceAsStream("/examples/" + name + ".txt")) {
            if (in == null) {
                throw new IllegalArgumentException("No such example <" + name + ">");
            }
            String code = new Scanner(in, "UTF-8").useDelimiter("\\A").next();
            return new String[]{name, code ,expected};
        }
    }


    @Test(dataProvider = "provide_code_expectedText")
    public void runningCode_outputsExpectedText(String description, String code, String expectedText) throws Exception {
        //execution
        String actualOutput = compileAndRun(code);

        //evaluation
        Assert.assertEquals(actualOutput, expectedText);
    }


    @Test(expectedExceptions = UndeclaredVariableException.class, expectedExceptionsMessageRegExp = "1:8 undeclared variable <x>")
    public void compilingCode_throwsUndeclaredVariableException_ifReadingUndefinedVariable() throws Exception {
        //execution
        compileAndRun("zeichma(x);");

        //evaluation performed by expected exception
    }

    @Test(expectedExceptions = UndeclaredVariableException.class, expectedExceptionsMessageRegExp = "1:0 undeclared variable <x>")
    public void compilingCode_throwsUndeclaredVariableException_ifWrittingUndefinedVariable() throws Exception {
        //execution
        compileAndRun("x = 5;");

        //evaluation performed by expected exception
    }

    @Test(expectedExceptions = VariableAlreadyDefinedException.class, expectedExceptionsMessageRegExp = "2:10 variable already definied: <x>")
    public void compilingCode_throwsVariableAlreadyDefinedException_whenDefiningAlreadyDefinedVariable() throws Exception {
        //execution
        compileAndRun("janzezahl x;" + System.lineSeparator() +
                "janzezahl x;");

        //evaluation performed by expected exception
    }

    @Test(expectedExceptions = UndefinedFunctionException.class, expectedExceptionsMessageRegExp = "1:8 call to undefined function: <someUndefinedFunction>")
    public void compilingCode_throwsUndefinedFunctionException_whenCallingUndefinedFunction() throws Exception {
        //execution
        compileAndRun("zeichma(someUndefinedFunction());");

        //evaluation performed by expected exception
    }

    @Test(expectedExceptions = FunctionAlreadyDefinedException.class, expectedExceptionsMessageRegExp = "2:10 function already defined: <x>")
    public void compilingCode_throwsFunctionAlreadyDefinedException_whenCallingAlreadyDefinedFunction() throws Exception {
        //execution
        compileAndRun("janzezahl x() { hauraus 42;}\n" +
                "janzezahl x() { hauraus 42;}");

        //evaluation performed by expected exception
    }


    private String compileAndRun(String code) throws Exception {
        code = Main.compile(new ANTLRInputStream(code));
        ClassFile classFile = new ClassFile();
        classFile.readJasmin(new StringReader(code), "", false);
        Path outputPath = tempDir.resolve(classFile.getClassName() + ".class");
        try (OutputStream outputStream = Files.newOutputStream(outputPath)) {
            classFile.write(outputStream);
        }
        return runJavaClass(tempDir, classFile.getClassName());
    }

    private String runJavaClass(Path dir, String className) throws Exception {
        Process process = Runtime.getRuntime().exec(new String[]{"java", "-cp", dir.toString(), className});
        try (InputStream in = process.getInputStream()) {
            return new Scanner(in).useDelimiter("\\A").next();
        }
    }
}