import java.util.Properties;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import java.io.*;
public class Producer 

{
	    public static void main(String args[]) throws Exception 
	    {
		      RandomAccessFile in = new RandomAccessFile("/home/local/ZOHOCORP/tejas-pt6441/Sample.txt", "r");
		      String line;
		      while(true) 
		      {
		         if((line = in.readLine()) != null) 
		         {
		            Push(line);
		         } else 
		         {
		            Thread.sleep(2000);
		         }
		      }
		 }
		public static void Push(String fileContent)
	    {
		    String server="localhost:9092";
			Properties props=new Properties();
			props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, server);
			props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
			props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
			KafkaProducer<String,String> myProducer=new KafkaProducer<String,String>(props);
			ProducerRecord<String,String> myrecord=new ProducerRecord<String,String>("Mytopic",fileContent);
			myProducer.send(myrecord);
			myProducer.flush();
			myProducer.close();
	        
	    }
}

