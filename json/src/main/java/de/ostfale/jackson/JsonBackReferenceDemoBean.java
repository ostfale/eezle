package de.ostfale.jackson;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.ArrayList;
import java.util.List;

/**
 * Backreference
 * Created : 23.07.2018
 *
 * @author : usauerbrei
 */
public class JsonBackReferenceDemoBean {

	public long personId = 123;
	public String  name = "John Thomas";
	@JsonBackReference
	public List<JsonManagedReferenceBeanDemo> employees;

	public JsonBackReferenceDemoBean(long personId, String name) {
		this.personId = personId;
		this.name = name;
		employees = new ArrayList<JsonManagedReferenceBeanDemo>();
	}

	public void addEmployees(JsonManagedReferenceBeanDemo managedReferenceDemoBean){
		employees.add(managedReferenceDemoBean);
	}
}
