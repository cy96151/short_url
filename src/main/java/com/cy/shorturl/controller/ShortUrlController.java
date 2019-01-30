package com.cy.shorturl.controller;

import com.cy.shorturl.contant.ShortUrlContant;
import com.cy.shorturl.entity.UrlInfo;
import com.cy.shorturl.mapper.UrlInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 短链接转换控制层
 *
 * @auther: cy96151
 */
@Controller
@RequestMapping("/short_url")
public class ShortUrlController {

    @Autowired
    private UrlInfoMapper urlInfoMapper;

    /**
     * 获取短链接
     *
     * @param longUrl 长链接
     * @return 短链接信息
     */
    @PostMapping("get")
    @ResponseBody
    public Map getShortUrl(String longUrl) {
        // 优化url:剔除空白字符、补充url头
        longUrl = StringUtils.deleteWhitespace(longUrl);
        if (!StringUtils.startsWith(longUrl, ShortUrlContant.URL_HEAD_HTTP) && !StringUtils.startsWith(longUrl, ShortUrlContant.URL_HEAD_HTTPS)) {
            longUrl = ShortUrlContant.URL_HEAD_HTTP + longUrl;
        }

        // LRU


        // 插入表
        UrlInfo urlInfo = new UrlInfo(longUrl);
        urlInfoMapper.insert(urlInfo);

        // 编码转换
        StringBuilder shortUrl = new StringBuilder();
        recursionEncode(shortUrl, urlInfo.getId());

        // 返回结果
        Map result = new HashMap(2);
        result.put("code", 0);
        result.put("shortUrl", shortUrl.toString());
        return result;
    }

    /**
     * 递归编码
     * <p>将id值转为62位编码(倒序)</p>
     *
     * @param shortUrl 生成的62位短码
     * @param i        Url主键
     */
    private void recursionEncode(StringBuilder shortUrl, long i) {
        if (i == 0L) {
            return;
        }
        shortUrl.append(ShortUrlContant.charArray[(int) i % 62]);
        recursionEncode(shortUrl, i / 62);
    }
}
