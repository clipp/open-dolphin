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

package org.opendolphin.demo

import org.opendolphin.core.comm.NamedCommand
import org.opendolphin.core.server.action.DolphinServerAction
import org.opendolphin.core.server.comm.ActionRegistry

import static org.opendolphin.core.Tag.MESSAGE
import static org.opendolphin.demo.MyProps.ATT.*
import static org.opendolphin.demo.MyProps.CMD.*
import static org.opendolphin.demo.MyProps.PM_ID.*


class DemoTitlePurposeAction extends DolphinServerAction {

    void registerIn(ActionRegistry registry) {

        serverDolphin.action SET_TITLE, { NamedCommand command, response ->
            def title = serverDolphin[MOLD][TITLE]
            changeValue title, title.value + " new from server"
            changeValue serverDolphin[MOLD][TITLE, MESSAGE], "changed on server"
        }

        serverDolphin.action SET_PURPOSE, { NamedCommand command, response ->
            def purpose = serverDolphin[MOLD][PURPOSE]
            changeValue purpose, purpose.value + " new from server"
        }

    }
}
