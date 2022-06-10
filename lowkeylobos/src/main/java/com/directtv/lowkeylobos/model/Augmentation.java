package com.directtv.lowkeylobos.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class Augmentation {

	private Constraints constraints;

	public Constraints getConstraints() {
		return constraints;
	}

	public void setConstraints(Constraints constraints) {
		this.constraints = constraints;
	}
}
