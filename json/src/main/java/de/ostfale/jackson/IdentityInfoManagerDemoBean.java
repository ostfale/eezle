package de.ostfale.jackson;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.List;

/**
 * Let us consider an example where the IdentityInfoEmployeeDemoBean has a bidirectional relationship
 * with JsonIdentityInfoManagerDemoBean using the @JsonIdentityInfo annotation.
 * Created : 23.07.2018
 *
 * @author : usauerbrei
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "personId")
public class IdentityInfoManagerDemoBean {

	public long personId = 123;
	public String  name = "John Thomas";
	public List<JsonIdentityInfoEmployeeDemoBean> employees;

	public IdentityInfoManagerDemoBean(long personId, String name) {
		this.personId = personId;
		this.name = name;
		employees = new ArrayList<>();
	}

	public void addEmployees(JsonIdentityInfoEmployeeDemoBean identityInfoEmployeeDemoBean){
		employees.add(identityInfoEmployeeDemoBean);
	}
}
