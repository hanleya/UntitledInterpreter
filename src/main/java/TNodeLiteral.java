public class TNodeLiteral extends TNode {

    public double rLit;
    public int iLit;

    public enum LitType { Int, Real }
    public LitType ltype;

    public TNodeLiteral(LitType type) {
        super(NodeOps.LIT);
        this.ltype = type;
    }

    public void printLit(String indent) {
        System.out.println(indent + ltype.toString() + "\t" +
                (switch (ltype) {
                    case Int -> iLit;
                    case Real -> rLit;
                }));
    }

}
