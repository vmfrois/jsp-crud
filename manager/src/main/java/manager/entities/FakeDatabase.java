package manager.entities;

import java.util.ArrayList;
import java.util.List;

public class FakeDatabase {

	private static List<Company> list = new ArrayList<>();
	
	static {
		Company company = new Company();
		company.setName("Take Blip");
		
		Company company2 = new Company();
		company2.setName("Google");
		
		list.add(company);
		list.add(company2);
	}
	
	
	public void add(Company company) {
		System.out.println("Empresa cadastrada no banco");
		FakeDatabase.list.add(company);
	}
	
	public List<Company> getEmpresa(){
		
		return FakeDatabase.list;
	}
}
