package com.example.savino.needtodo.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ClassB extends ClassAbstractA {

    @Override
    public void method1() {

        if (methodBoolean()) {  // method in abstrac class
            // bla bla
        }
    }

    @Override
    public void method2() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);

        stack.search(2);

        Integer pop = stack.pop();

    }

    @Override
    public void method3() {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);

        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }

    }

    private ClassAbstractA method4() {

        ClassAbstractA classA = new ClassAbstractA() {
            @Override
            public void method1() {

            }

            @Override
            public void method2() {

            }

            @Override
            public void method3() {

            }
        };

        return classA;
    }
}
