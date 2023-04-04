import AST.*;
import org.jetbrains.annotations.Nullable;

import java.io.*;

public class InterpreterMain {

    public static void main(String[] args) {
        TNode root = getRoot();
        root.printNode();

        InterpreterExecutor exec = new InterpreterExecutor(root);
        exec.execute();
    }

    @Nullable
    public static TNode getRoot() {
        File input = new File("src/main/resources/test.txt");
        ASTStart root;

        try {
            root = Parser.parse(new FileInputStream(input));
        } catch (FileNotFoundException e) {
            System.out.println("No input file found.");
            return null;
        }

        //root.dump(" ");

        return BuildTree.build(root);
    }





}
