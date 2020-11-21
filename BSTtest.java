/*
* Main testing class for BST
* @author: Xiaocheng Zhang
*/
public class BSTtest
{
    public static void main(String[] args)
    {
        //TODO CHANGE CLASS AS NEEDED TO TEST CODE
        
	BST<Integer> tree = new BST<Integer>();

        int L = 3;
        int R = 10;

	tree.insert(10);
	tree.insert(5);
	tree.insert(3);
	tree.insert(7);
	tree.insert(18);

	tree.print();
        tree.delete(7);
        System.out.println(tree.find(5));
        tree.print();
        
        System.out.println(tree.rangeSum(L, R));
    }
}
