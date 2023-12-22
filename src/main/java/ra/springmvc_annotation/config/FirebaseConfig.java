package ra.springmvc_annotation.config;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.StorageOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.cloud.storage.Storage;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Configuration
public class FirebaseConfig {
    private final String firebaseConfigPath = "/Users/suongtran/Desktop/SpringMVC_Annotation/src/main/resources/firebase-config.json";

    @Bean
    public Storage storage() throws IOException{
        InputStream serviceAccount = Files.newInputStream(Paths.get(firebaseConfigPath));
        return StorageOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build()
                .getService();
    }

}
