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
        return this.memoDao.insert(memo) > 0;
    }
}
