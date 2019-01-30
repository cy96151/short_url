package com.cy.shorturl.service.impl;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cy.shorturl.entity.UrlInfo;
import com.cy.shorturl.mapper.UrlInfoMapper;
import com.cy.shorturl.service.IurlInfoService;
import org.springframework.stereotype.Service;

/**
 * @author: 曹毅
 * @since: 2019-01-28
 */
@Service
public class UrlInfoServiceImpl extends ServiceImpl<UrlInfoMapper,UrlInfo> implements IurlInfoService {
}
