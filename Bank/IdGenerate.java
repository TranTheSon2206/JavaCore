package Bank;

import java.util.concurrent.locks.ReentrantLock;

public class IdGenerate {
    private static Long id = 0L;
    private static ReentrantLock lock = new ReentrantLock();

    public static Long getNewID(){
        Long result;
        lock.lock(); //Lock the id parameter , only one thread can be access (avoid Data Racing)
        try {
            result = ++id; //Increase and assign to result
        } finally {
            lock.unlock(); //Release thread after increase id
        }
        return result;
    }
    private IdGenerate(){}
}
