package se.mah.k3.pfi2.project.kronox;

import java.util.ArrayList;

public class Posts  {
	/**
	 * Stores All schedule posts
	 * -post stored in Arraylist
	 * Used for working with Graphics & ETC
	 * 
	 * */
	
	ArrayList<Post> posts= new ArrayList<Post>();
		
	
	Posts(ArrayList<Post> _posts){
		 this.posts=_posts;	
	}
	
	 public	void addPost(Post _post){
			posts.add(_post);
		}
	 public	void removePost(int _index){
			posts.remove(_index);
		}
	 public Post getPost(int _index){
		return posts.get(_index);
	 }
	 public ArrayList<Post> getPostArray(){
		return posts;
	 }
	 
}
