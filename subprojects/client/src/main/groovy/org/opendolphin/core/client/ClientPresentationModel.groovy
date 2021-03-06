/*
 * Copyright 2012-2013 Canoo Engineering AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.opendolphin.core.client

import org.opendolphin.core.BasePresentationModel
import org.opendolphin.core.Tag
import groovy.transform.CompileStatic

@CompileStatic
class ClientPresentationModel extends BasePresentationModel {

    private static final String AUTO_ID_SUFFIX = "-AUTO-ID"
    boolean clientSideOnly = false
    private static long instanceCount = 0

    ClientPresentationModel(List<ClientAttribute> attributes) {
        this(null, attributes)
    }

    /**
     * @param id if id is null or empty, the hashCode will be used
     */
    ClientPresentationModel(String id, List<ClientAttribute> attributes) {
        super(id ?: "" + instanceCount++ + AUTO_ID_SUFFIX, attributes)
        if (id?.endsWith(AUTO_ID_SUFFIX)) {
            throw new IllegalArgumentException("presentation model with self-provided id '$id' may not end with suffix '$AUTO_ID_SUFFIX' since that is reserved.")
        }
    }

    // override with server specific return values to avoid casting in client code

    ClientAttribute getAt(String propertyName) {
        return (ClientAttribute) super.getAt(propertyName)
    }

    ClientAttribute getAt(String propertyName, Tag tag) {
        return (ClientAttribute) super.getAt(propertyName, tag)
    }
}
