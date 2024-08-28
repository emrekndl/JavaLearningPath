==========================
JavaLearningPath: Day6
==========================

Bu proje, Spring Boot, Hibernate ve JPA kullanılarak geliştirilen katmanlı mimari yapısına sahip bir RESTful API uygulamasıdır. Projede Docker Compose ile MySQL veritabanı kurulumu ve yönetimi de yapılmaktadır.

Projeyi Kurulum ve Çalıştırma
=============================

1. **Proje Kurulumu:**

GitHub'dan projeyi klonlayın:

.. code-block:: bash

    git clone https://github.com/emrekndl/JavaLearningPath.git
    cd JavaLearningPath/day6

2. **MySQL Veritabanı Kurulumu:**

MySQL konteynerini başlatmak ve gerekli veritabanını oluşturmak için aşağıdaki komutu çalıştırın:

.. code-block:: bash

    podman-compose -f compose-mysql.yaml up

Bu komut, `world` veritabanını, veritabanı kullanıcısını ve parolasını oluşturur ve `db-data/world.sql` dosyasındaki verileri yükler.

3. **Maven Kullanarak Projeyi Derleyin:**

.. code-block:: bash

    ./mvnw clean compile

4. **Projeyi Çalıştırın:**

   Spring Boot uygulamasını çalıştırmak için:

.. code-block:: bash

    ./mvnw spring-boot:run

5. **Testleri Çalıştırın:**

   Testleri çalıştırmak için:

.. code-block:: bash

    ./mvnw test

6. **Jar Dosyası Oluşturma ve Çalıştırma:**

   Projenizi bir jar dosyası haline getirin:

.. code-block:: bash

    ./mvnw package

   Daha sonra oluşturulan jar dosyasını çalıştırın:

.. code-block:: bash

    java -jar target/day6-0.0.1-SNAPSHOT.jar

Dizin Yapısı
============

Projede dosya ve dizin yapısı aşağıdaki gibidir:
    .. code-block::

        day6/
        ├── compose-mysql.yaml
        ├── db-data
        │   ├── mysql
        │   └── world.sql
        ├── MavenDemo.rst
        ├── mvnw
        ├── mvnw.cmd
        ├── pom.xml
        ├── README.rst
        ├── src
        │   ├── main
        │   │   ├── java
        │   │   │   └── com
        │   │   │       └── springbootdemo
        │   │   │           └── day6
        │   │   │               ├── business
        │   │   │               │   ├── CityManager.java
        │   │   │               │   └── ICityService.java
        │   │   │               ├── dataAccess
        │   │   │               │   ├── HibernateCityDal.java
        │   │   │               │   └── ICityDal.java
        │   │   │               ├── Day6Application.java
        │   │   │               ├── hibenateJpaEntities
        │   │   │               │   └── City.java
        │   │   │               └── restApi
        │   │   │                   └── CityController.java
        │   │   └── resources
        │   │       ├── application.properties
        │   │       ├── static
        │   │       └── templates
        │   └── test
        │       └── java
        │           └── com
        │               └── springbootdemo
        │                   └── day6
        │                       └── Day6ApplicationTests.java
        └── target

Proje Detayları
===============

Bu proje temel olarak **City** nesnesi üzerine kurulmuştur. `City.java` sınıfı Hibernate entity'si olarak tanımlanmış ve `city` tablosuna karşılık gelir.

REST API Endpoint'leri
----------------------

- **GET /api/cities:** Tüm şehirleri listeler.
- **POST /api/add:** Yeni bir şehir ekler.
- **POST /api/update:** Var olan bir şehri günceller.
- **DELETE /api/delete:** Bir şehri siler.
- **GET /api/cities/{id}:** Belirli bir ID'ye sahip şehri getirir.
  

Spring Boot: Spring REST
------------------------

**REST API Oluşturma ve Yapılandırma**

