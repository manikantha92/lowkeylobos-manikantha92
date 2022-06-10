package com.directtv.lowkeylobos.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class Constraints{

	private boolean isRecordable;

	public boolean isRecordable() {
		return isRecordable;
	}

	public void setRecordable(boolean isRecordable) {
		this.isRecordable = isRecordable;
	}
}
