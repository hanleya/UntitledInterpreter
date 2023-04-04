import java.util.ArrayList;

public class InterpreterExecutor {

    TNode root;
    VarStack variables;

    public InterpreterExecutor(TNode root) {
        this.root = root;
        variables = new VarStack();
    }

    public void execute() {
        execFunc(root.getChild(0), new ArrayList<>());
    }

    private Variable execFunc(TNode node, ArrayList<Variable> params) {
        variables.pushFrame();
        variables.pushScope();

        for (int i = 0; i < params.size(); i++) {
            variables.addVar(node.getChild(0).getChild(i).id, params.get(i));
        }

        Variable ret = execBlock(node.getChild(1));

        variables.popFrame();
        return ret;
    }

    private Variable execBlock(TNode node) {
        for (TNode n : node.children) {
            switch (n.getOp()) {
                case DECL:
                    variables.addVar(n.id, execExpression(n.getChild(0)));
                    break;
                case RETURN:
                    return execExpression(n.getChild(0));
                case IF:
                    if ((int)execExpression(n.getChild(0)).value != 0) {
                        execExpression(n.getChild(1));
                    }
                    break;
                case WHILE:
                    while ((int)execExpression(n.getChild(0)).value != 0) {
                        execExpression(n.getChild(1));
                    }
                    break;
                default:
                    execExpression(n).printVar();
            }
        }
        return new Variable(DataType.None, null);
    }

    private Variable execExpression(TNode node) {
        switch (node.getOp()) {
            case ASSIGNX, ASSIGNPLUSX, ASSIGNMINUSX, ASSIGNTIMESX, ASSIGNDIVX, ASSIGNMODX:
                return execAssign(node);

            case VAR:
                return new Variable(node.type, variables.seek(node.id).value);
            case LIT:
                return new Variable(node.type, switch (node.type) {
                    case None -> null;
                    case Int -> ((TNodeLiteral)node).iLit;
                    case Real -> ((TNodeLiteral)node).rLit;
                    case String -> null;
                });
        }
        return null;
    }

    private Variable execAssign(TNode node) {
        Variable val = execExpression(node.getChild(0));
        Variable var = variables.seek(node.id);

        var.value = switch (node.getOp()) {
            case ASSIGNX -> val.value;
            case ASSIGNPLUSX -> addVars(var, val);
            case ASSIGNMINUSX -> subVars(var, val);
            case ASSIGNTIMESX -> mulVars(var, val);
            case ASSIGNDIVX -> divVars(var, val);
            case ASSIGNMODX -> modVars(var, val);
            default -> null;
        };

        return val;
    }

    private Object addVars(Variable v1, Variable v2) {
        if (v1.type == DataType.Int && v2.type == DataType.Int) {
            return (int)v1.value + (int)v2.value;
        } else {
            return (double)v1.value + (double)v2.value;
        }
    }
    private Object subVars(Variable v1, Variable v2) {
        if (v1.type == DataType.Int && v2.type == DataType.Int) {
            return (int)v1.value - (int)v2.value;
        } else {
            return (double)v1.value - (double)v2.value;
        }
    }
    private Object mulVars(Variable v1, Variable v2) {
        if (v1.type == DataType.Int && v2.type == DataType.Int) {
            return (int)v1.value * (int)v2.value;
        } else {
            return (double)v1.value * (double)v2.value;
        }
    }
    private Object divVars(Variable v1, Variable v2) {
        if (v1.type == DataType.Int && v2.type == DataType.Int) {
            return (int)v1.value / (int)v2.value;
        } else {
            return (double)v1.value / (double)v2.value;
        }
    }
    private Object modVars(Variable v1, Variable v2) {
        return (int)v1.value % (int)v2.value;
    }

    private Object expoVars(Variable v1, Variable v2) {
        if (v1.type == DataType.Int && v2.type == DataType.Int) {
            int i = 1;
            for (int j = (int)v2.value; j > 0; j--) {
                i *= (int)v1.value;
            }
            return i;
        } else {
            return Math.pow((double)v1.value, (double)v2.value);
        }
    }



}
