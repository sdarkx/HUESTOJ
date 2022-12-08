package com.oj.zut.service.utils;

import java.util.Map;

public interface BatchProcessingMail {
    Map<String, String> BatchSendEmail(Map<String, String> date);
}
