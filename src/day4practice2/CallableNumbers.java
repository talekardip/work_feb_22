package day4practice2;

import java.util.concurrent.Callable;

public class CallableNumbers implements Callable {
    private int number;

    public CallableNumbers(int number) {
        this.number = number;
    }

    @Override
    public Object call() throws Exception {
        int tot = 0;
        for(int i=1;i<=number;i++){
            tot+=i;
        }
        return tot;
    }
}
