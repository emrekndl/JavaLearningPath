
==========================
JavaLearningPath: Day4
==========================

Bu proje, Spring Framework kullanarak IoC (Inversion of Control) ve Dependency Injection (Bağımlılık Enjeksiyonu) konularını kapsamlı bir şekilde ele alır. Proje, Spring'in temel yapılandırmalarını ve farklı enjeksiyon yöntemlerini gösterir.

Dizin Yapısı
------------
.. code-block::

    day4/
    ├── bin
    ├── lib
    │   ├── commons-logging-1.3.4.jar
    │   ├── spring-aop-6.1.12.jar
    │   ├── spring-beans-6.1.12.jar
    │   ├── spring-context-6.1.12.jar
    │   ├── spring-core-6.1.12.jar
    │   ├── spring-expression-6.1.12.jar
    │   └── spring-jdbc-6.1.12.jar
    ├── README.rst
    ├── src
    │   ├── applicationContext.xml
    │   ├── com
    │   │   └── part2
    │   │       ├── applicationContext.xml
    │   │       ├── CustomerManager.java
    │   │       ├── ICustomerDal.java
    │   │       ├── ICustomerService.java
    │   │       ├── IoCConfig.java
    │   │       ├── Main.java
    │   │       ├── MssqlCustomerDal.java
    │   │       └── MysqlCustomerDal.java
    │   ├── CustomerDal.java
    │   ├── CustomerManager.java
    │   ├── ICustomerDal.java
    │   ├── ICustomerService.java
    │   ├── Main.java
    │   └── MysqlCustomerDal.java
    └── values.properties

Konular
-------
Bu projede aşağıdaki konular işlenmiştir:

1. **IoC ve Dependency Injection Nedir?**
   - IoC (Inversion of Control), nesne bağımlılıklarının dış kaynaklar tarafından yönetilmesidir. Dependency Injection, bu bağımlılıkların otomatik olarak sağlanmasını sağlar, böylece kodun esnekliği ve test edilebilirliği artar.

2. **Constructor Arg İle İç İçe Bağımlılık Çözümü**
   - Constructor argümanları kullanarak, bir sınıfın bağımlılıklarını oluşturulma anında sağlamayı anlatır. Constructor üzerinden bağımlılıkları çözerek daha yapılandırılmış ve test edilebilir kod elde edilir.

   - Örnek dosya: `src/CustomerManager.java`, `src/applicationContext.xml`, `src/Main.java`

3. **Setter Injection**
   - Setter metodları kullanarak bağımlılıkların nasıl enjekte edileceğini açıklar. Bu yöntem, bağımlılıkların sınıfın setter metodları aracılığıyla sağlanmasını sağlar.

   - Örnek dosya: `src/CustomerManager.java`

4. **Metinsel Değerler ile Injection**
   - Metinsel değerlerin `@Value` anotasyonu ile nasıl enjekte edileceğini gösterir. Bu yöntemle, sınıflara dış kaynaklardan değerler aktarılır.

   - Örnek dosya: `src/applicationContext.xml`

5. **Properties Dosyasıyla Injection**
   - Dış konfigürasyon dosyaları (properties) kullanarak değerlerin nasıl yönetileceğini ve enjekte edileceğini açıklar. Bu, uygulamanın yapılandırılabilirliğini artırır.

   - Örnek dosya: `src/values.properties`

6. **Annotation Bazlı Injection**
   - Spring anotasyonları ile bağımlılık yönetimini anlatır. `@Autowired` gibi anotasyonlar, bağımlılıkların otomatik olarak enjekte edilmesini sağlar.

   - Örnek dosya: `src/MssqlCustomerDal.java`

7. **Class Config Dosyası**
   - XML yerine Java sınıf tabanlı konfigürasyon kullanarak bean'lerin nasıl yapılandırılacağını gösterir. Bu, daha modern ve tip güvenli bir konfigürasyon yöntemidir.

   - Örnek dosya: `src/com/part2/IoCConfig.java`

8. **Class Config İçinde Bean Tanımlamak**
   - Java sınıf konfigürasyonunda bean'lerin nasıl tanımlanacağını açıklar. Bean'ler, sınıf konfigürasyonları ile yönetilir ve yapılandırılır.

   - Örnek dosya: `src/com/part2/IoCConfig.java`

9. **Bağlı Classların Çözümlenmesi**
   - Spring konteynerinde bağlı sınıfların nasıl çözümleneceğini ve kullanılacağını anlatır. Bu süreç, uygulama bileşenlerinin nasıl bağlandığını ve çalıştığını gösterir.

   - Örnek dosya: `src/com/part2/Main.java`

10. **Class Config İle Property Injection**
    - Java sınıf konfigürasyonları kullanarak property enjeksiyonunun nasıl yapılacağını açıklar. Bu, bean'lere dinamik değerlerin atanmasını sağlar.

    - Örnek dosya: `src/com/part2/IoCConfig.java`

Kurulum ve Çalıştırma
---------------------
1. **Dizin İçeriğini Klonlayın:**
   Projeyi GitHub üzerinden klonlayarak aşağıdaki komutu kullanabilirsiniz:

   .. code-block:: bash

       git clone https://github.com/emrekndl/JavaLearningPath.git
       cd JavaLearningPath/day4

2. **Gerekli Bağımlılıkları İndirin:**
   `lib/` klasöründe bulunan Spring kütüphanelerini projenize ekleyin.

3. **Spring Container'ı Çalıştırın:**
   Spring IoC yapılandırmasını uygulamak için gerekli Java dosyalarını derleyin ve çalıştırın. Spring konteynerini başlatmak için `Main` sınıfını çalıştırın:

   .. code-block:: bash

       javac -d bin src/**/*.java
       java -cp "bin:lib/*" com.part2.Main

Notlar
-------
- `values.properties` dosyasında belirtilen konfigürasyon değerleri, `applicationContext.xml` ve `IoCConfig.java` dosyaları aracılığıyla Spring konteynerine sağlanmaktadır.
- `src` dizinindeki dosyalar, Spring IoC yapılandırmaları ve bean tanımlamaları için örnekler içermektedir. `CustomerManager` ve `MssqlCustomerDal` sınıfları, Spring'in dependency injection yeteneklerini nasıl kullanabileceğinizi gösterir.
