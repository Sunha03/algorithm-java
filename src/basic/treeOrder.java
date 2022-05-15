package basic;

class Node {
	int data;	// node ��
	Node left;	// ���� ���
	Node right;	// ������ ���

	Node(int data) {
		this.data = data;
	}
}

public class treeOrder {
	public static Node root;

	// node ���� �Լ�
	public static void createNode(int data, int left, int right) {
		if (root == null) {		// �ʱ� -> root node ����
			root = new Node(data);
			
			if (left != -1) {	// left node ���� �ִ� ���, left node ����
				root.left = new Node(left);
			}
			if (right != -1) {	// right node ���� �ִ� ���, right node ����
				root.right = new Node(right);
			}
		} else {				// � node���� Ž�� �� ����
			searchNode(root, data, left, right);
		}
	}

	// node Ž�� �Լ�
	public static void searchNode(Node node, int data, int left, int right) {
		if (node == null) {				// ���� node�� null�� ���, ��� ����
			return;
		} else if (node.data == data) {	// Ž�� node ã�� �Ϸ�
			if (left != -1) {
				node.left = new Node(left);
			}
			if (right != -1) {
				node.right = new Node(right);
			}
		} else {				// Ž�� node�� ��ã�� ���, ��ͷ� Ž��
			searchNode(node.left, data, left, right);		// ���� ����Ʈ�� Ž��
			searchNode(node.right, data, left, right);		// ������ ����Ʈ�� Ž��
		}
	}

	// ���� ��ȸ(preorder) : root -> left -> right
	public static void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");	// root ��ȸ
			if (node.left != null) {			// left ��ȸ
				preOrder(node.left);
			}
			if (node.right != null ) {			// right ��ȸ
				preOrder(node.right);
			}
		}
	}

	// ���� ��ȸ(inorder) : left -> root -> right
	public static void inOrder(Node node) {
		if (node != null) {
			if (node.left != null) {			// left ��ȸ
				inOrder(node.left);
			}
			System.out.print(node.data + " ");	// root ��ȸ
			if (node.right != null ) {			// right ��ȸ
				inOrder(node.right);
			}
		}
	}
	
	// ���� ��ȸ(postorder) : left -> right -> root
	public static void postOrder(Node node) {
		if (node != null) {
			if (node.left != null) {			// left ��ȸ
				postOrder(node.left);
			}
			if (node.right != null ) {			// right ��ȸ
				postOrder(node.right);
			}
			System.out.print(node.data + " ");	// root ��ȸ
		}
	}
	
	// �ݺ� ��ȸ
	public static void iteratorOrder(Node node) {
		
	}
	
	// ���� ��ȸ
	public static void levelOrder(Node node) {
		
	}

	public static void main(String[] args) {
		int n = 10;
		
		/*
		 				 1
		 		  2			   3
		 	  4		  5		6	  7
		 	8	9	10
		 */
		createNode(1, 2, 3);
		createNode(2, 4, 5);
		createNode(4, 8, 9);
		createNode(5, 10, -1);
		createNode(3, 6, 7);
		
		preOrder(root);
		System.out.println();
		
		inOrder(root);
		System.out.println();
		
		postOrder(root);
		System.out.println();
	}

}
