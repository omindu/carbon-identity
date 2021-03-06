
/*
 * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.application.common.model;

import org.apache.axiom.om.OMElement;

import java.io.Serializable;
import java.util.Iterator;

public class User implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -3605277664796682611L;
    protected String tenantDomain;
    protected String userStoreDomain;
    protected String userName;

    /**
     * Returns a User instance populated from the given OMElement
     * The OMElement is of the form below
     * <User>
     * <TenantDomain></TenantDomain>
     * <UserStoreDomain></UserStoreDomain>
     * <UserName></UserName>
     * </User>
     *
     * @param userOM OMElement to populate user
     * @return populated User instance
     */
    public static User build(OMElement userOM) {
        User user = new User();

        if (userOM == null) {
            return user;
        }

        Iterator<?> iter = userOM.getChildElements();
        while (iter.hasNext()) {
            OMElement member = (OMElement) iter.next();
            if ("TenantDomain".equals(member.getLocalName())) {
                if (member.getText() != null) {
                    user.setTenantDomain(member.getText());
                }
            } else if ("UserStoreDomain".equalsIgnoreCase(member.getLocalName())) {
                user.setUserStoreDomain(member.getText());
            } else if ("UserName".equalsIgnoreCase(member.getLocalName())) {
                user.setUserName(member.getText());
            }
        }
        return user;

    }

    /**
     * Returns the tenant domain of the user
     *
     * @return tenant domain
     */
    public String getTenantDomain() {
        return tenantDomain;
    }

    /**
     * Sets the tenant domain of the user
     *
     * @param tenantDomain tenant domain of the user
     */
    public void setTenantDomain(String tenantDomain) {
        this.tenantDomain = tenantDomain;
    }

    /**
     * Returns the user store domain of the user
     *
     * @return user store domain
     */
    public String getUserStoreDomain() {
        return userStoreDomain;
    }

    /**
     * Sets the user store domain of the user
     *
     * @param userStoreDomain user store domain of the user
     */
    public void setUserStoreDomain(String userStoreDomain) {
        this.userStoreDomain = userStoreDomain;
    }

    /**
     * Returns the username of the user
     *
     * @return username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username of the user
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
