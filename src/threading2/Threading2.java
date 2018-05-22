/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threading2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
/**
 *
 * @author reem
 */
public class Threading2 implements Runnable{

private List numList;
public Threading2(List numListt) {
    numList = numListt;}

public void run() {
synchronized(this){ // does not allow more than one thread to access the code (I looked it up in stackoverflow)
Random rand = new Random();  
int value = rand.nextInt(400);
numList.add(value);
System.out.println(Thread.currentThread().getName() + " added " + value);
		
		}
		}

public static void main(String[] args) {
List numList = new ArrayList(); 
Collections.synchronizedList(numList);//  block the list while processing the method (I looked it up in stackoverflow)
		
Thread t1 = new Thread((Runnable) new Threading2(numList));
Thread t2 = new Thread((Runnable) new Threading2(numList));
Thread t3 = new Thread((Runnable) new Threading2(numList));
Thread t4 = new Thread((Runnable) new Threading2(numList));
t1.start();
t2.start();
t3.start();
t4.start();
while (Thread.activeCount() > 1) { //  stop main thread utill all thread execution is completed							 
		}
System.out.println("Size of list is " + numList.size());
for (Object i : numList) {
System.out.println("number: " + i);
		}
	}
}

    

