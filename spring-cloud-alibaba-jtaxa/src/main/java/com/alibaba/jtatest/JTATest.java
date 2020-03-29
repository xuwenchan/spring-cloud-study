package com.alibaba.jtatest;

import com.mysql.cj.jdbc.MysqlXADataSource;
import com.mysql.cj.jdbc.MysqlXid;

import javax.sql.XAConnection;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;
import java.sql.Connection;
import java.sql.Statement;

public class JTATest {

    static String db1 = "jdbc:mysql://localhost:3306/link";

    static String db2 = "jdbc:mysql://localhost:3306/finance";

    public static void main(String[] args){

         String connStr1 = "jdbc:mysql://localhost:3306/link";

         String connStr2 = "jdbc:mysql://localhost:3306/finance";

         try{
             //从不同数据库获取不同的数据源
             MysqlXADataSource ds1=getDataSource(connStr1,"root","123456");

             MysqlXADataSource ds2=getDataSource(connStr1,"root","123456");

             //数据库1获取连接
             XAConnection xaConnection=ds1.getXAConnection();
             XAResource xaResource= xaConnection.getXAResource();
             Connection connection= xaConnection.getConnection();
             Statement statement= connection.createStatement();

             //数据库2获取连接
             XAConnection xaConnection2=ds1.getXAConnection();
             XAResource xaResource2= xaConnection2.getXAResource();
             Connection connection2= xaConnection2.getConnection();
             Statement statement2= connection2.createStatement();

             //创建事务分支的xid
             Xid xid1=new MysqlXid(new byte[]{0x01},new byte[]{0x02},100);
             Xid xid2=new MysqlXid(new byte[]{0x011},new byte[]{0x012},100);

             try{
               //事务分支1关联分支事务sql语句
               xaResource.start(xid1,XAResource.TMNOFLAGS);
               int updateResult=statement.executeUpdate("insert into usres('uid','userName','pwd') values (10,'xuwenchan','123456') ");
               xaResource.end(xid1,XAResource.TMSUCCESS);

               //事务分支2关联分支事务sql语句

                 xaResource2.start(xid2,XAResource.TMNOFLAGS);
                 int updateResult1=statement2.executeUpdate("insert into usres('uid','userName','pwd') values (10,'xuwenchan','123456') ");
                 xaResource2.end(xid2,XAResource.TMSUCCESS);

                 //两阶段提交协议第一阶段
                 int ret1=xaResource.prepare(xid1);
                 int ret2=xaResource2.prepare(xid2);
                 /*到此为止，已经添加好了一把锁*/

                 //两阶段提交协议第二阶段
                 if(XAResource.XA_OK==ret1 && XAResource.XA_OK==ret2){
                     xaResource.commit(xid1,false);
                     xaResource2.commit(xid2,false);

                     System.out.println("ret1:"+ret1+"-----ret2:"+ret2);
                 }else {
                     xaResource.rollback(xid1);
                     xaResource2.rollback(xid2);
                 }



             }catch (Exception e){
                 e.printStackTrace();
             }






         }catch(Exception e){
             System.out.println("出现异常");
             e.printStackTrace();
         }


    }

    public static MysqlXADataSource getDataSource(String connStr,String user,String pwd){
        return null;
    }
}
