import AST.*;

import java.util.ArrayList;
import java.util.HashMap;

public class BuildTree {

    private static ArrayList<String> varIdTable;
    private static ArrayList<String> funcIdTable;


    public static TNode build(ASTStart s) {

        varIdTable = new ArrayList<String>();
        funcIdTable = new ArrayList<String>();

        TNode root = new TNode(NodeOps.ROOT);

        Execute e = (n) -> buildFunc((ASTFunction) n);
        iterAST(root, s, e);

        try {
            evalTypes(root);
        } catch (TypeMismatchError err) {
            System.out.println(err.msg);
        }

        return root;
    }

    private static TNode buildFunc(ASTFunction f) {

        TNode func = new TNode(NodeOps.FUNC);

        func.id = funcId((ASTIdentifier) f.jjtGetChild(0));
        func.addChild(buildFParams((ASTFuncParams) f.jjtGetChild(1)));

        Node n = f.jjtGetChild(2);
        if (n instanceof ASTType) {
            func.type = getType((ASTType) n);
            func.addChild(buildBlock((ASTBlock) f.jjtGetChild(3)));
        } else {
            func.addChild(buildBlock((ASTBlock) f.jjtGetChild(2)));
        }

        return func;
    }

    private static TNode buildFParams(ASTFuncParams p) {

        TNode pars = new TNode(NodeOps.PARAMS);

        Execute e = (n) -> buildVar((ASTIdentifier) n.jjtGetChild(0), (ASTType) n.jjtGetChild(1));
        iterAST(pars, p, e);

        return pars;
    }


    private static TNode buildBlock(ASTBlock b) {

        TNode block = new TNode(NodeOps.BLOCK);

        Execute e = (n) -> {
            if (n instanceof ASTVarDecl) {
                return buildDecl((ASTVarDecl) n);
            } else if (n instanceof ASTReturnStmt) {
                return buildReturn((ASTReturnStmt) n);
            } else if (n instanceof ASTIfStmt) {
                return buildIf((ASTIfStmt) n);
            } else if (n instanceof ASTWhileStmt) {
                return buildWhile((ASTWhileStmt) n);
            } else {
                return buildExpr(n);
            }
        };
        iterAST(block, b, e);

        return block;
    }

    private static TNode buildDecl(ASTVarDecl v) {
        TNode node = new TNode(NodeOps.DECL);

        node.id = varId((ASTIdentifier) v.jjtGetChild(0));
        node.type = getType((ASTType) v.jjtGetChild(1));

        node.addChild(buildExpr(v.jjtGetChild(2)));

        return node;
    }

    private static TNode buildReturn(ASTReturnStmt r) {
        TNode node = new TNode(NodeOps.RETURN);

        node.addChild(buildExpr(r.jjtGetChild(0)));

        return node;
    }

    private static TNode buildIf(ASTIfStmt i) {
        TNode node = new TNode(NodeOps.IF);

        node.addChild(buildExpr(i.jjtGetChild(0).jjtGetChild(0)));
        node.addChild(buildBlock((ASTBlock) i.jjtGetChild(1)));

        return node;
    }

    private static TNode buildWhile(ASTWhileStmt w) {
        TNode node = new TNode(NodeOps.WHILE);

        node.addChild(buildExpr(w.jjtGetChild(0).jjtGetChild(0)));
        node.addChild(buildBlock((ASTBlock) w.jjtGetChild(1)));

        return node;
    }



    private static TNode buildExpr(Node n) {
        TNode node = null;

        if (n instanceof ASTAssignmentExp) {
            node = buildAssign((ASTAssignmentExp) n);
        } else if (n instanceof ASTOrExp) {
            node = buildOr((ASTOrExp) n);
        } else if (n instanceof ASTAndExp) {
            node = buildAnd((ASTAndExp) n);
        } else if (n instanceof ASTBoolExp) {
            node = buildBool((ASTBoolExp) n);
        } else if (n instanceof ASTAddExp) {
            node = buildAdd((ASTAddExp) n);
        } else if (n instanceof ASTMulExp) {
            node = buildMul((ASTMulExp) n);
        } else if (n instanceof ASTExpoExp) {
            node = buildExpo((ASTExpoExp) n);
        } else if (n instanceof ASTPrefixExp) {
            node = buildPrefix((ASTPrefixExp) n);
        } else if (n instanceof ASTSuffixExp) {
            node = buildSuffix((ASTSuffixExp) n);
        } else if (n instanceof ASTSubscript) {
            node = buildSubscript((ASTSubscript) n);
        } else if (n instanceof ASTFunctionCall) {
            node = buildCall((ASTFunctionCall) n);
        } else if (n instanceof ASTIdentifier) {
            node = buildVar((ASTIdentifier) n);
        } else if (n instanceof ASTIntLiteral) {
            node = buildIntLit((ASTIntLiteral) n);
        } else if (n instanceof ASTRealLiteral) {
            node = buildRealLit((ASTRealLiteral) n);
        }

        return node;
    }

