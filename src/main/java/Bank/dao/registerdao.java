package Bank.dao;

import java.util.List;

import Bank.model.account;
import Bank.model.credit;

public interface registerdao {
	int create(List<account> acc);
	boolean login(account acc);
	int update(account acc);
	int delete(int regNo);
	List<account> search(int regNo);
	List<account> display();
	int creditBal(credit cred);		
	

}
