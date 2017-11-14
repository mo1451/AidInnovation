/**
 * 
 */
package com.mo1451.model;

/**
 * @author 默1451
 *
 */
public class Page {
	private int start;
	private int pageSize;
	private int count;
	private int page;
	private int maxPage;
	
	public Page(int page, int pageSize) {
		this.page = page;
		this.pageSize = pageSize;
		this.start = (page-1)*pageSize;
	}
	public int getStart() {
		return start;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getCount() {
		return count;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	
	public void resetMaxPage() {
		this.maxPage = count/pageSize + 1;
	}
}
