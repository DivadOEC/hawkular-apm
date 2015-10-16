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
package org.hawkular.btm.api.model.config.btxn;

import org.hawkular.btm.api.model.btxn.CorrelationIdentifier;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * This class represents a processing action to be performed on information associated
 * with an instrumentation location.
 *
 * @author gbrown
 */
public class ProcessorAction {

    @JsonInclude(Include.NON_NULL)
    private String description;

    @JsonInclude(Include.NON_NULL)
    private String name;

    @JsonInclude(Include.NON_NULL)
    private String type;

    @JsonInclude(Include.NON_NULL)
    private CorrelationIdentifier.Scope scope;

    @JsonInclude
    private ActionType actionType;

    @JsonInclude(Include.NON_NULL)
    private Expression predicate;

    @JsonInclude
    private Expression expression;

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the scope
     */
    public CorrelationIdentifier.Scope getScope() {
        return scope;
    }

    /**
     * @param scope the scope to set
     */
    public void setScope(CorrelationIdentifier.Scope scope) {
        this.scope = scope;
    }

    /**
     * @return the actionType
     */
    public ActionType getActionType() {
        return actionType;
    }

    /**
     * @param actionType the actionType to set
     */
    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    /**
     * @return the predicate
     */
    public Expression getPredicate() {
        return predicate;
    }

    /**
     * @param predicate the predicate to set
     */
    public void setPredicate(Expression predicate) {
        this.predicate = predicate;
    }

    /**
     * @return the expression
     */
    public Expression getExpression() {
        return expression;
    }

    /**
     * @param expression the expression to set
     */
    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ProcessorAction [description=" + description + ", name=" + name + ", type=" + type + ", scope="
                + scope + ", actionType=" + actionType + ", predicate=" + predicate + ", expression=" + expression
                + "]";
    }

    /**
     * This enumerated type identifies the types of action that
     * can be performed.
     *
     * @author gbrown
     */
    public enum ActionType {

        SetProperty,

        SetDetail,

        SetFault,

        SetFaultDescription,

        AddContent,

        AddCorrelationId
    }
}
