import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(64);
        while(true){
            if(getSumOfSticks(pq) == x){
                break;
            }
            int smallest = pq.remove();
            pq.add(smallest / 2);
            if(getSumOfSticks(pq) < x){
                pq.add(smallest / 2);
            }
        }
        System.out.println(pq.size());
    }
    public static int getSumOfSticks(PriorityQueue<Integer> pq){
        int sum = 0;
        for(int len : pq){
            sum += len;
        }
        return sum;
    }
}