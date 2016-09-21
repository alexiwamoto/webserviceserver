package wsserver;

import javax.xml.ws.Endpoint;

public class ServiceStarter {

    public static void main(String[] args) {

        String url = "http://localhost:1212/find";

        Endpoint.publish(url, new FindBook());

        System.out.println("Service started @ " + url);

    }

}
