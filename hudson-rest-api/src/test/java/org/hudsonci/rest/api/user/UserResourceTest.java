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

package org.hudsonci.rest.api.user;

import hudson.model.User;
import hudson.security.Permission;

import org.hudsonci.service.NodeService;
import org.hudsonci.service.ProjectService;
import org.hudsonci.service.SecurityService;
import org.hudsonci.service.SystemService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import org.hudsonci.rest.api.user.UserConverter;
import org.hudsonci.rest.api.user.UserResource;
import org.hudsonci.rest.model.UserDTO;

@RunWith(MockitoJUnitRunner.class)
public class UserResourceTest
{
    @Mock
    private User hudsonUser;

    @Mock
    private SecurityService securityService;

    @Mock
    private UserConverter userx;

    @Test
    public void testGetUserSecurity()
    {
        when(securityService.getUser("foo")).thenReturn(
                this.hudsonUser);

        UserResource res = new UserResource(securityService,userx);
        UserDTO dto = res.getUser("foo");
        
        verify(this.hudsonUser, times(1)).
                checkPermission(Permission.READ);
    }
}
