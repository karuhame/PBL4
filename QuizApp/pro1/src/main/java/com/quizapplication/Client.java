/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quizapplication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class Client {
    private int port;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    public static int StudentInfoNum = 6;
    int role;
    String Name;
    String MSSV;
    String LSH;
    int Mark = 0;
    int Number_Error = 0;
    String Detecting_Error;
    String ID_Account;
    
    public Client(int port){
        this.port = port;
        this.execute();
    }
    public void execute(){
        try {
            socket = new Socket("localhost", this.port);
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public boolean postStudent(String[] datas){
        String result ="";
        String request = "postStudent";
        try {
            //Send request to server: Post Student
            out.writeUTF(request);
            //Send data to server: rollNo, name, gender, address, marks
            for (int i = 0; i < StudentInfoNum; i++) {
                out.writeUTF(datas[i]);
            }
            out.flush();
            // Client Nhan ket qua tu Server: true, false
            result = in.readUTF();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        //If server receive packet return true
        if(result.equals("true")){
            return true;
        }
        return false;
    }
    
//  Name, MSSV, LSH, Mark, Number_Error, Detecting_Error
    public ArrayList<String[]> getAllStudentsByMark(int mark){
        ArrayList<String[]> result = new ArrayList<>(1000);
        String request = "getAllStudents";
        try {
            out.writeUTF(request);
            out.writeUTF(String.valueOf(mark));
            //Get the number of students;
            int studentNum = Integer.parseInt(in.readUTF());
            
            for (int i = 0; i < studentNum; i++) {
                String[] data = new String[Client.StudentInfoNum];
                //read info of each student
                for (int j = 0; j < StudentInfoNum; j++) {
                    data[j] = in.readUTF();
                }
                
                result.add(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        
        return result;
    }
    
   
    
//     Name, MSSV, LSH, Mark, Number_Error, Detecting_Error
    public String[] getStudentInfoByID(String ID_Account){
        String[] datas = new String[StudentInfoNum];
        String request = "getStudentInfoByID";
        try {
            out.writeUTF(request);
            out.writeUTF(ID_Account);

    // Name, MSSV, LSH, Mark, Number_Error, Detecting_Error
            for(int i = 0; i<6; i++){
                datas[i] = in.readUTF();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return datas;
    }

    public void submitRequest(int marks){
        String request = "submitRequest";
        Mark = marks;
        try {
            out.writeUTF(request);
            out.writeUTF(String.valueOf(Mark));
        } catch (Exception e) {
        }
    }
    
    public boolean login(String username, String password){
        String request = "login";
        try {
            out.writeUTF(request);
            out.writeUTF(username);
            out.writeUTF(password);
            System.out.println("1");
            
            // Kêt quả của login 
            if(in.readUTF().equals("Login Fail")){
                System.out.println("Fail");
                return false;
            }

            //Trả về ID, thông tin cá nhân
            role = Integer.parseInt(in.readUTF());
            ID_Account = in.readUTF();

            //Nếu như phân quyền là học sinh thì lấy thông tin
            if(role==1){
                Name = in.readUTF();
                MSSV = in.readUTF();
                LSH = in.readUTF();
            }

           
        } catch (Exception e) {
        }
        return true;
    }
    
     public int getQuestionNumber(){
        int res = 0;
        String request = "getQuestionNumber";
        try {
            out.writeUTF(request);
            //Get number of question
            res = Integer.parseInt(in.readUTF());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return res;
    }
    
    public String[] getQuestionByID(int questionID){
        String[] datas = new String[6];
        String request = "getQuestionByID";
        try {
            out.writeUTF(request);
            out.writeUTF(String.valueOf(questionID));
            //Nhận name, opt, opt2, opt3, opt4, answer
            for(int i = 0; i< 6; i++){
                datas[i] = in.readUTF();
                }
        } catch (Exception e) {
        }
        return datas;
    }
    
    public boolean answerCheck(int questionID, String answer){
        String[] datas;
        datas = getQuestionByID(questionID);
        if(answer.equals(datas[5])){
            Mark++;
            return true;
        }
        return false;
        
    }
   
    public void printThisStudentInfo(){
        System.out.println("ID: " + ID_Account);
        System.out.println("Role: " + role);
        System.out.println("Name: " + Name);
        System.out.println("MSSV: " + MSSV);
        System.out.println("LSH: " + LSH);
        System.out.println("Mark: " + Mark);
        System.out.println("Number of Error: " + Number_Error);
        System.out.println("Name of Error: " + Detecting_Error);
    }
    public static void main(String[] args) {
        Client client = new Client(6666);
//Unit test getAllStudentsByMark
        ArrayList<String[]> result;
        result = client.getAllStudentsByMark(1);
        
// Iterate over the result list and print each String[] element
        for (String[] data : result) {
            System.out.println(Arrays.toString(data));
        }

//UnitTest login
//        System.out.println("hello");
//        boolean checkLogin = client.login("admin", "123456");
//        client.printStudentInfo();
//        System.out.println(checkLogin);
    
//UnitTest getQuestionNumber
//        int questionNum = client.getQuestionNumber();
//        System.out.println(questionNum);

//UnitTest getQuestionByID
//            String[] questionInfo = client.getQuestionByID(8);
//            for(String info: questionInfo){
//                System.out.println(info);
//            }
//UnitTest getStudentIfoByID
//            System.out.println("Hello");
//            String[] studentInfo = client.getStudentInfoByID("1");
//            client.printThisStudentInfo();
    }
}
