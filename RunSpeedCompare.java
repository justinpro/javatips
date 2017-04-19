import java.util.*;
import java.io.*;

class RunSpeedCompare{
    class BufferedInputFile{
        public String read(String filename) throws IOException{
            BufferedReader sr=new BufferedReader(new FileReader(filename));
            String a;
            StringBuilder sb=new StringBuilder();
            while ((a=sr.readLine())!=null){
                sb.append(a+"\n");
            }
            System.out.println(sb);
            return sb+"";
        }
    }
    public static void main(String[] args) throws IOException{
        String file1="test.txt";
        String file2="test2.txt";
        RunSpeedCompare t=new RunSpeedCompare();
        RunSpeedCompare.BufferedInputFile inner=t.new BufferedInputFile();
        BufferedReader br1=new BufferedReader(new StringReader(inner.read("test.java")));
        BufferedReader br2=new BufferedReader(new StringReader(inner.read("test.java")));

        PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter(file1)));
        int linecount=1;
        String s;
        long start=System.nanoTime();
        while ((s=br1.readLine())!=null){
            out.println(linecount++ +" "+s);
        }
        long duration=System.nanoTime()-start;
        out.close();
        System.out.println("Buffered write:  "+duration+" nanoseconds");

        PrintWriter out2=new PrintWriter(new FileWriter(file2));
        int linecount2=1;
        String s2;
        long start2=System.nanoTime();
        while((s2=br2.readLine())!=null){
            out2.println(linecount2++ +" "+s2);
        }
        long daration2=System.nanoTime()-start2;
        out2.close();
        System.out.println("unffered write:  "+daration2+" nanoseconds");
        /*
        System.out.println("file1 ===>");
        inner.read(file1);
        System.out.println("file2 ===>");
        inner.read(file2);
        */
    }
}