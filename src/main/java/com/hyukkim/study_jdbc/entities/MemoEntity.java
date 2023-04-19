package com.hyukkim.study_jdbc.entities;

import java.util.Date;
import java.util.Objects;

public class MemoEntity {
    private int index;
    private Date date;
    private String test;

    public int getIndex() {
        return index;
    }

    public MemoEntity setIndex(int index) {
        this.index = index; // 인스턴스 변수 index에 매개변수 index 값을 할당
        return this;        // MemoEntity 인스턴스 자신을 반환
    }

    public Date getDate() {
        return date;
    }

    public MemoEntity setDate(Date date) {
        this.date = date;
        return this;
    }

    public String getText() {
        return test;
    }

    public MemoEntity setText(String text) {
        this.test = text;
        return this;
    }

    // 객체의 index 값을 비교하여 같으면 true, 다르면 false를 반환하는 equals 메서드
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // 객체 자신과 인자로 받은 객체 o가 같은 객체라면 true 반환
        if (o == null || getClass() != o.getClass()) return false; // o가 null이거나 클래스가 다르면 fasle 반환
        MemoEntity that = (MemoEntity) o; // 형변환
        return index == that.index; // 객체의 index 값이 같으면 true 반환, 다르면 false 반환
    }

    // 객체의 index 값을 기반으로 hash 값을 반환하는 hashcode 메서드
    @Override
    public int hashCode() {
        return Objects.hash(index); // index 값을 기반으로 hash 값을 반환
    }
}
