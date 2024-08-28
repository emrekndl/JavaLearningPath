# Maven Projesi Bilgileri

Bu belge, Maven projelerinin nasıl çalıştırılacağı ve debug yapılacağı hakkında temel bilgileri sağlar.

## Proje Oluşturma

Yeni bir Maven projesi oluşturmak için şu komutu kullanabilirsiniz:

.. code-block:: bash

   mvn archetype:generate -DgroupId=com.example -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

Bu komut, `com.example` grubuna ve `my-app` adına sahip bir Maven projesi oluşturur. `maven-archetype-quickstart` arketipi, temel bir Java projesi için yapılandırılmıştır.

## Projenin Derlenmesi ve Çalıştırılması

1. **Projeyi Derleme**
   Projeyi derlemek için şu komutu kullanın:
   .. code-block:: bash

      mvn compile

2. **Maven ile `exec:java` Kullanarak Çalıştırma**

   Maven'ın `exec-maven-plugin` kullanarak ana sınıfı çalıştırabilirsiniz. `pom.xml` dosyasında `exec-maven-plugin` yapılandırıldığından emin olun ve şu komutu kullanın:

   .. code-block:: bash

      mvn exec:java -Dexec.mainClass="com.example.Main"

3. **Maven ile `package` ve `java -jar` Kullanarak Çalıştırma**

   Projeyi bir JAR dosyasına paketledikten sonra, bu JAR dosyasını çalıştırabilirsiniz:

   .. code-block:: bash

      mvn package

   Oluşan JAR dosyasını çalıştırmak için:

   .. code-block:: bash

      java -jar target/my-app-1.0.jar

4. **Maven ile `compile` ve `java` Kullanarak Çalıştırma**

   Projeyi `mvn compile` ile derledikten sonra, ana sınıfı şu şekilde çalıştırabilirsiniz:

   .. code-block:: bash

      java -cp target/classes com.example.Main

## Build ve Source Sürümlerini Değiştirme

    `pom.xml` dosyasında build ve source sürümlerini değiştirmek için, aşağıdaki yapılandırmayı ekleyebilirsiniz:

    .. code-block:: xml

       <properties>
       <maven.compiler.source>1.8</maven.compiler.source>
       <maven.compiler.target>1.8</maven.compiler.target>
       </properties>

    Bu örnekte, Java sürümünü 8 olarak belirlenmiştir. İhtiyacınıza göre bu değerleri değiştirebilirsiniz.

## Debug Yapma

1. **Maven ile `mvnDebug` Kullanarak Debug Yapma**

   Maven'ı debug modunda başlatmak için:

   .. code-block:: bash

      mvnDebug test

   Bu komut, Maven'ı debug portu (varsayılan olarak 8000) ile başlatır.

2. **IDE Üzerinden Debug Yapma**

   IDE kullanıyorsanız, Maven projelerini debug modunda çalıştırabilirsiniz:

   - **IntelliJ IDEA**
     - Run/Debug Configurations menüsüne gidin ve yeni bir Maven konfigürasyonu oluşturun.
     - Command Line sekmesine gerekli hedefleri ekleyin ve Debug seçeneğini kullanın.

   - **Eclipse**
     - Projeyi sağ tıklayın ve `Debug As -> Maven build` seçeneğini seçin.
     - Goals kısmına gerekli hedefleri yazın ve Debug düğmesine basın.

3. **Bağımsız Java Uygulaması İçin Debug Yapma**

   Derlenmiş sınıfları doğrudan debug modunda çalıştırabilirsiniz:

   .. code-block:: bash

      java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000 -cp target/classes com.example.Main

   Bu komut JVM'i debug modunda başlatır ve `address=8000` debug portunu belirtir.

## Ekstra Notlar

- **`mvn dependency:resolve`**: Projenizin bağımlılıklarını indirir ve çözümlemesini yapar. Bağımlılıkların doğru bir şekilde indirildiğinden emin olmak için bu komutu kullanabilirsiniz.
- **`mvn clean`**: Projeyi temizler, hedef (target) dizinini siler ve önceki derlemeleri temizler.
- **`mvn test`**: Testleri çalıştırır, test kodlarını derler ve testleri yürütür.
- **`mvn install`**: Projeyi kurar, bağımlılıkları indirir ve derlenmiş projeyi yerel Maven deposuna ekler.

Bu belge, Maven projeleri oluşturma, derleme, çalıştırma, build ve source sürümlerini değiştirme, sürüm ekleme ve debug yapma konularını kapsamlı bir şekilde içerir. Başka bir ekleme veya değişiklik yapmamı isterseniz, lütfen belirtin!
