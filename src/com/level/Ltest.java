package com.level;

public class Ltest {
    public static void main(String[] args) {
        Ltest lt = new Ltest();
        try {
            lt.test2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void test1() throws LevelException {
        throw new LevelException("ass");
    }

    public void test2(){
        try {
            test1();
        } catch (LevelException e) {
            RuntimeException re = new RuntimeException("donkey");
            re.initCause(e);
            throw re;
        }
    }
}
