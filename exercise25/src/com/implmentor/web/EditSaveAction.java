package com.implmentor.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.implmentor.bo.BookmarkForm;

public class EditSaveAction extends ParentAction {

	@Override
	public ActionForward myexecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		if (! isCancelled(request)) {
			editBookmark( (BookmarkForm)form, request);
		}

		return mapping.findForward("list");
	}
}
