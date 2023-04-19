package com.hyukkim.study_jdbc.utils;

import org.mariadb.jdbc.internal.com.read.dao.CmdInformationBatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    //데이터베이스 연결을 위한 드라이버, 프로토콜, 호스트, 포트, 사용자 이름, 비밀번호를 저장하는 private static final 변수입니다.
    private static final String DRIVER = "org.mariadb.jdbc.Driver";
    private static final String PROTOCOL = "jdbc:mariadb";
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String USERNAME = "study";
    private static final String PASSWORD = "test1234";

    // getConnection() 메서드는 ClassNotFoundException, SQLException 예외를 던지며, 데이터베이스에 연결된 Connection 객체를 반환합니다.
    public static Connection getConnection() throws
            ClassNotFoundException,
            SQLException {
        Class.forName(DatabaseUtil.DRIVER);
        return DriverManager.getConnection(
                String.format("%s://%s:%s",
                        DatabaseUtil.PROTOCOL,
                        DatabaseUtil.HOST,
                        DatabaseUtil.PORT),
                DatabaseUtil.USERNAME,
                DatabaseUtil.PASSWORD
        );

    }
    // DatabaseUtil 생성자는 상위 클래스의 생성자를 호출합니다.
    private DatabaseUtil() {
        super();
    }
}
