package com.learn.base;

import java.io.*;

/**
 * 本类只针对我目前的状态来详细的复习一遍io流，所以只列出几个重要的类和方法来使用，具体细节不再深究
 * 总结两个发现：
 * 1 jdk1.7版本以上如果把流的定义卸载try的括号中，则jvm会自己在调用结束后关闭流
 * 2 read(char[])/read(byte[]) 方法，是返回读取到的字符/字节的实际长度，在写输出时，write要指定缓存数组的offset和length
 */
public class IOLearn {
    /**
     * 文件流，又叫节点流,流在1.7版本以后再try的（）中打开流，jvm会在使用完毕后自动关闭
     */
    public static void FileIO(String filePath) {

        try (
                FileInputStream fileInputStream = new FileInputStream(new File(filePath));
                FileOutputStream fileOutputStream = new FileOutputStream("D:/testLearn/test.pro");
        ) {

            byte[] b = new byte[10];
            int a = 0;
            while ((a = fileInputStream.read(b)) != -1) {
                try {
                    fileOutputStream.write(b);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (
                FileReader fileReader = new FileReader(new File(filePath));
                FileWriter fileWriter = new FileWriter(new File("D:/testLearn/charactor.pro"));

        ) {
            char[] chars = new char[10];
            int c = 0;
            while ((c = fileReader.read(chars)) != -1) {
                fileWriter.write(chars);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log4jTestLogger.infoLog("FileIo end .....");
    }

    /**
     * 字符串流:StringBufferInputStream 已经被deprested了，不再使用
     */
    public static void StringIO() {
        // StringBufferInputStream
        StringReader stringReader = new StringReader("abc");
        // 具体过程同上，不再赘述
    }

    /**
     * 包装流 方便的输出各种类型的值
     */
    public static PrintStream printStream() {

        PrintStream printStream = new PrintStream(System.out);
        printStream.print("String:" + "abcde");
        printStream.print(123L);
        printStream.print("kkouyt");
        return printStream;
    }

    /**
     * 缓冲流
     */
    public static void bufferIO(String path) {
        try (
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D:/testLearn/buffer.pro"))
        ) {
            byte[] b = new byte[20];
            int c = 0;
           while( (c= bufferedInputStream.read())!=-1){
                bufferedOutputStream.write(c);
           }
        } catch (Exception e) {
                e.printStackTrace();
        }
        //reader writer与上述极为类似，bufferedReader多了一个readLine方法
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:/testLearn/buffer.pro"));

        ) {
            byte[] b = new byte[20];
            String c ;
            while( (c= bufferedReader.readLine())!=null){
                printStream().println(c);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 转换流
     */
    public static void transformIO(String filePath) {
        try(
                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
                OutputStreamWriter outPutStreamReader = new OutputStreamWriter(new FileOutputStream("D:/testLearn/trans.pro"));

        ){
            char[] chars = new char[10];
            int actLth = inputStreamReader.read(chars);
            while(actLth!=-1){
                outPutStreamReader.write(chars,0,actLth);
                actLth = inputStreamReader.read(chars);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
