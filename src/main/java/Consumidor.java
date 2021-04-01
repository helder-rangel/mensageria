import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Consumidor {
    public static void main(String[] args) throws Exception{
        System.out.println("Consumidor ativo");

        String NOME_FILA = "FILA_OLA_PDIST";

        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        Connection conexao =  connectionFactory.newConnection();
        Channel canal = conexao.createChannel();
        canal.queueDeclare(NOME_FILA, false, false,false, null);

        DeliverCallback callback = (consumerTag, delivery) -> {
          String mensagem = new String(delivery.getBody());
            System.out.println("Recebi mensgem: " + mensagem);
        };

        canal.basicConsume(NOME_FILA, true, callback, consumertag -> {});
    }
}
