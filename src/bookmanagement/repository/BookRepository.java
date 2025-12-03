package bookmanagement.repository;

import bookmanagement.domain.BookVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookRepository {
    ArrayList<BookVO> bookVOList;

    public ArrayList<BookVO> select(String searchWord, int selectedIndex) {
        Connection con = JDBCConnector.getConnection();
        bookVOList = new ArrayList<BookVO>();
        ResultSet rs = null;
        PreparedStatement psmt = null;
        String[] columnName = {"name", "publish", "author"};
        String sql = "select isbn, name, publish, author, price, category_name from book, category where book.category = category.category_id and "+ columnName[selectedIndex] +" like ?";
        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1, "%"+searchWord+"%");
            rs = psmt.executeQuery();
            while (rs.next()) {
                BookVO bookVO = new BookVO();
                bookVO.setIsbn(rs.getInt("isbn"));
                bookVO.setName(rs.getString("name"));
                bookVO.setPublish(rs.getString("publish"));
                bookVO.setAuthor(rs.getString("author"));
                bookVO.setPrice(rs.getInt("price"));
                bookVO.setCategoryName(rs.getString("category_name"));
                bookVOList.add(bookVO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs != null)
                    rs.close();

                if (psmt != null)
                    psmt.close();

                if(con != null)
                    con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


        return bookVOList;
    }

    public void insert(BookVO vo) {
        Connection con = JDBCConnector.getConnection();
        String sql = "update book set name=?, publish=?, author=?, price=?, category=? where isbn=?";
        PreparedStatement psmt = null;

        try {
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, vo.getIsbn());
            psmt.setString(2, vo.getName());
            psmt.setString(3, vo.getPublish());
            psmt.setString(4, vo.getAuthor());
            psmt.setInt(5, vo.getPrice());
            int categoryId = 0;
            switch (vo.getCategoryName()) {
                case "IT도서":
                    categoryId = 10;
                    break;
                case "소설":
                    categoryId = 20;
                    break;
                case "비소설":
                    categoryId = 30;
                    break;
                case "경제":
                    categoryId = 40;
                    break;
                case "사회":
                    categoryId = 50;
                    break;
            }
            psmt.setInt(6, categoryId);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {

                if (psmt != null)
                    psmt.close();

                if (con != null)
                    con.close();

            } catch (SQLException e) {
                System.out.println("insert close 문제 발생");
                e.printStackTrace();
            }
        }
    }


    public void update(BookVO vo) {
        Connection con = JDBCConnector.getConnection();
        String sql = "update book set name=?, publish=?, author=?, price=?, category=? where isbn=?";
        PreparedStatement psmt = null;
        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1, vo.getName());
            psmt.setString(2, vo.getPublish());
            psmt.setString(3, vo.getAuthor());
            psmt.setInt(4, vo.getPrice());
            int categoryId = 0;
            switch (vo.getCategoryName()) {
                case "IT도서":
                    categoryId = 10;
                    break;
                case "소설":
                    categoryId = 20;
                    break;
                case "비소설":
                    categoryId = 30;
                    break;
                case "경제":
                    categoryId = 40;
                    break;
                case "사회":
                    categoryId = 50;
                    break;
            }
            psmt.setInt(5, categoryId);
            psmt.setInt(6, vo.getIsbn());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {

                if (psmt != null)
                    psmt.close();

                if (con != null)
                    con.close();

            } catch (SQLException e) {
                System.out.println("update close 문제 발생");
                e.printStackTrace();
            }
        }
    }

    public void delete(BookVO vo) {
        // 1. 데이터베이스 연결(Connection)을 가져옵니다.
        Connection con = JDBCConnector.getConnection();

        // 2. 삭제(DELETE) SQL 문을 정의합니다. (ISBN을 조건으로 사용)
        String sql = "delete from book where isbn=?";

        // 3. PreparedStatement 객체를 초기화합니다.
        PreparedStatement psmt = null;

        try {
            // 4. SQL 문으로 PreparedStatement를 준비합니다.
            psmt = con.prepareStatement(sql);

            // 5. SQL 문의 첫 번째 물음표(?)에 BookVO 객체에서 가져온 isbn 값을 설정합니다.
            // parameterIndex는 1부터 시작합니다.
            psmt.setInt(1, vo.getIsbn());

            // 6. SQL 문을 실행하여 데이터베이스에서 데이터를 업데이트(삭제)합니다.
            psmt.executeUpdate();

        } catch (SQLException e) {
            // 7. SQL 관련 예외 발생 시 스택 트레이스를 출력합니다.
            e.printStackTrace();

        } finally {
            // 8. 데이터베이스 자원(PreparedStatement, Connection)을 안전하게 닫습니다.
            try {
                if (psmt != null)
                    psmt.close();

                if (con != null)
                    con.close();

            } catch (SQLException e) {
                // 9. 자원 닫기(close) 작업 중 예외 발생 시 메시지를 출력하고 스택 트레이스를 출력합니다.
                System.out.println("delete close 문제 발생");
                e.printStackTrace();
            }
        }
    }

}



