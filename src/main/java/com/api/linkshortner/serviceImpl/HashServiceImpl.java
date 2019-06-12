package com.api.linkshortner.serviceImpl;

import com.api.linkshortner.service.HashService;
import com.api.linkshortner.utils.SupportedProtocol;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
//import org.apache.wicket.protocol.http.request;


@Service
public class HashServiceImpl implements HashService {

    private static final int RADIX = 36;
    private static final String PIPE = "-";

    @Override
    public String shorten(String url) {
        return encode(url);
    }

    private String encode(String url) {
        if(StringUtils.isEmpty(url)) {
            throw new InternalException("Invalid URL Exception");
        }

        boolean isSupportedProtocol = SupportedProtocol.contains(url);
        if (!isSupportedProtocol) {
            throw new InternalException("URL Protocol Error");
        }

        String hexValue = Integer.toString(url.hashCode(), RADIX);
        if (hexValue.startsWith(PIPE)) {
            hexValue = hexValue.substring(1);
        }

        return hexValue;
    }
}
