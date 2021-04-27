import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
public class AllWay {
    Scanner scanner = new Scanner(System.in);
    private Connection conn = null;
    public void connect() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/jdbook?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
        String user = "root";
        String pwd = "123456";
        try {
            Class.forName(driver);
            this.conn = DriverManager.getConnection(url,user,pwd);
            System.out.println("数据库连接成功");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void select(ArrayList<Books> arrayList){       //搜索数据
        this.connect();     //最后记得this.conn.close()，参考下面的look()方法
        //下方用foreach显示所有数据

        //下方用sql语句查询显示搜索的数据
        int n1;
        System.out.print("输入要搜索的序号：");
        n1 = scanner.nextInt();      //n1用途：sql语句中where id = n1
    }
    public Boolean delete(ArrayList<Books> arrayList){       //删除数据
        this.connect();     //最后记得this.conn.close()，参考下面的look()方法
        //下方用foreach显示所有数据

        //
        int n2;
        System.out.print("输入你要删除的书籍的序号：");
        n2 = scanner.nextInt();     //n2用途：sql语句中where id = n2
        //下方用sql语句删除，删除成功返回true，删除失败返回false

        return true;
    }
    public ArrayList<Books> look() {        //查询全体数据
        Statement stmt;
        ArrayList<Books> bookList=new ArrayList<Books>();
        this.connect();
        try {
            stmt = this.conn.createStatement();
            String sql = "select * from JDBook";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Books bk=new Books();
                bk.setId(rs.getInt("id"));
                bk.setName(rs.getString("name"));
                bk.setPrice(rs.getDouble("price"));
                bk.setAddress(rs.getString("public"));
                bookList.add(bk);
            }
            System.out.println("浏览成功");
            this.conn.close();
            return bookList;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("浏览报错");
            try {
                this.conn.close();
            } catch (SQLException e1) {
                try {
                    this.conn.close();
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }
                e1.printStackTrace();
            }
            return bookList;
        }
    }
}
