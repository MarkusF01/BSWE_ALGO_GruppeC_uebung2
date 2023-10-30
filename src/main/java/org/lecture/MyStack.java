package org.lecture;

public interface MyStack {
    /**
     * Initialize the stack
     */
    void init();

    /**
     * Add a new data entry to the stack
     *
     * @param data the data to add
     */
    void push(int data);

    /**
     * Remove the data entry on top
     */
    int pop();

    /**
     * Get the data that is currently on top
     *
     * @return the data that is on top
     */
    int top();

    /**
     * Check if the stack is empty
     *
     * @return true if the stack is empty
     */
    boolean empty();

    /**
     * Print the stack to the console
     */
    void print();
}
