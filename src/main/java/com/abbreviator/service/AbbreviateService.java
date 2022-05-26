package com.abbreviator.service;

import com.abbreviator.controller.help.RequestObjectLink;
import com.abbreviator.entity.Link;

public interface AbbreviateService {
    Link abbreviateURI(RequestObjectLink link);
}
