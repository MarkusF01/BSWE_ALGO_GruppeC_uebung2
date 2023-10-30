package org.lecture;

public class MyStackImpl implements MyStack {
    private Node top;
    private int length;
    private boolean initialized;

    @Override
    public void init() {
        top = null;
        length = 0;
        initialized = true;
    }

    @Override
    public void push(int data) {
        checkInitialization();
        Node newNode = new Node(data);
        newNode.setNextNode(top);
        top = newNode;
        length++;
    }

    @Override
    public int pop() {
        checkInitialization();
        checkEmpty();
        int data = top.getData();
        top = top.getNextNode();
        length--;

        return data;
    }

    @Override
    public int top() {
        checkInitialization();
        checkEmpty();
        return top.getData();
    }

    @Override
    public boolean empty() {
        return length == 0;
    }

    @Override
    public void print() {
        checkInitialization();
        System.out.print("Stack: [");
        Node node = top;
        while(node.getNextNode() != null){
            System.out.print(node.getData()+", ");
            node = node.getNextNode();
        }
        System.out.print(node.getData());
        System.out.println("]");
    }

    private void checkInitialization() {
        if (!initialized) {
            throw new IllegalStateException("Stack not initialized. Call init() before using the stack.");
        }
    }
    private void checkEmpty() {
        if(empty()){
            throw new IllegalStateException("Stack is empty");
        }
    }
}
