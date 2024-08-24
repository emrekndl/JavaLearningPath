========================
JavaLearningPath: Day3
========================

Bu proje, Java programlama dili kullanılarak MySQL veritabanı işlemlerini gerçekleştirmek amacıyla hazırlanmıştır. Proje, temel CRUD (Create, Read, Update, Delete) işlemlerini içerir ve veritabanına bağlanarak şehir ve ülke bilgilerini yönetmeyi sağlar.

Dizin Yapısı
------------
.. code-block::

    day3/
    ├── bin
    ├── config.properties
    ├── db-data
    │   ├── mysql
    │       └─ world.sql  
    ├── lib
    │   └── mysql-connector-j-9.0.0.jar
    ├── README.rst
    ├── run-mysql.sh
    └── src
        ├── Config.java
        ├── Country.java
        ├── DbHelper.java
        └── Main.java

Kurulum
-------

Projenin çalıştırılması için aşağıdaki adımları izleyin:

1. **Depoyu Klonlayın**:
   İlk olarak, projeyi yerel bilgisayarınıza klonlayın:

   .. code-block:: bash

      git clone https://github.com/emrekndl/JavaLearningPath.git
      cd JavaLearningPath/day3

2. **MySQL Container'ı Çalıştırın**:
   `run-mysql.sh` dosyasını çalıştırarak MySQL container'ını başlatın:

   .. code-block:: bash

      chmod +x run-mysql.sh
      ./run-mysql.sh

3. **Veritabanı Ayarları**:
   `config.properties` dosyası, MySQL veritabanı bağlantı ayarlarını içerir. Bu dosyada gerekli düzenlemeleri yaparak veritabanınıza bağlanabilirsiniz.

4. **Veritabanı Kurulumu**:
   Veritabanını kurmak için `world.sql` dosyasını kullanarak MySQL container'ına bağlanmanız ve veritabanını oluşturmanız gerekmektedir:

   .. code-block:: bash

       podman exec -it mysql bash
       mysql -u root -p < /var/lib/mysql/world.sql

5. **Proje Dosyalarını Derleyin**:
   Java dosyalarını derlemek için aşağıdaki komutu çalıştırın:

   .. code-block:: bash

      javac -d bin -cp lib/mysql-connector-j-9.0.0.jar src/*.java

6. **Proje Dosyalarını Çalıştırın**:
   Derlenmiş `Main` sınıfını çalıştırarak CRUD işlemlerini gerçekleştirin:

   .. code-block:: bash

      java -cp bin:lib/mysql-connector-j-9.0.0.jar Main


Kapsamlı Konular
-----------------
Java dosyalarınızı derledikten sonra `Main.java` dosyasını çalıştırarak CRUD işlemlerini gerçekleştirebilirsiniz.

- **`DbHelper` Sınıfı**: Veritabanı bağlantısı kurmak ve hataları yönetmek için kullanılır. `Config` sınıfı ile `config.properties` dosyasındaki veritabanı bilgileri alınarak bağlantı sağlanır. `getConnection()` metodu, `DriverManager` kullanarak veritabanına bağlanır ve bir bağlantı nesnesi döndürür. `showErrorMessage()` metodu ise olası SQL hatalarını ekranda gösterir.
- Örnek dosya:
  - `DbHelper.java`

Her bir CRUD işlemi için `Main.java` dosyasında farklı metotlar bulunmaktadır:

- **`selectDemo()`**: Bu metot, "country" tablosundan ülkeleri listeleyen bir SELECT sorgusu çalıştırır. Veritabanına `DbHelper` aracılığıyla bağlanır, ülkeleri `ArrayList` içine toplar ve her ülkenin adını ekrana yazdırır. Örnek dosya:
  - `Main.java -> selectDemo()`

- **`InsertDemo()`**: Bu metot, "city" tablosuna yeni bir şehir ekleyen bir INSERT sorgusu çalıştırır. Parametre olarak şehrin adı, ülke kodu, bölgesi ve nüfusu girilir. Başarılı bir ekleme işlemi olduğunda ekrana mesaj yazdırılır. Örnek dosya:
  - `Main.java -> InsertDemo()`

- **`updateDemo()`**: Bu metot, "city" tablosundaki mevcut bir şehir kaydını günceller. Örneğin, "New York Purge" isimli bir şehir oluşturulmuş ve bu şehrin nüfusu güncellenmiştir. Başarılı güncelleme işlemi ekrana bildirilir. Örnek dosya:
  - `Main.java -> updateDemo()`

- **`deleteDemo()`**: Bu metot, "city" tablosundan belirtilen ID'ye sahip bir şehri siler. Başarılı silme işlemi sonrası, işlemin tamamlandığı ekranda gösterilir. Örnek dosya:
  - `Main.java -> deleteDemo()`


Notlar
-------
- Bu projede, MySQL container'ının başlatılması için Podman kullanılmıştır. Docker kullananlar için benzer komutlar geçerli olacaktır.
- MySQL container'ı `run-mysql.sh` dosyası ile başlatılır ve veriler `db-data/mysql` dizininde saklanır, bu sayede container kapatılsa bile veriler kalıcı olur.
