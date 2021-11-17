package com.dao;

import com.domain.Advertisement;

import java.util.List;

public interface MailDAO {
    List<String> findSuitableMails(Advertisement advertisement);
}
