
==========================
JavaLearningPath: Day5
==========================

Bu proje, Hibernate ile MySQL veritabanı üzerinde CRUD işlemlerini ve Hibernate yapılandırmasını öğrenmek için oluşturulmuştur. Hibernate'in temel yapılandırmaları, veritabanı işlemleri ve ilişkisel veritabanı yönetimi üzerinde durulmuştur.

Dizin Yapısı
------------
.. code-block::

    day5/
    ├── bin
    │   ├── com
    │   │   └── hibernatedemo
    │   │       ├── City.class
    │   │       └── Main.class
    │   └── hibernate.cfg.xml
    ├── db-data
    │   └── mysql
    │       └── world.sql
    ├── lib
    │   ├── antlr4-4.9.1.jar
    │   ├── antlr4-runtime-4.9.1.jar
    │   ├── antlr-runtime-3.5.2.jar
    │   ├── byte-buddy-1.10.21.jar
    │   ├── classmate-1.5.1.jar
    │   ├── dom4j-2.1.3.jar
    │   ├── FastInfoset-1.2.15.jar
    │   ├── hibernate-commons-annotations-5.1.2.Final.jar
    │   ├── hibernate-core-6.0.0.Alpha7.jar
    │   ├── hibernate-entitymanager-6.0.0.Alpha7.jar
    │   ├── icu4j-61.1.jar
    │   ├── istack-commons-runtime-3.0.7.jar
    │   ├── jandex-2.2.3.Final.jar
    │   ├── javax.activation-api-1.2.0.jar
    │   ├── javax.json-1.0.4.jar
    │   ├── javax.persistence-api-2.2.jar
    │   ├── jaxb-api-2.3.1.jar
    │   ├── jaxb-runtime-2.3.1.jar
    │   ├── jboss-logging-3.4.1.Final.jar
    │   ├── jboss-transaction-api_1.2_spec-1.1.1.Final.jar
    │   ├── mysql-connector-j-9.0.0.jar
    │   ├── org.abego.treelayout.core-1.0.3.jar
    │   ├── ST4-4.3.jar
    │   ├── stax-ex-1.8.jar
    │   └── txw2-2.3.1.jar
    ├── README.rst
    ├── run-mysql.sh
    └── src
        ├── com
        │   └── hibernatedemo
        │       ├── City.java
        │       └── Main.java
        └── hibernate.cfg.xml

Konular
-------
Bu projede aşağıdaki konular işlenmiştir:


1. **Hibernate ile CRUD İşlemleri**
   - Hibernate kullanarak bir veritabanı üzerinde temel CRUD (Create, Read, Update, Delete) işlemleri nasıl yapılır.
   - Örnek dosyalar:
   - `src/com/hibernatedemo/City.java`
   - `src/com/hibernatedemo/Main.java`

2. **Hibernate Yapılandırması**
   - `hibernate.cfg.xml` dosyası ile Hibernate yapılandırması ve veritabanı bağlantı bilgileri nasıl ayarlanır.
   - Örnek dosya:
   - `src/hibernate.cfg.xml`

3. **HQL (Hibernate Query Language) ile Sorgular**
   - HQL kullanarak veritabanında sorgular nasıl yazılır ve çalıştırılır.
   - Örnek dosya:
   - `src/com/hibernatedemo/Main.java`

4. **Hibernate Entity Sınıfları**
   - Hibernate ile entity sınıfları nasıl oluşturulur ve veritabanı tablolarına bağlanılır.
   - Örnek dosya:
   - `src/com/hibernatedemo/City.java`

5. **Session Yönetimi ve Transaction'lar**
   - Hibernate Session API'si ile veritabanı işlemleri nasıl yönetilir ve transaction'lar nasıl kullanılır.
   - Örnek dosya:
   - `src/com/hibernatedemo/Main.java`

Kurulum ve Çalıştırma
---------------------
1. **Dizin İçeriğini Klonlayın:**
   Projeyi GitHub üzerinden klonlayarak aşağıdaki komutu kullanabilirsiniz:

   .. code-block:: bash

       git clone https://github.com/emrekndl/JavaLearningPath.git
       cd JavaLearningPath/day5

2. **Gerekli Bağımlılıkları İndirin:**
   `lib/` klasöründe bulunan Spring kütüphanelerini projenize ekleyin.


3. **Veritabanı Ayarları:**
    `run-mysql.sh` dosyasını çalıştırarak MySQL'de gerekli veritabanını oluşturun ve verileri yükleyin:

    .. code-block:: bash
	
	chmod +x run-mysql.sh
        ./run-mysql.sh

    Bu script, MySQL'de `world` isimli bir veritabanı oluşturacak ve `db-data/mysql/world.sql` dosyasını kullanarak gerekli verileri yükleyecektir.

4. **Veritabanı Kurulumu**:
   Veritabanını kurmak için `world.sql` dosyasını kullanarak MySQL container'ına bağlanmanız ve veritabanını oluşturmanız gerekmektedir:

   .. code-block:: bash

       podman exec -it mysql bash
       mysql -u root -p < /var/lib/mysql/world.sql

5. **Hibernate Yapılandırması:**
    `src/hibernate.cfg.xml` dosyasında veritabanı bağlantı bilgilerinizi güncelleyin:

    .. code-block:: xml

        <property name="hibernate.connection.url">jdbc:mysql://localhost:3307/world</property>
        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.connection.password">root</property>

6. **Projeyi Derleyin ve Çalıştırın:**
    .. code-block:: bash

        javac -d bin src/com/hibernatedemo/*.java
        java -cp "bin:lib/*" com.hibernatedemo.Main

Notlar
======

- Proje, Hibernate'i kullanarak MySQL veritabanında CRUD işlemleri gerçekleştirmeyi amaçlar.
- `City.java` sınıfı, Hibernate entity sınıfı olarak tanımlanmıştır ve `world` veritabanındaki `city` tablosuna karşılık gelir.
- `Main.java` dosyasında HQL sorguları ve Hibernate ile CRUD işlemleri yapılmaktadır.
