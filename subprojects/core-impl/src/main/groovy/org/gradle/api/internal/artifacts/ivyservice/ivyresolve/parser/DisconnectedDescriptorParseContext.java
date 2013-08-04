/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.api.internal.artifacts.ivyservice.ivyresolve.parser;

import org.apache.ivy.core.module.descriptor.Artifact;
import org.apache.ivy.core.module.descriptor.DefaultModuleDescriptor;
import org.apache.ivy.core.module.descriptor.ModuleDescriptor;
import org.apache.ivy.core.module.id.ModuleRevisionId;

import java.text.ParseException;
import java.util.Date;

/**
 * An implementation of {@link DescriptorParseContext} that is useful for parsing an ivy.xml file without attempting to download
 * other resources from a DependencyResolver.
 */
public class DisconnectedDescriptorParseContext extends AbstractDescriptorParseContext {
    public DisconnectedDescriptorParseContext() {
        super("integration");
    }

    public ModuleDescriptor getModuleDescriptor(ModuleRevisionId mRevId) throws ParseException {
        return new DefaultModuleDescriptor(mRevId, "release", new Date());
    }

    public boolean artifactExists(Artifact artifact) {
        return false;
    }

    public ModuleRevisionId getCurrentRevisionId() {
        throw new UnsupportedOperationException();
    }
}