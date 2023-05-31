package org.acme;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import io.quarkus.logging.Log;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/blobprocessor")
public class BlobResource {

    @POST
    public void run(Input input) {
        if (input != null) {
            String file = new String(Base64.getDecoder().decode(input.Data.file), StandardCharsets.UTF_8);

            Log.info(file);

            Log.info(input.Metadata.name);
            Log.info(input.Metadata.Uri);
        }
    }

}
