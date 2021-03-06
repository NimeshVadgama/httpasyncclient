/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */
package org.apache.http.nio.client.util;

import java.io.IOException;

import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.nio.client.HttpAsyncClient;

/**
 * Static helpers for dealing with {@link HttpAsyncClient}.
 */
public class HttpAsyncClientUtils {

    private HttpAsyncClientUtils() {
    }

    /**
     * Unconditionally close a httpAsyncClient. Shuts down the underlying
     * connection manager and releases the resources.
     * <p>
     * Example Code:
     *
     * <pre>
     * HttpAsyncClient httpAsyncClient = null;
     * try {
     *   httpAsyncClient = ...;
     * } catch (Exception e) {
     *   // error handling
     * } finally {
     *   HttpAsyncClientUtils.closeQuietly(httpAsyncClient);
     * }
     * </pre>
     *
     * @param httpAsyncClient
     *            the HttpAsyncClient to close, may be null or already closed.
     */
    public static void closeQuietly(final CloseableHttpAsyncClient httpAsyncClient) {
        if (httpAsyncClient != null) {
            try {
                httpAsyncClient.close();
            } catch (final IOException e) {
            }
        }
    }

    @Deprecated
    public static void closeQuietly(final HttpAsyncClient httpAsyncClient) {
        if (httpAsyncClient != null) {
            try {
                httpAsyncClient.shutdown();
            } catch (final InterruptedException e) {
            }
        }
    }
}
