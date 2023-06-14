/*
 * Copyright (c) 2023, WSO2 LLC. (http://www.wso2.com) All Rights Reserved.
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.ballerina.stdlib.constraint.validators.interfaces;

import io.ballerina.runtime.api.values.BMap;
import io.ballerina.runtime.api.values.BString;
import io.ballerina.stdlib.constraint.ConstraintErrorInfo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static io.ballerina.stdlib.constraint.Constants.CONSTRAINT_DATE_OPTION;
import static io.ballerina.stdlib.constraint.Constants.FUTURE;
import static io.ballerina.stdlib.constraint.Constants.FUTURE_DATE;
import static io.ballerina.stdlib.constraint.Constants.FUTURE_OR_PRESENT;
import static io.ballerina.stdlib.constraint.Constants.FUTURE_OR_PRESENT_DATE;
import static io.ballerina.stdlib.constraint.Constants.MESSAGE;
import static io.ballerina.stdlib.constraint.Constants.PAST;
import static io.ballerina.stdlib.constraint.Constants.PAST_DATE;
import static io.ballerina.stdlib.constraint.Constants.PAST_OR_PRESENT;
import static io.ballerina.stdlib.constraint.Constants.PAST_OR_PRESENT_DATE;
import static io.ballerina.stdlib.constraint.Constants.VALUE;

/**
 * The interface to validate the date related constraints.
 */
public interface DateValidator {

    default void validate(Map.Entry<BString, Object> constraint, LocalDate date, boolean isMemberValue,
                          List<ConstraintErrorInfo> failedConstraints, String path) {
        if (constraint.getKey().getValue().equals(CONSTRAINT_DATE_OPTION)) {
            Object constraintValue = constraint.getValue();
            String message = null;
            if (constraintValue instanceof BMap) {
                message = ((BMap) constraintValue).getStringValue(MESSAGE).getValue();
                constraintValue = ((BMap) constraintValue).get(VALUE);
            }
            switch (constraintValue.toString()) {
                case PAST:
                    if (!validateIsPastDate(date)) {
                        failedConstraints.add(new ConstraintErrorInfo(path, message, PAST_DATE, isMemberValue));
                    }
                    break;
                case PAST_OR_PRESENT:
                    if (!validateIsPastOrPresentDate(date)) {
                        failedConstraints.add(new ConstraintErrorInfo(path, message, PAST_OR_PRESENT_DATE,
                                isMemberValue));
                    }
                    break;
                case FUTURE:
                    if (!validateIsFutureDate(date)) {
                        failedConstraints.add(new ConstraintErrorInfo(path, message, FUTURE_DATE, isMemberValue));
                    }
                    break;
                case FUTURE_OR_PRESENT:
                    if (!validateIsFutureOrPresentDate(date)) {
                        failedConstraints.add(new ConstraintErrorInfo(path, message, FUTURE_OR_PRESENT_DATE,
                                isMemberValue));
                    }
                    break;
                default:
                    break;
            }
        }
    }

    static boolean validateIsPastDate(LocalDate date) {
        return date.isBefore(LocalDate.now());
    }

    static boolean validateIsPastOrPresentDate(LocalDate date) {
        return date.isBefore(LocalDate.now()) || date.isEqual(LocalDate.now());
    }

    static boolean validateIsFutureDate(LocalDate date) {
        return date.isAfter(LocalDate.now());
    }

    static boolean validateIsFutureOrPresentDate(LocalDate date) {
        return date.isAfter(LocalDate.now()) || date.isEqual(LocalDate.now());
    }
}
