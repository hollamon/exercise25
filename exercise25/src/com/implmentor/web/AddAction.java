package com.implmentor.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class AddAction extends ParentAction {

	@Override
	public ActionForward myexecute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws Exception {
		// For some reason, a bookmark form was being put in session.  This makes sure it is gone
		// so the form will be empty when adding
		request.getSession().removeAttribute("bookmarkForm");

		return mapping.findForward("add");
	}

}
