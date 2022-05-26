package com.gapache.cloud.auth.server.service;

import com.gapache.security.model.ResourceDTO;

import java.util.List;

public interface ResourceService {

    List<ResourceDTO> findAll();
}
