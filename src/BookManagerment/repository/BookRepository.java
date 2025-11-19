package BookManagerment.repository;
import BookManagerment.domain.BookVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookRepository {
    ArrayList<BookVO> bookVOList;


    ArrayList<BookVO> books = new ArrayList<BookVO>();

    public ArrayList<BookVO> select(String searchWord, int selectedIndex){
        Connection con = JDBCConnector.getConnection();
        bookVOList = new ArrayList<>();
        ResultSet rs = null;
        PreparedStatement psmt = null;
        String[] coumnName = {"name", "publish", "author"};
        String sql = "select isbn, name, publish, author, price, category_name from book, category where book.category = category.category_id and "+
                coumnName[selectedIndex] + " like ?";

        try {
            psmt = con.prepareStatement(sql);
            psmt.setString(1, "%" + searchWord + "%");
            rs = psmt.executeQuery();
            while (rs.next()) {
                BookVO bookVO = new BookVO();
                bookVO.setIsbn(rs.getInt("isbn"));
                bookVO.setName(rs.getString("name"));
                bookVO.setPublish(rs.getString("publish"));
                bookVO.setAuthor(rs.getString("author"));
                bookVO.setPrice(rs.getInt("price"));
                bookVO.setCategoryName(rs.getString("category_name"));
                books.add(bookVO);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }finally {
                try {
                    if (rs != null)
                    rs.close();

                    if (psmt != null)
                        psmt.close();

                    if (con != null)
                        con.close();

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        return books;
    }
}
