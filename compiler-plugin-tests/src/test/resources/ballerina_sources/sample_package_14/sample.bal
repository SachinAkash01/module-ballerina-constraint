// Copyright (c) 2022, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
//
// WSO2 Inc. licenses this file to you under the Apache License,
// Version 2.0 (the "License"); you may not use this file except
// in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

import ballerina/constraint;

type Foo record {
    @constraint:Float {
        minValue: {
            value: 1,
            message: "Value should be greater than 1"
        },
        minValueExclusive: 0
    }
    float value1;
    @constraint:Float {
        maxValue: 10,
        maxValueExclusive: {
            value: 11,
            message: "Value should be less than 11"
        }
    }
    float value2;
};

@constraint:Float {
    minValue: 1,
    minValueExclusive: 0
}
type FloatType1 float;

@constraint:Float {
    maxValue: 10,
    maxValueExclusive: 11
}
type FloatType2 float;
