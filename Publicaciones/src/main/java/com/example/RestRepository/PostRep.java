package com.example.RestRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.example.Document.Comentario;
import com.example.Document.Post;
import com.mongodb.client.result.UpdateResult;

@Repository
public class PostRep {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public Post save(Post post) {
		return mongoTemplate.save(post);
	}
	
	public UpdateResult addComment(String idPost,Comentario comentario) {
		return mongoTemplate.updateFirst(
				new Query().addCriteria(Criteria.where("_id").is(idPost)),
				new Update().addToSet("comentarios", comentario),
				Post.class);
	}
	
	public List<Post> finaAll(){
		return mongoTemplate.findAll(Post.class);
	}
	
	public Post find(String idPost) {
		return mongoTemplate.find(
				new Query ().addCriteria(Criteria.where("_id").is(idPost)),
				Post.class).get(0);
	}
}

