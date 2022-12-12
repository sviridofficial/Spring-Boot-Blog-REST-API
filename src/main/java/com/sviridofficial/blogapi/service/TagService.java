package com.sviridofficial.blogapi.service;

import com.sviridofficial.blogapi.model.Tag;
import com.sviridofficial.blogapi.payload.ApiResponse;
import com.sviridofficial.blogapi.payload.PagedResponse;
import com.sviridofficial.blogapi.security.UserPrincipal;

public interface TagService {

	PagedResponse<Tag> getAllTags(int page, int size);

	Tag getTag(Long id);

	Tag addTag(Tag tag, UserPrincipal currentUser);

	Tag updateTag(Long id, Tag newTag, UserPrincipal currentUser);

	ApiResponse deleteTag(Long id, UserPrincipal currentUser);

}
