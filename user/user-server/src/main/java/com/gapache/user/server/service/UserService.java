package com.gapache.user.server.service;

import com.gapache.commons.model.IPageRequest;
import com.gapache.commons.model.PageResult;
import com.gapache.user.common.model.vo.UserVO;
import com.gapache.user.common.model.vo.SaveUserRelationVO;

import java.util.List;

public interface UserService {

    UserVO create(UserVO vo);

    Boolean userIsExisted(Long id);

    UserVO findByUsername(String username, String clientId);

    boolean delete(Long id);

    UserVO get(Long id, String clientId);

    boolean update(UserVO vo);

    PageResult<UserVO> page(IPageRequest<UserVO> iPageRequest);

    Boolean saveUserRelation(SaveUserRelationVO vo);

    List<UserVO> findAllByIdIn(List<Long> userIds);

    List<UserVO> list(UserVO userVO);
}
