package com.abbreviator.service;

import com.abbreviator.dao.RequestObjectLink;
import com.abbreviator.entity.Link;

public interface AbbreviateService {
    Link abbreviateURI(RequestObjectLink link);
}
