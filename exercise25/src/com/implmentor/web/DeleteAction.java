package com.implmentor.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.implmentor.bo.BookmarkForm;

public class DeleteAction extends ParentAction {

	@Override
	public ActionForward myexecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String sid = request.getParameter("id");

		int id;
		try {
			id = Integer.parseInt(sid);
		} catch (NumberFormatException e) {
			System.err.println("Unable to parse int on " + sid);
			return mapping.findForward("list");
		}

		BookmarkForm b = getBookmark(id, request);
		if ( b == null ) {
			System.err.println("bookmark " + id + " not found");
			return mapping.findForward("list");
		}

		request.setAttribute("bookmarkForm", b);
		return mapping.findForward("delete");
	}
}
