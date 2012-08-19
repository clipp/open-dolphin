package com.canoo.dolphin.demo

import com.canoo.dolphin.LogConfig
import com.canoo.dolphin.core.client.ClientDolphin
import com.canoo.dolphin.core.client.ClientModelStore
import com.canoo.dolphin.core.client.comm.HttpClientConnector
import com.canoo.dolphin.core.client.comm.JavaFXUiThreadHandler

LogConfig.logCommunication()
def dolphin = new ClientDolphin()
dolphin.setClientModelStore(new ClientModelStore(dolphin))
def connector = new HttpClientConnector(dolphin, "http://localhost:8080/dolphin-grails")
connector.uiThreadHandler = new JavaFXUiThreadHandler()
dolphin.setClientConnector(connector)

PushView.show(dolphin)