    private static TNode buildAssign(ASTAssignmentExp e) {

        TNode n = new TNode(switch (e.type) {
            case ASSIGN -> NodeOps.ASSIGNX;
            case APLUS -> NodeOps.ASSIGNPLUSX;
            case AMINUS -> NodeOps.ASSIGNMINUSX;
            case AMUL -> NodeOps.ASSIGNTIMESX;
            case ADIV -> NodeOps.ASSIGNDIVX;
            case AMOD -> NodeOps.ASSIGNMODX;
        });

        n.id = varId((ASTIdentifier) e.jjtGetChild(0));
        n.addChild(buildExpr(e.jjtGetChild(1)));

        return n;
    }

    private static TNode buildOr(ASTOrExp e) {

        TNode n = new TNode(NodeOps.ORX);

        Execute ex = BuildTree::buildExpr;
        iterAST(n, e, ex);

        return n;
    }

    private static TNode buildAnd(ASTAndExp e) {

        TNode n = new TNode(NodeOps.ANDX);

        Execute ex = BuildTree::buildExpr;
        iterAST(n, e, ex);

        return n;
    }

    private static TNode buildBool(ASTBoolExp e) {

        TNode n = new TNode(switch (e.type) {
            case EQ -> NodeOps.EQX;
            case NEQ -> NodeOps.NEQX;
            case LT -> NodeOps.LTX;
            case LEQ -> NodeOps.LEQX;
            case GT -> NodeOps.GTX;
            case GEQ -> NodeOps.GEQX;
        });

        Execute ex = BuildTree::buildExpr;
        iterAST(n, e, ex);

        return n;
    }

    private static TNode buildAdd(ASTAddExp e) {

        TNode n = new TNode(switch (e.op.get(0)) {
            case PLUS -> NodeOps.ADDX;
            case MINUS -> NodeOps.SUBX;
        });
        n.addChild(buildExpr(e.jjtGetChild(0)));

        TNode curr = n;
        int i;
        for (i = 1; i < e.op.size(); i++) {
            TNode n2 = new TNode(switch (e.op.get(i)) {
                case PLUS -> NodeOps.ADDX;
                case MINUS -> NodeOps.SUBX;
            });
            n2.addChild(buildExpr(e.jjtGetChild(i)));

            curr.addChild(n2);
            curr = n2;
        }

        curr.addChild(buildExpr(e.jjtGetChild(i)));

        return n;
    }

    private static TNode buildMul(ASTMulExp e) {

        TNode n = new TNode(switch (e.op.get(0)) {
            case MUL -> NodeOps.MULX;
            case DIV -> NodeOps.DIVX;
            case MOD -> NodeOps.MODX;
        });
        n.addChild(buildExpr(e.jjtGetChild(0)));

        TNode curr = n;
        int i;
        for (i = 1; i < e.op.size(); i++) {
            TNode n2 = new TNode(switch (e.op.get(i)) {
                case MUL -> NodeOps.MULX;
                case DIV -> NodeOps.DIVX;
                case MOD -> NodeOps.MODX;
            });
            n2.addChild(buildExpr(e.jjtGetChild(i)));

            curr.addChild(n2);
            curr = n2;
        }

        curr.addChild(buildExpr(e.jjtGetChild(i)));

        return n;
    }

    private static TNode buildExpo(ASTExpoExp e) {
        TNode n = new TNode(NodeOps.EXPOX);

        n.addChild(buildExpr(e.jjtGetChild(0)));
        n.addChild(buildExpr(e.jjtGetChild(1)));

        return n;
    }

    private static TNode buildPrefix(ASTPrefixExp e) {

        TNode n = new TNode(switch (e.op) {
            case INC -> NodeOps.PREINC;
            case DEC -> NodeOps.PREDEC;
            case NOT -> NodeOps.NOT;
        });

        n.addChild(buildExpr(e.jjtGetChild(0)));

        return n;
    }

