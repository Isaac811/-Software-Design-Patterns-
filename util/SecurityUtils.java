package com.work.util;

import com.work.common.exception.ServiceException;
import com.work.constant.HttpStatus;
import com.work.domain.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author Jiayu Liu
 */
public class SecurityUtils {
    /**
     * Get Authentication
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
