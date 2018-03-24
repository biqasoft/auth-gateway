package com.biqasoft.authgateway.processing.dto;

import com.biqasoft.entity.core.useraccount.UserAccount;

public class UserAccountAddRequest extends UserAccount {

    private String domain;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
