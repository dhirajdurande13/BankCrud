package Bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import Bank.db.connection;
import Bank.model.account;
import Bank.model.credit;

public class registerDaoimp implements registerdao {

	
	
	Connection conn=null;
	connection c=new connection();
	@Override
	public int create(List<account> lst) {
		// TODO Auto-generated method stub
		
		account acc=lst.get(0);
		
		int i=0;
		try {
			 conn=c.getconnection();
			PreparedStatement pstate=conn.prepareStatement("insert into bank values(?,?,?,?,?)");
			pstate.setInt(1, acc.getRegNo());
			pstate.setString(2, acc.getCustName());
			pstate.setString(3, acc.getUsername());
			pstate.setString(4, acc.getPassword());
			pstate.setDouble(5, acc.getAccBal());
			i=pstate.executeUpdate();
			if(i>0) {
				System.out.println("saved");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return i;
	}

	@Override
	public boolean login(account acc) {
		boolean b=false;
		int i=0;
		 try {
			conn=c.getconnection();
			 PreparedStatement pstate=conn.prepareStatement("select * from bank where username=? and password=?");
			 pstate.setString(1, acc.getUsername());
			 pstate.setString(2, acc.getPassword());
			 i=pstate.executeUpdate();
				if(i>0) {
					b=true;
				}
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return b;
	}

	@Override
	public int update(account acc) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			conn=c.getconnection();
			
			 PreparedStatement pstate=conn.prepareStatement("update bank set accBal=? where regNo=?");
			 pstate.setInt(2, acc.getRegNo());
			 pstate.setDouble(1, acc.getAccBal());
			i=pstate.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return i;
	}

	@Override
	public int delete(int regNo) {
		int i=0;
		try {
			conn=c.getconnection();
			
			 PreparedStatement pstate=conn.prepareStatement("delete from bank  where regNo=?");
			 pstate.setInt(1,regNo);
			
			i=pstate.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return i;
	}

	@Override
	public List<account> search(int regNo) {
		List<account> lst=null;
		try {
			conn=c.getconnection();
			
			 PreparedStatement pstate=conn.prepareStatement("select * from bank where regNo=?");
			 pstate.setInt(1, regNo);
			 ResultSet res=pstate.executeQuery();
			 if(res.next())
			 {
				 account acc=new account(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getFloat(5));
				 lst=new ArrayList<account>();
				 lst.add(acc);
				 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return lst;
	}

	@Override
	public List<account> display() {
		List<account> lst=new LinkedList<account>();
		try {
			conn=c.getconnection();
			String str="SELECT * from bank";
			 Statement state=conn.createStatement();
			ResultSet res=state.executeQuery(str);
			
			 while(res.next())
			 {
				
				 account acc=new account(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getFloat(5));
				
				  lst.add(acc);
				 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
			
		
	
		return lst;
	}

	@Override
	public int creditBal(credit cred) {
		List<account> lst=null;
		float currentAmt=0;
		try {
			conn=c.getconnection();
			
			 PreparedStatement pstate=conn.prepareStatement("select * from bank where regNo=?");
			 pstate.setInt(1, cred.getRegNo());
			 ResultSet res=pstate.executeQuery();
			 if(res.next())
			 {
				
				currentAmt=res.getFloat(5);
				 
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		int i=0;
		float newBal=cred.getAccBal()+currentAmt;
		try {
			conn=c.getconnection();
			
			 PreparedStatement pstate=conn.prepareStatement("update bank set accBal=? where regNo=?");
			 pstate.setInt(2,cred.getRegNo());
			 pstate.setDouble(1, newBal);
			i=pstate.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return i;
	}
}
