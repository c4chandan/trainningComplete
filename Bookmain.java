class Book
{
	 int isBn;
	 String bookTitle;
	 String authorName;
 	 double	price;

	void setBookDetails(int id,String title,String name,double pri )
	{
		isBn=id;
		bookTitle=title;
		authorName=name;
		price=pri;	
	}
	
	void printBookDetails()
	{
		System.out.println("ID ="+isBn);
		System.out.println("BookTitle="+bookTitle);
		System.out.println("AuthorName"+authorName);
		System.out.println("Price"+price);
	}

	double getAmountToPay(double discountPercent)
	{
		return (price-(price*(discountPercent/100)));
	}
}

class Bookmain
{
	public static void main(String[] args)
	{ 
		Book newbooks=new Book();
		newbooks.setBookDetails(1,"Jungle","Disney",180);
		newbooks.printBookDetails();
		System.out.println("price after discount "+newbooks.getAmountToPay(5.0)+"\n \n");

		Book newbooks2=new Book();
		newbooks2.setBookDetails(2,"Ramayn","ramchander",230);
		newbooks2.printBookDetails();
		System.out.println("price after discount "+newbooks2.getAmountToPay(10.0));
	}
}







