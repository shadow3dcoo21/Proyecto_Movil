package com.example.nuevo_proyecto

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.eclipse.paho.client.mqttv3.MqttAsyncClient
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.MqttException
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence


enum class EstadoFoco {
    APAGADO, ENCENDIDO
}
class EjemploViewModel : ViewModel() {
    private val brokerUri = "ws://161.132.41.45:9001"
    private val clientId = "AndroidClient"
    private val topic1 = "esp/led1"
    private val topic2 = "esp/led2"
    private val topic3 = "esp/led3"
    private val topic4 = "esp/alarma"
    private val encendido = "1"
    private val apagado = "0"

    var estadoFoco1: EstadoFoco = EstadoFoco.APAGADO
        private set

    private var estadoFoco2 = EstadoFoco.APAGADO
    private var estadoFoco3 = EstadoFoco.APAGADO


    private val mqttClient: MqttAsyncClient by lazy {
        MqttAsyncClient(brokerUri, clientId, MemoryPersistence())
    }

    init {
        connectToMqtt()
    }
















    private fun connectToMqtt() {
        try {
            val options = MqttConnectOptions()
            options.isCleanSession = true
            options.connectionTimeout = 60

            mqttClient.connect(options)

            // Suscribirse al tema después de la conexión (opcional)
            mqttClient.subscribe(topic1, 0)
            mqttClient.subscribe(topic2, 0)
            mqttClient.subscribe(topic3, 0)
            mqttClient.subscribe(topic4, 0)
        } catch (e: MqttException) {
            e.printStackTrace()
        }
    }


    fun publishMessage(topic: String, message: String) {
        CoroutineScope(Dispatchers.IO).launch {
            mqttClient.publish(topic, message.toByteArray(), 0, false)
        }
    }

    fun publishMessageE(topic: String) {
        val topic = "$topic"
        val message = encendido
        publishMessage(topic, message)
    }

    fun publishMessageA(topic: String) {
        val topic = "$topic"
        val message = apagado
        publishMessage(topic, message)
    }

    fun publishMessageTE() {
        val message = encendido
        publishMessage("esp/led1", message)
        publishMessage("esp/led2", message)
        publishMessage("esp/led3", message)


    }

    fun publishMessageTA() {
        val message = apagado
        publishMessage("esp/led1", message)
        publishMessage("esp/led2", message)
        publishMessage("esp/led3", message)


    }

    override fun onCleared() {
        super.onCleared()
        mqttClient.disconnect()
    }
}
