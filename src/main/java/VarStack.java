import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Stack;

public class VarStack {

    private static class VarFrame {
        ArrayDeque<VarScope> scopes;

        public VarFrame() {
            scopes = new ArrayDeque<>();
        }

        public VarScope getScope() {
            return scopes.peek();
        }

        public Variable seek(int id) {
            for (VarScope s : scopes) {
                Variable v = s.getVal(id);
                if (v != null) {
                    return v;
                }
            }
            return null;
        }
    }

    private static class VarScope {
        HashMap<Integer, Variable> vars;

        public VarScope() {
            vars = new HashMap<>();
        }

        public void addVar(int id, Variable var) {
            vars.put(id, var);
        }

        public Variable getVal(int id) {
            return vars.get(id);
        }

    }

    private Stack<VarFrame> frames;

    public VarStack() {
        frames = new Stack<>();
    }

    public void pushFrame() {
        frames.push(new VarFrame());
    }
    public void popFrame() {
        frames.pop();
    }

    public void pushScope() {
        frames.peek().scopes.push(new VarScope());
    }
    public void popScope() {
        frames.peek().scopes.pop();
    }

    public Variable seek(int id) {
        return frames.peek().seek(id);
    }

    public void addVar(int id, Variable var) {
        frames.peek().getScope().addVar(id, var);
    }



}