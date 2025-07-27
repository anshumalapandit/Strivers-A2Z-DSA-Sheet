/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class DLL{
public class Node{
    int data;
    Node next;
    Node prev;
    Node(int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}
public static Node head;
public static Node tail;
//insertion at first
public void addFirst(int data){
    Node newNode=new Node(data);
    if(head==null){
        // if linkedlist is empty 
        head=tail=newNode;
         System.out.println("added first :"+head.data);
        return;
    }
    newNode.next=head;
    head.prev=newNode;
    head=newNode;
    System.out.println("added first :"+head.data);
}
// insertion at last
public void addLast(int data){
    Node newNode = new Node(data);
    if(head==null){
        head=tail=newNode;
        return;
    }
    tail.next=newNode;
    newNode.prev=tail;
    tail=newNode;
    System.out.println("added last: "+tail.data);
}
// insertion at given idx 
public void insertAtIdx(int idx,int ele){
    Node newNode=new Node(ele);
    int i=0;
    if(idx==0){
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
        System.out.println("Inserted at idx:"+idx+" element: "+head.data);
        return;
    }
    Node temp=head;
    while(i!=idx-1){
        if(temp.next!=null){
            temp=temp.next;
            i++;
        }else{
            // idx is invalid
            System.out.println("Index not found .");
        return;
            
        }
    }
    // now i reached just before where i want to add 
    // now there are 3  cases it can be head ,tail,between 
    // what if at tail
    if(temp.next==null){
        temp.next=newNode;
        newNode.prev=temp;
        tail=newNode;
        System.out.println("Inserted at idx:"+idx+" element: "+tail.data);
        return;
    }
    // what if in between anywhere
    newNode.next=temp.next;
    temp.next.prev=newNode.prev;
    temp.next=newNode;
    newNode.prev=temp;
    System.out.println("Inserted at idx:"+idx+" element: "+newNode.data);
}
// insertion just after idx
public void insertAfterIdx(int idx,int ele){
    Node newNode=new Node(ele);
    int i=0;
    if(idx==0){
        newNode.next=head.next;
        head.next.prev=newNode.prev;
        head.next=newNode;
        newNode.prev=head;
        System.out.println("Inserted at after idx:"+idx+" element: "+head.data);
        return;
    }
    Node temp=head;
    while(i!=idx){
        if(temp.next!=null){
            temp=temp.next;
            i++;
        }else{
            // idx is invalid
            System.out.println("Index not found .");
        return;
            
        }
    }
    // now i reached just before where i want to add 
    // now there are 3  cases it can be head ,tail,between 
    // what if at tail
    if(temp.next==null){
        temp.next=newNode;
        newNode.prev=temp;
        tail=newNode;
        System.out.println("Inserted at after idx:"+idx+" element: "+tail.data);
        return;
    }
    // what if in between anywhere
    newNode.next=temp.next;
    temp.next.prev=newNode.prev;
    temp.next=newNode;
    newNode.prev=temp;
    System.out.println("Inserted at after  idx:"+idx+" element: "+newNode.data);
}
// display
public void display(){
    if(head==null){
        System.out.println("DLL is empty bro!😁 add first ");
        return;
    }
    Node temp=head;
    while(temp!=null){
        System.out.print(temp.data+"<-->");
        temp=temp.next;
    }
    System.out.print("null");
    System.out.println();
}
public static void main(String [] args){
    DLL d=new DLL();
    d.addFirst(1);
    d.addFirst(2);
    d.addLast(3);
    d.addLast(4);
    d.display();
    d.insertAtIdx(0,11);
    d.display();
    d.insertAtIdx(1,12);
    d.display();
    d.insertAtIdx(5,55);
    d.display();
    d.insertAtIdx(99,12);
    d.insertAfterIdx(1,22);
    d.display();
    
}
}
