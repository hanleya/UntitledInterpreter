import AST.*;

import java.util.ArrayList;

public class BuildTree {

    private static ArrayList<String> varIdTable;
    private static ArrayList<String> funcIdTable;


    public static TNode build(ASTStart s) {

        varIdTable = new ArrayList<String>();
        funcIdTable = new ArrayList<String>();

        TNode root = new TNode(NodeOps.ROOT);

        for (int i = 0; i < s.jjtGetNumChildren(); i++) {
            root.addChild(buildFunc((ASTFunction) s.jjtGetChild(i)));
        }

        root.printNode();

        return root;
    }

    private static TNode buildFunc(ASTFunction f) {

        TNode func = new TNode(NodeOps.FUNC);

        func.id = funcId((ASTIdentifier) f.jjtGetChild(0));
        func.addChild(buildFParams((ASTFuncParams) f.jjtGetChild(1)));
        func.type = getType((ASTType) f.jjtGetChild(2));
        func.addChild(buildBlock((ASTBlock) f.jjtGetChild(3)));

        return func;
    }

    private static TNode buildFParams(ASTFuncParams p) {

        TNode pars = new TNode(NodeOps.PARAMS);
        TNode var;

        ASTIdentifier id;
        ASTType type;

        for (int i = 0; i < p.jjtGetNumChildren(); i++) {
            var = new TNode(NodeOps.VAR);

            var.id = varId((ASTIdentifier) p.jjtGetChild(i).jjtGetChild(0));
            var.type = getType((ASTType) p.jjtGetChild(i).jjtGetChild(1));

            pars.addChild(var);
        }

        return pars;
    }


    private static TNode buildBlock(ASTBlock b) {
        return new TNode(NodeOps.BLOCK);
    }


    private static Types getType(ASTType t) {
        return Types.values()[t.type];
    }

    private static int varId(ASTIdentifier id) {
        String s = id.image;
        int i = varIdTable.indexOf(s);

        if (i == -1) {
            varIdTable.add(s);
            i = varIdTable.size() - 1;
        }

        return i;
    }

    private static int funcId(ASTIdentifier id) {
        String s = id.image;
        int i = funcIdTable.indexOf(s);

        if (i == -1) {
            funcIdTable.add(s);
            i = funcIdTable.size() - 1;
        }

        return i;
    }
}
