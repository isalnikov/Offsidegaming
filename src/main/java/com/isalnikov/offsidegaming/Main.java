package com.isalnikov.offsidegaming;

/**
 *
 * @author isalnikov
 */
import com.isalnikov.offsidegaming.model.Client;
import com.isalnikov.offsidegaming.model.DeviceData;
import com.isalnikov.offsidegaming.service.ClientService;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private ClientService clientService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        log.info("SpringApplication run...");
        
        Client client = new Client();
        client.addValue(new DeviceData(1L, 2L, 3L));
        client.addValue(new DeviceData(4L, 5L, 6L));
        clientService.save(client);

        client = new Client();
        client.addValue(new DeviceData(7L, 8L, 9L));
        client.addValue(new DeviceData(10L, 11L, 12L));

        clientService.save(client);

        List<Client> list = clientService.findAll();
        list.stream().map((client_) -> clientService.findAllDataByClientId(client_.getId())).forEachOrdered((client_) -> {
            client_.getValues().forEach(log::info);
        });

    }
}
