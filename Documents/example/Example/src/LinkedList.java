
public class LinkedList {
	int val;
	LinkedList next;
	LinkedList(){}
	LinkedList(int n){
		val = n;
	}
	
	LinkedList head = null;
	LinkedList tail = null;
	
	public void addNode(int val) {
		LinkedList node = new LinkedList(val);
		if(head==null) {
			head = node;
			tail = node;
		}
		else
		{tail.next = node;
		node.next = null;
		tail = node;
		}
		
	}
	
	public void printList() {
		LinkedList current  = head;
		while(current!=null) {
			System.out.println(current.val);
			current = current.next;
		}
	}
	
	public void findNode(int n) {
		LinkedList current  = head;
		while(current!=null) {
			if(current.val == n) {
				System.out.println("Value found " + n);
				return;
			}
			current = current.next;
		}
		System.out.println("Value not found " + n);
	}
	
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.addNode(5);
		l.addNode(3);
		l.findNode(7);
		l.addNode(7);
		l.addNode(2);
		l.addNode(8);
		l.findNode(7);
		l.findNode(2);
		
		l.printList();
		
	}
}
