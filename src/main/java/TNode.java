import java.util.ArrayList;

public class TNode {

    private final NodeOps op;
    public int id = -1;
    public DataType type = DataType.None;
    public final ArrayList<TNode> children = new ArrayList<TNode>();


    public TNode(NodeOps op) { this.op = op; }

    public void addChild(TNode n) { children.add(n); }

    public NodeOps getOp() { return op; }
    public TNode getChild(int i) { return children.get(i); }


    public void printNode() {
        printNode("");
    }

    private void printNode(String indent) {
        System.out.println(indent + op.toString() + "\t" + id + "\t" + type);
        for (TNode n : children) {
            if (n instanceof TNodeLiteral) {
                ((TNodeLiteral) n).printLit(indent + "  ");
            } else {
                n.printNode(indent + "  ");
            }
        }
    }

}
