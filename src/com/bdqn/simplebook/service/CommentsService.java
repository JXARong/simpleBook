package com.bdqn.simplebook.service;

import com.bdqn.simplebook.domain.Comments;

import java.util.List;

/**
 * @author: 赖榕
 * @date: 2019/11/19
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.service
 */
public interface CommentsService {

    List<Comments> selAllCommentsByPid(Integer pid);
}
