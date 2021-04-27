import java.util.ArrayList;
import java.util.Scanner;
public class MainClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String p;       //判断是否继续循环
        do{
            System.out.println("欢迎使用数据库系统\n1.查看全部数据\n2.搜索数据\n3.删除数据\n");
            System.out.print("请选择功能：");
            String s = scanner.next();
            switch (s) {
                case "1":
                    AllWay allWay1 = new AllWay();
                    ArrayList<Books> arrayList1 = allWay1.look();
                    for (Books book : arrayList1) {
                        System.out.println("序号：" + book.getId() + "\n书名：" + book.getName() + "\n价格：" + book.getPrice() + "\n出版社：" + book.getAddress());
                    }
                    break;
                case "2":
                    AllWay allWay2 = new AllWay();
                    ArrayList<Books> arrayList2 = allWay2.look();
                    allWay2.select(arrayList2);
                    break;
                case "3":
                    AllWay allWay3 = new AllWay();
                    ArrayList<Books> arrayList3 = allWay3.look();
                    allWay3.delete(arrayList3);
                    break;
                default:
                    break;
            }
            System.out.print("是否继续（y/n）：");
            p = scanner.next();
        }while(p.toLowerCase().equals("y"));
    }
}
