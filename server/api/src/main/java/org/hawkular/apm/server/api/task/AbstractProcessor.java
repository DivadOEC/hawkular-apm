/*
 * Copyright 2015-2016 Red Hat, Inc. and/or its affiliates
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
package org.hawkular.apm.server.api.task;

import java.util.List;

import org.hawkular.apm.api.utils.PropertyUtil;

/**
 * This abstract class represents the base class for processors.
 *
 * @author gbrown
 */
public abstract class AbstractProcessor<T, R> implements Processor<T,R> {

    /**  */
    private static final int DEFAULT_RETRY_DELAY = 2000;

    /**  */
    private static final int DEFAULT_LAST_RETRY_DELAY = 10000;

    private long retryDelay = PropertyUtil.getPropertyAsInteger(PropertyUtil.HAWKULAR_APM_PROCESSOR_RETRY_DELAY,
            DEFAULT_RETRY_DELAY);

    private long lastRetryDelay = PropertyUtil.getPropertyAsInteger(
            PropertyUtil.HAWKULAR_APM_PROCESSOR_LAST_RETRY_DELAY, DEFAULT_LAST_RETRY_DELAY);

    private ProcessorType type;

    /**
     * This constructor initialises the type of the processor.
     *
     * @param type The type
     */
    public AbstractProcessor(ProcessorType type) {
        this.type = type;
    }

    /* (non-Javadoc)
     * @see org.hawkular.apm.server.api.task.Processor#getType()
     */
    @Override
    public org.hawkular.apm.server.api.task.Processor.ProcessorType getType() {
        return type;
    }

    /* (non-Javadoc)
     * @see org.hawkular.apm.server.api.task.Processor#initialise(java.lang.String,java.util.List)
     */
    @Override
    public void initialise(String tenantId, List<T> items) throws RetryAttemptException {
    }

    /* (non-Javadoc)
     * @see org.hawkular.apm.server.api.task.Processor#getDeliveryDelay(java.util.List)
     */
    @Override
    public long getDeliveryDelay(List<R> results) {
        return 0;
    }

    /* (non-Javadoc)
     * @see org.hawkular.apm.server.api.task.Processor#getRetryDelay(java.util.List, int)
     */
    @Override
    public long getRetryDelay(List<T> items, int retryCount) {
        if (retryCount == 0) {
            return lastRetryDelay;
        }
        return retryDelay;
    }

    /* (non-Javadoc)
     * @see org.hawkular.apm.server.api.task.Processor#processOneToOne(java.lang.String, java.lang.Object)
     */
    @Override
    public R processOneToOne(String tenantId, T item) throws RetryAttemptException {
        return null;
    }

    /* (non-Javadoc)
     * @see org.hawkular.apm.server.api.task.Processor#processOneToMany(java.lang.String, java.lang.Object)
     */
    @Override
    public List<R> processOneToMany(String tenantId, T item) throws RetryAttemptException {
        return null;
    }

    /* (non-Javadoc)
     * @see org.hawkular.apm.server.api.task.Processor#processManyToMany(java.lang.String, java.util.List)
     */
    @Override
    public List<R> processManyToMany(String tenantId, List<T> items) throws RetryAttemptException {
        return null;
    }

    /* (non-Javadoc)
     * @see org.hawkular.apm.server.api.task.Processor#cleanup(java.lang.String,java.util.List)
     */
    @Override
    public void cleanup(String tenantId, List<T> items) {
    }

}
