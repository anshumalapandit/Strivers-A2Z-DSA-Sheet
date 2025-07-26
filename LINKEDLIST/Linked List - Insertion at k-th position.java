void insertAfterK(int value, int k) {
    Node newNode = new Node(value);
    Node temp = head;
    
    // If there are no nodes in the linked list
    // Set the new node as head and return
    if (temp == null) {
        head = newNode;
        return;
    }
    
    // Iterate to the k-th node
    // i want to stop just before the  position where i want to add element
    for (int i = 1; i < k; i++) {
        temp = temp.next;
    }
    // remember seq is important 1 then 2 
    // Set the next of new Node to next of current 1.
      newNode.next=temp.next;

    // Set the next of current to new Node 2.
    temp.next=newNode;
}
