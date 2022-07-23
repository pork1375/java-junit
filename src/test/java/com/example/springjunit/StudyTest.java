package com.example.springjunit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)   // _ 를 공백으로 치환한다.
class StudyTest {

    @Test
    @DisplayName("이름을 만든다.")
    void create() {
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create");
    }

    @Test
    // @Disabled   // 실행하고싶지 않을때
    void create_new_study_again() {
        System.out.println("create1");
    }

    // 모든 테스트 시작 "전" 한번만 실행한다. static 사용하고 return 없다.
    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }


    @AfterAll
    // 모든 테스트 시작 "후" 한번만 실행한다. static 사용하고 return 없다.
    static void afterAll() {
        System.out.println("after all");
    }

    // 각각 테스트를 실행하기 "이전"에 실행된다.
    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach");
    }


    // 각각 테스트를 실행하기 "이후"에 실행된다.
    @AfterEach
    void afterEach() {
        System.out.println("afterEach");
    }


}