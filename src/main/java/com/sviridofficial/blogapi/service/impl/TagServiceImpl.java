package com.sviridofficial.blogapi.service.impl;

import com.sviridofficial.blogapi.exception.ResourceNotFoundException;
import com.sviridofficial.blogapi.exception.UnauthorizedException;
import com.sviridofficial.blogapi.model.Tag;
import com.sviridofficial.blogapi.model.role.RoleName;
import com.sviridofficial.blogapi.payload.ApiResponse;
import com.sviridofficial.blogapi.payload.PagedResponse;
import com.sviridofficial.blogapi.repository.TagRepository;
import com.sviridofficial.blogapi.security.UserPrincipal;
import com.sviridofficial.blogapi.service.TagService;
import com.sviridofficial.blogapi.utils.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

	@Autowired
	private TagRepository tagRepository;

	@Override
	public PagedResponse<Tag> getAllTags(int page, int size) {
		AppUtils.validatePageNumberAndSize(page, size);

		Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC, "createdAt");

		Page<Tag> tags = tagRepository.findAll(pageable);

		List<Tag> content = tags.getNumberOfElements() == 0 ? Collections.emptyList() : tags.getContent();

		return new PagedResponse<>(content, tags.getNumber(), tags.getSize(), tags.getTotalElements(), tags.getTotalPages(), tags.isLast());
	}

	@Override
	public Tag getTag(Long id) {
		return tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tag", "id", id));
	}

	@Override
	public Tag addTag(Tag tag, UserPrincipal currentUser) {
		return tagRepository.save(tag);
	}

	@Override
	public Tag updateTag(Long id, Tag newTag, UserPrincipal currentUser) {
		Tag tag = tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tag", "id", id));
		if (tag.getCreatedBy().equals(currentUser.getId()) || currentUser.getAuthorities()
				.contains(new SimpleGrantedAuthority(RoleName.ROLE_ADMIN.toString()))) {
			tag.setName(newTag.getName());
			return tagRepository.save(tag);
		}
		ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, "You don't have permission to edit this tag");

		throw new UnauthorizedException(apiResponse);
	}

	@Override
	public ApiResponse deleteTag(Long id, UserPrincipal currentUser) {
		Tag tag = tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tag", "id", id));
		if (tag.getCreatedBy().equals(currentUser.getId()) || currentUser.getAuthorities()
				.contains(new SimpleGrantedAuthority(RoleName.ROLE_ADMIN.toString()))) {
			tagRepository.deleteById(id);
			return new ApiResponse(Boolean.TRUE, "You successfully deleted tag");
		}

		ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, "You don't have permission to delete this tag");

		throw new UnauthorizedException(apiResponse);
	}
}






















