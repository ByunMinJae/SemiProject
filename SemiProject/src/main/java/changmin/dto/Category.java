package changmin.dto;

public class Category {
	private int categoryno;
	private String categoryname;
	
	public Category() {
	}

	public Category(int categoryno, String categoryname) {
		super();
		this.categoryno = categoryno;
		this.categoryname = categoryname;
	}

	@Override
	public String toString() {
		return "Category [categoryno=" + categoryno + ", categoryname=" + categoryname + "]";
	}

	public int getCategoryno() {
		return categoryno;
	}

	public void setCategoryno(int categoryno) {
		this.categoryno = categoryno;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	
	
	
}
