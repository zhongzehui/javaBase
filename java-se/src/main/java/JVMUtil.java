import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class JVMUtil {

    public static void main(String[] args) {
        Thread thread01 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(new Date().toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread-zzh-01");
        Date date = new Date();
        System.out.println(ObjectSizeCalculator.getObjectSize(date));
        String zzh = new String("123456"); //56 64
        System.out.println(ObjectSizeCalculator.getObjectSize(zzh));
        //thread01.start();
    }
}
