/*
 * Copyright (c) 2022, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.ballerina.stdlib.constraint.compiler;

import io.ballerina.projects.DiagnosticResult;
import io.ballerina.projects.Package;
import io.ballerina.projects.ProjectEnvironmentBuilder;
import io.ballerina.projects.directory.BuildProject;
import io.ballerina.projects.environment.Environment;
import io.ballerina.projects.environment.EnvironmentBuilder;
import io.ballerina.tools.diagnostics.Diagnostic;
import org.testng.Assert;

import java.nio.file.Path;
import java.nio.file.Paths;

import static io.ballerina.stdlib.constraint.compiler.ConstraintDiagnosticCodes.CONSTRAINT_101;
import static io.ballerina.stdlib.constraint.compiler.ConstraintDiagnosticCodes.CONSTRAINT_102;
import static io.ballerina.stdlib.constraint.compiler.ConstraintDiagnosticCodes.CONSTRAINT_103;
import static io.ballerina.stdlib.constraint.compiler.ConstraintDiagnosticCodes.CONSTRAINT_104;

/**
 * Utility functions related to compiler plugins tests.
 */
public final class CompilerPluginTestUtils {

    private CompilerPluginTestUtils() {}

    private static final Path RESOURCE_DIRECTORY = Paths.get("src", "test", "resources", "ballerina_sources")
            .toAbsolutePath();
    private static final Path DISTRIBUTION_PATH = Paths.get("../", "target", "ballerina-runtime")
            .toAbsolutePath();

    static Package loadPackage(String path) {
        Path projectDirPath = RESOURCE_DIRECTORY.resolve(path);
        Environment environment = EnvironmentBuilder.getBuilder().setBallerinaHome(DISTRIBUTION_PATH).build();
        ProjectEnvironmentBuilder projectEnvironmentBuilder = ProjectEnvironmentBuilder.getBuilder(environment);
        BuildProject project = BuildProject.load(projectEnvironmentBuilder, projectDirPath);
        return project.currentPackage();
    }

    static void assertError101(DiagnosticResult diagnosticResult, int index, String annotationTag, String fieldType) {
        Diagnostic diagnostic = (Diagnostic) diagnosticResult.errors().toArray()[index];
        Assert.assertEquals(diagnostic.diagnosticInfo().messageFormat(),
                String.format(CONSTRAINT_101.getMessage(), annotationTag, fieldType));
        Assert.assertEquals(diagnostic.diagnosticInfo().code(), CONSTRAINT_101.getCode());
    }

    static void assertError102(DiagnosticResult diagnosticResult, int index, String annotationTag, String fieldType) {
        Diagnostic diagnostic = (Diagnostic) diagnosticResult.errors().toArray()[index];
        Assert.assertEquals(diagnostic.diagnosticInfo().messageFormat(),
                String.format(CONSTRAINT_102.getMessage(), annotationTag, fieldType));
        Assert.assertEquals(diagnostic.diagnosticInfo().code(), CONSTRAINT_102.getCode());
    }

    static void assertError103(DiagnosticResult diagnosticResult, int index, String annotationTag, String fieldType) {
        Diagnostic diagnostic = (Diagnostic) diagnosticResult.errors().toArray()[index];
        Assert.assertEquals(diagnostic.diagnosticInfo().messageFormat(),
                String.format(CONSTRAINT_103.getMessage(), annotationTag, fieldType));
        Assert.assertEquals(diagnostic.diagnosticInfo().code(), CONSTRAINT_103.getCode());
    }

    static void assertError104(DiagnosticResult diagnosticResult, int index, String annotationTag, String fieldName) {
        Diagnostic diagnostic = (Diagnostic) diagnosticResult.errors().toArray()[index];
        Assert.assertEquals(diagnostic.diagnosticInfo().messageFormat(),
                String.format(CONSTRAINT_104.getMessage(), fieldName, annotationTag));
        Assert.assertEquals(diagnostic.diagnosticInfo().code(), CONSTRAINT_104.getCode());
    }
}
