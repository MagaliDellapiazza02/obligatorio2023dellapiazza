package uy.edu.um.prog2.adt.stack;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

public class ArrayStack<T> implements MyStack<T>{

    private int size;
    private final T[] stack;


    @SuppressWarnings("unchecked")
    public ArrayStack(int size, Class<T> eClass) {
        this.stack = (T[]) Array.newInstance(eClass, size);
    }

    @Override
    public void push(T element) {
        if (stack[0] != null) {
            System.arraycopy(stack, 0, stack, 1, size);
        }
        stack[0] = element;
        size++;
    }

    @Override
    public T pop() throws EmptyStackException {
        T value;
        if (stack[0] == null){
            throw new EmptyStackException();
        } else {
            value=stack[0];
            System.arraycopy(stack, 1, stack, 0, size);
            size--;
        }
        return value;
    }

    @Override
    public T top() throws EmptyStackException {
        if (stack[0] == null){
            throw new EmptyStackException();
        } else {
            return stack[0];
        }
    }

    @Override
    public boolean isEmpty() {
        return stack[0] == null;
    }

    @Override
    public void makeEmpty() {
        for (int i = 0; i < size; i++) {
            stack[i] = null;
        }
    }

    @Override
    public int size() {
        return 0;
    }

}
