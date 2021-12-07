public class TreeNode<T>
{

    private TreeNode<T> leftChild;
    private TreeNode<T> rightSibling;
    private TreeNode<T> parent;

    private T value;

    public TreeNode(T value)
    {
        this.value = value;
    }

    public void setLeftChild(TreeNode<T> leftChild)
    {
        this.leftChild = leftChild;
        leftChild.parent = this;
    }

    public void setRightSibling(TreeNode<T> rightSibling)
    {
        assert this.parent.leftChild != null;

        this.rightSibling = rightSibling;
        rightSibling.parent = this.parent;
    }

    public static <T> void PreOrderTreeWalk(TreeNode<T> node)
    {
        if (node != null)
        {
            System.out.println(node.value);
            PreOrderTreeWalk(node.leftChild);
            PreOrderTreeWalk(node.rightSibling);
        }
    }

    public static <T> void MorrisPreOrder(TreeNode<T> current)
    {

        //TreeNode<T> current = node;

        while (current != null)
        {
            System.out.println(current.value);

            if (current.leftChild != null)
            {
                current = current.leftChild;
            }
            else if (current.rightSibling != null)
            {

                current = current.rightSibling;
            }

            else
            {
                while (current.parent != null)
                {
                    current = current.parent;
                    if (current.rightSibling != null)
                    {
                        break;
                    }
                }
                current = current.rightSibling;

            }
        }

    }

    public static void main(String[] args)
    {
        TreeNode<String> X = new TreeNode<>("X");
        TreeNode<String> Y = new TreeNode<>("Y");
        TreeNode<String> Z = new TreeNode<>("Z");
        TreeNode<String> U = new TreeNode<>("U");
        TreeNode<String> V = new TreeNode<>("V");
        TreeNode<String> W = new TreeNode<>("W");
        TreeNode<String> S = new TreeNode<>("S");
        TreeNode<String> R = new TreeNode<>("R");
        TreeNode<String> L = new TreeNode<>("L");
        TreeNode<String> N = new TreeNode<>("N");
        TreeNode<String> K = new TreeNode<>("K");
        TreeNode<String> J = new TreeNode<>("J");
        TreeNode<String> B = new TreeNode<>("B");
        TreeNode<String> F = new TreeNode<>("F");
        TreeNode<String> G = new TreeNode<>("G");
        TreeNode<String> H = new TreeNode<>("H");
        TreeNode<String> O = new TreeNode<>("O");
        TreeNode<String> P = new TreeNode<>("P");

        TreeNode<String> T = new TreeNode<>("T");
        T.setLeftChild(X);
        X.setRightSibling(Y);
        Y.setRightSibling(Z);

        TreeNode<String> M = new TreeNode<>("M");
        M.setLeftChild(S);
        S.setRightSibling(T);

        TreeNode<String> E = new TreeNode<>("E");
        E.setLeftChild(K);
        K.setRightSibling(L);
        L.setRightSibling(M);
        M.setRightSibling(N);

        K.setLeftChild(R);

        TreeNode<String> Q = new TreeNode<>("Q");
        Q.setLeftChild(V);
        V.setRightSibling(W);

        TreeNode<String> I = new TreeNode<>("I");
        I.setLeftChild(Q);

        TreeNode<String> D = new TreeNode<>("D");
        D.setLeftChild(I);
        I.setRightSibling(J);

        TreeNode<String> A = new TreeNode<>("A");
        TreeNode<String> C = new TreeNode<>("C");
        A.setLeftChild(B);
        B.setRightSibling(C);
        C.setRightSibling(D);
        D.setRightSibling(E);

        C.setLeftChild(F);
        F.setRightSibling(G);
        G.setRightSibling(H);

        F.setLeftChild(O);

        O.setRightSibling(P);
        P.setLeftChild(U);

        TreeNode.PreOrderTreeWalk(A);
        TreeNode.MorrisPreOrder(A);
        //System.out.print(M.parent.value);

    }

}
