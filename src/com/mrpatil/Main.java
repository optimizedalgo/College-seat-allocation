package com.mrpatil;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

    class Student {
        private String city;
        private String fname;
        private double cet_marks;

        public Student(String city, String fname, double cet_marks) {
            this.city = city;
            this.fname = fname;
            this.cet_marks = cet_marks;
        }

        public String getCity() {
            return city;
        }

        public String getFname() {
            return fname;
        }

        public double getCet_marks() {
            return cet_marks;
        }

    }

    class Main {
        public static void Main(String args[]) {

            PriorityQueue<Student> pQ= new PriorityQueue<Student>(

                    new Comparator<Student>() {

                        public int compare(Student student1, Student student2) {
                            // step 1: if cgpa are not

                            if (student1.getCet_marks() != student2.getCet_marks()) { // cannot   use   o1.equals(o2)   because   it   compares   only  int
                                if (student1.getCet_marks() > student2.getCet_marks())
                                    return -1;
                                else
                                    return 1;        // (int) casting as ans may in double; -ve to decending order
                            } else {// step 2 : if CGPA are same sort according to Fname
                                if ((student1.getFname().compareTo(student2.getFname())) != 0) { // step 3: if first name also equal, sort according to Token();
                                    return student1.getFname().compareTo(student2.getFname());
                                } else {
                                    if ((student1.getCity().compareTo(student2.getCity())) != 0)
                                        return student1.getCity().compareTo(student2.getCity());
                                    else return -2;
                                }
                                // step 2:L cont.. if Fname are not same, sort accordingly and return
                            }
                        }
                    }
            );
            PriorityQueue<Student> pN= new PriorityQueue<Student>(

                    new Comparator<Student>() {

                        public int compare(Student student1, Student student2) {
                            // step 1: if cgpa are not

                            if (student1.getCet_marks() != student2.getCet_marks()) { // cannot   use   o1.equals(o2)   because   it   compares   only  int
                                if (student1.getCet_marks() > student2.getCet_marks())
                                    return -1;
                                else
                                    return 1;        // (int) casting as ans may in double; -ve to decending order
                            } else {// step 2 : if CGPA are same sort according to Fname
                                if ((student1.getFname().compareTo(student2.getFname())) != 0) { // step 3: if first name also equal, sort according to Token();
                                    return student1.getFname().compareTo(student2.getFname());
                                } else {
                                    if ((student1.getCity().compareTo(student2.getCity())) != 0)
                                        return student1.getCity().compareTo(student2.getCity());
                                    else return -2;
                                }
                                // step 2:L cont.. if Fname are not same, sort accordingly and return
                            }
                        }
                    }
            );
            System.out.println("************************************************************\n");
            System.out.println("\n\n\t\t***\t SPPU-(PICT) College Allotment System\t**\n\n");
            int choice = 0, counter = 0,vacancies=0;
            do {
                System.out.println("************************************************************\n");
                System.out.print("Menu\n1. Enter Vacant Seats In PICT \n2. Enter Student Details \n3. Display List \n4. College Allocated \n5. Vacancies In PICT\n6.Exit\nEnter Your Choice : ");
                Scanner in = new Scanner(System.in);
                choice = in.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("************************************************************\n");
                        System.out.print("\tEnter Number Of Vacancies In PICT : ");
                        Scanner in1 = new Scanner(System.in);
                        vacancies = in1.nextInt();
                        break;
                    case 2:
                        System.out.println("************************************************************\n");
                        System.out.print("\n\tEnter Name : ");
                            String name = in.next();
                            System.out.print("\n\tEnter CET Marks : ");
                            int cet_marks = in.nextInt();
                            System.out.print("\n\tEnter City Name : ");
                            String city = in.next();

                            Student student = new Student(city, name, cet_marks);

                            pQ.add(student);                //add() throws exception but offer() doesnot. bot methods adds object to queue
                            counter++;
                        break;

                    case 3:
                        System.out.println("************************************************************\n");
                        System.out.println("sr.no|\tname |\tCet Marks |\tCity\t|");

                        if (pQ.isEmpty()) {
                            System.out.println("\tList Is EMPTY !!");
                        } else {
                            for (int i = 0; i < counter; i++) {

                                Student stu = pQ.poll();
                                pN.add(stu);
                                System.out.println((i+1)+"\t"+stu.getFname() + "|\t" + stu.getCet_marks() + "|\t" + stu.getCity());        //when empty throws NullPointerException, so in catch break the loop;
                            }
                        }

                        for(int i=0;i<counter;i++){
                            Student stu1 = pN.poll();
                            pQ.add(stu1);
                        }
                        break;

                    case 4:
                        System.out.println("************************************************************\n");
                        if(vacancies!=0){
                            System.out.println("\tname |\tCet Marks |\tCity\t|");
                            for (int i = 0; i < counter; i++) {

                                Student stu2 = pQ.poll();
                                pN.add(stu2);
                            }
                            if(counter!=0){

                                Student stu = pN.poll();
                                System.out.println("\t"+stu.getFname() + "|\t" + stu.getCet_marks() + "|\t" + stu.getCity());
                                counter--;
                                --vacancies;
                                for (int i = 0; i < counter; i++) {

                                    Student stu1 = pN.poll();
                                    pQ.add(stu1);
                                }
                            }
                            else System.out.println("\t**\tList is Empty\t**");
                        }
                        else System.out.println("\n\t**\tAll Seats In PICT Are FULL\t**");
                        break;
                    case 5:
                        System.out.println("************************************************************\n");
                        System.out.println("\n\tVacancies In PICT : "+vacancies);
                        break;
                    case 6:
                        System.out.println("************************************************************\n");
                        System.out.println("\n\t**\tProgram Ends\t**\n\t**\tThanks For Visiting Portal\t**");
                        break;
                }


            } while (choice != 6);
        }
    }
