package com.example.springjunit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class repeatTest {

    @Test
    @DisplayName("반복")
   void test1() {

    }

    @DisplayName("반복만들기")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}, {totalRepetitions}")   // 반복횟수
    void repeatTest(RepetitionInfo repetitionInfo) {
        System.out.println("반복횟수 / 총횟수 ==> " + repetitionInfo.getCurrentRepetition() + " / "
                + repetitionInfo.getTotalRepetitions());
    }

    @DisplayName("파라미터 만들기1")
    @ParameterizedTest(name = "{index}, {displayName} message={0}")
    @ValueSource(strings = {"aaa", "bbb" , "ccc"})
    void params1(String message) {
        System.out.println(message);
    }

    @DisplayName("파라미터 만들기2")
    @ParameterizedTest(name = "{index}, {displayName} message={0}")
    @ValueSource(ints = {10, 20, 40})
    void params2(@ConvertWith(StudyConverter.class) Study study) {
        System.out.println(study.getLimit());
    }

    static class StudyConverter extends SimpleArgumentConverter {

        @Override
        protected Object convert(Object o, Class<?> aClass) throws ArgumentConversionException {
            assertEquals(Study.class, aClass, "변환한다.");
            Study study = new Study(Integer.parseInt(o.toString()));
            return study;

        }
    }

}
