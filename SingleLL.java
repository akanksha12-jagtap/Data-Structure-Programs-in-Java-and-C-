package ds;

import java.util.Scanner;

public class SingleLL {
	//class to declare node
	class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data=data;
			this.next=null;
		}
	}
	
	public static Node p;
	
	//add node function
	public void add(int num) {
		Node newnode= new Node(num);
		Node q=p;
		if(p==null) {
			p=newnode;
		}
		else {
			while(q.next!=null) {
				q=q.next;
			}
			q.next=newnode;
			q.next.next=null;
		}
	}
	
	//display LL method
	public void display() {
		Node q=p;
		if(p==null) {
			System.out.println("LL is empty");
		}
		else {
			while(q!=null) {
				System.out.print(q.data+" ");
				q=q.next;
			}
		}
	}
	
	//return the count of the nodes in LL
	public int count() {
		Node q=p;
		int cnt=0;
		if(p==null) {
			return 0;
		}
		else {
			while(q!=null) {
				cnt++;
				q=q.next;
			}
			return cnt;
		}
	}
	
	//sort the items in LL
	public void sort() {
		Node i,j;
		int temp;
		if(p==null) {
			System.out.println("LL is Empty");
		}
		else {
			for(i=p;i!=null;i=i.next) {
				for(j=i.next;j!=null;j=j.next) {
					if(i.data>j.data) {
						temp=i.data;
						i.data=j.data;
						j.data=temp;
					}
				}
			}
			display();
		}
	}
	
	//inserting node in the existing LL
	public void insert(int num,int pos) {
		Node newnode= new Node(num);
		Node q=p;
		Node temp;
		if(pos==1) {
			p=newnode;
			p.data=num;
			p.next=q;
			return;
		}
		if(pos==count()+1) {
			add(num);
			return;
		}
		else {
			for(int i=1;i<=(pos-2);i++) {
				q=q.next;
			}
			temp=q.next;
			q.next=newnode;
			q.next.data=num;
			q.next.next=temp;
		}
		
	}
	
	//removing node from existing LL
	public int remove(int pos) {
		Node q=p;
		int temp;
		if(p==null) {
			return 0;
		}
		if(pos==1) {
			temp=p.data;
			p=p.next;
			q=p;
			return temp;
		}
		else {
			for(int i=1;i<(pos-1);i++) {
				q=q.next;
			}
			temp=q.next.data;
			q.next=q.next.next;
			return temp;
		}
	}
	
	public void search(int num) {
		int flag=0,pos=1;
		Node q;
		for(q=p;q!=null;q=q.next) {
			if(q.data==num) {
				flag=1;
				break;
			}
			pos++;
		}
		if(flag==1){
			System.out.println("Elem found at position:"+pos);
		}
		else{
			System.out.println("Elem not found");
		}
	}
	//Main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		SingleLL sl=new SingleLL();
		p=null;
		char ch='y';
		while(ch=='y') {
			System.out.println("1. ADD\n2. DISPLAY\n3. COUNT\n4. SORT\n5. INSERT\n6. REMOVE\n7. SEARCH");
			System.out.println("Enter a option:");
			int opt=sc.nextInt();
			System.out.println();
			switch(opt) {
			case 1:
				System.out.println("Enter no. to add: ");
				int num=sc.nextInt();
				sl.add(num);
				break;
			case 2:
				System.out.println("LL contains following items: \n");
				sl.display();
				break;
			case 3:
				int cnt=sl.count();
				System.out.println("Count is: "+cnt);
				break;
			case 4:
				System.out.println("Sorted list is: ");
				sl.sort();
				break;
			case 5:
				System.out.println("Enter position: ");
				int pos=sc.nextInt();
				System.out.println("Enter Data: ");
				num=sc.nextInt();
				sl.insert(num,pos);
				break;
			case 6:
				System.out.println("Enter position: ");
				pos=sc.nextInt();
				num=sl.remove(pos);
				if(num==0) {
					System.out.println("LL is empty");
				}
				else{
					System.out.println("removed elem is:"+num);
				}
				break;
			case 7:
				System.out.println("Enter number: ");
				num=sc.nextInt();
				sl.search(num);
				break;
			default:
				System.out.println("Invalid option..!");
				break;
			}
			System.out.print("\nDo you want to continue?");
			ch=sc.next().charAt(0);
		}
		sc.close();
		
	}

}
