import java.lang.reflect.Array;
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
        variables.pushScope();

        for (TNode n : node.children) {
            switch (n.getOp()) {
                case DECL:
                    variables.addVar(n.id, execExpression(n.getChild(0)));
                    break;
                case RETURN:
                    return execExpression(n.getChild(0));
                case IF:
                    if ((int)execExpression(n.getChild(0)).value != 0) {
                        Variable v = execBlock(n.getChild(1));
                        if (v != null) {
                            return v;
                        }
                    }
                    break;
                case WHILE:
                    while ((int)execExpression(n.getChild(0)).value != 0) {
                        Variable v = execBlock(n.getChild(1));
                        if (v != null) {
                            return v;
                        }
                    }
                    break;
                default:
                    execExpression(n).printVar();
            }
        }

        variables.popScope();
        return null;
    }

    private Variable execExpression(TNode node) {
        switch (node.getOp()) {
            case ASSIGNX, ASSIGNPLUSX, ASSIGNMINUSX, ASSIGNTIMESX, ASSIGNDIVX, ASSIGNMODX:
                return execAssign(node);
            case ORX, ANDX:
                return execAndOr(node);
            case EQX, NEQX, LTX, LEQX, GTX, GEQX:
                return execComp(node);
            case ADDX, SUBX, MULX, DIVX, MODX, EXPOX:
                return execArith(node);
            case PREINC, PREDEC, POSTINC, POSTDEC:
                return execIncDec(node);
            case NOT:
                Variable v = execExpression(node.getChild(0));
                v.value = ((int)v.value == 0) ? 1 : 0;
                return v;
            case CALL:
                return execFuncExpr(node);
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

    private Variable execAndOr(TNode node) {
        if (node.getOp() == NodeOps.ORX) {
            for (TNode n : node.children) {
                if ((int)execExpression(n).value == 1) {
                    return new Variable(DataType.Int, 1);
                }
            }
            return new Variable(DataType.Int, 0);
        } else {
            for (TNode n : node.children) {
                if ((int)execExpression(n).value == 0) {
                    return new Variable(DataType.Int, 0);
                }
            }
            return new Variable(DataType.Int, 1);
        }
    }

    private Variable execComp(TNode node) {
        Variable v1 = execExpression(node.getChild(0));
        Variable v2 = execExpression(node.getChild(1));

        boolean b = false;

        switch (node.getOp()) {
            case EQX:
                if (v1.type == DataType.Int && v2.type == DataType.Int) {
                    b = (int)v1.value == (int)v2.value;
                } else if (v1.type == DataType.Int && v2.type == DataType.Real) {
                    b = (int)v1.value == (double)v2.value;
                } else if (v1.type == DataType.Real && v2.type == DataType.Int) {
                    b = (double)v1.value == (int)v2.value;
                } else {
                    b = (double)v1.value == (double)v2.value;
                }
                break;
            case NEQX:
                if (v1.type == DataType.Int && v2.type == DataType.Int) {
                    b = (int)v1.value != (int)v2.value;
                } else if (v1.type == DataType.Int && v2.type == DataType.Real) {
                    b = (int)v1.value != (double)v2.value;
                } else if (v1.type == DataType.Real && v2.type == DataType.Int) {
                    b = (double)v1.value != (int)v2.value;
                } else {
                    b = (double)v1.value != (double)v2.value;
                }
                break;
            case LTX:
                if (v1.type == DataType.Int && v2.type == DataType.Int) {
                    b = (int)v1.value < (int)v2.value;
                } else if (v1.type == DataType.Int && v2.type == DataType.Real) {
                    b = (int)v1.value < (double)v2.value;
                } else if (v1.type == DataType.Real && v2.type == DataType.Int) {
                    b = (double)v1.value < (int)v2.value;
                } else {
                    b = (double)v1.value < (double)v2.value;
                }
                break;
            case LEQX:
                if (v1.type == DataType.Int && v2.type == DataType.Int) {
                    b = (int)v1.value <= (int)v2.value;
                } else if (v1.type == DataType.Int && v2.type == DataType.Real) {
                    b = (int)v1.value <= (double)v2.value;
                } else if (v1.type == DataType.Real && v2.type == DataType.Int) {
                    b = (double)v1.value <= (int)v2.value;
                } else {
                    b = (double)v1.value <= (double)v2.value;
                }
                break;
            case GTX:
                if (v1.type == DataType.Int && v2.type == DataType.Int) {
                    b = (int)v1.value > (int)v2.value;
                } else if (v1.type == DataType.Int && v2.type == DataType.Real) {
                    b = (int)v1.value > (double)v2.value;
                } else if (v1.type == DataType.Real && v2.type == DataType.Int) {
                    b = (double)v1.value > (int)v2.value;
                } else {
                    b = (double)v1.value > (double)v2.value;
                }
                break;
            case GEQX:
                if (v1.type == DataType.Int && v2.type == DataType.Int) {
                    b = (int)v1.value >= (int)v2.value;
                } else if (v1.type == DataType.Int && v2.type == DataType.Real) {
                    b = (int)v1.value >= (double)v2.value;
                } else if (v1.type == DataType.Real && v2.type == DataType.Int) {
                    b = (double)v1.value >= (int)v2.value;
                } else {
                    b = (double)v1.value >= (double)v2.value;
                }
                break;
        }

        return new Variable(DataType.Int, b ? 1 : 0);
    }

    private Variable execArith(TNode node) {

        Variable v1 = execExpression(node.getChild(0));
        Variable v2 = execExpression(node.getChild(1));

        Object o = switch (node.getOp()) {
            case ADDX -> addVars(v1, v2);
            case SUBX -> subVars(v1, v2);
            case MULX -> mulVars(v1, v2);
            case DIVX -> divVars(v1, v2);
            case MODX -> modVars(v1, v2);
            case EXPOX -> expoVars(v1, v2);
            default -> null;
        };

        return new Variable(node.type, o);

    }

    private Variable execIncDec(TNode node) {
        Variable v = variables.seek(node.getChild(0).id);
        Variable ret = new Variable(DataType.Int, v.value);

        switch (node.getOp()) {
            case PREDEC, POSTDEC:
                v.value = (int)v.value - 1;
                break;
            case PREINC, POSTINC:
                v.value = (int)v.value + 1;
                break;
        }

        if (node.getOp() == NodeOps.PREINC || node.getOp() == NodeOps.PREDEC) {
            ret.value = v.value;
        }

        return ret;
    }

    private Variable execFuncExpr(TNode node) {

        ArrayList<Variable> params = new ArrayList<>();

        for (TNode n : node.children) {
            params.add(execExpression(n));
        }

        for (TNode n : root.children) {
            if (n.id == node.id) {
                return execFunc(n, params);
            }
        }

        return null;

    }


    private Object addVars(Variable v1, Variable v2) {
        if (v1.type == DataType.Int && v2.type == DataType.Int) {
            return (int)v1.value + (int)v2.value;
        } else if (v1.type == DataType.Int && v2.type == DataType.Real) {
            return (int)v1.value + (double)v2.value;
        } else if (v1.type == DataType.Real && v2.type == DataType.Int) {
            return (double)v1.value + (int)v2.value;
        } else {
            return (double)v1.value + (double)v2.value;
        }
    }
    private Object subVars(Variable v1, Variable v2) {
        if (v1.type == DataType.Int && v2.type == DataType.Int) {
            return (int)v1.value - (int)v2.value;
        } else if (v1.type == DataType.Int && v2.type == DataType.Real) {
            return (int)v1.value - (double)v2.value;
        } else if (v1.type == DataType.Real && v2.type == DataType.Int) {
            return (double)v1.value - (int)v2.value;
        } else {
            return (double)v1.value - (double)v2.value;
        }
    }
    private Object mulVars(Variable v1, Variable v2) {
        if (v1.type == DataType.Int && v2.type == DataType.Int) {
            return (int)v1.value * (int)v2.value;
        } else if (v1.type == DataType.Int && v2.type == DataType.Real) {
            return (int)v1.value * (double)v2.value;
        } else if (v1.type == DataType.Real && v2.type == DataType.Int) {
            return (double)v1.value * (int)v2.value;
        } else {
            return (double)v1.value * (double)v2.value;
        }
    }
    private Object divVars(Variable v1, Variable v2) {
        if (v1.type == DataType.Int && v2.type == DataType.Int) {
            return (int)v1.value / (int)v2.value;
        } else if (v1.type == DataType.Int && v2.type == DataType.Real) {
            return (int)v1.value / (double)v2.value;
        } else if (v1.type == DataType.Real && v2.type == DataType.Int) {
            return (double)v1.value / (int)v2.value;
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
        } else if (v1.type == DataType.Int && v2.type == DataType.Real) {
            return Math.pow((int)v1.value, (double)v2.value);
        } else if (v1.type == DataType.Real && v2.type == DataType.Int) {
            return Math.pow((double)v1.value, (int)v2.value);
        } else {
            return Math.pow((double)v1.value, (double)v2.value);
        }
    }



}
