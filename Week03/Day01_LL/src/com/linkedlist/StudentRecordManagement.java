package com.linkedlist;

public class StudentRecordManagement {
    public static void main(String[] args) {

        StudentData studentList=new StudentData();
        studentList.addAtBeginning(2,"shiv",35,'A');
        studentList.addAtBeginning(3,"shivam",36,'B');
        studentList.addAtPosition(2,45,"ram",34,'C');

        studentList.displayAll();
        System.out.println("Add new member !");

        studentList.addAtLast(5,"shyam",87,'A');

        studentList.displayAll();

        System.out.println("delete student member !");
        studentList.deleteByRollNumber(45);

        studentList.displayAll();

    }
}

//Student Node
class  StudentNode{

    int rollNumber;
    String name;
    int age;
    char grade;
    StudentNode next;

    StudentNode(int rollNumber,String name,int age,char grade){

        this.rollNumber=rollNumber;
        this.name=name;
        this.age=age;
        this.grade=grade;
        next=null;
    }

}

class StudentData{

    private static StudentNode head;

    StudentData(){
        head=null;
    }

    //add AtBeginning function
    public void addAtBeginning(int rollNumber,String name,int age,char grade){

        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        newNode.next=head;
        head=newNode;
    }

    //Add atLast of the List
    public void addAtLast(int rollNumber,String name,int age,char grade){
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);

        if(head==null){
            head=newNode;
            return;
        }

        StudentNode temp =head;

        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }

    //Add at Position
    public void addAtPosition(int position,int rollNumber,String name,int age,char grade){
      if(position<0){
          System.out.println("invalid position !");
          return;
      }
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);

        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        StudentNode temp = head;

        for(int i=0;i<position-1&& temp!=null;i++){
            temp=temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newNode.next=temp.next;
      temp.next=newNode;

    }


    //Delete by rollNumber

    public StudentNode deleteByRollNumber(int rollNumber){

        if(head==null){
            System.out.println("LinkedList is empty");
        }

        if(head.rollNumber==rollNumber){
            StudentNode temp;
            temp=head;
            head=head.next;
            return temp;
        }
        StudentNode temp=head;

        while(temp.next!=null && temp.next.rollNumber!=rollNumber){
            temp=temp.next;
        }
        if(temp.next==null){
            System.out.println("Student of"+rollNumber+" not found");
            return null;
        }else{
            StudentNode node=temp.next;
            temp.next=temp.next.next;
            return node;
        }

    }

    //Search Student by rollNumber
    public StudentNode searchByRollNumber(int rollNumber){
        if(head==null){
            System.out.println("LinkedList is empty");
        }

        if(head.rollNumber==rollNumber){
            return head;
        }
        StudentNode temp=head;

        while(temp.next!=null && temp.next.rollNumber!=rollNumber){
            temp=temp.next;
        }
        if(temp.next==null){
            System.out.println("Student of"+rollNumber+" not found");
            return null;
        }else{
            return temp.next;
        }
    }

    //Update Student Grade By rollNumber
    public void updateGrade(int rollNumber,char grade){
        if(head==null){
            System.out.println("Empty LinkedList !");
            return;
        }
        if(head.rollNumber==rollNumber){
            head.grade=grade;
        }
        StudentNode temp=head;
        while(temp.next!=null && temp.rollNumber==rollNumber){
            temp=temp.next;
        }

        if(temp.next==null){
            System.out.println("Rollnumber are not present !");
            return;
        }else{
            temp.next.grade=grade;
        }


    }

    //Display function
    public void displayAll() {
        if (head == null) {
            System.out.println("\nNo student records found.");
            return;
        }

        StudentNode temp = head;
        while (temp != null) {
            System.out.println("\nRoll Number: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

}

