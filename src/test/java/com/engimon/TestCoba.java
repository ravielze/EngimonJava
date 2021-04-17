package com.engimon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestCoba {

    public class Calculator {

        public int add(int a, int b){
            return a+b;
        }
    }

    private final Calculator calculator = new Calculator();

    @BeforeAll
    static void beforeAll(){
        System.out.println("a");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("b");
    }

    @Test
    @DisplayName("Addition 1+1 = 2")
    void addition(){
        assertEquals(2, calculator.add(1, 1));
    }

    @Test
    @DisplayName("Addition -1+1 = 0")
    void addition2(){
        assertEquals(0, calculator.add(-1, 1));
    }
    
}
