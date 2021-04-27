package ruanjian;


import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        int[] number= Bookdata[];
        boolean tf=false; Scanner input=new Scanner(System.in);
        for(int a=0;a<number.length;a++){ System.out.print(number[a]+" "); }
        System.out.println("请输入您要删除的书：");
        int gg=input.nextInt();
        for(int a=0;a<number.length;a++){
            if(number[a]==gg){ number[a]=0; tf=true; } }
        if(tf){ System.out.println("找到了您输入的元素！");
        System.out.println("删除后的结果是：");
        for(int a=0;a<number.length;a++){ if(number[a]==0){ continue; }
        System.out.println(number[a]); } }
        else{ System.out.println("没有找到您输入的书本！"); } }
   // #System.out.println("书名：" + books[n].getBookName() + "\n作者：" + books[n].getWriter());
   // #System.out.println("删除成功");
}
