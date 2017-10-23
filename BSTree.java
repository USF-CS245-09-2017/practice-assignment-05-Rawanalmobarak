public class BSTree<T extends Comparable<T>> {

	private class BSTNode {
		public String data;
		public BSTNode left;
		public BSTNode right;

		BSTNode(String newdata) {
			data = newdata;
		}
	}

	private BSTNode root;

	public boolean find(String String) {
		return find(root, String);
	}

	public boolean find(BSTNode tree, String string) {
		if (tree == null) {
			return false;
		}
		if (string.compareTo((String) tree.data) == 0) {
			return true;
		}
		if (string.compareTo((String) tree.data) < 0) {
			return find(tree.left, string);
		} else {
			return find(tree.right, string);
		}
	}

	public void insert(String string) {
		root = insert(root, string);
	}

	public BSTree<T>.BSTNode insert(BSTNode tree, String string) {
		if (tree == null) {
			return new BSTNode(string);
		}
		if (string.compareTo(tree.data) < 0) {
			tree.left = insert(tree.left, string);
			return tree;
		} else {
			tree.right = insert(tree.right, string);
			return tree;
		}
	}

	public void delete(String string) {
		root = delete(root, string);
	}

	public BSTree<T>.BSTNode delete(BSTNode tree, String string) {
		if (tree == null) {
			return null;
		}
		if (tree.data.compareTo(string) == 0) {
			if (tree.left == null) {
				return tree.right;
			} else if (tree.right == null) {
				return tree.left;
			} else {
				if (tree.right.left == null) {
					tree.data = tree.right.data;
					tree.right = tree.right.right;
					return tree;
				} else {
					tree.data = RemoveSmallest(tree.right);
					return tree;
				}
			}
		} else if (string.compareTo(tree.data) < 0) {
			tree.left = delete(tree.left, string);
			return tree;
		} else {
			tree.right = delete(tree.right, string);
			return tree;
		}

	}

	private String RemoveSmallest(BSTree<T>.BSTNode tree) {
		if (tree.left.left == null) {
			String smallest = tree.left.data;
			tree.left = tree.left.right;
			return smallest;
		} else {
			return RemoveSmallest(tree.left);
		}
	}

	public Object toStringInOrder() {
		return toStringInOrder(root);
	}

	public Object toStringInOrder(BSTree<T>.BSTNode tree) {
		String result = "";
		if (tree != null) {
			String leftString = (String) toStringInOrder(tree.left);
			String rightString = (String) toStringInOrder(tree.right);

			if (!leftString.equals("")) {
				result = result + leftString + " ";
			}

			result = result + tree.data;

			if (!rightString.equals("")) {
				result = result + " " + rightString;
			}

		}
		return result;

	}

	public Object toStringPreOrder() {
		return toStringPreOrder(root);
	}

	public Object toStringPreOrder(BSTree<T>.BSTNode tree) {

		String result = "";
		if (tree != null) {
			String leftString = (String) toStringPreOrder(tree.left);
			String rightString = (String) toStringPreOrder(tree.right);

			result = result + tree.data;

			if (!leftString.equals("")) {
				result = result + " " + leftString;
			}

			if (!rightString.equals("")) {
				result = result + " " + rightString;
			}

		}
		return result;
	}

}
