==========================
JavaLearningPath: Day2
==========================

Bu proje, Java programlama dilinin çeşitli özelliklerini uygulamalı olarak gösterir. `day2` dizini, Java'nın temel ve ileri düzey konularını içeren örneklerle doludur. Aşağıda bu dizindeki konuların detaylı açıklamaları yer almaktadır.

Kurulum ve Çalıştırma
==========================

1. **Depoyu Klonlayın:**
   Projeyi GitHub üzerinden klonlayın:

   .. code-block:: bash

       git clone https://github.com/emrekndl/JavaLearningPath.git
       cd JavaLearningPath/day2

2. **Derleme:**
   Projeyi derlemek için önce bir `bin` dizini oluşturun ve kaynak kodları derleyin:

   .. code-block:: bash

       mkdir bin
       javac -d bin src/*.java

   Bu komut, `src/` klasöründeki tüm `.java` dosyalarını derler ve derlenmiş `.class` dosyalarını `bin` klasörüne yerleştirir.

3. **Çalıştırma:**
   Derlenen projeyi çalıştırmak için şu komutu kullanın:

   .. code-block:: bash

       java -cp bin Main

   Bu komut, `Main` sınıfındaki `main` metodunu çalıştırır.

Dizin Yapısı
==========================

Proje dizini şu şekilde organize edilmiştir:

.. code-block:: text

   day2/
   ├── src/
   │   ├── Main.java
   │   └── (Diğer kaynak dosyalar)
   └── bin/
       └── (Derlenmiş .class dosyaları)

Kapsamlı Konular
==========================

1. Statik Kullanım (Static)
-----------------------------
Statik metotlar ve alanlar, bir sınıfa ait olup sınıf düzeyinde erişilir. Statik metotlar sınıf adı ile çağrılır ve nesne oluşturulmadan erişilebilir. `Product` sınıfı ve `ProductManager` sınıfı örnekleri ile statik özelliklerin nasıl kullanıldığı ve uygulandığı gösterilmiştir.

Örnek: `ProductValidator.java`, `Product.java`, `ProductManager.java`.

2. Paketler (Packages)
-------------------------
Java'da paketler, ilgili sınıfları gruplayarak düzenlemeye yardımcı olur. Paketler, kod organizasyonunu sağlamak ve yeniden kullanılabilirliği artırmak için önemlidir. `BasicMath` paketi içinde `FourOperations` ve `Logarithm` sınıfları kullanılarak matematiksel işlemler gerçekleştirilmiştir.

Örnek: `BasicMath.FourOperations.java`, `BasicMath.Logarithm.java`.

3. Koleksiyonlar (Collections)
-------------------------------
Koleksiyon sınıfları, dinamik veri yapıları sağlar ve çeşitli veri türlerini saklama, ekleme, silme ve sıralama işlemleri sunar. `ArrayList` ve `HashMap` sınıfları kullanılarak veri saklama ve erişim işlemleri gerçekleştirilmiştir.

Örnek: `Main.java`. 

4. Hata Yönetimi (Exception Handling)
--------------------------------------
Hata yönetimi, try-catch blokları ile yapılır. Hataların yakalanması ve yönetilmesi için `ArrayIndexOutOfBoundsException`, `ArithmeticException` gibi istisnalar kullanılır. Ayrıca, `finally` bloğu hata oluşsa da veya oluşmasa da çalışacak kodu içerir.

Örnek: `Main.java`.

5. Dosya İşlemleri (File Operations)
--------------------------------------
Dosya işlemleri için `BufferedReader`, `FileReader`, `BufferedWriter`, ve `FileWriter` sınıfları kullanılır. Dosya okuma, yazma, bilgi alma ve kapama işlemleri örneklenmiştir. Ayrıca, `try-with-resources` yapısı ile dosyaların otomatik olarak kapatılması sağlanmıştır.

Örnek: `Main.java`.

6. Jenerikler (Generics)
---------------------------
Jenerikler, tür güvenliğini artırır ve tekrar kullanılabilir kod yazmayı sağlar. `MyList` sınıfı örneğinde, jenerik türlerin nasıl kullanıldığı ve sınıfın tür parametresi ile çalıştığı gösterilmiştir.

Örnek: `MyList.java`.

7. Repository Desen (Repository Design Pattern)
--------------------------------------------------
Repository deseni, veri erişim işlemleri için özel sınıflar kullanır. Bu desen, veri erişimini soyutlayarak kodun daha düzenli ve yönetilebilir olmasını sağlar. `CustomerDal` ve `ProductDal` sınıfları ile veri ekleme işlemleri gerçekleştirilmiştir.

Örnek: `CustomerDal.java`, `ProductDal.java`, `IEntityRepository.java`.

8. Jenerik Metotlar (Generic Methods)
---------------------------------------
Jenerik metotlar, tür güvenliğini artırır ve aynı metodu farklı türlerle çalışacak şekilde yazmayı sağlar. `Validator` sınıfında yer alan jenerik metotlar, farklı türlerdeki nesnelerin doğruluğunu kontrol etmek için kullanılmıştır.

Örnek: `Validator.java` (Jenerik metot kullanımı).

9. İş Parçacıkları (Threading)
-------------------------------
Java'da çoklu iş parçacıkları (`threads`) kullanılarak eşzamanlı işlemler yapılabilir. `ChronometerThread` sınıfı ile farklı iş parçacıklarının nasıl oluşturulduğu ve çalıştırıldığı gösterilmiştir.

Örnek: `ChronometerThread.java`.
