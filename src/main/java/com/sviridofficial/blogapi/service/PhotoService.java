package com.sviridofficial.blogapi.service;

import com.sviridofficial.blogapi.payload.ApiResponse;
import com.sviridofficial.blogapi.payload.PagedResponse;
import com.sviridofficial.blogapi.payload.PhotoRequest;
import com.sviridofficial.blogapi.payload.PhotoResponse;
import com.sviridofficial.blogapi.security.UserPrincipal;

public interface PhotoService {

	PagedResponse<PhotoResponse> getAllPhotos(int page, int size);

	PhotoResponse getPhoto(Long id);

	PhotoResponse updatePhoto(Long id, PhotoRequest photoRequest, UserPrincipal currentUser);

	PhotoResponse addPhoto(PhotoRequest photoRequest, UserPrincipal currentUser);

	ApiResponse deletePhoto(Long id, UserPrincipal currentUser);

	PagedResponse<PhotoResponse> getAllPhotosByAlbum(Long albumId, int page, int size);

}