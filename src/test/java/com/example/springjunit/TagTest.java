package com.example.springjunit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TagTest {

    @Test
    @DisplayName("fast")
    // 실행할때 태그가 있는것만 실행하게 한다.
    // edit configurations 에서 사용한다.
//    @Tag("fast")
    @FastTest   // 어노테이션을 직접 만들어서 사용한다.
    void test1() {
        System.out.println("test1 --");

    }

    @Test
    @DisplayName("slow")
    @SlowTest
    void test2() {
        System.out.println("test2 --");

    }

}
