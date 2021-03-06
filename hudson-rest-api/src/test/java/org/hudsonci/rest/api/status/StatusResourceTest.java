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

package org.hudsonci.rest.api.status;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import hudson.init.InitMilestone;
import hudson.model.Hudson;

import org.hudsonci.service.NodeService;
import org.hudsonci.service.ProjectService;
import org.hudsonci.service.SecurityService;
import org.hudsonci.service.SystemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import org.hudsonci.rest.api.status.StatusConverter;
import org.hudsonci.rest.api.status.StatusResource;
import org.hudsonci.rest.api.user.UserConverter;
import org.hudsonci.rest.model.InitLevelDTO;
import org.hudsonci.rest.model.StatusDTO;

@RunWith(MockitoJUnitRunner.class)
public class StatusResourceTest
{
    @Mock
    private SystemService systemService;

    @Mock
    private SecurityService securityService;

    @Mock
    private StatusConverter statusx;

    @Mock
    private UserConverter userx;

    private SystemService mockSystemService()
    {
        when(this.systemService.getUrl()).thenReturn(
                "http://localhost:1234");
        when(this.systemService.getInitLevel()).thenReturn(
                InitMilestone.COMPLETED);
        when(this.systemService.getSystemMessage()).thenReturn("OK");
        when(this.systemService.getVersion()).thenReturn("1.1,2010");

        return systemService;
    }

    @Test
    public void testGetStatusSecurity()
    {
        StatusResource res = new StatusResource(mockSystemService(),
                securityService, statusx, userx);
        StatusDTO dto = res.getStatus();
        verify(securityService, Mockito.times(1)).checkPermission(
                Hudson.READ);
    }

}
