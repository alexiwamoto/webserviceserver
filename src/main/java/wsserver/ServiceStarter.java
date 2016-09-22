package wsserver;

import javax.xml.ws.Endpoint;

public class ServiceStarter {

    public static void main(String[] args) {

        String url = "http://localhost:1212/storage";

        Endpoint.publish(url, new BookStorage());

        System.out.println("Service started @ " + url);

    }

}
