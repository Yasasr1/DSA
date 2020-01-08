/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;
import java.util.*;

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
    LinkedList<HashNode>[] t;
 
    Table(){
        t = new LinkedList[tableSize];
        for(int i=0; i<tableSize; i++){
            if (t[i] == null) {
                t[i] = new LinkedList<HashNode>();
            }
        }
    }
    
    int hashFunction(int key){
        return key % tableSize;
    }
    
    void insert(int key, int value){
       int hash = hashFunction(key);
       HashNode node = new HashNode(key,value);
       t[hash].add(node);
    }
    
    void search(int key){
        int hash = hashFunction(key);
        for(int i=0; i<t[hash].size(); i++){
            HashNode temp = t[hash].get(i);
            if(temp.key == key){
                System.out.println("found ");
            }
            else if(i == t[hash].size()-1 && temp.key != key){
                System.out.println("not found ");
            }
        }
    }
    
    void delete(int key){
        int hash = hashFunction(key);
        for(int i=0; i<t[hash].size(); i++){
            HashNode temp = t[hash].get(i);
            if(temp.key == key){
                t[hash].remove(i);
            }
            else if(i == t[hash].size()-1 && temp.key != key){
                System.out.println("not found ");
            }
        }
    }
    
    void display(){
        for(int i=0; i<tableSize; i++){
            System.out.print(i+"-> ");
            if(t[i] == null){
                System.out.println(i+" empty");
            }else{
                 for(int j=0; j<t[i].size(); j++){
                     HashNode temp = t[i].get(j);
                     System.out.print(" "+temp.value);
                 }
            }
            System.out.print("\n");
        }
    }
};

public class chaning {
    public static void main(String args[]){
        Table t = new Table();
        t.insert(10, 60);
        t.insert(12, 70);
        t.delete(12);
        t.display();
    }
}
