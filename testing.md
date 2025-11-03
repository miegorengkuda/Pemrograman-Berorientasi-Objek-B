Dokumentasi Tugas atau Project mata kuliah Pemrograman Berorientasi Objek (B)

Dafa Kumara Sahasika (5025241112)

## Testing dan Debugging
Testing adalah salah satu aktivitas yang harus dilakukan sebagai bagian dari tahap pembangunan perangkat lunak. 
Tujuannya adalah untuk mencari sebanyak-banyaknya kesalahan, error maupun defect. 
Testing dilakukan dengan mengacu pada test plan dan test cases.

Debugging adalah aktivitas yang dilakukan untuk mencari posisi kesalahan dan memperbaikinya apabila dari hasil testing diperoleh indikasi adanya error atau defect.


`SalesItem.java`
```java
import java.util.ArrayList;

public class SalesItem
{
    private String name;
    private int price;
    private ArrayList<Comment> comments;
    public SalesItem(String name, int price)
    {
        this.name = name;
        this.price = price;
        comments = new ArrayList<Comment>();
    }
    public boolean addComment(String author, String text, int rating)
    {
        if(rating < 1 || rating > 5) {
            return false;
        }
        for(Comment comment : comments) {
            if(comment.getAuthor().equals(author)) {
                return false;
            }
        }
        Comment newComment = new Comment(author, text, rating);
        comments.add(newComment);
        return true;
    }
    public boolean removeComment(Comment comment)
    {
        return comments.remove(comment);
    }
    public int getNumberOfComments()
    {
        return comments.size();
    }
    public void showInfo()
    {
        System.out.println("=================================");
        System.out.println("Item: " + name);
        System.out.println("Price: " + price);
        System.out.println("Number of comments: " + getNumberOfComments());
        for(Comment comment : comments) {
            comment.print();
            System.out.println();
        }
    }
    public Comment findMostHelpfulComment()
    {
        if(comments.isEmpty()) {
            return null;
        }
        Comment best = comments.get(0);
        for(Comment current : comments) {
            if(current.getVoteBalance() > best.getVoteBalance()) {
                best = current;
            }
        }
        return best;
    }
}
```

`Comment.java`
```java
public class Comment
{
    private String author;
    private String text;
    private int rating;
    private int upvotes;
    private int downvotes;
    public Comment(String author, String text, int rating)
    {
        this.author = author;
        this.text = text;
        this.rating = rating;
        upvotes = 0;
        downvotes = 0;
    }
    public String getAuthor()
    {
        return author;
    }
    public void upvote()
    {
        upvotes++;
    }
    public void downvote()
    {
        downvotes++;
    }
    public int getVoteBalance()
    {
        return upvotes - downvotes;
    }
    public void print()
    {
        System.out.println("Author: " + author);
        System.out.println("Rating: " + rating);
        System.out.println("Comment: " + text);
        System.out.println("Votes: " + getVoteBalance());
    }
}
```
