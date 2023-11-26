package com.alibou.demo.tu;


import com.alibou.demo.exception.StudentAssignmentException;

// Service
public class ExampleClass {

    public int add(Integer a, Integer b) {
        if (a == null || b == null) {
            return 0;
        }
        return a + b;
    }

    public int add(String a, String b) {
        if (a == null || b == null) {
            return 0;
        }
        return Integer.parseInt(a) + Integer.parseInt(b);
    }

    public int div(Integer a, Integer b) {
        if (b == 0) {
            throw new ArithmeticException("b Should not be zero!");
        }
        return a / b;
    }
}
