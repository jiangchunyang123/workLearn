import com.learn.base.IOLearn;
import org.junit.Test;

public class TestMain {
    @Test
    public void test1(){
        System.out.println("path:"+IOLearn.class.getResource("/test.properties").getPath());
    //    IOLearn.FileIO(IOLearn.class.getResource("/test.properties").getPath());
     //   IOLearn.bufferIO(IOLearn.class.getResource("/test.properties").getPath());
        IOLearn.transformIO(IOLearn.class.getResource("/test.properties").getPath());
     //   IOLearn.printStream();
    }
}
