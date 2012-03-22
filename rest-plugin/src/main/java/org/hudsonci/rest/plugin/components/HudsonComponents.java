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

package org.hudsonci.rest.plugin.components;

import org.hudsonci.rest.api.admin.AdminResource;
import org.hudsonci.rest.api.build.BuildResource;
import org.hudsonci.rest.api.node.NodeResource;
import org.hudsonci.rest.api.project.ProjectResource;
import org.hudsonci.rest.api.project.ProjectsResource;
import org.hudsonci.rest.api.queue.QueueResource;
import org.hudsonci.rest.api.user.UserResource;
import org.hudsonci.rest.plugin.RestComponentProvider;

import javax.inject.Named;
import javax.inject.Singleton;


/**
 * Provides Hudson-specific REST components.
 *
 * @author <a href="mailto:jason@planet57.com">Jason Dillon</a>
 * @since 2.1.0
 */
@Named
@Singleton
public class HudsonComponents
    extends RestComponentProvider
{
    @Override
    public Class<?>[] getClasses() {
        return new Class[] {
            AdminResource.class,
            BuildResource.class,
            ProjectsResource.class,
            NodeResource.class,
            QueueResource.class,
            UserResource.class,
            
            //
            // WORK AROUND: This is added to test by UUID reference bits, should eventually only allow one method.
            //
            ProjectResource.class,
        };
    }
}
