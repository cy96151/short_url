package com.cy.shorturl.controller;

import com.cy.shorturl.contant.ShortUrlContant;
import com.cy.shorturl.entity.UrlInfo;
import com.cy.shorturl.mapper.UrlInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Url跳转
 *
 * @author: caoyi
 */
@Controller
public class UrlConvertController {

    @Autowired
    private UrlInfoMapper urlInfoMapper;

    /**
     * 根据短链接获取跳转至长链接
     *
     * @param urlCode 短链接
     * @return 跳转地址
     */
    @GetMapping(value = "/{urlCode}")
    public String urlConvert(@PathVariable(name = "urlCode") String urlCode) {
        // 编码转换
        long id = decode(urlCode);

        // 查询长链信息
        UrlInfo urlInfo = urlInfoMapper.selectById(id);

        // 无效链接
        if (urlInfo == null || StringUtils.isBlank(urlInfo.getUrl())) {
            return "NotFound";
        }

        // 跳转
        return "redirect:" + urlInfo.getUrl();
    }

    /**
     * 首页
     *
     * @return
     */
    @GetMapping(value = "/")
    public String convertPage() {
        return "Convert";
    }

    /**
     * 将短链接进行解码
     * <p>62进制转10进制</p>
     *
     * @param shortUrl 短链接
     * @return 10进制主键
     */
    private long decode(String shortUrl) {
        double id = 0;
        for (int i = 0, length = shortUrl.length(); i < length; i++) {
            int mod = shortUrl.charAt(i) - 48;
            id += ShortUrlContant.charIndex[mod] * Math.pow(62, i);
        }
        return (long) id;
    }
}
