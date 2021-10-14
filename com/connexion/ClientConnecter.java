package com.connexion;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import com.Dao.Reglement;




public class ClientConnecter {
	 private Socket socketEnd2=null;
	  private static final int  port=3333;
	  private  InputStream input=null;
	  private OutputStream output=null;
	  
	  
		public ClientConnecter() {
		try{
			socketEnd2=new Socket("127.0.0.1", port);
		 input=socketEnd2.getInputStream();
		 output=socketEnd2.getOutputStream();
		 
		}catch(Exception exp){
			System.out.println(exp);
		}
		}
		public String getInfoCompte(String key){
			String msg="";
			try{
				 PrintWriter pw=new PrintWriter(output);
				 pw.println(key);
				 pw.flush();
				 
			BufferedReader br=new BufferedReader(new InputStreamReader(input));
			 msg=br.readLine();
			System.out.println(msg);
			
			}catch(Exception exp){
				System.out.println(exp);
			}
			
			return msg;
		}
		public String succesOperation(){
			String msg="";
			try{
				 
			BufferedReader br=new BufferedReader(new InputStreamReader(input));
			msg=br.readLine();
			System.out.println(msg);
			br.close();
			}catch(Exception exp){
				System.out.println(exp);
			}
			return msg;
		}
		public void regler(Reglement r){
			try{
				ObjectOutputStream os=new ObjectOutputStream(output);
				os.writeObject(r);
				os.flush();
				
			}catch(Exception e){
				System.out.println(e);
			}
			}
	


		public static void main(String[] args) {
			ClientConnecter client=new ClientConnecter();
	      String ch=client.getInfoCompte("256B606060");
	      System.out.println(ch);
        Reglement r=new Reglement("256B606060", 150);
	   client.regler(r);
	   String s=client.succesOperation();
	   System.out.println(s);
		}

}
