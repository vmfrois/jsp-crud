package manager.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FakeDatabase {

	private static List<Company> list = new ArrayList<>();
	private static Integer id = 1;
	
	static {
		Company company = new Company();
		company.setId(FakeDatabase.id++);
		company.setName("Take Blip");
		
		Company company2 = new Company();
		company2.setId(FakeDatabase.id++);
		company2.setName("Google");
		
		list.add(company);
		list.add(company2);
	}
	
	
	public void add(Company company) {
		company.setId(FakeDatabase.id++);
		FakeDatabase.list.add(company);
	}
	
	public List<Company> getAllCompany(){
		return FakeDatabase.list;
	}
	
	public Company getCompanyById(Integer id) {
		for (Company company : list) {
			if(company.getId() == id) {
				return company;
			}
		}
		return null;
	}
	
	public Company removeCompany(Integer id){
		Company companyRemoved = null;
		Iterator<Company> it = list.iterator();
		while(it.hasNext()) {
			Company comp = it.next();
			if(comp.getId() == id) {
				it.remove();
				companyRemoved = comp;
			}
		}
		return companyRemoved;
	}
	

	
}
