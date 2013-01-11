package com.implmentor.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.implmentor.bo.BookmarkForm;

public class DeleteBookmarkAction extends ParentAction {

	@Override
	public ActionForward myexecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		BookmarkForm bf = (BookmarkForm)form;

		if (! isCancelled(request)) {
			deleteBookmark(bf.getId(), request);
		}

		return mapping.findForward("list");
	}

}
