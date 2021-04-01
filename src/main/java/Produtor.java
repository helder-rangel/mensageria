import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Produtor {
    public static void main(String[] args) throws Exception {
        // connectionFactory
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
         // conexao
        String NOME_FILA = "FILA_OLA_PDIST";
        try(
                Connection connection = connectionFactory.newConnection();
                // canal
                Channel canal = connection.createChannel();

                ) {
            canal.queueDeclare(NOME_FILA, false, false, false, null);
            String mensagem = "Tudo bemm contigo?4";

            canal.basicPublish("", NOME_FILA, null, mensagem.getBytes());
            System.out.println("Enviada mensagem: " + mensagem);
        }

        // criar fila
        // enviar mensagem

    }
}
