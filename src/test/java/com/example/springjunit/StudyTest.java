package com.example.springjunit;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)   // _ 를 공백으로 치환한다.
class StudyTest {

    @Test
    @DisplayName("이름을 만든다.")
    void create() {
//        Study study = new Study(-10);
//        assertNotNull(study);
        // assertEquals(순서는 상관없지만 아래처럼 API의도와 같이 만들자.)
        // assertEquals(기대하는값, 실제 나오는값, 실패했을때 메세지 출력)
//        assertEquals(StudyStatus.DRAFT, study.getStatus(), "스터디를 처음 만들면 상태값이 DRAFT여야 한다.");
        // 메세지를 람다식을 사용하면 실패를 했을때만 메세지 문자열 연산을 한다. 성능을 신경쓰는 입장이면 유리하다.
//        assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT +" 상태다");
//        assertEquals(StudyStatus.DRAFT, study.getStatus(), new Supplier<String>() {
//            @Override
//            public String get() {
//                return "스터디를 처음 만들면 상태값이 DRAFT여야 한다.";
//            }
//        });

//        assertTrue(1 < 2);
//        assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 한다.");
        System.out.println("--------");
        // 전체 한번에 실행
//        assertAll(
//                () -> assertNotNull(study),
//                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT +" 상태다"),
//                () -> assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 한다.")
//        );

        System.out.println("--------");
        // 에러가 발생하는데 () -> 어떤걸 실행했을때 발생하느냐
//        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        // 에러가 났을때 메세지가 내가 기대했던 메세지가 맞는지 확인
//        assertEquals("limit 0보다 커야 한다.", exception.getMessage());

        System.out.println("--------");
        // 해당 시간안에 실행이 되는지 체크
        assertTimeout(Duration.ofSeconds(10), () -> new Study(10));
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