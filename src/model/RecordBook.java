package model;

public class RecordBook {
	int id;
	String date;
	int price;
	String content;

	public RecordBook() {}

	public RecordBook(String date, String content, int price) {
		this.date=date;
		this.price=price;
		this.content=content;
	}

	public RecordBook(int id, String date,String content, int price) {
		this(date,content,price);
		this.id=id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setDate (String date) {
		this.date=date;
	}

	public String getDate () {
		return date;
	}

	public void setPrice (int price) {
		this.price=price;
	}

	public int getPrice() {
		return price;
	}

	public void setContent(String content) {
		this.content=content;
	}

	public String getContent() {
		return content;
	}
}
