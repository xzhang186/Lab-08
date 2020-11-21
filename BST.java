/*
* Binary search tree data structure
* @author : Xiaocheng Zhang 
*/
//public class BST<T>
public class BST<T extends Comparable<T>>
{
    /*
    * The root of the BST
    */
    TreeNode<T> root;

    /*
    * TreeNode class for a BST
    */
    private class TreeNode<T>
    {
        //Comparable<T> data;
        T data;
	TreeNode<T> left;
        TreeNode<T> right;
        int instance;

        //TreeNode(Comparable<T> item)
        TreeNode(T item)
	{
            data = item;
            instance = 1;
        }
    }

    public BST()
    {
        root = null;
    }

    /*
    * Find function that finds an item in the BST
    * @param item to be found
    * @return boolean if the item was found
    */
    public boolean find(Comparable<T> item)
    {
        return find(item, root);
    }

    /*
    * Function override of the find function
    * @param item to be found
    * @param treeNode the current treeNode you are at
    * @return boolean if the item was found
    */
    private boolean find(Comparable<T> item, TreeNode<T> treeNode)
    {
        //TODO FILL IN FUNCITON
        //throw new UnsupportedOperationException("Not yet implemented");
	
	if(treeNode == null)
        {
            return false;
        }

        if((item.compareTo(treeNode.data) == 0))
        {
            return true;
        }
        
	if(item.compareTo(treeNode.data) < 0)
        {
            return find(item, treeNode.left);
        }

        return find(item, treeNode.right);
    }

    /*
    * Insert an item to the tree
    * @param item to insert
    */
    public void insert(Comparable<T> item)
    {
        root = insert(item, root);
    }

    /*
    * Helper function for insert
    * @param item to add
    * @param treeNode you are at
    * @return treeNode you traverse to
    */
    private TreeNode<T> insert(Comparable<T> item, TreeNode<T> treeNode)
    {
        //TODO FILL IN FUNCITON
        //throw new UnsupportedOperationException("Not yet implemented");
	
	if(treeNode == null)
        {
            return new TreeNode(item);
        }

        if(item.compareTo((T) treeNode.data) < 0)
        {
            treeNode.left = insert(item, treeNode.left);
        }
        else
        {
            treeNode.right = insert(item, treeNode.right);
        }
        return treeNode;
    }

    /*
    * Function for deletion of a treeNode
    * @param item to delete
    */
    //public void delete(Comparable<T> item)
    public void delete(T item)
    {
        root = delete(item, root);
    }

    /*
    * Helper function for deletion of a treeNode
    * @param item to delete
    * @param treeNode you are at
    * @return treeNode you traverse to
    */
    //private TreeNode<T> delete(Comparable<T> item, TreeNode<T> treeNode)
    private TreeNode<T> delete(T item, TreeNode<T> treeNode)
    {
        //TODO FILL IN FUNCITON
        //throw new UnsupportedOperationException("Not yet implemented");
	
	if(treeNode == null)
        {
            return null;
        }
        
	if(treeNode.data.compareTo(item) < 0)
        {
            treeNode.right = delete(item, treeNode.right);
            return treeNode;
        }
        else if(treeNode.data.compareTo(item) > 0)
        {
            treeNode.left = delete(item, treeNode.left);
            return treeNode;
        }

	if(treeNode.left == null)
        {
            return treeNode.right;
        }
        else if(treeNode.right == null)
        {
            return treeNode.left;
        }

	if(treeNode.right.left == null)
        {
            treeNode.data = treeNode.right.data;
            treeNode.right = treeNode.right.right;
        }
        else
        {
            treeNode.data = deleteSmallest(treeNode.right);
        }

        return treeNode;
    }

    /*
    * Helper function for deletion of a treeNode
    * @param treeNode you are at
    * @return T you traverse to
    */
    private T deleteSmallest(TreeNode<T> treeNode)
    {
        if(treeNode.left.left == null)
        {
            T smallest = treeNode.left.data;
            treeNode.left = treeNode.left.right;
            return smallest;
        }
        else
        {
            return deleteSmallest(treeNode.left);
        }
    }


    /*
    * Function to find the range sum of the binary tree
    * @param L the left bound
    * @param R the right bound
    * @return The sum of the range in the binary tree
    */
    public int rangeSum(int L, int R)
    {
        //TODO FILL IN FUNCITON
        //throw new UnsupportedOperationException("Not yet implemented");
        return rangeSum(root, L, R);	
    }

    /*
    * Function to find the range sum of the binary tree
    * @param treeNode the treeNode
    * @param L the left bound
    * @param R the right bound
    * @return The sum of the range in the binary tree
    */
    private int rangeSum(TreeNode<T> treeNode, int L, int R)
    {
        int sum = 0;
        
	if(treeNode == null)
        {
            return 0;
        }
        
	if(treeNode.left != null)
        {
            sum += rangeSum(treeNode.left, L, R);
        }
        
	if(treeNode.right != null)
        {
            sum += rangeSum(treeNode.right, L, R);
        }
        
	int data = (Integer)treeNode.data;
        
	if(data >= L && data <= R)
        {
            sum += data;
        }
        
	return sum;
    }


    /*
    * Function to print the Binary tree
    */
    public void print()
    {
        print(root);
    }

    /*
    * Helper Function to print the Binary tree
    * @param root the root of the tree
    */
    private void print(TreeNode<T> root)
    {
        //TODO FILL IN FUNCITON
        //throw new UnsupportedOperationException("Not yet implemented");
	
	if(root != null)
        {
            print(root.left);
            System.out.println("root:\t" + root.data + "\tleft:\t" + getLeftData(root) + "\tright:\t" + getRightData(root));
            print(root.right);
        }
    }

    /*
     * Get left node data
     * @return T data
     */
    private T getLeftData(TreeNode<T> root)
    {
        if(root != null && root.left != null)
	{
	    return root.left.data;
	}

	return null;
    }

    /*
     * Get right node data
     * @return T data
     */
    private T getRightData(TreeNode<T> root)
    {
        if(root != null && root.right != null)
        {
            return root.right.data;
        }

        return null;
    }
}
