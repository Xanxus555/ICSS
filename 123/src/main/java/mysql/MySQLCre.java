package mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

 
public class MySQLCre {
	static Connection con;
	static StringBuffer suffix=new StringBuffer();
	static StringBuffer suffixmath=new StringBuffer();
	public static void CreDatabase(Connection connection) {
		//声明一个连接对象
		//遍历查询结果集
		con=connection;
		
        try {
            //1.调用方法返回连接
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            Statement statement = con.createStatement(); //2.创建statement类对象，用来执行SQL语句！！
            
            String sql="drop table if exists word;";
            statement.executeUpdate(sql);
            sql = "CREATE TABLE word("
            		+ "id bigint(50) not null,"
            		+ "q_or_a int(50),"
            		+ "part varchar(50),"
                    + "name varchar(50),"
                    + "pre1 varchar(50),"
                    + "pre2 varchar(50),"
                    + "next1 varchar(50),"
                    + "next2 varchar(50),"
                    + "label int(50),"
                    + "Sequence int(50)"
                    + ")charset=utf8;";	//要执行的SQL语句
            statement.executeUpdate(sql);
            
            MySQLconnection.close(statement);
        }	catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        //创建Math数据库
        try {
            //1.调用方法返回连接
            if(!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            Statement statement = con.createStatement(); //2.创建statement类对象，用来执行SQL语句！！
            
            String sql="drop table if exists math;";
            statement.executeUpdate(sql);
            sql = "CREATE TABLE math("
            		+ "id bigint(50) not null,"
            		+ "q_or_a int(50),"
            		+ "part varchar(50),"
                    + "name varchar(50),"
                    + "pre1 bigint(50),"
                    + "pre2 bigint(50),"
                    + "next1 bigint(50),"
                    + "next2 bigint(50),"
                    + "label int(50),"
                    + "Sequence int(50)"
                    + ")charset=utf8;";	//要执行的SQL语句
            statement.executeUpdate(sql);
            
            MySQLconnection.close(statement);
        }	catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
	}
	public static void superadd(long id,int q_or_a,String part,String name,String pre1,String pre2,String next1,String next2,int line,int position,int sumflag) {
		String sql="insert into word (id,q_or_a,part,name,pre1,pre2,next1,next2,label,Sequence)values ";
		suffix.append("('"+id+"','"+q_or_a+"','"+part+"','"+name+"','"+pre1+"','"+pre2+"','"+next1+"','"+next2+"','"+line+"','"+position+"'),");
		if(sumflag==0) {
			try {
				con.setAutoCommit(false);
				
				PreparedStatement past=con.prepareStatement(" ");
				sql+=suffix.substring(0,suffix.length()-1);
				past.addBatch(sql);
				past.executeBatch();
				con.commit();
				past.close();
				suffix=new StringBuffer();
			}catch(SQLException e){
				e.printStackTrace();
			}
			
		}

	}
	public static void supermath(long id,int q_or_a,String part,String name,long pre1,long pre2,long next1,long next2,int line,int position,int sumflag)
	{
		String sql="insert into math (id,q_or_a,part,name,pre1,pre2,next1,next2,label,Sequence)values ";
		suffixmath.append("('"+id+"','"+q_or_a+"','"+part+"','"+name+"','"+pre1+"','"+pre2+"','"+next1+"','"+next2+"','"+line+"','"+position+"'),");
		if(sumflag==0) {
			try {
				con.setAutoCommit(false);
				
				PreparedStatement past=con.prepareStatement(" ");
				sql+=suffixmath.substring(0,suffixmath.length()-1);
				past.addBatch(sql);
				past.executeBatch();
				con.commit();
				past.close();
				suffixmath=new StringBuffer();
			}catch(SQLException e){
				e.printStackTrace();
			}
			
		}
	}
	public static void finish() {
		String sql="delete from word where part=''";
		
		Statement statement;
		try {
			statement = con.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	public static void Add(long id,int q_or_a,String part,String name,String pre1,String pre2,String next1,String next2,int line,int position) { 
		try {
		
		String sql="insert into word values('"+id+"','"+q_or_a+"','"+part+"','"+name+"','"+pre1+"','"+pre2+"','"+next1+"','"+next2+"','"+line+"','"+position+"')";
		Statement statement = con.createStatement();
        statement.executeUpdate(sql);
        MySQLconnection.close(statement);
        }	catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
	}
	public static void AddMath(long id,int q_or_a,String part,String name,long pre1,long pre2,long next1,long next2,int line,int position) { 
		try {
		
		String sql="insert into math values('"+id+"','"+q_or_a+"','"+part+"','"+name+"','"+pre1+"','"+pre2+"','"+next1+"','"+next2+"','"+line+"','"+position+"')";
		Statement statement = con.createStatement();
        statement.executeUpdate(sql);
        MySQLconnection.close(statement);
        }	catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
	}
	
    public static void main(String[] args) {
    }
 
}