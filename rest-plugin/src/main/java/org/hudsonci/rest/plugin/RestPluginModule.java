/*******************************************************************************
 *
 * Copyright (c) 2010-2011 Sonatype, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: 
 *
 *   
 *     
 *
 *******************************************************************************/ 

package org.hudsonci.rest.plugin;

import com.google.inject.AbstractModule;
import org.codehaus.jackson.map.ObjectMapper;
import org.hudsonci.rest.common.ObjectMapperProvider;
import javax.inject.Named;

/**
 * Additional Guice bindings for the REST plugin.
 *
 * @author <a href="mailto:jason@planet57.com">Jason Dillon</a>
 * @since 2.1.0
 */
@Named
public class RestPluginModule
    extends AbstractModule
{
    @Override
    protected void configure() {
        bind(ObjectMapper.class).toProvider(ObjectMapperProvider.class);
    }
}
