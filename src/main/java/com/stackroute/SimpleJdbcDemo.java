package com.stackroute;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class SimpleJdbcDemo
{
  private Connection connection;
  private Statement statement;
  private ResultSet resultSet;
  public void getEmployeeDetails()
  {
      try
      /*(Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","Root@123");
      Statement statement=connection.createStatement();
      ResultSet resultSet= statement.executeQuery("Select * from employee");
           ); *///FOR TRY WITH RESOURCE
      {
          /*load driver and register with driver manager*/
          Class.forName("com.mysql.cj.jdbc.Driver");
          //Driver manager  to get connection
          connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","Root@123");
          //create a statement
          statement=connection.createStatement();
          //ResultSet obj
          resultSet= statement.executeQuery("Select * from employee");
          while(resultSet.next())
          {
              System.out.println("Id: "+ resultSet.getInt(1)+" Name:"+resultSet.getString(2)+" Age:"+resultSet.getInt(3)+" Gender:"+resultSet.getString(4));
          }
      }


      catch (ClassNotFoundException e) {
          e.printStackTrace();
      } catch (SQLException e) {
          e.printStackTrace();

      }
    finally {
          try{
          connection.close();
          resultSet.close();
          statement.close();
      } catch (SQLException e) {
              e.printStackTrace();
          }
      }
  }
}