    private static TNode buildSuffix(ASTSuffixExp e) {

        TNode n = new TNode(switch (e.op) {
            case INC -> NodeOps.POSTINC;
            case DEC -> NodeOps.POSTDEC;
        });

        n.addChild(buildExpr(e.jjtGetChild(0)));

        return n;
    }

    private static TNode buildSubscript(ASTSubscript e) {
        TNode n = new TNode(NodeOps.SUBSCRIPT);

        n.addChild(buildExpr(e.jjtGetChild(0)));
        n.addChild(buildExpr(e.jjtGetChild(1)));

        return n;
    }

    private static TNode buildCall(ASTFunctionCall e) {
        TNode n = new TNode(NodeOps.CALL);
        n.id = funcId((ASTIdentifier) e.jjtGetChild(0));

        Execute ex = BuildTree::buildExpr;
        iterAST(n, e.jjtGetChild(1), ex);

        return n;
    }

    private static TNode buildIntLit(ASTIntLiteral e) {
        TNodeLiteral n = new TNodeLiteral(TNodeLiteral.LitType.Int);
        n.type = DataType.Int;
        n.iLit = e.val;
        return n;
    }

    private static TNode buildRealLit(ASTRealLiteral e) {
        TNodeLiteral n = new TNodeLiteral(TNodeLiteral.LitType.Real);
        n.type = DataType.Real;
        n.rLit = e.val;
        return n;
    }



    private static TNode buildVar(ASTIdentifier id, ASTType t) {
        TNode var = new TNode(NodeOps.VAR);

        var.id = varId(id);
        var.type = getType(t);

        return var;
    }
    private static TNode buildVar(ASTIdentifier id) {
        TNode var = new TNode(NodeOps.VAR);

        var.id = varId(id);

        return var;
    }



    private static void evalTypes(TNode node) throws TypeMismatchError {

        FuncParamTypes f = new FuncParamTypes();

        for (TNode n : node.children) {
            f.addFunc(n.id, n.type, n.getChild(0));
        }

        for (TNode n : node.children) {
            VarScope v = new VarScope(null);

            for (TNode p : n.getChild(0).children) {
                v.varTypes.put(p.id, p.type);
            }

            evalTypesBlock(n.getChild(1), n.type, v, f);
        }

    }

    private static void evalTypesBlock(TNode node, DataType expectedType, VarScope vTypes, FuncParamTypes fTypes) throws TypeMismatchError {
        for (TNode n : node.children) {
            switch (n.getOp()) {
                case DECL:
                    evalTypesExpr(n.getChild(0), vTypes, fTypes);
                    vTypes.varTypes.put(n.id, n.type);
                    checkTypes(n.type, n.getChild(0));
                    break;
                case RETURN:
                    n.type = expectedType;
                    evalTypesExpr(n.getChild(0), vTypes, fTypes);
                    checkTypes(expectedType, n.getChild(0));
                    break;
                case IF, WHILE:
                    n.getChild(0).type = DataType.Int;
                    evalTypesExpr(n.getChild(0), vTypes, fTypes);
                    checkTypes(DataType.Int, n.getChild(0));

                    evalTypesBlock(n.getChild(1), DataType.None, new VarScope(vTypes), fTypes);
                    break;
                default:
                    evalTypesExpr(n, vTypes, fTypes);
            }
        }
    }

    private static void evalTypesExpr(TNode node, VarScope vTypes, FuncParamTypes fTypes) throws TypeMismatchError {
        switch (node.getOp()) {
            case ASSIGNX, ASSIGNPLUSX, ASSIGNMINUSX, ASSIGNTIMESX, ASSIGNDIVX, ASSIGNMODX:
                node.type = vTypes.getVarType(node.id);
                evalTypesExpr(node.getChild(0), vTypes, fTypes);
                checkTypes(node.type, node.getChild(0));
                break;
            case ORX, ANDX, MODX, PREINC, PREDEC, POSTINC, POSTDEC, NOT:
                node.type = DataType.Int;
                for (TNode n : node.children) {
                    evalTypesExpr(n, vTypes, fTypes);
                    checkTypes(DataType.Int, n);
                }
                break;
            case EQX, NEQX, LTX, LEQX, GTX, GEQX:
                node.type = DataType.Int;
                for (TNode n : node.children) {
                    evalTypesExpr(n, vTypes, fTypes);
                    if (n.type != DataType.Int && n.type != DataType.Real) {
                        throw new TypeMismatchError(DataType.Int, node.type);
                    }
                }
                break;
            case ADDX, SUBX, MULX, DIVX, EXPOX:
                evalTypesArith(node, vTypes, fTypes);
                break;
            case CALL:
                evalTypesCall(node, vTypes, fTypes);
                break;
            case VAR:
                node.type = vTypes.getVarType(node.id);
                if (node.type == null) {
                    throw new TypeMismatchError("Error: variable used before being defined");
                }
                break;
        }
    }

