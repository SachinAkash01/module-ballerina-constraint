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
        minValue: 0,
        maxValue: 10
    }
    () n;
    @constraint:Float {
        minValue: 0,
        maxValue: 10
    }
    boolean b;
    @constraint:Float {
        minValue: 0,
        maxValue: 10
    }
    int i;
    @constraint:Float {
        minValue: 0,
        maxValue: 10
    }
    float f;
    @constraint:Float {
        minValue: 0,
        maxValue: 10
    }
    decimal d;
    @constraint:Float {
        minValue: 0,
        maxValue: 10
    }
    string s;
    @constraint:Float {
        minValue: 0,
        maxValue: 10
    }
    xml x;
    @constraint:Float {
        minValue: 0,
        maxValue: 10
    }
    anydata[] a;
    @constraint:Float {
        minValue: 0,
        maxValue: 10
    }
    map<anydata> m;
    @constraint:Float {
        minValue: 0,
        maxValue: 10
    }
    table<map<anydata>> t;
};

@constraint:Float {
    minValue: 0,
    maxValue: {
        value: 10,
        message: "Max value should be 10"
    }
}
type NilType ();

@constraint:Float {
    minValue: 0,
    maxValue: 10
}
type BooleanType boolean;

@constraint:Float {
    minValue: 0,
    maxValue: 10
}
type IntType int;

@constraint:Float {
    minValue: 0,
    maxValue: 10
}
type FloatType float;

@constraint:Float {
    minValue: {
        value: 0,
        message: "Min value should be 0"
    },
    maxValue: 10
}
type DecimalType decimal;

@constraint:Float {
    minValue: 0,
    maxValue: 10
}
type StringType string;

@constraint:Float {
    minValue: 0,
    maxValue: 10
}
type XmlType xml;

@constraint:Float {
    minValue: 0,
    maxValue: 10
}
type ArrayType anydata[];

@constraint:Float {
    minValue: 0,
    maxValue: 10
}
type MapType map<anydata>;

@constraint:Float {
    minValue: 0,
    maxValue: 10
}
type TableType table<map<anydata>>;
