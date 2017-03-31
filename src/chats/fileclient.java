
//package fileshare;
package chats;

import java.net.*;
import java.io.*;
import javax.swing.*;
public class fileclient extends javax.swing.JFrame {

/** Creates new form fileclient */
File fadd;
BufferedOutputStream bos;
ObjectInputStream recv;
Socket  s1;
public fileclient() {
    
initComponents();
this.setVisible(true);
this.pack();
jLabel1.setText("Waiting");
this.setSize(400, 200);
try{
s1=new Socket("127.0.0.1",404);                                                          //port n ip selection  192.168.43.180
}
catch(Exception e){
System.out.println(""+e);
}
service();
}

@SuppressWarnings("unchecked")
// //GEN-BEGIN:initComponents
public void initComponents() {

jLabel1 = new javax.swing.JLabel();

//setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
setTitle("File  Sharing (Client)");

jLabel1.setText("File Recieved…");

javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addGap(129, 129, 129)
.addComponent(jLabel1)
.addContainerGap(191, Short.MAX_VALUE))
);
layout.setVerticalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addContainerGap()
.addComponent(jLabel1)
.addContainerGap(535, Short.MAX_VALUE))
);

pack();
}
public static void main(String args[]) {
   
java.awt.EventQueue.invokeLater(new Runnable() {
public void run() {
new fileclient();
}
});

}
void service(){
int size = 10000000;
byte [] barr  = new byte [size];
try{
InputStream is = s1.getInputStream();

recv=new ObjectInputStream(is);
msg m= new msg();
m=(msg) recv.readObject();
barr=m.getarray();
String fname=m.getname();
jLabel1.setText("File Recieved: "+fname);
destfile();
bos.write(barr);
bos.flush();
bos.close();
}catch(Exception i){
System.out.println("\nClient: Problem  "+i);
}
}
void destfile()
{
this.setSize(600,400);
JFileChooser fc=new JFileChooser();
fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
int x=fc.showSaveDialog(this);
try{
if(x== JFileChooser.CANCEL_OPTION || x ==JFileChooser.ABORT){
jLabel1.setText("## Operation Aborted by User ##");
this.setSize(400,200);
return;
}
}
catch(Exception e){
    
}
jLabel1.setText("Saved As : " +fc.getSelectedFile());
fadd=fc.getSelectedFile();
if((fadd==null)||(fadd.getName().equals(""))){
jLabel1.setText("! File Not Saved or Wrongly saved !");
}
else{
try{
FileOutputStream fos = new FileOutputStream(fadd);
bos = new BufferedOutputStream(fos);
}catch(IOException i){
System.out.println("PROB!"+i);
}
}
new chats.chat_client();
}

// Variables declaration – do not modify//GEN-BEGIN:variables
private javax.swing.JLabel jLabel1;
// End of variables declaration//GEN-END:variables
}
/*class msg implements Serializable
{
boolean flag;
int size;
String name;
byte[] mess;

msg(){
flag=false;
size=0;
name="Server";
}


void setarray(byte[] b){
mess=b;
}

void setname(String str){
name=str;
}

byte[] getarray(){
return(mess);
}

String getname(){
return(name);
}
}*/