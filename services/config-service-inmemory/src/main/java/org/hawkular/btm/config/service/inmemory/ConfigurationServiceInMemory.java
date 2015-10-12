/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hawkular.btm.config.service.inmemory;

import javax.inject.Singleton;

import org.hawkular.btm.api.model.config.CollectorConfiguration;
import org.hawkular.btm.api.model.config.btxn.BusinessTxnConfig;
import org.hawkular.btm.api.services.ConfigurationLoader;
import org.hawkular.btm.api.services.ConfigurationService;

/**
 * This class provides the in-memory implementation of the Admin
 * Service. This implementation is only intended for testing usage.
 *
 * @author gbrown
 */
@Singleton
public class ConfigurationServiceInMemory implements ConfigurationService {

    /* (non-Javadoc)
     * @see org.hawkular.btm.api.services.AdminService#getCollectorConfiguration(java.lang.String,
     *                          java.lang.String, java.lang.String)
     */
    @Override
    public CollectorConfiguration getCollectorConfiguration(String tenantId, String host, String server) {
        return ConfigurationLoader.getConfiguration();
    }

    /* (non-Javadoc)
     * @see org.hawkular.btm.api.services.ConfigurationService#updateBusinessTransactionConfig(java.lang.String,
     *              java.lang.String, org.hawkular.btm.api.model.config.btxn.BusinessTxnConfig)
     */
    @Override
    public void updateBusinessTransactionConfig(String tenantId, String name, BusinessTxnConfig config) {
    }

    /* (non-Javadoc)
     * @see org.hawkular.btm.api.services.ConfigurationService#getBusinessTransactionConfig(java.lang.String,
     *                          java.lang.String)
     */
    @Override
    public BusinessTxnConfig getBusinessTransactionConfig(String tenantId, String name) {
        return null;
    }

    /* (non-Javadoc)
     * @see org.hawkular.btm.api.services.ConfigurationService#removeBusinessTransactionConfig(java.lang.String,
     *                          java.lang.String)
     */
    @Override
    public void removeBusinessTransactionConfig(String tenantId, String name) {
    }

}
