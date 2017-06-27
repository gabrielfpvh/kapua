/*******************************************************************************
 * Copyright (c) 2011, 2016 Eurotech and/or its affiliates and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.app.console.shared.service;

import org.eclipse.kapua.app.console.commons.client.GwtKapuaException;
import org.eclipse.kapua.app.console.commons.shared.model.GwtSession;
import org.eclipse.kapua.app.console.shared.model.authentication.GwtJwtCredential;
import org.eclipse.kapua.app.console.shared.model.authentication.GwtLoginCredential;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("auth")
public interface GwtAuthorizationService extends RemoteService {

    /**
     * Logins a session based on the given credentials. If credentials are correct a session is established and returned
     * 
     * @param gwtLoginCredentials
     *            The credentials to authenticate
     * @return The session info established.
     * @throws GwtKapuaException
     *             If credentials are not valid.
     * @since 1.0.0
     */
    public GwtSession login(GwtLoginCredential gwtLoginCredentials) throws GwtKapuaException;

    /**
     * Logins a session based on the given access token. If the access token is correct a session is established and returned
     * 
     * @param gwtAccessTokenCredentials
     *            The access token to authenticate
     * @return The session info established.
     * @throws GwtKapuaException
     *             If the access token is not valid.
     * @since 1.0.0
     */
    public GwtSession login(GwtJwtCredential gwtAccessTokenCredentials) throws GwtKapuaException;

    /**
     * Return the currently authenticated user or null if no session has been established.
     * 
     * @return The current active session or null if no session is active.
     * @throws GwtKapuaException
     *             FIXME: document this
     * @since 1.0.0
     */
    public GwtSession getCurrentSession()
            throws GwtKapuaException;

    /**
     * Destroy the current active session.
     * 
     * @throws GwtKapuaException
     *             FIXME: document this
     * @since 1.0.0
     */
    public void logout()
            throws GwtKapuaException;

}