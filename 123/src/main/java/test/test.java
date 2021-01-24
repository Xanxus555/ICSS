package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;

import org.ansj.domain.Result;
import org.ansj.splitWord.analysis.ToAnalysis;

import com.mysql.cj.MysqlConnection;

import mysql.MySQLCre;
import mysql.MySQLconnection;

public class test {
	static Connection connection;
    public static void main( String[] args )throws IOException 
    {

    		connection = MySQLconnection.getConnection();
    		MySQLCre.CreDatabase(connection);
	        String fileName ="../123/src/main/java/train.txt";
	        File file = new File(fileName);

	        BufferedReader reader = null;
	        try {
	        	
	        	
	            System.out.println("以行为单位读取文件内容，一次读一整行：");
	            reader = new BufferedReader(new FileReader(file));
	            String tempString = null;
	            int line = 1;
	            long id=0;
	            
	            // 一次读入一行，直到读入null为文件结束
	            while ((tempString = reader.readLine()) != null) {
	            	
	            	if(tempString.charAt(0)=='0') {
	            		
	            	}
	            	else {
						
					long mathpre1=id-1;
	            	long mathpre2=id-2;
	            	long mathnext1=0;
	            	long mathnext2=0;
	                // 显示行号
	            	String name="";
	            	String pre1="";
	            	String pre2="";
	            	String next1="";
	            	String next2="";
	            	
	                System.out.println("line " + line + ": " + tempString);
	                String str=ToAnalysis.parse(tempString).toString();
	                System.out.println(str);
	                int position=0;
	                int flag=0;
	                for(int i=6;i<str.length();i++) {
	                	if(str.charAt(i)==32||str.charAt(i)==9)
	                	{
	                		if(str.charAt(i)==9) {
	                			position=0;
	                			flag++;
	                		}
	                		i+=2;
	                		
	                	}

	                	String a="";
	                	String b="";
	                	String part="";
	                	mathnext2=0;
	                	int l=i;
	                	int tag= 0;
	                	for(;l<str.length()&&(str.charAt(l))!=',';l++) {
	                		if(str.charAt(l)=='/')
	                		{
	                			part="";
	                			tag=1;
	                		}
	                		if(tag==1)
	                			part+=str.charAt(l);
	                		else
	                			a+=str.charAt(l);
	                		
	                	}
	                	int j=i;
	                	tag=0;
	                	for(int k=0;k!=2;j++) {
	                		if(j==str.length()||str.charAt(j)==9) {
	                			tag=1;
	                			break;
	                		}
	                			
	                		if(str.charAt(j)==','&&str.charAt(j+1)!=32&&str.charAt(j)!=9)
	                			k++;
	                	}
	                	
	                	id++;
	                	//System.out.println(tag);
	                	for(int k=j;k<str.length()&&(str.charAt(k))!=',';k++) {
	                		if(str.charAt(k)=='/')
	                		{
	                			
	                			tag=1;
	                		}
	                		if(tag==1) {

	                			break;
	                		}
	                		else if(tag==0) {
	                			b+=str.charAt(k);
	                			mathnext2=id+2;
	                		}
	                			
	                	}
	                	next1=next2;
	                	next2=b;
	                	position++;
	                	
	                	int q_or_a=flag%2;
	                	
	                	
	                	if(position==1) {
	                		pre1="";
	                		pre2="";
	                		mathpre1=0;
	                		mathpre2=-1;
	                	}
	                	else if(position==2) {
	                		mathpre1=id-1;
	                		mathpre2=0;
	                	}
	                	else{
	                		mathpre1=id-1;
	                		mathpre2=id-2;
	                	}
	            		if(a.length()>=25||pre1.length()>=40||pre2.length()>=40||next1.length()>=40||next2.length()>=40)continue;
	                	MySQLCre.superadd(id,q_or_a,part,a, pre1, pre2, next1, next2,line,flag,line%1000);//需要添加，line第几条语句，length本语句第几个词

	                	
	                	
	                	MySQLCre.supermath(id,q_or_a,part,a,mathpre1,mathpre2,mathnext1,mathnext2,line,flag,line%1000);
	                	pre2=pre1;
	                	pre1=a;
	                	mathpre2=mathpre1;
	                	mathnext1=mathnext2;
	                	

	                	i=l;
	                }
	                
	                line++;
	                if(line == 10000)break;
	            	}
	            }
	            MySQLCre.finish();
	            reader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (reader != null) {
	                try {
	                    reader.close();
	                } catch (IOException e1) {
	                }

	        
	            }
	    
    }MySQLconnection.close(connection);
	        
}
}
