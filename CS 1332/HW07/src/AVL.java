import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Your implementation of an AVL Tree.
 *
 * @author Owen Huggins
 * @userid ohuggins3
 * @GTID 903591787
 * @version 1.0
 */
public class AVL<T extends Comparable<? super T>> {
    // DO NOT ADD OR MODIFY INSTANCE VARIABLES.
    private AVLNode<T> root;
    private int size;

    /**
     * A no-argument constructor that should initialize an empty AVL.
     *
     * Since instance variables are initialized to their default values, there
     * is no need to do anything for this constructor.
     */
    public AVL() {
        // DO NOT IMPLEMENT THIS CONSTRUCTOR!
    }

    /**
     * Initializes the AVL tree with the data in the Collection. The data
     * should be added in the same order it appears in the Collection.
     *
     * @throws IllegalArgumentException if data or any element in data is null
     * @param data the data to add to the tree
     */
    public AVL(Collection<T> data) {
        if (data == null || data.contains(null)) {
            throw new java.lang.IllegalArgumentException("data cannot be null");
        } else {
            for (T element : data) {
                this.add(element);
            }
        }
    }

    /**
     * Adds the data to the AVL. Start by adding it as a leaf like in a regular
     * BST and then rotate the tree as needed.
     *
     * If the data is already in the tree, then nothing should be done (the
     * duplicate shouldn't get added, and size should not be incremented).
     *
     * Remember to recalculate heights and balance factors going up the tree,
     * rebalancing if necessary.
     *
     * @throws java.lang.IllegalArgumentException if the data is null
     * @param data the data to be added
     */
    public void add(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("data cannot be null");
        } else {
            if (this.size == 0) {
                this.root = new AVLNode<>(data);
                this.size++;
            } else {
                root = addHelper(data, this.root);
            }
        }


    }



    /**
     * Adds the data to the tree.
     * This is the helper method for add, it adds the data recursively
     * Must be O(log n) for best and average cases and O(n) for worst case.
     * @param data the data to add
     * @param current the current node that the is being checked in the BST
     * @return the node that was added with updated height and balance factor
     */

    private AVLNode<T> addHelper(T data, AVLNode<T> current) {
        AVLNode<T> copy = new AVLNode<>(data);
        if (current == null) {
            this.size++;
            return copy;
        }
        if (data.compareTo(current.getData()) < 0) {

            current.setLeft(addHelper(data, current.getLeft()));

        } else if (data.compareTo(current.getData()) > 0) {
            current.setRight(addHelper(data, current.getRight()));

        }
        heightBalanceHelper(current);
        return balanceProcedure(current);
    }

    /**
     * Calculates the height and balance factor after the node was added
     * @param current the root that was added
     *
     */

    private void heightBalanceHelper(AVLNode<T> current) {
        current.setHeight(1 + Math.max(additionalHelper(current.getLeft()), additionalHelper(current.getRight())));
        current.setBalanceFactor(additionalHelper(current.getLeft()) - additionalHelper(current.getRight()));

    }
    /**
     * Calculates the height and balance factor after the node was added
     * @param current the root that was added
     * @return the new updated height for the node of the tree
     */

    private int additionalHelper(AVLNode<T> current) {
        if (current == null) {
            return -1;
        } else {
            return current.getHeight();
        }
    }

    /**
     * Checks the node's balance to update it
     * @param current the root that was added
     * @return the node that was correctly rotated
     */
    private AVLNode<T> balanceProcedure(AVLNode<T> current) {
        if (current.getBalanceFactor() < -1) {
            if (current.getRight().getBalanceFactor() > 0) {
                current.setRight(rightRotate(current.getRight()));
            }
            current = leftRotate(current);

        } else if (current.getBalanceFactor() > 1) {
            if (current.getLeft().getBalanceFactor() < 0) {
                current.setLeft(leftRotate(current.getLeft()));
            }
            current = rightRotate(current);
        }
        return current;

    }

    /**
     * Checks the node's balance to update it
     * @param nodeA the node that will change
     * @return the node that is rotated left
     */
    private AVLNode<T> leftRotate(AVLNode<T> nodeA) {
        AVLNode<T> nodeB = nodeA.getRight();
        nodeA.setRight(nodeB.getLeft());
        nodeB.setLeft(nodeA);
        heightBalanceHelper(nodeA);
        heightBalanceHelper(nodeB);
        return nodeB;

    }

    /**
     * Checks the node's balance to update it
     * @param nodeC the node that will change
     * @return the node that was rotated right
     */
    private AVLNode<T> rightRotate(AVLNode<T> nodeC) {
        AVLNode<T> nodeB = nodeC.getLeft();
        nodeC.setLeft(nodeB.getRight());
        nodeB.setRight(nodeC);
        heightBalanceHelper(nodeC);
        heightBalanceHelper(nodeB);
        return nodeB;

    }





    /**
     * Removes the data from the tree. There are 3 cases to consider:
     *
     * 1: the data is a leaf. In this case, simply remove it.
     * 2: the data has one child. In this case, simply replace it with its
     * child.
     * 3: the data has 2 children. Use the successor to replace the data,
     * not the predecessor. As a reminder, rotations can occur after removing
     * the successor node.
     *
     * Remember to recalculate heights going up the tree, rebalancing if
     * necessary.
     *
     * @throws IllegalArgumentException if the data is null
     * @throws java.util.NoSuchElementException if the data is not found
     * @param data the data to remove from the tree.
     * @return the data removed from the tree. Do not return the same data
     * that was passed in.  Return the data that was stored in the tree.
     */
    public T remove(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("data cannot be null");
        }
        if (this.size == 1 && data.equals(this.root.getData())) {
            T copy = this.root.getData();
            clear();
            return copy;
        }
        AVLNode<T> dummyNode = new AVLNode<T>(null);
        this.root = removeHelper(data, this.root, dummyNode);
        assert this.root != null;
        heightBalanceHelper(this.root);
        return dummyNode.getData();

    }
    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     *
     * @param data the data to remove
     * @param node the current node the BST is on
     * @param dummyNode a placer node for pointer reinforcement
     * @return the data that was removed
     * @throws java.util.NoSuchElementException   if the data is not in the tree
     */

    private AVLNode<T> removeHelper(T data, AVLNode<T> node, AVLNode<T> dummyNode) {
        if (node == null) {
            throw new java.util.NoSuchElementException("data not found");
        } else if (data.compareTo(node.getData()) < 0) {
            node.setLeft(removeHelper(data, node.getLeft(), dummyNode));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(removeHelper(data, node.getRight(), dummyNode));
        } else if (data.equals(node.getData())) {
            dummyNode.setData(node.getData());
            this.size--;
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            } else if (node.getLeft() != null && node.getRight() == null) {
                return node.getLeft();
            } else if (node.getLeft() == null && node.getRight() != null) {
                return node.getRight();
            } else {
                AVLNode<T> dummyNode2 = new AVLNode<>(null);
                assert node.getRight() != null;
                node.setRight(removeSuccessor(node.getRight(), dummyNode2));
                node.setData(dummyNode2.getData());
            }
        }
        heightBalanceHelper(node);
        return balanceProcedure(node);

    }

    /**
     * helper method for remove, using the successor to replace the data.
     *
     *
     * @param node the current node the BST is on
     * @param dummy a placer node for pointer reinforcement
     * @return the data that was removed.
     */

    private AVLNode<T> removeSuccessor(AVLNode<T> node, AVLNode<T> dummy) {
        if (node.getLeft() == null) {
            dummy.setData(node.getData());
            return node.getRight();
        } else {
            node.setLeft(removeSuccessor(node.getLeft(), dummy));
        }
        heightBalanceHelper(node);
        return balanceProcedure(node);
    }

    /**
     * Returns the data in the tree matching the parameter passed in (think
     * carefully: should you use value equality or reference equality?).
     *
     * @throws IllegalArgumentException if the data is null
     * @throws java.util.NoSuchElementException if the data is not found
     * @param data the data to search for in the tree.
     * @return the data in the tree equal to the parameter. Do not return the
     * same data that was passed in.  Return the data that was stored in the
     * tree.
     */
    public T get(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("data cannot be null");
        } else if (this.size == 0) {
            throw new java.util.NoSuchElementException("data not found");
        } else {
            return (getHelper(data, this.root));
        }

    }

    /**
     * Returns the node from the tree to the get method
     *
     *
     * @param data the data to search for
     * @param node the current node the method is looking at
     * @return the node the data is equal to
     * @throws java.util.NoSuchElementException   if the data is not in the tree
     */

    private T getHelper(T data, AVLNode<T> node) {
        if (node == null) {
            throw new java.util.NoSuchElementException("Data not found");
        }
        if (data.compareTo(node.getData()) < 0) {
            return getHelper(data, node.getLeft());
        } else if (data.compareTo(node.getData()) > 0) {
            return getHelper(data, node.getRight());
        } else {
            return node.getData();
        }
    }

    /**
     * Returns whether or not data matching the given parameter is contained
     * within the tree.
     *
     * This must be done recursively.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data the data to search for
     * @return true if the parameter is contained within the tree, false
     * otherwise
     * @throws java.lang.IllegalArgumentException if data is null
     */

    public boolean contains(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("Data cannot be null");
        }
        return (containsHelper(data, this.root));
    }

    /**
     * Returns the answer if the BST contains the data, helper method for contains
     *
     *
     * @param data the data to search for
     * @param node the current node the method is looking at
     * @return if the data is in the tree or not
     */

    private boolean containsHelper(T data, AVLNode<T> node) {
        if (node == null) {
            return false;
        }
        if (data.compareTo(node.getData()) < 0) {
            return containsHelper(data, node.getLeft());
        } else if (data.compareTo(node.getData()) > 0) {
            return containsHelper(data, node.getRight());
        } else {
            return data.equals(node.getData());
        }
    }


    /**
     * Returns the data on branches of the tree with the maximum depth. If you
     * encounter multiple branches of maximum depth while traversing, then you
     * should list the remaining data from the left branch first, then the
     * remaining data in the right branch. This is essentially a preorder
     * traversal of the tree, but only of the branches of maximum depth.
     *
     * Your list should not duplicate data, and the data of a branch should be
     * listed in order going from the root to the leaf of that branch.
     *
     * Should run in worst case O(n), but you should not explore branches that
     * do not have maximum depth. You should also not need to traverse branches
     * more than once.
     *
     * Hint: How can you take advantage of the balancing information stored in
     * AVL nodes to discern deep branches?
     *
     * Example Tree:
     *                           10
     *                       /        \
     *                      5          15
     *                    /   \      /    \
     *                   2     7    13    20
     *                  / \   / \     \  / \
     *                 1   4 6   8   14 17  25
     *                /           \          \
     *               0             9         30
     *
     * Returns: [10, 5, 2, 1, 0, 7, 8, 9, 15, 20, 25, 30]
     *
     * @return the list of data in branches of maximum depth in preorder
     * traversal order
     */
    public List<T> deepestBranches() {
        List<T> list = new ArrayList<>();
        if (this.root != null) {
            if (this.root.getHeight() == 0) {
                list.add(this.root.getData());
                return list;
            }
            preorderHelper(this.root, list);
        }
        return list;

    }

    /**
     * recursive helper method for preorder
     * @param node the starting node
     * @param list the list that we are returning in preorder
     *
     */

    private void preorderHelper(AVLNode<T> node, List<T> list) {
        if (node == null) {
            return;
        }
        if (node.getLeft().getHeight() > node.getRight().getHeight()) {
            list.add(node.getData());
            if (node.getLeft().getBalanceFactor() > 0) {
                deepestBranchesHelper1(node.getLeft(), list);
            } else {
                deepestBranchesHelper2(node.getLeft(), list);
            }
        } else if (node.getLeft().getHeight() < node.getRight().getHeight()) {
            list.add(node.getData());
            if (node.getRight().getBalanceFactor() > 0) {
                deepestBranchesHelper1(node.getRight(), list);
            } else {
                deepestBranchesHelper2(node.getRight(), list);
            }
        } else {
            list.add(node.getData());
            if (node.getLeft().getHeight() == 0 && node.getRight().getHeight() == 0) {
                list.add(node.getLeft().getData());
                list.add(node.getRight().getData());
                return;
            }
            preorderHelper(node.getLeft(), list);
            preorderHelper(node.getRight(), list);
        }

    }
    /**
     * recursive helper method for preorder
     * @param node the starting node
     * @param list the list that we are returning in preorder
     *
     */
    private void deepestBranchesHelper1(AVLNode<T> node, List<T> list) {
        if (node != null) {
            list.add(node.getData());
            deepestBranchesHelper1(node.getLeft(), list);

        }


    }

    /**
     * recursive helper method for preorder
     * @param node the starting node
     * @param list the list that we are returning in preorder
     *
     */
    private void deepestBranchesHelper2(AVLNode<T> node, List<T> list) {
        if (node != null) {
            list.add(node.getData());
            deepestBranchesHelper2(node.getRight(), list);

        }


    }






    /**
     * Returns a sorted list of data that are within the threshold bounds of
     * data1 and data2. That is, the data should be > data1 and < data2.
     *
     * Should run in worst case O(n), but this is heavily dependent on the
     * threshold data. You should not explore branches of the tree that do not
     * satisfy the threshold.
     *
     * Example Tree:
     *                           10
     *                       /        \
     *                      5          15
     *                    /   \      /    \
     *                   2     7    13    20
     *                  / \   / \     \  / \
     *                 1   4 6   8   14 17  25
     *                /           \          \
     *               0             9         30
     *
     * sortedInBetween(7, 14) returns [8, 9, 10, 13]
     * sortedInBetween(3, 8) returns [4, 5, 6, 7]
     * sortedInBetween(8, 8) returns []
     *
     * @throws java.lang.IllegalArgumentException if data1 or data2 are null
     * @param data1 the smaller data in the threshold
     * @param data2 the larger data in the threshold
     * or if data1 > data2
     * @return a sorted list of data that is > data1 and < data2
     */
    public List<T> sortedInBetween(T data1, T data2) {
        List<T> list = new ArrayList<>();
        if (data1 == null || data2 == null || data1.compareTo(data2) > 0) {
            throw new java.lang.IllegalArgumentException("data1 and data2 cannot be null and "
                    + "data1 cannot be greater than data2");
        } else if (data1.equals(data2)) {
            return list;
        }
        inorderHelper(this.root, list, data1, data2);
        return list;
    }

    /**
     * helper method for inorder, adds to the list all the data of the BST in inorder
     *
     * @param node the current node the method is looking at
     * @param list the list that we will use in the inorder method
     * @param data1 the smallest data in the range
     * @param data2 the highest data in the range
     */

    private void inorderHelper(AVLNode<T> node, List<T> list, T data1, T data2) {
        if (node != null) {
            if (node.getData().compareTo(data1) > 0) {
                inorderHelper(node.getLeft(), list, data1, data2);
            }
            if (node.getData().compareTo(data1) > 0 && node.getData().compareTo(data2) < 0) {
                list.add(node.getData());
            }
            if (node.getData().compareTo(data2) < 0) {
                inorderHelper(node.getRight(), list, data1, data2);
            }

        }
    }



    /**
     * Clears the tree.
     */
    public void clear() {
        this.root = null;
        this.size = 0;

    }

    /**
     * Returns the height of the root of the tree.
     *
     * Since this is an AVL, this method does not need to traverse the tree
     * and should be O(1)
     *
     * @return the height of the root of the tree, -1 if the tree is empty
     */
    public int height() {
        if (this.root == null) {
            return -1;
        } else {
            return this.root.getHeight();
        }

    }

    /**
     * Returns the size of the AVL tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return number of items in the AVL tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD
        return size;
    }

    /**
     * Returns the root of the AVL tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the root of the AVL tree
     */
    public AVLNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }
}