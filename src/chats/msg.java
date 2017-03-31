/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chats;

import java.io.Serializable;

/**
 *
 * @author k
 */
class msg implements Serializable
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
}