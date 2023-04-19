package com.hyukkim.study_jdbc;

import com.hyukkim.study_jdbc.cotrollers.MemoController;
import com.hyukkim.study_jdbc.daos.MemoDao;
import com.hyukkim.study_jdbc.entities.MemoEntity;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in); // 번호 입력받기

    public static void main(String[] args) throws Exception { //프로그램의 시작점
        while (true){ // 무한루프로 명령 입력
            // 명령 선택 메뉴
            System.out.println("=".repeat(50));
            System.out.println("명령을 선택해 주세요.");
            System.out.println("=".repeat(50));
            System.out.println("1. 메모");
            System.out.println("q. 종료");
            System.out.println("=".repeat(50));
            System.out.println("> ");
            String command = Main.scanner.nextLine(); // command 에 scanner받은줄을 넣는다
            // switch-case 문으로 명령을 처리
            switch (command){
                case "1":
                    Main.handleMemo();
                    break;
                case "q":
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.printf("'%s'은(는) 올ㄹ바르지 않은 명령입니다.\n", command);

            }

        }


        }

    private  static void handleMemo() throws Exception{ // 메모 관련 명령을 처리하는 메서드
        MemoController memoController = new MemoController(); // 객체 생성
        while(true){
            // 메모 관련 메뉴 출력
            System.out.println("=".repeat(32));
            System.out.println("메모");
            System.out.println("1. 작성하기");
            System.out.println("2. 조회하기");
            // 내일 까지 해오기
            System.out.println("3. 삭제하기");
            System.out.println("q. 돌아가기");
            System.out.println("> ");
            // 입력받은 명령을 command변수에 저장
            String command = Main.scanner.nextLine();
            // switch-case 문으로 명령을 처리
            switch (command){
                case "1":
                    // MemoController 객체의 write() 메서드 호출하여 메모 작성
                    if(memoController.write(Main.scanner)){
                        System.out.println("성공적으로 메모를 작성하였습니다.");
                    }else {
                        System.out.println("알 수 없는 이유로 메모를 작성하지 못하였습니다.");
                    }
                    break;
                case "2":
                    // MemoController객체의 query() 메서드를 호출하여 메모 조회
                    List<MemoEntity> memos = memoController.query(Main.scanner); //MemoController 의 query 메서드 호출, 입력받은 스캐너를 인자로 전달
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 날짜 포맷
                    System.out.println("=".repeat(32));
                    System.out.printf("No.\tDt.                \tText\n"); // 테이블 헤더 출력
                    System.out.println("=".repeat(32));
                    if(memos.size() == 0){
                        System.out.println("표시할 매모가 없습니다.");
                    } else {
                        for (MemoEntity memo : memos){
                            System.out.printf("%3d\t%s\t%s\n",
                                    memo.getIndex(),
                                    sdf.format(memo.getDate()),
                                    memo.getText());
                        }
                        System.out.println("=".repeat(32));
                        System.out.printf("메모 총 %, d개\n", memos.size());
                        System.out.println("=".repeat(32));
                    }
                    break;
                case "3":
                    if(memoController.delete(Main.scanner)){
                        System.out.println("메모를 성공적으로 삭제하였습니다.");
                    }else {
                        System.out.println("메모를 삭제하지 못하였습니다.");
                    }
                    break;

                case "q":
                    return;
                default:
                    System.out.printf("'%s'은(는) 올바르지 않은 명령입니다.\n", command);
                }
            }
        }
    }


