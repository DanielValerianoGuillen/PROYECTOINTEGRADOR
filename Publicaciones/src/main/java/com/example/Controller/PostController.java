package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Document.Comentario;
import com.example.Document.Post;
import com.example.RestRepository.PostRep;
import com.mongodb.client.result.UpdateResult;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin()
public class PostController {
	
	
	@Autowired
	private PostRep postRep;
	
	@GetMapping("/posts/")
	public List<Post> findAll(){
		return postRep.finaAll();
	}
	
	@PostMapping("/posts")
	public Post save(@RequestBody Post post) {
		return postRep.save(post);
	}
	
	@PostMapping("/posts/{idPost}/addcomment")
	public UpdateResult addComment(@PathVariable("idPost") String idPost ,@RequestBody Comentario comentario){
		return postRep.addComment(idPost, comentario);
	}
	
	@GetMapping("/post/{idPost}")
	public Post find(@PathVariable("idPost") String idPost) {
		return postRep.find(idPost);
	}
}
