/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;
import java.util.Scanner;
import java.lang.Math;

class HashNode{
    int key;
    int value;
    
    HashNode(int k, int v){
        this.key = k;
        this.value = v;
    }
};

class Table{
    int tableSize = 10;
    HashNode[] t;
    
    Table(){
        t = new HashNode[tableSize];
        for(int i=0; i<tableSize; i++){
            t[i] = null;
        }
    }
    
    int hashFunction(int key){
        return key % tableSize;
    }
    
    void insert(int key,int value){
        int hash = hashFunction(key);
        while(t[hash] != null && t[hash].key != -1){
            hash = hashFunction(hash + 1);
        }
        t[hash] = new HashNode(key,value);
    }
    
    void search(int key){
        int hash = hashFunction(key);
        while(t[hash] != null && t[hash].key != key){
            hash++;
        }
        if(t[hash] == null){
            System.out.println("element not found");
        }else{
            System.out.println("found:"+hash);
        }
    }
    
    void delete(int key){
        int hash = hashFunction(key);
        while(t[hash] != null && t[hash].key != key){
            hash++;
        }if(t[hash] == null){
            System.out.println("element not found");
        }else{
            t[hash].key = -1;
        }
    }
    
    void display(){
        for(int i=0; i<tableSize; i++){
            if(t[i] == null || t[i].key == -1){
                System.out.println(i+" empty");
            }else
               System.out.println(t[i].value);
        }
    }
};


public class JavaApplication5 {
   
    public static void main(String[] args) {
        /*Table t = new Table();
        t.insert(12, 60);
        t.insert(10, 50);
        t.delete(10);
        t.insert(10, 50);
        t.search(11);
        t.display();*/
        
        //Scanner s = new Scanner(System.in);
        String st = "123";
        int p = Integer.parseInt(st);
        
        int j = 123;
        String a = Integer.toBinaryString(j);
        int bint = Integer.parseInt(a);
        
        int q = 2,w =3;
        double power = Math.pow(q, w);
        //System.out.println(power);
        
        String y = "Yasas";
        int ascii = 0;
        char temp;
        
        for(int i=0; i<y.length(); i++){
            temp = y.charAt(i);
            ascii = ascii + (int)temp;
        }
        
        System.out.println(ascii);
        
    }
    
    
    
    
}
