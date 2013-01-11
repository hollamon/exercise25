package com.implmentor.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.implmentor.bo.BookmarkForm;

public abstract class ParentAction extends Action {

	public static final String LIST_KEY = "list";

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		if ( session.getAttribute(LIST_KEY) == null ) {
			List<BookmarkForm> l = new ArrayList<BookmarkForm>();
			l.add(new BookmarkForm(1,"Google","http://www.google.com"));
			l.add(new BookmarkForm(2,"Arizona","http://www.arizona.edu"));
			session.setAttribute(LIST_KEY,l);
		}
		return myexecute(mapping, form, request, response);
	}

	public List<BookmarkForm> getBookmarks(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (List<BookmarkForm>)session.getAttribute(LIST_KEY);
	}

	public BookmarkForm getBookmark(Integer id,HttpServletRequest request) {
		List<BookmarkForm> list = getBookmarks(request);

		for (BookmarkForm bf : list) {
			if ( id.intValue() == bf.getId().intValue() ) {
				return bf;
			}
		}
		return null;
	}

	public void editBookmark(BookmarkForm b,HttpServletRequest request) {
		List<BookmarkForm> list = getBookmarks(request);

		for (BookmarkForm bf : list) {
			if ( b.getId().intValue() == bf.getId().intValue() ) {
				bf.setName(b.getName());
				bf.setUrl(b.getUrl());
			}
		}
	}

	public void deleteBookmark(Integer id,HttpServletRequest request) {
		List<BookmarkForm> list = getBookmarks(request);

		Iterator<BookmarkForm> i = list.iterator();
		while ( i.hasNext() ) {
			BookmarkForm bf = i.next();
			if ( bf.getId().intValue() == id.intValue() ) {
				i.remove();
			}
		}
	}

	public synchronized void addBookmark(BookmarkForm b,HttpServletRequest request) {
		List<BookmarkForm> list = getBookmarks(request);

		// Assign new primary key
		int max = 0;
		for (BookmarkForm bf : list) {
			if ( max < bf.getId() ) {
				max = bf.getId();
			}
		}
		b.setId(max + 1);

		list.add(b);
	}

	public abstract ActionForward myexecute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws Exception;
}