- **REST API'lerin Oluşturulması:** Spring Boot ile RESTful API geliştirmek için `@RestController` ve `@RequestMapping` anotasyonları kullanılır. `CityController.java` dosyası, API endpoint'lerini tanımlar.
- **DevTools Kullanımı:** Geliştirme sürecinde hızlı yeniden yükleme ve otomatik yeniden başlatma için Spring Boot DevTools kullanılır. Yapılandırma, `pom.xml` dosyasında yer alır.
- **Hibernate ve JPA Entegrasyonu:** Veritabanı işlemleri için Hibernate ve JPA kullanılır. `HibernateCityDal.java` ve `ICityDal.java` dosyaları, veritabanı erişim katmanını oluşturur.
- **Application Properties:** Uygulama yapılandırmaları `application.properties` dosyasında yer alır. Bu dosya, veritabanı bağlantı bilgileri ve diğer konfigürasyonları içerir.
- **Entity Tasarımı:** Hibernate entity'si olarak tanımlanan `City` sınıfı, `hibernateJpaEntities` paketinde bulunur. Bu sınıf `city` tablosu ile eşleşir ve veri modelini temsil eder.

Spring Boot: Katmanlı Mimariler
-------------------------------

**Katmanlı Mimari**: Projelerde kodun düzenlenmesini ve bakımını kolaylaştırmak için kullanılan bir yaklaşımdır. Spring Boot ile katmanlı mimarinin temel bileşenleri şunlardır:

- **Controller Katmanı**: REST API isteklerini işleyen ve HTTP yanıtlarını yöneten katmandır. `CityController.java` dosyası, API endpoint'lerini tanımlar ve istemciden gelen istekleri `Service` katmanına yönlendirir.
- **Service Katmanı**: İş mantığını ve uygulama lojiklerini içerir. `CityManager.java` dosyası, iş mantığını kapsar ve `ICityService.java` arayüzü üzerinden iş mantığı metodlarını tanımlar.
- **Data Access Katmanı**: Veritabanı işlemlerini gerçekleştiren katmandır. `HibernateCityDal.java` ve `ICityDal.java` dosyaları, veritabanı ile etkileşim kuran metodları içerir. Hibernate ve JPA kullanılarak veritabanı erişimi sağlanır.
- **Entity Katmanı**: Veritabanı tablolarını Java sınıfları olarak temsil eder. `City.java` sınıfı, `city` tablosunu temsil eden Hibernate entity'sidir ve veritabanı ile etkileşim için kullanılır.

**Yapılar ve Teknolojiler**:
- **Spring Boot**: Basit ve hızlı uygulama geliştirme için kullanılır. `Day6Application.java` sınıfı, uygulamanın başlangıç noktasını sağlar.
- **Hibernate ve JPA**: ORM (Object-Relational Mapping) araçları olarak kullanılır. Veritabanı işlemleri için `City` sınıfı ve `CityController.java` dosyaları örnek teşkil eder.
- **DevTools**: Geliştirme sürecinde otomatik yeniden başlatma ve hızlı güncellemeler sağlar. `pom.xml` dosyasında yapılandırılmıştır.

Bu yapılar, kodun modüler ve yeniden kullanılabilir olmasını sağlar. Proje dosyalarındaki örnekler, bu yapının nasıl uygulandığını gösterir.

Notlar
------

- **Maven Genel Kullanımı:**
  - `MavenDemo.rst` dosyası, Maven komutlarının ve genel kullanımının detaylarını içerir. Bu dosya, Maven ile ilgili sık kullanılan komutlar ve yapılandırmalar hakkında bilgi sağlar. Maven, projelerin bağımlılıklarını yönetmek ve yapılandırmak için kullanılır. 

  **Maven Komutları:**
  - `mvn clean`: Proje derleme çıktısını temizler.
  - `mvn compile`: Projeyi derler.
  - `mvn test`: Testleri çalıştırır.
  - `mvn package`: Projeyi bir jar dosyası olarak paketler.
  - `mvn spring-boot:run`: Spring Boot uygulamasını çalıştırır.
