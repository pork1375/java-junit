package com.example.springjunit;

public class Study {

    private StudyStatus status; //StudyStatus.DRAFT; // 초기값을 만들어준다.

    private int limit;

    public Study(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("limit 0보다 커야 한다.");
        }
        this.limit = limit;
    }


    public StudyStatus getStatus() {
        return this.status;
    }

    public int getLimit() {
        return limit;
    }
}
