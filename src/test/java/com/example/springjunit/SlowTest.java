package com.example.springjunit;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)   // 어디에 쓸 수 있는가 ==> 메서드
@Retention(RetentionPolicy.RUNTIME) // 이 어노테이션을 사용한 코드가 런타임까지 사용한다.
@Test
@Tag("slow")    // fast라는 태그를 사용해서 meta data 로 사용한다.
public @interface SlowTest {
}