    private static void evalTypesArith(TNode node, VarScope vTypes, FuncParamTypes fTypes) throws TypeMismatchError {
        evalTypesExpr(node.getChild(0), vTypes, fTypes);
        evalTypesExpr(node.getChild(1), vTypes, fTypes);
        DataType t1 = node.getChild(0).type;
        DataType t2 = node.getChild(1).type;

        if (t1 == DataType.Int) {
            if (t2 == DataType.Int) {
                node.type = DataType.Int;
            } else if (t2 == DataType.Real) {
                node.type = DataType.Real;
            } else {
                throw new TypeMismatchError(node.getOp().toString() + " only accepts int or real arguments");
            }
        } else if (t1 == DataType.Real) {
            if (t2 == DataType.Int || t2 == DataType.Real) {
                node.type = DataType.Real;
            } else {
                throw new TypeMismatchError(node.getOp().toString() + " only accepts int or real arguments");
            }
        } else {
            throw new TypeMismatchError(node.getOp().toString() + " only accepts int or real arguments");
        }
    }

    private static void evalTypesCall(TNode node, VarScope vTypes, FuncParamTypes fTypes) throws TypeMismatchError {

        node.type = fTypes.getReturnType(node.id);
        ArrayList<DataType> p = fTypes.getParamTypes(node.id);

        if (node.children.size() != p.size()) {
            throw new TypeMismatchError("function call has wrong number of arguments");
        }

        for (int i = 0; i < node.children.size(); i++) {
            evalTypesExpr(node.getChild(i), vTypes, fTypes);
            checkTypes(p.get(i), node.getChild(i));
        }

    }



    private static void checkTypes(DataType expected, TNode node) throws TypeMismatchError {
        if (expected != node.type) {
            throw new TypeMismatchError(expected, node.type);
        }
    }




    private static DataType getType(ASTType t) {
        return DataType.values()[t.type];
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


    public static class TypeMismatchError extends Error {
        String msg;

        public TypeMismatchError(DataType expected, DataType found) {
            msg = "Type error, expected " + expected + " found " + found;
        }

        public TypeMismatchError(String msg) {
            this.msg = msg;
        }

    }



    private static class VarScope {

        VarScope parent;
        HashMap<Integer, DataType> varTypes;

        public VarScope(VarScope p) {
            parent = p;
            varTypes = new HashMap<>();
        }

        public DataType getVarType(int id) {
            DataType t = varTypes.get(id);
            if (t != null) {
                return t;
            } else if (parent != null) {
                return parent.getVarType(id);
            } else {
                System.out.println("ERROR: " + id + " not declared yet");
                return null;
            }
        }

    }

    private static class FuncParamTypes {

        private static class FTypes {

            DataType ret;
            ArrayList<DataType> params;

            public FTypes(DataType ret, ArrayList<DataType> params) {
                this.ret = ret;
                this.params = params;
            }

        }

        HashMap<Integer, FTypes> funcList;

        public FuncParamTypes() {
            funcList = new HashMap<>();
        }

        public void addFunc(int id, DataType ret, TNode params) {
            ArrayList<DataType> types = new ArrayList<>();

            for (TNode p : params.children) {
                types.add(p.type);
            }

            funcList.put(id, new FTypes(ret, types));
        }

        public DataType getReturnType(int id) {
            return funcList.get(id).ret;
        }

        public ArrayList<DataType> getParamTypes(int id) {
            return funcList.get(id).params;
        }

    }


    private interface Execute {
        public TNode exec(Node n);
    }
    private static void iterAST(TNode n, Node ASTn, Execute e) {
        for (int i = 0; i < ASTn.jjtGetNumChildren(); i++) {
            n.addChild(e.exec(ASTn.jjtGetChild(i)));
        }
    }


}
