package com.level;

import java.util.Scanner;

public class BookException {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        String[] books = {"C","C++","JAVA","C#","PHP","Python","Ruby"};

            System.out.println("输入命令：1-按照名称查找图书；2-按照序号查找图书");
            String book;
            try {
                book = getBookByNumber(books);
                System.out.println("book:" + book);

            } catch (Exception bne) {
                //捕获图书不存在异常时，要求重新输入命令
                System.out.println(bne.getMessage());
            }
    }



    private static String getBookByNumber(String[] books) throws Exception {
        while (true) {
            System.out.println("输入图书序号：");
            try {
                //获取输入的图书序号（数组下标）
                int index = inputCommand();
                System.out.println(index);
                //若返回值为-1
                if(index == -1){
                    System.out.println("命令输入错误！请根据提示输入数字命令！");
                    continue;
                }
                //若不出现”数组下标越界异常“，则返回相应位置的图书
                String book = books[index];
                return book;
            } catch (ArrayIndexOutOfBoundsException e) {
                //输入的序号不存在（引发“数组下标越界异常”），则抛出”图书不存在异常“
                Exception bookNotExists = new Exception("图书不存在！");
                bookNotExists.initCause(e);
                throw bookNotExists;
            }
        }
    }


    private static int inputCommand(){
        int command;
        try {
            command = scanner.nextInt();
            return command;
        }catch (Exception e){
//            scanner = new Scanner(System.in);
            return -1;
        }
    }
}
