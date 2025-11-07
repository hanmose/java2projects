package mvc_jdbc_test.controller;

import jdbc_test.JDBCConnector;
import mvc_jdbc_test.entity.Customer;
import mvc_jdbc_test.view.InputCustomerInfoView;

import java.sql.*;
import java.util.Scanner;

public class MainController {

    public static void main(String[] args) {
        Connection con = JDBCConnector.getConnection();
        runMenu(con);
        try { if (con != null && !con.isClosed()) con.close(); } catch (SQLException ignored) {}
        System.out.println("프로그램이 종료되었습니다.");
    }

    private static void runMenu(Connection con) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== 고객 관리 메뉴 =====");
            System.out.println("1. 고객 추가");
            System.out.println("2. 고객 수정");
            System.out.println("3. 고객 삭제");
            System.out.println("4. 종료");
            System.out.print("선택: ");
            String sel = sc.nextLine().trim();
            switch (sel) {
                case "1" -> inputCustomerAndInsert(con);
                case "2" -> updateCustomer(con);
                case "3" -> deleteCustomer(con);
                case "4" -> { return; }
                default -> System.out.println("잘못 입력했습니다.");
            }
        }
    }

    public static void inputCustomerAndInsert(Connection con) {
        InputCustomerInfoView inputView = new InputCustomerInfoView();
        Customer customer = inputView.inputCustomerInfo();
        String sql = "insert into 고객 values(?,?,?,?,?,?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, customer.getCustomerid());
            pstmt.setString(2, customer.getCustomername());
            pstmt.setInt(3, customer.getAge());
            pstmt.setString(4, customer.getLevel());
            pstmt.setString(5, customer.getJob());
            pstmt.setInt(6, customer.getReward());
            int cnt = pstmt.executeUpdate();
            System.out.println(cnt == 1 ? "✅ 고객 추가 완료" : "❌ 고객 추가 실패");
        } catch (SQLException e) {
            System.out.println("Statement or SQL Error: " + e.getMessage());
        }
    }

    public static void updateCustomer(Connection con) {
        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 고객아이디 입력: ");
        String targetId = sc.nextLine().trim();
        if (!existsCustomer(con, targetId)) {
            System.out.println("❌ 해당 고객아이디가 없습니다.");
            return;
        }
        InputCustomerInfoView inputView = new InputCustomerInfoView();
        Customer newInfo = inputView.inputCustomerInfoWithoutId();
        String sql = """
                update 고객
                   set 고객이름 = ?,
                       나이     = ?,
                       등급     = ?,
                       직업     = ?,
                       적립금   = ?
                 where 고객아이디 = ?
                """;
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, newInfo.getCustomername());
            pstmt.setInt(2, newInfo.getAge());
            pstmt.setString(3, newInfo.getLevel());
            pstmt.setString(4, newInfo.getJob());
            pstmt.setInt(5, newInfo.getReward());
            pstmt.setString(6, targetId);
            int cnt = pstmt.executeUpdate();
            System.out.println(cnt == 1 ? "✅ 고객 수정 완료" : "❌ 고객 수정 실패");
        } catch (SQLException e) {
            System.out.println("Statement or SQL Error: " + e.getMessage());
        }
    }

    public static void deleteCustomer(Connection con) {
        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 고객아이디 입력: ");
        String targetId = sc.nextLine().trim();
        String sql = "delete from 고객 where 고객아이디 = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, targetId);
            int cnt = pstmt.executeUpdate();
            System.out.println(cnt == 1 ? "✅ 고객 삭제 완료" : "❌ 고객아이디가 없어서 삭제되지 않았습니다.");
        } catch (SQLException e) {
            System.out.println("Statement or SQL Error: " + e.getMessage());
        }
    }

    private static boolean existsCustomer(Connection con, String id) {
        String sql = "select 1 from 고객 where 고객아이디 = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            return false;
        }
    }
}
