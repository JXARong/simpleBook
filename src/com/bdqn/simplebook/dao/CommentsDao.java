package com.bdqn.simplebook.dao;

import com.bdqn.simplebook.domain.Comments;

import java.util.List;

/**
 * @author: 赖榕
 * @date: 2019/11/19
 * @description:
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.dao
 */
public interface CommentsDao {

    List<Comments> selCommentsByPid(Integer pid);

    Integer delCommentsByPid(Integer pid);

    Integer delCommentsByUid(Integer uid);
}
