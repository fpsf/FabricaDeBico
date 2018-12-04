package fatec.ads.fabbico.repos;

import fatec.ads.fabbico.ents.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoUsuario extends JpaRepository<Usuario, Long> {

    Usuario findUsuarioByNome(String nome);

    // https://x-team.com/blog/storing-secure-passwords-with-postgresql/
    // https://www.meetspaceapp.com/2016/04/12/passwords-postgresql-pgcrypto.html

    // https://www.mkyong.com/spring-security/spring-security-password-hashing-example/

    // $2y$12$xA4I/qoQ0U4krWVXIe0VV.pPGkf8hL1e.NrSKRTJP6dHYZhUMk4qu == "admin" (12 rounds)

    /*
    https://stackoverflow.com/questions/5245840/how-to-convert-jsonstring-to-jsonobject-in-java
    JSONParser parser = new JSONParser();
    JSONObject json = (JSONObject) parser.parse(stringToParse);
    */

    // https://stackoverflow.com/questions/38916912/how-to-decode-jwt-header-and-body-in-java-using-apache-commons-codec

    /*
        String jwtToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0Iiwicm9sZXMiOiJST0xFX0FETUlOIiwiaXNzIjoibXlzZWxmIiwiZXhwIjoxNDcxMDg2MzgxfQ.1EI2haSz9aMsHjFUXNVz2Z4mtC0nMdZo6bo3-x-aRpw";
        System.out.println("------------ Decode JWT ------------");
        String[] split_string = jwtToken.split("\\.");
        String base64EncodedHeader = split_string[0];
        String base64EncodedBody = split_string[1];
        String base64EncodedSignature = split_string[2];

        System.out.println("~~~~~~~~~ JWT Header ~~~~~~~");
        Base64 base64Url = new Base64(true);
        String header = new String(base64Url.decode(base64EncodedHeader));
        System.out.println("JWT Header : " + header);


        System.out.println("~~~~~~~~~ JWT Body ~~~~~~~");
        String body = new String(base64Url.decode(base64EncodedBody));
        System.out.println("JWT Body : "+body);
    */

}
