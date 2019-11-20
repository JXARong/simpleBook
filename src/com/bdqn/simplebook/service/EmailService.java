package com.bdqn.simplebook.service;

import com.bdqn.simplebook.domain.Email;

/**
 * @author: 赖榕
 * @date: 2019/11/20
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.service
 */
public interface EmailService {
    boolean updateEmail(String path, Email email) throws Exception;
}
