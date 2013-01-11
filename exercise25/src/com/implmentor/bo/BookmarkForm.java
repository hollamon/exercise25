package com.implmentor.bo;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class BookmarkForm extends ActionForm implements Serializable {
	private Integer id;
	private String name;
	private String url;

	public BookmarkForm() {
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if ( (name == null) || (name.length() == 0) ) {
			errors.add("name", new ActionMessage("name.required"));
		}
		if ( (url == null) || (url.length() == 0) ) {
			errors.add("url", new ActionMessage("url.required"));
		}
		return errors;
	}

	public BookmarkForm(Integer id,String name,String url) {
		this.id = id;
		this.name = name;
		this.url = url;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
