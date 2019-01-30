package com.cy.shorturl.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cy.shorturl.entity.UrlInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * url信息操作
 *
 * @author: 曹毅
 * @since: 2019-01-27
 */
@Mapper
public interface UrlInfoMapper extends BaseMapper<UrlInfo> {
}
