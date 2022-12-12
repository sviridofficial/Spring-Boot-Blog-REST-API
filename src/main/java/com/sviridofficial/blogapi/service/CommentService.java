package com.sviridofficial.blogapi.service;

import com.sviridofficial.blogapi.model.Comment;
import com.sviridofficial.blogapi.payload.ApiResponse;
import com.sviridofficial.blogapi.payload.CommentRequest;
import com.sviridofficial.blogapi.payload.PagedResponse;
import com.sviridofficial.blogapi.security.UserPrincipal;

public interface CommentService {

	PagedResponse<Comment> getAllComments(Long postId, int page, int size);

	Comment addComment(CommentRequest commentRequest, Long postId, UserPrincipal currentUser);

	Comment getComment(Long postId, Long id);

	Comment updateComment(Long postId, Long id, CommentRequest commentRequest, UserPrincipal currentUser);

	ApiResponse deleteComment(Long postId, Long id, UserPrincipal currentUser);

}
