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
    @constraint:Array {
        length: 10,
        minLength: {
            value: 8,
            message: "Min length should be 8"
        }
    }
    anydata[] value1;
    @constraint:Array {
        length: {
            value: 10,
            message: "Length should be 10"
        },
        maxLength: 12
    }
    anydata[] value2;
};

@constraint:Array {
    length: {
        value: 10,
        message: "Length should be 10"
    },
    minLength: 8
}
type ArrayType1 anydata[];

@constraint:Array {
    length: 10,
    maxLength: {
        value: 12,
        message: "Max length should be 12"
    }
}
type ArrayType2 anydata[];
