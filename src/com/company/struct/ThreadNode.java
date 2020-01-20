package com.company.struct;

public class ThreadNode<T extends Comparable<T>> {

    private T value;

    private ThreadNode<T> leftChild;
    private ThreadNode<T> rightChild;
    private ThreadNode<T> rightThread;

    public ThreadNode() {
    }

    public ThreadNode(T value) {
        this.value = value;
    }

    public void addNode(T value) {
        if (this.value == null) {
            this.value = value;
        }
        else if (this.value.compareTo(value) > 0) {
            if (this.leftChild != null) {
                this.leftChild.addNode(value);
            } else {
                ThreadNode<T> child = new ThreadNode<>(value);
                child.rightThread = this;
                this.leftChild = child;
            }
        }
        else {
            if (this.rightChild != null) {
                this.rightChild.addNode(value);
            } else {
                ThreadNode<T> child = new ThreadNode<>(value);
                child.rightThread = this.rightThread;
                this.rightThread = null;
                this.rightChild = child;
            }
        }
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ThreadNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(ThreadNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public ThreadNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(ThreadNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public ThreadNode<T> getRightThread() {
        return rightThread;
    }

    public void setRightThread(ThreadNode<T> rightThread) {
        this.rightThread = rightThread;
    }
}
