package mqtt;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Mensagem 
{   
	MqttClient client = null;
	MqttConnectOptions connOpts = new MqttConnectOptions();
	MemoryPersistence persistence = new MemoryPersistence();
	
	public void Enviar(String topico,String mensagem)
    {
		try 
	    {
	    	String broker = "tcp://broker.hivemq.com";
	       	    	
	        this.client = new MqttClient(broker, "", persistence);
	        
	        connOpts.setCleanSession(true);
	
	        client.connect(connOpts);
	       
	        // Inscreva-se em um tópico
	        client.subscribe(topico);
	        
	        // QoS (Quality of Service) 0: pelo menos uma vez, 1: pelo menos uma vez com confirmação, 2: exatamente uma vez
	        int qos = 0;
	        
	        // Publicar a mensagem
	        client.publish(topico, mensagem.getBytes(), qos, false);
	     
	        // Defina o callback para lidar com as mensagens recebidas
	        client.setCallback(new MqttCallback() 
	        {
	            @Override
	            public void connectionLost(Throwable cause) {
	            	System.out.println("Conexão perdida: \n" + cause.toString());
	            }
	
	            @Override
	            public void messageArrived(String topic, MqttMessage message) throws Exception {
	                System.out.println(topic);
	                System.out.println(new String(message.getPayload()));
	            }
	
	            @Override
	            public void deliveryComplete(IMqttDeliveryToken token) {
	                // Este método é chamado quando a entrega da mensagem é bem-sucedida.
	            }
	        });
	
	       
	
	    } catch (MqttException me) 
	    {
	        System.out.println("Exceção ao conectar ao broker: " + me.getMessage());
	        me.printStackTrace();
	    } 
		
    }
}