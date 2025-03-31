package tobyspring.hellospring.api;

import java.io.IOException;
import java.net.URI;


public interface ApiExecutor {

    String extractExRate(URI uri) throws IOException;
}
