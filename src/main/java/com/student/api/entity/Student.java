package com.student.api.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "students")
public class Student {
	
	@Id
	private String studentId;
	
	private String name;
	
	@Field(name = "mail")
	private String email;
	
	private Department department;
	
	private List<Subject> subjects;
	
	@Transient
	private double precentage;
	
	public double getPrecentage() {
		if(subjects!=null && subjects.size()>0) {
			int total = 0;
			for(Subject subject:  subjects) {
				total += Integer.valueOf(subject.getMarkObtained());
			}
			return total/subjects.size();
		}
		return 0.00;
	}

}
