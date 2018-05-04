package com.rw.finance.common.constants;

/**
 * @Author huanghongfei
 * @Description description
 * @Date Create in 17:48 2018/4/23
 */
public class Constants {

    public enum YN{
        Y(1),
        N(0);
        private int b;
        YN(int b){
            this.b=b;
        }
        public int getValue(){
            return b;
        }
    }
}
