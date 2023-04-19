package com.hyukkim.study_jdbc.services;

import com.hyukkim.study_jdbc.daos.MemoDao;
import com.hyukkim.study_jdbc.entities.MemoEntity;

import java.util.List;

public class MemoService {
    private final MemoDao memoDao = new MemoDao();

    // 메모 전체 개수 조회 메소드
    public int getCount() throws Exception{
        return this.memoDao.selectcount();
    }

    // 메모 삭제 메소드
    public boolean delete(int index) throws Exception{
        return this.memoDao.delete(index) > 0;
    }
    // 메모 조회 메소드
    public List<MemoEntity> query(int page) throws Exception{
        return this.memoDao.select(page);

    }
    // 메모 작성 메소드
    public boolean write(MemoEntity memo) throws Exception {
        if (memo.getText().length() == 0 || memo.getText().length() > 1000) {
            return false;

        }
        // memoDao의 insert() 메소드 호출 결과가 0보다 크면 메모 작성이 성공한 것이므로 true반환, 그렇지 않으면 false 반환
        return this.memoDao.insert(memo) > 0;
    }
}
//MemoService 클래스는 메모에 대한 CRUD(Create, Read, Update, Delete) 기능을 수행하기 위한 서비스 클래스이다.
//private final MemoDao memoDao = new MemoDao(); : 서비스 클래스 내에서는 DAO 객체를 생성해 사용하며, 이를 위해 MemoDao 클래스를 필드로 갖는다.
//public int getCount() throws Exception : 메모 전체 개수 조회를 위한 메소드이다. memoDao 객체의 selectCount() 메소드를 호출해 메모 전체 개수를 반환한다.
//public boolean delete(int index) throws Exception : 메모 삭제를 위한 메소드이다. memoDao 객체의 delete(index) 메소드를 호출해 해당 인덱스의 메모를 삭제한다. 삭제된 row 수가 0보다 크면 삭제가 성공한 것으로 간주하고 true를 반환하고, 그렇지 않으면 false를 반환한다.
//public List<MemoEntity> query(int page) throws Exception : 메모 조회를 위한 메소드이다. memoDao 객체의 select(page) 메소드를 호출해 해당 페이지에 있는 메모 리스트를 반환한다.
//public boolean write(MemoEntity memo) throws Exception : 메모 작성을 위한 메소드이다. 메모 텍스트의 길이가 0글자 이상 1000글자 이하인지 확인하고, 조건에 맞지 않으면 false를 반환한다. memoDao 객체의 insert(memo) 메소드를 호출해 메모를 작성하고, 작성된 row 수가 0보다 크면 작성이 성공한 것으로 간주하고 true를 반환하고, 그렇지 않으면
