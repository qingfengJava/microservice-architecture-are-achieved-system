package com.gapache.user.server.service;

import com.gapache.user.common.model.vo.UserCustomizeInfoVO;

public interface UserCustomizeInfoService {

    UserCustomizeInfoVO create(UserCustomizeInfoVO vo);

    boolean update(UserCustomizeInfoVO vo);

    boolean delete(Long id);

    UserCustomizeInfoVO get(Long id);

    Object findValue(Long userId, String clientId, String key);
}
